package com.spring.core.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.core.hibernate.model.Player;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Configuration configurtion=new Configuration().addAnnotatedClass(Player.class)
		.configure("hibernate.cfg.xml");
SessionFactory factory= configurtion.buildSessionFactory();
Session session =factory.getCurrentSession();
session.beginTransaction();
Player p1 = new Player("Mohamed", 25, true);
session.save(p1);
session.getTransaction().commit();
System.out.println("Player saved: " + p1);
// Update
session = factory.getCurrentSession();
session.beginTransaction();
p1.setName("Mohamed Updated");
p1.setAge(26);
session.update(p1);
session.getTransaction().commit();
System.out.println(" Player updated: " + p1);
// Get by ID
session = factory.getCurrentSession();
session.beginTransaction();
Player found = session.get(Player.class, p1.getId());
System.out.println("Player found: " + found);
session.getTransaction().commit();
// Delete
session = factory.getCurrentSession();
session.beginTransaction();
session.delete(found);
session.getTransaction().commit();
System.out.println("Player deleted.");
factory.close();
}
	}


