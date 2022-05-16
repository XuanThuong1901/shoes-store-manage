package cnpm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.NhanVien;
import test.ttt;

@Controller

public class KhachHangController {
	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap mode) {
		
		return "shop/taikhoan";
	}
	
	@RequestMapping("thanhtoan")
	public String getViewThanhToan(ModelMap mode) {
		
		return "shop/thanhtoan";
	}
	
	@RequestMapping("giohang")
	public String getViewGioHang(ModelMap mode) {
		
		return "shop/giohang";
	}
	
	
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		
		model.addAttribute("test1", new ArrayList<ttt>());
		return "test";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.POST)
	public String postTest(ModelMap model, @ModelAttribute("test1") List<ttt> tt) {
		System.out.println(1);
		return "test";
	}
}
