package study.iterator;

import org.junit.Test;
import study.collection.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 迭代器专题
 *      Iterator对象称为迭代器（设计模式中的一种），主要用于遍历Collection集合中的元素。’
 *      GOF四人组给迭代器模式的定义为：提供一种方法访问一个容器（container）对象中各个
 *      元素，又不需暴露该对象的内部细节。迭代器模式，就是为了容器应运而生。
 *
 *      Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么
 *      所有实现了Collection接口的集合类都有iterator()方法。可以通过该方法返回Iterator
 *      接口的对象。该对象就是迭代器对象。
 *      注：每次调用iterator()方法都会获得一个全新的迭代器对象。
 *
 *      迭代器中的常用方法：hasNext() 、nex
 *
 * @author neo
 * @date 2021/6/13 14:58
 */
public class IteratorTest01 {

    @Test
    public void test01(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("String");
        coll.add(new User("smith", "New York"));
        coll.add(45);
        coll.add(false);

        Iterator it = coll.iterator();
        while(it.hasNext()){    /* hasNext() 判断是否还有下一个元素 */
            System.out.println(it.next());  /* 返回下一个元素 */
        }

        // 迭代器中的remove()方法
        /* remove() */
    }

}
