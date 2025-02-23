package org.spongycastle.pqc.crypto.sphincs;

class Tree {

    public static class leafaddr {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f6748a;
        public long b;

        public leafaddr() {
        }

        public leafaddr(leafaddr leafaddr) {
            this.a = leafaddr.a;
            this.f6748a = leafaddr.f6748a;
            this.b = leafaddr.b;
        }
    }

    public static void a(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4;
        byte[] bArr4 = bArr2;
        int i5 = i2;
        int i6 = 67;
        for (int i7 = 0; i7 < 7; i7++) {
            int i8 = 0;
            while (true) {
                i4 = i6 >>> 1;
                if (i8 >= i4) {
                    break;
                }
                hashFunctions.a(bArr2, (i8 * 32) + i5, bArr2, (i8 * 2 * 32) + i5, bArr3, (i7 * 2 * 32) + i3);
                i8++;
            }
            if ((i6 & 1) != 0) {
                System.arraycopy(bArr4, ((i6 - 1) * 32) + i5, bArr4, (i4 * 32) + i5, 32);
                i4++;
            }
            i6 = i4;
        }
        byte[] bArr5 = bArr;
        System.arraycopy(bArr4, i5, bArr, i, 32);
    }

    public static void b(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, leafaddr leafaddr2, byte[] bArr3, int i2) {
        leafaddr leafaddr3 = new leafaddr(leafaddr2);
        byte[] bArr4 = new byte[192];
        int[] iArr = new int[6];
        int i3 = (int) (leafaddr3.b + ((long) 32));
        int i4 = 0;
        while (leafaddr3.b < ((long) i3)) {
            int i5 = i4 * 32;
            byte[] bArr5 = new byte[32];
            byte[] bArr6 = new byte[2144];
            new Wots();
            Seed.a(hashFunctions, bArr5, 0, bArr2, leafaddr3);
            for (int i6 = 0; i6 != 2144; i6++) {
                bArr6[i6 + 0] = 0;
            }
            Seed.b(bArr6, 0, 2144, bArr5, 0);
            for (int i7 = 0; i7 < 67; i7++) {
                int i8 = (i7 * 32) + 0;
                Wots.a(hashFunctions, bArr6, i8, bArr6, i8, bArr3, i2, 15);
            }
            a(hashFunctions, bArr4, i5, bArr6, 0, bArr3, i2);
            iArr[i4] = 0;
            i4++;
            while (i4 > 1) {
                int i9 = i4 - 1;
                int i10 = iArr[i9];
                int i11 = i4 - 2;
                if (i10 != iArr[i11]) {
                    break;
                }
                int i12 = i11 * 32;
                hashFunctions.a(bArr4, i12, bArr4, i12, bArr3, i2 + ((i10 + 7) * 2 * 32));
                iArr[i11] = iArr[i11] + 1;
                i4 = i9;
            }
            leafaddr3.b++;
        }
        for (int i13 = 0; i13 < 32; i13++) {
            bArr[i + i13] = bArr4[i13];
        }
    }
}
