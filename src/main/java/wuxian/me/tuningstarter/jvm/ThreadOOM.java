package wuxian.me.tuningstarter.jvm;

/**
 * Created by wuxian on 8/1/2018.
 */
public class ThreadOOM {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException(
                    "must give these args: timeInterval:s | totalCount | beginCount");
        }

        int timeInterval = Integer.parseInt(args[0]);
        int totalCount = Integer.parseInt(args[1]);
        int beginCount = Integer.parseInt(args[2]);
        if (beginCount > totalCount) {
            throw new IllegalArgumentException(
                    "beginCount is bigger than totalCount"
            );
        }

        long warmup = 1;//10*1000;
        try {
            Thread.sleep(warmup);
        } catch (Exception e) {
            ;
        }

        if (beginCount > 0) {
            for (int i = 0; i < beginCount; i++) {
                new MThread().start();
            }
        }

        int cur = beginCount;
        //System.out.println("currentSize: " + ObjectSizeCalculator.getObjectSize(bigObjects));
        while (cur < totalCount) {
            System.out.println("current: " + cur);
            try {
                Thread.sleep(timeInterval * 1000);
            } catch (Exception e) {

            }
            System.out.println("add thread");
            new MThread().start();
            cur++;
        }

        System.out.println("return");

        return;

    }
}
