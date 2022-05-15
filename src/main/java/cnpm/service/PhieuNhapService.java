package cnpm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.PhieuNhapDAO;
import cnpm.entity.NhanVien;
import cnpm.entity.PhieuNhap;


@Service
public class PhieuNhapService {
	@Autowired
	PhieuNhapDAO phieuNhapDAO;
	
	public List<PhieuNhap> getDSPhieuNhap(){
		// TODO Auto-generated method stub
		return phieuNhapDAO.getDSPhieuNhap();
	}
	
	public PhieuNhap getByMaPN(Integer maPN) {
		return phieuNhapDAO.getByMaPN(maPN);
	}
	
	public Boolean them(PhieuNhap phieuNhap) {
		return phieuNhapDAO.them(phieuNhap);
	}
	
	public Boolean sua(PhieuNhap phieuNhap) {
		return phieuNhapDAO.sua(phieuNhap);
	}
	
	public Boolean xoa(PhieuNhap phieuNhap) {
		return phieuNhapDAO.xoa(phieuNhap);
	}
}
