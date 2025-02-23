package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcdr implements zzfr {
    public final /* synthetic */ zzfr zza;
    public final /* synthetic */ byte[] zzb;

    public /* synthetic */ zzcdr(zzfr zzfr, byte[] bArr) {
        this.zza = zzfr;
        this.zzb = bArr;
    }

    public final zzfs zza() {
        int i = zzcdw.zza;
        zzfs zza2 = this.zza.zza();
        byte[] bArr = this.zzb;
        return new zzcdk(new zzfn(bArr), bArr.length, zza2);
    }
}
