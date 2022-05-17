package cnpm.controller;

import java.util.ArrayList;
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

import cnpm.entity.*;

import cnpm.service.*;

@Controller
@RequestMapping("/quanly/")
public class QuanLyController {
	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	@Autowired
	NhaCungCapService nhaCungCapService;

	@Autowired
	PhieuNhapService phieuNhapService;

	@Autowired
	ChiTietSanPhamService chiTietSanPhamService;

	@Autowired
	ChiTietDonHangService chiTietDonHangService;

	@Autowired
	SizeService sizeService;

	@Autowired
	MauService mauService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DonHangService donHangService;

	@Autowired
	UtilsService utilService;

//	============== Model - Attribute ==============
	@ModelAttribute("thongTinCaNhan")
	public NhanVien thongTinCaNhan() {
		return new NhanVien();
	}

	@ModelAttribute("danhSachDonHang")
	public List<DonHang> getDSDH() {
		return donHangService.getDSDonHang();
	}

	@ModelAttribute("danhSachNhaCungCap")
	public List<NhaCungCap> getDSNCC() {
		return nhaCungCapService.getDSNhaCungCap();
	}

	@ModelAttribute("danhSachMau")
	public List<MauSanPham> getDSMau() {
		List<MauSanPham> list = mauService.getDSMau();
		return list;
	}

	@ModelAttribute("danhSachSize")
	public List<SizeSanPham> getDSSize() {
		List<SizeSanPham> list = sizeService.getDSSize();
		return list;
	}

	@ModelAttribute("danhSachSanPham")
	public List<SanPham> getDSSanPham() {
		List<SanPham> list = sanPhamService.getDSSanPham();
		return list;
	}

	@ModelAttribute("danhSachNhanVien")
	public List<NhanVien> getDSNhanVien() {
		List<NhanVien> list = nhanVienService.getDSNhanVien();
		return list;
	}

	@ModelAttribute("danhSachKhachHang")
	public List<KhachHang> getDSKhachHang() {
		List<KhachHang> list = khachHangService.getDSKhachHang();
		return list;
	}

	@ModelAttribute("danhSachPhieuNhap")
	public List<PhieuNhap> getDSPhieuNhap() {
		List<PhieuNhap> list = phieuNhapService.getDSPhieuNhap();
		return list;
	}

	@ModelAttribute("danhSachNhaCungCap")
	public List<NhaCungCap> getDSNhaCungCap() {
		List<NhaCungCap> list = nhaCungCapService.getDSNhaCungCap();
		return list;
	}

	@ModelAttribute("thongTinDH")
	public DonHang thongTinDH() {
		return new DonHang();
	}

	@ModelAttribute("CTSP")
	public ChiTietSanPham ctSPMoi() {
		return new ChiTietSanPham();
	}

	@ModelAttribute("CTPhieuNhapMoi")
	public ChiTietPhieuNhap ctPhieuNhapMoi() {
		return new ChiTietPhieuNhap();
	}

	@ModelAttribute("phieuNhapMoi")
	public PhieuNhap phieuNhapMoi(ModelMap model) {
		return new PhieuNhap();
	}

	@ModelAttribute("thongTinPN")
	public PhieuNhap thongtinPN(ModelMap model) {
		return new PhieuNhap();
	}

	@ModelAttribute("nhanVienMoi")
	public NhanVien thongTinNV() {
		NhanVien thongTinNV = new NhanVien();
		return thongTinNV;
	}

	@ModelAttribute("thongTinNV")
	public NhanVien thongtinNv(ModelMap model) {

		return new NhanVien();
	}

	@ModelAttribute("khachHangMoi")
	public KhachHang thongTinKH() {
		KhachHang thongTinKH = new KhachHang();
		return thongTinKH;
	}

	@ModelAttribute("thongTinKH")
	public KhachHang thongtinKh(ModelMap model) {

		return new KhachHang();
	}

	// danh muc

	@ModelAttribute("danhSachDanhMucSanPham")
	public List<DanhMucSanPham> dsDanhMucSanPham() {
		List<DanhMucSanPham> list = danhMucSanPhamService.getDSDanhMuc();
		return list;
	}

	@ModelAttribute("danhMucMoi")
	public DanhMucSanPham thongtinDM() {
		DanhMucSanPham thongTinDM = new DanhMucSanPham();
		return thongTinDM;
	}

