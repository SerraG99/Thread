public class main {
    public static void main(String[] args) {

        Thread thread = new Thread(new WorkerImplementRunnable());
        thread.start();

        try {
            thread.join();
            System.out.println("Frocio gay");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
