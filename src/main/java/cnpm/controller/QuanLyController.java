package cnpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.entity.NhanVien;
import cnpm.service.NhanVienService;

@Controller
@RequestMapping("/quanly/")
public class QuanLyController {
	@Autowired
	NhanVienService nhanVienService;
	
//	============== Model - Attribute ==============
	@ModelAttribute("danhSachNhanVien")
	public List<NhanVien> getDSNhanVien(){
		List<NhanVien> list = nhanVienService.getDSNhanVien();
		return list;
	}

	@RequestMapping(value="tongquan", method=RequestMethod.GET)
	public String getViewTongQuan() {
		
		return "quantri/quanly/tongquan";
	}
	
	@RequestMapping(value="nhanvien", method=RequestMethod.GET)
	public String getViewNhanVien(ModelMap model) {
		
		model.addAttribute("isOpenModalInfo", false);
		return "quantri/quanly/nhanvien";
	}
	
	@RequestMapping(value="nhanvien/{maNV}",params="thongtin", method=RequestMethod.GET)
	public String getThongtin1NhanVien(ModelMap model, @PathVariable("maNV") String maNV) {
		
		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if(nhanvien != null) {
			model.addAttribute("thongTinNV", nhanvien);
			model.addAttribute("isOpenModalInfo", true);
		}
		
		return "quantri/quanly/nhanvien";
	}
	
}
