package org.spongycastle.x509;

import org.spongycastle.asn1.x509.V1TBSCertificateGenerator;
import org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class X509V1CertificateGenerator {
    public X509V1CertificateGenerator() {
        new BCJcaJceHelper();
        new CertificateFactory();
        new V1TBSCertificateGenerator();
    }
}
