package org.web.vote.dao;

import org.web.vote.bean.Subject;
import org.web.vote.bean.User;

import java.util.List;

public interface UserDao {
    public User getUser(User user);
    public int addUser(User user);
}
