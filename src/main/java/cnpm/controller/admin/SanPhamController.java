package cnpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.entity.SanPham;
import cnpm.service.SanPhamService;

@Controller
@RequestMapping("/quanly/sanpham")
public class SanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	
	@ModelAttribute("danhSachSanPham")
	public List<SanPham> getDsSanpham(){
		return sanPhamService.getDSSanPham();
	}
	
	@RequestMapping("/")
	public String getViewSanpham() {
		return "quantri/quanly/sanpham";
	}
}
