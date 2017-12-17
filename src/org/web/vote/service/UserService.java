package org.web.vote.service;

import org.web.vote.bean.Subject;
import org.web.vote.bean.User;

import java.util.List;

public interface UserService {
    User getUser(User user);
    int addUser(User user);
}
