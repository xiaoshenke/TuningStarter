package wuxian.me.tuningstarter.jvm;

public class BigObject {

    private String[] strings = null;

    public BigObject(int size) {

        strings = new String[size * 256 * 1000];
    }


}
