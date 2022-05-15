package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.SanPham;

@Transactional
@Repository
public class SanPhamDAO {
	@Autowired
	SessionFactory factory;
	
	public List<SanPham> getDSSanPham(){
		Session session = factory.getCurrentSession();
		String hql = "from SanPham";
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		
		return list;
	}
}
