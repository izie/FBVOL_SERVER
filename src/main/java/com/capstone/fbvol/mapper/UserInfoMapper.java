package com.capstone.fbvol.mapper;

import com.capstone.fbvol.model.Entity;
import com.capstone.fbvol.model.User;

import java.util.List;

public interface UserInfoMapper {
	public User selectUserOne(Entity param);

    public List<User> getList();
}
