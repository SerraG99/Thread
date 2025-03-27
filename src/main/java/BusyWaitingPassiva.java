public class BusyWaitingPassiva extends Thread{
    public void run(){
        for(int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1500);
                System.out.println("Lavoro, sono il bimbo");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new BusyWaitingPassiva());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ho terminato l'esecuzione, sono il diddy");
    }

}
