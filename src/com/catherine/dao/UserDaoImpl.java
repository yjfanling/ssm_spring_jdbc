package com.catherine.dao;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.catherine.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	//private static ComboPooledDataSource dataSource;
//	JdbcTemplate jt=new JdbcTemplate(dataSource);
//	 JdbcTemplate jt;
//	static{
//	//连接数据库(c3p0)
//		try{
//			dataSource=new ComboPooledDataSource();
//			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_spring?serverTimezone=GMT");
//			dataSource.setUser("root");
//			dataSource.setPassword("951106");
//		}catch(PropertyVetoException e)
//		{
//			e.printStackTrace();
//		}
//	}
	
//	public void setJt(JdbcTemplate jt) {
//		this.jt = jt;
//	}
	//根据id查找用户
	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from user where u_id=?";
		User user=getJdbcTemplate().queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				User u=new User();
				u.setU_id(rs.getInt("u_id"));
				u.setU_username(rs.getString("u_username"));
				u.setU_password(rs.getString("u_password"));
				return u;
			}
			
		},id);
		return user;
	}
	//添加用户
	@Override
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,?,?)";
		getJdbcTemplate().update(sql,u.getU_username(),u.getU_password());
	}
	//根据id删除用户
	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete from user where u_id=?";
		getJdbcTemplate().update(sql,id);
	}
	//更新用户
	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		String sql="update user set u_username=?,u_password=? where u_id=?";
		getJdbcTemplate().update(sql,u.getU_username(),u.getU_password(),u.getU_id());
	}
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from user";
		List<User> list=getJdbcTemplate().query(sql,new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				User u=new User();
				u.setU_id(rs.getInt("u_id"));
				u.setU_username(rs.getString("u_username"));
				u.setU_password(rs.getString("u_password"));
				return u;
			}
		});
		return list;
	}
	@Override
	public Integer selectUserCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from user";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}

}
