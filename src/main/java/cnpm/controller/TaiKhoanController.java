package cnpm.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.KhachHangService;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	NhanVienService nhanVienService;
	
	@RequestMapping(value = {"dangnhap" }, method = RequestMethod.GET)
	public String getDangNhap(ModelMap model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "taikhoan/dangnhap";
	}
	
	@RequestMapping(value = {"dangky" }, method = RequestMethod.GET)
	public String getDangKy(ModelMap model) {
		model.addAttribute("tkdangky", new KhachHang());
		return "taikhoan/dangky";
	}

	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	public String postDangNhap(ModelMap model, HttpSession ss, @ModelAttribute("taikhoan") TaiKhoan taikhoan,BindingResult errors) {

		if (taikhoan.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "taikhoan", "Email không được để trống");
		}

		if (taikhoan.getMatKhau().trim().isEmpty()) {
			errors.rejectValue("matKhau", "taikhoan", "Mật khẩu không được để trống");
		}
		if (errors.hasErrors()) {
			return "taikhoan/dangnhap";
		}
		
		
		if (taiKhoanService.kiemTraDangNhap(taikhoan.getEmail(), taikhoan.getMatKhau())) {
			TaiKhoan thongtinTk = taiKhoanService.getByEmail(taikhoan.getEmail());
			
			if(!thongtinTk.getTrangThai()) {
				model.addAttribute("message", "Tài khoản chưa được kích hoạt hoặc đã bị khóa, vui lòng liên hệ với bộ phận hỗ trợ của chúng tôi!");
				return "taikhoan/dangnhap";
			}

			if (thongtinTk.getVaitro().getMaVT().equals("KH")) {
				if(thongtinTk.getKhachHang() == null) {
					return "taikhoan/dangnhap";
				}
				ss.setAttribute("user", thongtinTk);
				return "redirect:/trangchu";
			} else if (thongtinTk.getVaitro().getMaVT().equals("NV")) {
				
				if(thongtinTk.getNhanVien() == null) {
					return "taikhoan/dangnhap";
				}
				
				ss.setAttribute("user", thongtinTk);
				
				return "redirect:/nhanvien/tongquan";
			} else if (thongtinTk.getVaitro().getMaVT().equals("QL")) {
				if(thongtinTk.getNhanVien() == null) {
					return "taikhoan/dangnhap";
				}
				ss.setAttribute("user", thongtinTk);
				return "redirect:/quanly/tongquan";
			}


			return "redirect:/quanly/tongquan";
		}
		model.addAttribute("message", "Sai thông tin tài khoản hoặc mật khẩu");

		return "taikhoan/dangnhap";
	}
	
	@RequestMapping(value="dangky", method=RequestMethod.POST)
	public String postDangKy(ModelMap model, @ModelAttribute("tkdangky") KhachHang khachhang,
			@RequestParam("email-register") String email, 
			@RequestParam("password-register") String matKhau, 
			@RequestParam("confirm-password-register") String xnMatKhau ){
		
		System.out.println("khahchang " + khachhang.getHo());
		
		System.out.println("email " + email);
		
		// tao ma kh, tao ma tk
		
		// tao tk hash pw, setrangthai true, setvaitro, -> tai khoan
		
		// luu tai khoan
		
		// set matk -> matk da tao, luu khachhang, 
		
		return "taikhoan/dangky";
	}

}
