package defpackage;

/* renamed from: pz  reason: default package and case insensitive filesystem */
/* compiled from: TLV */
public final class C0301pz {
    public final mf a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f3176a;

    public C0301pz(mf mfVar, int i, byte[] bArr) {
        if (i == bArr.length) {
            this.a = mfVar;
            this.f3176a = bArr;
            return;
        }
        throw new IllegalArgumentException("length != bytes.length");
    }
}
