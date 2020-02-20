package com.tef.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		
		try {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("app-server");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static  EntityManager getConnection() {		
		return factory.createEntityManager();		
	}

}
