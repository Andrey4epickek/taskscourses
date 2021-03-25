public class StartClass {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new FirstThread(),"First thread");
            Thread thread2 = new Thread(new SecondThread(),"Second thread");
            thread.start();
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
