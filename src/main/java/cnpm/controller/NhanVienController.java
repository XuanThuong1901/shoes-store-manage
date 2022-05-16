package cnpm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.KhachHang;
import cnpm.service.KhachHangService;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;

@Controller
@RequestMapping("/nhanvien/")
public class NhanVienController {
	
	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;
	
	@RequestMapping("tongquan")
	public String getViewTongQuan(ModelMap model) {
		return "quantri/nhanvien/tongquan";
	}
	
	
	@RequestMapping(value = "khachhang",  method = RequestMethod.GET)
	public String showList (ModelMap model) {
		
		List<KhachHang> danhSachKhachHang = this.getDSKhachHang();
		model.addAttribute("danhSachKhachHang", danhSachKhachHang);
		model.addAttribute("isOpenModalInfo", false);
		
		return "quantri/nhanvien/khachhang";
	}
	
	@ModelAttribute("danhSachKhachHang")
	public List<KhachHang> getDSKhachHang() {
		List<KhachHang> list = khachHangService.getDSKhachHang();
		return list;	
	}
	
	@RequestMapping(value = "khachhang/{maKH}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1KhachHang(ModelMap model, @PathVariable("maKH") String maKH) {

		KhachHang khachhang = khachHangService.getByMaKH(maKH);
		if (khachhang != null) {
			model.addAttribute("thongTinKH", khachhang);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/nhanvien/khachhang";
	}
	
	
	
	
}
