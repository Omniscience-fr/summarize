###### ArrayList内部实现

1. ArrayList添加元素的方法，它首先调用ensureCapacityInternal()方法，确保数组容量足够
  
    1. ensureCapacityInternal()方法:  
        &ensp;&ensp;&ensp;&ensp;它先判断数组是不是空的，如果是空的则首次至少要分配的大小为DEFAULT_CAPACITY，DEFAULT_CAPACITY的值为10，接下来调用ensureExplicitCapacity  
        
    2. ensureExplicitCapacity()方法:  
        &ensp;&ensp;&ensp;&ensp;首先记录修改的次数，其次如果需要的长度大于当前数组的长度，则调用grow()方法
        
    3. grow()方法:  
        &ensp;&ensp;&ensp;&ensp;真正将数组长度进行扩容的方法，先将数组原本的长度赋值给新定义的变量oldCapacity，
     再将变量oldCapacity右移一位，相当于oldCapacity变量除以2，然后再加上原来的变量oldCapacity，将得到的新值
     赋值给新定义的变量newCapacity，变量newCapacity的长度为原本数组长度，也就是变量oldCapacity的1.5倍。
     最后利用Arrays.copyof()方法,将原数组的内容以及新的长度newCapacity，拷贝到另一个新的数组中。  
     
     4. 扩容1.5的原因:  
         &ensp;&ensp;&ensp;&ensp;长度扩容为原来的1.5倍的原因与StringBuffer和StringBuild的扩容原因一样，
     一方面是为了减少调用扩容的次数，另一方面是为了减少不必要的内存浪费
     
2. 迭代器  
    1. ArrayList类实现了Iterable接口  
         &ensp;&ensp;&ensp;&ensp;Iterable表示可迭代。Iterable接口实现了iterator方法，iterator方法的返回值
    为实现了Iterator接口的对象
    
    2. Iterable和Iterator的区别  
        1. Iterable表示对象可以被迭代，它有一个方法iterator()，返回Iterator对象，实际通过Iterator接口的方法进行遍历。  
        
        2. 如果对象实现了Iterable，就可以使用foreach语法。
        
        3. 类可以不实现Iterable，也可以创建Iterator对象。
    3. ListIterator接口  
        &ensp;&ensp;&ensp;&ensp;ListIterator接口拓展了Iterator接口，增加了一些方法，向前遍历、添加元素、修改元素、返回索引位置等
        
    4. 迭代的陷阱  
        &ensp;&ensp;&ensp;&ensp;迭代器有一个常见的误区，就是在迭代的过程中调用删除的方法，但往往会抛出并发修改异常
    java.util.ConcurrentModificationException。原因是迭代器内部会维护索引相关位置的数据，
    要求在迭代过程中不允许出现结构性变化(添加，删除，插入元素，修改不算结构性变化)，否则索引就失效了。若一定要在迭代
    过程中删除元素，可以使用迭代器本身的删除方法。  
    
    5. 迭代器实现原理  
        &ensp;&ensp;&ensp;&ensp;ArrayList中iterator方法是新创建一个对象，这个对象是一个内部类，实现了Iterator接口，
    这个内部类有三个成员变量：int cursor; int lastRet = -1;int expectedModCount = modCount;  
        1. cursor表示下一个要返回的元素位置  
        
        2. lastRet表示最后一个返回的索引位置  
        
        3. expectedModCount表示期望的修改次数，初始化为外部类当前的修改次数modCount   
       
       &ensp;&ensp;&ensp;&ensp;每次发生结构性变化的时候modCount都会增加，而每次迭代器操作的时候都会检查expectedModCount是否与modCount相同，这样就能检测出结构性变化.
       
       &ensp;&ensp;&ensp;&ensp;这个内部类实现Iterator接口的原理：  
       
        1. hasNext()方法：用cursor与size进行比较，返回值为布尔型  
        
        2. next()方法：首先调用了checkForComodification()方法，若外部类的修改次数(modCount)不等于内部类的修改次数(expectedModCount),
        则抛出并发修改异常ConcurrentModificationException，若没有抛出异常，则将下一个要返回的元素位置，赋给新定义的变量i，并判断这个变量
        与size的大小，若小于size，则抛出并发修改异常，若大于size，则将现有数据赋给新定义的Object数组，
        并判断Object数组与变量i的大小，若变量i大于等于Object数组的长度，则抛出并发修改异常，否则将变量i自增1，并重新赋给cursor，
        返回对应的元素。
        
        3. remove()方法：首先判断最后一个返回的索引位置(lastRet)是否小于0，若小于，则抛出异常，否则继续调用checkForComodification()方法进行
        检测，若检测没有抛出异常，则调用ArrayList本身的remove方法，将最后一个返回的索引位置删除，并将cursor，lastRet，expectedModCount
        变量的值进行更新。
        
        &ensp;&ensp;&ensp;&ensp;注：调用remove方法之前，必须要先调用next()方法，否则将抛出异常
        
   
    6. ArrayList实现的接口  
        1. Collection：表示一个数据集合，数据间没有位置或顺序的概念  
        
        2. List：表示有顺序或位置的数据集合，它扩展了Collection  
        
        3. RandomAccess：没有定义任何代码，是一个标记接口，表示可以随机访问  
        
    7. ArrayList特点：内部采用动态数组实现  
       1.  可以随机访问，按照索引位置进行访问效率很高，用算法描述中的术语，效率是O(1)，简单说就是可以一步到位。  
       
       2. 除非数组已排序，否则按照内容查找元素效率比较低，具体是O(N)，N为数组内容长度，也就是说，性能与数组长度成正比  
       
       3. 添加元素的效率还可以，重新分配和拷贝数组的开销被平摊了，具体来说，添加N个元素的效率为O(N)。  
       
       4. 插入和删除元素的效率比较低，因为需要移动元素，具体为O(N)  
       
       
        
        