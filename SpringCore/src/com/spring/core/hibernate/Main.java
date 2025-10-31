package com.spring.core.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.core.hibernate.model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Configuration configurtion=new Configuration().addAnnotatedClass(Student.class)
		.configure("hibernate.cfg.xml");
SessionFactory factory= configurtion.buildSessionFactory();
Session session =factory.getCurrentSession();
System.out.println(session);

	}

}
