package com.tut;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project working..." );
        
//        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        
//        System.out.println(factory);
//        
//        Student std=new Student();
//        std.setName("Anuprash");
//        std.setCity("Meerut");
//        
//        Address add= new Address();
//        add.setStreet("Ram Vihar");
//        add.setCity("Jaipur");
//        add.setOpen(true);
//        add.setX(123.4);
//        add.setAddedDate(new Date());
//        
//        FileInputStream fis= new FileInputStream("src/main/java/com/tut/image.jpg");
//        byte[] data= new byte[fis.available()];
//        fis.read(data);
//        
//        add.setImage(data);
//        
//        
//        Session session = factory.openSession();
//        
//        Transaction tx=session.beginTransaction();
//        session.persist(std);
//        session.persist(add);
//        tx.commit();
//        
//        session.close();  
    }
}
