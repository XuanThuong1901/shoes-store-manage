package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nhanvien/")
public class NhanVienController {
	
	@RequestMapping("tongquan")
	public String getViewTongQuan(ModelMap model) {
		return "quantri/nhanvien/tongquan";
	}
}
