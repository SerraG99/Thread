import java.util.Random;

public class SommaParallela extends Thread{
    private int[] array;
    private int [] somma;
    private int index;
    public SommaParallela(int[] array, int [] somma, int index){
        this.array = array;
        this.somma = somma;
        this.index = index;
    }
    public void run(){
        for (int i : array){
            somma[index]+=i;
        }

    }


    public static void main(String[] args) {
        int[] numeri = new int[50];
        int [] somme = new int[5];
        Random rand = new Random();

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = rand.nextInt(3);
        }

        Thread [] t = new Thread[5];

        for (int i = 0; i < 5 ; i++){
            int [] help = new int[10];
            for(int k = 0; k < 10; k++){
                help[k]=numeri[i*10+k];
            }
            for(int z = 0; z < 10; z++)

            t[i] = new Thread(new SommaParallela(help, somme, i));
            t[i].start();
        }
        for(int i = 0; i < 5; i++){
            try {
                t[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int s =0;

        for(int i = 0; i < 5; i++) {
            s += somme[i];
            System.out.println(somme[i]);
        }
        System.out.println(s);


    }
}
