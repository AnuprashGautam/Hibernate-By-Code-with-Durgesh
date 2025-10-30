package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		Person person = new Person();
		person.setName("Anuprash");
		person.setAddress("Meerut");
		person.setPhone("99999999");
		
		Transaction tx = openSession.beginTransaction();
		
		openSession.persist(person);
		
		tx.commit();
		openSession.close();
		sessionFactory.close();
	}
}
