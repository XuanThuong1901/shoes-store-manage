package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.DonHangDAO;
import cnpm.entity.DonHang;

@Service
public class DonHangService {
	@Autowired
	DonHangDAO donHangDAO;
	
	public List<DonHang> getDSDonHang(){
		return donHangDAO.getDSDonHang();
	}
	
	public DonHang getByMaDH(Integer maDH) {
		return donHangDAO.getByMaDH(maDH);
	}
}
