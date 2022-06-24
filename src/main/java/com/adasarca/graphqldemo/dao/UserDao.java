package com.adasarca.graphqldemo.dao;

import com.adasarca.graphqldemo.model.User;

import java.util.*;

public class UserDao {

    private final TreeMap<Integer, User> userMap;

    public UserDao() {
        this.userMap = new TreeMap<>();
        userMap.put(1, new User(1, "Tom Cruise", "tom@ness.com"));
        userMap.put(2, new User(2, "Albert Einstein", "einstein@ness.com"));
        userMap.put(3, new User(3, "Thomas Edison", "thomas@ness.com"));
    }

    public List<User> getAll() {
        return new LinkedList<>(this.userMap.values());
    }

    public User getById(int id) {
        return this.userMap.get(id);
    }

    public User save(User user) {
        if (user.getId() == 0 || !userMap.containsKey(user.getId()))
            user.setId(userMap.lastKey() + 1);
        this.userMap.put(user.getId(), user);
        return user;
    }
}
