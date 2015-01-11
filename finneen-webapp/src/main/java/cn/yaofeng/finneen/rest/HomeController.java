package cn.yaofeng.finneen.rest;

import cn.yaofeng.finneen.system.user.entity.User;
import cn.yaofeng.finneen.system.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class HomeController {
	
	final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;
	
	private int index = 0;
	private static int st = 0;
	
	@RequestMapping(value="/hello")
	public Object hello(){
		logger.info(st++ +"-hello-" + index++ + "-" + this.hashCode());
		logger.error(new Exception("error") + "");
		User user = new User();
		user.setUserName("admin");
		userService.save(user);
		return userService.findAll();
	}


}
