
public class MultithreadingTest {

    /*
	 * This program should display "I am doing job i for the j time(s)". The
	 * numbers of tasks is 2 and the number of times is 1000.
     */
    public static void main(String[] args) {
        MessageDisplayer th1 = new MessageDisplayer("A");
        MessageDisplayer th2 = new MessageDisplayer("B");
        th1.start();
        th2.start();
    }
}
