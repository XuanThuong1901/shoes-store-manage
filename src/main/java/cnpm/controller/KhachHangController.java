package cnpm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import cnpm.service.TrangThaiDonHangService;

@Controller

public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;

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
	

	@ModelAttribute("dsHTTT")
	public  List<HinhThucThanhToan> getDSHinhThucThanhToan(){
		return hinhThucThanhToanService.getDSHinhThucThanhToan();
	}
		
	@ModelAttribute("giohang")
	public List<GioHang> getGioHang(HttpSession ss, ModelMap model){
		
		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return null;
		}
		
		if(!tk.getVaitro().getMaVT().equals("KH")) {
			
			return null;
		}
		
		List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
		System.out.println("list " + list.size());
		return list;
		
	}
	
	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap model) {

		return "shop/taikhoan";
	}
	
	float tongtien = 0.0F;
	
	@RequestMapping(value="thanhtoan")
	public String getViewThanhToan(ModelMap model, HttpServletRequest request) {

		//Double tongtien = Double.parseDouble(request.getParameter("tongtien"));
		//model.addAttribute("tongtien", tongtien);
		model.addAttribute("donhang", new DonHang());
		
		return "shop/thanhtoan";
	}
	
	@RequestMapping(value="thanhtoan", params="thanhtoangiohang", method=RequestMethod.POST)
	public String getthanhToan(ModelMap model, HttpServletRequest request) {

		tongtien = Float.parseFloat(request.getParameter("tongtien"));
		
		model.addAttribute("tongtien", tongtien);
		model.addAttribute("donhang", new DonHang());
		
		return "shop/thanhtoan";
	}
	
	@RequestMapping(value="thanhtoan", params="muahang", method=RequestMethod.POST)
	public String muaHang(ModelMap model, HttpSession ss, HttpServletRequest request, @ModelAttribute("donhang") DonHang donhang) {

		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return "redirect:/dangnhap";
		}else if(!tk.getVaitro().getMaVT().equals("KH")) {
			
			return "redirect:/";
		}
		
		List<GioHang> dsgiohang = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
		if(dsgiohang != null) {
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
			for(GioHang giohang : dsgiohang) {
				ctpk.setMaDH(donhang.getMaDH());
				ctpk.setMaCTSP(giohang.getChiTietSP().getMaChiTietSP());
				ctdonhang.setChiTietDonHangPK(ctpk);
				ctdonhang.setSoLuong(giohang.getSoLuong());
				ctdonhang.setGia(giohang.getChiTietSP().getSanPham().getGia());
				
				if(chiTietDonHangService.themCTDH(ctdonhang)) {
					gioHangService.xoa(giohang);
				}else {
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
	
	@RequestMapping(value="giohang",params="xoasp", method = RequestMethod.POST)
	public String xoaSPKhoiGioHang(ModelMap model, HttpSession ss, HttpServletRequest request) {
		
		if(request.getParameter("mactsp")==null) {
			return "shop/giohang";
		}
		
		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		if (tk == null) {
			return "redirect:/dangnhap";
		}else if(!tk.getVaitro().getMaVT().equals("KH")) {
			
			return "redirect:/";
		}
		
		Integer mactsp = Integer.parseInt(request.getParameter("mactsp")); 
		GioHang giohang = gioHangService.getByPk(tk.getKhachHang().getMaKH(), mactsp);
		if(gioHangService.xoa(giohang)) {
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Xóa sản phẩm khỏi giỏ hàng thành công !");
			List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
			model.addAttribute("giohang", list);
		}
		
		
		
		return "shop/giohang";
	}

	@RequestMapping(value = "/sanpham/{maSP}", params = "themvaogiohang", method = RequestMethod.POST)
	public String themGioHang(ModelMap model, HttpServletRequest request, @PathVariable("maSP") Integer maSP,

			//@RequestParam("size") Integer size, @RequestParam("soluong") Integer soLuong,

			 HttpSession ss, RedirectAttributes redirectAttributes) {
		/// check chi cho khach hang dc them
		Integer size = 0;
		Integer soLuong = 0;
		if(request.getParameter("size") != null) {
			 size = Integer.parseInt(request.getParameter("size")); 
		}else {
			System.out.println("size = null");
		}
		
		if(request.getParameter("soluong") != null) {
			soLuong = Integer.parseInt(request.getParameter("soluong")); 
		}else {
			System.out.println("sl = null");
		}
		
		
		
		System.out.println("size " + size + "so luong " + soLuong);

		if (maSP == null) {
			return "redirect:/";

		}

		if (size == 0 ) {
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
		}else if(!tk.getVaitro().getMaVT().equals("KH")) {
			
			return "redirect:/";
		}
		
		ChiTietSanPham ctsp = chiTietSanPhamService.getByMaSPVaSize(maSP, size);
		

		System.out.println("number " + size + " numer" + soLuong + " " + maSP + " " + ctsp);
		
		
		GioHang giohang = gioHangService.getByPk(tk.getKhachHang().getMaKH(), ctsp.getMaChiTietSP());
			if(giohang == null) {
				GioHangPK pk = new GioHangPK(tk.getKhachHang().getMaKH(), ctsp.getMaChiTietSP());
				giohang = new GioHang();
				giohang.setGioHangPK(pk);
				giohang.setSoLuong(soLuong);
				
				if(gioHangService.them(giohang)) {
					model.addAttribute("isSuccess", true);
					model.addAttribute("alertMessage", "Đã thêm sản phẩm vào giỏ");
					System.out.println("Đã thêm sản phẩm vào giỏ");
					List<GioHang> list = gioHangService.getGioHangCuaKH(tk.getKhachHang().getMaKH());
					model.addAttribute("giohang", list);
				}else {
					System.out.println("Thêm sản phẩm vào giỏ thất bại");
				}
			}else {
				giohang.setSoLuong(giohang.getSoLuong() + soLuong);
				
				if(gioHangService.sua(giohang)) {
					model.addAttribute("isSuccess", true);
					model.addAttribute("alertMessage", "Đã thêm sản phẩm vào giỏ");
					System.out.println("Cập nhật giỏ hàng thành công");
				}else {
					System.out.println("Cập nhật giỏ hàng thất bại");
				}
					
			}
		
		//String referer = request.getHeader("Referer");
		//return "redirect:" + referer;
			
		model.addAttribute("ctsanpham", ctsp.getSanPham());
		return "shop/chitietsanpham";
	}

	

}
