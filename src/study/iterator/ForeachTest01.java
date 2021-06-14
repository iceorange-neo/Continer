package study.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author neo
 * @date 2021/6/13 15:43
 */
public class ForeachTest01 {

    @Test
    public void test(){

        Collection coll = Arrays.asList(123, 456);

        /* foreach */
        for (Object elm : coll){
            System.out.println(elm);
        }
    }
}
