import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @Author: fr
 * @Date: 2019/6/3 17:11
 */
public class Topk<E> {
    private PriorityQueue<E> p;
    private int k;

    public Topk(int k) {
        this.k = k;
        this.p = new PriorityQueue<>(k);
    }

    public void addAll(Collection<? extends E> c){
        for(E e : c){
            add(e);
        }
    }

    public void add(E e) {
        if(p.size()<k){
            p.add(e);
            return;
        }
        Comparable<? super E> head = (Comparable<? super E>)p.peek();
        if(head.compareTo(e)>0){
            //小于TopK中的最小值，不用变
            return;
        }
        //新元素替换掉原来的最小值成为Top K之一。
        p.poll();
        p.add(e);
    }

    public <T> T[] toArray(T[] a){
        return p.toArray(a);
    }

    public E getKth(){
        return p.peek();
    }

}
