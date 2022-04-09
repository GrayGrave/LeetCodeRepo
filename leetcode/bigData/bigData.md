## 大数据和空间限制问题
### 1、布隆过滤器
不安全网页的黑名单包含100亿个网页，每个网页的URL最多占用64B。现在想要实现一种网页过滤系统，可以根据网页的URL判断该网页是否在黑名单上面，请设计系统。
<br>**要求：** <br>
1、允许系统有万分之一以下的判断失误率     <br>
2、使用的额外空间不要超过30GB   <br>

**思路：** 利用hash表进行保存，100亿条URL至少需要640GB空间不符合要求。
**使用布隆过滤器进行解决**,将URL分别经过K个哈希函数进行计算，再对过滤器长度大小进行取余，然后将对应的位置的 bit arr进行涂黑(设置为1).
即将不同的URL进行映射涂黑，便得到了一个bit map，其中已经有相当多的位置被涂黑，即生成了一个布隆过滤器。<br>
**检查阶段：** 将输入的新URL进行k个哈希函数的映射，算出k个值，查看这些位置是否都为黑，若出现一个不为黑则说明该URL一定不在这个集合里，如果都为黑则说明在这个集合中(有可能误判)。即不会放过属于黑名单的URL，可能会将其他URL误判为黑名单里面的URL。即布隆过滤器的失误类型属于“宁可错杀三千，绝不放过一个”
布隆过滤器涉及到的参数：bitMap 的大小m、输入对象的个数(黑名单个数)n、失误率p、hash函数个数k。

`m= -(n*lnp)/(ln2)^2 `<br>
`k=ln2*(m/n)`

### 2、只用2GB内存在20亿个整数中找到出现次数最多的数
哈希表统计：一条记录(key-4B,value-4B)大小为8B，故记录过多会超过2GB内存 <br>
**思路：哈希分流** 到16个文件(每个文件的大小不会超过2GB)，然后每个文件利用哈希表统计各自出现次数最多的数，然后选出16个小文件中出现次数最多的数即可



### 3、40亿个非负整数中找到没出现的数
32位无符号整数的范围是0~4294967295，现在有一个正好包含40亿个无符号整数的文件，所以在整个范围中必然有没有出现过的数。可以使用最多1GB的内存，怎么找到没有出现过的数？

**思路：**<br>
若使用哈希表来保存出现过的数，若40亿个数都不相同，则哈希表的记录为40亿条，存一个32位整数需要 4B，则最差情况下需要40亿*4B=160亿字节，
大约需要16GB空间，不符合要求。
**使用bit map 来表示数出现的情况**，即申请一个长度为4294967295的bit类型的数组bitArr，每个位置可以表示0
或者1状态。该bit类型的数组占用500MB空间。然后遍历40个数，将遇到的数字在对应数组位置设置为1，遍历完成后再依次遍历bitArr数组，找出为0的位置，即可得出没有出现的数字。

**进阶问题:** 只有10MB内存，找到其中一个没有出现的数即可 <br>
1、划分64个区间，找某个区间上面有未出现的数（根据映射到该区间的数量决定）<br>
2、申请长度为区间长度的bit map，进行遍历标记，找出没出现的数字。



### 4、找到100亿个URL中重复的URL以及搜索词汇的top K 问题
**url问题：** hash分流到不同的文件或者机器进行处理即可

**topK 问题：**哈希分流到不同的不同的机器，如果还有内存限制则再分流到不同的文件。
hash表统计不同搜索词的词频，然后遍历哈希表，输入容量为K的**小根堆**，最后得到文件的topK搜索词，
不同文件的topK 再次利用小根堆得到机器内的topK，继续利用小根堆得到所有机器的全局topK，问题便得到了解决。


### 5、40亿个非负数整数中找到出现两次的数和所有数的中位数

32 位无符号整数的范围是0~4294967295，现在有一个正好包含40亿个无符号整数的文件。可以使用最多1GB的内存，怎么找到出现了两次的数。

**补充问题：** 最多使用10MB的内存，找到这40亿个整数的中位数。<br>
**思路：** bit map 使用两个bit 表示出现的次数 01(一次) 10(两次) 11(三次)  然后遍历寻找10的数据即可

**补充问题：** 最多使用10MB内存空间，找到40亿个整数的中位数<br>
**思路：** 即找排序后的第20亿个数，思路也是先根据10MB内存限制进行分区，然后统计区间数字个数，然后确定中位数所处的区间，在该区间中即可找到中位数。

### 6、一致性哈希的基本原理 数据存在集群，如何确定存在哪个机器的问题
**背景：** 工程师常常使用服务集群来设计和实现数据缓存，故数据的操作需要知道应该在哪个机器上，进而引出了一致性哈希的问题。

**以下是常见策略：**<br>
1、无论是添加、查询还是删除数据，都先将数据的id通过哈希函数转换成一个哈希值，记为key。<br>
2、如果目前机器有N台，则计算key%N的值，该值就是数据所属的机器编号，无论是添加、删除还是查询操作，都只在这台机器上面进行<br>
分析这种缓存策略可能带来的问题，并提出改进方案。

**解答：** <br>
潜在问题是，若增加或者删除机器(N变化)代价会很高，所有的数据ID不得不根据ID重新计算一遍哈希值，并将哈希值对新的机器数进行取模操作，然后进行大规模的数据迁移。

**解决方案：** <br>
假设数据的ID经过哈希函数转换成的哈希范围是2^32，也就是0~(2^32)-1的数字空间中。将这些数字头尾相连，即形成一个闭环，那么一个数据ID在计算出hash之后认为对应到环中的一个位置上。
然后顺时针寻找离这个位置最近的机器，便找到该数据的归属。 这样机器的增减，对数据的移动都比较小。<br>
**解决数据倾斜的问题，** 即数据分布不均。一个机器对应多个虚拟节点，虚拟节点分布环的不同位置，数据先找到最近的虚拟节点，然后映射到对应的具体机器节点。