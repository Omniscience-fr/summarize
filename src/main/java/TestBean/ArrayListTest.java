package TestBean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

    @Test
    public void arraylistTest(){
        ArrayList list = new ArrayList();
        for(int i=0;i<13;i++) {
            /**
             * add流程（简化版）:
             * 调用add方法，将元素拷贝进新的数组中
             * 判断当前数组是否是要扩容，默认长度为10
             * 若不需要扩容，则直接将元素按下标添加进数组中
             * 若需要扩容，则将原本数组扩容成原本的2倍+2的长度
             *
             */
            list.add("1111111111");
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
