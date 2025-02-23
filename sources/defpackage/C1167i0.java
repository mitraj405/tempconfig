package defpackage;

import javax.crypto.spec.SecretKeySpec;

/* renamed from: i0  reason: default package and case insensitive filesystem */
/* compiled from: AesKey */
public final class C1167i0 extends SecretKeySpec {
    public final /* synthetic */ int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1167i0(byte[] bArr, int i) {
        super(bArr, "AES");
        this.c = i;
        if (i != 1) {
        } else {
            super(bArr, "HMAC");
        }
    }

    public final String toString() {
        switch (this.c) {
            case 0:
                return C1354qp.l(getEncoded().length) + " bit AES key";
            default:
                return super.toString();
        }
    }
}
