package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.daoimp.NhanVienDAOImp;
import cnpm.entity.NhanVien;

@Transactional
@Repository
public class NhanVienDAO implements NhanVienDAOImp {
	
	@Autowired
	SessionFactory factory;
	
	public void check() {
		System.out.println("dao nhan vine");
		
	}

	public NhanVien getByMaTK(String maTK) {
		Session session = factory.getCurrentSession();
		String hql = "from NhanVien where maTK = :maTK";
		Query query = session.createQuery(hql);
		query.setParameter("maTK", maTK);
		List<NhanVien> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		NhanVien nv = res.get(0);
		return nv;
	}
}
