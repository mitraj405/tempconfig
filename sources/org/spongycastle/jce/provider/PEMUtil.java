package org.spongycastle.jce.provider;

public class PEMUtil {
    public PEMUtil(String str) {
        lf.j("-----BEGIN ", str, "-----");
        lf.j("-----BEGIN X509 ", str, "-----");
        lf.j("-----END ", str, "-----");
        lf.j("-----END X509 ", str, "-----");
    }
}
