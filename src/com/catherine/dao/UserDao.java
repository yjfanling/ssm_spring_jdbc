package com.catherine.dao;

import java.util.List;

import com.catherine.bean.User;

public interface UserDao {
	//��
	public void saveUser(User u);
	//ɾ
	public void deleteUserById(Integer id);
	//��
	public void updateUser(User u);
	//��
	//����id�����û� 
	public User selectUserById(Integer id);
	//����ȫ���û�List
	public List<User> selectAllUser();
	//�����û�����
	public Integer selectUserCount();
}
