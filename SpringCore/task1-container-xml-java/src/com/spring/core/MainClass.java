package com.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.PathResource;
 

public class MainClass {

	public static void main(String[] args) {
//						task 1-1
//BeanFactory factory= new XmlBeanFactory(new PathResource("D:\\eclipse-projects\\SpringCore\\src\\beans.xml")) ;
//MangerService manger=	(MangerService)factory.getBean("MangerService");
//manger.save("ali");
//manger.update("moo");
//						task 1-2
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService person = (UserService) context.getBean("personService");
        UserService manger = (UserService) context.getBean("mangerService");
        person.save("ali");
        person.update("moo");




	}

}
