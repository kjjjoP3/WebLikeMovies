package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.PhimTHs;
import com.poly.Entity.Phims;
import com.poly.Entity.TamPTH;
import com.poly.Entity.TheLoais;
import com.poly.Utils.JpaUtils;

public class PhimTHDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}

	public PhimTHs create(PhimTHs entity) {
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
	
	public PhimTHs update(PhimTHs entity) {
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

	public PhimTHs delete(String id) {
		PhimTHs entity = this.findById(id);
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
	
	public PhimTHs findById(String id) {
		PhimTHs entity = em.find(PhimTHs.class, Long.parseLong(id));
		return entity;
	}
	
	public List<PhimTHs> findAll(){
		String jpql = "Select o from PhimTHs o";
		TypedQuery<PhimTHs> query = em.createQuery(jpql, PhimTHs.class);
		List<PhimTHs> list = query.getResultList();
		return list;
	}
	
	public List<Phims> fillMaPhim(){
		String jpql = "select * from phim where maPhim not in (select maPhim from PhimTH)";
		Query query = em.createNativeQuery(jpql, Phims.class);
		List<Phims> list = query.getResultList();
		return list;
	}
	
	public List<TheLoais> fillTheLoai(){
		String jpql = "select maTheLoai, tenTheLoai from TheLoai";
		Query query = em.createNativeQuery(jpql, TheLoais.class);
		List<TheLoais> list = query.getResultList();
		return list;
	}
	
	public Long Count() {
		String jpql = "Select count(o) from PhimTHs o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		long result = query.getSingleResult();
		return result;
	}
	
	public List<TamPTH> findItem(int i){
		int result = 10*i;
		String jpql = " select maTongHop, Title, tenTheLoai, loaiPhim from (Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim) inner join TheLoai on PhimTH.maTheLoai = TheLoai.maTheLoai ORDER BY maTongHop OFFSET "+result+" ROWS FETCH NEXT 10 ROWS ONLY";
		//String jpql = "select TOP ? * from Phim";
		Query query = em.createNativeQuery(jpql, TamPTH.class);
		List<TamPTH> list = query.getResultList();
		return list;
	}
	
	public TamPTH fillPath(String id) {
		String jpql = "select maTongHop, Title, tenTheLoai, loaiPhim from (Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim) inner join TheLoai on PhimTH.maTheLoai = TheLoai.maTheLoai where PhimTH.maPhim like :uid";
		Query query = em.createNativeQuery(jpql, TamPTH.class);
		query.setParameter("uid", id);
		TamPTH entity = (TamPTH) query.getSingleResult();
		return entity;
	}
	
	
}
