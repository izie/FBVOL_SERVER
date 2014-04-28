package com.capstone.fbvol.game.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by changmatthew on 2014. 4. 28..
 */
@Repository
public class GameRepositoryImpl implements  GameRepository {

    private final List<String> messages = new CopyOnWriteArrayList<String>();

    @Override
    public List<String> getMessage(int index) {
        if (this.messages.isEmpty()) {
            return Collections.<String> emptyList();
        }
        Assert.isTrue((index >= 0) && (index <= this.messages.size()), "Invalid message index");
        return this.messages.subList(index, this.messages.size());
    }

    @Override
    public void addMessage(String message) {
        this.messages.add(message);
    }
}
