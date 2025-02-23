package org.spongycastle.asn1.x500;

import java.util.Vector;
import org.spongycastle.asn1.x500.style.BCStyle;

public class X500NameBuilder {
    public final X500NameStyle a;

    public X500NameBuilder() {
        this(BCStyle.f5722a);
    }

    public X500NameBuilder(X500NameStyle x500NameStyle) {
        new Vector();
        this.a = x500NameStyle;
    }
}
