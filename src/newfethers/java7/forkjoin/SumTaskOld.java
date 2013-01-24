package newfethers.java7.forkjoin;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumTaskOld implements Callable <Long> {
	/**
	 * 
	 */
	final List<Integer> values;
	private int THRESHOLD = 10240; // For demo only

	public SumTaskOld(List<Integer> array) {
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
	public Long call() throws Exception {
		// System.out.println((hi - lo));
				if (values.size() < THRESHOLD)
					return SumUtil.directAdd(values);
				else {
					int pivot = values.size() / 2;
					// System.out.println(pivot);
					ExecutorService executor = Executors.newFixedThreadPool(2);
					
					SumTaskOld task1 = new SumTaskOld(values.subList(0, pivot));
					SumTaskOld task2 = new SumTaskOld(values.subList(pivot, values.size()));
					Future <Long> future1 = executor.submit(task1);
					Future <Long> future2 = executor.submit(task2);
					long result = future1.get() + future2.get();
					executor.shutdown();
					return result;

				}
	}

	


	
}