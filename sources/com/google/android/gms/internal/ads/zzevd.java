package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    public zzevd(zzgcu zzgcu, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzgcu;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    public final int zza() {
        return 35;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzevc(this));
    }

    public final /* synthetic */ zzeve zzc() throws Exception {
        int i;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzu.zzp();
        boolean zzE = zzt.zzE(this.zzb);
        String str = this.zzc.afmaVersion;
        zzu.zzp();
        boolean zzF = zzt.zzF();
        zzu.zzp();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i = 0;
        } else {
            i = applicationInfo.targetSdkVersion;
        }
        int i2 = i;
        Context context = this.zzb;
        String str2 = this.zzd;
        return new zzeve(isCallerInstantApp, zzE, str, zzF, i2, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), str2);
    }
}
