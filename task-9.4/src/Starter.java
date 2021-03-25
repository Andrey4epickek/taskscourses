import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new MyThread(1000));
            thread.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
