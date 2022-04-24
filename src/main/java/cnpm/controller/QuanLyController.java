package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quanly/")
public class QuanLyController {

	@RequestMapping(value="tongquan", method=RequestMethod.GET)
	public String getTongQuan() {
		
		return "quanly/tongquan";
	}
	
}
