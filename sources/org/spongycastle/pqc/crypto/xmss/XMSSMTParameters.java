package org.spongycastle.pqc.crypto.xmss;

import java.util.Map;
import org.spongycastle.crypto.ExtendedDigest;

public final class XMSSMTParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSParameters f6770a;
    public final int b;

    public XMSSMTParameters(int i, int i2, ExtendedDigest extendedDigest) {
        this.a = i;
        this.b = i2;
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        } else if (i % i2 == 0) {
            int i3 = i / i2;
            if (i3 != 1) {
                XMSSParameters xMSSParameters = new XMSSParameters(i3, extendedDigest);
                this.f6770a = xMSSParameters;
                WOTSPlus wOTSPlus = xMSSParameters.f6789a;
                String b2 = wOTSPlus.f6760a.f6763a.b();
                int a2 = a();
                WOTSPlusParameters wOTSPlusParameters = wOTSPlus.f6760a;
                int i4 = wOTSPlusParameters.b;
                int i5 = wOTSPlusParameters.c;
                if (b2 != null) {
                    DefaultXMSSMTOid defaultXMSSMTOid = DefaultXMSSMTOid.a.get(DefaultXMSSMTOid.a(b2, a2, i4, i5, i, i2));
                } else {
                    Map<String, DefaultXMSSMTOid> map = DefaultXMSSMTOid.a;
                    throw new NullPointerException("algorithmName == null");
                }
            } else {
                throw new IllegalArgumentException("height / layers must be greater than 1");
            }
        } else {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
    }

    public final int a() {
        return this.f6770a.a();
    }
}
