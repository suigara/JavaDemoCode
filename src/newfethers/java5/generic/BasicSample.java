package newfethers.java5.generic;

import java.util.List;

public class BasicSample<T extends Object> {

	public void addAll(List<T> c) {

	}

	public static void main(String[] args) {

		// ArrayList<?> c = new ArrayList<String>();
		// c.add("111");// compile error

		foo(new String[3]); //  runtime error
	}

	public static void foo(Object[] objs) {
		objs[0] = 1;
	}
}
