package org.spongycastle.jce.provider;

import org.spongycastle.x509.X509StreamParserSpi;

public class X509CRLParser extends X509StreamParserSpi {
    static {
        new PEMUtil("CRL");
    }
}
