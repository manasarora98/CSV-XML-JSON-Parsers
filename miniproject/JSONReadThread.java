package com.com.miniproject;

public class JSONReadThread extends Thread {
    @Override
    public void run(){
        JSONHandler jsonobj=new JSONHandler();
        try {
            jsonobj.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
