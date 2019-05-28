###### String内部实现
 1. String类内部用一个字符数组表示字符串，实例变量定义为:  
       
        private final char value[];
 
 2. String有两个构造方法，可以根据char数组创建String:
 
        public String(char value[])
        public String(char value[], int offset, int count)
  
 3. String内部实际操作:  
  
        需要说明的是，String会根据参数新创建一个数组，并拷贝内容，而不会直接用参数中的字符数组。
        String中的大部分方法，内部也都是操作的这个字符数组。比如说：
            1. length()方法返回的就是这个数组的长度
            2. substring()方法就是根据参数，调用构造方法String(char value[], int offset, int count)新建了一个字符串
            3. indexOf查找字符或子字符串时就是在这个数组中进行查找   
            
 4. String的不可变性  
   
        1. String类是不可变类，即对象一旦创建，就没有办法修改了。
        2. String类也声明为了final，不能被继承，内部char数组value也是final的，初始化后就不能再变了
        
###### StringBuilder和StringBuffer内部实现  
 1. 内部组成和构造方法  
 
        1. 与String类似，StringBuilder类也封装了一个字符数组，定义如下：
            char[] value;
        2. 与String不同，它不是final的，可以修改。
        3. 另外，与String不同，字符数组中不一定所有位置都已经被使用，它有一个实例变量，表示数组中已经使用的字符个数，定义如下：
            int count;
        4. StringBuilder继承自AbstractStringBuilder
        
 2. StringBuilder和StringBuffer总结：  
 
        1. StringBuilder和StringBuffer之所以可以修改，是因为内部不是用final修饰的
        2. StringBuilder和StringBuffer的所有插入方法，会先自动计算参数长度，若长度符合，将会把参数拷贝到内部的字符数组中
        若长度不符合，将会进行长度拓展
        3. 长度拓展是2倍加+2的形式增长，默认长度为16，一次拓展之后的长度是：16*2+2=34
        4. 以2倍加+2的形式增长是一种折中策略，一方面减少内存分配的次数，另一方便避免空间浪费
        
   
        
        