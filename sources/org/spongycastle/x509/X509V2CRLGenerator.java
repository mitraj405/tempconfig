package org.spongycastle.x509;

import java.security.cert.CRLException;
import org.spongycastle.asn1.x509.V2TBSCertListGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class X509V2CRLGenerator {

    public static class ExtCRLException extends CRLException {
        public final Throwable getCause() {
            return null;
        }
    }

    public X509V2CRLGenerator() {
        new BCJcaJceHelper();
        new V2TBSCertListGenerator();
        new X509ExtensionsGenerator();
    }
}
