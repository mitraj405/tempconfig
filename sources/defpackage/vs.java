package defpackage;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.n;

/* renamed from: vs  reason: default package */
/* compiled from: RawMessageInfo */
public final class vs implements hl {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final A f3382a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3383a;

    /* renamed from: a  reason: collision with other field name */
    public final Object[] f3384a;

    public vs(n nVar, String str, Object[] objArr) {
        this.f3382a = nVar;
        this.f3383a = str;
        this.f3384a = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.a = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 1;
        int i2 = 13;
        while (true) {
            int i3 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i2;
                i2 += 13;
                i = i3;
            } else {
                this.a = c | (charAt2 << i2);
                return;
            }
        }
    }

    public final A a() {
        return this.f3382a;
    }

    public final int b() {
        if ((this.a & 1) == 1) {
            return 1;
        }
        return 2;
    }

    public final Object[] c() {
        return this.f3384a;
    }

    public final String d() {
        return this.f3383a;
    }

    public final boolean isMessageSetWireFormat() {
        if ((this.a & 2) == 2) {
            return true;
        }
        return false;
    }
}
