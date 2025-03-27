public class InterruptProcess extends Thread{
    public void run(){
        long tempoInizio = System.currentTimeMillis();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            long tempoTrascorso = (System.currentTimeMillis() - tempoInizio) / 1000;
            System.out.println("Thread figlio interrotto dopo " + tempoTrascorso + " secondi.");
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Thread t = new Thread(new InterruptProcess());
        t.start();
        try {
            Thread.sleep(5*1000);
            t.interrupt();
        } catch (InterruptedException e) {


            throw new RuntimeException(e);
        }
    }
}
