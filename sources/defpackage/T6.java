package defpackage;

/* renamed from: T6  reason: default package */
/* compiled from: Constraints */
public final class T6 {
    public static final T6 a = new T6(new a());

    /* renamed from: a  reason: collision with other field name */
    public long f538a;

    /* renamed from: a  reason: collision with other field name */
    public Em f539a;

    /* renamed from: a  reason: collision with other field name */
    public C0141b7 f540a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f541a;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f542b;
    public boolean c;
    public boolean d;

    /* renamed from: T6$a */
    /* compiled from: Constraints */
    public static final class a {
        public Em a = Em.NOT_REQUIRED;

        /* renamed from: a  reason: collision with other field name */
        public final C0141b7 f543a = new C0141b7();
    }

    public T6() {
        this.f539a = Em.NOT_REQUIRED;
        this.f538a = -1;
        this.b = -1;
        this.f540a = new C0141b7();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || T6.class != obj.getClass()) {
            return false;
        }
        T6 t6 = (T6) obj;
        if (this.f541a == t6.f541a && this.f542b == t6.f542b && this.c == t6.c && this.d == t6.d && this.f538a == t6.f538a && this.b == t6.b && this.f539a == t6.f539a) {
            return this.f540a.equals(t6.f540a);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f538a;
        long j2 = this.b;
        return this.f540a.hashCode() + (((((((((((((this.f539a.hashCode() * 31) + (this.f541a ? 1 : 0)) * 31) + (this.f542b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public T6(a aVar) {
        this.f539a = Em.NOT_REQUIRED;
        this.f538a = -1;
        this.b = -1;
        new C0141b7();
        this.f541a = false;
        this.f542b = false;
        this.f539a = aVar.a;
        this.c = false;
        this.d = false;
        this.f540a = aVar.f543a;
        this.f538a = -1;
        this.b = -1;
    }

    public T6(T6 t6) {
        this.f539a = Em.NOT_REQUIRED;
        this.f538a = -1;
        this.b = -1;
        this.f540a = new C0141b7();
        this.f541a = t6.f541a;
        this.f542b = t6.f542b;
        this.f539a = t6.f539a;
        this.c = t6.c;
        this.d = t6.d;
        this.f540a = t6.f540a;
    }
}
