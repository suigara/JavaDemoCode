package newfethers.java7.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final List<Integer> values;
	private int THRESHOLD = 10240; // For demo only

	public SumTask(List<Integer> array) {
		this.values = array;
	}

	//
	// public SortTask(int[] array, int lo, int hi) {
	//
	// this.array = array;
	// this.lo = lo;
	// this.hi = hi;
	// }

	@Override
	protected Long compute() {
		// System.out.println((hi - lo));
		if (values.size() < THRESHOLD)
			return SumUtil.directAdd(values);
		else {
			int pivot = values.size() / 2;
			// System.out.println(pivot);
			SumTask task1 = new SumTask(values.subList(0, pivot));
			SumTask task2 = new SumTask(values.subList(pivot, values.size()));
			task1.fork();
			return task2.compute() + task1.join();

		}
	}


}