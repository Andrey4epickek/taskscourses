
public class SomeThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}