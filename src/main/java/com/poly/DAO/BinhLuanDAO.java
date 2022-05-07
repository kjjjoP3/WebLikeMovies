package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.BinhLuans;
import com.poly.Entity.Phims;
import com.poly.Entity.TamRating;
import com.poly.Entity.YeuThichs;
import com.poly.Utils.JpaUtils;

public class BinhLuanDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
	    em.close();
	    super.finalize();
	}
	
	public BinhLuans create(BinhLuans entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public BinhLuans update(BinhLuans entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	
	public BinhLuans delete(String id) {
			BinhLuans entity = this.findById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	
	public BinhLuans findById(String id) {
		BinhLuans entity = em.find(BinhLuans.class, id);
		return entity;
	}
	
	public List<BinhLuans> findAll(){
		String jpql = "Select o from BinhLuans o";
		TypedQuery<BinhLuans> query = em.createQuery(jpql, BinhLuans.class);
		List<BinhLuans> list = query.getResultList();
		return list;
	}
	
	public BinhLuans selectByUser(String user, String film) {
		String jpql = "select o from BinhLuans o where (o.phims.maPhim like :film) and (o.nguoidungs.tenDN like :user)";
		TypedQuery<BinhLuans> query = em.createQuery(jpql, BinhLuans.class);
		query.setParameter("film", film);
		query.setParameter("user", user);
		BinhLuans entity =  query.getSingleResult();
		return entity;
	}
	
	public List<TamRating> findItem(int i, String id){
		int result = 5*i;
		String jpql = "SELECT maBinhLuan, ho, Ten, Sao, noiDung FROM BinhLuan inner join nguoiDung on BinhLuan.tenDN = nguoiDung.tenDN where maPhim like :uid ORDER BY maBinhLuan OFFSET "+result+" ROWS FETCH NEXT 10 ROWS ONLY";
		//String jpql = "select TOP ? * from Phim";
		Query query = em.createNativeQuery(jpql, TamRating.class);
		query.setParameter("uid", id);
		List<TamRating> list = query.getResultList();
		return list;
	}
	
	public Long Count(String id) {
		String jpql = "Select count(o) from BinhLuans o where maPhim like :uid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("uid", id);
		long result = query.getSingleResult();
		return result;
	}
	
	public Long countById(String id) {
		String jpql = "Select count(o) from BinhLuans o where o.nguoidungs.tenDN like :uid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("uid", id);
		long result = query.getSingleResult();
		return result;
	}
}
