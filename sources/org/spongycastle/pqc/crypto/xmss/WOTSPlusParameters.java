package org.spongycastle.pqc.crypto.xmss;

import java.util.Map;
import org.spongycastle.crypto.Digest;

final class WOTSPlusParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6763a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSOid f6764a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public WOTSPlusParameters(Digest digest) {
        int i;
        if (digest != null) {
            this.f6763a = digest;
            String b2 = digest.b();
            if (b2.equals("SHAKE128")) {
                i = 32;
            } else if (b2.equals("SHAKE256")) {
                i = 64;
            } else {
                i = digest.f();
            }
            this.a = i;
            this.b = 16;
            int ceil = (int) Math.ceil(((double) (i * 8)) / ((double) XMSSUtil.i(16)));
            this.d = ceil;
            int floor = ((int) Math.floor((double) (XMSSUtil.i(15 * ceil) / XMSSUtil.i(16)))) + 1;
            this.e = floor;
            int i2 = ceil + floor;
            this.c = i2;
            String b3 = digest.b();
            if (b3 != null) {
                WOTSPlusOid wOTSPlusOid = WOTSPlusOid.a.get(WOTSPlusOid.a(i, i2, b3));
                this.f6764a = wOTSPlusOid;
                if (wOTSPlusOid == null) {
                    throw new IllegalArgumentException("cannot find OID for digest algorithm: " + digest.b());
                }
                return;
            }
            Map<String, WOTSPlusOid> map = WOTSPlusOid.a;
            throw new NullPointerException("algorithmName == null");
        }
        throw new NullPointerException("digest == null");
    }
}
