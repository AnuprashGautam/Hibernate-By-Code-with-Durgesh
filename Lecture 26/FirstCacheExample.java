package com.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstCacheExample {
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		Student student = openSession.get(Student.class, 1);
		System.out.println(student);
		
		System.out.println("Doing some work...");

		Student student1 = openSession.get(Student.class, 1);
		System.out.println(student1);
		
		openSession.close();
		sessionFactory.close();
	}
}
