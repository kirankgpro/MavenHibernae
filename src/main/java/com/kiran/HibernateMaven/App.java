package com.kiran.HibernateMaven;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kiran.HibernateMaven.domain.UserInfo;
import com.kiran.HibernateMaven.domain.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{ 
	static Session session;
	static SessionFactory sessionFactory ;
    public static void main( String[] args )
    {
      try {
		UserInfo userInfo = new UserInfo();
		  Vehicle vehicle = new Vehicle();
		  Vehicle vehicle2 = new Vehicle();
		  
		  vehicle.setVehicleName("cool");
		  vehicle2.setVehicleName("kiran");
		  vehicle.setUserr(userInfo);
		  vehicle2.setUserr(userInfo);
		   
		   userInfo.setFirstName("kiran");
		   userInfo.setLastName("kg");
		   userInfo.getVehicle().add(vehicle);
		   userInfo.getVehicle().add(vehicle2);
		   
		    sessionFactory = new Configuration().configure().buildSessionFactory();
		    session = sessionFactory.openSession();
		   session.beginTransaction();
		   session.save(userInfo);
		   //session.save(vehicle);
		   //session.save(vehicle2);
		   
		   //session.save(vehicle);
		   session.getTransaction().commit();
		   
		   UserInfo user= session.get(UserInfo.class, 1);
		   
		   Collection collection = user.getVehicle();
		   Iterator it =collection.iterator();
		   while(it.hasNext()) {
			   Vehicle veh=(Vehicle)it.next();
			   System.out.println(veh.getVehicleName());
		   }
		   
		   
		   session.close();
		   sessionFactory.close();
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
	}
      finally {
    	  session.close();
		   sessionFactory.close();
	}
    }
}
