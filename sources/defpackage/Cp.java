package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* renamed from: Cp  reason: default package */
/* compiled from: PlatformThreadLocalRandom.kt */
public final class Cp extends C1338q {
    public final int d(int i) {
        return ThreadLocalRandom.current().nextInt(0, i);
    }

    public final Random e() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        C1177ig.e(current, "current()");
        return current;
    }
}
