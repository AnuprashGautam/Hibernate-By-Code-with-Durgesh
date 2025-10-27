package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmbeddingDemo {
	public static void main(String[] args)
	{
      SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
      
      Student std=new Student();
      std.setName("Anuprash");
      std.setCity("Meerut");
      Certificate certi1=new Certificate();
      certi1.setCourse("Java");
      certi1.setDuration("2 month");
      std.setCertificate(certi1);
      
      
      Student std1=new Student();
      std1.setName("Anubhav");
      std1.setCity("Muzaffarnagar");
      Certificate certi2=new Certificate();
      certi2.setCourse("Python");
      certi2.setDuration("1.5 month");
      std1.setCertificate(certi2);
      
      Session openSession = factory.openSession();
      
      Transaction tx=openSession.beginTransaction();
      
      openSession.persist(std);
      openSession.persist(std1);
      
      tx.commit();
      openSession.close();
      factory.close();
	}
}
