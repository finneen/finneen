package cn.finneen.poc.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan
public class Application {
	
	@Autowired
	Environment env;
	
	String application_version = "application.version";
	
	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			
			@Override
			public String getMessage() {
				return env.getProperty(application_version);
			}
		};
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
