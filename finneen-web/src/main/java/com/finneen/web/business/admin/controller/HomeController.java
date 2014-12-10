package com.finneen.web.business.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaofeng on 2014/12/10.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String home(){
		return "home";
	}
}
