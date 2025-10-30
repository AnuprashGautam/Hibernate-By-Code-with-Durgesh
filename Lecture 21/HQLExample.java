package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
//		1. SELECTING THE DATA
		
//		Student student= (Student) query.uniqueResult(); // Fetching the single entity
		List<Student> list = query.list();
		
		for(Student std: list)
		{
			System.out.println(std.getName()+" : "+std.getCity());
		}
		
		Transaction tx=openSession.beginTransaction();
		
//		2.	DELETEING THE DATA
		
		Query query1=openSession.createQuery("delete from Student as s where s.city=:c");
		query1.setParameter("c", "Abc");
		
		int affectedRows = query1.executeUpdate();
		
		System.out.println("DELETED ROWS: "+affectedRows);
		
//		3. 	UPDATE QUERY
		
		Query query2=openSession.createQuery("update Student set city=:c where name=:n");
		query2.setParameter("c", "Pune");
		query2.setParameter("n", "Anuprash");
		int affectedRows1 = query2.executeUpdate();
		
		System.out.println("UPDATED ROWS: "+affectedRows1);
		
//		4. JOIN QUERY
		
		Query query3=openSession.createQuery("select q.questionId, q.question, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object[]> list2 = query3.list();
		
		for(Object[] objArr: list2)
		{
			System.out.println(Arrays.toString(objArr));
		}
				
		
		tx.commit();
		openSession.close();
		sessionFactory.close();
	}
}
