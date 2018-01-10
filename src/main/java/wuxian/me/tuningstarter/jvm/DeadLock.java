package wuxian.me.tuningstarter.jvm;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuxian on 10/1/2018.
 */
public class DeadLock {

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();


    public void run() {
        CyclicBarrier barrier = new CyclicBarrier(2);
        new AThread(barrier).start();
        new BThread(barrier).start();
    }

    public static void main(String[] args) {

        new DeadLock().run();

    }

    class AThread extends Thread {

        private CyclicBarrier barrier;

        public AThread(CyclicBarrier barrier) {
            this.barrier = barrier;
            setName("AThread");
        }

        public void run() {

            try {
                barrier.await();
            } catch (Exception e) {

            }
            System.out.println("enter lock loop: " + Thread.currentThread());

            while (true) {

                try {
                    lock1.lock();
                    System.out.println("acquire lock1! " + Thread.currentThread());

                    try {
                        sleep(300);
                    } catch (Exception e) {

                    }

                    try {
                        lock2.lock();
                        System.out.println("acquire two locks! " + Thread.currentThread());
                    } finally {
                        lock2.unlock();
                    }

                } finally {
                    lock1.unlock();
                }

                try {
                    sleep(100);
                } catch (Exception e) {

                }

            }
        }

    }

    class BThread extends Thread {

        private CyclicBarrier barrier;

        public BThread(CyclicBarrier barrier) {
            this.barrier = barrier;
            setName("BThread");
        }

        public void run() {
            Random random = new Random();
            double d = random.nextDouble();
            try {
                barrier.await();
            } catch (Exception e) {

            }
            System.out.println("enter lock loop: " + Thread.currentThread());


            while (true) {
                if (d < 0.2) {
                    enterDeadlock();
                } else {
                    enterNormal();
                }
                d = random.nextDouble();

                try {
                    sleep(100);
                } catch (Exception e) {

                }
            }
        }

        private void enterDeadlock() {
            System.out.println("enter dead lock");

            try {
                lock2.lock();
                System.out.println("acquire lock2! " + Thread.currentThread());

                try {
                    sleep(300);
                } catch (Exception e) {

                }

                try {
                    lock1.lock();
                    System.out.println("acquire two locks! " + Thread.currentThread());
                } finally {
                    lock1.unlock();
                }

            } finally {
                lock2.unlock();
            }
        }

        private void enterNormal() {

            System.out.println("enter normal");
            try {
                lock1.lock();
                System.out.println("acquire lock1! " + Thread.currentThread());

                try {
                    sleep(300);
                } catch (Exception e) {

                }

                try {
                    lock2.lock();
                    System.out.println("acquire two locks! " + Thread.currentThread());
                } finally {
                    lock2.unlock();
                }

            } finally {
                lock1.unlock();
            }

        }

    }

}
