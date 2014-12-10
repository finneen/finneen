package cn.finneen.boot;

import cn.finneen.boot.business.poc.City;
import cn.finneen.boot.business.poc.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by yaofeng on 2014/11/25.
 */
@RestController
@EnableAutoConfiguration
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private CityRepository repository;

	@RequestMapping(value = "/")
	String home() {
		logger.info("hello world");
		return "Hello World";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	City save() {
		City city = new City("beijing", "ok");
		return repository.save(city);
	}

	public Application() {
		super();
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	Iterator<City> findAll() {
		return repository.findAll().iterator();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
