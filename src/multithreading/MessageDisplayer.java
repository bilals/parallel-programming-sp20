package multithreading;

public class MessageDisplayer extends Thread {

	private final int taskNumber;

	public MessageDisplayer(int taskNumber) {
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 1000; i++) {
			System.out.println("I am doing task " + taskNumber + " for the "
					+ (i + 1) + " time(s)");
		}

	}

}
