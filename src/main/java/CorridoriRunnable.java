public class CorridoriRunnable implements Runnable{

    private double contatore;
    private double steep;
    private String nome;
    public CorridoriRunnable(String nome, double steep){
        this.nome = nome;
        this.steep = steep;
        contatore = 0;
    }
    @Override
    public void run() {
        Thread.currentThread().setName(nome);
        while(contatore<100){
            contatore+=steep;
            System.out.printf("%s ha fatto %f metri %n",Thread.currentThread().getName(),contatore);
            try {
                double sleep = 0.2 + (Math.random() * (0.5 - 0.2));
                Thread.sleep((long) (sleep*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%s è arrivato%n",Thread.currentThread().getName());


    }

    public static void main(String[] args) {
        int n_corridori = 3;
        Thread [] t1 = new Thread [n_corridori];
        for (int i = 0; i < n_corridori; i++) {
            t1[i] = new Thread(new CorridoriRunnable("Corridore " + (i+1), 0.2 + (Math.random() * (0.5 - 0.2))));
            t1[i].start();
        }

    }
}
