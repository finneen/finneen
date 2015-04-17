package cn.finneen.poc.test.elasticsearch;

import cn.finneen.poc.elasticsearch.Application;
import cn.finneen.poc.elasticsearch.entities.Contact;
import cn.finneen.poc.elasticsearch.entities.Manuscript;
import cn.finneen.poc.elasticsearch.entities.Role;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.hamcrest.core.Is.is;

/**
 * Created by yaofeng on 2015/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ClientTest {

	private static final Logger logger = LoggerFactory.getLogger(ClientTest.class);

	@Autowired
	private ElasticsearchTemplate template;

	@Before
	public void before() {
		template.deleteIndex(Contact.class);
		template.createIndex(Contact.class);
		template.putMapping(Contact.class);
	}

	@Test
	public void test() {
		Contact contact1 = new Contact();
		contact1.setId("1");
		contact1.setName("2");

		Manuscript manuscript1 = new Manuscript();
		manuscript1.setTitle("t1");
		manuscript1.setAbstractText("t2");
		manuscript1.setStatus("ACCEPTED");

		Role role1 = new Role();
		role1.setName("role1");

		Role role2 = new Role();
		role2.setName("role2");

		manuscript1.setRole(Arrays.asList(role1, role2));

		Manuscript manuscript2 = new Manuscript();
		manuscript2.setTitle("t1");
		manuscript2.setAbstractText("t2");
		manuscript2.setStatus("DELETED");

		Role role3 = new Role();
		role3.setName("role3");

		manuscript2.setRole(Arrays.asList(role3));

		contact1.setManuscripts(Arrays.asList(manuscript1,manuscript2));

		IndexQuery indexQuery = new IndexQueryBuilder().withObject(contact1)
						.withIndexName("test-contact-test").withId(contact1.getId())
						.withType("contact-test-type").build();

		template.bulkIndex(Arrays.asList(indexQuery));
		template.refresh("test-contact-test", true);

		BoolQueryBuilder builder = boolQuery();
		builder.must(nestedQuery("manuscripts", termQuery("manuscripts.status", "ACCEPTED")))
						.must(nestedQuery("manuscripts.role", termQuery("manuscripts.role.name", "role1")));

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();


		logger.info("{}", searchQuery.getQuery());


		Page<Contact> page  = template.queryForPage(searchQuery, Contact.class);

		logger.info("{}", page.getContent());
		Assert.assertThat(page.getTotalElements(), is(1L));
	}


}
