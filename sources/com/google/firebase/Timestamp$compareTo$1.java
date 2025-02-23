package com.google.firebase;

/* compiled from: Timestamp.kt */
public /* synthetic */ class Timestamp$compareTo$1 extends C0532Hq {
    public static final Timestamp$compareTo$1 INSTANCE = new Timestamp$compareTo$1();

    public Timestamp$compareTo$1() {
        super(Timestamp.class, "seconds", "getSeconds()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((Timestamp) obj).getSeconds());
    }
}
