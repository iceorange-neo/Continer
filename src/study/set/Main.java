package study.set;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neo
 * @date 2021/6/14 0:33
 */
public class Main {
    @Test
    public void testHashMap(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Anderson", 31);
        hashMap.put("Smith", 30);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println(hashMap);
    }
}
