package com.spring.core.task1;
import com.spring.core.task2.AppConfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import com.spring.core.task2.AccountServiceImpl;
 public class MainClass {

	public static void main(String[] args) {
//						task 1-1
//BeanFactory factory= new XmlBeanFactory(new PathResource("D:\\eclipse-projects\\SpringCore\\src\\beans.xml")) ;
//MangerService manger=	(MangerService)factory.getBean("MangerService");
//manger.save("ali");
//manger.update("moo");
//						task 1-2
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        UserService person = (UserService) context.getBean("personService");
//        UserService manger = (UserService) context.getBean("mangerService");
//        person.save("ali");
//        manger.update("moo");

//						task 2-1
//		BeanFactory factory= new XmlBeanFactory(new PathResource("D:\\eclipse-projects\\spring-course\\SpringCore\\src\\beans.xml"));
//		AccountServiceImpl	account=(AccountServiceImpl)factory.getBean("AccountServiceImpl");
//		account.getSavePerson("mood");
//						task 2-2
//		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
//		AccountServiceImpl	account=	(AccountServiceImpl)context.getBean("accountService");
//		account.getSavePerson("mood Context");
		
//						task 3-1
//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		com.spring.core.task3.UserService	user=(com.spring.core.task3.UserService)context.getBean("PersonService");
//		user.save("moo3");
//		context.close();// بس الـ destroy method مش هتشتغل تلقائي لأن scope = prototype
		
//						task 3-2
		
	AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(com.spring.core.task3.AppConfig.class);
     com.spring.core.task3.UserService person = (com.spring.core.task3.UserService ) context.getBean("personService");
     person.save("moo3-2");
     context.close();


	
	}

}
