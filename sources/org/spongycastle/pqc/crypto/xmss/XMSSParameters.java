package org.spongycastle.pqc.crypto.xmss;

import java.util.Map;
import org.spongycastle.crypto.ExtendedDigest;

public final class XMSSParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final WOTSPlus f6789a;
    public final int b;

    public XMSSParameters(int i, ExtendedDigest extendedDigest) {
        if (i >= 2) {
            this.f6789a = new WOTSPlus(new WOTSPlusParameters(extendedDigest));
            this.a = i;
            int i2 = 2;
            while (true) {
                int i3 = this.a;
                if (i2 > i3) {
                    throw new IllegalStateException("should never happen...");
                } else if ((i3 - i2) % 2 == 0) {
                    this.b = i2;
                    String b2 = this.f6789a.f6760a.f6763a.b();
                    int a2 = a();
                    WOTSPlusParameters wOTSPlusParameters = this.f6789a.f6760a;
                    int i4 = wOTSPlusParameters.b;
                    int i5 = wOTSPlusParameters.c;
                    if (b2 != null) {
                        DefaultXMSSOid defaultXMSSOid = DefaultXMSSOid.a.get(DefaultXMSSOid.a(b2, a2, i4, i5, i));
                        return;
                    } else {
                        Map<String, DefaultXMSSOid> map = DefaultXMSSOid.a;
                        throw new NullPointerException("algorithmName == null");
                    }
                } else {
                    i2++;
                }
            }
        } else {
            throw new IllegalArgumentException("height must be >= 2");
        }
    }

    public final int a() {
        return this.f6789a.f6760a.a;
    }
}
