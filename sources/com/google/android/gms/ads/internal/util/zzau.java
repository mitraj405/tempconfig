package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzau {
    private final Context zza;
    private final zzdvi zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new zzah(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzu.zzt().zzb();
        this.zzk = zzu.zzt().zza();
        this.zzb = zzu.zzs().zza();
    }

    private final void zzs(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        int ordinal = this.zzb.zza().ordinal();
        if (ordinal == 1) {
            i = zzu2;
        } else if (ordinal != 2) {
            i = zzu;
        } else {
            i = zzu3;
        }
        zzu.zzp();
        AlertDialog.Builder zzK = zzt.zzK(context);
        AtomicInteger atomicInteger = new AtomicInteger(i);
        zzK.setTitle("Setup gesture");
        zzK.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new zzap(atomicInteger));
        zzK.setNegativeButton("Dismiss", new zzaq(this));
        zzK.setPositiveButton("Save", new zzar(this, atomicInteger, i, zzu2, zzu3));
        zzK.setOnCancelListener(new zzas(this));
        zzK.create().show();
    }

    private final boolean zzt(float f, float f2, float f3, float f4) {
        if (Math.abs(this.zzi.x - f) >= ((float) this.zzh) || Math.abs(this.zzi.y - f2) >= ((float) this.zzh) || Math.abs(this.zzj.x - f3) >= ((float) this.zzh) || Math.abs(this.zzj.y - f4) >= ((float) this.zzh)) {
            return false;
        }
        return true;
    }

    private static final int zzu(List list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        return C0709Uj.j(sb, this.zzd, "}");
    }

    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzc(zzgcu zzgcu) {
        if (!zzu.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzu.zzs().zzd(this.zza, this.zzd, this.zze);
            return;
        }
        zzgcu.execute(new zzan(this));
    }

    public final /* synthetic */ void zzd(zzgcu zzgcu) {
        if (!zzu.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzu.zzs().zzd(this.zza, this.zzd, this.zze);
            return;
        }
        zzgcu.execute(new zzam(this));
    }

    public final /* synthetic */ void zze() {
        zzu.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzf() {
        zzu.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                this.zzb.zzm(zzdve.SHAKE);
            } else if (atomicInteger.get() == i3) {
                this.zzb.zzm(zzdve.FLICK);
            } else {
                this.zzb.zzm(zzdve.NONE);
            }
        }
        zzr();
    }

    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i) {
        zzu.zzp();
        zzt.zzT(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public final /* synthetic */ void zzj(int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 == i) {
            if (!(this.zza instanceof Activity)) {
                zzm.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzu.zzp();
                Map zzP = zzt.zzP(build);
                for (String str3 : zzP.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append((String) zzP.get(str3));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(this.zza);
            zzK.setMessage(str2);
            zzK.setTitle("Ad Information");
            zzK.setPositiveButton("Share", new zzaj(this, str2));
            zzK.setNegativeButton("Close", new zzak());
            zzK.create().show();
        } else if (i6 == i2) {
            zzm.zze("Debug mode [Creative Preview] selected.");
            zzbzo.zza.execute(new zzai(this));
        } else if (i6 == i3) {
            zzm.zze("Debug mode [Troubleshooting] selected.");
            zzbzo.zza.execute(new zzag(this));
        } else if (i6 == i4) {
            zzdvi zzdvi = this.zzb;
            zzgcu zzgcu = zzbzo.zze;
            zzgcu zzgcu2 = zzbzo.zza;
            if (zzdvi.zzq()) {
                zzgcu.execute(new zzat(this));
            } else {
                zzgcu2.execute(new zzaf(this, zzgcu));
            }
        } else if (i6 == i5) {
            zzdvi zzdvi2 = this.zzb;
            zzgcu zzgcu3 = zzbzo.zze;
            zzgcu zzgcu4 = zzbzo.zza;
            if (zzdvi2.zzq()) {
                zzgcu3.execute(new zzae(this));
            } else {
                zzgcu4.execute(new zzal(this, zzgcu3));
            }
        }
    }

    public final /* synthetic */ void zzk() {
        zzay zzs = zzu.zzs();
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm = zzs.zzm();
        Context context = this.zza;
        zzs.zzh(zzs.zzj(context, str, str2));
        if (zzs.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzs.zze(context, str2, str3, str);
            }
            zzm.zze("Device is linked for debug signals.");
            zzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzs.zzd(context, str, str2);
    }

    public final /* synthetic */ void zzl() {
        zzay zzs = zzu.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzs.zzk(context, str, str2)) {
            zzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (C0515Ga.FARE_ONLY.equals(zzs.zza)) {
            zzm.zze("Creative is not pushed for this device.");
            zzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (C0515Ga.AVLBLTY_ONLY.equals(zzs.zza)) {
            zzm.zze("The app is not linked for creative preview.");
            zzs.zzd(context, str, str2);
        } else if ("0".equals(zzs.zza)) {
            zzm.zze("Device is linked for in app preview.");
            zzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i != -1) {
            if (i == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzba.zzc().zza(zzbbw.zzeg)).longValue());
                }
            } else if (i == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                        }
                        if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzm.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzu.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzu.zzs().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzip)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(this.zza);
            zzK.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzao(this, zzu, zzu2, zzu3, zzu4, zzu5));
            zzK.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
