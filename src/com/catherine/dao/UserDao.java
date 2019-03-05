package com.catherine.dao;

import java.util.List;

import com.catherine.bean.User;

public interface UserDao {
	//增
	public void saveUser(User u);
	//删
	public void deleteUserById(Integer id);
	//改
	public void updateUser(User u);
	//查
	//根据id查找用户 
	public User selectUserById(Integer id);
	//查找全部用户List
	public List<User> selectAllUser();
	//查找用户数量
	public Integer selectUserCount();
}
