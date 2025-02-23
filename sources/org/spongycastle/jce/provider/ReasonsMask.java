package org.spongycastle.jce.provider;

import org.spongycastle.asn1.x509.ReasonFlags;

class ReasonsMask {
    public static final ReasonsMask a = new ReasonsMask(33023);

    /* renamed from: a  reason: collision with other field name */
    public int f6599a;

    public ReasonsMask(ReasonFlags reasonFlags) {
        this.f6599a = reasonFlags.t();
    }

    public final boolean a() {
        if (this.f6599a == a.f6599a) {
            return true;
        }
        return false;
    }

    public ReasonsMask(int i) {
        this.f6599a = i;
    }

    public ReasonsMask() {
        this(0);
    }
}
