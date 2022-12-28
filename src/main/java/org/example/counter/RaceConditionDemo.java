package org.example.counter;

public class RaceConditionDemo {

    public static void main(String[] args) {
        // 멀티 Thread 환경 -> 싱글톤 -> 유지되는 상태값을 공유 -> race condition
        // Thread safety 하지 않음
        // 결론 : 싱글톤에선 상태를 유지(stateful)하게 설계하면 안됨
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
