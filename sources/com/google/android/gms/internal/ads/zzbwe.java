package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbwe extends zzaxm implements zzbwg {
    public zzbwe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle zzb() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        Bundle bundle = (Bundle) zzaxo.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzdn zzc() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        zzdn zzb = zzdm.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbwd zzd() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 11
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbwd
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbwd r1 = (com.google.android.gms.internal.ads.zzbwd) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbwb r2 = new com.google.android.gms.internal.ads.zzbwb
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwe.zzd():com.google.android.gms.internal.ads.zzbwd");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final void zzf(zzl zzl, zzbwn zzbwn) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, zzbwn);
        zzdc(1, zza);
    }

    public final void zzg(zzl zzl, zzbwn zzbwn) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, zzbwn);
        zzdc(14, zza);
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaxo.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(15, zza);
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzdd);
        zzdc(8, zza);
    }

    public final void zzj(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzdg);
        zzdc(13, zza);
    }

    public final void zzk(zzbwj zzbwj) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbwj);
        zzdc(2, zza);
    }

    public final void zzl(zzbwu zzbwu) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbwu);
        zzdc(7, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzdc(5, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    public final boolean zzo() throws RemoteException {
        throw null;
    }

    public final void zzp(zzbwo zzbwo) throws RemoteException {
        throw null;
    }
}
