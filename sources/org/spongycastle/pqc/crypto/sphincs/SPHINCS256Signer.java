package org.spongycastle.pqc.crypto.sphincs;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.sphincs.Tree;
import org.spongycastle.util.Pack;

public class SPHINCS256Signer implements MessageSigner {
    public final HashFunctions a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6747a;

    public SPHINCS256Signer(ExtendedDigest extendedDigest, ExtendedDigest extendedDigest2) {
        if (extendedDigest.f() != 32) {
            throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
        } else if (extendedDigest2.f() == 64) {
            this.a = new HashFunctions(extendedDigest, extendedDigest2);
        } else {
            throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
        }
    }

    public final byte[] a(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        byte[] bArr3 = this.f6747a;
        byte[] bArr4 = new byte[41000];
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[64];
        long[] jArr = new long[8];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[32];
        byte[] bArr9 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
        byte[] bArr10 = new byte[1088];
        for (int i2 = 0; i2 < 1088; i2++) {
            bArr10[i2] = bArr3[i2];
        }
        System.arraycopy(bArr10, 1056, bArr4, 40968, 32);
        HashFunctions hashFunctions = this.a;
        Digest digest = hashFunctions.b;
        byte[] bArr11 = new byte[digest.f()];
        digest.update(bArr4, 40968, 32);
        digest.update(bArr2, 0, bArr2.length);
        digest.c(0, bArr11);
        for (int i3 = 0; i3 != 32; i3++) {
            bArr4[40968 + i3] = 0;
        }
        for (int i4 = 0; i4 != 8; i4++) {
            jArr[i4] = Pack.h(i4 * 8, bArr11);
        }
        long j = jArr[0] & 1152921504606846975L;
        System.arraycopy(bArr11, 16, bArr5, 0, 32);
        System.arraycopy(bArr5, 0, bArr4, 39912, 32);
        Tree.leafaddr leafaddr = new Tree.leafaddr();
        leafaddr.a = 11;
        byte[] bArr12 = bArr6;
        leafaddr.f6748a = 0;
        leafaddr.b = 0;
        System.arraycopy(bArr10, 32, bArr4, 39944, UserMetadata.MAX_ATTRIBUTE_SIZE);
        byte[] bArr13 = bArr10;
        byte[] bArr14 = bArr9;
        byte[] bArr15 = bArr8;
        byte[] bArr16 = bArr7;
        Tree.b(hashFunctions, bArr4, 40968, bArr13, leafaddr, bArr4, 39944);
        Digest digest2 = hashFunctions.b;
        digest2.update(bArr4, 39912, 1088);
        digest2.update(bArr2, 0, bArr2.length);
        byte[] bArr17 = bArr12;
        digest2.c(0, bArr17);
        Tree.leafaddr leafaddr2 = new Tree.leafaddr();
        leafaddr2.a = 12;
        leafaddr2.b = (long) ((int) (j & 31));
        leafaddr2.f6748a = j >>> 5;
        for (int i5 = 0; i5 < 32; i5++) {
            bArr4[i5] = bArr5[i5];
        }
        byte[] bArr18 = bArr13;
        System.arraycopy(bArr18, 32, bArr14, 0, UserMetadata.MAX_ATTRIBUTE_SIZE);
        int i6 = 0;
        for (int i7 = 8; i6 < i7; i7 = 8) {
            bArr4[32 + i6] = (byte) ((int) ((j >>> (i6 * 8)) & 255));
            i6++;
        }
        byte[] bArr19 = bArr15;
        Seed.a(hashFunctions, bArr19, 0, bArr18, leafaddr2);
        new Horst();
        byte[] bArr20 = new byte[2097152];
        byte[] bArr21 = new byte[4194272];
        Seed.b(bArr20, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, bArr19, 0);
        for (int i8 = 0; i8 < 65536; i8++) {
            hashFunctions.b((i8 + 65535) * 32, i8 * 32, bArr21, bArr20);
        }
        int i9 = 0;
        while (i9 < 16) {
            int i10 = 16 - i9;
            byte[] bArr22 = bArr19;
            long j2 = (long) ((1 << i10) - 1);
            int i11 = 1 << (i10 - 1);
            byte[] bArr23 = bArr14;
            long j3 = (long) (i11 - 1);
            int i12 = 0;
            while (i12 < i11) {
                hashFunctions.a(bArr21, (int) ((((long) i12) + j3) * 32), bArr21, (int) ((((long) (i12 * 2)) + j2) * 32), bArr23, i9 * 2 * 32);
                i12++;
                i11 = i11;
                bArr18 = bArr18;
                j3 = j3;
            }
            byte[] bArr24 = bArr18;
            i9++;
            bArr19 = bArr22;
            bArr14 = bArr23;
        }
        byte[] bArr25 = bArr18;
        byte[] bArr26 = bArr19;
        byte[] bArr27 = bArr14;
        int i13 = 40;
        int i14 = 2016;
        while (i14 < 4064) {
            bArr4[i13] = bArr21[i14];
            i14++;
            i13++;
        }
        int i15 = 0;
        while (true) {
            if (i15 >= 32) {
                break;
            }
            int i16 = i15 * 2;
            int i17 = (bArr17[i16] & UnsignedBytes.MAX_VALUE) + ((bArr17[i16 + 1] & UnsignedBytes.MAX_VALUE) << 8);
            int i18 = 0;
            for (int i19 = 32; i18 < i19; i19 = 32) {
                bArr4[i13] = bArr20[(i17 * 32) + i18];
                i18++;
                i13++;
            }
            int i20 = i17 + 65535;
            for (int i21 = 0; i21 < 10; i21++) {
                if ((i20 & 1) != 0) {
                    i = i20 + 1;
                } else {
                    i = i20 - 1;
                }
                int i22 = 0;
                while (i22 < 32) {
                    bArr4[i13] = bArr21[(i * 32) + i22];
                    i22++;
                    i13++;
                }
                i20 = (i - 1) / 2;
            }
            i15++;
        }
        int i23 = 0;
        for (int i24 = 32; i23 < i24; i24 = 32) {
            bArr16[i23] = bArr21[i23];
            i23++;
        }
        byte[] bArr28 = bArr16;
        new Wots();
        int i25 = 13352;
        int i26 = 12;
        int i27 = 0;
        while (i27 < i26) {
            leafaddr2.a = i27;
            byte[] bArr29 = bArr26;
            byte[] bArr30 = bArr25;
            Seed.a(hashFunctions, bArr29, 0, bArr30, leafaddr2);
            int[] iArr = new int[67];
            int i28 = 0;
            int i29 = 0;
            while (i28 < 64) {
                byte b = bArr28[i28 / 2];
                iArr[i28] = b & Ascii.SI;
                int i30 = (b & UnsignedBytes.MAX_VALUE) >>> 4;
                iArr[i28 + 1] = i30;
                i29 = (15 - i30) + (15 - iArr[i28]) + i29;
                i28 += 2;
            }
            while (i28 < 67) {
                iArr[i28] = i29 & 15;
                i29 >>>= 4;
                i28++;
            }
            for (int i31 = 0; i31 != 2144; i31++) {
                bArr4[i31 + i25] = 0;
            }
            byte[] bArr31 = bArr30;
            int[] iArr2 = iArr;
            Seed.b(bArr4, i25, 2144, bArr29, 0);
            int i32 = 0;
            while (i32 < 67) {
                int i33 = (i32 * 32) + i25;
                Wots.a(hashFunctions, bArr4, i33, bArr4, i33, bArr27, 0, iArr2[i32]);
                i32++;
                i26 = i26;
                bArr29 = bArr29;
            }
            int i34 = i26;
            byte[] bArr32 = bArr29;
            int i35 = i25 + 2144;
            Tree.leafaddr leafaddr3 = new Tree.leafaddr(leafaddr2);
            byte[] bArr33 = new byte[2048];
            byte[] bArr34 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
            byte[] bArr35 = new byte[68608];
            long j4 = 0;
            while (true) {
                leafaddr3.b = j4;
                if (j4 >= 32) {
                    break;
                }
                Seed.a(hashFunctions, bArr34, (int) (j4 * 32), bArr31, leafaddr3);
                j4 = leafaddr3.b + 1;
                leafaddr2 = leafaddr2;
            }
            Tree.leafaddr leafaddr4 = leafaddr2;
            byte[] bArr36 = bArr31;
            new Wots();
            leafaddr3.b = 0;
            while (true) {
                long j5 = leafaddr3.b;
                if (j5 >= 32) {
                    break;
                }
                byte[] bArr37 = bArr36;
                int i36 = (int) (67 * j5 * 32);
                int i37 = (int) (j5 * 32);
                for (int i38 = 0; i38 != 2144; i38++) {
                    bArr35[i38 + i36] = 0;
                }
                Seed.b(bArr35, i36, 2144, bArr34, i37);
                for (int i39 = 0; i39 < 67; i39++) {
                    int i40 = (i39 * 32) + i36;
                    Wots.a(hashFunctions, bArr35, i40, bArr35, i40, bArr27, 0, 15);
                }
                leafaddr3.b++;
                bArr36 = bArr37;
            }
            byte[] bArr38 = bArr36;
            leafaddr3.b = 0;
            while (true) {
                long j6 = leafaddr3.b;
                if (j6 >= 32) {
                    break;
                }
                Tree.a(hashFunctions, bArr33, (int) ((j6 * 32) + PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), bArr35, (int) (j6 * 67 * 32), bArr27, 0);
                leafaddr3.b++;
            }
            int i41 = 0;
            for (int i42 = 32; i42 > 0; i42 >>>= 1) {
                for (int i43 = 0; i43 < i42; i43 += 2) {
                    hashFunctions.a(bArr33, ((i43 >>> 1) * 32) + ((i42 >>> 1) * 32), bArr33, (i43 * 32) + (i42 * 32), bArr27, (i41 + 7) * 2 * 32);
                }
                i41++;
            }
            Tree.leafaddr leafaddr5 = leafaddr4;
            int i44 = (int) leafaddr5.b;
            for (int i45 = 0; i45 < 5; i45++) {
                System.arraycopy(bArr33, (((i44 >>> i45) ^ 1) * 32) + ((32 >>> i45) * 32), bArr4, (i45 * 32) + i35, 32);
            }
            System.arraycopy(bArr33, 32, bArr28, 0, 32);
            i25 = i35 + 160;
            long j7 = leafaddr5.f6748a;
            leafaddr5.b = (long) ((int) (j7 & 31));
            leafaddr5.f6748a = j7 >>> 5;
            i27++;
            leafaddr2 = leafaddr5;
            i26 = i34;
            bArr26 = bArr32;
            bArr25 = bArr38;
        }
        byte[] bArr39 = bArr25;
        for (int i46 = 0; i46 != 1088; i46++) {
            bArr39[0 + i46] = 0;
        }
        return bArr4;
    }

