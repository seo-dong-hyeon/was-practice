package org.example.counter;

public class Counter implements Runnable{

    // 상태값
    private int count = 0;

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getValue(){
        return count;
    }

    @Override
    public void run() {
        // 동기화 -> race condition 해결
        synchronized (this) {
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
        }
    }
}