	@ModelAttribute("thongTinDM")
	public DanhMucSanPham thongtinDm(ModelMap model) {

		return new DanhMucSanPham();
	}

	// nha cung cap

	@ModelAttribute("danhSachNhaCungCap")
	public List<NhaCungCap> dsNhaCungCap() {
		List<NhaCungCap> list = nhaCungCapService.getDSNhaCungCap();
		return list;
	}

	@ModelAttribute("nhaCungCapMoi")
	public NhaCungCap thongtinNCC() {
		NhaCungCap thongTinNCC = new NhaCungCap();
		return thongTinNCC;
	}

	@ModelAttribute("thongTinNCC")
	public NhaCungCap thongtinNcc(ModelMap model) {

		return new NhaCungCap();
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

	@RequestMapping(value = "danhmucsp", method = RequestMethod.GET)
	public String getViewDanhMuc(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "nhacungcap", method = RequestMethod.GET)
	public String getViewNhaCungCap(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhanvien", params = "themNV", method = RequestMethod.POST)
	public String themMoiNhanVien(ModelMap model, @ModelAttribute("nhanVienMoi") NhanVien nhanvien,
			@RequestParam("anhMoi") MultipartFile anh, BindingResult errors) {
		if (nhanvien.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "nhanVienMoi", "Họ không được để trống");
		}

		if (nhanvien.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "nhanVienMoi", "Tên không được để trống");
		}

		if (nhanvien.getTaiKhoan().getEmail().trim().isEmpty() || !nhanvien.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "nhanVienMoi", "Email không hợp lệ hoặc bị trống");
		}

		if (nhanvien.getTaiKhoan().getMatKhau().trim().isEmpty()) {
			errors.rejectValue("taiKhoan.matKhau", "nhanVienMoi", "Mật khẩu không được để trống");
		}

		if (nhanvien.getPhai() != true && nhanvien.getPhai() != false) {
			errors.rejectValue("phai", "nhanVienMoi", "???");
		}

