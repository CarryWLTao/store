package com.wlt.service;

import com.wlt.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User active(String code) throws Exception;

}
