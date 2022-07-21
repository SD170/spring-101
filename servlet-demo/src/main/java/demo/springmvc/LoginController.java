package demo.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.jee.UserValidationService;

@Controller // no need to extend HttpServlet
public class LoginController {
	@Autowired
	UserValidationService validationService;
	
	@RequestMapping(value = "/hello")	// actual path /spring-mvc/hello. /spring-mvc is the prefix the dispatcher servlet is using
	@ResponseBody	// states that, the return value is not path to a redirected method. It's a html response
	// without @ResponseBody the sayHello() method redirects to another view/jsp with name "hello world.jsp"
	public String sayHello() {
		return "hello world";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginControllerGET() {
		return "login-spmvc"; // searches for login.jsp and shows that. [as no response body]
		
		// now when we want to show login.jsp what I really want is /WEB-INF/views/login-spmvc.jsp
		// for this we need a view resolver.
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControllerPOST(@RequestParam String name, @RequestParam String pass, ModelMap model) {
		
		// ModelMap map is needed for data to be availible on the jsp page, using ${}.
		model.put("name", name); // just like setting attributes
		model.put("pass", pass);
		// under the hood these controller sends the request for appropiate jsp s along the modal map to the dispatcher servlet
		// then the dispatcher servlet provides the modal map to the appropriate jsp.
		
		
		
		// validating user
		boolean validUser = validationService.isValidUser(name, pass);
		
		if(validUser) {
			
			return "welcome";
		}else {
			// redirect to login again
			return "login-spmvc";
			
		}
				
	}
}
