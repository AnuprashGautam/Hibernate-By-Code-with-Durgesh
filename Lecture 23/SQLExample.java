package com.sqlExample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		NativeQuery nativeSqlQuery= openSession.createNativeQuery("select * from student", Student.class);
		
		List<Student> list = nativeSqlQuery.list();
		
		for(Student std: list)
		{
			System.out.println(std);
		}
		
		openSession.close();
		sessionFactory.close();
	}
}
