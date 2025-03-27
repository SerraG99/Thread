import java.util.Random;

public class TaskCounter extends Thread{
    private Counter c;
    private int n;
    public TaskCounter(Counter c, int n){
        this.c = c;
        this.n = n;
    }
    public void run(){
        int num = new Random().nextInt(n - n/2 + 1) + n/2;
        for (int i = 0; i < num; i++)
            c.next();
    }
    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(new TaskCounter(c,5));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.getCount());
    }

}
