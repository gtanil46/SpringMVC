package com.gta.cardealer.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.gta.cardealer.models.Car;

@Service
public class CarService {
	public java.util.List<Car> getCars() {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
		
		Session session=new Configuration()
				.configure()
				.buildSessionFactory()
				.openSession();
        
        Query query = session.createQuery("from Car");
        java.util.List list = query.list();
        Iterator iter = list.iterator();
        
        java.util.List<Car> al = new ArrayList<Car>();
        while(iter.hasNext())
        {
        	al.add((Car)iter.next());
        	//Car c = (Car) iter.next();
        	//System.out.println(c.toString());
        }
        session.close();
        System.out.println("Successful");
        return al;
		
	}
}
