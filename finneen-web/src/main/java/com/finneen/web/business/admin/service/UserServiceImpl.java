package com.finneen.web.business.admin.service;

import org.springframework.stereotype.Service;

/**
 * Created by yaofeng on 2014/12/10.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Override
	public String getUsers() {
		return "world";
	}
}
