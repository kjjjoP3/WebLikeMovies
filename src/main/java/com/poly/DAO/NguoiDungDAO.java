package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;
import com.poly.Utils.JpaUtils;

public class NguoiDungDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}

	public NguoiDungs create(NguoiDungs entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e){
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public NguoiDungs update(NguoiDungs entity) {
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

	public NguoiDungs delete(String id) {
		NguoiDungs entity = this.findById(id);
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
	
	public NguoiDungs findById(String id) {
		NguoiDungs entity = em.find(NguoiDungs.class, id);
		return entity;
	}
	
	public List<NguoiDungs> findAll(){
		String jpql = "Select o from NguoiDungs o";
		TypedQuery<NguoiDungs> query = em.createQuery(jpql, NguoiDungs.class);
		List<NguoiDungs> list = query.getResultList();
		return list;
	}
    
	public List<NguoiDungs> findItem(int i){
		int result = 10*i;
		String jpql = "  SELECT * FROM NguoiDung ORDER BY Ten OFFSET "+ result +" ROWS FETCH NEXT 10 ROWS ONLY";
		//String jpql = "select TOP ? * from Phim";
		Query query = em.createNativeQuery(jpql, NguoiDungs.class);
		List<NguoiDungs> list = query.getResultList();
		return list;
	}
	
	public Long Count() {
		String jpql = "Select count(o) from NguoiDungs o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		long result = query.getSingleResult();
		return result;
	}
	
	public NguoiDungs findByUsernameAndEmail(String tenDN, String Email) {
		String jpql="select o from NguoiDungs o where o.tenDN= :tenDN and o.Email= :Email";
		try {
			TypedQuery<NguoiDungs> query = em.createQuery(jpql, NguoiDungs.class);
			query.setParameter("tenDN", tenDN);
			query.setParameter("Email", Email);
			return query.getSingleResult();
		
			
		}finally {
			em.close();
		}
		
	}
	
	
	
	
	
	
	
}
