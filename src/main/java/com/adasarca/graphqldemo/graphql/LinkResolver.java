package com.adasarca.graphqldemo.graphql;

import com.adasarca.graphqldemo.model.Link;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.adasarca.graphqldemo.dao.UserDao;
import com.adasarca.graphqldemo.model.User;

public class LinkResolver implements GraphQLResolver<Link> {
    private final UserDao userDao;

    public LinkResolver(UserDao userDao) {
        this.userDao = userDao;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userDao.getById(link.getUserId());
    }
}
