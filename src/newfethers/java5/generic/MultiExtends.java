package newfethers.java5.generic;

import java.util.List;
import java.util.Map;

public class MultiExtends {
	@SuppressWarnings("rawtypes")
	public static <T extends List & Map> void fill(List<T> list, T o) {

	}
}
