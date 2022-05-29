package cnpm.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.KhachHangService;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;
import cnpm.service.UtilsService;


@Controller
@SessionAttributes("user")
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	UtilsService utilService;
	
	@ModelAttribute("thongTinNV")
	public NhanVien thongtinNv(ModelMap model) {

		return new NhanVien();
	}
	
	@RequestMapping(value="dangxuat")
	public String dangXuat(HttpSession ss) {
		if(ss.getAttribute("user") != null) {
			ss.removeAttribute("user");
		}
		return "redirect:/";
	}
	
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
					model.addAttribute("message", "Thông tin đăng nhập không hợp lệ");
					return "taikhoan/dangnhap";
				}
				ss.setAttribute("user", thongtinTk);

				return "redirect:/trangchu";
			} else if (thongtinTk.getVaitro().getMaVT().equals("NV")) {
				
				if(thongtinTk.getNhanVien() == null) {
					model.addAttribute("message", "Thông tin đăng nhập không hợp lệ");
					return "taikhoan/dangnhap";
				}
				
				ss.setAttribute("user", thongtinTk);

				return "redirect:/nhanvien/tongquan";
			} else if (thongtinTk.getVaitro().getMaVT().equals("QL")) {
				if(thongtinTk.getNhanVien() == null) {
					model.addAttribute("message", "Thông tin đăng nhập không hợp lệ");
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
	public String postDangKy(ModelMap model, @ModelAttribute("tkdangky") KhachHang khachHang, BindingResult errors,
			@RequestParam("email-register") String email, 
			@RequestParam("password-register") String matKhau, 
			@RequestParam("confirm-password-register") String xnMatKhau) {

		
		if(khachHang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "tkdangky", "Họ không được để trống");
		}
		
		if(khachHang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "tkdangky", "Tên không được để trống");
		}
		
		if(email == "") {
			model.addAttribute("email", "Email không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(matKhau == "") {
			model.addAttribute("password", "Mật khẩu không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(xnMatKhau == "") {
			model.addAttribute("confirmPassword", "Mật khẩu xác nhận không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(matKhau!="" && xnMatKhau!="" && !xnMatKhau.equals(matKhau)) {
			model.addAttribute("confirmPassword", "Mật khẩu và mật khẩu xác nhận không trùng nhau");
			return "taikhoan/dangky";
		}
		

		if(khachHang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "tkdangky", "Số điện thoại không được để trống");
		}
		
		if(khachHang.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "tkdangky", "Địa chỉ không được để trống");
		}
		if (errors.hasErrors()) {
			return "taikhoan/dangky";
		}
		
//		System.out.println("khahchang " + khachhang.getHo());
//		
//		System.out.println("email " + email);
		
		if(taiKhoanService.emailDaCo(email) ) {
			model.addAttribute("email", "Email đã được sử dụng");
			return "taikhoan/dangky";
		}
		
		if(khachHangService.getBySdt(khachHang.getSdt()) != null) {
			errors.rejectValue("sdt", "tkdangky", "Số điện thoại đã được sử dụng");
			return "taikhoan/dangky";
		}
		
		
			TaiKhoan taiKhoan = taiKhoanService.setTK(email, matKhau);			
			taiKhoanService.themKH(taiKhoan);
			
			khachHang.setMaKH(khachHangService.taoMaKHMoi());
			khachHang.setTaiKhoan(taiKhoan);
			if(khachHangService.themKH(khachHang)) {
				model.addAttribute("tkdangky", new KhachHang());
				model.addAttribute("message", "Tạo tài khoản thành công");
			}else {
				model.addAttribute("message", "Tạo tài khoản thất bại");
			}
			
		
		
		return "taikhoan/dangky";
	}
	
	@RequestMapping(value = "{tenVT}/tongquan/{maNV}", params = "chinhsua", method = RequestMethod.GET)
	public String getLoginUser ( @PathVariable("maNV") String maNV, @PathVariable("tenVT") String tenVT, HttpSession ss, ModelMap model) {
		
			NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
			model.addAttribute("thongTinNV", nhanvien);
//			model.addAttribute("isOpenModalEditUser", true);
			
		return "quantri/include/taikhoan";
	}
	
	@RequestMapping(value = "{tenVT}/tongquan/{maNV}", params = "chinhsua", method = RequestMethod.POST)
	public String postLoginUser(ModelMap model, @ModelAttribute("thongTinNV") NhanVien nhanvien,
			@PathVariable("tenVT") String tenVT, @RequestParam("anhMoi") MultipartFile anh, @PathVariable("maNV") String maNV, BindingResult errors) {

		if (nhanvien.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "thongTinNV", "Họ không được để trống");
		}

		if (nhanvien.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "thongTinNV", "Tên không được để trống");
		}

		if (nhanvien.getTaiKhoan().getEmail().trim().isEmpty() || !nhanvien.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không hợp lệ hoặc bị trống");
		}

		if (nhanvien.getPhai() != true && nhanvien.getPhai() != false) {
			errors.rejectValue("phai", "thongTinNV", "???");
		}

		if (nhanvien.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "thongTinNV", "Ngày sinh không được để trống");
		}

		if (nhanvien.getCccd().trim().isEmpty()) {
			errors.rejectValue("cccd", "thongTinNV", "Cccd không được để trống");
		} else if (!nhanvien.getCccd().trim().matches("^[0-9]*$")) {
			errors.rejectValue("cccd", "thongTinNV", "Cccd không hợp lệ");
		}

		if (nhanvien.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không được để trống");
		} else if (!nhanvien.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
//			model.addAttribute("isOpenModalEditUser", true);
			return "quantri/include/taikhoan";
		}

		NhanVien nhanviencu = nhanVienService.getByMaNV(maNV);
		if (nhanviencu != null) {
			if (!nhanviencu.getHo().equals(nhanvien.getHo()))
				nhanviencu.setHo(nhanvien.getHo());
			if (!nhanviencu.getTen().equals(nhanvien.getTen())) {
				nhanviencu.setTen(nhanvien.getTen());
			}
			if (!nhanviencu.getNgaySinh().equals(nhanvien.getNgaySinh())) {
				nhanviencu.setNgaySinh(nhanvien.getNgaySinh());
			}
			if (!nhanviencu.getCccd().equals(nhanvien.getCccd())) {
				nhanviencu.setCccd(nhanvien.getCccd());
			}
			if (!nhanviencu.getDiaChi().equals(nhanvien.getDiaChi())) {
				nhanviencu.setDiaChi(nhanvien.getDiaChi());
			}

			if (!nhanviencu.getSdt().equals(nhanvien.getSdt())) {
				if (nhanVienService.getBySdt(nhanvien.getSdt()) != null) {
					errors.rejectValue("sdt", "thongTinNV", "Số điện thoại đã được sử dụng");
//					model.addAttribute("isOpenModalEditUser", true);
					return "quantri/include/taikhoan";
				} else {
					nhanviencu.setSdt(nhanvien.getSdt());
				}
			}

			if (nhanviencu.getPhai() != nhanvien.getPhai()) {
				nhanviencu.setPhai(nhanvien.getPhai());
			}
			if (!nhanviencu.getTaiKhoan().getEmail().equals(nhanvien.getTaiKhoan().getEmail())) {
				if (taiKhoanService.emailDaCo(nhanvien.getTaiKhoan().getEmail())) {
					errors.rejectValue("taiKhoan.email", "thongTinNV", "Email đã được sử dụng");
//					model.addAttribute("isOpenModalEditUser", true);
					return "quantri/include/taikhoan";
				} else {
					nhanviencu.getTaiKhoan().setEmail(nhanvien.getTaiKhoan().getEmail());
				}

			}

			if (nhanviencu.getTaiKhoan().getTrangThai() != nhanvien.getTaiKhoan().getTrangThai()) {
				nhanviencu.getTaiKhoan().setTrangThai(nhanvien.getTaiKhoan().getTrangThai());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					nhanviencu.setAnh(hinh);
				}
			}

			if (nhanVienService.suaNV(nhanviencu)) {
				model.addAttribute("thongTinNV", new NhanVien());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa nhân viên thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa nhân viên thất bại");
		}

		return "quantri/include/taikhoan";
	}
	
	@RequestMapping(value = "{tenVT}/tongquan/{maNV}", params = "doimatkhau", method = RequestMethod.POST)
	public String resetMatKhau(ModelMap model, @ModelAttribute("thongTinNV") NhanVien nhanvien,
			@PathVariable("tenVT") String tenVT, @PathVariable("maNV") String maNV, 
			BindingResult errors, @RequestParam("confirm-password") String nlmk) {
	
		if (nhanvien.getTaiKhoan().getMatKhau().trim().isEmpty()) {
			errors.rejectValue("taiKhoan.matKhau", "thongTinNV", "Mật khẩu không được để trống");
		}
		if (errors.hasErrors()) {
//			model.addAttribute("isOpenModalEditUser", true);
			return "quantri/include/taikhoan";
		}
		if(nlmk == "") {
			model.addAttribute("confirmPassword", "Mật khẩu xác nhận không thể để trống");
			return "quantri/include/taikhoan";
		}
		
		if(nlmk!="" && nlmk!="" && !nlmk.equals(nhanvien.getTaiKhoan().getMatKhau())) {
			model.addAttribute("confirmPassword", "Mật khẩu và mật khẩu xác nhận không trùng nhau");
			return "quantri/include/taikhoan";
		}

		NhanVien nhanviencu = nhanVienService.getByMaNV(maNV);
		if (nhanviencu != null) {
			
			String hash = "2B95EBA6BA37DAB56CC03660404AA729";
			
			if (!nhanviencu.getTaiKhoan().getMatKhau().equals(nhanvien.getTaiKhoan().getMatKhau())) {
				nhanviencu.getTaiKhoan().setMatKhau(DigestUtils.md5Hex(nhanvien.getTaiKhoan().getMatKhau()).toUpperCase());
			}

			if (nhanVienService.suaNV(nhanviencu)) {
				model.addAttribute("thongTinNV", new NhanVien());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Đổi mật khẩu thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Đổi mật khẩu thất bại");
		}
		
		
		return "quantri/include/taikhoan";
	
	}

}

