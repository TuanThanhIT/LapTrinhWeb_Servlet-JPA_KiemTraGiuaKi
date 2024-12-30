package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {
	public static void main(String[] args) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			trans.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 trans.rollback();
			 throw e;
		 }finally {
			 enma.close();


		 }
	}
}
