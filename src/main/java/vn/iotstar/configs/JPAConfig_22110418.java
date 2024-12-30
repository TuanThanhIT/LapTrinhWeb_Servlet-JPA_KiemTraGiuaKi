package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig_22110418 {
	public static EntityManager getEntityManager() 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dataSource");
		return factory.createEntityManager();
	}
}
