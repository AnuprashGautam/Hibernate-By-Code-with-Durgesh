package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		Query<Student> query = openSession.createQuery("from Student", Student.class);
		
		System.out.println("-------------------------------------------------------");
		int order=0;
		for(int i=0; i<=15; i=i+5)
		{
			query.setFirstResult(0+i);
			query.setMaxResults(5);
			
			List<Student> list = query.list();
			for(Student std: list)
			{
				System.out.println(order++ +"----"+std.getName()+"----"+std.getCity());
			}
			System.out.println("--------------------------------------------------------");
		}
		
		query.list();
		openSession.close();
		sessionFactory.close();
	}
}
