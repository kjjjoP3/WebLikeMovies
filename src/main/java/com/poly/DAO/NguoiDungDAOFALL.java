package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.Entity.NguoiDungs;
import com.poly.Utils.JpaUtils;


public class NguoiDungDAOFALL {

	public void insert(NguoiDungs user) {
		  EntityManager em=JpaUtils.getEntityManager();
		  
		  EntityTransaction trans=em.getTransaction();
		  try {
			trans.begin();
			
			em.persist(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	  }
	  public void update(NguoiDungs user) {
		  EntityManager em=JpaUtils.getEntityManager();
		  
		  EntityTransaction trans=em.getTransaction();
		  try {
			trans.begin();
			
			em.merge(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	  }
	  public void delete(String tenDN) {
		  EntityManager em=JpaUtils.getEntityManager();
		  
		  EntityTransaction trans=em.getTransaction();
		  try {
			trans.begin();
			
			NguoiDungs user=em.find(NguoiDungs.class,tenDN);
			if(user!=null) {
				em.remove(user);
			}else {
				throw new Exception("Can not found to delete");
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	  }
	  public NguoiDungs findById(String tenDN) {
		  EntityManager em=JpaUtils.getEntityManager();
			NguoiDungs user=em.find(NguoiDungs.class,tenDN);
			return user;
	  }
	  
	  public List<NguoiDungs> findAll(){
		  EntityManager em=JpaUtils.getEntityManager();
		  TypedQuery<NguoiDungs> query=em.createNamedQuery("User.findAll",NguoiDungs.class);
		  return query.getResultList();
	  }
	  
	  
	
}
