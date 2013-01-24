package newfethers.java7.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

public class MainTest {

	public static void main(String agrs[]) throws Exception {
		new MainTest().test();
	}

	private List<Long> normalTimes = new ArrayList<Long>();
	private List<Long> concurrencyTimesCallable = new ArrayList<Long>();
	private List<Long> concurrencyTimesForkJoin = new ArrayList<Long>();
	private boolean showDetail = false;

	public void test() throws Exception {
		int length = 10240000;
		int count = 100;
		System.out.println("********************(1+2+....+" + length + ")("
				+ count + ")��************************");
		List<Integer> values = new ArrayList<Integer>();

		for (int i = 0; i < length; i++) {
			values.add(i + 1);
		}
		System.out.println("����׼����ɣ���ʼ����...");
		long begin = System.currentTimeMillis();

		for (int i = 0; i < count; i++) {
			normal(values);
		}
		for (int i = 0; i < count; i++) {
			callable(values);
		}
		for (int i = 0; i < count; i++) {
			forkjoin(values);
		}
		System.out.println("********************���ս��************************");
		System.out.println("��ͨ�ۼ�ƽ������ʱ��Ϊ��" + SumUtil.average(normalTimes)
				+ " ms");
		System.out.println("callable����ƽ������ʱ��Ϊ��"
				+ SumUtil.average(concurrencyTimesCallable) + " ms");
		System.out.println("fork/join����ƽ������ʱ��Ϊ��"
				+ SumUtil.average(concurrencyTimesForkJoin) + " ms");
		long second = (System.currentTimeMillis() - begin) / 1000;
		String str = "";
		if (second > 60) {
			str += second / 60 + "min ";
		}
		if (second % 60 != 0) {
			str += second % 60 + "s";
		}
		System.out.println("�����ܺ�ʱ��" + str);
	}

	private void forkjoin(List<Integer> values) {
		long t3 = System.currentTimeMillis();
		ForkJoinTask<Long> sum3 = new SumTask(values);
		int processors = Runtime.getRuntime().availableProcessors();
		ForkJoinPool fjpool = new ForkJoinPool(processors);
		long result3 = fjpool.invoke(sum3);
		concurrencyTimesForkJoin.add(System.currentTimeMillis() - t3);
		printDetail("fork/join�����ۼ�", System.currentTimeMillis() - t3, result3);
	}

	private void callable(List<Integer> values) throws InterruptedException,
			ExecutionException {
		long t2 = System.currentTimeMillis();
		Callable<Long> sum2 = new SumTaskOld(values);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Long> future = executor.submit(sum2);
		Long result2 = future.get();
		executor.shutdown();
		concurrencyTimesCallable.add(System.currentTimeMillis() - t2);
		printDetail("callable�����ۼ�", System.currentTimeMillis() - t2, result2);
	}

	private void normal(List<Integer> values) {
		long t1 = System.currentTimeMillis();
		long result1 = SumUtil.directAdd(values);
		normalTimes.add(System.currentTimeMillis() - t1);
		printDetail("��ͨ�ۼ�", System.currentTimeMillis() - t1, result1);
	}

	private void printDetail(String name, long time, long result) {
		if (showDetail) {
			System.out.println(name + "����ʱ��Ϊ��" + time + "|�����" + result);
		}

	}

}
