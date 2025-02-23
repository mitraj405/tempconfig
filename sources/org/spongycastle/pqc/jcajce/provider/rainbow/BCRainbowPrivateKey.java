package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    public final int[] a;

    /* renamed from: a  reason: collision with other field name */
    public final Layer[] f6816a;

    /* renamed from: a  reason: collision with other field name */
    public final short[] f6817a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6818a;
    public final short[] b;

    /* renamed from: b  reason: collision with other field name */
    public final short[][] f6819b;

    public BCRainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.f6818a = sArr;
        this.f6817a = sArr2;
        this.f6819b = sArr3;
        this.b = sArr4;
        this.a = iArr;
        this.f6816a = layerArr;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (obj == null || !(obj instanceof BCRainbowPrivateKey)) {
            return false;
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) obj;
        if (RainbowUtil.h(this.f6818a, bCRainbowPrivateKey.f6818a)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !RainbowUtil.h(this.f6819b, bCRainbowPrivateKey.f6819b)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || !RainbowUtil.g(this.f6817a, bCRainbowPrivateKey.f6817a)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 || !RainbowUtil.g(this.b, bCRainbowPrivateKey.b)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4 || !Arrays.equals(this.a, bCRainbowPrivateKey.a)) {
            z5 = false;
        } else {
            z5 = true;
        }
        Layer[] layerArr = this.f6816a;
        if (layerArr.length != bCRainbowPrivateKey.f6816a.length) {
            return false;
        }
        for (int length = layerArr.length - 1; length >= 0; length--) {
            z5 &= layerArr[length].equals(bCRainbowPrivateKey.f6816a[length]);
        }
        return z5;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public final byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.a, DERNull.a), new RainbowPrivateKey(this.f6818a, this.f6817a, this.f6819b, this.b, this.a, this.f6816a)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        Layer[] layerArr = this.f6816a;
        int x = org.spongycastle.util.Arrays.x(this.f6818a);
        int w = org.spongycastle.util.Arrays.w(this.f6817a);
        int x2 = org.spongycastle.util.Arrays.x(this.f6819b);
        int u = org.spongycastle.util.Arrays.u(this.a) + ((org.spongycastle.util.Arrays.w(this.b) + ((x2 + ((w + ((x + (layerArr.length * 37)) * 37)) * 37)) * 37)) * 37);
        for (int length = layerArr.length - 1; length >= 0; length--) {
            u = (u * 37) + layerArr[length].hashCode();
        }
        return u;
    }
}
