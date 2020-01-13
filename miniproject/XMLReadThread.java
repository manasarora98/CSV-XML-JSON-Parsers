package com.com.miniproject;

public class XMLReadThread extends Thread {
    @Override
    public void run() {
        XMLHandler xmlobj = new XMLHandler();
        try {
            xmlobj.read();
        } catch (Exception e) {

        }
    }
}
