package org.web.vote.service;

import org.web.vote.bean.Option;
import org.web.vote.bean.Subject;
import org.web.vote.bean.Vote;
import org.web.vote.dao.VoteDao;
import org.web.vote.dao.VoteDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class VoteServiceImpl implements VoteService{
    public VoteDao vDao = new VoteDaoImpl();
    public List list = new ArrayList();
    @Override
    public List<Subject> getListAll() {
        list = vDao.getListAll();
        for (Object object:list) {
            Subject sub = (Subject)object;
            System.out.println(sub.toString());
        }
        return list;
    }

    @Override
    public List<Option> getListAll(int id) {
        list = vDao.getListAll(id);
        System.out.println(list.toString()+"-------------------------");
        return list;
    }

    @Override
    public int addVote(Vote vote) {
        return vDao.doVote(vote);
    }

    @Override
    public int addNewVote(Subject subject) {
        return vDao.addNewVote(subject);
    }
}
