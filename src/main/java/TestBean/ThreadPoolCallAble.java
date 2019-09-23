package TestBean;

import ThreadPool.MyThreadPoolCallAble;

import java.util.concurrent.*;

public class ThreadPoolCallAble {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        MyThreadPoolCallAble threadPoolCallAble = new MyThreadPoolCallAble(100,500);
        MyThreadPoolCallAble threadPoolCallAble1 = new MyThreadPoolCallAble(10,50);

        Future<Integer> submit = service.submit(threadPoolCallAble);

        Integer integer = submit.get();
        System.out.println(integer);


        Future<Integer> future = service.submit(threadPoolCallAble1);
        Integer integer1 = future.get();
        System.out.println(integer1);

    }
}
