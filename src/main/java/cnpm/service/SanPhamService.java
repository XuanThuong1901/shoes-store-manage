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
	
	public List<SanPham> getSanPhamTheoTen(String tensp){
		return sanPhamDAO.getSanPhamTheoTen(tensp);
	}
	
	public Integer maSPCuoiCung() {
		List<SanPham> sanpham = this.getDSSanPham();
		Integer index = sanpham.get(sanpham.size()-1).getMaSP();
		return index;
	}
	
	public List<SanPham> getRandomDSSanPham(){
		return sanPhamDAO.getRandomDSSanPham();
	}
	
	public List<SanPham> getDSSanPham(){
		return sanPhamDAO.getDSSanPham();
	}
	
	public SanPham getByMaSP(Integer maSP) {
		return sanPhamDAO.getByMaSP(maSP);
	}
	
	public List<SanPham> getDSSanPhamTheoDM(Integer maDM){
		return sanPhamDAO.getDSSanPhamTheoDM(maDM);
	}
	
	public List<SanPham> getDSSanPhamTheoPhai(Boolean phai){
		return sanPhamDAO.getDSSanPhamTheoPhai(phai);
	}
	
	public Boolean themSP(SanPham sanpham) {
		return sanPhamDAO.them(sanpham);
	}
	
	public Boolean suaSP(SanPham sanpham) {
		return sanPhamDAO.sua(sanpham);
	}
	
	public Boolean xoaSP(SanPham sanpham) {
		return sanPhamDAO.xoa(sanpham);
	}
}
