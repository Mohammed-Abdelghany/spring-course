package com.spring.core.task1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.PathResource;

import com.spring.core.task2.AccountServiceImpl;
 public class MainClass {

	public static void main(String[] args) {
//						task 1-1
//BeanFactory factory= new XmlBeanFactory(new PathResource("D:\\eclipse-projects\\SpringCore\\src\\beans.xml")) ;
//MangerService manger=	(MangerService)factory.getBean("MangerService");
//manger.save("ali");
//manger.update("moo");
//						task 1-2
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        UserService person = (UserService) context.getBean("personService");
//        UserService manger = (UserService) context.getBean("mangerService");
//        person.save("ali");
//        manger.update("moo");

//						task 2-1
		BeanFactory factory= new XmlBeanFactory(new PathResource("D:\\eclipse-projects\\spring-course\\SpringCore\\src\\beans.xml"));
		AccountServiceImpl	account=(AccountServiceImpl)factory.getBean("AccountServiceImpl");
		account.getSavePerson("mood");


	}

}
