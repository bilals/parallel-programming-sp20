
public class MessageDisplayer extends Thread {

    private final String taskName;

    public MessageDisplayer(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("I am task " + taskName + ", working for "
                    + (i + 1) + " time(s)");
        }
    }
}
