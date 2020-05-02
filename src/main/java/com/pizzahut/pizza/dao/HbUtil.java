package com.pizzahut.pizza.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
	private static SessionFactory factory = createSessionFactory();
	private static ServiceRegistry registry;
	
	public static SessionFactory createSessionFactory() {
		// create service registry
		registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		// create metadata
		Metadata metadata = new MetadataSources(registry)
				.getMetadataBuilder()
				.build();
		// create session factory
		return metadata.getSessionFactoryBuilder().build();
	}
		
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void shutdown() {
		factory.close();
	}
	
	public static Session getSession() {
		return factory.getCurrentSession();
	}

	// put this code into proxy class for tx mgmt
	public static void beginTransaction() {
		factory.getCurrentSession().beginTransaction();
	}
	
	public static void commitTransaction() {
		factory.getCurrentSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		factory.getCurrentSession().getTransaction().rollback();
	}
}
