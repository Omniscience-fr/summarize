package TestBean;


import Thread.MyThread;
import Thread.ThreadDemo;

public class ThreadTest {
    public static void main(String[] args) {
        Runnable runnable =new MyThread();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程:正在执行" + i);
        }

//        ThreadDemo threadDemo = new ThreadDemo("新的线程");
//        threadDemo.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main线程:" + i);
//        }

    }
}
