package cn.finneen.poc.test.redis;

import cn.finneen.poc.redis.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yaofeng on 2015/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class RedisTest {

	private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() {
		redisTemplate.execute(new RedisCallback() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Long size = connection.dbSize();
				connection.set("key".getBytes(), "value".getBytes());

				logger.info(new String(connection.get("key".getBytes())));
				return null;
			}
		});
	}

}
