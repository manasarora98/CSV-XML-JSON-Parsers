package com.com.miniproject;

import java.util.ArrayList;

public class MyCollection {
    private static ArrayList<Employee> list = new ArrayList<>();
    private static Object lockObject = new Object();
    private static int readCounter=299;
    private static int writeCounter=0;

    public static synchronized void add(Employee e) {
            list.add(e);
            ++writeCounter;
    }

    public static synchronized Employee get(){
        return  list.get(readCounter--);
    }
}
