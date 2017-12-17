package org.web.vote.service;

import org.web.vote.bean.Option;
import org.web.vote.bean.Subject;
import org.web.vote.bean.Vote;

import java.util.List;

public interface VoteService {
    public List<Subject> getListAll();
    public List<Option> getListAll(int id);
    public int addVote(Vote vote);
    public int addNewVote(Subject subject);
}
