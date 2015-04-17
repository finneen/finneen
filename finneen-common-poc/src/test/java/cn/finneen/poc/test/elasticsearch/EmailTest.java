package cn.finneen.poc.test.elasticsearch;

import cn.finneen.poc.elasticsearch.Application;
import cn.finneen.poc.elasticsearch.entities.Email;
import cn.finneen.poc.elasticsearch.entities.Title;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by yaofeng on 2015/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class EmailTest {

	private static final Logger logger = LoggerFactory.getLogger(EmailTest.class);

	@Autowired
	private ElasticsearchTemplate template;

//	@Before
	public void before() {
		template.deleteIndex(Email.class);
		template.createIndex(Email.class);
		template.putMapping(Email.class);
	}

	@Test
	public void test() {
		Email email = new Email();
		email.setEmail("finneen.yao@mail.com");
		email.setId("1");
		email.setTitle("周星驰电影");

		Email email2 = new Email();
		email2.setEmail("finneen.yao@mail.com");
		email2.setId("2");
		email2.setTitle("I'm not happy about the foxes");

		Email email3 = new Email();
		email3.setEmail("finneen.yao@mail.com");
		email3.setId("3");
		email3.setTitle("東京%20スカイツリー,トウキョウ%20スカイツリー,カスタム名詞");

		Email email4 = new Email();
		email4.setEmail("finneen.yao@mail.com");
		email4.setId("4");
		email4.setTitle("最最最最好的新新新新电影");

		IndexQuery indexQuery = new IndexQueryBuilder().withObject(email).withObject(email).withId(email.getId()).build();
		IndexQuery indexQuery1 = new IndexQueryBuilder().withObject(email).withObject(email2).withId(email2.getId()).build();
		IndexQuery indexQuery2 = new IndexQueryBuilder().withObject(email).withObject(email3).withId(email3.getId()).build();
		IndexQuery indexQuery3 = new IndexQueryBuilder().withObject(email).withObject(email4).withId(email4.getId()).build();

		template.bulkIndex(Arrays.asList(indexQuery, indexQuery1, indexQuery2, indexQuery3));
		template.refresh(Email.class, true);
		// index over

		BoolQueryBuilder builder = boolQuery();
		builder.must(multiMatchQuery("東京").type(MultiMatchQueryBuilder.Type.MOST_FIELDS).field("title"));
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();

		logger.info(searchQuery.getQuery().toString());

		List<Email> emails = template.queryForList(searchQuery, Email.class);

		logger.info("{}", emails);

	}

	@Test
	public void testQuery() {
		BoolQueryBuilder builder = boolQuery();
		builder.must(multiMatchQuery("电影").type(MultiMatchQueryBuilder.Type.MOST_FIELDS).field("title.cn"));
		builder.mustNot(multiMatchQuery("周星驰").type(MultiMatchQueryBuilder.Type.MOST_FIELDS).field("title.cn"));
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();

		logger.info(searchQuery.getQuery().toString());

		List<Email> emails = template.queryForList(searchQuery, Email.class);

		logger.info("{}", emails);

	}

}
