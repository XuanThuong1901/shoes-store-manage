package cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class KhachHangController {
	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap mode) {
		
		return "shop/taikhoan";
	}
	
	@RequestMapping("thanhtoan")
	public String getViewThanhToan(ModelMap mode) {
		
		return "shop/thanhtoan";
	}
	
	@RequestMapping("giohang")
	public String getViewGioHang(ModelMap mode) {
		
		return "shop/giohang";
	}
}
