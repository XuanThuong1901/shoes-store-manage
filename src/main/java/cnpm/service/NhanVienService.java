package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.NhanVienDAO;
import cnpm.daoimp.NhanVienDAOImp;
import cnpm.entity.NhanVien;

@Service
public class NhanVienService{
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	
	public NhanVien getByMaNV(String maNV) {
		return nhanVienDAO.getByMaNV(maNV);
	}

	public NhanVien getByMaTK(String maTK) {
		// TODO Auto-generated method stub
		return nhanVienDAO.getByMaTK(maTK);
	}

	public List<NhanVien> getDSNhanVien(){
		return nhanVienDAO.getDSNhanVien();
	}

}