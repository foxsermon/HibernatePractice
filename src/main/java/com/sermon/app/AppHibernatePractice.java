package com.sermon.app;

import org.hibernate.Session;

import com.sermon.model.User;
import com.sermon.util.HibernateUtil;

public class AppHibernatePractice {

	public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        //User user = (User) session.load(User.class, new Integer(13));
        User user = (User) session.get(User.class, new Integer(13));
        System.out.println(user.getId() + ", " + user.getName());
        
        //session.save(stock);
        
        //session.delete(stock);
        
        session.getTransaction().commit();
	}
}
