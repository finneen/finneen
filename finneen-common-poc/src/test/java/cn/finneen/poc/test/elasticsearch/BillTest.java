package cn.finneen.poc.test.elasticsearch;

import cn.finneen.poc.elasticsearch.Application;
import cn.finneen.poc.elasticsearch.entities.Bill;
import cn.finneen.poc.elasticsearch.entities.Phone;
import com.google.common.collect.Lists;
import org.elasticsearch.index.query.BoolQueryBuilder;
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

import java.text.DecimalFormat;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by yaofeng on 2015/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class BillTest {

	private static final Logger logger = LoggerFactory.getLogger(BillTest.class);

	@Autowired
	private ElasticsearchTemplate template;

	@Test
	public void test() {
		//template.deleteIndex(Bill.class);
		//template.createIndex(Bill.class);
		//template.putMapping(Bill.class);

		Bill bill = new Bill();
		Phone phone = new Phone();
		phone.setPhoneNum("13920236210");
		phone.setType("主叫");
		phone.setCountry("英国");
		phone.setRegion("伦敦");

		Phone phone2 = new Phone();
		phone2.setPhoneNum("18698128551");
		phone2.setType("被叫");
		phone2.setCountry("美国");
		phone2.setRegion("旧金山");

		List<Phone> phones = Lists.newArrayList();
		phones.add(phone);
		phones.add(phone2);
		bill.setPhone(phones);

		logger.info("{}", bill);

		IndexQuery indexQuery = new IndexQueryBuilder().withObject(bill).withId("1").build();

		template.index(indexQuery);
	}

	@Test
	public void testQuery() {
		BoolQueryBuilder builder = boolQuery();
		builder.must(nestedQuery("phone", termQuery("phone.country", "5")));

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		List<Bill> bills = template.queryForList(searchQuery, Bill.class);

		logger.info("{}", bills);
	}

	public static void main(String args[]) {
			String result = "";
			for(int i = 1;i <= 3;i++){//前3个，随即数1-7
				result = result + Integer.toString((int)(Math.random() * 8));
			}
			DecimalFormat a = new DecimalFormat("0000000");//随机到非7位数时前面加0
			result = result + a.format((int)(Math.random() * 4720001));//随机数0-4720000

			System.out.println(result);
		}
}
