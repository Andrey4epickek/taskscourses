public class SecondThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s started \n",Thread.currentThread().getName());
    }
}