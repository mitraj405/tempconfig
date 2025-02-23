package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsn;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbsn zza;

    private final void zza() {
        zzbsn zzbsn = this.zza;
        if (zzbsn != null) {
            try {
                zzbsn.zzx();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null && !zzbsn.zzH()) {
                return;
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbsn zzbsn2 = this.zza;
            if (zzbsn2 != null) {
                zzbsn2.zzi();
            }
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbsn zzo = zzay.zza().zzo(this);
        this.zza = zzo;
        if (zzo != null) {
            try {
                zzo.zzl(bundle);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzm.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    public final void onDestroy() {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzm();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    public final void onPause() {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzo();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onRestart() {
        super.onRestart();
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzq();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onResume() {
        super.onResume();
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzr();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    public final void onStart() {
        super.onStart();
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzt();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onStop() {
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzu();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbsn zzbsn = this.zza;
            if (zzbsn != null) {
                zzbsn.zzv();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
