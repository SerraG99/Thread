public class InterrputProcessMultipli extends Thread{
    private int sleep;
    public InterrputProcessMultipli(int sleep){
        this.sleep = sleep;
    }
    public void run(){
        try {
            if (sleep > 0) {
                System.out.println(Thread.currentThread().getName() + " sta dormendo per " + sleep + " ms.");
                Thread.sleep(sleep);
            }

            while (!Thread.currentThread().isInterrupted()) {
                System.out.print(".");

            }
            System.out.println("Stavo lavorando");
        } catch (InterruptedException e) {
            if(sleep>0)
                System.out.println("Stavo dormendo");


        }

    }

    public static void main(String[] args) {
        Thread t1 = new InterrputProcessMultipli(0);
        Thread t2 = new InterrputProcessMultipli(5000);
        t1.start();
        t2.start();
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
}
