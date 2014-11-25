package cn.finneen.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaofeng on 2014/11/25.
 */
@RestController
@EnableAutoConfiguration
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);

	@RequestMapping(value = "/")
	String home() {
		logger.info("hello world");
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
