package study.set;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * TreeSet：
 * @author neo
 * @date 2021/6/13 21:52
 */
public class TreeSetTest {

    /*
        1、向TreeSet中添加的数据必须是同属一类数据类型【重要】

     */
    @Test
    public void test01TreeSet(){

        Set<Integer> set = new TreeSet<>();
        set.add(500);
        set.add(52);
        set.add(-10);
        set.add(10);
        /* 默认从小到大 */
        System.out.println(set);    // [-10, 10, 52, 500]

        /*
            对于存储自定义类型的排序：
                自定义类型必须实现Comparable接口重写CompareTo(Object o)方法
                或者实现Comparator接口重写compare(Object o1, Object o2)方法

            注意：TreeSet集合中判断相等与不等的标准不是equals()方法。而是比较规则
            返回值是否为0.
         */

        Set<User> users = new TreeSet<>();
        users.add(new User("A", 52));
        users.add(new User("O", 15));
        users.add(new User("A", 20));
        users.add(new User("D", 5));
        System.out.println(users);
    }

    @Test
    public void test2TreeSet(){
        // 按照用户名称升序排序， 若是用户名相同，按照年龄降序排序
        TreeSet<User> users = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compare = o1.getName().compareTo(o2.getName());
                if(compare == 0){
                    return -(o1.getAge() - o2.getAge());
                }
                return compare;
            }
        });

        users.add(new User("A", 15));
        users.add(new User("A", 75));
        users.add(new User("d", 75));
        users.add(new User("O", 75));
        System.out.println(users);

        System.out.println("--------------------");
        // 改写为lambda
        TreeSet<User> users1 = new TreeSet<>((u1, u2) -> {
            int compare = u1.getName().compareTo(u2.getName());
            if (compare == 0){
                return -Integer.compare(u1.getAge(), u2.getAge());
            }
            return compare;
        });

        users1.add(new User("A", 15));
        users1.add(new User("A", 75));
        users1.add(new User("d", 75));
        users1.add(new User("O", 75));
        System.out.println(users1);
    }
}
