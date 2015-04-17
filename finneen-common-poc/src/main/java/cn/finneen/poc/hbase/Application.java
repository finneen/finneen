package cn.finneen.poc.hbase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.hadoop.hbase.HbaseConfigurationFactoryBean;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yaofeng on 2015/3/18.
 */
@Configuration
@ComponentScan
@ImportResource(value = "classpath:/applicationContext-hbase.xml")
public class Application {

	/*@Bean
	HbaseTemplate hbaseTemplate() throws IOException {

		org.apache.hadoop.conf.Configuration configuration = hbaseConfiguration();

		HbaseTemplate template = new HbaseTemplate();
		template.setConfiguration(configuration);
		return template;
	}

	@Bean
	org.apache.hadoop.conf.Configuration hbaseConfiguration() throws IOException {
		HbaseConfigurationFactoryBean hbaseConfiguration = new HbaseConfigurationFactoryBean();
		Resource resource = new ClassPathResource("/mid-hadoop.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		hbaseConfiguration.setProperties(properties);
		return hbaseConfiguration.getObject();
	}*/


}
