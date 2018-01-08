package wuxian.me.tuningstarter.jvm;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.util.ArrayList;

public class BigObjectTest {

    @Test
    public void testSize() {

        System.out.println(ObjectSizeCalculator.getObjectSize(new BigObject(40))); //40mb
        //System.out.println(ObjectSizeFetcher.getObjectSize(new BigObject(100)));

        System.out.println(ObjectSizeCalculator.getObjectSize(new ArrayList<BigObject>(10))); //80

        ArrayList<BigObject> bigObjects = new ArrayList<BigObject>(10);
        bigObjects.add(new BigObject(40));
        bigObjects.add(new BigObject(60));
        System.out.println(ObjectSizeCalculator.getObjectSize(bigObjects));

    }

}