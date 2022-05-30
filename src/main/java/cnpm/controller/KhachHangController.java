package cnpm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cnpm.entity.ChiTietDonHang;
import cnpm.entity.ChiTietDonHangPK;
import cnpm.entity.ChiTietSanPham;
import cnpm.entity.DonHang;
import cnpm.entity.GioHang;
import cnpm.entity.GioHangPK;
import cnpm.entity.HinhThucThanhToan;
import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.ChiTietDonHangService;
import cnpm.service.ChiTietSanPhamService;
import cnpm.service.DonHangService;
import cnpm.service.GioHangService;
import cnpm.service.HinhThucThanhToanService;
import cnpm.service.KhachHangService;
import cnpm.service.TaiKhoanService;
import cnpm.service.TrangThaiDonHangService;
import cnpm.service.UtilsService;

@Controller

public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	GioHangService gioHangService;

	@Autowired
	ChiTietSanPhamService chiTietSanPhamService;

	@Autowired
	HinhThucThanhToanService hinhThucThanhToanService;

	@Autowired
	DonHangService donHangService;

	@Autowired
	TrangThaiDonHangService trangThaiDonHangService;

	@Autowired
	ChiTietDonHangService chiTietDonHangService;

	@Autowired
	UtilsService utilService;

	@ModelAttribute("dsHTTT")
	public List<HinhThucThanhToan> getDSHinhThucThanhToan() {
		return hinhThucThanhToanService.getDSHinhThucThanhToan();
	}
	
	@ModelAttribute("thongTinKH")
	public KhachHang getThongTin(HttpSession ss) {
		TaiKhoan taiKhoan = (TaiKhoan) ss.getAttribute("user");
		KhachHang kh = taiKhoan.getKhachHang();
		return kh;
	}

	@ModelAttribute("giohang")
	public List<GioHang> getGioHang(HttpSession ss, ModelMap model) {

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return null;
		}

		if (!tk.getVaitro().getMaVT().equals("KH")) {

			return null;
		}

		List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
		System.out.println("list " + list.size());
		return list;

	}

	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap model, HttpSession ss) {

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		KhachHang khachhang = tk.getKhachHang();
		model.addAttribute("thongTinKH", khachhang);
		return "shop/taikhoan";
	}

	@RequestMapping(value = "taikhoan", params = "luuthaydoi", method = RequestMethod.POST)
	public String postLoginUser(ModelMap model, @ModelAttribute("thongTinKH") KhachHang khachhang,
			@RequestParam("anhMoi") MultipartFile anh, BindingResult errors, HttpSession ss) {

		if (khachhang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "thongTinKH", "Họ không được để trống");
		}

		if (khachhang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "thongTinKH", "Tên không được để trống");
		}

		if (khachhang.getPhai() != true && khachhang.getPhai() != false) {
			errors.rejectValue("phai", "thongTinKH", "???");
		}

		if (khachhang.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "thongTinKH", "Ngày sinh không được để trống");
		}

		if (khachhang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinKH", "Số điện thoại không được để trống");
		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "thongTinKH", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
//			model.addAttribute("isOpenModalEditUser", true);
			return "shop/taikhoan";
		}
		
		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		
		System.out.println(tk.getKhachHang().getMaKH());

		KhachHang khachhangcu = khachHangService.getByMaKH(tk.getKhachHang().getMaKH());
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
				khachhangcu.setSdt(khachhang.getSdt());
			}

			if (khachhangcu.getPhai() != khachhang.getPhai()) {
				khachhangcu.setPhai(khachhang.getPhai());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					khachhangcu.setAnh(hinh);
				}
			}

			if (khachHangService.suaKH(khachhangcu)) {
				tk.setKhachHang(khachhangcu);
				ss.setAttribute("user", tk);
				model.addAttribute("thongTinKH", khachhangcu);
				model.addAttribute("change", "Sửa nhân viên thành công");
			}
		}else {
			model.addAttribute("change", "Sửa nhân viên thất bại");
		}

		return "shop/taikhoan";
	}

	@RequestMapping(value = "taikhoan", params = "doimatkhau", method = RequestMethod.POST)
	public String postDoiMatKhau(ModelMap model, HttpSession ss, @RequestParam("mkcu") String mkcu,
			@RequestParam("mkmoi") String mkmoi, @RequestParam("xacnhanmk") String xacnhanmk) {
		
		if (mkcu == "") {
			model.addAttribute("mkcu", "Chưa nhập mật khẩu hiện tại");
			return "shop/taikhoan";
		}

		if (mkmoi == "") {
			model.addAttribute("mkmoi", "Chưa nhập mật khẩu mới");
			return "shop/taikhoan";
		}

		if (xacnhanmk == "") {
			model.addAttribute("xacnhanmk", "Chưa nhập mật khẩu xác nhận");
			return "shop/taikhoan";
		}

		if (!mkmoi.equals(xacnhanmk)) {
			model.addAttribute("xacnhanmk", "Mật khẩu và mật khẩu xác nhận khác nhau");
			return "shop/taikhoan";
		}

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");

		if (taiKhoanService.kiemTraDangNhap(tk.getEmail(), mkcu)) {
			taiKhoanService.thayDoiMK(tk, mkmoi);
			model.addAttribute("suamk", "Thay đổi thành công");
		} else {
			model.addAttribute("suamk", "Thay đổi thất bại");
		}

		return "shop/taikhoan";
	}

	float tongtien = 0.0F;

	@RequestMapping(value = "thanhtoan")
	public String getViewThanhToan(ModelMap model, HttpServletRequest request) {

		// Double tongtien = Double.parseDouble(request.getParameter("tongtien"));
		// model.addAttribute("tongtien", tongtien);
		model.addAttribute("donhang", new DonHang());

		return "shop/thanhtoan";
	}

	@RequestMapping(value = "thanhtoan", params = "thanhtoangiohang", method = RequestMethod.POST)
	public String getthanhToan(ModelMap model, HttpServletRequest request) {

		tongtien = Float.parseFloat(request.getParameter("tongtien"));

		model.addAttribute("tongtien", tongtien);
		model.addAttribute("donhang", new DonHang());

		return "shop/thanhtoan";
	}

	@RequestMapping(value = "thanhtoan", params = "muahang", method = RequestMethod.POST)
	public String muaHang(ModelMap model, HttpSession ss, HttpServletRequest request,
			@ModelAttribute("donhang") DonHang donhang) {

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return "redirect:/dangnhap";
		} else if (!tk.getVaitro().getMaVT().equals("KH")) {

			return "redirect:/";
		}

		List<GioHang> dsgiohang = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
		if (dsgiohang != null) {
			// them don hang
			donhang.setKhachHang(tk.getKhachHang());
			donhang.setThoiGian(new Date());
			donhang.setTongTien(tongtien);
			donhang.setTrangThaiDH(trangThaiDonHangService.getById(1));
			donHangService.themDH(donhang);
			// them chi tiet don hang
			donhang = donHangService.getDHVuaTao();
			System.out.println("donhang id " + donhang.getMaDH());
			ChiTietDonHang ctdonhang = new ChiTietDonHang();
			ChiTietDonHangPK ctpk = new ChiTietDonHangPK();
			for (GioHang giohang : dsgiohang) {
				ctpk.setMaDH(donhang.getMaDH());
				ctpk.setMaCTSP(giohang.getChiTietSP().getMaChiTietSP());
				ctdonhang.setChiTietDonHangPK(ctpk);
				ctdonhang.setSoLuong(giohang.getSoLuong());
				ctdonhang.setGia(giohang.getChiTietSP().getSanPham().getGia());

				if (chiTietDonHangService.themCTDH(ctdonhang)) {
					gioHangService.xoa(giohang);
				} else {
					return "shop/giohang";
				}
			}

			model.addAttribute("giohang", new ArrayList<GioHang>());
		}

		return "shop/thanhtoan";
	}

	@RequestMapping("giohang")
	public String getViewGioHang(ModelMap model, HttpSession ss) {

		return "shop/giohang";
	}

	@RequestMapping(value = "giohang", params = "xoasp", method = RequestMethod.POST)
	public String xoaSPKhoiGioHang(ModelMap model, HttpSession ss, HttpServletRequest request) {

		if (request.getParameter("mactsp") == null) {
			return "shop/giohang";
		}

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return "redirect:/dangnhap";
		} else if (!tk.getVaitro().getMaVT().equals("KH")) {

			return "redirect:/";
		}

		Integer mactsp = Integer.parseInt(request.getParameter("mactsp"));
		GioHang giohang = gioHangService.getByPk(tk.getKhachHang().getMaKH(), mactsp);
		if (gioHangService.xoa(giohang)) {
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Xóa sản phẩm khỏi giỏ hàng thành công !");
			List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
			model.addAttribute("giohang", list);
		}

		return "shop/giohang";
	}

	@RequestMapping(value = "/sanpham/{maSP}", params = "themvaogiohang", method = RequestMethod.POST)
	public String themGioHang(ModelMap model, HttpServletRequest request, @PathVariable("maSP") Integer maSP,

			// @RequestParam("size") Integer size, @RequestParam("soluong") Integer soLuong,

			HttpSession ss, RedirectAttributes redirectAttributes) {
		/// check chi cho khach hang dc them
		Integer size = 0;
		Integer soLuong = 0;
		if (request.getParameter("size") != null) {
			size = Integer.parseInt(request.getParameter("size"));
		} else {
			System.out.println("size = null");
		}

		if (request.getParameter("soluong") != null) {
			soLuong = Integer.parseInt(request.getParameter("soluong"));
		} else {
			System.out.println("sl = null");
		}

		System.out.println("size " + size + "so luong " + soLuong);

		if (maSP == null) {
			return "redirect:/";

		}

		if (size == 0) {
			redirectAttributes.addFlashAttribute("isSuccess", false);
			redirectAttributes.addFlashAttribute("message", "Vui lòng chọn size");

			return "redirect:" + request.getHeader("Referer");

		}

		if (soLuong == 0) {
			redirectAttributes.addFlashAttribute("isSuccess", false);
			redirectAttributes.addFlashAttribute("message", "Vui lòng chọn số lượng thêm");
			return "redirect:" + request.getHeader("Referer");
		}

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return "redirect:/dangnhap";
		} else if (!tk.getVaitro().getMaVT().equals("KH")) {

			return "redirect:/";
		}

		ChiTietSanPham ctsp = chiTietSanPhamService.getByMaSPVaSize(maSP, size);

		System.out.println("number " + size + " numer" + soLuong + " " + maSP + " " + ctsp);

		GioHang giohang = gioHangService.getByPk(tk.getKhachHang().getMaKH(), ctsp.getMaChiTietSP());
		if (giohang == null) {
			GioHangPK pk = new GioHangPK(tk.getKhachHang().getMaKH(), ctsp.getMaChiTietSP());
			giohang = new GioHang();
			giohang.setGioHangPK(pk);
			giohang.setSoLuong(soLuong);

			if (gioHangService.them(giohang)) {
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Đã thêm sản phẩm vào giỏ");
				System.out.println("Đã thêm sản phẩm vào giỏ");
				List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
				model.addAttribute("giohang", list);
			} else {
				System.out.println("Thêm sản phẩm vào giỏ thất bại");
			}
		} else {
			giohang.setSoLuong(giohang.getSoLuong() + soLuong);

			if (gioHangService.sua(giohang)) {
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Đã thêm sản phẩm vào giỏ");
				System.out.println("Cập nhật giỏ hàng thành công");
			} else {
				System.out.println("Cập nhật giỏ hàng thất bại");
			}

		}

		// String referer = request.getHeader("Referer");
		// return "redirect:" + referer;

		model.addAttribute("ctsanpham", ctsp.getSanPham());
		return "shop/chitietsanpham";
	}

}
