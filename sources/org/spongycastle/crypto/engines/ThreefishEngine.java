package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine implements BlockCipher {
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;

    /* renamed from: a  reason: collision with other field name */
    public final int f6057a;

    /* renamed from: a  reason: collision with other field name */
    public final ThreefishCipher f6058a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6059a;

    /* renamed from: a  reason: collision with other field name */
    public final long[] f6060a;

    /* renamed from: b  reason: collision with other field name */
    public final int f6061b;

    /* renamed from: b  reason: collision with other field name */
    public final long[] f6062b;

    /* renamed from: c  reason: collision with other field name */
    public final long[] f6063c;

    public static final class Threefish1024Cipher extends ThreefishCipher {
        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* JADX WARNING: type inference failed for: r80v0, types: [long[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(long[] r79, long[] r80) {
            /*
                r78 = this;
                r0 = r78
                int[] r1 = org.spongycastle.crypto.engines.ThreefishEngine.b
                int[] r2 = org.spongycastle.crypto.engines.ThreefishEngine.d
                long[] r3 = r0.b
                int r4 = r3.length
                r5 = 33
                if (r4 != r5) goto L_0x04f9
                long[] r4 = r0.a
                int r6 = r4.length
                r7 = 5
                if (r6 != r7) goto L_0x04f3
                r6 = 0
                r8 = r79[r6]
                r10 = 1
                r11 = r79[r10]
                r13 = 2
                r14 = r79[r13]
                r16 = 3
                r17 = r79[r16]
                r13 = 4
                r19 = r79[r13]
                r21 = r79[r7]
                r23 = 6
                r24 = r79[r23]
                r26 = 7
                r27 = r79[r26]
                r6 = 8
                r29 = r79[r6]
                r6 = 9
                r31 = r79[r6]
                r5 = 10
                r33 = r79[r5]
                r35 = 11
                r36 = r79[r35]
                r5 = 12
                r38 = r79[r5]
                r7 = 13
                r40 = r79[r7]
                r42 = 14
                r43 = r79[r42]
                r45 = 15
                r46 = r79[r45]
                r5 = 19
            L_0x004f:
                if (r5 < r10) goto L_0x046d
                r48 = r1[r5]
                r49 = r2[r5]
                int r50 = r48 + 1
                r51 = r3[r50]
                long r8 = r8 - r51
                int r51 = r48 + 2
                r52 = r3[r51]
                long r11 = r11 - r52
                int r52 = r48 + 3
                r53 = r3[r52]
                long r14 = r14 - r53
                int r53 = r48 + 4
                r54 = r3[r53]
                r56 = r11
                long r10 = r17 - r54
                int r12 = r48 + 5
                r17 = r3[r12]
                r58 = r14
                long r13 = r19 - r17
                int r15 = r48 + 6
                r17 = r3[r15]
                long r6 = r21 - r17
                int r17 = r48 + 7
                r19 = r3[r17]
                r60 = r1
                long r0 = r24 - r19
                int r18 = r48 + 8
                r19 = r3[r18]
                r61 = r10
                long r10 = r27 - r19
                int r19 = r48 + 9
                r20 = r3[r19]
                r24 = r10
                long r10 = r29 - r20
                int r20 = r48 + 10
                r21 = r3[r20]
                r63 = r6
                long r6 = r31 - r21
                int r21 = r48 + 11
                r27 = r3[r21]
                r29 = r10
                long r10 = r33 - r27
                int r22 = r48 + 12
                r27 = r3[r22]
                r31 = r10
                long r10 = r36 - r27
                int r27 = r48 + 13
                r33 = r3[r27]
                r65 = r6
                long r6 = r38 - r33
                int r28 = r48 + 14
                r33 = r3[r28]
                int r36 = r49 + 1
                r38 = r4[r36]
                long r33 = r33 + r38
                r38 = r6
                long r6 = r40 - r33
                int r33 = r48 + 15
                r40 = r3[r33]
                int r34 = r49 + 2
                r67 = r4[r34]
                long r40 = r40 + r67
                r67 = r12
                r68 = r13
                long r12 = r43 - r40
                int r14 = r48 + 16
                r40 = r3[r14]
                r70 = r15
                long r14 = (long) r5
                long r40 = r40 + r14
                r43 = 1
                long r40 = r40 + r43
                r43 = r14
                long r14 = r46 - r40
                r71 = r2
                r2 = 9
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r14, r8)
                long r8 = r8 - r14
                r2 = 48
                r72 = r4
                r73 = r5
                r4 = r58
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r10, r4)
                long r4 = r4 - r10
                r2 = 35
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r6, r0)
                long r0 = r0 - r6
                r2 = 52
                r46 = r6
                r40 = r10
                r6 = r65
                r10 = r68
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r6, r10)
                long r10 = r10 - r6
                r2 = 23
                r58 = r6
                r6 = r56
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r6, r12)
                long r12 = r12 - r6
                r2 = 31
                r56 = r12
                r12 = r63
                r76 = r14
                r14 = r29
                r29 = r76
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r12, r14)
                long r14 = r14 - r12
                r2 = 37
                r63 = r14
                r14 = r61
                r76 = r0
                r0 = r31
                r31 = r76
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r14, r0)
                long r0 = r0 - r14
                r2 = 20
                r61 = r0
                r0 = r24
                r24 = r6
                r6 = r38
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r0, r6)
                long r6 = r6 - r0
                r2 = 31
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r0, r8)
                long r8 = r8 - r0
                r2 = 44
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r12, r4)
                long r4 = r4 - r12
                r2 = 47
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r14, r10)
                long r10 = r10 - r14
                r2 = 46
                r65 = r12
                r12 = r31
                r76 = r14
                r14 = r24
                r24 = r76
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r14, r12)
                long r12 = r12 - r14
                r68 = r3
                r2 = r29
                r29 = r14
                r14 = 19
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r2, r6)
                long r6 = r6 - r2
                r14 = 42
                r31 = r6
                r6 = r46
                r46 = r0
                r0 = r56
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r6, r0)
                long r0 = r0 - r6
                r56 = r2
                r14 = r40
                r2 = 44
                r40 = r0
                r0 = r63
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r14, r0)
                long r0 = r0 - r14
                r2 = 25
                r63 = r0
                r0 = r58
                r58 = r10
                r10 = r61
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r0, r10)
                long r2 = r10 - r0
                r10 = 16
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r10, r0, r8)
                long r8 = r8 - r0
                r11 = 34
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r11, r6, r4)
                long r4 = r4 - r6
                r11 = 56
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r11, r14, r12)
                long r12 = r12 - r14
                r11 = 51
                r61 = r6
                r6 = r58
                r76 = r14
                r14 = r56
                r56 = r76
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r11, r14, r6)
                long r6 = r6 - r14
                r10 = r46
                r46 = r14
                r14 = 4
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r10, r2)
                long r2 = r2 - r10
                r14 = 53
                r74 = r2
                r2 = r24
                r24 = r0
                r0 = r31
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r2, r0)
                long r0 = r0 - r2
                r14 = 42
                r31 = r0
                r0 = r65
                r76 = r10
                r10 = r40
                r40 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r0, r10)
                long r10 = r10 - r0
                r14 = 41
                r65 = r10
                r10 = r29
                r29 = r12
                r12 = r63
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r10, r12)
                long r12 = r12 - r10
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r10, r8)
                long r8 = r8 - r10
                r15 = 9
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r2, r4)
                long r4 = r4 - r2
                r15 = 37
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r6)
                long r6 = r6 - r0
                r14 = r29
                r29 = r0
                r0 = r40
                r40 = r6
                r6 = 31
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r6, r0, r14)
                long r6 = r14 - r0
                r14 = r24
                r24 = r0
                r0 = 12
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r14, r12)
                long r12 = r12 - r14
                r63 = r12
                r0 = r56
                r12 = 47
                r56 = r14
                r14 = r74
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r0, r14)
                long r12 = r14 - r0
                r14 = r61
                r61 = r12
                r12 = 44
                r76 = r0
                r0 = r31
                r31 = r76
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r14, r0)
                long r0 = r0 - r12
                r14 = 30
                r74 = r12
                r12 = r46
                r46 = r0
                r0 = r65
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r12, r0)
                long r0 = r0 - r12
                r14 = r68[r48]
                long r8 = r8 - r14
                r14 = r68[r50]
                long r10 = r10 - r14
                r14 = r68[r51]
                long r4 = r4 - r14
                r14 = r68[r52]
                long r2 = r2 - r14
                r14 = r68[r53]
                long r14 = r40 - r14
                r40 = r68[r67]
                r50 = r2
                long r2 = r29 - r40
                r29 = r68[r70]
                long r6 = r6 - r29
                r29 = r68[r17]
                r40 = r2
                long r2 = r24 - r29
                r17 = r68[r18]
                r24 = r2
                long r2 = r63 - r17
                r17 = r68[r19]
                r29 = r2
                long r2 = r56 - r17
                r17 = r68[r20]
                r19 = r10
                long r10 = r61 - r17
                r17 = r68[r21]
                r52 = r10
                long r10 = r31 - r17
                r17 = r68[r22]
                r21 = r2
                long r2 = r46 - r17
                r17 = r68[r27]
                r31 = r72[r49]
                long r17 = r17 + r31
                r31 = r2
                long r2 = r74 - r17
                r17 = r68[r28]
                r27 = r72[r36]
                long r17 = r17 + r27
                long r0 = r0 - r17
                r17 = r68[r33]
                long r17 = r17 + r43
                long r12 = r12 - r17
                r17 = r0
                r0 = 5
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r12, r8)
                long r8 = r8 - r12
                r0 = 20
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r10, r4)
                long r4 = r4 - r0
                r10 = 48
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r10, r2, r6)
                long r6 = r6 - r2
                r10 = r21
                r21 = r0
                r0 = 41
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r10, r14)
                long r14 = r14 - r10
                r0 = r19
                r19 = r2
                r2 = 47
                r76 = r10
                r10 = r17
                r17 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r0, r10)
                long r2 = r10 - r0
                r10 = 28
                r27 = r2
                r2 = r40
                r76 = r12
                r11 = r29
                r29 = r76
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r10, r2, r11)
                long r10 = r11 - r2
                r40 = r0
                r33 = r10
                r12 = r50
                r10 = r52
                r0 = 16
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r12, r10)
                long r10 = r10 - r0
                r12 = 25
                r43 = r10
                r10 = r24
                r24 = r6
                r6 = r31
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r10, r6)
                long r6 = r6 - r10
                r13 = 33
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r13, r10, r8)
                long r8 = r8 - r10
                r12 = 4
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r2, r4)
                long r4 = r4 - r2
                r12 = 51
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r0, r14)
                long r14 = r14 - r0
                r31 = r14
                r13 = r24
                r12 = 13
                r24 = r2
                r2 = r40
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r2, r13)
                long r12 = r13 - r2
                r14 = 34
                r40 = r2
                r2 = r29
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r2, r6)
                long r6 = r6 - r2
                r14 = r19
                r19 = r0
                r0 = r27
                r27 = r6
                r6 = 41
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r6, r14, r0)
                long r0 = r0 - r6
                r14 = 59
                r29 = r0
                r0 = r21
                r21 = r10
                r10 = r33
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r0, r10)
                long r10 = r10 - r0
                r14 = 17
                r33 = r10
                r10 = r17
                r17 = r2
                r2 = r43
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r10, r2)
                long r2 = r2 - r10
                r14 = 38
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r10, r8)
                long r8 = r8 - r10
                r14 = 19
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.j(r14, r6, r4)
                long r4 = r4 - r6
                r15 = 10
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r12)
                long r12 = r12 - r0
                r15 = 55
                r43 = r6
                r6 = r31
                r76 = r0
                r0 = r17
                r17 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r6)
                long r6 = r6 - r0
                r15 = 49
                r31 = r0
                r0 = r21
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r2)
                long r2 = r2 - r0
                r15 = 18
                r21 = r2
                r2 = r19
                r19 = r10
                r10 = r27
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r2, r10)
                long r10 = r10 - r2
                r15 = 23
                r27 = r10
                r10 = r24
                r24 = r0
                r0 = r29
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r10, r0)
                long r0 = r0 - r10
                r15 = 52
                r29 = r0
                r0 = r40
                r76 = r12
                r12 = r33
                r33 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r12)
                long r12 = r12 - r0
                r15 = 24
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r0, r8)
                long r8 = r8 - r0
                r15 = 13
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r2, r4)
                long r4 = r4 - r2
                r15 = 8
                long r10 = org.spongycastle.crypto.engines.ThreefishEngine.j(r15, r10, r6)
                long r6 = r6 - r10
                r14 = r33
                r33 = r2
                r2 = 47
                r76 = r0
                r0 = r24
                r24 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r2, r0, r14)
                long r2 = r14 - r0
                r14 = r19
                r19 = r0
                r0 = 8
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r14, r12)
                long r0 = r12 - r14
                r12 = 17
                r38 = r0
                r0 = r17
                r17 = r2
                r2 = r21
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r0, r2)
                long r2 = r2 - r0
                r12 = 22
                r21 = r0
                r0 = r43
                r76 = r2
                r2 = r27
                r27 = r76
                long r40 = org.spongycastle.crypto.engines.ThreefishEngine.j(r12, r0, r2)
                long r0 = r2 - r40
                r12 = r29
                r2 = r31
                r29 = r0
                r0 = 37
                long r46 = org.spongycastle.crypto.engines.ThreefishEngine.j(r0, r2, r12)
                long r43 = r12 - r46
                int r0 = r73 + -2
                r31 = r14
                r36 = r21
                r1 = r60
                r3 = r68
                r2 = r71
                r13 = 4
                r14 = r4
                r21 = r10
                r11 = r24
                r4 = r72
                r10 = 1
                r5 = r0
                r24 = r17
                r17 = r33
                r0 = r78
                r33 = r27
                r27 = r19
                r19 = r6
                r6 = 9
                r76 = r29
                r29 = r38
                r38 = r76
                goto L_0x004f
            L_0x046d:
                r68 = r3
                r72 = r4
                r1 = 0
                r2 = r68[r1]
                long r8 = r8 - r2
                r0 = 1
                r1 = r68[r0]
                long r11 = r11 - r1
                r0 = 2
                r1 = r68[r0]
                long r14 = r14 - r1
                r0 = r68[r16]
                long r17 = r17 - r0
                r0 = 4
                r1 = r68[r0]
                long r19 = r19 - r1
                r0 = 5
                r1 = r68[r0]
                long r21 = r21 - r1
                r0 = r68[r23]
                long r24 = r24 - r0
                r0 = r68[r26]
                long r27 = r27 - r0
                r0 = 8
                r1 = r68[r0]
                long r29 = r29 - r1
                r0 = 9
                r1 = r68[r0]
                long r31 = r31 - r1
                r0 = 10
                r1 = r68[r0]
                long r33 = r33 - r1
                r0 = r68[r35]
                long r36 = r36 - r0
                r0 = 12
                r1 = r68[r0]
                long r38 = r38 - r1
                r0 = 13
                r1 = r68[r0]
                r0 = 0
                r3 = r72[r0]
                long r1 = r1 + r3
                long r40 = r40 - r1
                r1 = r68[r42]
                r3 = 1
                r4 = r72[r3]
                long r1 = r1 + r4
                long r43 = r43 - r1
                r1 = r68[r45]
                long r46 = r46 - r1
                r80[r0] = r8
                r80[r3] = r11
                r0 = 2
                r80[r0] = r14
                r80[r16] = r17
                r0 = 4
                r80[r0] = r19
                r0 = 5
                r80[r0] = r21
                r80[r23] = r24
                r80[r26] = r27
                r0 = 8
                r80[r0] = r29
                r0 = 9
                r80[r0] = r31
                r0 = 10
                r80[r0] = r33
                r80[r35] = r36
                r0 = 12
                r80[r0] = r38
                r0 = 13
                r80[r0] = r40
                r80[r42] = r43
                r80[r45] = r46
                return
            L_0x04f3:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04f9:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.a(long[], long[]):void");
        }

        /* JADX WARNING: type inference failed for: r86v0, types: [long[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(long[] r85, long[] r86) {
            /*
                r84 = this;
                r0 = r84
                int[] r1 = org.spongycastle.crypto.engines.ThreefishEngine.b
                int[] r2 = org.spongycastle.crypto.engines.ThreefishEngine.d
                long[] r3 = r0.b
                int r4 = r3.length
                r5 = 33
                if (r4 != r5) goto L_0x04c3
                long[] r4 = r0.a
                int r6 = r4.length
                r7 = 5
                if (r6 != r7) goto L_0x04bd
                r6 = 0
                r8 = r85[r6]
                r10 = 1
                r11 = r85[r10]
                r13 = 2
                r14 = r85[r13]
                r16 = 3
                r17 = r85[r16]
                r5 = 4
                r19 = r85[r5]
                r21 = r85[r7]
                r23 = 6
                r24 = r85[r23]
                r26 = 7
                r27 = r85[r26]
                r7 = 8
                r30 = r85[r7]
                r7 = 9
                r33 = r85[r7]
                r7 = 10
                r36 = r85[r7]
                r38 = 11
                r39 = r85[r38]
                r7 = 12
                r42 = r85[r7]
                r7 = 13
                r45 = r85[r7]
                r47 = 14
                r48 = r85[r47]
                r50 = 15
                r51 = r85[r50]
                r53 = r3[r6]
                long r8 = r8 + r53
                r53 = r3[r10]
                long r11 = r11 + r53
                r53 = r3[r13]
                long r14 = r14 + r53
                r53 = r3[r16]
                long r17 = r17 + r53
                r53 = r3[r5]
                long r19 = r19 + r53
                r29 = 5
                r53 = r3[r29]
                long r21 = r21 + r53
                r53 = r3[r23]
                long r24 = r24 + r53
                r53 = r3[r26]
                long r27 = r27 + r53
                r32 = 8
                r53 = r3[r32]
                long r30 = r30 + r53
                r35 = 9
                r53 = r3[r35]
                long r33 = r33 + r53
                r41 = 10
                r53 = r3[r41]
                long r36 = r36 + r53
                r53 = r3[r38]
                long r39 = r39 + r53
                r44 = 12
                r53 = r3[r44]
                long r42 = r42 + r53
                r53 = r3[r7]
                r55 = r4[r6]
                long r53 = r53 + r55
                long r53 = r53 + r45
                r45 = r3[r47]
                r55 = r4[r10]
                long r45 = r45 + r55
                long r45 = r45 + r48
                r48 = r3[r50]
                long r51 = r51 + r48
                r5 = r17
                r57 = r21
                r59 = r27
                r61 = r33
                r63 = r39
                r65 = r51
                r67 = r53
            L_0x00ad:
                r13 = 20
                if (r10 >= r13) goto L_0x047c
                r27 = r1[r10]
                r28 = r2[r10]
                long r8 = r8 + r11
                r13 = 24
                long r11 = org.spongycastle.crypto.engines.ThreefishEngine.h(r13, r11, r8)
                long r14 = r14 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.h(r7, r5, r14)
                r33 = r8
                r39 = r14
                r7 = r57
                long r13 = r19 + r7
                r15 = 8
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r7, r13)
                r51 = r1
                r48 = r10
                r9 = r59
                long r0 = r24 + r9
                r15 = 47
                long r9 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r9, r0)
                r52 = r2
                r53 = r3
                r54 = r11
                r2 = r61
                long r11 = r30 + r2
                r15 = 8
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r2, r11)
                r56 = r7
                r24 = r11
                r11 = r63
                long r7 = r36 + r11
                r15 = 17
                long r11 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r11, r7)
                r58 = r4
                r59 = r5
                r30 = r7
                r4 = r67
                long r6 = r42 + r4
                r8 = 22
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r8, r4, r6)
                r36 = r6
                r61 = r9
                r6 = r65
                long r8 = r45 + r6
                r10 = 37
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r10, r6, r8)
                r63 = r11
                long r10 = r33 + r2
                r15 = 38
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r2, r10)
                r33 = r13
                long r12 = r39 + r4
                r15 = 19
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r15, r4, r12)
                long r0 = r0 + r63
                r39 = r2
                r14 = r63
                r2 = 10
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r14, r0)
                long r2 = r33 + r6
                r33 = r14
                r14 = 55
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r6, r2)
                long r14 = r30 + r61
                r30 = r4
                r4 = 49
                r42 = r6
                r5 = r61
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r5, r14)
                long r6 = r36 + r59
                r36 = r14
                r14 = 18
                r45 = r0
                r0 = r59
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r0, r6)
                long r8 = r8 + r56
                r14 = 23
                r59 = r6
                r6 = r56
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r6, r8)
                long r14 = r24 + r54
                r24 = r8
                r8 = 52
                r56 = r0
                r0 = r54
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r8, r0, r14)
                long r10 = r10 + r4
                r8 = 33
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r8, r4, r10)
                long r12 = r12 + r6
                r9 = 4
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r9, r6, r12)
                long r2 = r2 + r56
                r9 = 51
                r54 = r12
                r12 = r56
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.h(r9, r12, r2)
                long r8 = r45 + r0
                r45 = r12
                r12 = 13
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r0, r8)
                r69 = r45
                r45 = r54
                r54 = r14
                long r13 = r59 + r42
                r12 = 34
                r56 = r4
                r4 = r42
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r4, r13)
                r42 = r13
                long r12 = r24 + r30
                r14 = 41
                r24 = r6
                r6 = r30
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r6, r12)
                long r14 = r54 + r33
                r54 = r0
                r0 = 59
                r59 = r12
                r12 = r33
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r0, r12, r14)
                long r12 = r36 + r39
                r33 = r14
                r14 = 17
                r36 = r2
                r2 = r39
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r2, r12)
                long r10 = r10 + r4
                r14 = 5
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r14, r4, r10)
                long r14 = r45 + r0
                r39 = r4
                r4 = 20
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r0, r14)
                long r8 = r8 + r6
                r4 = 48
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r6, r8)
                long r6 = r36 + r2
                r36 = r4
                r4 = 41
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r2, r6)
                long r4 = r59 + r54
                r45 = r0
                r0 = r54
                r54 = r2
                r2 = 47
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r0, r4)
                long r2 = r33 + r24
                r33 = r4
                r4 = 28
                r59 = r8
                r8 = r24
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r8, r2)
                r8 = r69
                long r12 = r12 + r8
                r24 = r2
                r2 = 16
                long r8 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r8, r12)
                long r2 = r42 + r56
                r42 = r12
                r12 = 25
                r61 = r4
                r4 = r56
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r4, r2)
                r12 = r53[r27]
                long r10 = r10 + r12
                int r13 = r27 + 1
                r56 = r53[r13]
                long r0 = r0 + r56
                int r56 = r27 + 2
                r63 = r53[r56]
                long r14 = r14 + r63
                int r57 = r27 + 3
                r63 = r53[r57]
                long r8 = r8 + r63
                int r63 = r27 + 4
                r64 = r53[r63]
                long r6 = r6 + r64
                int r64 = r27 + 5
                r65 = r53[r64]
                r67 = r13
                long r12 = r61 + r65
                int r61 = r27 + 6
                r65 = r53[r61]
                long r59 = r59 + r65
                int r62 = r27 + 7
                r65 = r53[r62]
                long r4 = r4 + r65
                int r65 = r27 + 8
                r68 = r53[r65]
                long r24 = r24 + r68
                int r66 = r27 + 9
                r68 = r53[r66]
                r70 = r4
                long r4 = r54 + r68
                int r54 = r27 + 10
                r68 = r53[r54]
                long r42 = r42 + r68
                int r55 = r27 + 11
                r68 = r53[r55]
                r72 = r4
                long r4 = r45 + r68
                int r45 = r27 + 12
                r68 = r53[r45]
                long r2 = r2 + r68
                int r46 = r27 + 13
                r68 = r53[r46]
                r74 = r58[r28]
                long r68 = r68 + r74
                r74 = r2
                long r2 = r68 + r36
                int r36 = r27 + 14
                r68 = r53[r36]
                int r37 = r28 + 1
                r76 = r58[r37]
                long r68 = r68 + r76
                long r68 = r68 + r33
                int r33 = r27 + 15
                r76 = r53[r33]
                r78 = r2
                r80 = r4
                r2 = r48
                long r3 = (long) r2
                long r76 = r76 + r3
                r82 = r3
                long r2 = r76 + r39
                long r10 = r10 + r0
                r4 = 41
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r0, r10)
                long r14 = r14 + r8
                r4 = 9
                long r8 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r8, r14)
                long r6 = r6 + r12
                r4 = 37
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r12, r6)
                r4 = r12
                long r12 = r59 + r70
                r39 = r0
                r0 = 31
                r59 = r4
                r4 = r70
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r0, r4, r12)
                long r0 = r24 + r72
                r70 = r4
                r24 = r8
                r8 = r72
                r4 = 12
                long r8 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r8, r0)
                long r4 = r42 + r80
                r42 = r0
                r72 = r6
                r0 = r80
                r6 = 47
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r0, r4)
                long r6 = r74 + r78
                r74 = r4
                r4 = 44
                r76 = r0
                r0 = r78
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r0, r6)
                long r4 = r68 + r2
                r68 = r6
                r6 = 30
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r2, r4)
                long r10 = r10 + r8
                r6 = 16
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r8, r10)
                long r14 = r14 + r0
                r6 = 34
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r0, r14)
                long r12 = r12 + r76
                r6 = 56
                r79 = r7
                r7 = r76
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r7, r12)
                long r8 = r72 + r2
                r72 = r6
                r6 = 51
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r2, r8)
                long r6 = r74 + r70
                r74 = r0
                r0 = r70
                r70 = r2
                r2 = 4
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r0, r6)
                long r2 = r68 + r24
                r68 = r6
                r6 = 53
                r76 = r12
                r12 = r24
                long r6 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r12, r2)
                long r4 = r4 + r59
                r12 = 42
                r24 = r2
                r2 = r59
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r2, r4)
                long r12 = r42 + r39
                r42 = r4
                r4 = r39
                r39 = r6
                r6 = 41
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r4, r12)
                long r10 = r10 + r0
                r6 = 31
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r0, r10)
                long r14 = r14 + r2
                r6 = 44
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r2, r14)
                long r8 = r8 + r39
                r6 = r39
                r39 = r0
                r0 = 47
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r0, r6, r8)
                long r6 = r76 + r4
                r59 = r0
                r0 = 46
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r0, r4, r6)
                long r4 = r24 + r70
                r24 = r2
                r2 = 19
                r76 = r0
                r0 = r70
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r0, r4)
                long r2 = r42 + r74
                r42 = r4
                r4 = 42
                r70 = r8
                r8 = r74
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r8, r2)
                long r12 = r12 + r72
                r8 = r72
                r72 = r2
                r2 = 44
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r8, r12)
                long r8 = r68 + r79
                r68 = r12
                r12 = 25
                r74 = r4
                r4 = r79
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r4, r8)
                long r10 = r10 + r0
                r12 = 9
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r0, r10)
                long r14 = r14 + r2
                r12 = 48
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r2, r14)
                long r6 = r6 + r74
                r12 = 35
                r78 = r0
                r0 = r74
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r12, r0, r6)
                long r12 = r70 + r4
                r70 = r0
                r0 = 52
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r0, r4, r12)
                long r4 = r72 + r76
                r72 = r2
                r2 = 23
                r74 = r0
                r0 = r76
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r0, r4)
                long r2 = r68 + r24
                r68 = r4
                r4 = r24
                r24 = r6
                r6 = 31
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r6, r4, r2)
                long r8 = r8 + r59
                r19 = r2
                r6 = r59
                r2 = 37
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.h(r2, r6, r8)
                long r6 = r42 + r39
                r42 = r8
                r8 = r39
                r39 = r4
                r4 = 20
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.h(r4, r8, r6)
                r8 = r53[r67]
                long r8 = r8 + r10
                r10 = r53[r56]
                long r0 = r0 + r10
                r10 = r53[r57]
                long r14 = r14 + r10
                r10 = r53[r63]
                long r2 = r2 + r10
                r10 = r53[r64]
                long r10 = r10 + r12
                r12 = r53[r61]
                long r12 = r39 + r12
                r39 = r53[r62]
                long r24 = r24 + r39
                r39 = r53[r65]
                long r59 = r4 + r39
                r4 = r53[r66]
                long r4 = r19 + r4
                r19 = r53[r54]
                long r61 = r74 + r19
                r19 = r53[r55]
                long r19 = r42 + r19
                r39 = r53[r45]
                long r63 = r72 + r39
                r39 = r53[r46]
                long r42 = r6 + r39
                r6 = r53[r36]
                r36 = r58[r37]
                long r6 = r6 + r36
                long r6 = r6 + r70
                r33 = r53[r33]
                r22 = 2
                int r28 = r28 + 2
                r36 = r58[r28]
                long r33 = r33 + r36
                long r45 = r33 + r68
                r28 = 16
                int r27 = r27 + 16
                r27 = r53[r27]
                long r27 = r27 + r82
                r30 = 1
                long r27 = r27 + r30
                long r65 = r27 + r78
                int r27 = r48 + 2
                r30 = r4
                r67 = r6
                r36 = r19
                r4 = r58
                r7 = 13
                r5 = r2
                r19 = r10
                r57 = r12
                r10 = r27
                r2 = r52
                r3 = r53
                r11 = r0
                r1 = r51
                r0 = r84
                goto L_0x00ad
            L_0x047c:
                r0 = r5
                r39 = r8
                r27 = r11
                r33 = r57
                r9 = r59
                r2 = r61
                r11 = r63
                r6 = r65
                r4 = r67
                r8 = 0
                r86[r8] = r39
                r8 = 1
                r86[r8] = r27
                r8 = 2
                r86[r8] = r14
                r86[r16] = r0
                r0 = 4
                r86[r0] = r19
                r0 = 5
                r86[r0] = r33
                r86[r23] = r24
                r86[r26] = r9
                r0 = 8
                r86[r0] = r30
                r0 = 9
                r86[r0] = r2
                r0 = 10
                r86[r0] = r36
                r86[r38] = r11
                r0 = 12
                r86[r0] = r42
                r0 = 13
                r86[r0] = r4
                r86[r47] = r45
                r86[r50] = r6
                return
            L_0x04bd:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04c3:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.b(long[], long[]):void");
        }
    }

    public static final class Threefish256Cipher extends ThreefishCipher {
        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public final void a(long[] jArr, long[] jArr2) {
            int[] iArr = ThreefishEngine.c;
            int[] iArr2 = ThreefishEngine.d;
            long[] jArr3 = this.b;
            if (jArr3.length == 9) {
                long[] jArr4 = this.a;
                if (jArr4.length == 5) {
                    boolean z = false;
                    long j = jArr[0];
                    int i = 1;
                    long j2 = jArr[1];
                    long j3 = jArr[2];
                    long j4 = jArr[3];
                    int i2 = 17;
                    while (i2 >= i) {
                        int i3 = iArr[i2];
                        int i4 = iArr2[i2];
                        int i5 = i3 + 1;
                        long j5 = j - jArr3[i5];
                        int i6 = i3 + 2;
                        int i7 = i4 + 1;
                        long j6 = j2 - (jArr3[i6] + jArr4[i7]);
                        int i8 = i3 + 3;
                        long j7 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                        long j8 = (long) i2;
                        long j9 = ThreefishEngine.j(32, j4 - ((jArr3[i3 + 4] + j8) + 1), j5);
                        long j10 = j5 - j9;
                        long j11 = ThreefishEngine.j(32, j6, j7);
                        long j12 = j7 - j11;
                        long j13 = ThreefishEngine.j(58, j11, j10);
                        long j14 = j10 - j13;
                        long j15 = ThreefishEngine.j(22, j9, j12);
                        long j16 = j12 - j15;
                        long j17 = ThreefishEngine.j(46, j15, j14);
                        long j18 = j14 - j17;
                        long j19 = ThreefishEngine.j(12, j13, j16);
                        long j20 = j16 - j19;
                        long j21 = ThreefishEngine.j(25, j19, j18);
                        long j22 = ThreefishEngine.j(33, j17, j20);
                        long j23 = (j18 - j21) - jArr3[i3];
                        long j24 = j21 - (jArr3[i5] + jArr4[i4]);
                        long j25 = (j20 - j22) - (jArr3[i6] + jArr4[i7]);
                        long j26 = ThreefishEngine.j(5, j22 - (jArr3[i8] + j8), j23);
                        long j27 = j23 - j26;
                        long j28 = ThreefishEngine.j(37, j24, j25);
                        long j29 = j25 - j28;
                        long j30 = ThreefishEngine.j(23, j28, j27);
                        long j31 = j27 - j30;
                        long j32 = ThreefishEngine.j(40, j26, j29);
                        long j33 = j29 - j32;
                        long j34 = ThreefishEngine.j(52, j32, j31);
                        long j35 = j31 - j34;
                        long j36 = ThreefishEngine.j(57, j30, j33);
                        long j37 = j33 - j36;
                        long j38 = ThreefishEngine.j(14, j36, j35);
                        j = j35 - j38;
                        j4 = ThreefishEngine.j(16, j34, j37);
                        j3 = j37 - j4;
                        i2 -= 2;
                        j2 = j38;
                        iArr = iArr;
                        z = false;
                        i = 1;
                    }
                    char c = z;
                    long j39 = j2 - (jArr3[1] + jArr4[c]);
                    jArr2[c] = j - jArr3[c];
                    jArr2[1] = j39;
                    jArr2[2] = j3 - (jArr3[2] + jArr4[1]);
                    jArr2[3] = j4 - jArr3[3];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public final void b(long[] jArr, long[] jArr2) {
            int[] iArr = ThreefishEngine.c;
            int[] iArr2 = ThreefishEngine.d;
            long[] jArr3 = this.b;
            if (jArr3.length == 9) {
                long[] jArr4 = this.a;
                if (jArr4.length == 5) {
                    long j = jArr[0];
                    long j2 = jArr[1];
                    long j3 = jArr[2];
                    long j4 = jArr[3];
                    long j5 = j + jArr3[0];
                    long j6 = jArr3[1] + jArr4[0] + j2;
                    long j7 = jArr3[2] + jArr4[1] + j3;
                    int i = 1;
                    long j8 = j4 + jArr3[3];
                    long j9 = j6;
                    while (i < 18) {
                        int i2 = iArr[i];
                        int i3 = iArr2[i];
                        long j10 = j5 + j9;
                        long h = ThreefishEngine.h(14, j9, j10);
                        long j11 = j7 + j8;
                        long h2 = ThreefishEngine.h(16, j8, j11);
                        long j12 = j10 + h2;
                        long h3 = ThreefishEngine.h(52, h2, j12);
                        long j13 = j11 + h;
                        long h4 = ThreefishEngine.h(57, h, j13);
                        long j14 = j12 + h4;
                        long h5 = ThreefishEngine.h(23, h4, j14);
                        long j15 = j13 + h3;
                        long h6 = ThreefishEngine.h(40, h3, j15);
                        long j16 = j14 + h6;
                        long h7 = ThreefishEngine.h(5, h6, j16);
                        long j17 = j15 + h5;
                        long h8 = ThreefishEngine.h(37, h5, j17);
                        long j18 = j16 + jArr3[i2];
                        int i4 = i2 + 1;
                        long j19 = jArr3[i4] + jArr4[i3] + h8;
                        int i5 = i2 + 2;
                        int i6 = i3 + 1;
                        long j20 = jArr3[i5] + jArr4[i6] + j17;
                        int i7 = i2 + 3;
                        long j21 = (long) i;
                        long j22 = jArr3[i7] + j21 + h7;
                        long j23 = j18 + j19;
                        long h9 = ThreefishEngine.h(25, j19, j23);
                        long j24 = j21;
                        long j25 = j20 + j22;
                        long h10 = ThreefishEngine.h(33, j22, j25);
                        long j26 = j23 + h10;
                        long h11 = ThreefishEngine.h(46, h10, j26);
                        long j27 = j25 + h9;
                        long h12 = ThreefishEngine.h(12, h9, j27);
                        long j28 = j26 + h12;
                        long h13 = ThreefishEngine.h(58, h12, j28);
                        long j29 = j27 + h11;
                        long h14 = ThreefishEngine.h(22, h11, j29);
                        long j30 = j28 + h14;
                        long h15 = ThreefishEngine.h(32, h14, j30);
                        long j31 = j29 + h13;
                        long h16 = ThreefishEngine.h(32, h13, j31);
                        j5 = j30 + jArr3[i4];
                        j9 = h16 + jArr3[i5] + jArr4[i6];
                        long j32 = j31 + jArr3[i7] + jArr4[i3 + 2];
                        j8 = jArr3[i2 + 4] + j24 + 1 + h15;
                        i += 2;
                        j7 = j32;
                        iArr = iArr;
                    }
                    jArr2[0] = j5;
                    jArr2[1] = j9;
                    jArr2[2] = j7;
                    jArr2[3] = j8;
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class Threefish512Cipher extends ThreefishCipher {
        public Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public final void a(long[] jArr, long[] jArr2) {
            int[] iArr = ThreefishEngine.a;
            int[] iArr2 = ThreefishEngine.d;
            long[] jArr3 = this.b;
            if (jArr3.length == 17) {
                long[] jArr4 = this.a;
                if (jArr4.length == 5) {
                    boolean z = false;
                    long j = jArr[0];
                    int i = 1;
                    long j2 = jArr[1];
                    long j3 = jArr[2];
                    long j4 = jArr[3];
                    long j5 = jArr[4];
                    long j6 = jArr[5];
                    long j7 = jArr[6];
                    long j8 = jArr[7];
                    int i2 = 17;
                    while (i2 >= i) {
                        int i3 = iArr[i2];
                        int i4 = iArr2[i2];
                        int i5 = i3 + 1;
                        long j9 = j - jArr3[i5];
                        int i6 = i3 + 2;
                        long j10 = j2 - jArr3[i6];
                        int i7 = i3 + 3;
                        long j11 = j3 - jArr3[i7];
                        int i8 = i3 + 4;
                        long j12 = j4 - jArr3[i8];
                        int i9 = i3 + 5;
                        long j13 = j5 - jArr3[i9];
                        int i10 = i3 + 6;
                        int i11 = i4 + 1;
                        long j14 = j6 - (jArr3[i10] + jArr4[i11]);
                        int i12 = i3 + 7;
                        long j15 = j7 - (jArr3[i12] + jArr4[i4 + 2]);
                        int[] iArr3 = iArr2;
                        long[] jArr5 = jArr3;
                        long j16 = (long) i2;
                        long j17 = j16;
                        int i13 = i2;
                        long[] jArr6 = jArr4;
                        long j18 = ThreefishEngine.j(8, j10, j15);
                        long j19 = j15 - j18;
                        long j20 = ThreefishEngine.j(35, j8 - ((jArr3[i3 + 8] + j16) + 1), j9);
                        long j21 = j9 - j20;
                        long j22 = j20;
                        long j23 = j11;
                        long j24 = ThreefishEngine.j(56, j14, j23);
                        long j25 = j23 - j24;
                        long j26 = ThreefishEngine.j(22, j12, j13);
                        long j27 = j13 - j26;
                        long j28 = ThreefishEngine.j(25, j18, j27);
                        long j29 = j27 - j28;
                        long j30 = ThreefishEngine.j(29, j26, j19);
                        long j31 = j19 - j30;
                        long j32 = ThreefishEngine.j(39, j24, j21);
                        long j33 = j21 - j32;
                        long j34 = j22;
                        long j35 = j30;
                        long j36 = j25;
                        long j37 = ThreefishEngine.j(43, j34, j36);
                        long j38 = j36 - j37;
                        long j39 = ThreefishEngine.j(13, j28, j38);
                        long j40 = j38 - j39;
                        long j41 = ThreefishEngine.j(50, j37, j29);
                        long j42 = j29 - j41;
                        long j43 = ThreefishEngine.j(10, j32, j31);
                        long j44 = j35;
                        long j45 = j31 - j43;
                        long j46 = j33;
                        long j47 = ThreefishEngine.j(17, j44, j46);
                        long j48 = j46 - j47;
                        long j49 = ThreefishEngine.j(39, j39, j48);
                        long j50 = ThreefishEngine.j(30, j47, j40);
                        long j51 = ThreefishEngine.j(34, j43, j42);
                        long j52 = j42 - j51;
                        long j53 = j51;
                        long j54 = j45;
                        long j55 = ThreefishEngine.j(24, j41, j54);
                        long j56 = (j48 - j49) - jArr5[i3];
                        long j57 = j49 - jArr5[i5];
                        long j58 = (j40 - j50) - jArr5[i6];
                        long j59 = j50 - jArr5[i7];
                        long j60 = j52 - jArr5[i8];
                        long j61 = j59;
                        long j62 = (j54 - j55) - (jArr5[i10] + jArr6[i11]);
                        long j63 = ThreefishEngine.j(44, j57, j62);
                        long j64 = j62 - j63;
                        long j65 = ThreefishEngine.j(9, j55 - (jArr5[i12] + j17), j56);
                        long j66 = j56 - j65;
                        long j67 = ThreefishEngine.j(54, j53 - (jArr5[i9] + jArr6[i4]), j58);
                        long j68 = j58 - j67;
                        long j69 = ThreefishEngine.j(56, j61, j60);
                        long j70 = j60 - j69;
                        long j71 = ThreefishEngine.j(17, j63, j70);
                        long j72 = ThreefishEngine.j(49, j69, j64);
                        long j73 = j64 - j72;
                        long j74 = ThreefishEngine.j(36, j67, j66);
                        long j75 = j66 - j74;
                        long j76 = j68;
                        long j77 = ThreefishEngine.j(39, j65, j76);
                        long j78 = j76 - j77;
                        long j79 = ThreefishEngine.j(33, j71, j78);
                        long j80 = j78 - j79;
                        long j81 = j70 - j71;
                        long j82 = ThreefishEngine.j(27, j77, j81);
                        long j83 = j81 - j82;
                        long j84 = ThreefishEngine.j(14, j74, j73);
                        long j85 = j73 - j84;
                        long j86 = ThreefishEngine.j(42, j72, j75);
                        long j87 = j75 - j86;
                        long j88 = ThreefishEngine.j(46, j79, j87);
                        long j89 = j87 - j88;
                        long j90 = j80;
                        j4 = ThreefishEngine.j(36, j86, j90);
                        j6 = ThreefishEngine.j(19, j84, j83);
                        j8 = ThreefishEngine.j(37, j82, j85);
                        j7 = j85 - j8;
                        i2 = i13 - 2;
                        j3 = j90 - j4;
                        j2 = j88;
                        j = j89;
                        iArr = iArr;
                        jArr4 = jArr6;
                        z = false;
                        i = 1;
                        j5 = j83 - j6;
                        iArr2 = iArr3;
                        jArr3 = jArr5;
                    }
                    long[] jArr7 = jArr3;
                    long[] jArr8 = jArr4;
                    char c = z;
                    long j91 = j - jArr7[c];
                    long j92 = j2 - jArr7[1];
                    long j93 = j3 - jArr7[2];
                    long j94 = j4 - jArr7[3];
                    long j95 = j5 - jArr7[4];
                    long j96 = j7 - (jArr7[6] + jArr8[1]);
                    jArr2[c] = j91;
                    jArr2[1] = j92;
                    jArr2[2] = j93;
                    jArr2[3] = j94;
                    jArr2[4] = j95;
                    jArr2[5] = j6 - (jArr7[5] + jArr8[c]);
                    jArr2[6] = j96;
                    jArr2[7] = j8 - jArr7[7];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public final void b(long[] jArr, long[] jArr2) {
            int[] iArr = ThreefishEngine.a;
            int[] iArr2 = ThreefishEngine.d;
            long[] jArr3 = this.b;
            if (jArr3.length == 17) {
                long[] jArr4 = this.a;
                if (jArr4.length == 5) {
                    long j = jArr[0];
                    int i = 1;
                    long j2 = jArr[1];
                    long j3 = jArr[2];
                    long j4 = jArr[3];
                    long j5 = jArr[4];
                    long j6 = jArr[5];
                    long j7 = jArr[6];
                    long j8 = jArr[7];
                    long j9 = j + jArr3[0];
                    long j10 = j2 + jArr3[1];
                    long j11 = j3 + jArr3[2];
                    long j12 = j4 + jArr3[3];
                    long j13 = j5 + jArr3[4];
                    long j14 = jArr3[5] + jArr4[0] + j6;
                    long j15 = jArr3[6] + jArr4[1] + j7;
                    long j16 = j12;
                    long j17 = j8 + jArr3[7];
                    long j18 = j14;
                    while (i < 18) {
                        int i2 = iArr[i];
                        int i3 = iArr2[i];
                        long j19 = j9 + j10;
                        long h = ThreefishEngine.h(46, j10, j19);
                        long j20 = j11 + j16;
                        long h2 = ThreefishEngine.h(36, j16, j20);
                        long j21 = j18;
                        long j22 = j13 + j21;
                        int[] iArr3 = iArr2;
                        long h3 = ThreefishEngine.h(19, j21, j22);
                        long[] jArr5 = jArr3;
                        long j23 = j17;
                        long j24 = j15 + j23;
                        long h4 = ThreefishEngine.h(37, j23, j24);
                        long j25 = j20 + h;
                        long h5 = ThreefishEngine.h(33, h, j25);
                        long j26 = j22 + h4;
                        long h6 = ThreefishEngine.h(27, h4, j26);
                        long j27 = j24 + h3;
                        long h7 = ThreefishEngine.h(14, h3, j27);
                        long j28 = j19 + h2;
                        long[] jArr6 = jArr4;
                        long j29 = h6;
                        long h8 = ThreefishEngine.h(42, h2, j28);
                        long j30 = j26 + h5;
                        long h9 = ThreefishEngine.h(17, h5, j30);
                        long j31 = j27 + h8;
                        long h10 = ThreefishEngine.h(49, h8, j31);
                        long j32 = j28 + h7;
                        long h11 = ThreefishEngine.h(36, h7, j32);
                        long j33 = j25 + j29;
                        long j34 = j30;
                        long h12 = ThreefishEngine.h(39, j29, j33);
                        long j35 = j31 + h9;
                        long h13 = ThreefishEngine.h(44, h9, j35);
                        long j36 = j32 + h12;
                        long h14 = ThreefishEngine.h(9, h12, j36);
                        long j37 = j33 + h11;
                        long h15 = ThreefishEngine.h(54, h11, j37);
                        long j38 = h14;
                        long j39 = j34 + h10;
                        long h16 = ThreefishEngine.h(56, h10, j39);
                        long j40 = j36 + jArr5[i2];
                        int i4 = i2 + 1;
                        long j41 = h13 + jArr5[i4];
                        int i5 = i2 + 2;
                        long j42 = j37 + jArr5[i5];
                        int i6 = i2 + 3;
                        long j43 = h16 + jArr5[i6];
                        int i7 = i2 + 4;
                        long j44 = j39 + jArr5[i7];
                        int i8 = i2 + 5;
                        long j45 = jArr5[i8] + jArr6[i3] + h15;
                        int i9 = i2 + 6;
                        int i10 = i3 + 1;
                        long j46 = jArr5[i9] + jArr6[i10] + j35;
                        int i11 = i2 + 7;
                        int i12 = i;
                        long j47 = (long) i12;
                        long j48 = j47;
                        long j49 = jArr5[i11] + j47 + j38;
                        long j50 = j40 + j41;
                        int i13 = i12;
                        long h17 = ThreefishEngine.h(39, j41, j50);
                        long j51 = j42 + j43;
                        long h18 = ThreefishEngine.h(30, j43, j51);
                        long j52 = j44 + j45;
                        long h19 = ThreefishEngine.h(34, j45, j52);
                        long j53 = h18;
                        long j54 = j46 + j49;
                        long h20 = ThreefishEngine.h(24, j49, j54);
                        long j55 = j51 + h17;
                        long h21 = ThreefishEngine.h(13, h17, j55);
                        long j56 = j52 + h20;
                        long h22 = ThreefishEngine.h(50, h20, j56);
                        long j57 = j54 + h19;
                        long h23 = ThreefishEngine.h(10, h19, j57);
                        long j58 = j50 + j53;
                        long j59 = h22;
                        long h24 = ThreefishEngine.h(17, j53, j58);
                        long j60 = j56 + h21;
                        long h25 = ThreefishEngine.h(25, h21, j60);
                        long j61 = j57 + h24;
                        long h26 = ThreefishEngine.h(29, h24, j61);
                        long j62 = j58 + h23;
                        long h27 = ThreefishEngine.h(39, h23, j62);
                        long j63 = j55 + j59;
                        long j64 = j60;
                        long h28 = ThreefishEngine.h(43, j59, j63);
                        long j65 = j61 + h25;
                        long h29 = ThreefishEngine.h(8, h25, j65);
                        long j66 = j62 + h28;
                        long h30 = ThreefishEngine.h(35, h28, j66);
                        long j67 = j63 + h27;
                        long h31 = ThreefishEngine.h(56, h27, j67);
                        long j68 = h30;
                        long j69 = j64 + h26;
                        long h32 = ThreefishEngine.h(22, h26, j69);
                        j9 = j66 + jArr5[i4];
                        j10 = h29 + jArr5[i5];
                        j11 = j67 + jArr5[i6];
                        j16 = h32 + jArr5[i7];
                        long j70 = j69 + jArr5[i8];
                        long j71 = jArr5[i9] + jArr6[i10] + h31;
                        j15 = jArr5[i11] + jArr6[i3 + 2] + j65;
                        i = i13 + 2;
                        j13 = j70;
                        iArr = iArr;
                        j18 = j71;
                        jArr4 = jArr6;
                        j17 = jArr5[i2 + 8] + j48 + 1 + j68;
                        iArr2 = iArr3;
                        jArr3 = jArr5;
                    }
                    jArr2[0] = j9;
                    jArr2[1] = j10;
                    jArr2[2] = j11;
                    jArr2[3] = j16;
                    jArr2[4] = j13;
                    jArr2[5] = j18;
                    jArr2[6] = j15;
                    jArr2[7] = j17;
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }

    public static abstract class ThreefishCipher {
        public final long[] a;
        public final long[] b;

        public ThreefishCipher(long[] jArr, long[] jArr2) {
            this.b = jArr;
            this.a = jArr2;
        }

        public abstract void a(long[] jArr, long[] jArr2);

        public abstract void b(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        a = iArr;
        b = new int[iArr.length];
        c = new int[iArr.length];
        d = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = a;
            if (i < iArr2.length) {
                b[i] = i % 17;
                iArr2[i] = i % 9;
                c[i] = i % 5;
                d[i] = i % 3;
                i++;
            } else {
                return;
            }
        }
    }

    public ThreefishEngine(int i) {
        long[] jArr = new long[5];
        this.f6062b = jArr;
        int i2 = i / 8;
        this.f6057a = i2;
        int i3 = i2 / 8;
        this.f6061b = i3;
        this.f6060a = new long[i3];
        long[] jArr2 = new long[((i3 * 2) + 1)];
        this.f6063c = jArr2;
        if (i == 256) {
            this.f6058a = new Threefish256Cipher(jArr2, jArr);
        } else if (i == 512) {
            this.f6058a = new Threefish512Cipher(jArr2, jArr);
        } else if (i == 1024) {
            this.f6058a = new Threefish1024Cipher(jArr2, jArr);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
    }

    public static long d(int i, byte[] bArr) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            return ((((long) bArr[i7 + 1]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 40) | ((((long) bArr[i7]) & 255) << 48);
        }
        throw new IllegalArgumentException();
    }

    public static long h(int i, long j, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    public static void i(long j, byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) j);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) (j >> 8));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (j >> 16));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (j >> 24));
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (j >> 32));
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((int) (j >> 40));
            bArr[i7] = (byte) ((int) (j >> 48));
            bArr[i7 + 1] = (byte) ((int) (j >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }

    public static long j(int i, long j, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        long[] jArr;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            ((TweakableBlockCipherParameters) cipherParameters).getClass();
            throw null;
        } else if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr != null) {
                int length = bArr.length;
                int i = this.f6057a;
                if (length == i) {
                    int i2 = this.f6061b;
                    jArr = new long[i2];
                    for (int i3 = 0; i3 < i2; i3++) {
                        jArr[i3] = d(i3 * 8, bArr);
                    }
                } else {
                    throw new IllegalArgumentException(C1058d.y("Threefish key must be same size as block (", i, " bytes)"));
                }
            } else {
                jArr = null;
            }
            f(z, jArr, (long[]) null);
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "Invalid parameter passed to Threefish init - "));
        }
    }

    public final String b() {
        return "Threefish-" + (this.f6057a * 8);
    }

    public final int c() {
        return this.f6057a;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        long[] jArr;
        int i3 = this.f6057a;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (i2 + i3 <= bArr2.length) {
            int i4 = 0;
            while (true) {
                jArr = this.f6060a;
                if (i4 >= i3) {
                    break;
                }
                jArr[i4 >> 3] = d(i + i4, bArr);
                i4 += 8;
            }
            g(jArr, jArr);
            for (int i5 = 0; i5 < i3; i5 += 8) {
                i(jArr[i5 >> 3], bArr2, i2 + i5);
            }
            return i3;
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public final void f(boolean z, long[] jArr, long[] jArr2) {
        long[] jArr3;
        this.f6059a = z;
        if (jArr != null) {
            int length = jArr.length;
            int i = this.f6061b;
            if (length == i) {
                long j = 2004413935125273122L;
                int i2 = 0;
                while (true) {
                    jArr3 = this.f6063c;
                    if (i2 >= i) {
                        break;
                    }
                    long j2 = jArr[i2];
                    jArr3[i2] = j2;
                    j ^= j2;
                    i2++;
                }
                jArr3[i] = j;
                System.arraycopy(jArr3, 0, jArr3, i + 1, i);
            } else {
                throw new IllegalArgumentException(C1058d.y("Threefish key must be same size as block (", i, " words)"));
            }
        }
        if (jArr2 == null) {
            return;
        }
        if (jArr2.length == 2) {
            long j3 = jArr2[0];
            long[] jArr4 = this.f6062b;
            jArr4[0] = j3;
            long j4 = jArr2[1];
            jArr4[1] = j4;
            jArr4[2] = j3 ^ j4;
            jArr4[3] = j3;
            jArr4[4] = j4;
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    public final void g(long[] jArr, long[] jArr2) throws DataLengthException, IllegalStateException {
        long[] jArr3 = this.f6063c;
        int i = this.f6061b;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == i) {
            boolean z = this.f6059a;
            ThreefishCipher threefishCipher = this.f6058a;
            if (z) {
                threefishCipher.b(jArr, jArr2);
            } else {
                threefishCipher.a(jArr, jArr2);
            }
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public final void reset() {
    }
}
