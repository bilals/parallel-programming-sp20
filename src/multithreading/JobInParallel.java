package multithreading;

public class JobInParallel extends Thread {
	private final String jobName;

	public JobInParallel(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public void run() {
		// job to do here
		for (int i = 0; i < 100; i++) {
			System.out.println("I'm doing " + jobName + " in parallel (step "
					+ i + ")");
		}
	}
}
