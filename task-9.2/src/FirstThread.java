public class FirstThread implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s started \n",Thread.currentThread().getName());
    }
}