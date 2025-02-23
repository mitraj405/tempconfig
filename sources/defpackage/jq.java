package defpackage;

import androidx.datastore.preferences.protobuf.C0128e;
import androidx.datastore.preferences.protobuf.C0132i;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* renamed from: jq  reason: default package */
/* compiled from: PreferencesProto */
public final class jq extends n<jq, a> implements jl {
    /* access modifiers changed from: private */
    public static final jq DEFAULT_INSTANCE;
    private static volatile Ho<jq> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private x<String, C0262lq> preferences_ = x.a;

    /* renamed from: jq$a */
    /* compiled from: PreferencesProto */
    public static final class a extends n.a<jq, a> implements jl {
        public a() {
            super(jq.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: jq$b */
    /* compiled from: PreferencesProto */
    public static final class b {
        public static final w<String, C0262lq> a = new w<>(GD.a, GD.f230a, C0262lq.w());
    }

    static {
        jq jqVar = new jq();
        DEFAULT_INSTANCE = jqVar;
        n.m(jq.class, jqVar);
    }

    public static x o(jq jqVar) {
        x<String, C0262lq> xVar = jqVar.preferences_;
        if (!xVar.f1941a) {
            jqVar.preferences_ = xVar.c();
        }
        return jqVar.preferences_;
    }

    public static a q() {
        return (a) ((n.a) DEFAULT_INSTANCE.i(n.f.NEW_BUILDER));
    }

    public static jq r(FileInputStream fileInputStream) throws IOException {
        n l = n.l(DEFAULT_INSTANCE, new C0128e.b(fileInputStream), C0132i.a());
        if (l.isInitialized()) {
            return (jq) l;
        }
        throw new q(new C0222iB().getMessage());
    }

    public final Object i(n.f fVar) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new vs(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.a});
            case 3:
                return new jq();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Ho<jq> ho = PARSER;
                if (ho == null) {
                    synchronized (jq.class) {
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

    public final Map<String, C0262lq> p() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
