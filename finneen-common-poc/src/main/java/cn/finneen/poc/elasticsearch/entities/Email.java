package cn.finneen.poc.elasticsearch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Created by yaofeng on 2015/3/16.
 */
@Document(indexName = "email", type = "email", shards = 5, replicas = 1)
public class Email {

	@Id
	private String id;

	@Field(type = FieldType.String)
	private String email;

	@MultiField(mainField = @Field(type = FieldType.String, index = FieldIndex.analyzed),
		otherFields = {
			@NestedField(dotSuffix = "cn", type = FieldType.String, indexAnalyzer = "ansj_index"),
			@NestedField(dotSuffix = "en", type = FieldType.String, indexAnalyzer = "english"),
			@NestedField(dotSuffix = "jp", type = FieldType.String, indexAnalyzer = "kuromoji", searchAnalyzer = "kuromoji"),
		}
	)
	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Email{" +
						"id='" + id + '\'' +
						", email='" + email + '\'' +
						", title='" + title + '\'' +
						'}';
	}
}
