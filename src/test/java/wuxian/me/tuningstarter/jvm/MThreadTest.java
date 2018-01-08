package wuxian.me.tuningstarter.jvm;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.*;

public class MThreadTest {

    @Test
    public void testSize() {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        final MThread thread = new MThread() {

            public void run() {
                try {
                    barrier.await();
                    System.out.println("MThread.barrier.await()");
                } catch (Exception e) {

                }
                super.run();

            }
        };
        thread.start();
        try {
            barrier.await();
        } catch (Exception e) {

        }
        System.out.println("testSize.barrier.await()");
        System.out.println(ObjectSizeCalculator.getObjectSize(thread)); //253208 -> 253k

    }

}