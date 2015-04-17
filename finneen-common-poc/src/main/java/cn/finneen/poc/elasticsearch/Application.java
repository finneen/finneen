package cn.finneen.poc.elasticsearch;

import cn.finneen.poc.elasticsearch.entities.Contact;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections.SetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.Map;
import java.util.Set;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by yaofeng on 2015/3/13.
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:application.properties")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Bean(name = "elasticsearchTemplate")
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(nodeBuilder().client(true).node().client());
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		ElasticsearchTemplate template = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");
		template.createIndex(Contact.class);
	}
}
