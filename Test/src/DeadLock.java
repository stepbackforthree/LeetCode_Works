import org.junit.Test;

import java.util.*;


public class DeadLock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread() + "get object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "wait to get object2");

                synchronized (object2) {
                    System.out.println(Thread.currentThread() + "get object2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (object2) {
                System.out.println(Thread.currentThread() + "get object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "wait to get object1");

                synchronized (object1) {
                    System.out.println(Thread.currentThread() + "get object1");
                }
            }
        }, "线程2").start();
    }
}
