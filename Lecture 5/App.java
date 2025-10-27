package com.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project working..." );
        
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        
        Student std=new Student();
        std.setName("Anuprash");
        std.setCity("Meerut");
        
        Session session = factory.openSession();
        
        Transaction tx=session.beginTransaction();
        session.persist(std);
        tx.commit();
        
        session.close();  
    }
}
