package com.codeWithPratik.multiThreading;

public class SharedResource {
    boolean isIteamAvailable= false;

    public synchronized void addItem(){
        isIteamAvailable=true;
        System.out.println("Producer thread: "+Thread.currentThread().getName());
        try{
            notifyAll();//wake up other thread which is in running state
            System.out.println("lock is released and wake up to other thread which is in waited state like consumer thread");
        }catch(Exception e){

        }


    }

    public synchronized void consumeItem() throws InterruptedException {
        System.out.println("consumer Thread before waiting state: "+Thread.currentThread().getName());
        while(!isIteamAvailable){
            try{
                wait(); // thread is waiting state and lock is released

            }catch(Exception e){

            }
        }
        isIteamAvailable=false;
        Thread.sleep(10000);
        System.out.println("consumer thread is executed after waiting state : "+Thread.currentThread().getName());
    }

}
