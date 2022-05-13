package cnpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.model.ThongTinCaNhan;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;
import cnpm.service.UtilsService;

@Controller
@RequestMapping("/quanly/")
public class QuanLyController {
	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	UtilsService utilService;

//	============== Model - Attribute ==============
	@ModelAttribute("danhSachNhanVien")
	public List<NhanVien> getDSNhanVien() {
		List<NhanVien> list = nhanVienService.getDSNhanVien();
		return list;
	}

	@ModelAttribute("nhanVienMoi")
	public ThongTinCaNhan nhanVienMoi() {
		ThongTinCaNhan nhanVienMoi = new ThongTinCaNhan();
		return nhanVienMoi;
	}

	@RequestMapping(value = "tongquan", method = RequestMethod.GET)
	public String getViewTongQuan() {

		return "quantri/quanly/tongquan";
	}

	@RequestMapping(value = "nhanvien", method = RequestMethod.GET)
	public String getViewNhanVien(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien", params = "themMoiNV", method = RequestMethod.POST)
	public String themMoiNhanVien(ModelMap model, @ModelAttribute("nhanVienMoi") ThongTinCaNhan thongtin,
			@RequestParam("anh") MultipartFile anh, BindingResult errors) {
		if (thongtin.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "nhanVienMoi", "Họ không được để trống");
		}

		if (thongtin.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "nhanVienMoi", "Tên không được để trống");
		}

		if (thongtin.getEmail().trim().isEmpty() || !thongtin.getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("email", "nhanVienMoi", "Email không hợp lệ hoặc bị trống");
		}

		if (thongtin.getMatKhau().trim().isEmpty()) {
			errors.rejectValue("matKhau", "nhanVienMoi", "Mật khẩu không được để trống");
		}

		if (thongtin.getPhai() != true && thongtin.getPhai() != false) {
			errors.rejectValue("phai", "nhanVienMoi", "???");
		}

		if (thongtin.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "nhanVienMoi", "Ngày sinh không được để trống");
		}

		if (thongtin.getCccd().trim().isEmpty()) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không được để trống");
		} else if (!thongtin.getCccd().trim().matches("^[0-9]*$")) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không hợp lệ");
		}

		if (thongtin.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không được để trống");
		} else if (!thongtin.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (taiKhoanService.emailDaCo(thongtin.getEmail())) {
			errors.rejectValue("email", "nhanVienMoi", "Email đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (nhanVienService.getBySdt(thongtin.getSdt()) != null) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		String hinh = "";

		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
		}

		System.out.println("hinh " + hinh);
		model.addAttribute("isShowModalAddNew", true);
		model.addAttribute("hinh", hinh);

		TaiKhoan taiKhoan = taiKhoanService.setTK(thongtin.getEmail(), thongtin.getMatKhau());
		taiKhoanService.themNV(taiKhoan);

		NhanVien nhanvien = new NhanVien();
		nhanvien.setMaNV(nhanVienService.taoMaNVMoi());
		nhanvien.setHo(thongtin.getHo());
		nhanvien.setTen(thongtin.getTen());
		nhanvien.setPhai(thongtin.getPhai());
		nhanvien.setNgaySinh(thongtin.getNgaySinh());
		nhanvien.setCccd(thongtin.getCccd());
		nhanvien.setSdt(thongtin.getDiaChi());
		nhanvien.setDiaChi(thongtin.getDiaChi());
		nhanvien.setTaiKhoan(taiKhoan);
		nhanvien.setAnh(hinh);

		if (nhanVienService.themNV(nhanvien)) {
			model.addAttribute("nhanVienMoi", new ThongTinCaNhan());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Tạo tài khoản thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Tạo tài khoản thất bại");
		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1NhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			model.addAttribute("thongTinNV", nhanvien);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "tatHD", method = RequestMethod.GET)
	public String getTatHDNhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			model.addAttribute("maNV", maNV);
			model.addAttribute("isOpenModalDisabled", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien", params = "tatHD", method = RequestMethod.POST)
	public String postTatHDNhanVien(ModelMap model, @RequestParam("maNVTatHD") String maNV) {
		if (maNV.isEmpty()) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Tắt hoạt động của nhân viên " + maNV + " thất bại");
			return "quantri/quanly/nhanvien";
		}
		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			if (nhanvien.getTaiKhoan().getTrangThai()) {
				if (taiKhoanService.setTrangThaiTK(nhanvien.getTaiKhoan(), false)) {
					model.addAttribute("isSuccess", true);
					model.addAttribute("alertMessage", "Tắt hoạt động của nhân viên " + maNV + " thành công");
					List<NhanVien> list = nhanVienService.getDSNhanVien();
					model.addAttribute("danhSachNhanVien", list);
				}

			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Tắt hoạt động của nhân viên " + maNV + " thất bại");
			}

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "moHD", method = RequestMethod.GET)
	public String getMoHDNhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			model.addAttribute("maNV", maNV);
			model.addAttribute("isOpenModalEnable", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien", params = "moHD", method = RequestMethod.POST)
	public String postMoHDNhanVien(ModelMap model, @RequestParam("maNVMoHD") String maNV) {
		if (maNV.isEmpty()) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Mở hoạt động của nhân viên " + maNV + " thất bại");
			return "quantri/quanly/nhanvien";
		}
		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			if (!nhanvien.getTaiKhoan().getTrangThai()) {
				if (taiKhoanService.setTrangThaiTK(nhanvien.getTaiKhoan(), true)) {
					model.addAttribute("isSuccess", true);
					model.addAttribute("alertMessage", "Mở hoạt động của nhân viên " + maNV + " thành công");
					List<NhanVien> list = nhanVienService.getDSNhanVien();
					model.addAttribute("danhSachNhanVien", list);
				}

			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Mở hoạt động của nhân viên " + maNV + " thất bại");
			}

		}

		return "quantri/quanly/nhanvien";
	}

}
