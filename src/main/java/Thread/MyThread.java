package Thread;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我的线程:正在执行!" + i);
        }
    }
}
