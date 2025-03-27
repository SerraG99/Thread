public class BusyWaitingAttiva extends Thread{
    public void run(){
        for(int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new BusyWaitingAttiva());
        t1.start();
        int i = 0;
        while (t1.isAlive()){
            System.out.printf("controllo %d %b%n",i,t1.isAlive());
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
