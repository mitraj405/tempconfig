package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzblq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbo extends zzaxm implements zzbq {
    public zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbn zze() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 1
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbn
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbn r1 = (com.google.android.gms.ads.internal.client.zzbn) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.ads.internal.client.zzbl r2 = new com.google.android.gms.ads.internal.client.zzbl
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbo.zze():com.google.android.gms.ads.internal.client.zzbn");
    }

    public final void zzf(zzbgb zzbgb) throws RemoteException {
        throw null;
    }

    public final void zzg(zzbge zzbge) throws RemoteException {
        throw null;
    }

    public final void zzh(String str, zzbgk zzbgk, zzbgh zzbgh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaxo.zzf(zza, zzbgk);
        zzaxo.zzf(zza, zzbgh);
        zzdc(5, zza);
    }

    public final void zzi(zzblq zzblq) throws RemoteException {
        throw null;
    }

    public final void zzj(zzbgo zzbgo, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbgo);
        zzaxo.zzd(zza, zzq);
        zzdc(8, zza);
    }

    public final void zzk(zzbgr zzbgr) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbgr);
        zzdc(10, zza);
    }

    public final void zzl(zzbh zzbh) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbh);
        zzdc(2, zza);
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, adManagerAdViewOptions);
        zzdc(15, zza);
    }

    public final void zzn(zzblh zzblh) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbes zzbes) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbes);
        zzdc(6, zza);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzq(zzcf zzcf) throws RemoteException {
        throw null;
    }
}
