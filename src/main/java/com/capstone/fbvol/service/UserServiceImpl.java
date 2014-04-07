package com.capstone.fbvol.service;

import com.capstone.fbvol.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by changmatthew on 2014. 3. 31..
 */
@Repository
public class UserServiceImpl implements UserService {

    private final List<Character> users = new CopyOnWriteArrayList<Character>();


    public List<Character> getUsers(int idx) {
        if(this.users.isEmpty()){
            return Collections.emptyList();
        }

        Assert.isTrue((idx >= 0) && (idx <= this.users.size()), "Invalid message index");

        return this.users.subList(idx, this.users.size());
    }


    public void setUsers(Character user) {
        this.users.add(user);
    }
}
