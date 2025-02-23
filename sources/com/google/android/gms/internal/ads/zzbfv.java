package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbfv extends zzaxm implements zzbfx {
    public zzbfv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final zzdq zze() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfa zzf() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 16
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbfa
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbfa r1 = (com.google.android.gms.internal.ads.zzbfa) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbey r2 = new com.google.android.gms.internal.ads.zzbey
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfv.zzf():com.google.android.gms.internal.ads.zzbfa");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfd zzg(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 2
            android.os.Parcel r4 = r3.zzdb(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzbfd
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzbfd r0 = (com.google.android.gms.internal.ads.zzbfd) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzbfb r1 = new com.google.android.gms.internal.ads.zzbfb
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfv.zzg(java.lang.String):com.google.android.gms.internal.ads.zzbfd");
    }

    public final IObjectWrapper zzh() throws RemoteException {
        return C0709Uj.e(zzdb(9, zza()));
    }

    public final String zzi() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzj(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(1, zza);
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzk() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        ArrayList<String> createStringArrayList = zzdb.createStringArrayList();
        zzdb.recycle();
        return createStringArrayList;
    }

    public final void zzl() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzm() throws RemoteException {
        zzdc(15, zza());
    }

    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(5, zza);
    }

    public final void zzo() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzdc(14, zza);
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(17, zza);
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(10, zza);
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
