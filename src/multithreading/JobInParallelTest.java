package multithreading;

public class JobInParallelTest {

	public static void main(String[] args) throws InterruptedException {
		JobInParallel job1 = new JobInParallel("job 1");
		JobInParallel job2 = new JobInParallel("job 2");
		JobInParallel job3 = new JobInParallel("job 3");

		long start = System.currentTimeMillis();
		job1.start();
		job2.start();
		job3.start();

		// job1.join();
		// job2.join();
		// job3.join();

		// Ex1: how to display a message when ALL jobs are done?
		while (job1.isAlive() || job2.isAlive() || job3.isAlive()) {

		}
		long end = System.currentTimeMillis();

		// Ex2: how to compute the time required to finish these 3 threads?
		System.out.println("Elapsed time: " + (end - start) + " ms");
	}
}
