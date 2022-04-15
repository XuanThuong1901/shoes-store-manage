package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String index(ModelMap model) {
		model.addAttribute("message", "ok");
		return "index";
	}
	
	@RequestMapping(value="/san-pham")
	public String getViewProduct() {
		
		return "user/product";
	}
}
