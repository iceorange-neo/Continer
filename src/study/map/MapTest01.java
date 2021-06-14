package study.map;

import org.junit.Test;

/**
 * 一：简介
 * Map:双列集合，key-value
 *      HashMap:非线程安全，可以存储null的key和value
 *          LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *              在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *              jdk1.7：数组+链表
 *              jdk1.8：数组+链表+红黑树
 *
 *      TreeMap:可按照排序规则实现排序遍历(key)。
 *              红黑树
 *      Hashtable:线程安全，不能存储null的key和value
 *          Properties:属性配置类（key和value都是String类型）
 *
 * 二、Map结构：
 *      Map中的key：无序、不可重复，使用Set存储所有的key  [重写equals()和hashCode()]
 *      Map中的value：无序、可重复的，使用Collection存储所有的value
 *      一个键值对：key-value构成了一个value。
 *      Map中的Entry是无序、不可重复的，使用Set存储Entry。
 *
 * 三、HashMap底层实现原理？
 *      jdk7：HashMap = new HashMap();
 *      在实例化之后，底层创建了一个长度为16的一维数组Entry[] table。
 *      ....
 *      map.put(key, value);
 *      首先，计算key所在类的hashCode()方法计算hash值，通过散列函数计算后，得到在Entry数组中的
 *      存放位置。
 *      若此位置上数据为空，此时key添加成功。
 *      若此位置上数据非空，比较当前key和其他存在的Entry对象中的key比较哈希值：
 *          若key的哈希值与已经存在的数据的hash值都不同，则添加成功。
 *          若key的哈希值与某一个数据的hash值相同，则拿着key所在类的equals()方法比较：
 *              若equals()返回false，此时key-value添加成功。
 *              若equals（）返回true，使用key对于的value替换value值。
 *      扩容问题：默认扩容为原容量的2倍，加载因子是0.75.
 *
 *      jdk8的改进：
 *          1、new HashMap()：底层没有创建一个长度为16的数组
 *          2、jdk8底层数组是：Node[]
 *          3、首次调用put()方法时，才会创建长度为16的数组。
 *          4、jdk7底层结构是数组+链表，jdk8是数组+链表+红黑树
 *              当数组的某一个索引位置上的元素以链表形式存在的数据个数>8 且数组长度>64时，
 *              此时此索引位置上的所有数据改为使用红黑树存储。
 * @author neo
 * @date 2021/6/14 15:00
 */
public class MapTest01 {

    public static void main(String[] args){


    }

    @Test
    public void testHashMap(){

    }

    @Test
    public void testLinkedHashMap(){

    }

}