    public final boolean b(byte[] bArr, byte[] bArr2) {
        byte b;
        boolean z;
        byte b2;
        boolean z2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5 = bArr;
        byte[] bArr6 = bArr2;
        byte[] bArr7 = this.f6747a;
        byte[] bArr8 = new byte[2144];
        byte[] bArr9 = new byte[32];
        byte[] bArr10 = new byte[32];
        byte[] bArr11 = new byte[41000];
        byte[] bArr12 = new byte[1056];
        if (bArr6.length == 41000) {
            byte[] bArr13 = new byte[64];
            boolean z3 = false;
            for (int i = 0; i < 1056; i++) {
                bArr12[i] = bArr7[i];
            }
            byte[] bArr14 = new byte[32];
            for (int i2 = 0; i2 < 32; i2++) {
                bArr14[i2] = bArr6[i2];
            }
            System.arraycopy(bArr6, 0, bArr11, 0, 41000);
            HashFunctions hashFunctions = this.a;
            Digest digest = hashFunctions.b;
            digest.update(bArr14, 0, 32);
            digest.update(bArr12, 0, 1056);
            digest.update(bArr5, 0, bArr5.length);
            digest.c(0, bArr13);
            long j = 0;
            int i3 = 0;
            while (true) {
                b = 8;
                if (i3 >= 8) {
                    break;
                }
                j ^= ((long) (bArr11[32 + i3] & UnsignedBytes.MAX_VALUE)) << (i3 * 8);
                i3++;
            }
            new Horst();
            byte[] bArr15 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
            int i4 = 2088;
            int i5 = 0;
            while (true) {
                z = true;
                if (i5 < 32) {
                    int i6 = i5 * 2;
                    int i7 = (bArr13[i6] & UnsignedBytes.MAX_VALUE) + ((bArr13[i6 + 1] & UnsignedBytes.MAX_VALUE) << b);
                    if ((i7 & 1) == 0) {
                        hashFunctions.b(z3 ? 1 : 0, i4, bArr15, bArr11);
                        for (int i8 = z3; i8 < 32; i8++) {
                            bArr15[i8 + 32] = bArr11[i4 + 32 + i8];
                        }
                    } else {
                        hashFunctions.b(32, i4, bArr15, bArr11);
                        for (int i9 = z3; i9 < 32; i9++) {
                            bArr15[i9] = bArr11[i4 + 32 + i9];
                        }
                    }
                    i4 += 64;
                    for (int i10 = 1; i10 < 10; i10++) {
                        i7 >>>= 1;
                        if ((i7 & 1) == 0) {
                            hashFunctions.a(bArr15, 0, bArr15, 0, bArr12, (i10 - 1) * 2 * 32);
                            for (int i11 = z3; i11 < 32; i11++) {
                                bArr15[i11 + 32] = bArr11[i4 + i11];
                            }
                        } else {
                            hashFunctions.a(bArr15, 32, bArr15, 0, bArr12, (i10 - 1) * 2 * 32);
                            for (int i12 = z3; i12 < 32; i12++) {
                                bArr15[i12] = bArr11[i4 + i12];
                            }
                        }
                        i4 += 32;
                    }
                    int i13 = i7 >>> 1;
                    hashFunctions.a(bArr15, 0, bArr15, 0, bArr12, 576);
                    int i14 = z3;
                    while (i14 < 32) {
                        if (bArr11[(i13 * 32) + 40 + i14] != bArr15[i14]) {
                            for (int i15 = 0; i15 < 32; i15++) {
                                bArr10[i15] = 0;
                            }
                            bArr3 = bArr12;
                            bArr4 = bArr11;
                            b2 = 4;
                            z2 = false;
                        } else {
                            z3 = false;
                            i14++;
                        }
                    }
                    i5++;
                    b = 8;
                } else {
                    for (int i16 = z3; i16 < 32; i16++) {
                        hashFunctions.a(bArr15, i16 * 32, bArr11, (i16 * 2 * 32) + 40, bArr12, 640);
                    }
                    for (int i17 = z3; i17 < 16; i17++) {
                        hashFunctions.a(bArr15, i17 * 32, bArr15, i17 * 2 * 32, bArr12, 704);
                    }
                    for (int i18 = z3; i18 < 8; i18++) {
                        hashFunctions.a(bArr15, i18 * 32, bArr15, i18 * 2 * 32, bArr12, ViewUtils.EDGE_TO_EDGE_FLAGS);
                    }
                    b2 = 4;
                    for (int i19 = z3; i19 < 4; i19++) {
                        hashFunctions.a(bArr15, i19 * 32, bArr15, i19 * 2 * 32, bArr12, 832);
                    }
                    for (int i20 = z3; i20 < 2; i20++) {
                        hashFunctions.a(bArr15, i20 * 32, bArr15, i20 * 2 * 32, bArr12, 896);
                    }
                    z2 = z3;
                    bArr3 = bArr12;
                    bArr4 = bArr11;
                    hashFunctions.a(bArr10, 0, bArr15, 0, bArr12, 960);
                }
            }
            new Wots();
            int i21 = 13352;
            int i22 = z2;
            while (i22 < 12) {
                int i23 = 67;
                int[] iArr = new int[67];
                int i24 = z2;
                int i25 = i24;
                while (i24 < 64) {
                    byte b3 = bArr10[i24 / 2];
                    iArr[i24] = b3 & Ascii.SI;
                    int i26 = (b3 & UnsignedBytes.MAX_VALUE) >>> b2;
                    iArr[i24 + 1] = i26;
                    i25 = (15 - i26) + (15 - iArr[i24]) + i25;
                    i24 += 2;
                }
                while (i24 < 67) {
                    iArr[i24] = i25 & 15;
                    i25 >>>= b2;
                    i24++;
                }
                int i27 = z2;
                while (i27 < i23) {
                    int i28 = i27 * 32;
                    int i29 = iArr[i27];
                    int[] iArr2 = iArr;
                    Wots.a(hashFunctions, bArr8, i28, bArr4, i21 + i28, bArr3, i29 * 32, 15 - i29);
                    i27++;
                    i23 = i23;
                    iArr = iArr2;
                    i22 = i22;
                    bArr10 = bArr10;
                }
                int i30 = i22;
                byte[] bArr16 = bArr10;
                int i31 = i21 + 2144;
                Tree.a(hashFunctions, bArr9, 0, bArr8, 0, bArr3, 0);
                int i32 = (int) (j & 31);
                byte[] bArr17 = new byte[64];
                if ((i32 & 1) != 0) {
                    for (int i33 = z2; i33 < 32; i33++) {
                        bArr17[i33 + 32] = bArr9[i33];
                    }
                    for (int i34 = z2; i34 < 32; i34++) {
                        bArr17[i34] = bArr4[i31 + i34];
                    }
                } else {
                    for (int i35 = z2; i35 < 32; i35++) {
                        bArr17[i35] = bArr9[i35];
                    }
                    for (int i36 = z2; i36 < 32; i36++) {
                        bArr17[i36 + 32] = bArr4[i31 + i36];
                    }
                }
                int i37 = i31 + 32;
                for (int i38 = z2; i38 < b2; i38++) {
                    i32 >>>= 1;
                    if ((i32 & 1) != 0) {
                        hashFunctions.a(bArr17, 32, bArr17, 0, bArr3, (i38 + 7) * 2 * 32);
                        for (int i39 = z2; i39 < 32; i39++) {
                            bArr17[i39] = bArr4[i37 + i39];
                        }
                    } else {
                        hashFunctions.a(bArr17, 0, bArr17, 0, bArr3, (i38 + 7) * 2 * 32);
                        for (int i40 = z2; i40 < 32; i40++) {
                            bArr17[i40 + 32] = bArr4[i37 + i40];
                        }
                    }
                    i37 += 32;
                }
                hashFunctions.a(bArr16, 0, bArr17, 0, bArr3, 704);
                j >>= 5;
                i21 = i31 + 160;
                i22 = i30 + 1;
                bArr10 = bArr16;
            }
            byte[] bArr18 = bArr10;
            for (int i41 = z2; i41 < 32; i41++) {
                if (bArr18[i41] != bArr3[i41 + UserMetadata.MAX_ATTRIBUTE_SIZE]) {
                    z = z2;
                }
            }
            return z;
        }
        throw new IllegalArgumentException("signature wrong size");
    }
}
