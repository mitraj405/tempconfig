package defpackage;

import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* renamed from: nz  reason: default package and case insensitive filesystem */
/* compiled from: TLSSocketFactory */
public final class C1293nz implements X509TrustManager {
    public final /* synthetic */ X509TrustManager a;

    public C1293nz(X509TrustManager x509TrustManager) {
        this.a = x509TrustManager;
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.a.checkClientTrusted(x509CertificateArr, str);
        } catch (CertificateException unused) {
            throw new CertificateException("Certificate not valid or trusted.");
        }
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.a.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateExpiredException unused) {
            throw new CertificateException("Server not trusted.");
        } catch (IllegalArgumentException unused2) {
            throw new IllegalArgumentException("Server not trusted.");
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
