package TestBean;

import org.junit.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void treeMap(){
        TreeMap map = new TreeMap();
        for (int i = 0; i < 13; i++) {
            /**
             *
             * put方法流程(简化版):
             * TreeMap底层是红黑树，红黑树也是一个平衡二叉树
             * 第一次添加元素，将该元素对象（final Entry<key，value>）作为根节点
             * 继续添加元素，利用comparable对象，比较当前元素对象的key值和父节点对象的key值，若当前元素对象的key值小于父节点的key值，则返回-1，否则返回1
             * 判断比较的值，若是小于0，则获取左孩子对象，若大于0，则获取右孩子对象
             * 判断是否有孩子对象，若有，则继续循环比较
             * 若没有，则将当前元素对象的key，value以及当前元素对象的父节点传入新的entry对象中
             * 判断刚才比较的结果，若大于0，则将当前元素对象赋为父节点的右孩子，若小于0，则作为左孩子
             * 最后给二叉树涂颜色
             */
            map.put(i,(i+1));
        }

    }
}
