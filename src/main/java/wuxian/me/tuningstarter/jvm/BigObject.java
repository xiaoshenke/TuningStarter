package wuxian.me.tuningstarter.jvm;

/**
 * Created by wuxian on 8/1/2018.
 */
public class BigObject {

    private String[] strings = null;

    public BigObject(int size) {

        strings = new String[size * 256 * 1000];
    }


}
