package defpackage;

import androidx.work.Data;

/* renamed from: hE  reason: default package and case insensitive filesystem */
/* compiled from: WorkSpec */
public final class C0214hE {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f2987a;

    /* renamed from: a  reason: collision with other field name */
    public T6 f2988a;

    /* renamed from: a  reason: collision with other field name */
    public UD f2989a = UD.ENQUEUED;

    /* renamed from: a  reason: collision with other field name */
    public Data f2990a;

    /* renamed from: a  reason: collision with other field name */
    public String f2991a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2992a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f2993b;

    /* renamed from: b  reason: collision with other field name */
    public Data f2994b;

    /* renamed from: b  reason: collision with other field name */
    public String f2995b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public long f2996c;

    /* renamed from: c  reason: collision with other field name */
    public String f2997c;
    public long d;
    public long e;
    public long f;
    public long g;

    /* renamed from: hE$a */
    /* compiled from: WorkSpec */
    public static class a {
        public UD a;

        /* renamed from: a  reason: collision with other field name */
        public String f2998a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != aVar.a) {
                return false;
            }
            return this.f2998a.equals(aVar.f2998a);
        }

        public final int hashCode() {
            return this.a.hashCode() + (this.f2998a.hashCode() * 31);
        }
    }

    static {
        zi.e("WorkSpec");
    }

    public C0214hE(String str, String str2) {
        Data data = Data.a;
        this.f2990a = data;
        this.f2994b = data;
        this.f2988a = T6.a;
        this.b = 1;
        this.d = 30000;
        this.g = -1;
        this.c = 1;
        this.f2991a = str;
        this.f2995b = str2;
    }

    public final long a() {
        boolean z;
        long j;
        long j2;
        long j3;
        boolean z2 = true;
        boolean z3 = false;
        if (this.f2989a != UD.ENQUEUED || this.a <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.b == 2) {
                z3 = true;
            }
            if (z3) {
                j3 = this.d * ((long) this.a);
            } else {
                j3 = (long) Math.scalb((float) this.d, this.a - 1);
            }
            j = this.e;
            j2 = Math.min(18000000, j3);
        } else {
            long j4 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j5 = this.e;
                int i = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                if (i == 0) {
                    j5 = this.f2987a + currentTimeMillis;
                }
                long j6 = this.f2996c;
                long j7 = this.f2993b;
                if (j6 == j7) {
                    z2 = false;
                }
                if (z2) {
                    if (i == 0) {
                        j4 = j6 * -1;
                    }
                    return j5 + j7 + j4;
                }
                if (i != 0) {
                    j4 = j7;
                }
                return j5 + j4;
            }
            j2 = this.e;
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            j = this.f2987a;
        }
        return j2 + j;
    }

    public final boolean b() {
        return !T6.a.equals(this.f2988a);
    }

    public final boolean c() {
        if (this.f2993b != 0) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0214hE.class != obj.getClass()) {
            return false;
        }
        C0214hE hEVar = (C0214hE) obj;
        if (this.f2987a != hEVar.f2987a || this.f2993b != hEVar.f2993b || this.f2996c != hEVar.f2996c || this.a != hEVar.a || this.d != hEVar.d || this.e != hEVar.e || this.f != hEVar.f || this.g != hEVar.g || this.f2992a != hEVar.f2992a || !this.f2991a.equals(hEVar.f2991a) || this.f2989a != hEVar.f2989a || !this.f2995b.equals(hEVar.f2995b)) {
            return false;
        }
        String str = this.f2997c;
        if (str == null ? hEVar.f2997c != null : !str.equals(hEVar.f2997c)) {
            return false;
        }
        if (!this.f2990a.equals(hEVar.f2990a) || !this.f2994b.equals(hEVar.f2994b) || !this.f2988a.equals(hEVar.f2988a) || this.b != hEVar.b) {
            return false;
        }
        if (this.c == hEVar.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f2989a.hashCode();
        int g2 = lf.g(this.f2995b, (hashCode + (this.f2991a.hashCode() * 31)) * 31, 31);
        String str = this.f2997c;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int hashCode2 = this.f2990a.hashCode();
        int hashCode3 = this.f2994b.hashCode();
        long j = this.f2987a;
        long j2 = this.f2993b;
        long j3 = this.f2996c;
        int hashCode4 = this.f2988a.hashCode();
        int V = xx.V(this.b);
        long j4 = this.d;
        long j5 = this.e;
        long j6 = this.f;
        long j7 = this.g;
        return xx.V(this.c) + ((((((((((((V + ((((hashCode4 + ((((((((hashCode3 + ((hashCode2 + ((g2 + i) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.a) * 31)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f2992a ? 1 : 0)) * 31);
    }

    public final String toString() {
        return C0709Uj.j(new StringBuilder("{WorkSpec: "), this.f2991a, "}");
    }

    public C0214hE(C0214hE hEVar) {
        Data data = Data.a;
        this.f2990a = data;
        this.f2994b = data;
        this.f2988a = T6.a;
        this.b = 1;
        this.d = 30000;
        this.g = -1;
        this.c = 1;
        this.f2991a = hEVar.f2991a;
        this.f2995b = hEVar.f2995b;
        this.f2989a = hEVar.f2989a;
        this.f2997c = hEVar.f2997c;
        this.f2990a = new Data(hEVar.f2990a);
        this.f2994b = new Data(hEVar.f2994b);
        this.f2987a = hEVar.f2987a;
        this.f2993b = hEVar.f2993b;
        this.f2996c = hEVar.f2996c;
        this.f2988a = new T6(hEVar.f2988a);
        this.a = hEVar.a;
        this.b = hEVar.b;
        this.d = hEVar.d;
        this.e = hEVar.e;
        this.f = hEVar.f;
        this.g = hEVar.g;
        this.f2992a = hEVar.f2992a;
        this.c = hEVar.c;
    }
}
