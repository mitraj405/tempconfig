package defpackage;

import java.security.Signature;
import javax.crypto.Mac;

/* renamed from: D7  reason: default package and case insensitive filesystem */
/* compiled from: CryptoPrimitive */
public final class C0480D7 {
    public final Signature a;

    /* renamed from: a  reason: collision with other field name */
    public final Mac f3566a;

    public C0480D7(Signature signature, Mac mac) {
        this.a = signature;
        this.f3566a = mac;
    }
}
