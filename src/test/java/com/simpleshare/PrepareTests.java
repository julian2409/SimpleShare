package com.simpleshare;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.simpleshare.dao.DaoManager;

public class PrepareTests {
	
	@Test
	public void clearDB() {
		initDatabase();
	}
	
	public static void initDatabase() {
		DaoManager dm = DaoManager.getInstance();
		EntityManager em = dm.getEntityManager();
		
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		try {
			em.createNativeQuery("DELETE FROM USER_ACCOUNT").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			em.createNativeQuery("DELETE FROM FILE_DATA").executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			em.createNativeQuery("DELETE FROM ACCESS_ITEM").executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		em.getTransaction().commit();
	}
}