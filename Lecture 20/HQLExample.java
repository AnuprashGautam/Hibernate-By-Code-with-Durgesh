package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		String q="from Student as s where s.name=:n and s.city='Muzaffarnagar'";
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		Query query=openSession.createQuery(q);
		query.setParameter("n", "Anuprash");
		
//		Student student= (Student) query.uniqueResult(); // Fetching the single entity
		List<Student> list = query.list();
		
		for(Student std: list)
		{
			System.out.println(std.getName()+" : "+std.getCity());
		}
		
		openSession.close();
		sessionFactory.close();
	}
}
