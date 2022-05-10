package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.TaiKhoanDAO;
import cnpm.daoimp.TaiKhoanDAOImp;
import cnpm.entity.TaiKhoan;

@Service
public class TaiKhoanService {
	@Autowired
	TaiKhoanDAO taiKhoanDAO;
	
	@Autowired
	VaiTroService vaiTroService;
	
	public boolean kiemTraDangNhap(String email, String matkhau) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.kiemTraDangNhap(email, matkhau);
	}

	public TaiKhoan getByEmail(String email) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getByEmail(email);
	}

	public String taoMaTKMoi() {
		int index = this.getDSTaiKhoan().size() + 1;
		while(this.maTKDaCo("TK"+Integer.toString(index))) {
			index++;
		}
		
		String maTK = "TK" + Integer.toString(index);
		
		return maTK;
	}

	public List<TaiKhoan> getDSTaiKhoan() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getDSTaiKhoan();
	}

	public TaiKhoan getByMaTK(String maTK) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getByMaTK(maTK);
	}
	
	public Boolean maTKDaCo(String maTK) {
		if(this.getByMaTK(maTK) != null) {
			return true;
		}
		return false;
	}

	public Boolean themKH(TaiKhoan taikhoan) {
		taikhoan.setTrangThai(true);
		taikhoan.setVaitro(vaiTroService.getByMaVT("KH"));
		
		return taiKhoanDAO.them(taikhoan);
	}
	
	public Boolean themNV(TaiKhoan taikhoan) {
		taikhoan.setTrangThai(true);
		taikhoan.setVaitro(vaiTroService.getByMaVT("NV"));
		
		return taiKhoanDAO.them(taikhoan);
	}
	
}
