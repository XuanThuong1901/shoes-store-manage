package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.SanPhamDAO;
import cnpm.entity.SanPham;

@Service
public class SanPhamService {
	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public List<SanPham> getDSSanPham(){
		return sanPhamDAO.getDSSanPham();
	}
	
	public SanPham getByMaSP(Integer maSP) {
		return sanPhamDAO.getByMaSP(maSP);
	}
}
