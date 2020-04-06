package multithreading;
public class MessageDisplayerTest {

	/*
	 * This program display "I am doing task i for the j time(s)". The number of
	 * tasks is 4, and the number of display times is 1000 per task.
	 */

	public static void main(String[] args) {
		MessageDisplayer task1 = new MessageDisplayer(1);
		task1.start();
		MessageDisplayer task2 = new MessageDisplayer(2);
		task2.start();
	}

}
