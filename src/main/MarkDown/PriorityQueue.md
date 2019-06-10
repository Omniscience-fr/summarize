###### 剖析PriorityQueue
1. 基本概念
    1. PriorityQueue就是优先级队列，它实现了queue接口，与LinkedList类似，它的队列长度也没有限制，
 与一般队列的区别是它有优先级的概念。每个元素都有优先级，队头的元素优先级永远是最高的。
    2. PriorityQueue内部是用堆实现的，内部元素不完全有序，不过逐个出队会有序的输出
    3. PriorityQueue可以看做是一种比较通用的实现了堆的性质的数据结构，可以用来解决堆的问题

2. 基本用法
    1. 构造方法：PriorityQueue有多种构造方法
        1. public PriorityQueue()
        2. public PriorityQueue(int initialCapacity)
        3. public PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        4. public PriorityQueue(Collection<? extends E> c)
        5. public PriorityQueue(PriorityQueue<? extends E> c)
        6. public PriorityQueue(SortedSet<? extends E> c)  
     
        优先级队列是用堆实现的，物理存储是用数组实现的，与ArrayList类似，PriorityQueue同样使用动态
    数组，根据元素的个数进行动态扩展，initialCapacity表示初始的数组大小，可以通过参数传入。默认的
    构造方法有默认的initialCapacity值11。  
        与TreeMap/TreeSet类似，为了保持一定的顺序，PriorityQueue要求要么传递一个comparator比较器，
    要么元素实现comparable接口：  
        1. 对于前两个构造方法和接收Collection集合的构造方法，要求元素实现comparable接口。
        2. 第三个构造方法要求定义初始化大小，并传入一个comparator比较器。
        3. 对于最后两个构造方法，参数容器有comparator()方法，PriorityQueue共用参数容器的比较器，
        如果返回的comparator为null，则也要求实现comparable接口。

3. 内部实现
    1. 内部成员：
       1. private transient Object[] queue;
       2. private int size = 0;
       3. private final Comparator<? super E> comparator;
       4. private transient int modCount = 0;  
    
        queue实际就是存储元素的数组，size表示当前元素的个数，comparator是一个比较器，可以为null，modcount
     表示记录修改次数
     
     2. offer方法：
        1. 先判断参数是否为null,若是则抛出异常
        2. 记录修改次数，并将当前元素个数赋值给新变量i
        3. 判断当前元素个数是否大于数组的长度，若是则调用grow()方法进行扩容，并将长度+1后重新赋值给size
        4. 若是第一次添加，则直接添加到第一个位置即可，若不是第一次添加，则将其放在队尾，并进行向下调整，直至满足堆的性质
        
     3. grow方法：
        1. 将数组的长度赋值给新定义的变量oldCapacity
        2. 判断oldCapacity是否小于64，若是，则将长度扩展为原来长度的2倍+2，若不是，则扩展为原来长度的0.5倍
        3. 使用Arrays.copyof方法进行元素拷贝
        
     4. siftUp方法，根据comparator比较器是否为null，分为两种情况,比较器不为null时：  
        1. 根据插入位置是否大于0来进行while循环
        2. 将要插入的位置-1后无符号右移1位，定义为父节点位置，并获取父节点位置的元素
        3. 将新元素和父节点元素进行比较，若是新元素大于等于父节点元素，则满足堆的性质，结束循环，当前位置就是新元素的最终位置，
     若新元素小于父节点元素，则将父节点往下移动，继续向上寻找。
     
     5. siftDown方法，与siftUp方法一样，根据comparator比较器是否为null，分为两种情况，比较器不为null时：
        1. 将数组长度的一半赋值给变量half，并根据最终插入位置是否大于half进行while循环
        2. 将最终位置的孩子节点的位置赋值给变量child((k << 1)+1,相当于获取最终位置元素的左孩子节点的位置)
        3. 获取到左孩子节点的元素，赋值给object变量c，并将变量child+1赋值为新变量right
        4. 判断right是否小于数组长度并且左孩子节点的元素c与right位置的元素比较是否大于0，若是，则将right位置的元素赋值给c变量
        5. 最终插入位置与原来最后的元素进行比较，是否小于等于0，若是，则结束循环，k就是最终插入位置，否则将较小的孩子往上移动，
     并继续向下寻找
     
4. PriorityQueue特点  
    PriorityQueue实现了Queue接口，有优先级，内部是用堆实现的，特点如下：
    1. 实现了优先级队列，最先出队的总是优先级最高的，即排序中的第一个。
    2. 优先级可以有相同的，内部元素不是完全有序的，如果遍历输出，除了第一个，其他没有特定顺序。
    3. 查看头部元素的效率很高，为O(1)，入队、出队效率比较高，为O(log2(N))，构建堆heapify的效率为O(N)。
    4. 根据值查找和删除元素的效率比较低，为O(N)。