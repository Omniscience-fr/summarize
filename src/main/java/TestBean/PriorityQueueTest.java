package TestBean;

import Queue.Topk;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: fr
 * @Date: 2019/6/3 17:11
 */
public class PriorityQueueTest {

    @Test
    public void show(){
        Topk<Integer> topk = new Topk<>(5);
        topk.addAll(Arrays.asList(new Integer[]{100, 1, 2, 5, 6, 7, 34, 9, 3, 4, 5, 8, 23, 21, 90, 1, 0}));

        System.out.println(Arrays.toString(topk.toArray(new Integer[0])));
        System.out.println(topk.getKth());
    }
}
