package com.catherine.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.catherine.bean.User;
import com.catherine.dao.UserDao;
import com.catherine.dao.UserDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class JdbcTest {
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void test(){
//		UserDao ud=new UserDaoImpl();
		User u=ud.selectUserById(3);
		System.out.println(u);
	}
	@Test
	public void test1(){
//		UserDao ud=new UserDaoImpl();
		User u=new User();
		u.setU_username("alice");
		u.setU_password("123123");
//		ud.saveUser(u);
		List<User> list=ud.selectAllUser();
		for(User us:list)
			System.out.println(us);
	}
	
	@Test
	public void test2(){
		User u=new User();
		u.setU_username("老王");
		u.setU_password("666");
		ud.saveUser(u);
	}
	@Test
	public void test3(){
		List<User> list=ud.selectAllUser();
		for(User us:list)
			System.out.println(us);
	}
	@Test
	public void test4(){
		User u=new User();
		u.setU_id(5);
		u.setU_username("老李");
		u.setU_password("888");
		ud.updateUser(u);
	}
	@Test
	public void test5(){
		System.out.println(ud.selectUserCount());
	}
}
