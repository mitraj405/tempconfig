package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdnk extends zzbgz {
    private final String zza;
    private final zzdiw zzb;
    private final zzdjb zzc;
    private final zzdsk zzd;

    public zzdnk(String str, zzdiw zzdiw, zzdjb zzdjb, zzdsk zzdsk) {
        this.zza = str;
        this.zzb = zzdiw;
        this.zzc = zzdjb;
        this.zzd = zzdsk;
    }

    public final void zzA() {
        this.zzb.zzH();
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        this.zzb.zzL(bundle);
    }

    public final void zzC() {
        this.zzb.zzN();
    }

    public final void zzD(zzcs zzcs) throws RemoteException {
        this.zzb.zzO(zzcs);
    }

    public final void zzE(zzdg zzdg) throws RemoteException {
        try {
            if (!zzdg.zzf()) {
                this.zzd.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzP(zzdg);
    }

    public final void zzF(zzbgx zzbgx) throws RemoteException {
        this.zzb.zzQ(zzbgx);
    }

    public final boolean zzG() {
        return this.zzb.zzV();
    }

    public final boolean zzH() throws RemoteException {
        if (this.zzc.zzH().isEmpty() || this.zzc.zzk() == null) {
            return false;
        }
        return true;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        return this.zzb.zzY(bundle);
    }

    public final double zze() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzf() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdn zzg() throws RemoteException {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgc)).booleanValue()) {
            return null;
        }
        return this.zzb.zzm();
    }

    public final zzdq zzh() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbew zzi() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbfa zzj() throws RemoteException {
        return this.zzb.zzc().zza();
    }

    public final zzbfd zzk() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzl() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzo() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzp() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzq() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzr() throws RemoteException {
        return this.zza;
    }

    public final String zzs() throws RemoteException {
        return this.zzc.zzD();
    }

    public final String zzt() throws RemoteException {
        return this.zzc.zzE();
    }

    public final List zzu() throws RemoteException {
        return this.zzc.zzG();
    }

    public final List zzv() throws RemoteException {
        if (zzH()) {
            return this.zzc.zzH();
        }
        return Collections.emptyList();
    }

    public final void zzw() throws RemoteException {
        this.zzb.zzv();
    }

    public final void zzx() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzy(zzcw zzcw) throws RemoteException {
        this.zzb.zzC(zzcw);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        this.zzb.zzG(bundle);
    }
}
