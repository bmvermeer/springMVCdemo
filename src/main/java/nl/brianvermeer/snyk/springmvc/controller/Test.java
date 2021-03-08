package nl.brianvermeer.snyk.springmvc.controller;

import java.util.Collections;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
//        PriorityQueue<Integer> prioQ = new PriorityQueue<>();
//        prioQ.add(1);
//        prioQ.add(3);
//        prioQ.add(4);
//        prioQ.add(2);
//        prioQ.add(5);
//
//        while (!prioQ.isEmpty()) {
//            System.out.println(prioQ.poll());
//        }




        PriorityQueue<Integer> prioQ = new PriorityQueue<>(Collections.reverseOrder());
        prioQ.add(1);
        prioQ.add(3);
        prioQ.add(4);
        prioQ.add(2);
        prioQ.add(5);

        while (!prioQ.isEmpty()) {
            System.out.println(prioQ.poll());
        }

    }
}
