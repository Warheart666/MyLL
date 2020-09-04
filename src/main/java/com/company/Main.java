package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // write your code here

        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("qwe");
        list.add("2222");
        list.add("3333");
        System.out.println(list.toString());

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println();
            if (s.equalsIgnoreCase("2222")){
                iterator.remove();
            }
        }
        System.out.println(list);
//        LinkedList<String> strings = new LinkedList<String>();
//        strings.add("qwe");
//        strings.add("2222");
//        strings.add("3333");
//        System.out.println(strings.toString());


    }
}
