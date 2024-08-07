/*Q.Two thread a producer and a consumer share a common ,fixed-size buffer as a queue.The
producer job is to generate data and put into the buffer,while consumer consume the data from buffer

Note: I have to make sure when buffer is full ,it will wait for consumer to consume data and when buffer
 is empty ,it will wait for producer to produce the data
*/


package com.codeWithPratik.multiThreading.producer_consumer;
import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private int buffersize;
    private Queue<Integer> sharedBuffer;

    public SharedResource(int buffersize){
        sharedBuffer= new LinkedList<>();
        this.buffersize=buffersize;
    }

    public synchronized  void produce(int item) throws Exception{
        //if buffer is full then wait for consume thread to consume item
        while(sharedBuffer.size()==buffersize){
            System.out.println("buffer is full and ,producer is waiting for consumer");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced " +item);
        //notify the consumer that there item to consume
        notify();


    }
    public synchronized int consume() throws  Exception{
        //Buffer is empty,wait for producer to produce item
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty and consumer is waiting for producer ");
            wait();

        }
        int item=sharedBuffer.poll();
        System.out.println("Consumer : " +item);
        //notify the producer that there is a space in the buffer now
        notify();
        return item;


    }
}
