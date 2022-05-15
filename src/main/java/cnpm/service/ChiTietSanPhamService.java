package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.ChiTietSanPhamDAO;
import cnpm.entity.ChiTietSanPham;


@Service
public class ChiTietSanPhamService {
	@Autowired
	ChiTietSanPhamDAO chiTietSanPhamDAO;

	public ChiTietSanPham getByCacMa(Integer maCTSP, Integer maMau, Integer maSize) {
		return chiTietSanPhamDAO.getByCacMa(maCTSP, maMau, maSize);
	}
	
}
