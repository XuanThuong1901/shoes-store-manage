package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	@RequestMapping(value="dang-nhap", method=RequestMethod.GET)
	public String getViewLogin() {
		return "auth/login";
	}
}
