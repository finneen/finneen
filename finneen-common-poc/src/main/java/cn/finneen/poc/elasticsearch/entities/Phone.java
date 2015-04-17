package cn.finneen.poc.elasticsearch.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by yaofeng on 2015/3/24.
 */
public class Phone {

	@Field(type = FieldType.String)
	private String phoneNum;

	@Field(type = FieldType.String, indexAnalyzer = "string2int")
	private String type;
	@Field(type = FieldType.String, indexAnalyzer = "string2int")
	private String country;
	@Field(type = FieldType.String, indexAnalyzer = "string2int")
	private String region;
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String operator;
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String o_phoneNum;
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String r_phoneNum;
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String c_country;
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String c_region;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getO_phoneNum() {
		return o_phoneNum;
	}

	public void setO_phoneNum(String o_phoneNum) {
		this.o_phoneNum = o_phoneNum;
	}

	public String getR_phoneNum() {
		return r_phoneNum;
	}

	public void setR_phoneNum(String r_phoneNum) {
		this.r_phoneNum = r_phoneNum;
	}

	public String getC_country() {
		return c_country;
	}

	public void setC_country(String c_country) {
		this.c_country = c_country;
	}

	public String getC_region() {
		return c_region;
	}

	public void setC_region(String c_region) {
		this.c_region = c_region;
	}

	@Override
	public String toString() {
		return "Phone{" +
						"phoneNum='" + phoneNum + '\'' +
						", type='" + type + '\'' +
						", country='" + country + '\'' +
						", region='" + region + '\'' +
						", operator='" + operator + '\'' +
						", o_phoneNum='" + o_phoneNum + '\'' +
						", r_phoneNum='" + r_phoneNum + '\'' +
						", c_country='" + c_country + '\'' +
						", c_region='" + c_region + '\'' +
						'}';
	}
}
