package cnpm.dao;

import org.springframework.stereotype.Repository;

import cnpm.daoimp.NhanVienDAOImp;

@Repository
public class NhanVienDAO implements NhanVienDAOImp {
	
	public void check() {
		System.out.println("dao nhan vine");
		
	}
}
