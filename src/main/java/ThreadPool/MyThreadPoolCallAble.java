package ThreadPool;

import java.util.concurrent.Callable;

public class MyThreadPoolCallAble implements Callable<Integer> {
    int x = 3;
    int y = 5;

    public MyThreadPoolCallAble(){

    }

    public MyThreadPoolCallAble(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x+y;
    }
}
