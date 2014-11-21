package cn.finneen.booknote.javass.chapter1;

/**
 * Java原生态类型
 * 
 * @author Finneen
 *
 */
public class PrimitiveTest {
	
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	public static void test1() {
		Integer a = 1;
		Integer b = 1;
		Integer c = 200;
		Integer d = 200;
		
		System.out.println(a == b); //true
		System.out.println(c == d); //false why?
		System.out.println(c.equals(d));
	}
	
	public static void test2() {
		int oldCapacity = 6;
		System.out.println(Integer.toBinaryString(oldCapacity));
		System.out.println(oldCapacity >> 1);
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(Integer.toBinaryString(newCapacity));
		System.out.println(newCapacity);
	}
}
