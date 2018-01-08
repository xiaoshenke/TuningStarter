package wuxian.me.tuningstarter.jvm;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wuxian on 8/1/2018.
 */
public class NormalGC {

    //random to reomve objs
    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 4) {
            throw new IllegalArgumentException(
                    "must give these args: ObjSize:Mb | timeInterval:s | totalCount | beginCount | gcByHand");
        }

        int size = Integer.parseInt(args[0]);
        int timeInterval = Integer.parseInt(args[1]);
        int totalCount = Integer.parseInt(args[2]);
        int beginCount = Integer.parseInt(args[3]);

        boolean gcByHand = args.length == 5 ? Boolean.parseBoolean(args[4]) : false;
        if (beginCount > totalCount) {
            throw new IllegalArgumentException(
                    "beginCount is bigger than totalCount"
            );
        }
        long warmup = 1;
        try {
            Thread.sleep(warmup);
        } catch (Exception e) {
            ;
        }

        ArrayList<BigObject> bigObjects = new ArrayList<BigObject>(totalCount);
        if (beginCount > 0) {
            for (int i = 0; i < beginCount; i++) {
                bigObjects.add(new BigObject(size));
            }
        }

        int cur = beginCount;
        Random random = new Random();
        while (cur < totalCount) {

            System.out.println("current: " + cur);
            try {
                Thread.sleep(timeInterval * 1000);
            } catch (Exception e) {

            }

            System.out.println("add bigObject");
            bigObjects.add(new BigObject(size));
            cur++;

            //30% percent
            if (random.nextDouble() < 0.3) {
                System.out.println("remove bigObject at 0");
                bigObjects.remove(0);
                if (gcByHand) {
                    System.out.println("call gc()");
                    System.gc();
                }
            }
        }

        System.out.println("return");
    }
}
