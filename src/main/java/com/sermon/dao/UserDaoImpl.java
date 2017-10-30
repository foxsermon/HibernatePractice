package com.sermon.dao;

import com.sermon.model.UserRemote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional( isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER)
    public UserRemote getUser(String username) {
        Session session = sessionFactory.openSession();
        UserRemote user = (UserRemote) session.get(UserRemote.class, username);
        session.close();
        return user;
    }

    public void createUser(UserRemote user) {

    }

    public void updateUser(UserRemote user) {

    }

    public void deleteUser(UserRemote user) {

    }

    @Transactional( isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER)
    public List<UserRemote> getUsers() {
        Session session = sessionFactory.openSession();
        List<UserRemote> users = session.createQuery("from UserRemote").list();
        session.close();
        return users;
    }
}
