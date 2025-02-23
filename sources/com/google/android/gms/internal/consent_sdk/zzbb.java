package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzbb implements ConsentForm {
    boolean zza = false;
    /* access modifiers changed from: private */
    public final Application zzb;
    /* access modifiers changed from: private */
    public final zzbw zzc;
    private final zzap zzd;
    private final zzbp zze;
    private final zzds zzf;
    /* access modifiers changed from: private */
    public Dialog zzg;
    private zzbu zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference zzj = new AtomicReference();
    private final AtomicReference zzk = new AtomicReference();
    /* access modifiers changed from: private */
    public final AtomicReference zzl = new AtomicReference();

    public zzbb(Application application, zzab zzab, zzbw zzbw, zzap zzap, zzbp zzbp, zzds zzds) {
        this.zzb = application;
        this.zzc = zzbw;
        this.zzd = zzap;
        this.zze = zzbp;
        this.zzf = zzds;
    }

    private final void zzk() {
        Dialog dialog = this.zzg;
        if (dialog != null) {
            dialog.dismiss();
            this.zzg = null;
        }
        this.zzc.zza((Activity) null);
        zzay zzay = (zzay) this.zzl.getAndSet((Object) null);
        if (zzay != null) {
            zzay.zzb();
        }
    }

    public final void show(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        String str;
        zzcr.zza();
        if (!this.zzi.compareAndSet(false, true)) {
            if (true != this.zza) {
                str = "ConsentForm#show can only be invoked once.";
            } else {
                str = "Privacy options form is being loading. Please try again later.";
            }
            onConsentFormDismissedListener.onConsentFormDismissed(new zzg(3, str).zza());
            return;
        }
        this.zzh.zzc();
        zzay zzay = new zzay(this, activity);
        this.zzb.registerActivityLifecycleCallbacks(zzay);
        this.zzl.set(zzay);
        this.zzc.zza(activity);
        Dialog dialog = new Dialog(activity, 16973840);
        dialog.setContentView(this.zzh);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window == null) {
            onConsentFormDismissedListener.onConsentFormDismissed(new zzg(3, "Activity with null windows is passed in.").zza());
            return;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setFlags(16777216, 16777216);
        ED.a(window, false);
        this.zzk.set(onConsentFormDismissedListener);
        dialog.show();
        this.zzg = dialog;
        this.zzh.zzd("UMP_messagePresented", "");
    }

    public final zzbu zzc() {
        return this.zzh;
    }

    public final void zzf(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzbu zzb2 = ((zzbv) this.zzf).zza();
        this.zzh = zzb2;
        zzb2.setBackgroundColor(0);
        zzb2.getSettings().setJavaScriptEnabled(true);
        zzb2.setWebViewClient(new zzbt(zzb2, (zzbs) null));
        this.zzj.set(new zzba(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener, (zzaz) null));
        zzbu zzbu = this.zzh;
        zzbp zzbp = this.zze;
        zzbu.loadDataWithBaseURL(zzbp.zza(), zzbp.zzb(), "text/html", "UTF-8", (String) null);
        zzcr.zza.postDelayed(new zzax(this), 10000);
    }

    public final void zzg(int i) {
        zzk();
        ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = (ConsentForm.OnConsentFormDismissedListener) this.zzk.getAndSet((Object) null);
        if (onConsentFormDismissedListener != null) {
            this.zzd.zzg(3);
            onConsentFormDismissedListener.onConsentFormDismissed((FormError) null);
        }
    }

    public final void zzh(zzg zzg2) {
        zzk();
        ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = (ConsentForm.OnConsentFormDismissedListener) this.zzk.getAndSet((Object) null);
        if (onConsentFormDismissedListener != null) {
            onConsentFormDismissedListener.onConsentFormDismissed(zzg2.zza());
        }
    }

    public final void zzi() {
        zzba zzba = (zzba) this.zzj.getAndSet((Object) null);
        if (zzba != null) {
            zzba.onConsentFormLoadSuccess(this);
        }
    }

    public final void zzj(zzg zzg2) {
        zzba zzba = (zzba) this.zzj.getAndSet((Object) null);
        if (zzba != null) {
            zzba.onConsentFormLoadFailure(zzg2.zza());
        }
    }
}
