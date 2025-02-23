package defpackage;

import android.os.Build;
import defpackage.C0390xD;
import java.util.Arrays;
import java.util.HashSet;

/* renamed from: Y0  reason: default package */
/* compiled from: ApiFeature */
public abstract class Y0 implements C0401y6 {
    public static final HashSet a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public final String f698a;
    public final String b;

    /* renamed from: Y0$a */
    /* compiled from: ApiFeature */
    public static class a {
        public static final HashSet a = new HashSet(Arrays.asList(C0390xD.a.a.c()));
    }

    /* renamed from: Y0$b */
    /* compiled from: ApiFeature */
    public static class b extends Y0 {
        public b(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    /* renamed from: Y0$c */
    /* compiled from: ApiFeature */
    public static class c extends Y0 {
        public c(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    /* renamed from: Y0$d */
    /* compiled from: ApiFeature */
    public static class d extends Y0 {
        public d(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return false;
        }
    }

    /* renamed from: Y0$e */
    /* compiled from: ApiFeature */
    public static class e extends Y0 {
        public e(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    /* renamed from: Y0$f */
    /* compiled from: ApiFeature */
    public static class f extends Y0 {
        public f(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    /* renamed from: Y0$g */
    /* compiled from: ApiFeature */
    public static class g extends Y0 {
        public g() {
            super("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        }

        public final boolean b() {
            if (Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: Y0$h */
    /* compiled from: ApiFeature */
    public static class h extends Y0 {
        public h(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: Y0$i */
    /* compiled from: ApiFeature */
    public static class i extends Y0 {
        public i() {
            super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        }

        public final boolean b() {
            if (Build.VERSION.SDK_INT >= 33) {
                return true;
            }
            return false;
        }
    }

    public Y0(String str, String str2) {
        this.f698a = str;
        this.b = str2;
        a.add(this);
    }

    public final String a() {
        return this.f698a;
    }

    public abstract boolean b();

    public boolean c() {
        boolean z;
        HashSet hashSet = a.a;
        String str = this.b;
        if (hashSet.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        if ("eng".equals(str2) || "userdebug".equals(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (hashSet.contains(str + ":dev")) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSupported() {
        if (b() || c()) {
            return true;
        }
        return false;
    }
}
