package newfethers.java5.generic;

import java.util.List;

public class MethodSign {
	public static List<String> lst;

	// public static void main(String[] args) {
	// List<String> aaa = new ArrayList<String>();
	// aaa.add("1");
	// test(aaa);
	// }
	//
	public static void test(List<Integer> lst) {
		System.out.println("test(List<Object> lst)");
	}
	//
	// public static String test(List<String> lst) {
	// System.out.println("test(List<String> lst)");
	// return "ttttt";
	// }

}
