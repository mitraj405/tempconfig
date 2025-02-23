package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class NotificationHandlerActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.NotificationHandlerActivity";

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzbsg zzm = zzay.zza().zzm(this, new zzboi());
            if (zzm == null) {
                zzm.zzg("OfflineUtils is null");
            } else {
                zzm.zze(getIntent());
            }
        } catch (RemoteException e) {
            zzm.zzg("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }

    public final void onResume() {
        super.onResume();
        finish();
    }
}
