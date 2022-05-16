package cnpm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.KhachHangService;
import test.ttt;

@Controller

public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;
	
	@ModelAttribute("taikhoan")
	public KhachHang getKhdangnhap(HttpSession ss) {
		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		KhachHang khachhang  = tk.getKhachHang();
		
		return khachhang;
	}
	
	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap model) {
		
		return "shop/taikhoan";
	}
	
	@RequestMapping("thanhtoan")
	public String getViewThanhToan(ModelMap model) {
		
		return "shop/thanhtoan";
	}
	
	@RequestMapping("giohang")
	public String getViewGioHang(ModelMap model) {
		
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
