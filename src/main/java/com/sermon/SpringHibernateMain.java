package com.sermon;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sermon.dao.OrdenDao;
import com.sermon.model.Orden;

public class SpringHibernateMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");

        OrdenDao dao = (OrdenDao) context.getBean(OrdenDao.class);
        List<Orden> ordens = dao.getOrden();
        for (Orden orden: ordens) {
            System.out.println(orden.getId() + ", " + orden.getDescription());
        }
        //close resources
        context.close();
    }
}
