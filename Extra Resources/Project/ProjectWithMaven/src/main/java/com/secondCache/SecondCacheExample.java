package com.secondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
	    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    
	    Session session1 = sessionFactory.openSession();
	    // Session 1
	    Student student1 = session1.get(Student.class, 1);
	    System.out.println(student1);
	    session1.close();
	    
	    Session session2 = sessionFactory.openSession();
	    // Session 1
	    Student student2 = session2.get(Student.class, 1);
	    System.out.println(student2);
	    session2.close();
	    
	    sessionFactory.close();
	}
}
