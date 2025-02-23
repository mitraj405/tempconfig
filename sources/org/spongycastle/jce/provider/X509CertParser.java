package org.spongycastle.jce.provider;

import org.spongycastle.x509.X509StreamParserSpi;

public class X509CertParser extends X509StreamParserSpi {
    static {
        new PEMUtil("CERTIFICATE");
    }
}
