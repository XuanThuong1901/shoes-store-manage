package cnpm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.entity.VaiTro;
import cnpm.service.NhanVienService;

@Transactional
@Controller
public class TrangChuController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	NhanVienService nvService;
	
	@RequestMapping(value="/")
	public String index(ModelMap model) {
		model.addAttribute("message", "ok");
		List<VaiTro> list = this.getVaiTro();
		model.addAttribute("list", list);
		
		nvService.check();
		
		return "index";
	}
	
	@RequestMapping(value="/san-pham")
	public String getViewProduct() {
		
		return "user/product";
	}
	
	
	
	public List<VaiTro> getVaiTro(){
		Session session = factory.getCurrentSession();
		String hql ="From VaiTro";
		Query query = session.createQuery(hql);
		List<VaiTro> list = query.list();
		return list;
	}
}
