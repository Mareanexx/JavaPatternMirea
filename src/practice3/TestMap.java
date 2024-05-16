package practice3;

import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) throws InterruptedException {
        LockedMap<Integer, String> myMap = new LockedMap<>();
        Thread thread1 = new Thread(() -> {
            myMap.put(1, "Value 1");
            myMap.put(2, "Value 2");
            myMap.put(3, "Value 3");
        });

        Thread thread2 = new Thread(() -> {
            myMap.put(4, "Value 4");
            myMap.put(5, "Value 5");
            myMap.put(6, "Value 6");
        });

        thread1.start();
        thread2.start();

        Thread.sleep(20);

        System.out.println("Количество элементов в mymap: " + myMap.size());
        Set<Map.Entry<Integer, String>> setofmap = myMap.entrySet();
        for (Map.Entry<Integer, String> entryset : setofmap) {
            System.out.println(entryset.getKey() + " " + entryset.getValue());
        }

    }
}
