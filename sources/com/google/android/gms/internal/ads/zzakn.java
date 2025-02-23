package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.google.firebase.perf.util.Constants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzakn implements zzaka {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf = new Canvas();
    private final zzakg zzg = new zzakg(719, 575, 0, 719, 0, 575);
    private final zzakf zzh = new zzakf(0, zzh(), zzi(), zzj());
    private final zzakm zzi;
    private Bitmap zzj;

    public zzakn(List list) {
        zzek zzek = new zzek((byte[]) list.get(0));
        int zzq = zzek.zzq();
        int zzq2 = zzek.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.zzi = new zzakm(zzq, zzq2);
    }

    private static int zzc(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakf zzd(zzej zzej, int i) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        zzej zzej2 = zzej;
        int i6 = 8;
        int zzd2 = zzej2.zzd(8);
        zzej2.zzn(8);
        int[] zzh2 = zzh();
        int[] zzi2 = zzi();
        int[] zzj2 = zzj();
        int i7 = i - 2;
        while (i7 > 0) {
            int zzd3 = zzej2.zzd(i6);
            int zzd4 = zzej2.zzd(i6);
            int i8 = i7 - 2;
            if ((zzd4 & 128) != 0) {
                iArr = zzh2;
            } else if ((zzd4 & 64) != 0) {
                iArr = zzi2;
            } else {
                iArr = zzj2;
            }
            if ((zzd4 & 1) != 0) {
                i5 = zzej2.zzd(i6);
                i4 = zzej2.zzd(i6);
                i3 = zzej2.zzd(i6);
                i2 = zzej2.zzd(i6);
                i7 = i8 - 4;
            } else {
                int zzd5 = zzej2.zzd(2) << 6;
                i7 = i8 - 2;
                i3 = zzej2.zzd(4) << 4;
                i2 = zzd5;
                i5 = zzej2.zzd(6) << 2;
                i4 = zzej2.zzd(4) << 4;
            }
            if (i5 == 0) {
                i2 = 255;
            }
            if (i5 == 0) {
                i3 = 0;
            }
            if (i5 == 0) {
                i4 = 0;
            }
            double d = (double) i5;
            double d2 = (double) (i4 - 128);
            double d3 = (double) (i3 - 128);
            iArr[zzd3] = zzc((byte) (255 - (i2 & Constants.MAX_HOST_LENGTH)), Math.max(0, Math.min((int) ((1.402d * d2) + d), Constants.MAX_HOST_LENGTH)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), Constants.MAX_HOST_LENGTH)), Math.max(0, Math.min((int) ((d3 * 1.772d) + d), Constants.MAX_HOST_LENGTH)));
            zzd2 = zzd2;
            i6 = 8;
        }
        return new zzakf(zzd2, zzh2, zzi2, zzj2);
    }

    private static zzakh zze(zzej zzej) {
        byte[] bArr;
        int zzd2 = zzej.zzd(16);
        zzej.zzn(4);
        int zzd3 = zzej.zzd(2);
        boolean zzp = zzej.zzp();
        zzej.zzn(1);
        byte[] bArr2 = zzet.zzf;
        if (zzd3 == 1) {
            zzej.zzn(zzej.zzd(8) * 16);
        } else if (zzd3 == 0) {
            int zzd4 = zzej.zzd(16);
            int zzd5 = zzej.zzd(16);
            if (zzd4 > 0) {
                bArr2 = new byte[zzd4];
                zzej.zzi(bArr2, 0, zzd4);
            }
            if (zzd5 > 0) {
                bArr = new byte[zzd5];
                zzej.zzi(bArr, 0, zzd5);
                return new zzakh(zzd2, zzp, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new zzakh(zzd2, zzp, bArr2, bArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v12, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v16, types: [byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0228 A[LOOP:3: B:85:0x0172->B:116:0x0228, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0222 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzf(byte[] r24, int[] r25, int r26, int r27, int r28, android.graphics.Paint r29, android.graphics.Canvas r30) {
        /*
            r0 = r24
            r1 = r26
            r8 = r29
            com.google.android.gms.internal.ads.zzej r9 = new com.google.android.gms.internal.ads.zzej
            int r2 = r0.length
            r9.<init>(r0, r2)
            r2 = r27
            r10 = r28
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0013:
            int r3 = r9.zza()
            if (r3 == 0) goto L_0x0233
            r14 = 8
            int r3 = r9.zzd(r14)
            r4 = 240(0xf0, float:3.36E-43)
            if (r3 == r4) goto L_0x022d
            r15 = 3
            r7 = 4
            r6 = 1
            r5 = 2
            r16 = 0
            switch(r3) {
                case 16: goto L_0x0155;
                case 17: goto L_0x009e;
                case 18: goto L_0x0041;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r3) {
                case 32: goto L_0x003c;
                case 33: goto L_0x0037;
                case 34: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0013
        L_0x0030:
            r3 = 16
            byte[] r12 = zzg(r3, r14, r9)
            goto L_0x0013
        L_0x0037:
            byte[] r11 = zzg(r7, r14, r9)
            goto L_0x0013
        L_0x003c:
            byte[] r13 = zzg(r7, r7, r9)
            goto L_0x0013
        L_0x0041:
            r15 = r2
            r2 = r16
        L_0x0044:
            int r3 = r9.zzd(r14)
            if (r3 == 0) goto L_0x004f
            r17 = r2
            r18 = r6
            goto L_0x0077
        L_0x004f:
            boolean r3 = r9.zzp()
            r4 = 7
            if (r3 != 0) goto L_0x006a
            int r3 = r9.zzd(r4)
            if (r3 == 0) goto L_0x0063
            r17 = r2
            r18 = r3
            r3 = r16
            goto L_0x0077
        L_0x0063:
            r17 = r6
            r3 = r16
            r18 = r3
            goto L_0x0077
        L_0x006a:
            int r3 = r9.zzd(r4)
            int r4 = r9.zzd(r14)
            r17 = r2
            r18 = r3
            r3 = r4
        L_0x0077:
            if (r18 == 0) goto L_0x0092
            if (r8 == 0) goto L_0x0092
            int r2 = r10 + 1
            float r4 = (float) r10
            r3 = r25[r3]
            r8.setColor(r3)
            float r3 = (float) r15
            int r5 = r15 + r18
            float r5 = (float) r5
            float r7 = (float) r2
            r2 = r30
            r0 = r6
            r6 = r7
            r7 = r29
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x0093
        L_0x0092:
            r0 = r6
        L_0x0093:
            int r15 = r15 + r18
            if (r17 != 0) goto L_0x009b
            r6 = r0
            r2 = r17
            goto L_0x0044
        L_0x009b:
            r2 = r15
            goto L_0x0013
        L_0x009e:
            r0 = r6
            if (r1 != r15) goto L_0x00ab
            if (r12 != 0) goto L_0x00a8
            byte[] r3 = zzc
            r17 = r3
            goto L_0x00ad
        L_0x00a8:
            r17 = r12
            goto L_0x00ad
        L_0x00ab:
            r17 = 0
        L_0x00ad:
            r6 = r2
            r2 = r16
        L_0x00b0:
            int r3 = r9.zzd(r7)
            if (r3 == 0) goto L_0x00bc
            r19 = r0
            r18 = r2
            goto L_0x011c
        L_0x00bc:
            boolean r3 = r9.zzp()
            if (r3 != 0) goto L_0x00d8
            int r3 = r9.zzd(r15)
            if (r3 == 0) goto L_0x00d1
            int r3 = r3 + 2
            r18 = r2
            r19 = r3
        L_0x00ce:
            r3 = r16
            goto L_0x011c
        L_0x00d1:
            r18 = r0
        L_0x00d3:
            r3 = r16
            r19 = r3
            goto L_0x011c
        L_0x00d8:
            boolean r3 = r9.zzp()
            if (r3 != 0) goto L_0x00ed
            int r3 = r9.zzd(r5)
            int r3 = r3 + r7
            int r4 = r9.zzd(r7)
        L_0x00e7:
            r18 = r2
            r19 = r3
            r3 = r4
            goto L_0x011c
        L_0x00ed:
            int r3 = r9.zzd(r5)
            if (r3 == 0) goto L_0x0117
            if (r3 == r0) goto L_0x0112
            if (r3 == r5) goto L_0x0107
            if (r3 == r15) goto L_0x00fc
            r18 = r2
            goto L_0x00d3
        L_0x00fc:
            int r3 = r9.zzd(r14)
            int r3 = r3 + 25
            int r4 = r9.zzd(r7)
            goto L_0x00e7
        L_0x0107:
            int r3 = r9.zzd(r7)
            int r3 = r3 + 9
            int r4 = r9.zzd(r7)
            goto L_0x00e7
        L_0x0112:
            r18 = r2
            r19 = r5
            goto L_0x00ce
        L_0x0117:
            r19 = r0
            r18 = r2
            goto L_0x00ce
        L_0x011c:
            if (r19 == 0) goto L_0x0140
            if (r8 == 0) goto L_0x0140
            int r2 = r10 + 1
            float r4 = (float) r10
            if (r17 == 0) goto L_0x0127
            byte r3 = r17[r3]
        L_0x0127:
            float r2 = (float) r2
            r3 = r25[r3]
            r8.setColor(r3)
            float r3 = (float) r6
            int r5 = r6 + r19
            float r5 = (float) r5
            r20 = r2
            r2 = r30
            r14 = 2
            r22 = r6
            r6 = r20
            r7 = r29
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x0143
        L_0x0140:
            r14 = r5
            r22 = r6
        L_0x0143:
            int r6 = r22 + r19
            if (r18 == 0) goto L_0x014d
            r9.zzf()
            r2 = r6
            goto L_0x0013
        L_0x014d:
            r5 = r14
            r2 = r18
            r7 = 4
            r14 = 8
            goto L_0x00b0
        L_0x0155:
            r14 = r5
            r0 = r6
            if (r1 != r15) goto L_0x0163
            if (r11 != 0) goto L_0x0160
            byte[] r3 = zzb
        L_0x015d:
            r17 = r3
            goto L_0x016f
        L_0x0160:
            r17 = r11
            goto L_0x016f
        L_0x0163:
            if (r1 != r14) goto L_0x016d
            if (r13 != 0) goto L_0x016a
            byte[] r3 = zza
            goto L_0x015d
        L_0x016a:
            r17 = r13
            goto L_0x016f
        L_0x016d:
            r17 = 0
        L_0x016f:
            r7 = r2
            r6 = r16
        L_0x0172:
            int r2 = r9.zzd(r14)
            if (r2 == 0) goto L_0x0181
            r18 = r0
        L_0x017a:
            r19 = r6
        L_0x017c:
            r4 = 4
            r5 = 8
            goto L_0x01ed
        L_0x0181:
            boolean r2 = r9.zzp()
            if (r2 == 0) goto L_0x0194
            int r2 = r9.zzd(r15)
            int r2 = r2 + r15
            int r3 = r9.zzd(r14)
            r18 = r2
            r2 = r3
            goto L_0x017a
        L_0x0194:
            boolean r2 = r9.zzp()
            if (r2 == 0) goto L_0x01a1
            r18 = r0
            r19 = r6
            r2 = r16
            goto L_0x017c
        L_0x01a1:
            int r2 = r9.zzd(r14)
            if (r2 == 0) goto L_0x01e4
            if (r2 == r0) goto L_0x01da
            if (r2 == r14) goto L_0x01c7
            if (r2 == r15) goto L_0x01b4
            r19 = r6
            r2 = r16
            r18 = r2
            goto L_0x017c
        L_0x01b4:
            r5 = 8
            int r2 = r9.zzd(r5)
            int r2 = r2 + 29
            int r3 = r9.zzd(r14)
            r18 = r2
            r2 = r3
            r19 = r6
            r4 = 4
            goto L_0x01ed
        L_0x01c7:
            r4 = 4
            r5 = 8
            int r2 = r9.zzd(r4)
            int r2 = r2 + 12
            int r3 = r9.zzd(r14)
            r18 = r2
            r2 = r3
            r19 = r6
            goto L_0x01ed
        L_0x01da:
            r4 = 4
            r5 = 8
            r19 = r6
            r18 = r14
            r2 = r16
            goto L_0x01ed
        L_0x01e4:
            r4 = 4
            r5 = 8
            r19 = r0
            r2 = r16
            r18 = r2
        L_0x01ed:
            if (r18 == 0) goto L_0x0219
            if (r8 == 0) goto L_0x0219
            int r3 = r10 + 1
            float r6 = (float) r10
            if (r17 == 0) goto L_0x01f8
            byte r2 = r17[r2]
        L_0x01f8:
            float r3 = (float) r3
            r2 = r25[r2]
            r8.setColor(r2)
            float r2 = (float) r7
            int r0 = r7 + r18
            float r0 = (float) r0
            r21 = r2
            r2 = r30
            r22 = r3
            r3 = r21
            r21 = r4
            r4 = r6
            r23 = r5
            r5 = r0
            r6 = r22
            r0 = r7
            r7 = r29
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x021e
        L_0x0219:
            r21 = r4
            r23 = r5
            r0 = r7
        L_0x021e:
            int r7 = r0 + r18
            if (r19 == 0) goto L_0x0228
            r9.zzf()
            r2 = r7
            goto L_0x0013
        L_0x0228:
            r6 = r19
            r0 = 1
            goto L_0x0172
        L_0x022d:
            int r10 = r10 + 2
            r2 = r27
            goto L_0x0013
        L_0x0233:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.zzf(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzg(int i, int i2, zzej zzej) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzej.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzh() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zzi() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i6 = 1; i6 < 16; i6++) {
            int i7 = i6 & 4;
            int i8 = i6 & 2;
            int i9 = i6 & 1;
            if (i6 < 8) {
                if (1 != i9) {
                    i3 = 0;
                } else {
                    i3 = 255;
                }
                if (i8 != 0) {
                    i4 = 255;
                } else {
                    i4 = 0;
                }
                if (i7 != 0) {
                    i5 = 255;
                } else {
                    i5 = 0;
                }
                iArr[i6] = zzc(Constants.MAX_HOST_LENGTH, i3, i4, i5);
            } else {
                int i10 = 127;
                if (1 != i9) {
                    i = 0;
                } else {
                    i = 127;
                }
                if (i8 != 0) {
                    i2 = 127;
                } else {
                    i2 = 0;
                }
                if (i7 == 0) {
                    i10 = 0;
                }
                iArr[i6] = zzc(Constants.MAX_HOST_LENGTH, i, i2, i10);
            }
        }
        return iArr;
    }

    private static int[] zzj() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i19 = 0; i19 < 256; i19++) {
            int i20 = Constants.MAX_HOST_LENGTH;
            if (i19 < 8) {
                int i21 = i19 & 2;
                int i22 = i19 & 4;
                if (1 != (i19 & 1)) {
                    i17 = 0;
                } else {
                    i17 = 255;
                }
                if (i21 != 0) {
                    i18 = 255;
                } else {
                    i18 = 0;
                }
                if (i22 == 0) {
                    i20 = 0;
                }
                iArr[i19] = zzc(63, i17, i18, i20);
            } else {
                int i23 = i19 & 136;
                int i24 = 170;
                int i25 = 85;
                if (i23 == 0) {
                    int i26 = i19 & 16;
                    int i27 = i19 & 32;
                    int i28 = i19 & 2;
                    int i29 = i19 & 64;
                    int i30 = i19 & 4;
                    if (1 != (i19 & 1)) {
                        i = 0;
                    } else {
                        i = 85;
                    }
                    if (i26 != 0) {
                        i2 = 170;
                    } else {
                        i2 = 0;
                    }
                    if (i28 != 0) {
                        i3 = 85;
                    } else {
                        i3 = 0;
                    }
                    if (i27 != 0) {
                        i4 = 170;
                    } else {
                        i4 = 0;
                    }
                    if (i30 == 0) {
                        i25 = 0;
                    }
                    if (i29 == 0) {
                        i24 = 0;
                    }
                    iArr[i19] = zzc(Constants.MAX_HOST_LENGTH, i + i2, i3 + i4, i25 + i24);
                } else if (i23 != 8) {
                    int i31 = 43;
                    if (i23 == 128) {
                        int i32 = i19 & 16;
                        int i33 = i19 & 32;
                        int i34 = i19 & 2;
                        int i35 = i19 & 64;
                        int i36 = i19 & 4;
                        if (1 != (i19 & 1)) {
                            i9 = 0;
                        } else {
                            i9 = 43;
                        }
                        int i37 = i9 + 127;
                        if (i32 != 0) {
                            i10 = 85;
                        } else {
                            i10 = 0;
                        }
                        if (i34 != 0) {
                            i11 = 43;
                        } else {
                            i11 = 0;
                        }
                        int i38 = i11 + 127;
                        if (i33 != 0) {
                            i12 = 85;
                        } else {
                            i12 = 0;
                        }
                        if (i36 == 0) {
                            i31 = 0;
                        }
                        int i39 = i31 + 127;
                        if (i35 == 0) {
                            i25 = 0;
                        }
                        iArr[i19] = zzc(Constants.MAX_HOST_LENGTH, i37 + i10, i38 + i12, i39 + i25);
                    } else if (i23 == 136) {
                        int i40 = i19 & 16;
                        int i41 = i19 & 32;
                        int i42 = i19 & 2;
                        int i43 = i19 & 64;
                        int i44 = i19 & 4;
                        if (1 != (i19 & 1)) {
                            i13 = 0;
                        } else {
                            i13 = 43;
                        }
                        if (i40 != 0) {
                            i14 = 85;
                        } else {
                            i14 = 0;
                        }
                        if (i42 != 0) {
                            i15 = 43;
                        } else {
                            i15 = 0;
                        }
                        if (i41 != 0) {
                            i16 = 85;
                        } else {
                            i16 = 0;
                        }
                        if (i44 == 0) {
                            i31 = 0;
                        }
                        if (i43 == 0) {
                            i25 = 0;
                        }
                        iArr[i19] = zzc(Constants.MAX_HOST_LENGTH, i13 + i14, i15 + i16, i31 + i25);
                    }
                } else {
                    int i45 = i19 & 16;
                    int i46 = i19 & 32;
                    int i47 = i19 & 2;
                    int i48 = i19 & 64;
                    int i49 = i19 & 4;
                    if (1 != (i19 & 1)) {
                        i5 = 0;
                    } else {
                        i5 = 85;
                    }
                    if (i45 != 0) {
                        i6 = 170;
                    } else {
                        i6 = 0;
                    }
                    if (i47 != 0) {
                        i7 = 85;
                    } else {
                        i7 = 0;
                    }
                    if (i46 != 0) {
                        i8 = 170;
                    } else {
                        i8 = 0;
                    }
                    if (i49 == 0) {
                        i25 = 0;
                    }
                    if (i48 == 0) {
                        i24 = 0;
                    }
                    iArr[i19] = zzc(127, i5 + i6, i7 + i8, i25 + i24);
                }
            }
        }
        return iArr;
    }

    public final void zza(byte[] bArr, int i, int i2, zzajz zzajz, zzdn zzdn) {
        zzajs zzajs;
        char c;
        char c2;
        int i3;
        int i4;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        Paint paint;
        int[] iArr;
        zzakk zzakk;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i;
        zzej zzej = new zzej(bArr, i12 + i2);
        zzej.zzl(i12);
        while (zzej.zza() >= 48 && zzej.zzd(8) == 15) {
            zzakm zzakm = this.zzi;
            int zzd2 = zzej.zzd(8);
            int zzd3 = zzej.zzd(16);
            int zzd4 = zzej.zzd(16);
            int zzb2 = zzej.zzb() + zzd4;
            if (zzd4 * 8 > zzej.zza()) {
                zzea.zzf("DvbParser", "Data field length exceeds limit");
                zzej.zzn(zzej.zza());
            } else {
                switch (zzd2) {
                    case 16:
                        if (zzd3 == zzakm.zza) {
                            zzaki zzaki = zzakm.zzi;
                            int zzd5 = zzej.zzd(8);
                            int zzd6 = zzej.zzd(4);
                            int zzd7 = zzej.zzd(2);
                            zzej.zzn(2);
                            SparseArray sparseArray3 = new SparseArray();
                            for (int i13 = zzd4 - 2; i13 > 0; i13 -= 6) {
                                int zzd8 = zzej.zzd(8);
                                zzej.zzn(8);
                                sparseArray3.put(zzd8, new zzakj(zzej.zzd(16), zzej.zzd(16)));
                            }
                            zzaki zzaki2 = new zzaki(zzd5, zzd6, zzd7, sparseArray3);
                            if (zzaki2.zzb == 0) {
                                if (!(zzaki == null || zzaki.zza == zzaki2.zza)) {
                                    zzakm.zzi = zzaki2;
                                    break;
                                }
                            } else {
                                zzakm.zzi = zzaki2;
                                zzakm.zzc.clear();
                                zzakm.zzd.clear();
                                zzakm.zze.clear();
                                break;
                            }
                        }
                        break;
                    case 17:
                        zzaki zzaki3 = zzakm.zzi;
                        if (zzd3 == zzakm.zza && zzaki3 != null) {
                            int zzd9 = zzej.zzd(8);
                            zzej.zzn(4);
                            boolean zzp = zzej.zzp();
                            zzej.zzn(3);
                            int zzd10 = zzej.zzd(16);
                            int zzd11 = zzej.zzd(16);
                            int zzd12 = zzej.zzd(3);
                            int zzd13 = zzej.zzd(3);
                            zzej.zzn(2);
                            int zzd14 = zzej.zzd(8);
                            int zzd15 = zzej.zzd(8);
                            int zzd16 = zzej.zzd(4);
                            int zzd17 = zzej.zzd(2);
                            zzej.zzn(2);
                            int i14 = zzd4 - 10;
                            SparseArray sparseArray4 = new SparseArray();
                            while (i14 > 0) {
                                int zzd18 = zzej.zzd(16);
                                int zzd19 = zzej.zzd(2);
                                int zzd20 = zzej.zzd(2);
                                int zzd21 = zzej.zzd(12);
                                zzej.zzn(4);
                                int zzd22 = zzej.zzd(12);
                                i14 -= 6;
                                if (zzd19 != 1) {
                                    if (zzd19 == 2) {
                                        zzd19 = 2;
                                    } else {
                                        i7 = zzd19;
                                        i6 = 0;
                                        i5 = 0;
                                        sparseArray4.put(zzd18, new zzakl(i7, zzd20, zzd21, zzd22, i6, i5));
                                    }
                                }
                                i14 -= 2;
                                i7 = zzd19;
                                i6 = zzej.zzd(8);
                                i5 = zzej.zzd(8);
                                sparseArray4.put(zzd18, new zzakl(i7, zzd20, zzd21, zzd22, i6, i5));
                            }
                            zzakk zzakk2 = new zzakk(zzd9, zzp, zzd10, zzd11, zzd12, zzd13, zzd14, zzd15, zzd16, zzd17, sparseArray4);
                            if (zzaki3.zzb == 0 && (zzakk = (zzakk) zzakm.zzc.get(zzakk2.zza)) != null) {
                                int i15 = 0;
                                while (true) {
                                    SparseArray sparseArray5 = zzakk.zzj;
                                    if (i15 < sparseArray5.size()) {
                                        zzakk2.zzj.put(sparseArray5.keyAt(i15), (zzakl) sparseArray5.valueAt(i15));
                                        i15++;
                                    }
                                }
                            }
                            zzakm.zzc.put(zzakk2.zza, zzakk2);
                            break;
                        }
                    case 18:
                        if (zzd3 != zzakm.zza) {
                            if (zzd3 == zzakm.zzb) {
                                zzakf zzd23 = zzd(zzej, zzd4);
                                zzakm.zzf.put(zzd23.zza, zzd23);
                                break;
                            }
                        } else {
                            zzakf zzd24 = zzd(zzej, zzd4);
                            zzakm.zzd.put(zzd24.zza, zzd24);
                            break;
                        }
                        break;
                    case 19:
                        if (zzd3 != zzakm.zza) {
                            if (zzd3 == zzakm.zzb) {
                                zzakh zze2 = zze(zzej);
                                zzakm.zzg.put(zze2.zza, zze2);
                                break;
                            }
                        } else {
                            zzakh zze3 = zze(zzej);
                            zzakm.zze.put(zze3.zza, zze3);
                            break;
                        }
                        break;
                    case 20:
                        if (zzd3 == zzakm.zza) {
                            zzej.zzn(4);
                            boolean zzp2 = zzej.zzp();
                            zzej.zzn(3);
                            int zzd25 = zzej.zzd(16);
                            int zzd26 = zzej.zzd(16);
                            if (zzp2) {
                                int zzd27 = zzej.zzd(16);
                                i10 = zzej.zzd(16);
                                i9 = zzej.zzd(16);
                                i8 = zzej.zzd(16);
                                i11 = zzd27;
                            } else {
                                i10 = zzd25;
                                i8 = zzd26;
                                i11 = 0;
                                i9 = 0;
                            }
                            zzakm.zzh = new zzakg(zzd25, zzd26, i11, i10, i9, i8);
                            break;
                        }
                        break;
                }
                zzej.zzo(zzb2 - zzej.zzb());
            }
        }
        zzakm zzakm2 = this.zzi;
        zzaki zzaki4 = zzakm2.zzi;
        if (zzaki4 == null) {
            zzajs = new zzajs(zzfxr.zzm(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakg zzakg = zzakm2.zzh;
            if (zzakg == null) {
                zzakg = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (!(bitmap != null && zzakg.zza + 1 == bitmap.getWidth() && zzakg.zzb + 1 == this.zzj.getHeight())) {
                Bitmap createBitmap = Bitmap.createBitmap(zzakg.zza + 1, zzakg.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = createBitmap;
                this.zzf.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray6 = zzaki4.zzc;
            int i16 = 0;
            while (i16 < sparseArray6.size()) {
                this.zzf.save();
                zzakj zzakj = (zzakj) sparseArray6.valueAt(i16);
                zzakk zzakk3 = (zzakk) this.zzi.zzc.get(sparseArray6.keyAt(i16));
                int i17 = zzakj.zza + zzakg.zzc;
                int i18 = zzakj.zzb + zzakg.zze;
                this.zzf.clipRect(i17, i18, Math.min(zzakk3.zzc + i17, zzakg.zzd), Math.min(zzakk3.zzd + i18, zzakg.zzf));
                zzakf zzakf = (zzakf) this.zzi.zzd.get(zzakk3.zzf);
                if (zzakf == null) {
                    zzakf = (zzakf) this.zzi.zzf.get(zzakk3.zzf);
                    if (zzakf == null) {
                        zzakf = this.zzh;
                    }
                }
                SparseArray sparseArray7 = zzakk3.zzj;
                int i19 = 0;
                while (i19 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i19);
                    zzakl zzakl = (zzakl) sparseArray7.valueAt(i19);
                    zzakh zzakh = (zzakh) this.zzi.zze.get(keyAt);
                    if (zzakh == null) {
                        zzakh = (zzakh) this.zzi.zzg.get(keyAt);
                    }
                    if (zzakh != null) {
                        if (zzakh.zzb) {
                            paint = null;
                        } else {
                            paint = this.zzd;
                        }
                        int i20 = zzakk3.zze;
                        int i21 = zzakl.zza + i17;
                        int i22 = zzakl.zzb + i18;
                        sparseArray2 = sparseArray6;
                        Canvas canvas = this.zzf;
                        sparseArray = sparseArray7;
                        if (i20 == 3) {
                            iArr = zzakf.zzd;
                        } else if (i20 == 2) {
                            iArr = zzakf.zzc;
                        } else {
                            iArr = zzakf.zzb;
                        }
                        i4 = i16;
                        int[] iArr2 = iArr;
                        int i23 = i20;
                        int i24 = i21;
                        Paint paint2 = paint;
                        Canvas canvas2 = canvas;
                        zzf(zzakh.zzc, iArr2, i23, i24, i22, paint2, canvas2);
                        zzf(zzakh.zzd, iArr2, i23, i24, i22 + 1, paint2, canvas2);
                    } else {
                        sparseArray2 = sparseArray6;
                        i4 = i16;
                        sparseArray = sparseArray7;
                    }
                    i19++;
                    sparseArray6 = sparseArray2;
                    sparseArray7 = sparseArray;
                    i16 = i4;
                }
                SparseArray sparseArray8 = sparseArray6;
                int i25 = i16;
                float f = (float) i18;
                float f2 = (float) i17;
                if (zzakk3.zzb) {
                    int i26 = zzakk3.zze;
                    c2 = 3;
                    if (i26 == 3) {
                        i3 = zzakf.zzd[zzakk3.zzg];
                        c = 2;
                    } else {
                        c = 2;
                        if (i26 == 2) {
                            i3 = zzakf.zzc[zzakk3.zzh];
                        } else {
                            i3 = zzakf.zzb[zzakk3.zzi];
                        }
                    }
                    this.zze.setColor(i3);
                    this.zzf.drawRect(f2, f, (float) (zzakk3.zzc + i17), (float) (zzakk3.zzd + i18), this.zze);
                } else {
                    c2 = 3;
                    c = 2;
                }
                zzcz zzcz = new zzcz();
                zzcz.zzc(Bitmap.createBitmap(this.zzj, i17, i18, zzakk3.zzc, zzakk3.zzd));
                zzcz.zzh(f2 / ((float) zzakg.zza));
                zzcz.zzi(0);
                zzcz.zze(f / ((float) zzakg.zzb), 0);
                zzcz.zzf(0);
                zzcz.zzk(((float) zzakk3.zzc) / ((float) zzakg.zza));
                zzcz.zzd(((float) zzakk3.zzd) / ((float) zzakg.zzb));
                arrayList.add(zzcz.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i16 = i25 + 1;
                char c3 = c2;
                char c4 = c;
                sparseArray6 = sparseArray8;
            }
            zzajs = new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdn.zza(zzajs);
    }

    public final void zzb() {
        zzakm zzakm = this.zzi;
        zzakm.zzc.clear();
        zzakm.zzd.clear();
        zzakm.zze.clear();
        zzakm.zzf.clear();
        zzakm.zzg.clear();
        zzakm.zzh = null;
        zzakm.zzi = null;
    }
}
