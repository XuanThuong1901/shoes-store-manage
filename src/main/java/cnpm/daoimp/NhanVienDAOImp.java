package cnpm.daoimp;

import cnpm.entity.NhanVien;

public interface NhanVienDAOImp {
	void check();
	
	NhanVien getById(String id);
}
