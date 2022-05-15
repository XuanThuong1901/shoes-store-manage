package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.ChiTietPhieuNhap;
import cnpm.entity.PhieuNhap;

@Transactional
@Repository
public class ChiTieuPhieuNhapDAO {
	@Autowired
	SessionFactory factory;
	
	public ChiTietPhieuNhap getByMaCTPN(Integer maCTPN) {
		Session session = factory.getCurrentSession();
		String hql = "from ChiTietPhieuNhap where maCTPN = :maCTPN";
		Query query = session.createQuery(hql);
		query.setParameter("maCTPN", maCTPN);
		List<ChiTietPhieuNhap> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		ChiTietPhieuNhap pn = res.get(0);
		return pn;
	}
	
	public List<PhieuNhap> getDSPhieuNhap(){
		Session session = factory.getCurrentSession();
		String hql = "from PhieuNhap";
		Query query = session.createQuery(hql);
		List<PhieuNhap> list = query.list();
		
		return list;
	}
	
	public Boolean them(PhieuNhap phieuNhap) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(phieuNhap);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		return isSuccess;
	}
	
	public Boolean sua(PhieuNhap phieuNhap) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(phieuNhap);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		
		return isSuccess;
	}
	
	public Boolean xoa(PhieuNhap phieuNhap) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(phieuNhap);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		
		return isSuccess;
	}
}
