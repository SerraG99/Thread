public class NomeRunnable implements Runnable{
    private String nome;
    public NomeRunnable(String nome){
        this.nome = nome;
    }
    public void run(){
        Thread.currentThread().setName(nome);
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new NomeRunnable("A"));
        Thread t2 = new Thread(new NomeRunnable("B"));
        t1.start();
        t2.start();
    }
}
