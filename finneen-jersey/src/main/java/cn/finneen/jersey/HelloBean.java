package cn.finneen.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloBean {
	private String a;
	private String b;

	private Long c;
	
	public HelloBean() {
	}
	
	public HelloBean(String a, String b, Long c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public Long getC() {
		return c;
	}

	public void setC(Long c) {
		this.c = c;
	}

}
