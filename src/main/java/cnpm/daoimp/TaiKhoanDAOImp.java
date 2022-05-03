package cnpm.daoimp;

import cnpm.entity.TaiKhoan;

public interface TaiKhoanDAOImp {
	public boolean kiemTraDangNhap(String email, String matkhau);
	
	public TaiKhoan getByEmail(String email);
}
