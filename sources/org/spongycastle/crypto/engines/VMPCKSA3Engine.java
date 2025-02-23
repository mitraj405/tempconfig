package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;

public class VMPCKSA3Engine extends VMPCEngine {
    public final String b() {
        return "VMPC-KSA3";
    }

    public final void c(byte[] bArr, byte[] bArr2) {
        this.b = 0;
        this.f6068a = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f6068a[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f6068a;
            byte b = this.b;
            int i3 = i2 & Constants.MAX_HOST_LENGTH;
            byte b2 = bArr3[i3];
            byte b3 = bArr3[(b + b2 + bArr[i2 % bArr.length]) & Constants.MAX_HOST_LENGTH];
            this.b = b3;
            bArr3[i3] = bArr3[b3 & UnsignedBytes.MAX_VALUE];
            bArr3[b3 & UnsignedBytes.MAX_VALUE] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f6068a;
            byte b4 = this.b;
            int i5 = i4 & Constants.MAX_HOST_LENGTH;
            byte b5 = bArr4[i5];
            byte b6 = bArr4[(b4 + b5 + bArr2[i4 % bArr2.length]) & Constants.MAX_HOST_LENGTH];
            this.b = b6;
            bArr4[i5] = bArr4[b6 & UnsignedBytes.MAX_VALUE];
            bArr4[b6 & UnsignedBytes.MAX_VALUE] = b5;
        }
        for (int i6 = 0; i6 < 768; i6++) {
            byte[] bArr5 = this.f6068a;
            byte b7 = this.b;
            int i7 = i6 & Constants.MAX_HOST_LENGTH;
            byte b8 = bArr5[i7];
            byte b9 = bArr5[(b7 + b8 + bArr[i6 % bArr.length]) & Constants.MAX_HOST_LENGTH];
            this.b = b9;
            bArr5[i7] = bArr5[b9 & UnsignedBytes.MAX_VALUE];
            bArr5[b9 & UnsignedBytes.MAX_VALUE] = b8;
        }
        this.a = 0;
    }
}
