package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangChuController {
	
	@RequestMapping(value="/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value="/product")
	public String getViewProduct() {
		
		return "product/list";
	}
}
