package com.adasarca.graphqldemo.dao;

import com.adasarca.graphqldemo.model.Vote;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class VoteDao {

    private final TreeMap<Integer, Vote> voteMap;

    public VoteDao() {
        this.voteMap = new TreeMap<>();
    }

    public List<Vote> getAll() {
        return new LinkedList<>(voteMap.values());
    }

    public List<Vote> getByUserId(int userId) {
        List<Vote> votes = new LinkedList<>();
        for (Vote vote : voteMap.values())
            if (userId == vote.getUserId())
                votes.add(vote);
        return votes;
    }

    public List<Vote> getByLinkId(int linkId) {
        List<Vote> votes = new LinkedList<>();
        for (Vote vote : voteMap.values())
            if (linkId == vote.getLinkId())
                votes.add(vote);
        return votes;
    }

    public List<Vote> getByUserIdAndLinkId(int userId, int linkId) {
        List<Vote> votes = new LinkedList<>();
        for (Vote vote : voteMap.values())
            if (linkId == vote.getLinkId() && userId == vote.getUserId())
                votes.add(vote);
        return votes;
    }

    public Vote save(Vote vote) {
        if (vote.getId() == 0 || !voteMap.containsKey(vote.getId()))
            vote.setId((voteMap.isEmpty() ? 0 : voteMap.lastKey()) + 1);
        vote.setCreatedAt(Instant.now().atZone(ZoneOffset.UTC));
        voteMap.put(vote.getId(), vote);
        return vote;
    }
}
