package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.UserMessagingPlatform;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzbn {
    private final zzds zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();

    public zzbn(zzds zzds, Executor executor) {
        this.zza = zzds;
        this.zzb = executor;
    }

    public final /* synthetic */ void zza(zzbb zzbb) {
        AtomicReference atomicReference = this.zzd;
        Objects.requireNonNull(atomicReference);
        zzbb.zzf(new zzbe(atomicReference), new zzbf());
    }

    public final void zzb(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzcr.zza();
        zzbp zzbp = (zzbp) this.zzc.get();
        if (zzbp == null) {
            onConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzg(3, "No available form can be built.").zza());
        } else {
            ((zzav) this.zza.zza()).zza(zzbp).zzb().zza().zzf(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
        }
    }

    public final void zzc() {
        zzbp zzbp = (zzbp) this.zzc.get();
        if (zzbp != null) {
            zzbb zza2 = ((zzav) this.zza.zza()).zza(zzbp).zzb().zza();
            zza2.zza = true;
            zzcr.zza.post(new zzbd(this, zza2));
        }
    }

    public final void zzd(zzbp zzbp) {
        this.zzc.set(zzbp);
    }

    public final void zze(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        zzcr.zza();
        zzj zzb2 = zza.zza(activity).zzb();
        if (zzb2 == null) {
            zzcr.zza.post(new zzbg(onConsentFormDismissedListener));
        } else if (!zzb2.isConsentFormAvailable() && zzb2.getPrivacyOptionsRequirementStatus() != ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED) {
            zzcr.zza.post(new zzbh(onConsentFormDismissedListener));
            zzb2.zza(activity);
        } else if (zzb2.getPrivacyOptionsRequirementStatus() == ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED) {
            zzcr.zza.post(new zzbi(onConsentFormDismissedListener));
        } else {
            ConsentForm consentForm = (ConsentForm) this.zzd.get();
            if (consentForm == null) {
                zzcr.zza.post(new zzbj(onConsentFormDismissedListener));
                return;
            }
            consentForm.show(activity, onConsentFormDismissedListener);
            this.zzb.execute(new zzbk(this));
        }
    }

    public final boolean zzf() {
        if (this.zzc.get() != null) {
            return true;
        }
        return false;
    }
}
