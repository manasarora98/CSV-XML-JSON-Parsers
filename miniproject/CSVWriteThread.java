package com.com.miniproject;

public class CSVWriteThread extends Thread {
    @Override
    public void run(){
        CSVHandler csvobj=new CSVHandler();
        csvobj.write();
    }
}
