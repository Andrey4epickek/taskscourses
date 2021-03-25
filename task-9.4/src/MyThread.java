import java.util.Date;

public class MyThread implements Runnable{

    int n;
    public MyThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(new Date());
                Thread.sleep(n);
            } catch (InterruptedException ex) {
            }
        }
    }
}
