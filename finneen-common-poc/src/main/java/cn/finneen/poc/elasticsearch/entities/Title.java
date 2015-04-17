package cn.finneen.poc.elasticsearch.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by yaofeng on 2015/3/16.
 */
public class Title {

	@Field(type = FieldType.String, indexAnalyzer = "english")
	private String en;
	@Field(type = FieldType.String, indexAnalyzer = "ansj_index")
	private String cn;
	@Field(type = FieldType.String, indexAnalyzer = "ansj_index")
	private String jp;

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getJp() {
		return jp;
	}

	public void setJp(String jp) {
		this.jp = jp;
	}
}
