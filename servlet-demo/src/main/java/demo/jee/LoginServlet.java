package demo.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// to fix the url for the request for the class. 
// The class also holds methods for different request types

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	// service to check some hardcoded password
	UserValidationService validationService = new UserValidationService();
	

	// the method name should be doGet(). See HttpServlet for more details.
	// doPost, doHead, doPut etc.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		/**
		 * rather than rendering html like this we'll use a JSP (JAVA Server Pages)
		 * servlets are not the best place to write HTML. We do that in a JSP and then
		 * it boils down to a servlet response, by java.
		 * 
		 * PrintWriter out = response.getWriter(); // to write on the response object we use the getWriter()
		 * out.println("<html>"); 
		 * out.println("<head>");
		 * out.println("<title>CR7!</title>"); 
		 * out.println("</head>");
		 * out.println("<body>"); 
		 * out.println("hello world"); 
		 * out.println("</body>");
		 * out.println("</html>");
		 * 
		 * jsp location: /src/main/demo.jee/WEB-INF/views
		 */
		
		// accessing a query-parameter: /login.do?name=cr7
		String name = request.getParameter("name");
		// passing this parameter from the servlet to jsp
		request.setAttribute("attrName", name); // now we can use the "attrName" in jsp with expression language: ${attrName}
		
		// rendering a jsp, basically redirecting the request from this servlet
		// to the JSP
		// the param to getRequestDispatcher() is the location from /demo.jee
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// getting field values from the form
		String name = request.getParameter("inp-name"); // getParameter() same as GET
		String pass = request.getParameter("inp-pass");

		// validating user
		boolean validUser = validationService.isValidUser(name, pass);
		
		if(validUser) {
			request.setAttribute("name", name);	// setting as attribute to view in jsp
			request.setAttribute("pass", pass);
			// after login redirect to welcome.jsp
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);			
		}else {
			// redirect to login again
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);			
			
		}
		
		

	}

}