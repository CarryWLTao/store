package com.wlt.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.wlt.dao.UserDao;
import com.wlt.domain.User;
import com.wlt.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	@Override
	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?);";
		qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),
				user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		

	}

}
