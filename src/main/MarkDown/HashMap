###### HashMap内部实现
1. Map接口
    1. Map接口有两个类型参数，K和V，分别表示键(Key)和值(Value)的类型
    
    2. keySet()/values()/entrySet()有一个共同的特点，它们返回的都是视图，不是拷贝的值，基于返回值的修改会直接修改Map自身
    
2. HashMap实现  
    1. table是一个Entry类型的数组，其中的每个元素指向一个单向链表，链表中的每个节点表示一个键值对，Entry是一个内部类
    
    2. table的初始值为EMPTY_TABLE，是一个空表,当添加键值对后，table就不是空表了，它会随着键值对的添加进行扩展，扩展的策略类似于ArrayList，添加第一个元素时，默认分配的大小为16，不过，并不是size大于16时再进行扩展，下次什么时候扩展与threshold有关。
    
    3. threshold表示阈值，当键值对个数size大于等于threshold时考虑进行扩展。threshold是怎么算出来的呢？一般而言，threshold等于table.length乘以loadFactor，比如，如果table.length为16，loadFactor为0.75，则threshold为12。
    loadFactor是负载因子，表示整体上table被占用的程度，是一个浮点数，默认为0.75，可以通过构造方法进行修改。
    
    
    