###### TreeMap内部实现
1. TreeMap的基本构造方法  
    1. 第一种为默认构造方法，不传任何参数，但是要求Map中的键要实现comparable接口
    2. 第二种构造方法要求传一个比较器对象comparator作为参数，若是comparator对象不为null，则调用传进来的比较器对象的compareTo方法  
    
        注：第一种构造方法简单，但要求Map中的键实现comparable接口，第二种更为灵活，不要求键实现comparable接口。最重要的一点是，
     无论哪一种构造方法，内部排序时比较的都是键而非值。
 
2. TreeMap基本用法与HashMap比较
    1. 相同的是，它们都实现了Map接口，都可以按Map进行操作。
    2. 不同的是，迭代时，TreeMap按键有序，为了实现有序，它要求：要么键实现Comparable接口，要么创建TreeMap时传递一个Comparator对象。
    
3. SortedMap接口
    1. firstKey返回第一个键，而lastKey返回最后一个键。
    2. headMap/tailMap/subMap都返回一个视图，视图中包括一部分键值对，它们的区别在于键的取值范围：
        1. headMap：为小于toKey的所有键。 SortedMap<K,V> headMap(K toKey); 
        2. tailMap：为大于等于fromKey的所有键。 SortedMap<K,V> tailMap(K fromKey);
        3. subMap：为大于等于fromKey且小于toKey的所有键。SortedMap<K,V> subMap(K fromKey, K toKey);

4. NavigableMap接口
    1. NavigableMap扩展了SortedMap，主要增加了一些查找邻近键的方法
        1. Map.Entry<K,V> floorEntry(K key);
        2. Map.Entry<K,V> lowerEntry(K key);
        3. Map.Entry<K,V> ceilingEntry(K key);
        4. Map.Entry<K,V> higherEntry(K key);  
 
        注：参数key对应的键不一定存在，但这些方法可能都有返回值，它们都返回一个邻近键值对，它们的区别在于，这个邻近键与参数key的关系。
    
     2. 邻近键与参数key的关系
        1. floorEntry：邻近键是小于等于key的键中最大的
        2. lowerEntry：邻近键是严格小于key的键中最大的
        3. ceilingEntry：邻近键是大于等于key的键中最小的
        4. higherEntry：邻近键是严格大于key的键中最小的
        
        
5. TreeMap实现
    1. TreeMap内部是用红黑树实现的，红黑树是一种大致平衡的排序二叉树 
    2. TreeMap有三个成员comparator，root，size
        1. comparator就是比较器，在构造方法中传递，如果没传，则为null
        2. root拜师树的根节点，从根节点可以访问到每个节点，节点的类型为Entry。
    3. Entry是被final修饰的TreeMap的静态内部类，无法被继承。每个节点除了键(key)和值(value)之外，还有三个引用，分别指向其左孩子(left)、右孩子(right)和父节点(parent)，
    对于根节点，父节点为null，对于叶子节点，孩子节点都为null，还有一个成员color表示颜色，TreeMap是用红黑树实现的，每个节点都有一个颜色，非黑即红。
    