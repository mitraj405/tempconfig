package org.spongycastle.jcajce.spec;

import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.util.Arrays;

public class AEADParameterSpec extends IvParameterSpec {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6563a = Arrays.c((byte[]) null);

    public AEADParameterSpec(byte[] bArr, int i) {
        super(bArr);
        this.a = i;
    }
}
