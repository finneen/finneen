package cn.finneen.poc.elasticsearch.entities;

/**
 * Created by yaofeng on 2015/3/13.
 */
public class Role {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" +
						"name='" + name + '\'' +
						'}';
	}
}
