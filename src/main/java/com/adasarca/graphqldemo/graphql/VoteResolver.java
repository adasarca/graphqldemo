package com.adasarca.graphqldemo.graphql;

import com.adasarca.graphqldemo.dao.LinkDao;
import com.adasarca.graphqldemo.dao.UserDao;
import com.adasarca.graphqldemo.model.Link;
import com.adasarca.graphqldemo.model.User;
import com.adasarca.graphqldemo.model.Vote;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class VoteResolver implements GraphQLResolver<Vote> {

    private final UserDao userDao;
    private final LinkDao linkDao;

    public VoteResolver(UserDao userDao, LinkDao linkDao) {
        this.userDao = userDao;
        this.linkDao = linkDao;
    }

    public User user(Vote vote) {
        return userDao.getById(vote.getUserId());
    }

    public Link link(Vote vote) {
        return linkDao.getById(vote.getLinkId());
    }
}
