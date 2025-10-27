package com.map;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {
	@SuppressWarnings("removal")
	public static void main(String[] args)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		
		// Creating the question with multiple answers
		Question q1=new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java?");
		
		Answer a1=new Answer();
		a1.setAnswerId(101);
		a1.setAnswer("It is a backend language.");
		a1.setQuestion(q1);
		
		
		Answer a2=new Answer();
		a2.setAnswerId(102);
		a2.setAnswer("It is a strongly typed language.");
		a2.setQuestion(q1);
		
		Answer a3=new Answer();
		a3.setAnswerId(103);
		a3.setAnswer("It is a multithreaded language.");
		a3.setQuestion(q1);
		
		q1.setAnswers(List.of(a1,a2,a3));
		
		// Now saving the questions and answers
		
//		Transaction tx=session.beginTransaction();
//		
//		session.persist(q1);
//		session.persist(a1);
//		session.persist(a2);
//		session.persist(a3);
//		
//		tx.commit();
		
		// Now fetching the data using get()
		
		Question question =(Question) session.get(Question.class, 1);
		
		System.out.println(question.getQuestion());
		
		System.out.println(question.getAnswers().size());
		
//		
//		for(Answer a: question.getAnswers())
//		{
//			System.out.println(a.getAnswer());
//		}
		
		session.close();
		factory.close();
	}
}
