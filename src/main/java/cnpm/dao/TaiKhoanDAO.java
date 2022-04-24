package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.daoimp.TaiKhoanDAOImp;
import cnpm.entity.TaiKhoan;

@Transactional
@Repository
public class TaiKhoanDAO implements TaiKhoanDAOImp{
	@Autowired
	SessionFactory factory;

	public boolean kiemTraDangNhap(String email, String matkhau) {
		Session session = factory.getCurrentSession();
		String hql = "from TaiKhoan where email = :email and matkhau = :matkhau";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("matkhau", matkhau);
		
		List<TaiKhoan> list= query.list();
		if(list.size() == 0) {
			return false;
		}
		
		return true;
	}

}
