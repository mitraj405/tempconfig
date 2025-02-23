package org.spongycastle.asn1.x500;

public interface X500NameStyle {
    String a(X500Name x500Name);

    boolean b(X500Name x500Name, X500Name x500Name2);

    int c(X500Name x500Name);
}
