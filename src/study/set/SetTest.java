package study.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * Set集合：
 *    1、无序不可重复
 *    2、常用实现类：
 *          HashSet：非线程安全，可以存储null值，底层数据结构是hash表
 *          LinkedHashSet：：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历。
 *          TreeSet：父接口是SocketSet，底层数据结构是二叉树，可以按照自然比较规则排序。也可以自定义比较规则。
 * @author neo
 * @date 2021/6/13 16:55
 */
public class SetTest {

    /*
        无序：添加的顺序不是按照线性结构放的。底层是HashMap，涉及到的是hash值。hash值是"随机的"。
        不可重复：key不可重复[详情见HashMap] 底层还有equals()

        如何实现的无序和不可重复。
        Set中添加元素的过程：以HashSet为例：
            向HashSet中添加元素，首先调用元素所在类的hashCode()方法，得到哈希值，根据
            散列函数计算出在HashSet底层bucket中的存放位置（--索引），判断数组此位置上
            是否含有其他元素：
                若此位置上无其他元素，直接添加，返回true。
                若此位置上有其他元素（或以链表的形式存在多个元素），则比较两元素的hash值：
                    若hash值不同，则元素添加成功，返回true。
                    若hash值相同，进行需要调用元素所在类的equals()方法：
                        equals()返回true，元素添加失败。
                        equals()返回false，元素添加成功。

         结论：在Set集合中存储的元素一定要同时重写hashCode()和equals()方法
                这两个方法尽可能保持一致性。[相等的对象必须具有相等的哈希值]
                    [equals()方法返回true。则hash码值一定相等
                    但是hash码值相等，equals()不一定为true]
     */
    @Test
    public void testHashSet(){
        Set<String> set = new HashSet<>();
        set.add("B");
        set.add("O");
        set.add("E");
        set.add("I");
        set.add("A");
        set.add("A");
        System.out.println(set);
    }

    /*
        LinkedHashSet是HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，
        记录此数据的前一个数据和后一个数据。
        优点：对于频繁的遍历操作，使用LinkedHashSet
     */
    @Test
    public void testLinkedHashSet(){
        /*
            LinkedHashSet：无序不可重复
                这里的无序需要注意
         */
        Set<String> set = new LinkedHashSet<>();
        set.add("B");
        set.add("A");
        set.add("A");
        set.add("C");
        set.add("O");
        set.add("I");
        System.out.println(set);    // [B, A, C, O, I] 取出的顺序和添加的顺序是一致的、

    }
}
