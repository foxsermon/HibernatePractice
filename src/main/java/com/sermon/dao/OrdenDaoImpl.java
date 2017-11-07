package com.sermon.dao;

import com.sermon.model.Orden;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrdenDaoImpl implements OrdenDao {

    @Autowired
    private SessionFactory sessionFactory;

    //@Transactional( isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER)
    public Orden getOrden(Integer id) {
        Session session = sessionFactory.openSession();
        Orden orden = (Orden) session.get(Orden.class, id);
        session.close();
        return orden;
    }
    
    @Transactional( isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public List<Orden> getOrden() {
        Session session = sessionFactory.openSession();
        List<Orden> ordens = session.createQuery("from Orden").list();
        session.close();
        return ordens;
    }
}
