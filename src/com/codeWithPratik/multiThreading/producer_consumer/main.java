package com.codeWithPratik.multiThreading.producer_consumer;

public class main {
    public static void main(String[] args) {
        SharedResource sharedBuffer = new SharedResource(7);
        Thread producerThread = new Thread(() -> {

            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {


            }
        });

        Thread consumerThread = new Thread(() -> {

            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.consume();
                }
            } catch (Exception e) {

            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
