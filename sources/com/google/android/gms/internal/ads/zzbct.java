package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbct {
    private CustomTabsSession zza;
    private CustomTabsClient zzb;
    private CustomTabsServiceConnection zzc;
    private zzbcs zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                        return resolveActivity.activityInfo.packageName.equals(zzhfv.zza(context));
                    }
                }
            }
        }
        return false;
    }

    public final CustomTabsSession zza() {
        CustomTabsClient customTabsClient = this.zzb;
        CustomTabsSession customTabsSession = null;
        if (customTabsClient != null) {
            if (this.zza == null) {
                J7 j7 = new J7((zzbcu) null);
                ICustomTabsService iCustomTabsService = customTabsClient.f1310a;
                try {
                    if (iCustomTabsService.newSession(j7)) {
                        customTabsSession = new CustomTabsSession(iCustomTabsService, j7, customTabsClient.a);
                    }
                } catch (RemoteException unused) {
                }
            }
            return this.zza;
        }
        this.zza = customTabsSession;
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String zza2;
        if (this.zzb == null && (zza2 = zzhfv.zza(activity)) != null) {
            zzhfw zzhfw = new zzhfw(this);
            this.zzc = zzhfw;
            zzhfw.setApplicationContext(activity.getApplicationContext());
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            if (!TextUtils.isEmpty(zza2)) {
                intent.setPackage(zza2);
            }
            activity.bindService(intent, zzhfw, 33);
        }
    }

    public final void zzc(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        customTabsClient.getClass();
        try {
            customTabsClient.f1310a.warmup(0);
        } catch (RemoteException unused) {
        }
        zzbcs zzbcs = this.zzd;
        if (zzbcs != null) {
            zzbcs.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbcs zzbcs) {
        this.zzd = zzbcs;
    }

    public final void zzf(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzc;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.zzb = null;
            this.zza = null;
            this.zzc = null;
        }
    }
}
