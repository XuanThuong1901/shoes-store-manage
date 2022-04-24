package cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.NhanVienDAO;
import cnpm.daoimp.NhanVienDAOImp;

@Service
public class NhanVienService implements NhanVienDAOImp {
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	

	public void check() {
		
		nhanVienDAO.check();
	}
}