package com.com.miniproject;

public class MyController extends Thread{

    public static void main(String[] args)throws Exception {
       //Threads instances for both read and write
       CSVReadThread csvreadthread = new CSVReadThread();
       CSVWriteThread csvwritethread = new CSVWriteThread();
       JSONReadThread jsonreadthread = new JSONReadThread();
       JSONWriteThread jsonwritethread = new JSONWriteThread();
       XMLReadThread xmlreadthread = new XMLReadThread();
       XMLWriteThread xmlwritethread = new XMLWriteThread();

       //ReadThreads start
       xmlreadthread.start();
       csvreadthread.start();
       jsonreadthread.start();
       //Completing ReadThreads
       xmlreadthread.join();
       csvreadthread.join();
       jsonreadthread.join();

       //WriteThreads start
       csvwritethread.start();
       xmlwritethread.start();
       jsonwritethread.start();

       csvwritethread.join();
       xmlwritethread.join();
       jsonwritethread.join();
    }
}