		if (nhanvien.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "nhanVienMoi", "Ngày sinh không được để trống");
		}

		if (nhanvien.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "nhanVienMoi", "Địa chỉ không được để trống");
		}

		if (nhanvien.getCccd().trim().isEmpty()) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không được để trống");
		} else if (!nhanvien.getCccd().trim().matches("^[0-9]*$")) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không hợp lệ");
		}

		if (nhanvien.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không được để trống");
		} else if (!nhanvien.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (taiKhoanService.emailDaCo(nhanvien.getTaiKhoan().getEmail())) {
			errors.rejectValue("email", "nhanVienMoi", "Email đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (nhanVienService.getBySdt(nhanvien.getSdt()) != null) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		String hinh = "";

		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
			if (!hinh.isEmpty()) {
				nhanvien.setAnh(hinh);
			}
		}

		TaiKhoan taiKhoan = taiKhoanService.setTK(nhanvien.getTaiKhoan().getEmail(),
				nhanvien.getTaiKhoan().getMatKhau());
		taiKhoanService.themNV(taiKhoan);

		nhanvien.setMaNV(nhanVienService.taoMaNVMoi());
		nhanvien.setTaiKhoan(taiKhoan);

		if (nhanVienService.themNV(nhanvien)) {
//			model.addAttribute("thongTinNV", new ThongTinCaNhan());
			model.addAttribute("nhanVienMoi", new NhanVien());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm tài khoản thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
		} else {
			taiKhoanService.xoaTK(taiKhoan);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm tài khoản thất bại");
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

	@RequestMapping(value = "nhanvien/{maNV}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaNhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);

		if (nhanvien != null) {
			model.addAttribute("thongTinNV", nhanvien);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "suaNV", method = RequestMethod.POST)
	public String postSuaNhanVien(ModelMap model, @ModelAttribute("thongTinNV") NhanVien nhanvien,
			@RequestParam("anhMoi") MultipartFile anh, @PathVariable("maNV") String maNV, BindingResult errors) {

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
			model.addAttribute("isOpenModalEdit", true);
			return "quantri/quanly/nhanvien";
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
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
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
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
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

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "resetmatkhau", method = RequestMethod.POST)
	public String resetMatKhau(ModelMap model, @PathVariable("maNV") String maNV) {
		if (maNV.trim().isEmpty()) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Reset mật khẩu thất bại");
		} else {
			NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
			if (nhanvien != null) {
				taiKhoanService.resetMK(nhanvien.getTaiKhoan());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Reset mật khẩu thành công");
			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Reset mật khẩu thất bại");
			}
		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "khachhang", method = RequestMethod.GET)
	public String getViewKhachHang(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/khachhang";
	}

	/// Khách hàng

	@RequestMapping(value = "khachhang", params = "themKH", method = RequestMethod.POST)
	public String themMoiNhanVien(ModelMap model, @ModelAttribute("khachHangMoi") KhachHang khachhang,
			@RequestParam("anhMoi") MultipartFile anh, BindingResult errors) {
		if (khachhang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "khachHangMoi", "Họ không được để trống");
		}

		if (khachhang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "khachHangMoi", "Tên không được để trống");
		}

		if (khachhang.getTaiKhoan().getEmail().trim().isEmpty() || !khachhang.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "khachHangMoi", "Email không hợp lệ hoặc bị trống");
		}

		if (khachhang.getTaiKhoan().getMatKhau().trim().isEmpty()) {
			errors.rejectValue("taiKhoan.matKhau", "khachHangMoi", "Mật khẩu không được để trống");
		}

		if (khachhang.getPhai() != true && khachhang.getPhai() != false) {
			errors.rejectValue("phai", "khachHangMoi", "???");
		}

		if (khachhang.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "khachHangMoi", "Ngày sinh không được để trống");
		}

		if (khachhang.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "khachHangMoi", "Địa chỉ không được để trống");
		}

		if (khachhang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại không được để trống");
		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		if (taiKhoanService.emailDaCo(khachhang.getTaiKhoan().getEmail())) {
			errors.rejectValue("email", "khachHangMoi", "Email đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		if (nhanVienService.getBySdt(khachhang.getSdt()) != null) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		String hinh = "";
		System.out.println("anh " + anh);
		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
			if (!hinh.isEmpty()) {
				khachhang.setAnh(hinh);
			}
		}

		TaiKhoan taiKhoan = taiKhoanService.setTK(khachhang.getTaiKhoan().getEmail(),
				khachhang.getTaiKhoan().getMatKhau());
		taiKhoanService.themKH(taiKhoan);

		khachhang.setMaKH(khachHangService.taoMaKHMoi());
		khachhang.setTaiKhoan(taiKhoan);

		if (khachHangService.themKH(khachhang)) {
//			model.addAttribute("thongTinNV", new ThongTinCaNhan());
			model.addAttribute("khachHangMoi", new KhachHang());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm tài khoản thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachKhachHang", khachHangService.getDSKhachHang());
		} else {
			taiKhoanService.xoaTK(taiKhoan);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm tài khoản thất bại");
		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1KhachHang(ModelMap model, @PathVariable("maKH") String maKH) {

		KhachHang khachhang = khachHangService.getByMaKH(maKH);
		if (khachhang != null) {
			model.addAttribute("thongTinKH", khachhang);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaKhachHang(ModelMap model, @PathVariable("maKH") String maKH) {

		KhachHang khachhang = khachHangService.getByMaKH(maKH);

		if (khachhang != null) {
			model.addAttribute("thongTinKH", khachhang);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "suaKH", method = RequestMethod.POST)
	public String postSuaKhachHang(ModelMap model, @ModelAttribute("thongTinKH") KhachHang khachhang,
			@RequestParam("anhMoi") MultipartFile anh, @PathVariable("maKH") String maKH, BindingResult errors) {

		if (khachhang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "thongTinNV", "Họ không được để trống");
		}

		if (khachhang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "thongTinNV", "Tên không được để trống");
		}

		if (khachhang.getTaiKhoan().getEmail().trim().isEmpty() || !khachhang.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không hợp lệ hoặc bị trống");
		}

		if (khachhang.getPhai() != true && khachhang.getPhai() != false) {
			errors.rejectValue("phai", "thongTinNV", "???");
		}

		if (khachhang.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "thongTinNV", "Ngày sinh không được để trống");
		}

		if (khachhang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không được để trống");
		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			return "quantri/quanly/nhanvien";
		}

		KhachHang khachhangcu = khachHangService.getByMaKH(maKH);
		if (khachhangcu != null) {
			if (!khachhangcu.getHo().equals(khachhang.getHo()))
				khachhangcu.setHo(khachhang.getHo());
			if (!khachhangcu.getTen().equals(khachhang.getTen())) {
				khachhangcu.setTen(khachhang.getTen());
			}
			if (!khachhangcu.getNgaySinh().equals(khachhang.getNgaySinh())) {
				khachhangcu.setNgaySinh(khachhang.getNgaySinh());
			}
			if (!khachhangcu.getDiaChi().equals(khachhang.getDiaChi())) {
				khachhangcu.setDiaChi(khachhang.getDiaChi());
			}

			if (!khachhangcu.getSdt().equals(khachhang.getSdt())) {
				if (nhanVienService.getBySdt(khachhang.getSdt()) != null) {
					errors.rejectValue("sdt", "thongTinNV", "Số điện thoại đã được sử dụng");
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
				} else {
					khachhangcu.setSdt(khachhang.getSdt());
				}
			}

			if (khachhangcu.getPhai() != khachhang.getPhai()) {
				khachhangcu.setPhai(khachhang.getPhai());
			}
			if (!khachhangcu.getTaiKhoan().getEmail().equals(khachhang.getTaiKhoan().getEmail())) {
				if (taiKhoanService.emailDaCo(khachhang.getTaiKhoan().getEmail())) {
					errors.rejectValue("taiKhoan.email", "thongTinNV", "Email đã được sử dụng");
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
				} else {
					khachhangcu.getTaiKhoan().setEmail(khachhang.getTaiKhoan().getEmail());
				}

			}

			if (khachhangcu.getTaiKhoan().getTrangThai() != khachhang.getTaiKhoan().getTrangThai()) {
				khachhangcu.getTaiKhoan().setTrangThai(khachhang.getTaiKhoan().getTrangThai());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					khachhangcu.setAnh(hinh);
				}
			}

			if (khachHangService.suaKH(khachhangcu)) {
				model.addAttribute("thongTinKH", new KhachHang());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa khách hàng thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachKhachHang", khachHangService.getDSKhachHang());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa khachhang thất bại");
		}

		return "quantri/quanly/khachhang";
	}

	/// Danh mục

	@RequestMapping(value = "danhmucsp", params = "themDM", method = RequestMethod.POST)
	public String themMoiDanhMuc(ModelMap model, @ModelAttribute("danhMucMoi") DanhMucSanPham danhmucsp,
			BindingResult errors) {
		if (danhmucsp.getTenDM().trim().isEmpty()) {
			errors.rejectValue("tenDM", "danhMucMoi", "Tên danh mục không được trống");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/danhmucsp";
		}

		if (danhMucSanPhamService.themDM(danhmucsp)) {

			model.addAttribute("danhmucMoi", new DanhMucSanPham());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());
		} else {
			model.addAttribute("alertMessage", "Thêm danh mục thất bại");
		}

		return "quantri/quanly/danhmucsp";
	}

	// Sửa thông tin Danh mục

	@RequestMapping(value = "danhmucsp/{maDM}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1DanhMuc(ModelMap model, @PathVariable("maDM") Integer maDM) {

		DanhMucSanPham danhmuc = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmuc != null) {
			model.addAttribute("thongTinDM", danhmuc);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp/{maDM}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaDanhMuc(ModelMap model, @PathVariable("maDM") Integer maDM) {

		DanhMucSanPham danhMucsp = danhMucSanPhamService.getByMaDM(maDM);

		if (danhMucsp != null) {
			model.addAttribute("thongTinDM", danhMucsp);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp/{maDM}", params = "suaThongtin", method = RequestMethod.POST)
	public String postSuaDanhMuc(ModelMap model, @ModelAttribute("thongTinDM") DanhMucSanPham danhmucsp,
			@PathVariable("maDM") Integer maDM, BindingResult errors) {

		if (danhmucsp.getTenDM().trim().isEmpty()) {
			errors.rejectValue("tenDM", "thongTinDM", "Tên danh mục không được trống");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/danhmucsp";
		}

		DanhMucSanPham danhmuccu = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmuccu != null) {
			System.out.println(1);
			if (!danhmuccu.getTenDM().equals(danhmucsp.getTenDM()))
				danhmuccu.setTenDM(danhmucsp.getTenDM());
		}
		if (danhMucSanPhamService.suaDM(danhmuccu)) {
			model.addAttribute("thongTinDM", new DanhMucSanPham());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Sửa danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa danh mục thất bại");
			System.out.println(3);
		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp", params = "xoadm", method = RequestMethod.POST)
	public String postXoaDanhMuc(ModelMap model, @RequestParam("maDM") Integer maDM) {

		// System.out.println(danhmucsp.getMaDM());
		DanhMucSanPham danhmucsp = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmucsp == null) {
			if (danhmucsp.getSanPhams() != null) {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Xóa danh mục thất bại");
			}
		}
		if (danhmucsp.getSanPhams().size() == 0) {
			danhMucSanPhamService.xoaDM(danhmucsp);
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Xóa danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());

		}
		if (danhmucsp.getSanPhams().size() > 0) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Xóa danh mục thất bại");
		}

		return "quantri/quanly/danhmucsp";
	}

	// ------ Nhà cung cấp

	@RequestMapping(value = "nhacungcap", params = "themNCC", method = RequestMethod.POST)
	public String themMoiNhaCungCap(ModelMap model, @ModelAttribute("nhaCungCapMoi") NhaCungCap nhacungcap,
			BindingResult errors) {

		if (nhacungcap.getTenNCC().trim().isEmpty()) {
			errors.rejectValue("tenNCC", "thongTinNCC", "Tên danh mục không được trống");
		}

		if (nhacungcap.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNCC", "Số điện thoại không được trống");
		} else if (!nhacungcap.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không hợp lệ");
		}

		if (nhacungcap.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "thongTinNCC", "Địa chỉ không được trống");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhacungcap";
		}

		if (nhaCungCapService.themNCC(nhacungcap)) {

			model.addAttribute("nhaCungCapMoi", new NhaCungCap());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm nhà cung cấp thành công");
			model.addAttribute("danhSachNhaCungCap", nhaCungCapService.getDSNhaCungCap());
		} else {
			model.addAttribute("alertMessage", "Thêm danh mục thất bại");
		}

		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhacungcap/{maNCC}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1NhaCungCap(ModelMap model, @PathVariable("maNCC") Integer maNCC) {

		NhaCungCap nhacungcap = nhaCungCapService.getByMaNCC(maNCC);
		if (nhacungcap != null) {
			model.addAttribute("thongTinNCC", nhacungcap);
			model.addAttribute("isOpenModalInfo", true);

		}
		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhacungcap/{maNCC}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaNhaCungCap(ModelMap model, @PathVariable("maNCC") Integer maNCC) {

		NhaCungCap nhacungcap = nhaCungCapService.getByMaNCC(maNCC);

		if (nhacungcap != null) {
			model.addAttribute("thongTinNCC", nhacungcap);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhacungcap/{maNCC}", params = "suaThongtin", method = RequestMethod.POST)
	public String postSuaNhaCungCap(ModelMap model, @ModelAttribute("thongTinNCC") NhaCungCap nhacungcap,
			@PathVariable("maNCC") Integer maNCC, BindingResult errors) {

		if (nhacungcap.getTenNCC().trim().isEmpty()) {
			errors.rejectValue("tenNCC", "thongTinNCC", "Tên danh mục không được trống");
		}
		if (nhacungcap.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNCC", "Số điện thoại không được trống");
		}
		if (nhacungcap.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "thongTinNCC", "Địa chỉ không được trống");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhacungcap";
		}

		NhaCungCap nhacungcapcu = nhaCungCapService.getByMaNCC(maNCC);
		if (nhacungcapcu != null) {

			if (!nhacungcapcu.getTenNCC().equals(nhacungcap.getTenNCC()))
				nhacungcapcu.setTenNCC(nhacungcap.getTenNCC());

			if (!nhacungcapcu.getSdt().equals(nhacungcap.getSdt()))
				nhacungcapcu.setSdt(nhacungcap.getSdt());

			if (!nhacungcapcu.getDiaChi().equals(nhacungcap.getDiaChi()))
				nhacungcapcu.setDiaChi(nhacungcap.getDiaChi());
		}
		if (nhaCungCapService.suaNCC(nhacungcapcu)) {
			model.addAttribute("thongTinDM", new NhaCungCap());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Sửa nhà cung cấp thành công");
			model.addAttribute("danhSachNhaCungCap", nhaCungCapService.getDSNhaCungCap());
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa nhà cung cấp thất bại");
		}

		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhacungcap", params = "xoancc", method = RequestMethod.POST)
	public String postXoaNhaCungCap(ModelMap model, @RequestParam("maNCC") Integer maNCC) {

		System.out.println(maNCC);
		NhaCungCap nhacungcap = nhaCungCapService.getByMaNCC(maNCC);
		if (nhacungcap == null) {
			System.out.println(1);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Xóa nhà cung cấp thất bại");
		}
		if (nhacungcap.getPhieuNhap().size() == 0) {
			System.out.println(2);
			nhaCungCapService.xoaNCC(nhacungcap);
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Xóa nhà cung cấp thành công");
			model.addAttribute("danhSachNhaCungCap", nhaCungCapService.getDSNhaCungCap());

		}
		if (nhacungcap.getPhieuNhap().size() > 0) {
			System.out.println(3);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Xóa nhà cung cấp thất bại");
		}

		return "quantri/quanly/nhacungcap";
	}

	//// Lỗi không biết sữa

	@RequestMapping(value = "phieunhap", method = RequestMethod.GET)
	public String getViewPhieuNhap(ModelMap model) {

		return "quantri/quanly/phieunhap";
	}

	@RequestMapping(value = "phieunhap/{maPN}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1PhieuNhap(ModelMap model, @PathVariable("maPN") Integer maPN) {

		PhieuNhap phieunhap = phieuNhapService.getByMaPN(maPN);
		if (phieunhap != null) {
			model.addAttribute("thongTinPN", phieunhap);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "phieunhap", params = "themPN", method = RequestMethod.POST)
	public String themMoiPhieuNhap(ModelMap model, @ModelAttribute("phieuNhapMoi") PhieuNhap phieunhap,
			BindingResult errors) {

		if (phieunhap.getThoiGian() == null) {
			errors.rejectValue("thoiGian", "phieuNhapMoi", "Ngày nhập không được để trống");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAddNew", true);
			return "quantri/quanly/phieunhap";
		}

		phieunhap.setTongTien(0.0);
		if (phieuNhapService.them(phieunhap)) {
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm phiếu nhập thành công");
			model.addAttribute("danhSachPhieuNhap", phieuNhapService.getDSPhieuNhap());
		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm phiếu nhập thất bại");
		}

		return "quantri/quanly/phieunhap";
	}

	@RequestMapping(value = "phieunhap/{maPN}", params = "suaphieunhap", method = RequestMethod.GET)
	public String getSuaPhieuNhap(ModelMap model, @PathVariable("maPN") Integer maPN) {

		PhieuNhap phieunhap = phieuNhapService.getByMaPN(maPN);
		if (phieunhap != null) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("thongTinPN", phieunhap);
		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Đã có lỗi xảy ra");
		}

		return "quantri/quanly/phieunhap";
	}

	@RequestMapping(value = "phieunhap/{maPN}", params = "suaPN", method = RequestMethod.POST)
	public String postSuaPhieuNhap(ModelMap model, @PathVariable("maPN") Integer maPN,
			@ModelAttribute("thongTinPN") PhieuNhap phieunhap, BindingResult errors) {

		if (phieunhap.getThoiGian() == null) {
			errors.rejectValue("thoiGian", "thongTinPN", "Ngày nhập không được để trống");
		}

		PhieuNhap phieunhapcu = phieuNhapService.getByMaPN(maPN);
		if (phieunhapcu != null) {
			if (phieunhapcu.getMaPN() != phieunhap.getNhaCungCap().getMaNCC()) {
				phieunhapcu.setNhaCungCap(nhaCungCapService.getByMaNCC(phieunhap.getNhaCungCap().getMaNCC()));
			}

			if (!phieunhapcu.getThoiGian().equals(phieunhap.getThoiGian())) {
				phieunhapcu.setThoiGian(phieunhap.getThoiGian());
			}

			if (phieuNhapService.sua(phieunhapcu)) {
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa phiếu nhập thành công");
				model.addAttribute("danhSachPhieuNhap", phieuNhapService.getDSPhieuNhap());
			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Sửa phiếu nhập thất bại");
			}

		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa phiếu nhập thất bại");
		}

		return "quantri/quanly/phieunhap";
	}

	@RequestMapping(value = "phieunhap", params = "themctpn", method = RequestMethod.POST)
	public String themCTPN(ModelMap model, @ModelAttribute("CTSP") ChiTietSanPham CTSP, BindingResult errors) {

		// ChiTietSanPham chitietSP = chiTietSanPhamService;
		/*
		 * if(chitietSP != null) {
		 * 
		 * }else {
		 * 
		 * }
		 */

		return "quantri/quanly/phieunhap";
	}

	@RequestMapping(value = "donhang", method = RequestMethod.GET)
	public String getViewDonHang() {
		return "quantri/quanly/donhang";
	}

	@RequestMapping(value = "donhang/{maDH}", params = "thongtin", method = RequestMethod.GET)
	public String getThongTinDonHang(ModelMap model, @PathVariable("maDH") Integer maDH) {

		if (maDH != null) {
			DonHang donhang = donHangService.getByMaDH(maDH);

			if (donhang != null) {
				List<ChiTietDonHang> chitietdonhang = chiTietDonHangService.getDSByMaDH(maDH);
				if (chitietdonhang.size() > 0) {
					model.addAttribute("chitietdonhang", chitietdonhang);
				} else {
					model.addAttribute("chitietdonhang", new ArrayList<ChiTietDonHang>());
				}

				model.addAttribute("thongTinDH", donhang);
				model.addAttribute("isOpenModalInfo", true);
			}
		}

		return "quantri/quanly/donhang";
	}
	
	@RequestMapping(value = "donhang/{maDH}", params = "suaTrangthai", method = RequestMethod.GET)
	public String getTrangThaiNhanVien(ModelMap model, @PathVariable("maDH") Integer maDH) {

		DonHang donhang = donHangService.getByMaDH(maDH);
		
		System.out.println(donhang.getTrangThaiDH().getMaTTDH());

		if (donhang != null) {
			model.addAttribute("thongTinDH", donhang);
			model.addAttribute("isOpenModalEdit", true);
			
			System.out.println(2);
		}
		return "quantri/quanly/donhang";
	}

	@RequestMapping(value = "donhang/{maDH}", params = "suaDH", method = RequestMethod.POST)
	public String postTrangThaiDonHang(ModelMap model, @PathVariable("maDH") Integer maDH,
			@ModelAttribute("thongTinDH") DonHang donhang, BindingResult errors) {

		DonHang donhangcu = donHangService.getByMaDH(maDH);
		if (donhangcu != null) {
			if (donhangcu.getTrangThaiDH().getMaTTDH() == 3 && donhang.getTrangThaiDH().getMaTTDH() != 3) {

				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng đã bị hủy trươc đó");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}
			if (donhangcu.getTrangThaiDH().getMaTTDH() == 1 && donhang.getTrangThaiDH().getMaTTDH() == 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng chưa được xác nhận");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}

			if (donhangcu.getTrangThaiDH().getMaTTDH() == 2 && donhang.getTrangThaiDH().getMaTTDH() != 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng không thể hủy hoặc chuyển thành đơn mới");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}

			if (donhangcu.getTrangThaiDH().getMaTTDH() == 4 && donhang.getTrangThaiDH().getMaTTDH() != 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng đã giao thành công trước đó");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}
			
			donhangcu.getTrangThaiDH().setMaTTDH(donhang.getTrangThaiDH().getMaTTDH());

			if (donHangService.suaDH(donhangcu)) {
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Thay đổi trạng thái thành công");
				model.addAttribute("danhSachDonHang", donHangService.getDSDonHang());
			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Thay đổi trạng thía thất bại");
			}

		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thay đổi trạng thía thất bại");
		}

		return "quantri/quanly/donhang";
	}

//	@RequestMapping(value = "donhang", params = "trangthai", method = RequestMethod.POST)
//	public String postTranThaiDonHang(ModelMap model, @RequestParam("maDH") Integer maDH) {
//		
//		System.out.println(maDH);
//		NhaCungCap nhacungcap = nhaCungCapService.getByMaNCC(maDH);
//		if(nhacungcap == null ) {
//			System.out.println(1);
//				model.addAttribute("isSuccess", false);
//				model.addAttribute("alertMessage", "Xóa nhà cung cấp thất bại");
//		}
//		if(nhacungcap.getPhieuNhap().size() == 0) {
//			System.out.println(2);
//			nhaCungCapService.xoaNCC(nhacungcap);
//			model.addAttribute("isSuccess", true);
//			model.addAttribute("alertMessage", "Xóa nhà cung cấp thành công");
//			model.addAttribute("danhSachNhaCungCap", nhaCungCapService.getDSNhaCungCap());
//			
//		}
//		if(nhacungcap.getPhieuNhap().size() >0 ) {
//			System.out.println(3);
//			model.addAttribute("isSuccess", false);
//			model.addAttribute("alertMessage", "Xóa nhà cung cấp thất bại");
//		}
//		
//		return "quantri/quanly/nhacungcap";
//	}
}
