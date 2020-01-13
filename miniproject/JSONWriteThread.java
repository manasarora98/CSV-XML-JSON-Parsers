package com.com.miniproject;

public class JSONWriteThread extends Thread {
    @Override
    public void run(){
        JSONHandler jsonobj=new JSONHandler();
        jsonobj.write();
    }
}
