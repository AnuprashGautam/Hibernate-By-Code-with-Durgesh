package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StatesDemo {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").configure().buildSessionFactory();
		
		// Making the Student object
		Student std=new Student();
		std.setId(1999);
		std.setName("Bunty");
		std.setCity("Muzaffarnagar");
		std.setCertificate(new Certificate("PCM", "1 year"));
		// TRANSIENT STATE
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.persist(std);
		// PERSISTENT STATE
				
		Student fetchedStudent=session.get(Student.class, 1999 );
		System.out.println("Old Object: "+fetchedStudent);
		
		std.setName("Anuprash");
		
		Student fetchedStudent1=session.get(Student.class, 1999 );
		System.out.println("New Object: "+fetchedStudent1);
		
		session.remove(std);
		// REMOVED STATE
		
		Student fetchedStudent2=session.get(Student.class, 1999 );
		System.out.println("After Detaching: "+fetchedStudent2);

		tx.commit();
		session.clear();
//		session.close();
		
		std.setName("Anuprash Gautam");
		// DETACHED STATE
		
		factory.close();
	}
}
