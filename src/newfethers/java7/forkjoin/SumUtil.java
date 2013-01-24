package newfethers.java7.forkjoin;

import java.util.List;

public class SumUtil {
	public static long directAdd(List<Integer> values) {
		long sum = 0;
		for (Integer value : values) {
			sum += value;
		}
		return sum;
	}

	public static long average(List<Long> values) {
		if (values.isEmpty())
			return 0;
		long sum = 0;
		for (long value : values) {
			sum += value;
		}
		return sum / values.size();
	}

}
