package com.gta.cardealer.service;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.gta.cardealer.models.Car;
import com.gta.cardealer.models.User;

@Service
public class LoginService {

	public boolean isUserValid(String username, String password)
	{
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
		
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
		
		Session session=new Configuration()
				.configure()
				.buildSessionFactory()
				.openSession();
		
		//Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from User");
        java.util.List list = query.list();
        Iterator iter = list.iterator();
		
//		User u1 = new User();
//		u1.setUsername("user2");
//		u1.setPassword("pass2");
        while(iter.hasNext())
        {
        	User u1 = (User) iter.next();

        	if(u1.getUsername().equals(username) && u1.getPassword().equals(password))
        	{
        		session.close();
        		return true;
        	}
        }
//		session.save(u1);
//		t.commit();
//		
		session.close();
		return false;
	}
	
}
