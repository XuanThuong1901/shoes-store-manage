package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity. DonHang;

@Transactional
@Repository
public class DonHangDAO {
	@Autowired
	SessionFactory factory;
	
	public List<DonHang> getDSDonHang(){
		Session session = factory.getCurrentSession();
		String hql = "from  DonHang";
		Query query = session.createQuery(hql);
		List< DonHang> list = query.list();
		
		return list;
	}
	
	public DonHang getByMaDH(Integer maDH) {
		Session session = factory.getCurrentSession();
		String hql = "from DonHang where maDH = :maDH";
		Query query = session.createQuery(hql);
		query.setParameter("maDH", maDH);
		List<DonHang> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res.get(0);
	}
}
