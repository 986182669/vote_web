package org.web.vote.service;

import org.web.vote.bean.Subject;
import org.web.vote.bean.User;
import org.web.vote.dao.UserDao;
import org.web.vote.dao.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    public UserDao uDao = new UserDaoImpl();
    public User u = null;
    public List list = new ArrayList();
    @Override
    public User getUser(User user) {
        return uDao.getUser(user);
    }

    @Override
    public int addUser(User user) {
        return uDao.addUser(user);
    }
}
