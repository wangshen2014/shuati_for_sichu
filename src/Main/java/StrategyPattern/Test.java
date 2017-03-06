package StrategyPattern;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by patrickyu on 10/12/16.
 */
public class Test {
    public static void main(String[] args) {

        A obj = new A();
        obj.func(new X() {
            @Override
            public void work() {
                System.out.println("working");
            }
        });


        Map<String, String> map = new TreeMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }
}
