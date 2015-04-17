package cn.finneen.poc.test.hbase;

import cn.finneen.poc.hbase.Application;
import cn.finneen.poc.hbase.HbaseConstant;
import cn.finneen.poc.hbase.LanguageType;
import cn.finneen.poc.utils.DateUtils;
import com.google.common.collect.Lists;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by yaofeng on 2015/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class HbaseClientTest {

	private static final Logger logger = LoggerFactory.getLogger(HbaseClientTest.class);

	private static final String tableName  = "bill";

	@Autowired
	private HbaseTemplate template;

	@Test
	public void test() throws IOException {

		Scan scan = new Scan();
//		scan.setMaxVersions(5);
		scan.setTimeRange(1427069951704L, System.currentTimeMillis());
		template.find("sms", scan, new RowMapper<Object>() {
			@Override
			public Object mapRow(Result result, int rowNum) throws Exception {
				for (KeyValue kv : result.raw()) {
					String rowKey = Bytes.toString(kv.getRow());
					String family = Bytes.toString(kv.getFamily());
					String qualifier = new String(kv.getQualifier());
					String value = new String(kv.getValue());
					long timestamp = kv.getTimestamp();

					logger.info("rowKey:{}, family:{}, qualifier:{}, value:{}, timestamp:{}", rowKey, family, qualifier, value, timestamp);
				}
				return null;
			}
		});
	}

	@Test
	public void testPut() {

		template.execute(tableName, new TableCallback<Object>() {
			@Override
			public Object doInTable(HTableInterface table) throws Throwable {

				String cp = HbaseConstant.cf.toString();

				List<Put> puts = Lists.newArrayList();

				for (Long i = 1L; i <= 3000L; i++) {
					Put put = new Put(Bytes.toBytes(i));

					//随机电话号码
					long dpnl = Math.round((Math.random() * 100000000));
					long cpnl = Math.round((Math.random() * 100000000));
					DecimalFormat a = new DecimalFormat("00000000");
					String dpn = a.format(dpnl);
					String cpn = a.format(cpnl);

					Date randomDate = DateUtils.randomDate("2010-01-01", "2015-03-01");
					long duration = Math.round((Math.random() * 300));

					//随机国家


					//随机地区
					//随机地区
					String [] regions = {"安徽", "江苏", "广州", "北京", "天津", "河北"};
					long r_num = Math.round(Math.random() * 5);
					String str_num = String.valueOf(r_num);
					int i_num = Integer.parseInt(str_num);

					long r1_num = Math.round(Math.random() * 5);
					String str1_num = String.valueOf(r1_num);
					int i1_num = Integer.parseInt(str1_num);


					//主叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dp.toString()), Bytes.toBytes("186" + dpn));//主叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dc.toString()), Bytes.toBytes("中国"));//主叫号码国家
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dr.toString()), Bytes.toBytes(regions[i1_num]));//主叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpc.toString()), Bytes.toBytes("中国联通"));//主叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpo.toString()), Bytes.toBytes("86186" + dpn));//主叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpr.toString()), Bytes.toBytes(""));//主叫原号码+区号，比如022之类，用于座机
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dcc.toString()), Bytes.toBytes("86"));//主叫号码国家编码，如：86
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.drc.toString()), Bytes.toBytes("022"));//主叫号码国家编码，如：022


					//被叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cp.toString()), Bytes.toBytes("139" + cpn));//被叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cc.toString()), Bytes.toBytes("中国"));//被叫号码国家
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cr.toString()), Bytes.toBytes(regions[i_num]));//被叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpc.toString()), Bytes.toBytes("中国移动"));//被叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpo.toString()), Bytes.toBytes("86139" + cpn));//被叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpr.toString()), Bytes.toBytes(""));//被叫原号码+区号，比如022之类，用于座机
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.ccc.toString()), Bytes.toBytes("86"));//被叫号码国家编码，如：86
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.crc.toString()), Bytes.toBytes("022"));//被叫号码国家编码，如：022

					//时间 时长
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.ti.toString()), Bytes.toBytes(randomDate.getTime()));//时间
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dt.toString()), Bytes.toBytes(String.valueOf(duration)));//时长

					puts.add(put);

				}
				table.put(puts);

				return null;
			}
		});
	}

	@Test
	public void testSmsPut() {

		template.execute("sms", new TableCallback<Object>() {
			@Override
			public Object doInTable(HTableInterface table) throws Throwable {
				String cp = HbaseConstant.cf.toString();

				List<Put> puts = Lists.newArrayList();

				for (Long i = 1L; i <= 20L; i++) {
					Put put = new Put(Bytes.toBytes(i));

					//随机电话号码
					long dpnl = Math.round((Math.random() * 100000000));
					long cpnl = Math.round((Math.random() * 100000000));
					DecimalFormat a = new DecimalFormat("00000000");
					String dpn = a.format(dpnl);
					String cpn = a.format(cpnl);

					Date randomDate = DateUtils.randomDate("2010-01-01", "2015-04-01");
					long duration = Math.round((Math.random() * 600));

					//随机地区
					String [] regions = {"安徽", "江苏", "广州", "北京", "天津", "河北"};
					long r_num = Math.round(Math.random() * 5);
					String str_num = String.valueOf(r_num);
					int i_num = Integer.parseInt(str_num);

					long r1_num = Math.round(Math.random() * 5);
					String str1_num = String.valueOf(r1_num);
					int i1_num = Integer.parseInt(str1_num);

					//随机语种

					LanguageType [] lt = LanguageType.values();
					long l_num = Math.round(Math.random() * (lt.length - 1));
					String str_l = String.valueOf(l_num);
					int i_l = Integer.parseInt(str_l);



					//随机内容
					String content[] = {"I'm not happy about the foxes", "外媒报道习近平讲话APP:每个人都能找到兴趣点", "東京%20スカイツリー,トウキョウ%20スカイツリー,カスタム名詞",
					"美国纪录片关注生态城", "据了解，该系统目前可以办理包括主体设立、项目建设、城市管理、社会服务及经营服务等领域的政务审批事项 45 项，全部事项均可以在网上进行申报，由专人在后台进行审批。与此同时，生态城办事大厅仍可进行审批事项申报与现场办理，形成“线上线下双互动”的服务模式。\n" +
									"　　此外，生态城还借鉴新加坡先进经验，把信息化作为提供便捷高效审批服务的突破口，打造网上虚拟审批大厅，让企业、居民足不出户，就可以在网上办理工商登记、项目立项、规划建设、环境评价、社会民生等重要审批事项，让政府的服务更加透明高效。",
					"“96600万事通”上线 生态城打造网上虚拟审批大厅", "北辰区妇幼保健中心和市代谢病医院项目加快建设"};

					long l_content = Math.round(Math.random() * 5);
					String str_content = String.valueOf(l_content);
					int i_content = Integer.parseInt(str1_num);


					//主叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dp.toString()), Bytes.toBytes("185" + dpn));//主叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dc.toString()), Bytes.toBytes("中国"));//主叫号码国家
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dr.toString()), Bytes.toBytes(regions[i1_num]));//主叫号码地区
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpc.toString()), Bytes.toBytes("中国联通"));//主叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpo.toString()), Bytes.toBytes("86186" + dpn));//主叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dpr.toString()), Bytes.toBytes(""));//主叫原号码+区号，比如022之类，用于座机
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.dcc.toString()), Bytes.toBytes("86"));//主叫号码国家编码，如：86
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.drc.toString()), Bytes.toBytes("022"));//主叫号码国家编码，如：022


					//被叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cp.toString()), Bytes.toBytes("138" + cpn));//被叫号码
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cc.toString()), Bytes.toBytes("中国"));//被叫号码国家
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cr.toString()), Bytes.toBytes(regions[i_num]));//被叫号码地区
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpc.toString()), Bytes.toBytes("中国移动"));//被叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpo.toString()), Bytes.toBytes("86139" + cpn));//被叫号码运行商
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.cpr.toString()), Bytes.toBytes(""));//被叫原号码+区号，比如022之类，用于座机
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.ccc.toString()), Bytes.toBytes("86"));//被叫号码国家编码，如：86
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.crc.toString()), Bytes.toBytes("022"));//被叫号码国家编码，如：022

					//时间
					long time = randomDate.getTime();
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.sti.toString()), Bytes.toBytes(time));//时间
					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.rti.toString()), Bytes.toBytes(time + 100));//时间

					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.content.toString()), Bytes.toBytes(content[i_content]));

					put.add(Bytes.toBytes(cp), Bytes.toBytes(HbaseConstant.lt.toString()), Bytes.toBytes(lt[i_l].toString()));

					puts.add(put);

				}
				table.put(puts);
				return null;
			}
		});
	}
}
