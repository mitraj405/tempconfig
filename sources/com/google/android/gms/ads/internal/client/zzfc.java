package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwj;
import com.google.android.gms.internal.ads.zzbwn;
import com.google.android.gms.internal.ads.zzbwo;
import com.google.android.gms.internal.ads.zzbwu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzfc extends zzbwf {
    private static void zzr(zzbwn zzbwn) {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzfb(zzbwn));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdn zzc() {
        return null;
    }

    public final zzbwd zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzl zzl, zzbwn zzbwn) throws RemoteException {
        zzr(zzbwn);
    }

    public final void zzg(zzl zzl, zzbwn zzbwn) throws RemoteException {
        zzr(zzbwn);
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
    }

    public final void zzj(zzdg zzdg) {
    }

    public final void zzk(zzbwj zzbwj) throws RemoteException {
    }

    public final void zzl(zzbwu zzbwu) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzp(zzbwo zzbwo) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }
}
