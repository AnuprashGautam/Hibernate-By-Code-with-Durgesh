package com.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadingExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction tx = openSession.beginTransaction();
		
		// CASCADING
		
		Question q= new Question();
		q.setQuestionId(3001);
		q.setQuestion("What is cascading?");
		
		List<Answer> answers=new ArrayList();
		Answer ans1=new Answer();
		ans1.setAnswerId(2001);
		ans1.setAnswer("Help in making the child object by its own.");
		answers.add(ans1);
		
		Answer ans2=new Answer();
		ans2.setAnswerId(2002);
		ans2.setAnswer("It is of 3 types.");
		answers.add(ans2);
		
		q.setAnswers(answers);
		
		openSession.persist(q);
		
		tx.commit();
		openSession.close();
		sessionFactory.close();
	}
}
