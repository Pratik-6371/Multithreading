package com.codeWithPratik.multiThreading;

public class MonitorLock {
    public static void main(String[] args) {
        B obj1 = new B();

        Thread t1= new Thread(obj1::task1);
        Thread t2 = new Thread(obj1::task2);
        Thread t3 = new Thread(obj1::task3);
        t1.start();
        t2.start();
        t3.start();
    }
}

class B {
    public synchronized void task1() {
        try {
            System.out.println("Execution process is going on inside task 1 method ");
            Thread.sleep(7000);
            System.out.println("task 1 completed ");
        } catch (Exception e ) {
            System.out.println(e.getMessage());

        }
    }
    public void task2(){

        synchronized (this){
            System.out.println("task 1 start inside task 2 ");
            task1();

            System.out.println("execution process is completed inside  task 2 method");



        }
    }

    public void task3(){
        System.out.println("task 3 method");
    }
}