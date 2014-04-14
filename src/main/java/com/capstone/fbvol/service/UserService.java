package com.capstone.fbvol.service;

import com.capstone.fbvol.model.*;
import com.capstone.fbvol.model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by changmatthew on 2014. 3. 31..
 */

public interface UserService {
    List<Character> getUsers(int idx);
    void setUsers(Character user);
    public User getUserInfo(Entity param);
    public List<User> getUsers();
}
