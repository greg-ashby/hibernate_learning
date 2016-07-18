package com.gregashby.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static Object lock = new Object();
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			synchronized (lock) {
				if (sessionFactory == null) {
					try {
						Configuration configuration = new Configuration();
						configuration.configure("hibernate.cfg.xml");
						// TODO this didn't work with the standard <mapping
						// class=... />
						// it looks like there's a different way to build the
						// session factory when
						// using annotations... e.g. new
						// AnnotationConfiguration().configure()
						// .buildSessionFactory(); Look into the tutorials on
						// this guy's site, they seem better than the ones I was
						// using:
						// http://viralpatel.net/blogs/hibernate-many-to-many-annotation-mapping-tutorial/
						configuration.addAnnotatedClass(com.gregashby.hibernate.model.Employee.class);
						configuration.addAnnotatedClass(com.gregashby.hibernate.model.Department.class);
						ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
								.applySettings(configuration.getProperties()).build();
						sessionFactory = configuration.buildSessionFactory(serviceRegistry);
					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		}

		return sessionFactory;
	}

}
