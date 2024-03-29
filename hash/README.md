# 哈希表
## 1、哈希冲突
本质上看，哈希函数的作用是将所有 key 构成的输入空间映射到数组所有索引构成的输出空间，而输入空间往往远大于输出空间。因此，理论上一定存在“多个输入对应相同输出”的情况。

对于上述示例中的哈希函数，当输入的 key 后两位相同时，哈希函数的输出结果也相同。例如，查询学号为 12836 和 20336 的两个学生时，我们得到：
```
12836 % 100 = 36
20336 % 100 = 36
```
两个学号指向了同一个姓名，这显然是不对的。我们将这种多个输入对应同一输出的情况称为「哈希冲突 hash collision」。
容易想到，哈希表容量 越大，多个 key 被分配到同一个桶中的概率就越低，冲突就越少。因此，我们可以通过扩容哈希表来减少哈希冲突。
似于数组扩容，哈希表扩容需将所有键值对从原哈希表迁移至新哈希表，非常耗时。并且由于哈希表容量 capacity 改变，我们需要通过哈希函数来重新计算所有键值对的存储位置，这进一步提高了扩容过程的计算开销。为此，编程语言通常会预留足够大的哈希表容量，防止频繁扩容。
<br>「负载因子 load factor」是哈希表的一个重要概念，其定义为哈希表的元素数量除以桶数量，用于衡量哈希冲突的严重程度，也常被作为哈希表扩容的触发条件。例如在 Java 中，当负载因子超过
时，系统会将哈希表容量扩展为原先的2 倍。

## 2、哈希表扩容
哈希冲突会导致查询结果错误，严重影响哈希表的可用性。为解决该问题，我们可以每当遇到哈希冲突时就进行哈希表扩容，直至冲突消失为止。此方法简单粗暴且有效，但效率太低，因为哈希表扩容需要进行大量的数据搬运与哈希值计算。为了提升效率，我们可以采用以下策略。
1. 改良哈希表数据结构，使得哈希表可以在存在哈希冲突时正常工作。
2. 仅在必要时，即当哈希冲突比较严重时，才执行扩容操作。
   哈希表的结构改良方法主要包括“链式地址”和“开放寻址”。

## 3、链式地址
在原始哈希表中，每个桶仅能存储一个键值对。「链式地址 separate chaining」将单个元素转换为链表，将键值对作为链表节点，将所有发生冲突的键值对都存储在同一链表中


## 4、开放寻址
「开放寻址 open addressing」不引入额外的数据结构，而是通过“多次探测”来处理哈希冲突，探测方式主要包括线性探测、平方探测、多次哈希等。

下面将主要以线性探测为例，介绍开放寻址哈希表的工作机制与代码实现。

1.   线性探测¶
     线性探测采用固定步长的线性搜索来进行探测，其操作方法与普通哈希表有所不同。

插入元素：通过哈希函数计算桶索引，若发现桶内已有元素，则从冲突位置向后线性遍历（步长通常为
），直至找到空桶，将元素插入其中。
查找元素：若发现哈希冲突，则使用相同步长向后线性遍历，直到找到对应元素，返回 value 即可；如果遇到空桶，说明目标元素不在哈希表中，返回
。