package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.SizeSanPham;

@Transactional
@Repository
public class SizeDAO {
	@Autowired
	SessionFactory factory;
	
	public List<SizeSanPham> getDSSize(){
		Session session = factory.getCurrentSession();
		String hql = "from SizeSanPham";
		Query query = session.createQuery(hql);
		List<SizeSanPham> list = query.list();
		
		return list;
	}
}
