package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {
	public static void main(String[] args)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		
		// Creating the question1 and its answer1
		Question q1=new Question();
		q1.setQuestionId(11);
		q1.setQuestion("What is Java?");
		
		Answer a1=new Answer();
		a1.setAnswerId(111);
		a1.setAnswer("It is a backend language.");
		a1.setQuestion(q1);
		q1.setAnswer(a1);
		
		// Creating the question2 and its answer2
		Question q2=new Question();
		q2.setQuestionId(12);
		q2.setQuestion("What is HTML?");
		
		Answer a2=new Answer();
		a2.setAnswerId(112);
		a2.setAnswer("It is a frontend language.");
		a2.setQuestion(q2);
		q2.setAnswer(a2);
		
		// Now saving the questions and answers
		
		Transaction tx=session.beginTransaction();
		
		session.persist(q1);
		session.persist(a1);
		session.persist(q2);
		session.persist(a2);
		
		tx.commit();
		
		// Now fetching the data using get()
		
		Question firstQuestion=(Question) session.get(Question.class, 11);
		System.out.println(firstQuestion.getQuestion());
		System.out.println(firstQuestion.getAnswer().getAnswer());
		
		Question secondQuestion=(Question) session.get(Question.class, 12);
		System.out.println(secondQuestion.getQuestion());
		System.out.println(secondQuestion.getAnswer().getAnswer());
	
		session.close();
		factory.close();
	}
}
