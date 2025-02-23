package com.google.firebase;

/* compiled from: Timestamp.kt */
public /* synthetic */ class Timestamp$compareTo$2 extends C0532Hq {
    public static final Timestamp$compareTo$2 INSTANCE = new Timestamp$compareTo$2();

    public Timestamp$compareTo$2() {
        super(Timestamp.class, "nanoseconds", "getNanoseconds()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((Timestamp) obj).getNanoseconds());
    }
}
