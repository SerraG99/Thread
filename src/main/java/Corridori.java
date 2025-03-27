public class Corridori extends Thread{

    private double contatore;
    private double steep;
    public Corridori(String nome, double steep){
        setName(nome);
        this.steep = steep;
        contatore = 0;
    }
    @Override
    public void run() {
        while(contatore<100){
            contatore+=steep;
            System.out.printf("%s ha fatto %f metri %n",getName(),contatore);
            try {
                double sleep = 0.2 + (Math.random() * (0.5 - 0.2));
                Thread.sleep((long) (sleep*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%s è arrivato%n",getName());


    }

    public static void main(String[] args) {
        int n_corridori = 3;
        Thread [] t1 = new Thread [n_corridori];
        for (int i = 0; i < n_corridori; i++) {
            t1[i] = new Thread(new Corridori("Corridore " + i+1, 0.2 + (Math.random() * (0.5 - 0.2))));
            t1[i].start();
        }

    }
}
