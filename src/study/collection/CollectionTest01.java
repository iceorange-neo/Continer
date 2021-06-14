package study.collection;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明方法的测试
 * @author neo
 * @date 2021/6/13 13:46
 */
public class CollectionTest01 {

    @Test
    public void test01(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(11);
        coll.add(123);
        coll.add(false);
        coll.add("hello");
        coll.add(new Object());
        coll.add(new User("smith", "Italian"));
        User user = new User("sun", "America");
        coll.add(user);

        // 1、contains(Object obj)：判断当前集合中是否包含obj
        System.out.println(coll.contains(123)); // true
        /* 需要查看源码 */
        /*
            contains(Object obj)底层调用了equals()方法
            结论：存储在集合中的自定义类型需要重写equals()方法
         */
        System.out.println(coll.contains(new User("smith", "Italian")));    // false
        System.out.println(coll.contains(user));    // true

        // 2、containsAll(Collection coll)：判断形集合中的所有元素是否都存在于当前集合中。
        /*
            Arrays.asList(Object .. args)：将可变长参数转化为Collection集合
         */
        Collection coll1 = Arrays.asList(123);
        System.out.println(coll.containsAll(coll1));    // true
    }

    @Test
    public void test02(){
        // 3、public boolean remove(Object obj)：移除collection中的指定元素
        // return true：删除成功     return false：删除失败
        /*
            remove()底层也是调用的equals()方法
         */
        Collection coll = new ArrayList();
        coll.add(12);
        coll.add(12);
        coll.add(18);
        coll.add("String");
        System.out.println(coll);   // [12, 12, 18, String]
        coll.remove(12);    // 移除第一个匹配的元素
        System.out.println(coll);   // [12, 18, String]

        // 4、removeAll(Collection coll1)：移除在当前集合中coll1集合中存在的元素
        Collection coll1 = Arrays.asList(12);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test03(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("sun");
        coll.add("summer");
        coll.add("first");
        coll.add(new User("allen", "New York"));
        Collection coll1 = Arrays.asList(123, "sun", new User("allen", "New York"));

        /* 5、retainAll(Collection coll) ：类似取交集 */
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);

        // 6、equals(Object obj)：两个集合中的元素完全一致返回true
        Collection coll2 = Arrays.asList(123, 456);

//        Collection coll3 = Arrays.asList(123, 456);
        Collection coll3 = new Vector();
        coll3.add(123);
        coll3.add(456);
        System.out.println(coll2.equals(coll3));
    }

    @Test
    public void test04(){
        // 7、hashCode()：计算当前对象的hash值
        Collection coll = Arrays.asList(123);
        System.out.println(coll.hashCode());

        // 8、toArray()：转化为Object[]
        Object[] objects = coll.toArray();
        System.out.println(Arrays.toString(objects));

        /*
            扩展：
         */
        List<int[]> list = Arrays.asList(new int[]{123, 456});
        System.out.println(list);   // [[I@5e8c92f4]
        System.out.println(list.size());    // 1
    }

}
