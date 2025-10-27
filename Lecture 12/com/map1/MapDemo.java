package com.map1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {
	public static void main(String[] args)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		
		Emp e1=new Emp();
		e1.seteId(12);
		e1.seteName("Ram");
		
		Emp e2=new Emp();
		e2.seteId(13);
		e2.seteName("Shyam");
		
		
		Project p1=new Project();
		p1.setpId(2);
		p1.setProjectName("Library Management");
		
		Project p2=new Project();
		p2.setpId(3);
		p2.setProjectName("Chatbot");
		
		e1.setProjects(List.of(p1));
		e2.setProjects(List.of(p1,p2));
		
		p1.setEmployees(List.of(e1,e2));
		p2.setEmployees(List.of(e2));
		
		Transaction tx=session.beginTransaction();
		
		session.persist(e1);
		session.persist(e2);
		session.persist(p1);
		session.persist(p2);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
