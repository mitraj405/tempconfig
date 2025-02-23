package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcay extends FrameLayout implements zzcap {
    final zzcbm zza;
    private final zzcbk zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbcl zze;
    private final long zzf;
    private final zzcaq zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    /* JADX WARNING: type inference failed for: r13v0, types: [com.google.android.gms.internal.ads.zzcaq, android.view.View] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.google.android.gms.internal.ads.zzcao] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.google.android.gms.internal.ads.zzccc] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcay(android.content.Context r16, com.google.android.gms.internal.ads.zzcbk r17, int r18, boolean r19, com.google.android.gms.internal.ads.zzbcl r20, com.google.android.gms.internal.ads.zzcbj r21) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r20
            r15.<init>(r16)
            r7 = r17
            r0.zzb = r7
            r0.zze = r9
            android.widget.FrameLayout r10 = new android.widget.FrameLayout
            r10.<init>(r8)
            r0.zzc = r10
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r11 = -1
            r1.<init>(r11, r11)
            r15.addView(r10, r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzj()
            com.google.android.gms.internal.ads.zzcar r1 = r1.zza
            com.google.android.gms.internal.ads.zzcbl r12 = new com.google.android.gms.internal.ads.zzcbl
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r17.zzn()
            java.lang.String r4 = r17.zzdi()
            com.google.android.gms.internal.ads.zzbci r6 = r17.zzk()
            r1 = r12
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = 2
            r2 = r18
            if (r2 != r1) goto L_0x005a
            com.google.android.gms.internal.ads.zzccc r13 = new com.google.android.gms.internal.ads.zzccc
            boolean r6 = com.google.android.gms.internal.ads.zzcar.zza(r17)
            r1 = r13
            r2 = r16
            r3 = r12
            r4 = r17
            r5 = r19
            r7 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0082
        L_0x005a:
            com.google.android.gms.internal.ads.zzcao r13 = new com.google.android.gms.internal.ads.zzcao
            boolean r12 = com.google.android.gms.internal.ads.zzcar.zza(r17)
            com.google.android.gms.internal.ads.zzcbl r14 = new com.google.android.gms.internal.ads.zzcbl
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r17.zzn()
            java.lang.String r4 = r17.zzdi()
            com.google.android.gms.internal.ads.zzbci r6 = r17.zzk()
            r1 = r14
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = r13
            r3 = r17
            r4 = r19
            r5 = r12
            r6 = r21
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
        L_0x0082:
            r0.zzg = r13
            android.view.View r1 = new android.view.View
            r1.<init>(r8)
            r0.zzd = r1
            r2 = 0
            r1.setBackgroundColor(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r11, r11, r3)
            r10.addView(r13, r2)
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzz
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b6
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r11, r11)
            r10.addView(r1, r2)
            r10.bringChildToFront(r1)
        L_0x00b6:
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzw
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00cb
            r15.zzn()
        L_0x00cb:
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r8)
            r0.zzq = r1
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzB
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.zzf = r1
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzy
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.zzk = r1
            if (r9 == 0) goto L_0x0105
            r2 = 1
            if (r2 == r1) goto L_0x00fe
            java.lang.String r1 = "0"
            goto L_0x0100
        L_0x00fe:
            java.lang.String r1 = "1"
        L_0x0100:
            java.lang.String r2 = "spinner_used"
            r9.zzd(r2, r1)
        L_0x0105:
            com.google.android.gms.internal.ads.zzcbm r1 = new com.google.android.gms.internal.ads.zzcbm
            r1.<init>(r15)
            r0.zza = r1
            r13.zzr(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcay.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbk, int, boolean, com.google.android.gms.internal.ads.zzbcl, com.google.android.gms.internal.ads.zzcbj):void");
    }

    private final void zzJ() {
        if (this.zzb.zzi() != null && this.zzi && !this.zzj) {
            this.zzb.zzi().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl2 = zzl();
        if (zzl2 != null) {
            hashMap.put("playerId", zzl2.toString());
        }
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        if (this.zzq.getParent() != null) {
            return true;
        }
        return false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            zzcaq zzcaq = this.zzg;
            if (zzcaq != null) {
                zzbzo.zze.execute(new zzcas(zzcaq));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        zzt.zza.post(new zzcau(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        zzt.zza.post(new zzcax(this, z));
    }

    public final void zzA(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzz(i);
        }
    }

    public final void zzB(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzA(i);
        }
    }

    public final void zzC(int i) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzz)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzB(i);
        }
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (zze.zzc()) {
            StringBuilder C = C1058d.C("Set video bounds to x:", i, ";y:", i2, ";w:");
            C.append(i3);
            C.append(";h:");
            C.append(i4);
            zze.zza(C.toString());
        }
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzc.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzG(float f) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzb.zze(f);
            zzcaq.zzn();
        }
    }

    public final void zzH(float f, float f2) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzb.zzd(false);
            zzcaq.zzn();
        }
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    public final void zze() {
        boolean z;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            if ((this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.zzj = z;
            if (!z) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzf() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null && this.zzm == 0) {
            zzcaq zzcaq2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(((float) zzcaq.zzc()) / 1000.0f), "videoWidth", String.valueOf(zzcaq2.zze()), "videoHeight", String.valueOf(zzcaq2.zzd()));
        }
    }

    public final void zzg() {
        this.zzd.setVisibility(4);
        zzt.zza.post(new zzcat(this));
    }

    public final void zzh() {
        this.zza.zzb();
        zzt.zza.post(new zzcav(this));
    }

    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        zzt.zza.post(new zzcaw(this));
    }

    public final void zzj(int i, int i2) {
        if (this.zzk) {
            zzbbn zzbbn = zzbbw.zzA;
            int max = Math.max(i / ((Integer) zzba.zzc().zza(zzbbn)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzba.zzc().zza(zzbbn)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg != null && this.zzp != null) {
            long elapsedRealtime = zzu.zzB().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = zzu.zzB().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                zze.zza("Spinner frame grab took " + elapsedRealtime2 + "ms");
            }
            if (elapsedRealtime2 > this.zzf) {
                zzm.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbcl zzbcl = this.zze;
                if (zzbcl != null) {
                    zzbcl.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final Integer zzl() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            return zzcaq.zzw();
        }
        return null;
    }

    public final void zzn() {
        String str;
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            TextView textView = new TextView(zzcaq.getContext());
            Resources zze2 = zzu.zzo().zze();
            if (zze2 == null) {
                str = "AdMob - ";
            } else {
                str = zze2.getString(R.string.watermark_label_prefix);
            }
            textView.setText(String.valueOf(str).concat(this.zzg.zzj()));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzc.bringChildToFront(textView);
        }
    }

    public final void zzo() {
        this.zza.zza();
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzt();
        }
        zzJ();
    }

    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    public final /* synthetic */ void zzq(boolean z) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzr(Integer num) {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzC(this.zzn, this.zzo, num);
            } else {
                zzK("no_src", new String[0]);
            }
        }
    }

    public final void zzs() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzb.zzd(true);
            zzcaq.zzn();
        }
    }

    public final void zzt() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            long zza2 = (long) zzcaq.zza();
            if (this.zzl != zza2 && zza2 > 0) {
                float f = ((float) zza2) / 1000.0f;
                if (((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue()) {
                    zzK("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(zzu.zzB().currentTimeMillis()));
                } else {
                    zzK("timeupdate", "time", String.valueOf(f));
                }
                this.zzl = zza2;
            }
        }
    }

    public final void zzu() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzo();
        }
    }

    public final void zzv() {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzp();
        }
    }

    public final void zzw(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzq(i);
        }
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzy(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzx(i);
        }
    }

    public final void zzz(int i) {
        zzcaq zzcaq = this.zzg;
        if (zzcaq != null) {
            zzcaq.zzy(i);
        }
    }
}
