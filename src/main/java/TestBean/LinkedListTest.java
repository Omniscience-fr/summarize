package TestBean;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    @Test
    public void linkedList(){
        LinkedList list = new LinkedList();
        for(int i=0;i<12;i++){
            /**
             * add流程(简化版):
             * LinkedList底层是deque（双向链表）,
             * 创建一个节点对象，将元素传入节点对象中进行赋值
             * 当添加第二个元素对象时，同样新创建一个节点对象，将元素传入节点对象中进行赋值
             * 然后将上一个节点对象的后继指向第二个节点对象
             *
             */
            list.add("111111");
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
    }

}
