public class Program {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new SomeThread());
            Thread thread2 = new Thread(new SlowThread());
            System.out.println(thread.getState() + " new");
            thread.start();
            thread2.start();
            System.out.println(thread2.getState() + " runnable");
            thread2.sleep(500);
            System.out.println(thread.getState() + " timed_waiting");

            System.out.println(thread2.getState() + " waiting");

            Object a = SlowThread.getA();
            synchronized (a){
                a.notify();
            }
            System.out.println(thread2.getState() + " blocked");
            thread2.sleep(2000);
            System.out.println(thread2.getState() + " terminated thread 2");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}