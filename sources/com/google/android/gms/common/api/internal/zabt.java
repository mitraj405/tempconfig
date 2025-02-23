package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zabt implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabu zab;

    public zabt(zabu zabu, ConnectionResult connectionResult) {
        this.zab = zabu;
        this.zaa = connectionResult;
    }

    public final void run() {
        zabu zabu = this.zab;
        zabq zabq = (zabq) zabu.zaa.zap.get(zabu.zac);
        if (zabq != null) {
            if (this.zaa.isSuccess()) {
                this.zab.zaf = true;
                if (this.zab.zab.requiresSignIn()) {
                    this.zab.zag();
                    return;
                }
                try {
                    zabu zabu2 = this.zab;
                    zabu2.zab.getRemoteService((IAccountAccessor) null, zabu2.zab.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.zab.zab.disconnect("Failed to get service from broker.");
                    zabq.zar(new ConnectionResult(10), (Exception) null);
                }
            } else {
                zabq.zar(this.zaa, (Exception) null);
            }
        }
    }
}
