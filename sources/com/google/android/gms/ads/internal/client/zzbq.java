package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
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
public interface zzbq extends IInterface {
    zzbn zze() throws RemoteException;

    void zzf(zzbgb zzbgb) throws RemoteException;

    void zzg(zzbge zzbge) throws RemoteException;

    void zzh(String str, zzbgk zzbgk, zzbgh zzbgh) throws RemoteException;

    void zzi(zzblq zzblq) throws RemoteException;

    void zzj(zzbgo zzbgo, zzq zzq) throws RemoteException;

    void zzk(zzbgr zzbgr) throws RemoteException;

    void zzl(zzbh zzbh) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzblh zzblh) throws RemoteException;

    void zzo(zzbes zzbes) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcf zzcf) throws RemoteException;
}
