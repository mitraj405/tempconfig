package defpackage;

import androidx.datastore.preferences.protobuf.n;
import defpackage.kq;

/* renamed from: lq  reason: default package and case insensitive filesystem */
/* compiled from: PreferencesProto */
public final class C0262lq extends n<C0262lq, a> implements jl {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final C0262lq DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile Ho<C0262lq> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    /* renamed from: lq$a */
    /* compiled from: PreferencesProto */
    public static final class a extends n.a<C0262lq, a> implements jl {
        public a() {
            super(C0262lq.DEFAULT_INSTANCE);
        }
    }

    static {
        C0262lq lqVar = new C0262lq();
        DEFAULT_INSTANCE = lqVar;
        n.m(C0262lq.class, lqVar);
    }

    public static a E() {
        return (a) ((n.a) DEFAULT_INSTANCE.i(n.f.NEW_BUILDER));
    }

    public static void n(C0262lq lqVar, long j) {
        lqVar.valueCase_ = 4;
        lqVar.value_ = Long.valueOf(j);
    }

    public static void o(C0262lq lqVar, String str) {
        lqVar.getClass();
        str.getClass();
        lqVar.valueCase_ = 5;
        lqVar.value_ = str;
    }

    public static void p(C0262lq lqVar, kq.a aVar) {
        lqVar.getClass();
        lqVar.value_ = aVar.f();
        lqVar.valueCase_ = 6;
    }

    public static void q(C0262lq lqVar, double d) {
        lqVar.valueCase_ = 7;
        lqVar.value_ = Double.valueOf(d);
    }

    public static void s(C0262lq lqVar, boolean z) {
        lqVar.valueCase_ = 1;
        lqVar.value_ = Boolean.valueOf(z);
    }

    public static void t(C0262lq lqVar, float f) {
        lqVar.valueCase_ = 2;
        lqVar.value_ = Float.valueOf(f);
    }

    public static void u(C0262lq lqVar, int i) {
        lqVar.valueCase_ = 3;
        lqVar.value_ = Integer.valueOf(i);
    }

    public static C0262lq w() {
        return DEFAULT_INSTANCE;
    }

    public final long A() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0;
    }

    public final String B() {
        if (this.valueCase_ == 5) {
            return (String) this.value_;
        }
        return "";
    }

    public final kq C() {
        if (this.valueCase_ == 6) {
            return (kq) this.value_;
        }
        return kq.p();
    }

    public final int D() {
        switch (this.valueCase_) {
            case 0:
                return 8;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                return 0;
        }
    }

    public final Object i(n.f fVar) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new vs(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", kq.class});
            case 3:
                return new C0262lq();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Ho<C0262lq> ho = PARSER;
                if (ho == null) {
                    synchronized (C0262lq.class) {
                        try {
                            ho = PARSER;
                            if (ho == null) {
                                ho = new n.b<>(DEFAULT_INSTANCE);
                                PARSER = ho;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return ho;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean v() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final double x() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float y() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int z() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }
}
