package com.sermon;

import com.sermon.dao.UserDao;
import com.sermon.model.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");

        UserDao dao = (UserDao) context.getBean(UserDao.class);
        List<UserRemote> users = dao.getUsers();
        for (UserRemote user: users) {
            System.out.println(user.getUsername() + ", " + user.getName());
        }
        UserRemote user = dao.getUser("foxsermon");
        System.out.println(user.getUsername());
        //close resources
        context.close();
    }
}
