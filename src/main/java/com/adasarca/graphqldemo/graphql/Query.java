package com.adasarca.graphqldemo.graphql;

import com.adasarca.graphqldemo.dao.LinkDao;
import com.adasarca.graphqldemo.dao.UserDao;
import com.adasarca.graphqldemo.dao.VoteDao;
import com.adasarca.graphqldemo.model.Link;
import com.adasarca.graphqldemo.model.User;
import com.adasarca.graphqldemo.model.Vote;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final LinkDao linkDao;
    private final UserDao userDao;
    private final VoteDao voteDao;

    public Query(LinkDao linkDao, UserDao userDao, VoteDao voteDao) {
        this.linkDao = linkDao;
        this.userDao = userDao;
        this.voteDao = voteDao;
    }

    public List<Link> allLinks() {
        return linkDao.getAll();
    }

    public List<User> allUsers() {
        return userDao.getAll();
    }

    public List<Vote> allVotes() {
        return voteDao.getAll();
    }

    public List<Vote> allVotes(Integer userId, Integer linkId) {
        if (null == userId) {
            if (null == linkId)
                return voteDao.getAll();
            else
                return voteDao.getByLinkId(linkId);
        } else {
            if (null == linkId)
                return voteDao.getByUserId(userId);
            else
                return voteDao.getByUserIdAndLinkId(userId, linkId);
        }
    }
}
