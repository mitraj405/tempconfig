package defpackage;

/* renamed from: ng  reason: default package */
/* compiled from: InvalidationLiveDataContainer */
public final class ng {
    public final Object a;
    public final Object b;

    public /* synthetic */ ng(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2 == null ? C1354qp.f6923b : bArr2;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            bArr = C1354qp.f6923b;
        }
        return C1354qp.A(C1354qp.L(bArr.length), bArr);
    }

    public final byte[] a(String str) {
        return b(((nh) this.a).d(str));
    }

    public ng(int i) {
        Object obj;
        this.a = new nh(3);
        Class<C1363r6> cls = C1343q6.f6895a;
        if (cls != null) {
            try {
                obj = cls.newInstance();
            } catch (Exception e) {
                C1343q6.a.f("Unable to create new instance of " + cls, e);
            }
            this.b = obj;
        }
        obj = new C1319p6();
        this.b = obj;
    }
}
