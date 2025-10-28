package com.tut;

import java.lang.module.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FetchDataDemo {
	public static void main (String[] args)
	{
		SessionFactory sessionFactory= new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		// get() method
		Student std= (Student) session.get(Student.class, 0);
		System.out.println(std);
		
		Student std1= (Student) session.get(Student.class, 0);
		System.out.println(std1);
		
		// load() method
//		Student std10=(Student) session.load(Student.class, 1);
//		System.out.println(std10);
		
		session.close();
		sessionFactory.close();
	}
}
