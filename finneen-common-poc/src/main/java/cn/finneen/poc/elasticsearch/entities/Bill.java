package cn.finneen.poc.elasticsearch.entities;

import cn.finneen.poc.utils.DateUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yaofeng on 2015/3/23.
 */
@Document(indexName = "bill", type = "bill")
public class Bill {

	@Id
	private String id;

	@Field(type = FieldType.Nested)
	private List<Phone> phone;
	@Field(type = FieldType.Long)
	private Long timestamp;
	@Field(type = FieldType.Long)
	private Long duration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Bill{" +
						"id='" + id + '\'' +
						", phone=" + phone +
						", timestamp=" + timestamp +
						", duration=" + duration +
						'}';
	}
}
