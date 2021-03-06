package cn.finneen.poc.hbase;

/**
 * Created by yaofeng on 2015/3/24.
 *
 * HBase 常量
 *
 */
public enum HbaseConstant {

	/**
	 * 列族名
	 */
	cf,

	/**
	 * 主叫号码
	 */
	dp,

	/**
	 * 主叫号码归属国家
	 */
	dc,

	/**
	 * 主叫号码归属地区
	 */
	dr,

	/**
	 * 主叫号码运营商
	 */
	dpc,

	/**
	 * 主叫号码原始号码
	 */
	dpo,

	/**
	 * 主叫号码带区号号码
	 */
	dpr,

	/**
	 * 主叫号码国家编码，如：86
	 */
	dcc,

	/**
	 * 主叫号码地区编码，如：022
	 */
	drc,

	/**
	 * 被叫号码
	 */
	cp,

	/**
	 * 被叫号码所属国家
	 */
	cc,

	/**
	 * 被叫号码所属地区
	 */
	cr,

	/**
	 * 被叫号码运营商
	 */
	cpc,

	/**
	 * 被叫号码原号码
	 */
	cpo,

	/**
	 * 被叫号码带区号号码
	 */
	cpr,

	/**
	 * 被叫号码国家编码，如86
	 */
	ccc,

	/**
	 * 被叫号码地区编码，如：022
	 */
	crc,

	/**
	 * 语言类型
	 */
	lt,

	/**
	 * 通话时间，long型时间
	 */
	ti,

	/**
	 * 通话时长，单位：秒
	 */
	dt,

	/**
	 * 短信发送时间
	 */
	sti,

	/**
	 * 短信接收时间
	 */
	rti,

	/**
	 * 内容
	 */
	content,
}
