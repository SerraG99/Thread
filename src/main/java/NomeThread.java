public class NomeThread extends Thread{
    public NomeThread (String nome){
        setName(nome);
    }
    public void run(){
        System.out.println(getName());
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new NomeThread("A"));
        Thread t2 = new Thread(new NomeThread("B"));
        t1.start();
        t2.start();
    }
}
