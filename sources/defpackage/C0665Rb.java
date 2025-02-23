package defpackage;

import java.util.Random;

/* renamed from: Rb  reason: default package and case insensitive filesystem */
/* compiled from: PlatformRandom.kt */
public final class C0665Rb extends C1338q {
    public final a a = new a();

    /* renamed from: Rb$a */
    /* compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        public final Object initialValue() {
            return new Random();
        }
    }

    public final Random e() {
        Object obj = this.a.get();
        C1177ig.e(obj, "implStorage.get()");
        return (Random) obj;
    }
}
