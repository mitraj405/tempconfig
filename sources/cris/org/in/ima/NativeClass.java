package cris.org.in.ima;

public class NativeClass {
    static {
        System.loadLibrary("native-lib");
    }

    public native String getClaim1();

    public native String getClaim2();

    public native String getClaim3();
}
