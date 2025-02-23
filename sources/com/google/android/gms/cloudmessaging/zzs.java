package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
abstract class zzs {
    final int zza;
    final TaskCompletionSource zzb = new TaskCompletionSource();
    final int zzc;
    final Bundle zzd;

    public zzs(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request { what=");
        sb.append(this.zzc);
        sb.append(" id=");
        sb.append(this.zza);
        sb.append(" oneWay=");
        return xx.G(sb, zzb(), "}");
    }

    public abstract void zza(Bundle bundle);

    public abstract boolean zzb();

    public final void zzc(zzt zzt) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            toString();
            zzt.toString();
        }
        this.zzb.setException(zzt);
    }

    public final void zzd(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            toString();
            String.valueOf(obj);
        }
        this.zzb.setResult(obj);
    }
}
