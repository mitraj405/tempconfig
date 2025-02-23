package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzalg implements zzaka {
    private final zzek zza = new zzek();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzalg(List list) {
        String str = "sans-serif";
        boolean z = false;
        if (list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.zzc = bArr[24];
            this.zzd = ((bArr[26] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[27] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[28] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[29] & UnsignedBytes.MAX_VALUE);
            this.zze = true == "Serif".equals(zzet.zzB(bArr, 43, bArr.length + -43)) ? "serif" : str;
            int i = bArr[25] * Ascii.DC4;
            this.zzg = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.zzb = z;
            if (z) {
                this.zzf = Math.max(0.0f, Math.min(((float) ((bArr[11] & UnsignedBytes.MAX_VALUE) | ((bArr[10] & UnsignedBytes.MAX_VALUE) << 8))) / ((float) i), 0.95f));
            } else {
                this.zzf = 0.85f;
            }
        } else {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = str;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & Constants.MAX_HOST_LENGTH) << 24)), i3, i4, i5 | 33);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzd(android.text.SpannableStringBuilder r4, int r5, int r6, int r7, int r8, int r9) {
        /*
            if (r5 == r6) goto L_0x0047
            r6 = r9 | 33
            r9 = r5 & 1
            r0 = r5 & 2
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0018
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r3 = 3
            r0.<init>(r3)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002e
        L_0x0018:
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r0.<init>(r2)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002d
        L_0x0021:
            if (r0 == 0) goto L_0x002d
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r3 = 2
            r0.<init>(r3)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            r5 = r5 & 4
            if (r5 != 0) goto L_0x003f
            if (r9 != 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            android.text.style.StyleSpan r5 = new android.text.style.StyleSpan
            r5.<init>(r1)
            r4.setSpan(r5, r7, r8, r6)
            return
        L_0x003f:
            android.text.style.UnderlineSpan r5 = new android.text.style.UnderlineSpan
            r5.<init>()
            r4.setSpan(r5, r7, r8, r6)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalg.zzd(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    public final void zza(byte[] bArr, int i, int i2, zzajz zzajz, zzdn zzdn) {
        boolean z;
        String str;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = i;
        zzdn zzdn2 = zzdn;
        this.zza.zzI(bArr, i6 + i2);
        this.zza.zzK(i6);
        zzek zzek = this.zza;
        boolean z5 = true;
        boolean z6 = false;
        int i7 = 2;
        if (zzek.zzb() >= 2) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        int zzq = zzek.zzq();
        if (zzq == 0) {
            str = "";
        } else {
            int zzd2 = zzek.zzd();
            Charset zzB = zzek.zzB();
            int zzd3 = zzek.zzd() - zzd2;
            if (zzB == null) {
                zzB = zzfuj.zzc;
            }
            str = zzek.zzA(zzq - zzd3, zzB);
        }
        if (str.isEmpty()) {
            zzdn2.zza(new zzajs(zzfxr.zzm(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        zzd(spannableStringBuilder2, this.zzc, 0, 0, spannableStringBuilder.length(), 16711680);
        zzc(spannableStringBuilder2, this.zzd, -1, 0, spannableStringBuilder.length(), 16711680);
        String str2 = this.zze;
        int length = spannableStringBuilder.length();
        if (str2 != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length, 16711713);
        }
        float f = this.zzf;
        while (true) {
            zzek zzek2 = this.zza;
            if (zzek2.zzb() >= 8) {
                int zzd4 = zzek2.zzd();
                int zzg2 = zzek2.zzg();
                int zzg3 = this.zza.zzg();
                if (zzg3 == 1937013100) {
                    if (this.zza.zzb() >= i7) {
                        z3 = z5;
                    } else {
                        z3 = z6;
                    }
                    zzdi.zzd(z3);
                    int zzq2 = this.zza.zzq();
                    int i8 = z6;
                    while (i8 < zzq2) {
                        zzek zzek3 = this.zza;
                        if (zzek3.zzb() >= 12) {
                            z4 = z5;
                        } else {
                            z4 = z6;
                        }
                        zzdi.zzd(z4);
                        int zzq3 = zzek3.zzq();
                        int zzq4 = zzek3.zzq();
                        zzek3.zzL(i7);
                        int zzm = zzek3.zzm();
                        zzek3.zzL(z5 ? 1 : 0);
                        int zzg4 = zzek3.zzg();
                        if (zzq4 > spannableStringBuilder.length()) {
                            i4 = zzq2;
                            zzea.zzf("Tx3gParser", "Truncating styl end (" + zzq4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                            i5 = spannableStringBuilder.length();
                        } else {
                            i4 = zzq2;
                            i5 = zzq4;
                        }
                        if (zzq3 >= i5) {
                            zzea.zzf("Tx3gParser", "Ignoring styl with start (" + zzq3 + ") >= end (" + i5 + ").");
                        } else {
                            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                            int i9 = zzq3;
                            int i10 = i5;
                            zzd(spannableStringBuilder3, zzm, this.zzc, i9, i10, 0);
                            zzc(spannableStringBuilder3, zzg4, this.zzd, i9, i10, 0);
                        }
                        i8++;
                        zzq2 = i4;
                        z5 = true;
                        z6 = false;
                        i7 = 2;
                    }
                    i3 = i7;
                } else if (zzg3 != 1952608120 || !this.zzb) {
                    i3 = 2;
                } else {
                    i3 = 2;
                    if (this.zza.zzb() >= 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzdi.zzd(z2);
                    f = Math.max(0.0f, Math.min(((float) this.zza.zzq()) / ((float) this.zzg), 0.95f));
                }
                this.zza.zzK(zzd4 + zzg2);
                i7 = i3;
                z5 = true;
                z6 = false;
            } else {
                zzcz zzcz = new zzcz();
                zzcz.zzl(spannableStringBuilder);
                zzcz.zze(f, 0);
                zzcz.zzf(0);
                zzdn2.zza(new zzajs(zzfxr.zzn(zzcz.zzp()), -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }

    public final /* synthetic */ void zzb() {
    }
}
