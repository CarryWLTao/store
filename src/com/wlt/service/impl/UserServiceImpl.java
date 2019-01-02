package com.wlt.service.impl;

import com.wlt.dao.UserDao;
import com.wlt.dao.impl.UserDaoImpl;
import com.wlt.domain.User;
import com.wlt.service.UserService;
import com.wlt.utils.MailUtils;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	/**
	 * 用户注册
	 * @throws Exception 
	 */
	@Override
	public void regist(User user) throws Exception {
		// 
		
		dao.add(user);
		//发送邮件 sendMail(收件人地址, 邮件内容)
		String emailMsg="欢迎您注册成为我们的一员,<a href='http://localhost:8080/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
		MailUtils.sendMail(user.getEmail(), emailMsg);
	}
	/**
	 * 用户激活
	 */
	@Override
	public User active(String code) throws Exception {
		//通过code获得一个用户
		User user=dao.getByCode(code);
		//判断用户是否为空
		if (user==null) {
			return null;
		}
		
		//修改用户状态  设置用户状态=1
		user.setState(1);
		dao.update(user);
		return user;
	}

}
