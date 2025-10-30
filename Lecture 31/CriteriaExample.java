package com.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.restriction.Restriction;

import com.tut.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		// Step 1: Create CriteriaBuilder
		CriteriaBuilder cb = openSession.getCriteriaBuilder();

        // Step 2: Create CriteriaQuery for Student class
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        // Step 3: Define the FROM clause and other restrictions
        Root<Student> root = cq.from(Student.class);

        // Step 4: Select all records
        cq.select(root);

        // Step 5: Execute query
        List<Student> students = openSession.createQuery(cq).getResultList();

        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getCity());
        }
		
		
		openSession.close();
		sessionFactory.close();
	}
}
