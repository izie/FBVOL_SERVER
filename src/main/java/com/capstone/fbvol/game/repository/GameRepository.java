package com.capstone.fbvol.game.repository;

import java.util.List;

/**
 * Created by changmatthew on 2014. 4. 28..
 */
public interface GameRepository {
    public List<String> getMessage(int messageIndex);

    void addMessage(String message);
}
