package com.capstone.fbvol.user.service;

import com.capstone.fbvol.user.dao.UserInfoMapper;
import com.capstone.fbvol.model.Entity;
import com.capstone.fbvol.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by changmatthew on 2014. 3. 31..
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final List<Character> users = new CopyOnWriteArrayList<Character>();

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User getUserInfo(Entity param) {
        logger.info("LoginService - getUserInfo()");
        //User temp = userInfoMapper.selectUserOne(param);
        return userInfoMapper.selectUserOne(param);
    }

    @Override
    public List<User> getUsers() {
        return userInfoMapper.getList();
    }

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
