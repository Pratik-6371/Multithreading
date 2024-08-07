package com.codeWithPratik.multiThreading;

public class Main {
    public static void main(String[] args) {

        System.out.println("main method: " +Thread.currentThread().getName());

    SharedResource sharedResource = new SharedResource();
    Thread producerThread= new Thread(()->{
        System.out.println("Producer thread in main class");
        try {
            Thread.sleep(10000); // allow consumer thread to process first
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            sharedResource.addItem();
    });

    Thread consumerThread= new Thread(()->{
        System.out.println("Consumer thread in main class");
        try {
            sharedResource.consumeItem();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });
    producerThread.start();;
    consumerThread.start();

    }

}
