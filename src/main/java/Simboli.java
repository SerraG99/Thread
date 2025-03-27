public class Simboli implements Runnable {
    private char s;
    public Simboli(char s){
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 50; i++)
                System.out.print(s);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Simboli('*'));
        Thread t2 = new Thread(new Simboli('#'));
        t1.start();
        t2.start();
    }
}
