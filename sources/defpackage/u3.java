package defpackage;

import java.util.Arrays;

/* renamed from: u3  reason: default package */
/* compiled from: ByteArrayWrapper */
public final class u3 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f3315a;

    public u3(byte[] bArr) {
        this.f3315a = bArr;
        this.a = Arrays.hashCode(bArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u3)) {
            return false;
        }
        return Arrays.equals(this.f3315a, ((u3) obj).f3315a);
    }

    public final int hashCode() {
        return this.a;
    }
}
