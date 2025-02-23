package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbqj extends zzaxm implements zzbql {
    public zzbqj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzdq zze() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbra zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbra zzbra = (zzbra) zzaxo.zza(zzdb, zzbra.CREATOR);
        zzdb.recycle();
        return zzbra;
    }

    public final zzbra zzg() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        zzbra zzbra = (zzbra) zzaxo.zza(zzdb, zzbra.CREATOR);
        zzdb.recycle();
        return zzbra;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbqo zzbqo) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzaxo.zzd(zza, bundle);
        zzaxo.zzd(zza, bundle2);
        zzaxo.zzd(zza, zzq);
        zzaxo.zzf(zza, zzbqo);
        zzdc(1, zza);
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpw zzbpw, zzbos zzbos) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbpw);
        zzaxo.zzf(zza, zzbos);
        zzdc(23, zza);
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpz zzbpz, zzbos zzbos, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbpz);
        zzaxo.zzf(zza, zzbos);
        zzaxo.zzd(zza, zzq);
        zzdc(13, zza);
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpz zzbpz, zzbos zzbos, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbpz);
        zzaxo.zzf(zza, zzbos);
        zzaxo.zzd(zza, zzq);
        zzdc(21, zza);
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbqc zzbqc, zzbos zzbos) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbqc);
        zzaxo.zzf(zza, zzbos);
        zzdc(14, zza);
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbqf zzbqf, zzbos zzbos) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbqf);
        zzaxo.zzf(zza, zzbos);
        zzdc(18, zza);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbqf zzbqf, zzbos zzbos, zzbes zzbes) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbqf);
        zzaxo.zzf(zza, zzbos);
        zzaxo.zzd(zza, zzbes);
        zzdc(22, zza);
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbqi zzbqi, zzbos zzbos) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbqi);
        zzaxo.zzf(zza, zzbos);
        zzdc(20, zza);
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbqi zzbqi, zzbos zzbos) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaxo.zzd(zza, zzl);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbqi);
        zzaxo.zzf(zza, zzbos);
        zzdc(16, zza);
    }

    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(19, zza);
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(24, zza);
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(15, zza);
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(17, zza);
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
