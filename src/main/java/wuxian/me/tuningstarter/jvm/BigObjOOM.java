package wuxian.me.tuningstarter.jvm;

//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import java.util.ArrayList;

public class BigObjOOM {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 4) {
            throw new IllegalArgumentException(
                    "must give these args: ObjSize:Mb | timeInterval:s | totalCount | beginCount");
        }

        int size = Integer.parseInt(args[0]);
        int timeInterval = Integer.parseInt(args[1]);
        int totalCount = Integer.parseInt(args[2]);
        int beginCount = Integer.parseInt(args[3]);
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

        ArrayList<BigObject> bigObjects = new ArrayList<BigObject>(totalCount);
        if (beginCount > 0) {
            for (int i = 0; i < beginCount; i++) {
                bigObjects.add(new BigObject(size));
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

            System.out.println("add bigObject");
            bigObjects.add(new BigObject(size));
            cur++;
        }

        System.out.println("return");

        return;
    }
}
