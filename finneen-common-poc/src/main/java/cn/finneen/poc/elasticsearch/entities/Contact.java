package cn.finneen.poc.elasticsearch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by yaofeng on 2015/3/13.
 */
@Document(indexName = "test-contact-test",type = "contact-test-type", shards = 1, replicas = 1)
public class Contact {

	@Id
	private String id;
	@Field(type = FieldType.String, indexAnalyzer = "ansj_index", searchAnalyzer = "ansj_query")
	private String name;
	@Field(type = FieldType.Nested)
	private List<Manuscript> manuscripts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Manuscript> getManuscripts() {
		return manuscripts;
	}

	public void setManuscripts(List<Manuscript> manuscripts) {
		this.manuscripts = manuscripts;
	}

	@Override
	public String toString() {
		return "Contact{" +
						"id='" + id + '\'' +
						", name='" + name + '\'' +
						", manuscripts=" + manuscripts +
						'}';
	}
}
