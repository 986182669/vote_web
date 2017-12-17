package org.web.vote.dao;

import org.web.vote.bean.Option;
import org.web.vote.bean.Subject;
import org.web.vote.bean.Vote;

import java.sql.SQLException;
import java.util.List;

public interface VoteDao {
    public List<Subject> getListAll();
    public List<Option> getListAll(int id);
    public void toVote(Vote vote);
    public int doVote(Vote vote);
    public int addNewVote(Subject subject);
}
