package com.finneen.web.business.admin.controller;

import com.finneen.web.business.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaofeng on 2014/12/10.
 */
@RestController
public class HelloController {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/")
	public String hello() {
		return userService.getUsers();
	}
}
