package TestBean;

import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {

    @Test
    public void hashMap(){
        HashMap map = new HashMap();
        for (int i = 0; i < 13; i++) {
            /**
             * put方法流程(简化版):
             * 第一次添加，先进行扩容，默认长度为16，并计算阈值，（默认长度16*0.75=12）为后边扩容使用
             * 创建节点对象，内有三个变量，哈希值，key，value，next
             * 将元素对象传入节点对象中，对哈希值，key，value进行赋值，next一直为null
             * 继续添加元素，检测当前长度+1是否大于第一次计算的阈值，若不大于，则添加元素
             * 若大于，则进行扩容，第二次扩容时，将阈值左移一位（12*2=24），作为新的阈值
             * 然后添加元素
             * 循环第一次创建的节点对象数组，将里边的元素拿出来，并赋给新创建的节点对象
             * 插入的位置为：当前对象的哈希值&（第一次创建的节点对象数组的长度-1）
             *
             *
             */
            map.put(i,(i+1));

        }

    }
}
