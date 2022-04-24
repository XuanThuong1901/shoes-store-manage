package cnpm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.TaiKhoan;
import cnpm.service.TaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;
	
	@RequestMapping(value = { "dang-nhap", "dangnhap" }, method = RequestMethod.GET)
	public String getDangNhap(ModelMap model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "taikhoan/dangnhap";
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	public String postDangNhap(ModelMap model, HttpSession ss, @ModelAttribute("taikhoan") TaiKhoan taikhoan) {
		
		if(taiKhoanService.kiemTraDangNhap(taikhoan.getEmail(), taikhoan.getMatKhau())) {
			
			return "redirect:/quanly/tongquan";
		}
		model.addAttribute("message","dang nhap that bai");
		
		return "taikhoan/dangnhap";
	}

}
