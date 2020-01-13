package com.com.miniproject;

public class CSVReadThread extends  Thread{

    @Override
    public void run() {

        CSVHandler csvobj = new CSVHandler();
        try {
            csvobj.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
