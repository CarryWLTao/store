package com.wlt.service.impl;

import com.wlt.dao.UserDao;
import com.wlt.dao.impl.UserDaoImpl;
import com.wlt.domain.User;
import com.wlt.service.UserService;

public class UserServiceImpl implements UserService{
	/**
	 * 用户注册
	 * @throws Exception 
	 */
	@Override
	public void regist(User user) throws Exception {
		// 
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		//发送邮件
		
	}

}
