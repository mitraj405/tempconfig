package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: oB  reason: default package and case insensitive filesystem */
/* compiled from: UnsafeUtil */
public final class C0285oB {
    public static final long a = ((long) b(byte[].class));

    /* renamed from: a  reason: collision with other field name */
    public static final Class<?> f3138a = A0.a;

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3139a = Logger.getLogger(C0285oB.class.getName());

    /* renamed from: a  reason: collision with other field name */
    public static final e f3140a;

    /* renamed from: a  reason: collision with other field name */
    public static final Unsafe f3141a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f3142a;
    public static final boolean b;
    public static final boolean c;

    /* renamed from: oB$a */
    /* compiled from: UnsafeUtil */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() throws Exception {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }

        public final /* bridge */ /* synthetic */ Object run() throws Exception {
            return a();
        }
    }

    /* renamed from: oB$b */
    /* compiled from: UnsafeUtil */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        public final boolean c(Object obj, long j) {
            if (C0285oB.c) {
                if (C0285oB.h(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (C0285oB.i(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public final byte d(Object obj, long j) {
            if (C0285oB.c) {
                return C0285oB.h(obj, j);
            }
            return C0285oB.i(obj, j);
        }

        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        public final float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        public final void k(Object obj, long j, boolean z) {
            if (C0285oB.c) {
                C0285oB.q(obj, j, z ? (byte) 1 : 0);
            } else {
                C0285oB.r(obj, j, z ? (byte) 1 : 0);
            }
        }

        public final void l(Object obj, long j, byte b) {
            if (C0285oB.c) {
                C0285oB.q(obj, j, b);
            } else {
                C0285oB.r(obj, j, b);
            }
        }

        public final void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        public final void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: oB$c */
    /* compiled from: UnsafeUtil */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        public final boolean c(Object obj, long j) {
            if (C0285oB.c) {
                if (C0285oB.h(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (C0285oB.i(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public final byte d(Object obj, long j) {
            if (C0285oB.c) {
                return C0285oB.h(obj, j);
            }
            return C0285oB.i(obj, j);
        }

        public final double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        public final float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        public final void k(Object obj, long j, boolean z) {
            if (C0285oB.c) {
                C0285oB.q(obj, j, z ? (byte) 1 : 0);
            } else {
                C0285oB.r(obj, j, z ? (byte) 1 : 0);
            }
        }

        public final void l(Object obj, long j, byte b) {
            if (C0285oB.c) {
                C0285oB.q(obj, j, b);
            } else {
                C0285oB.r(obj, j, b);
            }
        }

        public final void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        public final void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: oB$d */
    /* compiled from: UnsafeUtil */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        public final boolean c(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        public final byte d(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        public final double e(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        public final float f(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        public final void k(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        public final void l(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        public final void m(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        public final void n(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }
    }

    /* renamed from: oB$e */
    /* compiled from: UnsafeUtil */
    public static abstract class e {
        public final Unsafe a;

        public e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b);

        public abstract void m(Object obj, long j, double d);

        public abstract void n(Object obj, long j, float f);

        public final void o(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.a.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[SYNTHETIC, Splitter:B:12:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010c A[SYNTHETIC, Splitter:B:32:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x026d  */
    static {
        /*
            java.lang.Class<oB> r0 = defpackage.C0285oB.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f3139a = r0
            sun.misc.Unsafe r0 = o()
            f3141a = r0
            java.lang.Class<?> r1 = defpackage.A0.a
            f3138a = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r2 = e(r1)
            java.lang.Class r3 = java.lang.Integer.TYPE
            boolean r4 = e(r3)
            if (r0 != 0) goto L_0x0025
            goto L_0x003b
        L_0x0025:
            boolean r5 = defpackage.A0.a()
            if (r5 == 0) goto L_0x003d
            if (r2 == 0) goto L_0x0033
            oB$c r2 = new oB$c
            r2.<init>(r0)
            goto L_0x0042
        L_0x0033:
            if (r4 == 0) goto L_0x003b
            oB$b r2 = new oB$b
            r2.<init>(r0)
            goto L_0x0042
        L_0x003b:
            r2 = 0
            goto L_0x0042
        L_0x003d:
            oB$d r2 = new oB$d
            r2.<init>(r0)
        L_0x0042:
            f3140a = r2
            java.lang.String r2 = "copyMemory"
            r6 = 1
            java.lang.String r7 = "putLong"
            java.lang.String r8 = "putInt"
            java.lang.String r9 = "getInt"
            java.lang.String r10 = "putByte"
            java.lang.String r11 = "getByte"
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            java.lang.String r13 = "platform method missing - proto runtime falling back to safer methods: "
            java.lang.String r14 = "objectFieldOffset"
            java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
            java.lang.String r4 = "getLong"
            r16 = 0
            if (r0 != 0) goto L_0x0060
            goto L_0x007c
        L_0x0060:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00e7 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e7 }
            r5[r16] = r12     // Catch:{ all -> 0x00e7 }
            r0.getMethod(r14, r5)     // Catch:{ all -> 0x00e7 }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00e7 }
            r6[r16] = r15     // Catch:{ all -> 0x00e7 }
            r5 = 1
            r6[r5] = r1     // Catch:{ all -> 0x00e7 }
            r0.getMethod(r4, r6)     // Catch:{ all -> 0x00e7 }
            java.lang.reflect.Field r5 = d()     // Catch:{ all -> 0x00e7 }
            if (r5 != 0) goto L_0x0080
        L_0x007c:
            r18 = r11
            goto L_0x00fd
        L_0x0080:
            boolean r5 = defpackage.A0.a()     // Catch:{ all -> 0x00e7 }
            if (r5 == 0) goto L_0x0089
            r18 = r11
            goto L_0x00e3
        L_0x0089:
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00e7 }
            r6[r16] = r1     // Catch:{ all -> 0x00e7 }
            r0.getMethod(r11, r6)     // Catch:{ all -> 0x00e7 }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00e7 }
            r6[r16] = r1     // Catch:{ all -> 0x00e7 }
            java.lang.Class r5 = java.lang.Byte.TYPE     // Catch:{ all -> 0x00e7 }
            r18 = r11
            r11 = 1
            r6[r11] = r5     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r10, r6)     // Catch:{ all -> 0x00e5 }
            java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch:{ all -> 0x00e5 }
            r5[r16] = r1     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r9, r5)     // Catch:{ all -> 0x00e5 }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00e5 }
            r6[r16] = r1     // Catch:{ all -> 0x00e5 }
            r6[r11] = r3     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r8, r6)     // Catch:{ all -> 0x00e5 }
            java.lang.Class[] r3 = new java.lang.Class[r11]     // Catch:{ all -> 0x00e5 }
            r3[r16] = r1     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r4, r3)     // Catch:{ all -> 0x00e5 }
            r3 = 2
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x00e5 }
            r5[r16] = r1     // Catch:{ all -> 0x00e5 }
            r5[r11] = r1     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r7, r5)     // Catch:{ all -> 0x00e5 }
            r3 = 3
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x00e5 }
            r5[r16] = r1     // Catch:{ all -> 0x00e5 }
            r5[r11] = r1     // Catch:{ all -> 0x00e5 }
            r3 = 2
            r5[r3] = r1     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r2, r5)     // Catch:{ all -> 0x00e5 }
            r3 = 5
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ all -> 0x00e5 }
            r3[r16] = r15     // Catch:{ all -> 0x00e5 }
            r5 = 1
            r3[r5] = r1     // Catch:{ all -> 0x00e5 }
            r5 = 2
            r3[r5] = r15     // Catch:{ all -> 0x00e5 }
            r5 = 3
            r3[r5] = r1     // Catch:{ all -> 0x00e5 }
            r5 = 4
            r3[r5] = r1     // Catch:{ all -> 0x00e5 }
            r0.getMethod(r2, r3)     // Catch:{ all -> 0x00e5 }
        L_0x00e3:
            r0 = 1
            goto L_0x00ff
        L_0x00e5:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            r18 = r11
        L_0x00ea:
            java.util.logging.Level r1 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r13)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.util.logging.Logger r2 = f3139a
            r2.log(r1, r0)
        L_0x00fd:
            r0 = r16
        L_0x00ff:
            f3142a = r0
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = f3141a
            if (r1 != 0) goto L_0x010c
            r17 = r16
            r5 = 1
            goto L_0x021a
        L_0x010c:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0203 }
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0200 }
            r3[r16] = r12     // Catch:{ all -> 0x0200 }
            r1.getMethod(r14, r3)     // Catch:{ all -> 0x0200 }
            java.lang.String r3 = "arrayBaseOffset"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x0200 }
            r5[r16] = r0     // Catch:{ all -> 0x0200 }
            r1.getMethod(r3, r5)     // Catch:{ all -> 0x0200 }
            java.lang.String r3 = "arrayIndexScale"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x0200 }
            r5[r16] = r0     // Catch:{ all -> 0x0203 }
            r1.getMethod(r3, r5)     // Catch:{ all -> 0x0203 }
            r2 = 2
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch:{ all -> 0x0203 }
            r0[r16] = r15     // Catch:{ all -> 0x0203 }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x0203 }
            r3 = 1
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            r1.getMethod(r9, r0)     // Catch:{ all -> 0x01fd }
            r5 = 3
            java.lang.Class[] r0 = new java.lang.Class[r5]     // Catch:{ all -> 0x01fd }
            r0[r16] = r15     // Catch:{ all -> 0x01fd }
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0203 }
            r5 = 2
            r0[r5] = r3     // Catch:{ all -> 0x0203 }
            r1.getMethod(r8, r0)     // Catch:{ all -> 0x0203 }
            java.lang.Class[] r0 = new java.lang.Class[r5]     // Catch:{ all -> 0x0203 }
            r0[r16] = r15     // Catch:{ all -> 0x0203 }
            r3 = 1
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            r1.getMethod(r4, r0)     // Catch:{ all -> 0x01fd }
            r4 = 3
            java.lang.Class[] r0 = new java.lang.Class[r4]     // Catch:{ all -> 0x01fd }
            r0[r16] = r15     // Catch:{ all -> 0x01fd }
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            r3 = 2
            r0[r3] = r2     // Catch:{ all -> 0x0203 }
            r1.getMethod(r7, r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = "getObject"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0203 }
            r4[r16] = r15     // Catch:{ all -> 0x0203 }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x01fd }
            r1.getMethod(r0, r4)     // Catch:{ all -> 0x01fd }
            java.lang.String r0 = "putObject"
            r4 = 3
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x01fd }
            r5[r16] = r15     // Catch:{ all -> 0x01fd }
            r5[r3] = r2     // Catch:{ all -> 0x01fd }
            r3 = 2
            r5[r3] = r15     // Catch:{ all -> 0x0203 }
            r1.getMethod(r0, r5)     // Catch:{ all -> 0x0203 }
            boolean r0 = defpackage.A0.a()     // Catch:{ all -> 0x0203 }
            if (r0 == 0) goto L_0x0183
            r5 = 1
            r17 = 1
            goto L_0x021a
        L_0x0183:
            java.lang.Class[] r0 = new java.lang.Class[r3]     // Catch:{ all -> 0x0203 }
            r0[r16] = r15     // Catch:{ all -> 0x0203 }
            r3 = 1
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            r4 = r18
            r1.getMethod(r4, r0)     // Catch:{ all -> 0x01fd }
            r4 = 3
            java.lang.Class[] r0 = new java.lang.Class[r4]     // Catch:{ all -> 0x01fd }
            r0[r16] = r15     // Catch:{ all -> 0x01fd }
            r0[r3] = r2     // Catch:{ all -> 0x01fd }
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0203 }
            r4 = 2
            r0[r4] = r3     // Catch:{ all -> 0x0203 }
            r1.getMethod(r10, r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = "getBoolean"
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x0203 }
            r3[r16] = r15     // Catch:{ all -> 0x0203 }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x01fa }
            r1.getMethod(r0, r3)     // Catch:{ all -> 0x01fa }
            java.lang.String r0 = "putBoolean"
            r3 = 3
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x01fa }
            r5[r16] = r15     // Catch:{ all -> 0x01fa }
            r5[r4] = r2     // Catch:{ all -> 0x01fa }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0203 }
            r4 = 2
            r5[r4] = r3     // Catch:{ all -> 0x0203 }
            r1.getMethod(r0, r5)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = "getFloat"
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x0203 }
            r3[r16] = r15     // Catch:{ all -> 0x0203 }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x01fa }
            r1.getMethod(r0, r3)     // Catch:{ all -> 0x01fa }
            java.lang.String r0 = "putFloat"
            r3 = 3
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x01fa }
            r5[r16] = r15     // Catch:{ all -> 0x01fa }
            r5[r4] = r2     // Catch:{ all -> 0x01fa }
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ all -> 0x0203 }
            r4 = 2
            r5[r4] = r3     // Catch:{ all -> 0x0203 }
            r1.getMethod(r0, r5)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = "getDouble"
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x0203 }
            r3[r16] = r15     // Catch:{ all -> 0x0203 }
            r5 = 1
            r3[r5] = r2     // Catch:{ all -> 0x01f8 }
            r1.getMethod(r0, r3)     // Catch:{ all -> 0x01f8 }
            java.lang.String r0 = "putDouble"
            r3 = 3
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ all -> 0x01f8 }
            r3[r16] = r15     // Catch:{ all -> 0x01f8 }
            r3[r5] = r2     // Catch:{ all -> 0x01f8 }
            java.lang.Class r2 = java.lang.Double.TYPE     // Catch:{ all -> 0x01f8 }
            r4 = 2
            r3[r4] = r2     // Catch:{ all -> 0x01f8 }
            r1.getMethod(r0, r3)     // Catch:{ all -> 0x01f8 }
            r17 = r5
            goto L_0x021a
        L_0x01f8:
            r0 = move-exception
            goto L_0x0205
        L_0x01fa:
            r0 = move-exception
            r5 = r4
            goto L_0x0205
        L_0x01fd:
            r0 = move-exception
            r5 = r3
            goto L_0x0205
        L_0x0200:
            r0 = move-exception
            r5 = r2
            goto L_0x0205
        L_0x0203:
            r0 = move-exception
            r5 = 1
        L_0x0205:
            java.util.logging.Level r1 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r13)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.util.logging.Logger r2 = f3139a
            r2.log(r1, r0)
            r17 = r16
        L_0x021a:
            b = r17
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = b(r0)
            long r0 = (long) r0
            a = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            b(r0)
            c(r0)
            java.lang.Class<int[]> r0 = int[].class
            b(r0)
            c(r0)
            java.lang.Class<long[]> r0 = long[].class
            b(r0)
            c(r0)
            java.lang.Class<float[]> r0 = float[].class
            b(r0)
            c(r0)
            java.lang.Class<double[]> r0 = double[].class
            b(r0)
            c(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            b(r0)
            c(r0)
            java.lang.reflect.Field r0 = d()
            if (r0 == 0) goto L_0x0263
            oB$e r1 = f3140a
            if (r1 != 0) goto L_0x0260
            goto L_0x0263
        L_0x0260:
            r1.j(r0)
        L_0x0263:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x026d
            r6 = r5
            goto L_0x026f
        L_0x026d:
            r6 = r16
        L_0x026f:
            c = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0285oB.<clinit>():void");
    }

    public static <T> T a(Class<T> cls) {
        try {
            return f3141a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int b(Class<?> cls) {
        if (b) {
            return f3140a.a(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (b) {
            f3140a.b(cls);
        }
    }

    public static Field d() {
        Field field;
        Field field2;
        Class<Buffer> cls = Buffer.class;
        if (A0.a()) {
            try {
                field2 = cls.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = cls.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean e(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!A0.a()) {
            return false;
        }
        try {
            Class<?> cls3 = f3138a;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(Object obj, long j) {
        return f3140a.c(obj, j);
    }

    public static byte g(byte[] bArr, long j) {
        return f3140a.d(bArr, a + j);
    }

    public static byte h(Object obj, long j) {
        return (byte) ((l(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static byte i(Object obj, long j) {
        return (byte) ((l(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static double j(Object obj, long j) {
        return f3140a.e(obj, j);
    }

    public static float k(Object obj, long j) {
        return f3140a.f(obj, j);
    }

    public static int l(Object obj, long j) {
        return f3140a.g(obj, j);
    }

    public static long m(Object obj, long j) {
        return f3140a.h(obj, j);
    }

    public static Object n(Object obj, long j) {
        return f3140a.i(obj, j);
    }

    public static Unsafe o() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void p(byte[] bArr, long j, byte b2) {
        f3140a.l(bArr, a + j, b2);
    }

    public static void q(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int l = l(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        s(obj, j2, ((255 & b2) << i) | (l & (~(Constants.MAX_HOST_LENGTH << i))));
    }

    public static void r(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        s(obj, j2, ((255 & b2) << i) | (l(obj, j2) & (~(Constants.MAX_HOST_LENGTH << i))));
    }

    public static void s(Object obj, long j, int i) {
        f3140a.o(obj, j, i);
    }

    public static void t(Object obj, long j, long j2) {
        f3140a.p(obj, j, j2);
    }

    public static void u(Object obj, long j, Object obj2) {
        f3140a.q(obj, j, obj2);
    }
}
