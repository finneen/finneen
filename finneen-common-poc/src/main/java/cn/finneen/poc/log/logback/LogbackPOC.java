package cn.finneen.poc.log.logback;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackPOC {
	
	private static final Logger logger = LoggerFactory.getLogger(LogbackPOC.class);
	
	static Timer timer;
	
	public static void main(String[] args) {
		
		timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					logger.info("测试{}日志的使用", "logback");
					logger.error("{},error", "finneen", new Exception("error!"));
				}
			}
		};
		
		timer.schedule(task, new Date(), 10);
	}
}
