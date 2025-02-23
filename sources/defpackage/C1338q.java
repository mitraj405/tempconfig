package defpackage;

import kotlin.random.Random;

/* renamed from: q  reason: default package and case insensitive filesystem */
/* compiled from: PlatformRandom.kt */
public abstract class C1338q extends Random {
    public final int a(int i) {
        return ((-i) >> 31) & (e().nextInt() >>> (32 - i));
    }

    public final int b() {
        return e().nextInt();
    }

    public final int c(int i) {
        return e().nextInt(i);
    }

    public abstract java.util.Random e();
}
