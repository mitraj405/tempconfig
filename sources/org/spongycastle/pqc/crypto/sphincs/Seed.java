package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.pqc.crypto.sphincs.Tree;
import org.spongycastle.util.Pack;

class Seed {
    public static void a(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, Tree.leafaddr leafaddr) {
        byte[] bArr3 = new byte[40];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr3[i2] = bArr2[i2];
        }
        Pack.l((leafaddr.b << 59) | ((long) leafaddr.a) | (leafaddr.f6748a << 4), bArr3, 32);
        Digest digest = hashFunctions.f6744a;
        digest.update(bArr3, 0, 40);
        digest.c(i, bArr);
    }

    public static void b(byte[] bArr, int i, long j, byte[] bArr2, int i2) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(12);
        chaChaEngine.a(true, new ParametersWithIV(new KeyParameter(bArr2, i2, 32), new byte[8], 0, 8));
        chaChaEngine.d(bArr, i, (int) j, bArr, i);
    }
}
