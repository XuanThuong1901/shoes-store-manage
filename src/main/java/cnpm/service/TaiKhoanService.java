package cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.TaiKhoanDAO;
import cnpm.daoimp.TaiKhoanDAOImp;

@Service
public class TaiKhoanService implements TaiKhoanDAOImp {
	@Autowired
	TaiKhoanDAO taiKhoanDAO;
	
	public boolean kiemTraDangNhap(String email, String matkhau) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.kiemTraDangNhap(email, matkhau);
	}

}
