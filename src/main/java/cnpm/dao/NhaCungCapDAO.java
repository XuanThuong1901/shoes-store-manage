package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.NhaCungCap;
import cnpm.entity.PhieuNhap;

@Transactional
@Repository
public class NhaCungCapDAO {
	@Autowired
	SessionFactory factory;
	
	public NhaCungCap getByMaNCC(Integer maNCC) {
		Session session = factory.getCurrentSession();
		String hql = "from NhaCungCap where maNCC = :maNCC";
		Query query = session.createQuery(hql);
		query.setParameter("maNCC", maNCC);
		List<NhaCungCap> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		NhaCungCap ncc = res.get(0);
		return ncc;
	}
	
	public List<NhaCungCap> getDSNhaCungCap(){
		Session session = factory.getCurrentSession();
		String hql = "from NhaCungCap";
		Query query = session.createQuery(hql);
		List<NhaCungCap> list = query.list();
		
		return list;
	}
}
