package com.adasarca.graphqldemo.dao;

import com.adasarca.graphqldemo.model.Link;

import java.util.*;

public class LinkDao {

    private final TreeMap<Integer, Link> linkMap;

    public LinkDao() {
        linkMap = new TreeMap<>();
        linkMap.put(1, new Link(1, "http://howtographql.com", "Your favorite GraphQL page", 1));
        linkMap.put(2, new Link(2, "http://graphql.org/learn/", "The official docks", 2));
    }

    public List<Link> getAll() {
        return new LinkedList<>(linkMap.values());
    }

    public Link getById(int id) {
        return linkMap.get(id);
    }

    public Link save(Link link) {
        if (link.getId() == 0 || !linkMap.containsKey(link.getId())) {
            link.setId(linkMap.lastKey() + 1);
        }
        linkMap.put(link.getId(), link);
        return link;
    }
}
