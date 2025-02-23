package defpackage;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* renamed from: wE  reason: default package and case insensitive filesystem */
/* compiled from: X509Util */
public final class C1457wE {
    public final CertificateFactory a;

    public C1457wE() {
        try {
            this.a = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e);
        }
    }
}
