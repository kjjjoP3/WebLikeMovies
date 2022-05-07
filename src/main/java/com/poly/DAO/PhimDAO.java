package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;
import com.poly.Utils.JpaUtils;

public class PhimDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
	    em.close();
	    super.finalize();
	}
	
	public Phims create(Phims entity) {
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
	
	public Phims update(Phims entity) {
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
	
	public Phims delete(String id) {
		Phims entity = this.findById(id);
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
	
	public Phims findById(String id) {
		Phims entity = em.find(Phims.class, id);
		return entity;
	}
	
	public List<Phims> findAll(){
		String jpql = "Select o from Phims o";
		TypedQuery<Phims> query = em.createQuery(jpql, Phims.class);
		List<Phims> list = query.getResultList();
		return list;
	}
	
	public Long Count() {
		String jpql = "Select count(o) from Phims o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		long result = query.getSingleResult();
		return result;
	}
	
	public List<Phims> findItem(int i){
		int result = 10*i;
		String jpql = "SELECT * FROM Phim ORDER BY ngayCongChieu OFFSET " +result+ " ROWS FETCH NEXT 10 ROWS ONLY";
		//String jpql = "select TOP ? * from Phim";
		Query query = em.createNativeQuery(jpql, Phims.class);
		List<Phims> list = query.getResultList();
		return list;
	}
	
	public List<Phims> fillCarouselItem(){
		String jpql = "select top 12 * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and LEN(Title) <= 27 order by luotXem desc";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public List<Phims> fillNavPCR(){
		String jpql = "select top 6 * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and loaiPhim = 1 order by ngayCongChieu desc";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public List<Phims> fillNavCTL(String id){
		String jpql = "select top 6 * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and PhimTH.maTheLoai like\r\n"
				+ " (select TheLoai.maTheLoai from PhimTH inner join TheLoai on PhimTH.maTheLoai = TheLoai.maTheLoai where maPhim like :uid) and PhimTH.maPhim not like :uid order by ngayCongChieu desc";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    query.setParameter("uid", id);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public List<Phims> fillNavPHH(){
		String jpql = "select top 6 * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and loaiPhim = 0 order by ngayCongChieu desc";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public List<Phims> fillPageItem(int i, String s){
		int result = i*12;
		String jpql = "select * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and maTheLoai like :uid order by ngayCongChieu desc OFFSET "+result+" ROWS FETCH NEXT 12 ROWS ONLY";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    query.setParameter("uid", s);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public List<Phims> fillToType(int i, int id){
		int result = i*12;
		String jpql = "select * from Phim inner join PhimTH on Phim.maPhim = PhimTH.maPhim where hieuLuc = 1 and loaiPhim = ?0 order by ngayCongChieu desc OFFSET "+result+" ROWS FETCH NEXT 12 ROWS ONLY";
	    Query query = em.createNativeQuery(jpql, Phims.class);
	    query.setParameter(0, id);
	    List<Phims> list = query.getResultList();
	    return list;
	}
	
	public Long countPageItem(String s) {
		String jpql = "select count(o) from PhimTHs o where o.phims.hieuLuc = 1 and o.theloais.maTheLoai like :uid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("uid", s);
		long result = query.getSingleResult();
		return result;
	}
	
	public Long countPageItem2(boolean s) {
		String jpql = "select count(o) from PhimTHs o where o.phims.hieuLuc = 1 and o.loaiPhim = :uid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("uid", s);
		long result = query.getSingleResult();
		return result;
	}
	
	public List<Phims> findFilm(String s){
		String jpql = "select o from Phims o where o.Title like :uid";
		TypedQuery<Phims> query = em.createQuery(jpql, Phims.class);
		query.setParameter("uid", "%"+s+"%");
		List<Phims> list = query.getResultList();
		return list;
	}

}
