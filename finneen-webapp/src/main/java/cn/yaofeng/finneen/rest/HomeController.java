package cn.yaofeng.finneen.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class HomeController {
	
	final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private int index = 0;
	private static int st = 0;
	
	@RequestMapping(value="/hello")
	public Object hello(){
		logger.info(st++ +"-hello-" + index++ + "-" + this.hashCode());
		return "你好";
	}
}
