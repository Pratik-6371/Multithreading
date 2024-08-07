package com.codeWithPratik.multiThreading;

public class Test {

    public static void main(String[] args) {
        System.out.println("Thread execution start " +Thread.currentThread().getName());
        Thread t1 = new Thread(()->{


        });
        t1.start();
        System.out.println("Thread execution end " +Thread.currentThread().getName());


    }



    }



