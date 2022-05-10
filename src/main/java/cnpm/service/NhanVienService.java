package cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.NhanVienDAO;
import cnpm.daoimp.NhanVienDAOImp;
import cnpm.entity.NhanVien;

@Service
public class NhanVienService{
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	


	public NhanVien getByMaTK(String maTK) {
		// TODO Auto-generated method stub
		return nhanVienDAO.getByMaTK(maTK);
	}


}