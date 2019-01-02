package com.wlt.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wlt.dao.UserDao;
import com.wlt.domain.User;
import com.wlt.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?);";
		qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),
				user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		

	}
	/**
	 * 通过激活码获取一个用户
	 */
	@Override
	public User getByCode(String code) throws Exception {
		String sql="select * from user where code=? limit1";
		return qr.query(sql, new BeanHandler<>(User.class),code);
	}
	/**
	 * 修改用户
	 */
	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql="update user set username=?,password=?,name=?,email=?,birthday=?,state=?,code=? where uid=?";
		qr.update(sql,user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),
				user.getBirthday(),user.getState(),null,user.getUid());
		
	}

}
