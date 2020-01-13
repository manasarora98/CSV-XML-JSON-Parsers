package com.com.miniproject;

public class XMLWriteThread extends Thread {
    public void run(){
        XMLHandler xmlobj=new XMLHandler();
        xmlobj.write();
    }
}
