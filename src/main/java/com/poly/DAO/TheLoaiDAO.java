package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.Phims;
import com.poly.Entity.TheLoais;
import com.poly.Utils.JpaUtils;

public class TheLoaiDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	
	public TheLoais create(TheLoais entity) {
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
	
	public TheLoais update(TheLoais entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public TheLoais delete(String id) {
		TheLoais entity = this.findById(id);
		try {		
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public TheLoais findById(String id) {
		TheLoais entity = em.find(TheLoais.class, id);
		return entity;
	}
	
	public List<TheLoais> findAll(){
		String jpql = "Select o from TheLoais o";
		TypedQuery<TheLoais> query = em.createQuery(jpql, TheLoais.class);
		List<TheLoais> list = query.getResultList();
		return list;
	}
	
	public Long Count() {
		String jpql = "Select count(o) from TheLoais o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		long result = query.getSingleResult();
		return result;
	}
	
	public List<TheLoais> findItem(int i){
		int result = 10*i;
		String jpql = "SELECT * FROM TheLoai ORDER BY maTheLoai OFFSET " +result+ " ROWS FETCH NEXT 10 ROWS ONLY";
		//String jpql = "select TOP ? * from Phim";
		Query query = em.createNativeQuery(jpql, TheLoais.class);
		List<TheLoais> list = query.getResultList();
		return list;
	}
	
	public String nameTL(String s) {
		String jpql = "Select o.tenTheLoai from TheLoais o where o.maTheLoai like :uid";
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		query.setParameter("uid", s);
		String result = query.getSingleResult();
		return result;
	}
	
	public String nameFilm(String s) {
		String jpql = "Select o.theloais.tenTheLoai from PhimTHs o where o.phims.maPhim like :uid";
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		query.setParameter("uid", s);
		String result = query.getSingleResult();
		return result;
	}
}
