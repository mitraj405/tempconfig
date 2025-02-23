package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: AnimationHandler */
public final class a {
    public static final ThreadLocal<a> a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public final SimpleArrayMap<b, Long> f1996a = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final C0016a f1997a = new C0016a();

    /* renamed from: a  reason: collision with other field name */
    public d f1998a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f1999a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2000a = false;

    /* renamed from: androidx.dynamicanimation.animation.a$a  reason: collision with other inner class name */
    /* compiled from: AnimationHandler */
    public class C0016a {
        public C0016a() {
        }
    }

    /* compiled from: AnimationHandler */
    public interface b {
        boolean a(long j);
    }

    /* compiled from: AnimationHandler */
    public static abstract class c {
        public final C0016a a;

        public c(C0016a aVar) {
            this.a = aVar;
        }
    }

    /* compiled from: AnimationHandler */
    public static class d extends c {
        public final Choreographer a = Choreographer.getInstance();

        /* renamed from: a  reason: collision with other field name */
        public final C0017a f2001a = new C0017a();

        /* renamed from: androidx.dynamicanimation.animation.a$d$a  reason: collision with other inner class name */
        /* compiled from: AnimationHandler */
        public class C0017a implements Choreographer.FrameCallback {
            public C0017a() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0046 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void doFrame(long r10) {
                /*
                    r9 = this;
                    androidx.dynamicanimation.animation.a$d r10 = androidx.dynamicanimation.animation.a.d.this
                    androidx.dynamicanimation.animation.a$a r10 = r10.a
                    r10.getClass()
                    long r0 = android.os.SystemClock.uptimeMillis()
                    androidx.dynamicanimation.animation.a r10 = androidx.dynamicanimation.animation.a.this
                    r10.getClass()
                    long r2 = android.os.SystemClock.uptimeMillis()
                    r11 = 0
                    r4 = r11
                L_0x0016:
                    java.util.ArrayList<androidx.dynamicanimation.animation.a$b> r5 = r10.f1999a
                    int r6 = r5.size()
                    if (r4 >= r6) goto L_0x0049
                    java.lang.Object r5 = r5.get(r4)
                    androidx.dynamicanimation.animation.a$b r5 = (androidx.dynamicanimation.animation.a.b) r5
                    if (r5 != 0) goto L_0x0027
                    goto L_0x0046
                L_0x0027:
                    androidx.collection.SimpleArrayMap<androidx.dynamicanimation.animation.a$b, java.lang.Long> r6 = r10.f1996a
                    r7 = 0
                    java.lang.Object r7 = r6.getOrDefault(r5, r7)
                    java.lang.Long r7 = (java.lang.Long) r7
                    if (r7 != 0) goto L_0x0033
                    goto L_0x003e
                L_0x0033:
                    long r7 = r7.longValue()
                    int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                    if (r7 >= 0) goto L_0x0040
                    r6.remove(r5)
                L_0x003e:
                    r6 = 1
                    goto L_0x0041
                L_0x0040:
                    r6 = r11
                L_0x0041:
                    if (r6 == 0) goto L_0x0046
                    r5.a(r0)
                L_0x0046:
                    int r4 = r4 + 1
                    goto L_0x0016
                L_0x0049:
                    boolean r0 = r10.f2000a
                    if (r0 == 0) goto L_0x0061
                    int r0 = r5.size()
                L_0x0051:
                    int r0 = r0 + -1
                    if (r0 < 0) goto L_0x005f
                    java.lang.Object r1 = r5.get(r0)
                    if (r1 != 0) goto L_0x0051
                    r5.remove(r0)
                    goto L_0x0051
                L_0x005f:
                    r10.f2000a = r11
                L_0x0061:
                    int r11 = r5.size()
                    if (r11 <= 0) goto L_0x007d
                    androidx.dynamicanimation.animation.a$d r11 = r10.f1998a
                    if (r11 != 0) goto L_0x0074
                    androidx.dynamicanimation.animation.a$d r11 = new androidx.dynamicanimation.animation.a$d
                    androidx.dynamicanimation.animation.a$a r0 = r10.f1997a
                    r11.<init>(r0)
                    r10.f1998a = r11
                L_0x0074:
                    androidx.dynamicanimation.animation.a$d r10 = r10.f1998a
                    androidx.dynamicanimation.animation.a$d$a r11 = r10.f2001a
                    android.view.Choreographer r10 = r10.a
                    r10.postFrameCallback(r11)
                L_0x007d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.dynamicanimation.animation.a.d.C0017a.doFrame(long):void");
            }
        }

        public d(C0016a aVar) {
            super(aVar);
        }
    }
}
