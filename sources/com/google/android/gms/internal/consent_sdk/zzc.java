package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final /* synthetic */ class zzc implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzd[] zzc;

    public /* synthetic */ zzc(String str, String str2, zzd[] zzdArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzdArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.zzb;
            String lowerCase = str.toLowerCase();
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException unused) {
                    return;
                }
            }
            zzd[] zzdArr = this.zzc;
            jSONObject.toString();
            int i = 0;
            while (i < zzdArr.length) {
                zzd zzd = zzdArr[i];
                FutureTask futureTask = new FutureTask(new zzb(zzd, lowerCase, jSONObject));
                zzd.zza().execute(futureTask);
                try {
                    if (!((Boolean) futureTask.get()).booleanValue()) {
                        i++;
                    } else {
                        return;
                    }
                } catch (ExecutionException e) {
                    e.getCause();
                } catch (InterruptedException unused2) {
                }
            }
        }
    }
}
