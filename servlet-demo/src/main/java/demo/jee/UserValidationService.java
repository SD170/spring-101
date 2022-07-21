package demo.jee;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	public boolean isValidUser(String username, String password) {
		if(username.equals("sd") && password.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}
}
