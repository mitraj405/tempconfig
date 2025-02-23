package org.spongycastle.x509;

import org.spongycastle.asn1.x509.V3TBSCertificateGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;
import org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class X509V3CertificateGenerator {
    public X509V3CertificateGenerator() {
        new BCJcaJceHelper();
        new CertificateFactory();
        new V3TBSCertificateGenerator();
        new X509ExtensionsGenerator();
    }
}
