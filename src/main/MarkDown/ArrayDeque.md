###### ArrayDeque实现
1. ArrayDeque构造方法
    1. public ArrayDeque()
    2. public ArrayDeque(int numElements)
    3. public ArrayDeque(Collection<? extends E> c)  
    numElements表示元素个数，初始分配的空间会至少容纳这么多元素，但空间不是正好numElements这么大

2. ArrayDeque内部实现
    1. ArrayDeque内部主要实例变量
        1. private transient E[] elements;
        2. private transient int head;
        3. private transient int tail;  
        elements就是存储元素的数组。ArrayDeque的高效来源于head和tail这两个变量，它们使得物理上简单的从头到尾的数组变为了一个逻辑上循环的数组，避免了在头尾操作时的移动。
        
    2. 循环数组  
        对于一般数组，比如arr，第一个元素为arr[0]，最后一个为arr[arr.length-1]。但对于ArrayDeque中的数组，它是一个逻辑上的循环数组，所谓循环是指元素到数组尾之后可以接着从数组头开始，数组的长度、第一个和最后一个元素都与head和tail这两个变量有关  
        1. 如果head和tail相同，则数组为空，长度为0。
        2. 如果tail大于head，则第一个元素为elements[head]，最后一个为elements[tail-1]，长度为tail-head，元素索引从head到tail-1。
        3. 如果tail小于head，且为0，则第一个元素为elements[head]，最后一个为elements[elements.length-1]，元素索引从head到elements.length-1。
        4. 如果tail小于head，且大于0，则会形成循环，第一个元素为elements[head]，最后一个是elements[tail-1]，元素索引从head到elements.length-1，然后再从0到tail-1。  
        
    3. 构造方法
        1. 默认构造方法： public ArrayDeque() {elements = (E[]) new Object[16];}，初始化创建了一个长度为16的object数组
        2. 带参构造方法1：public ArrayDeque(int numElements) {allocateElements(numElements);}，numElements为指定数组长度
        3. 带参构造方法2：public ArrayDeque(Collection<? extends E> c) {allocateElements(c.size());addAll(c);}
    4. allocateElements()方法流程：  
        1. 定义变量initialCapacity为初始化长度，并将静态常量MIN_INITIAL_CAPACITY赋值给initialCapacity，静态常量的值为8
        2. 判断手动定义的数组长度numElements与initialCapacity的大小，若numElements小于initialCapacity，则创建的数组长度为8
        3. 若numElements大于等于initialCapacity，则将numElements赋给initialCapacity，将initialCapacity进行如下运算：
            1. initialCapacity与initialCapacity无符号右移一位的异或值赋给initialCapacity
            2. initialCapacity与initialCapacity无符号右移两位的异或值赋给initialCapacity
            3. initialCapacity与initialCapacity无符号右移四位的异或值赋给initialCapacity
            4. initialCapacity与initialCapacity无符号右移八位的异或值赋给initialCapacity
            5. initialCapacity与initialCapacity无符号右移十六位的异或值赋给initialCapacity
            6. initialCapacity自增1
        4. 判断运算结束后的initialCapacity值是否小于零，若是，继续将initialCapacity加上initialCapacity无符号右移一位的值赋给initialCapacity，作为数组长度
        5. 若运算结束后的initialCapacity值大于零，则直接将运算结束后的initialCapacity值作为数组长度进行创建  
    
    总结：   
        1. 如果numElements小于MIN_INITIAL_CAPACITY，则分配的数组长度就是MIN_INITIAL_CAPACITY，它是一个静态常量，值为8。  
        2. 在numElements大于等于8的情况下，分配的实际长度是严格大于numElements并且为2的整数次幂的最小数。比如，如果numElements为10，则实际分配16，如果numElements为32，则为64。
        
    5. addAll,add和addLast方法
        1. addAll方法，将集合中的元素作为参数，传递给add方法，并循环调用add方法
        2. add方法：调用addLast方法，将元素作为参数直接传递，并返回true
        3. addLast方法：
            1. 先判断传递进来的元素是否为空，若是则抛出空指针异常
            2. 若元素不为空，则将元素添加到数组elements的tail处
            3. 判断队列是否满值，若满，则调用doubleCapacity()方法进行两倍扩容  
            （判断队列满值的方式为：判断tail的下一个位置是否等于head，(tail + 1) & (elements.length - 1)==head ，head为数组的第一个元素位）
    6. doubleCapacity方法
        1. assert断言判断head和tail是否相等，若相等继续执行，若不等则抛出异常
        2. 定义变量n、p、r，并将head赋给n，数组长度（elements.length）赋给p，n-p的值赋给r
        3. 定义变量newCapacity作为新的数组长度，并将n左移一位后的值赋给newCapacity
        4. 判断newCapacity是否小于0，若是则抛出异常：双端队列太大了
        5. 新建一个长度为newCapacity的object数组
        6. 将head右边的元素拷贝到新数组开头处（System.arraycopy(elements, p, a, 0, r);）
        7. 再拷贝左边的元素到新数组中（System.arraycopy(elements, 0, a, r, p);）
        8. 最后重新设置head和tail，head设为0，tail设为n
        
    补充源码：  
        public static native void arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);  
        @param      src      原数组  
     * @param      srcPos   原数组开始位置  
     * @param      dest      目标数组  
     * @param      destPos  目标数组开始位置.  
     * @param      length    复制的长度  
     * @exception  IndexOutOfBoundsException 数组越界  
     * @exception  ArrayStoreException   类型不匹配  
     * @exception  NullPointerException  原数组或目标数组为Null 
 
    7. addFirst方法
        1. 判断元素是否为null，若是则抛出空指针异常
        2. 要先让head指向前一个位置，然后再赋值给head所在位置。head的前一个位置是：(head - 1) & (elements.length - 1)。刚开始head为0，如果elements.length为8，则(head - 1) & (elements.length - 1)的结果为7。
        3. 判断队列是否满值，若是则进行扩容
        
    8. pollFirst方法
        1. 将head赋值给新的变量h，获取到数组中h位的元素，赋值给result变量
        2. 判断result是否为null，若是则返回null
        3. 将数组中h位的元素设置成null
        4. 将head指向下一位（(h + 1) & (elements.length - 1)）
        
    9. pollLast方法
        1. 与pollLast方法类似，获取到最后一个位置并赋值给新的变量t，然后获取数组中t位的元素，赋值为result变量
        2. 判断result是否为null，若是则返回null
        3. 将数组中t位的元素设置成null
        4. 将tail指向前一位,即将t赋值为tail
        
3. ArrayDeque实现了双端队列，内部使用循环数组实现，这决定了它有如下特点：
    1. 在两端添加、删除元素的效率很高，动态扩展需要的内存分配以及数组拷贝开销可以被平摊，具体来说，添加N个元素的效率为O(N)。
    2. 根据元素内容查找和删除的效率比较低，为O(N)。
    3. 与ArrayList和LinkedList不同，没有索引位置的概念，不能根据索引位置进行操作。
    