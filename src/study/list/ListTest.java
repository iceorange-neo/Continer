package study.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * List接口的测试：
 *      ArrayList：作为List接口的主要实现类，底层是Object数组，非线程安全。默认初始化容量为10，默认原容量1.5倍
 *      大小扩容。效率高。
 *
 *      LinkedList：底层数据结构是双向链表，适用于频繁的插入和删除操作。
 *
 *      Vector：作为List接口的古老实现类。底层是Object数组，线程安全的。默认初始化
 *      容量是10，默认原容量2倍大小扩容，效率低。
 *
 * @author neo
 * @date 2021/6/13 15:48
 */
public class ListTest {

    @Test
    /**
     * ArrayList底层源码分析：
     *     jdk1.7和1.8不同
     *
     *   在jdk1.7中：
     *      public ArrayList(){
     *          // 调用重载的构造器：传入初始化容量10
     *          this(10);
     *      }
     *
     *      public boolean add(E e){
     *          ensureCapacityInternal(size + 1);   // 确认容量够？ 会涉及到扩容机制
     *          // 什么时候扩容？ 当次此添加导致底层elementData数组容量不够时，默认按照
     *          原容量1.5倍大小扩容。
     *
     *          elementData[size++] = e;
     *          return true;
     *      }
     *      结论：推荐使用预估容量对ArrayList进行初始化。为了避免频繁扩容。
     *
     *   在jdk1.8中：
     *      public ArrayList() {
     *          // public static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     *         this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     *      }
     *
     *      public boolean add(E e) {
     *         ensureCapacityInternal(size + 1);  // Increments modCount!!
     *         elementData[size++] = e;
     *         return true;
     *     }
     *     // 为了节省内存    [延迟机制]
     *     // 调用无参构造器的时候会创建一个{}数组。
     *     // 在第一次调用add()方法的时候才会创建容量为10的数组，并将数据添加。
     */
    public void testArrayList(){
        ArrayList list = new ArrayList();
    }

    /**
     * LinkedList底层源码分析：双向链表
     *     // Node节点
     *     transient int size = 0;
     *     transient Node<E> first; // 首节点
     *     transient Node<E> last;  // 尾节点
     *
     *     private static class Node<E>{
     *         E item;
     *         Node<E> next;
     *         Node<E> prev;
     *
     *         Node(Node<E> prev, E element, Node<E> next){
     *             this.item = item;
     *             this.next = next;
     *             this.prev = prev;
     *         }
     *     }
     *
     *     public boolean add(E e){
     *         linkLast(e);     // 添加元素会调用的方法
     *         return true;
     *     }
     *
     *     void linkLast(E e){
     *          final Node<E> l = last;
     *          final Node<E> newNode = new Node(l, e, null);   // 构造新节点
     *          last = newNode;
     *          if( l == null) first = newNode;
     *          else l.next = newNode;
     *          size++;
     *          modCount++;
     *     }
     *
     *    总结：内部声明了Node类型的first和last属性，默认值为null。
     *    list.add(elm);  // 将elm封装到Node中，创建Node对象。
     */
    public void testLinkedList(){

    }

    /*
        List接口中的常用方法：
     */
    @Test
    public void testFunction(){

        List<Integer> list = new ArrayList<>();
        /* void add(int index, Object ele)：在index位置上插入ele元素 */
        list.add(45);
        System.out.println(list);

        /* boolean addAll(int index, Collection elms)：从index位置开始将elms中的所有元素添加进入 */
        list.addAll(0, Arrays.asList(111, 222, 111));
        System.out.println(list);

        /* Object get(int index)：获取指定index位置的元素 */
        System.out.println(list.get(0));

        /* int indexOf(Object obj)：返回obj在当前集合中首次出现的位置 */
        System.out.println(list.indexOf(222));

        /* int lastIndexOf(Object obj)：返回obj在当前集合中最后一次出现的位置 */
        System.out.println(list.lastIndexOf(111));

        /* Object remove(int index)：移除指定index位置的元素，并返回此元素 */
        list.remove(0);
        System.out.println(list);

        /* Object set(int index, Object elm)：设置指定index位置的元素为elm */
        list.set(0, 777);
        System.out.println(list);

        /* List subList(int fromIndex, int toIndex)：但会从fromIndex到toIndex位置的子集合 */
        List<Integer> subList = list.subList(0, 2);
        System.out.println(subList);
    }

    /*
        List集合的遍历的方式
     */

    @Test
    public void testTraverse(){
        List<Integer> list = Arrays.asList(123, 456, 789);
        // 方式一：迭代器
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + "  ");
        }
        System.out.println();
        // 方式二：foreach
        for(int elm : list){
            System.out.print(elm + "  ");
        }
        System.out.println();
        // 方式三：get(index)
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
