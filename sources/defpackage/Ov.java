package defpackage;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* renamed from: Ov  reason: default package */
/* compiled from: Segment */
public final class Ov {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Ov f3743a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3744a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f3745a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Ov f3746b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f3747b;

    public Ov() {
        this.f3745a = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        this.f3747b = true;
        this.f3744a = false;
    }

    public final Ov a() {
        Ov ov;
        Ov ov2 = this.f3743a;
        if (ov2 != this) {
            ov = ov2;
        } else {
            ov = null;
        }
        Ov ov3 = this.f3746b;
        ov3.f3743a = ov2;
        this.f3743a.f3746b = ov3;
        this.f3743a = null;
        this.f3746b = null;
        return ov;
    }

    public final void b(Ov ov) {
        ov.f3746b = this;
        ov.f3743a = this.f3743a;
        this.f3743a.f3746b = ov;
        this.f3743a = ov;
    }

    public final Ov c() {
        this.f3744a = true;
        return new Ov(this.f3745a, this.a, this.b, true, false);
    }

    public final void d(Ov ov, int i) {
        if (ov.f3747b) {
            int i2 = ov.b;
            int i3 = i2 + i;
            byte[] bArr = ov.f3745a;
            if (i3 > 8192) {
                if (!ov.f3744a) {
                    int i4 = ov.a;
                    if ((i2 + i) - i4 <= 8192) {
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        ov.b -= ov.a;
                        ov.a = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f3745a, this.a, bArr, ov.b, i);
            ov.b += i;
            this.a += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public Ov(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3745a = bArr;
        this.a = i;
        this.b = i2;
        this.f3744a = z;
        this.f3747b = z2;
    }
}
