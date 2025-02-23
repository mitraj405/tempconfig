package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfw extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhfw(zzbct zzbct) {
        this.zza = new WeakReference(zzbct);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbct zzbct = (zzbct) this.zza.get();
        if (zzbct != null) {
            zzbct.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbct zzbct = (zzbct) this.zza.get();
        if (zzbct != null) {
            zzbct.zzd();
        }
    }
}
