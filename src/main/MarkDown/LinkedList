###### LinkedList内部实现

1. List接口  

        LinkedList与ArrayList一样，同样实现了List接口，而List接口扩展了Collection接口，Collection又扩展了Iterable接口，所有这些接口的方法都是可以使用的
        
2. 队列（queue）

    1. LinkedList还实现了队列接口Queue,队列的特点是先进先出，在尾部添加元素，在头部删除元素
    
    2. Queue拓展了Collection接口  
        1.  在尾部添加元素 (add, offer)
        
        2. 查看头部元素 (element, peek)，返回头部元素，但不改变队列
        
        3. 删除头部元素 (remove, poll)，返回头部元素，并且从队列中删除  
        
     &ensp;&ensp;&ensp;&ensp;每种操作都有两种形式，是为了对特殊情况的处理，特殊情况指的是队列为空或者队列满溢（队列有长度限制，但已经占满了，
     虽然LinkedList实现中，队列没有长度的限制，但是其他的queue有限制。）  
     &ensp;&ensp;&ensp;&ensp;队列为空时element和remove方法会抛出异常(NoSuchElementException)，而peek和poll会抛出null
     队列为满时，add会抛出异常IllegalStateException，而offer只会返回false。
     
3. 栈（Stack）----类已过时

    1. 栈与队列相反，特点是先进后出
        
    2. java中没有直接操作栈的接口，栈的方法都包含在了双端队列的接口Deque中
        
        1. push表示入栈，在头部添加元素，栈的空间可能是有限的，如果栈满了，push会抛出异常IllegalStateException。
        
        2. pop表示出栈，返回头部元素，并且从栈中删除，如果栈为空，会抛出异常NoSuchElementException。
        
        3. peek查看栈头部元素，不修改栈，如果栈为空，返回null。
        
4. 双端队列（Deque）

    1. 栈和队列都是在两端进行操作，栈只操作头部，队列两端都操作，但尾部只添加，头部只删除，查看
       
    2. Deque是两端都进行操作的队列，对queue进行了拓展，包含了栈的操作方式  
        1. xxxFirst操作头部，xxxLast操作尾部。与队列类似，每种操作有两种形式，区别也是在队列为空或满时，处理不同
        
        2. 为空时，getXXX/removeXXX会抛出异常，而peekXXX/pollXXX会返回null。队列满时，addXXX会抛出异常，offerXXX只是返回false。
        
    3. Deque还支持倒序迭代，即从后往前迭代，descendingIterator（）方法
    
5. 内部实现

    1. ArrayList内部是数组实现的，元素在内存是连续存放的，但LinkedList不是，LinkedList内部是是双向链表实现的，每个元素在内存都是
    单独存放的，元素之间通过链接连在一起
    
    2. 双向链表的整个元素是一个节点（node），一个节点中有两条链，元素左边的代表前驱（prev），指向前一个元素，元素右边的代表后继（next），
    指向下一个元素 。
    
    3. Add方法，主要调用了linkLast()方法  
        1. 先创建一个新的节点newNode
        
        2. 修改尾节点last，指向新的最后节点newNode
        
        3. 修改前节点的后向链接，如果原来链表为空，则让头节点指向新节点，否则让前一个节点的next指向新节点。
        
        linkLast方法流程总结：先创建一个新的节点，将要插入位置的左边节点的后继指向新节点，并将新节点的前驱指向左边节点，判断要插入位置的右边节点是否有元素，
        若没有，就将新节点的前驱指向头结点，否则将新节点的后继指向后边节点，并将右边节点的后继指向新节点
        
    4. LinkedList特点分析  
     &ensp;&ensp;&ensp;&ensp;LinkedList内部是用双向链表实现的，维护了长度、头节点和尾节点，这决定了它有如下特点
         1. 按需分配空间，不需要预先分配很多空间
         
         2. 不可以随机访问，按照索引位置访问效率比较低，必须从头或尾顺着链接找，效率为O(N/2)。
         
         3. 不管列表是否已排序，只要是按照内容查找元素，效率都比较低，必须逐个比较，效率为O(N)。
         
         4. 在两端添加、删除元素的效率很高，为O(1)。
         
         5. 在中间插入、删除元素，要先定位，效率比较低，为O(N)，但修改本身的效率很高，效率为O(1)。
        