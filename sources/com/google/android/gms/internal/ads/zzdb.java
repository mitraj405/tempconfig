package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdb {
    private static final String zzA = Integer.toString(10, 36);
    private static final String zzB = Integer.toString(11, 36);
    private static final String zzC = Integer.toString(12, 36);
    private static final String zzD = Integer.toString(13, 36);
    private static final String zzE = Integer.toString(14, 36);
    private static final String zzF = Integer.toString(15, 36);
    private static final String zzG = Integer.toString(16, 36);
    private static final String zzp = Integer.toString(0, 36);
    private static final String zzq = Integer.toString(17, 36);
    private static final String zzr = Integer.toString(1, 36);
    private static final String zzs = Integer.toString(2, 36);
    private static final String zzt = Integer.toString(18, 36);
    private static final String zzu = Integer.toString(4, 36);
    private static final String zzv = Integer.toString(5, 36);
    private static final String zzw = Integer.toString(6, 36);
    private static final String zzx = Integer.toString(7, 36);
    private static final String zzy = Integer.toString(8, 36);
    private static final String zzz = Integer.toString(9, 36);
    public final CharSequence zza;
    public final Layout.Alignment zzb;
    public final Layout.Alignment zzc;
    public final Bitmap zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final int zzi;
    public final float zzj;
    public final float zzk;
    public final int zzl;
    public final float zzm;
    public final int zzn;
    public final float zzo;

    static {
        zzcz zzcz = new zzcz();
        zzcz.zzl("");
        zzcz.zzp();
        Integer.toString(3, 36);
    }

    public /* synthetic */ zzdb(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6, zzda zzda) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 == null) {
            bitmap.getClass();
        } else {
            zzdi.zzd(bitmap2 == null);
        }
        if (charSequence2 instanceof Spanned) {
            this.zza = SpannedString.valueOf(charSequence);
        } else {
            this.zza = charSequence2 != null ? charSequence.toString() : null;
        }
        this.zzb = alignment;
        this.zzc = alignment2;
        this.zzd = bitmap2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = f2;
        this.zzi = i3;
        this.zzj = f4;
        this.zzk = f5;
        this.zzl = i4;
        this.zzm = f3;
        this.zzn = i6;
        this.zzo = f6;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdb.class == obj.getClass()) {
            zzdb zzdb = (zzdb) obj;
            if (TextUtils.equals(this.zza, zzdb.zza) && this.zzb == zzdb.zzb && this.zzc == zzdb.zzc && ((bitmap = this.zzd) != null ? !((bitmap2 = zzdb.zzd) == null || !bitmap.sameAs(bitmap2)) : zzdb.zzd == null) && this.zze == zzdb.zze && this.zzf == zzdb.zzf && this.zzg == zzdb.zzg && this.zzh == zzdb.zzh && this.zzi == zzdb.zzi && this.zzj == zzdb.zzj && this.zzk == zzdb.zzk && this.zzl == zzdb.zzl && this.zzm == zzdb.zzm && this.zzn == zzdb.zzn && this.zzo == zzdb.zzo) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, Float.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg), Float.valueOf(this.zzh), Integer.valueOf(this.zzi), Float.valueOf(this.zzj), Float.valueOf(this.zzk), Boolean.FALSE, -16777216, Integer.valueOf(this.zzl), Float.valueOf(this.zzm), Integer.valueOf(this.zzn), Float.valueOf(this.zzo)});
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.zza;
        if (charSequence != null) {
            bundle.putCharSequence(zzp, charSequence);
            CharSequence charSequence2 = this.zza;
            if (charSequence2 instanceof Spanned) {
                ArrayList zza2 = zzdd.zza((Spanned) charSequence2);
                if (!zza2.isEmpty()) {
                    bundle.putParcelableArrayList(zzq, zza2);
                }
            }
        }
        bundle.putSerializable(zzr, this.zzb);
        bundle.putSerializable(zzs, this.zzc);
        bundle.putFloat(zzu, this.zze);
        bundle.putInt(zzv, this.zzf);
        bundle.putInt(zzw, this.zzg);
        bundle.putFloat(zzx, this.zzh);
        bundle.putInt(zzy, this.zzi);
        bundle.putInt(zzz, this.zzl);
        bundle.putFloat(zzA, this.zzm);
        bundle.putFloat(zzB, this.zzj);
        bundle.putFloat(zzC, this.zzk);
        bundle.putBoolean(zzE, false);
        bundle.putInt(zzD, -16777216);
        bundle.putInt(zzF, this.zzn);
        bundle.putFloat(zzG, this.zzo);
        if (this.zzd != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zzdi.zzf(this.zzd.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundle.putByteArray(zzt, byteArrayOutputStream.toByteArray());
        }
        return bundle;
    }

    public final zzcz zzb() {
        return new zzcz(this, (zzcy) null);
    }
}
