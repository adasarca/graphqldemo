package com.adasarca.graphqldemo.graphql;

import com.adasarca.graphqldemo.dao.LinkDao;
import com.adasarca.graphqldemo.dao.UserDao;
import com.adasarca.graphqldemo.dao.VoteDao;
import com.adasarca.graphqldemo.model.Link;
import com.adasarca.graphqldemo.model.User;
import com.adasarca.graphqldemo.model.Vote;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Mutation implements GraphQLRootResolver {

    private final LinkDao linkDao;
    private final UserDao userDao;
    private final VoteDao voteDao;

    public Mutation(LinkDao linkDao, UserDao userDao, VoteDao voteDao) {
        this.linkDao = linkDao;
        this.userDao = userDao;
        this.voteDao = voteDao;
    }

    public Link createLink(String url, String description, Integer postedBy) {
        Link newLink = new Link(url, description, postedBy);
        return linkDao.save(newLink);
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        return this.userDao.save(user);
    }

    public Vote createVote(int linkId, int voteId) {
        Vote vote = new Vote(linkId, voteId);
        return this.voteDao.save(vote);
    }
}
