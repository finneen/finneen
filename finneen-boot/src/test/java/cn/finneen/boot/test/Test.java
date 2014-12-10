package cn.finneen.boot.test;

import cn.finneen.boot.Application;
import cn.finneen.boot.business.poc.City;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yaofeng on 2014/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class Test {

	RestTemplate restTemplate = new TestRestTemplate();


	@org.junit.Test
	public void test() {
		ResponseEntity<City> city = restTemplate.getForEntity("http://localhost:8081/save", City.class);
		System.out.println(city.getBody());
	}
}
