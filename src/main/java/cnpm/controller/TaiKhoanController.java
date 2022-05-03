package cnpm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.TaiKhoan;
import cnpm.service.KhachHangService;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;

//	@Autowired
//	KhachHangService khachHangService;

	@Autowired
	NhanVienService nhanVienService;

	@RequestMapping(value = { "dang-nhap", "dangnhap" }, method = RequestMethod.GET)
	public String getDangNhap(ModelMap model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "taikhoan/dangnhap";
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	public String postDangNhap(ModelMap model, HttpSession ss, @ModelAttribute("taikhoan") TaiKhoan taikhoan) {

		if (taiKhoanService.kiemTraDangNhap(taikhoan.getEmail(), taikhoan.getMatKhau())) {
			TaiKhoan thongtinTk = taiKhoanService.getByEmail(taikhoan.getEmail());

			System.out.println("tk " + thongtinTk.getVaitro().getMaVT());

			if (thongtinTk.getVaitro().getMaVT().equals("KH")) {

			} else if (thongtinTk.getVaitro().getMaVT().equals("NV")) {

			} else if (thongtinTk.getVaitro().getMaVT().equals("QL")) {

			}

//			ss.setAttribute("user", );

			return "redirect:/quanly/tongquan";
		}
		model.addAttribute("message", "dang nhap that bai");

		return "taikhoan/dangnhap";
	}

}
