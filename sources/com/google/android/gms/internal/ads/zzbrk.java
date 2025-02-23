package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.CollectionUtils;
import in.juspay.hypersdk.analytics.LogConstants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbrk extends zzbrq {
    private String zza = "top-right";
    private boolean zzb = true;
    private int zzc = 0;
    private int zzd = 0;
    private int zze = -1;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = -1;
    private final Object zzi = new Object();
    private final zzcej zzj;
    private final Activity zzk;
    private zzcgd zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbrr zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbrk(zzcej zzcej, zzbrr zzbrr) {
        super(zzcej, "resize");
        this.zzj = zzcej;
        this.zzk = zzcej.zzi();
        this.zzo = zzbrr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzm */
    public final void zzc(boolean z) {
        this.zzp.dismiss();
        this.zzq.removeView((View) this.zzj);
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            this.zzr.addView((View) this.zzj);
            this.zzj.zzaj(this.zzl);
        }
        if (z) {
            zzl(LogConstants.DEFAULT_CHANNEL);
            zzbrr zzbrr = this.zzo;
            if (zzbrr != null) {
                zzbrr.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zza(boolean z) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzjU)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzc(z);
                } else {
                    zzbzo.zze.zza(new zzbri(this, z));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0206 A[Catch:{ RuntimeException -> 0x043a }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0207 A[Catch:{ RuntimeException -> 0x043a }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x026b A[Catch:{ RuntimeException -> 0x043a }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0272 A[Catch:{ RuntimeException -> 0x043a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.Object r3 = r1.zzi
            monitor-enter(r3)
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x0014
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0014:
            com.google.android.gms.internal.ads.zzcej r4 = r1.zzj     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcgd r4 = r4.zzO()     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x0023
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzcej r4 = r1.zzj     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcgd r4 = r4.zzO()     // Catch:{ all -> 0x0487 }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x0487 }
            if (r4 == 0) goto L_0x0036
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0036:
            com.google.android.gms.internal.ads.zzcej r4 = r1.zzj     // Catch:{ all -> 0x0487 }
            boolean r4 = r4.zzaF()     // Catch:{ all -> 0x0487 }
            if (r4 == 0) goto L_0x0045
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0045:
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x0064
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0487 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0487 }
            r1.zzh = r4     // Catch:{ all -> 0x0487 }
        L_0x0064:
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x0083
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0487 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0487 }
            r1.zze = r4     // Catch:{ all -> 0x0487 }
        L_0x0083:
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x00a2
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0487 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0487 }
            r1.zzf = r4     // Catch:{ all -> 0x0487 }
        L_0x00a2:
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x00c1
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0487 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0487 }
            r1.zzg = r4     // Catch:{ all -> 0x0487 }
        L_0x00c1:
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x00dd
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0487 }
            boolean r4 = java.lang.Boolean.parseBoolean(r4)     // Catch:{ all -> 0x0487 }
            r1.zzb = r4     // Catch:{ all -> 0x0487 }
        L_0x00dd:
            java.lang.String r4 = "customClosePosition"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0487 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0487 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x00ed
            r1.zza = r0     // Catch:{ all -> 0x0487 }
        L_0x00ed:
            int r0 = r1.zzh     // Catch:{ all -> 0x0487 }
            if (r0 < 0) goto L_0x0480
            int r0 = r1.zze     // Catch:{ all -> 0x0487 }
            if (r0 < 0) goto L_0x0480
            android.app.Activity r0 = r1.zzk     // Catch:{ all -> 0x0487 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0487 }
            if (r0 == 0) goto L_0x0479
            android.view.View r4 = r0.getDecorView()     // Catch:{ all -> 0x0487 }
            if (r4 != 0) goto L_0x0105
            goto L_0x0479
        L_0x0105:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0487 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzV(r4)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0487 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzt.zzR(r5)     // Catch:{ all -> 0x0487 }
            r6 = 0
            r6 = r4[r6]     // Catch:{ all -> 0x0487 }
            r7 = 1
            r4 = r4[r7]     // Catch:{ all -> 0x0487 }
            int r8 = r1.zzh     // Catch:{ all -> 0x0487 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = 50
            if (r8 < r13) goto L_0x0263
            if (r8 <= r6) goto L_0x012b
            goto L_0x0263
        L_0x012b:
            int r15 = r1.zze     // Catch:{ all -> 0x0487 }
            if (r15 < r13) goto L_0x025d
            if (r15 <= r4) goto L_0x0133
            goto L_0x025d
        L_0x0133:
            if (r15 != r4) goto L_0x013e
            if (r8 != r6) goto L_0x013e
            java.lang.String r4 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0487 }
            goto L_0x0268
        L_0x013e:
            boolean r4 = r1.zzb     // Catch:{ all -> 0x0487 }
            if (r4 == 0) goto L_0x0219
            java.lang.String r4 = r1.zza     // Catch:{ all -> 0x0487 }
            int r16 = r4.hashCode()     // Catch:{ all -> 0x0487 }
            switch(r16) {
                case -1364013995: goto L_0x017e;
                case -1012429441: goto L_0x0174;
                case -655373719: goto L_0x016a;
                case 1163912186: goto L_0x0160;
                case 1288627767: goto L_0x0156;
                case 1755462605: goto L_0x014c;
                default: goto L_0x014b;
            }
        L_0x014b:
            goto L_0x0188
        L_0x014c:
            java.lang.String r14 = "top-center"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = r7
            goto L_0x0189
        L_0x0156:
            java.lang.String r14 = "bottom-center"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = r10
            goto L_0x0189
        L_0x0160:
            java.lang.String r14 = "bottom-right"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = r9
            goto L_0x0189
        L_0x016a:
            java.lang.String r14 = "bottom-left"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = r11
            goto L_0x0189
        L_0x0174:
            java.lang.String r14 = "top-left"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = 0
            goto L_0x0189
        L_0x017e:
            java.lang.String r14 = "center"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0188
            r4 = r12
            goto L_0x0189
        L_0x0188:
            r4 = -1
        L_0x0189:
            if (r4 == 0) goto L_0x01ed
            if (r4 == r7) goto L_0x01e1
            if (r4 == r12) goto L_0x01cb
            if (r4 == r11) goto L_0x01bb
            if (r4 == r10) goto L_0x01af
            if (r4 == r9) goto L_0x01a2
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r14 = r1.zzf     // Catch:{ all -> 0x0487 }
            r15 = -50
            int r4 = defpackage.C1058d.q(r4, r14, r8, r15)     // Catch:{ all -> 0x0487 }
        L_0x019f:
            int r8 = r1.zzd
            goto L_0x01f4
        L_0x01a2:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r14 = r1.zzf     // Catch:{ all -> 0x0487 }
            r9 = -50
            int r4 = defpackage.C1058d.q(r4, r14, r8, r9)     // Catch:{ all -> 0x0487 }
        L_0x01ac:
            int r8 = r1.zzd
            goto L_0x01c2
        L_0x01af:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r8 = r8 >> r7
            r14 = -25
            int r4 = defpackage.C1058d.q(r4, r9, r8, r14)     // Catch:{ all -> 0x0487 }
            goto L_0x01ac
        L_0x01bb:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r8 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r4 = r4 + r8
            int r8 = r1.zzd     // Catch:{ all -> 0x0487 }
        L_0x01c2:
            int r9 = r1.zzg     // Catch:{ all -> 0x0487 }
            r14 = -50
            int r8 = defpackage.C1058d.q(r8, r9, r15, r14)
            goto L_0x01f7
        L_0x01cb:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r8 = r8 >> r7
            r14 = -25
            int r4 = defpackage.C1058d.q(r4, r9, r8, r14)     // Catch:{ all -> 0x0487 }
            int r8 = r1.zzd
            int r9 = r1.zzg     // Catch:{ all -> 0x0487 }
            int r8 = r8 + r9
            int r9 = r15 >> 1
            int r8 = r8 + r9
            int r8 = r8 + -25
            goto L_0x01f7
        L_0x01e1:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r8 = r8 >> r7
            r14 = -25
            int r4 = defpackage.C1058d.q(r4, r9, r8, r14)     // Catch:{ all -> 0x0487 }
            goto L_0x019f
        L_0x01ed:
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r8 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r4 = r4 + r8
            int r8 = r1.zzd     // Catch:{ all -> 0x0487 }
        L_0x01f4:
            int r9 = r1.zzg     // Catch:{ all -> 0x0487 }
            int r8 = r8 + r9
        L_0x01f7:
            if (r4 < 0) goto L_0x0268
            int r4 = r4 + r13
            if (r4 > r6) goto L_0x0268
            r4 = 0
            r4 = r5[r4]     // Catch:{ all -> 0x0487 }
            if (r8 < r4) goto L_0x0268
            int r8 = r8 + r13
            r4 = r5[r7]     // Catch:{ all -> 0x0487 }
            if (r8 <= r4) goto L_0x0207
            goto L_0x0268
        L_0x0207:
            int[] r14 = new int[r12]     // Catch:{ all -> 0x0487 }
            int r4 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r4 = r4 + r5
            r5 = 0
            r14[r5] = r4     // Catch:{ all -> 0x0487 }
            int r4 = r1.zzd     // Catch:{ all -> 0x0487 }
            int r5 = r1.zzg     // Catch:{ all -> 0x0487 }
            int r4 = r4 + r5
            r14[r7] = r4     // Catch:{ all -> 0x0487 }
            goto L_0x0269
        L_0x0219:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0487 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzV(r4)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0487 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzt.zzR(r5)     // Catch:{ all -> 0x0487 }
            r6 = 0
            r4 = r4[r6]     // Catch:{ all -> 0x0487 }
            int r6 = r1.zzc     // Catch:{ all -> 0x0487 }
            int r8 = r1.zzf     // Catch:{ all -> 0x0487 }
            int r6 = r6 + r8
            int r8 = r1.zzd     // Catch:{ all -> 0x0487 }
            int r9 = r1.zzg     // Catch:{ all -> 0x0487 }
            int r8 = r8 + r9
            if (r6 >= 0) goto L_0x023c
            r6 = 0
            goto L_0x0244
        L_0x023c:
            int r9 = r1.zzh     // Catch:{ all -> 0x0487 }
            int r14 = r6 + r9
            if (r14 <= r4) goto L_0x0244
            int r6 = r4 - r9
        L_0x0244:
            r4 = 0
            r4 = r5[r4]     // Catch:{ all -> 0x0487 }
            if (r8 >= r4) goto L_0x024b
            r8 = r4
            goto L_0x0255
        L_0x024b:
            int r4 = r1.zze     // Catch:{ all -> 0x0487 }
            int r9 = r8 + r4
            r5 = r5[r7]     // Catch:{ all -> 0x0487 }
            if (r9 <= r5) goto L_0x0255
            int r8 = r5 - r4
        L_0x0255:
            int[] r14 = new int[r12]     // Catch:{ all -> 0x0487 }
            r4 = 0
            r14[r4] = r6     // Catch:{ all -> 0x0487 }
            r14[r7] = r8     // Catch:{ all -> 0x0487 }
            goto L_0x0269
        L_0x025d:
            java.lang.String r4 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0487 }
            goto L_0x0268
        L_0x0263:
            java.lang.String r4 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0487 }
        L_0x0268:
            r14 = 0
        L_0x0269:
            if (r14 != 0) goto L_0x0272
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0272:
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0487 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0487 }
            int r5 = r1.zzh     // Catch:{ all -> 0x0487 }
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r4, r5)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0487 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0487 }
            int r6 = r1.zze     // Catch:{ all -> 0x0487 }
            int r5 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r5, r6)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzj     // Catch:{ all -> 0x0487 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0487 }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x0487 }
            if (r6 == 0) goto L_0x0472
            boolean r8 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0487 }
            if (r8 == 0) goto L_0x0472
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r8 = r1.zzj     // Catch:{ all -> 0x0487 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0487 }
            r6.removeView(r8)     // Catch:{ all -> 0x0487 }
            android.widget.PopupWindow r8 = r1.zzp     // Catch:{ all -> 0x0487 }
            if (r8 != 0) goto L_0x02dd
            r1.zzr = r6     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzj     // Catch:{ all -> 0x0487 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0487 }
            r8.setDrawingCacheEnabled(r7)     // Catch:{ all -> 0x0487 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0487 }
            android.graphics.Bitmap r8 = r8.getDrawingCache()     // Catch:{ all -> 0x0487 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ all -> 0x0487 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0487 }
            r9 = 0
            r6.setDrawingCacheEnabled(r9)     // Catch:{ all -> 0x0487 }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x0487 }
            android.app.Activity r9 = r1.zzk     // Catch:{ all -> 0x0487 }
            r6.<init>(r9)     // Catch:{ all -> 0x0487 }
            r1.zzm = r6     // Catch:{ all -> 0x0487 }
            r6.setImageBitmap(r8)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzj     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcgd r6 = r6.zzO()     // Catch:{ all -> 0x0487 }
            r1.zzl = r6     // Catch:{ all -> 0x0487 }
            android.view.ViewGroup r6 = r1.zzr     // Catch:{ all -> 0x0487 }
            android.widget.ImageView r8 = r1.zzm     // Catch:{ all -> 0x0487 }
            r6.addView(r8)     // Catch:{ all -> 0x0487 }
            goto L_0x02e0
        L_0x02dd:
            r8.dismiss()     // Catch:{ all -> 0x0487 }
        L_0x02e0:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0487 }
            android.app.Activity r8 = r1.zzk     // Catch:{ all -> 0x0487 }
            r6.<init>(r8)     // Catch:{ all -> 0x0487 }
            r1.zzq = r6     // Catch:{ all -> 0x0487 }
            r8 = 0
            r6.setBackgroundColor(r8)     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout r6 = r1.zzq     // Catch:{ all -> 0x0487 }
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0487 }
            r8.<init>(r4, r5)     // Catch:{ all -> 0x0487 }
            r6.setLayoutParams(r8)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout r6 = r1.zzq     // Catch:{ all -> 0x0487 }
            android.widget.PopupWindow r8 = new android.widget.PopupWindow     // Catch:{ all -> 0x0487 }
            r9 = 0
            r8.<init>(r6, r4, r5, r9)     // Catch:{ all -> 0x0487 }
            r1.zzp = r8     // Catch:{ all -> 0x0487 }
            r8.setOutsideTouchable(r9)     // Catch:{ all -> 0x0487 }
            android.widget.PopupWindow r6 = r1.zzp     // Catch:{ all -> 0x0487 }
            r6.setTouchable(r7)     // Catch:{ all -> 0x0487 }
            android.widget.PopupWindow r6 = r1.zzp     // Catch:{ all -> 0x0487 }
            boolean r8 = r1.zzb     // Catch:{ all -> 0x0487 }
            r8 = r8 ^ r7
            r6.setClippingEnabled(r8)     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout r6 = r1.zzq     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r8 = r1.zzj     // Catch:{ all -> 0x0487 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0487 }
            r9 = -1
            r6.addView(r8, r9, r9)     // Catch:{ all -> 0x0487 }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x0487 }
            android.app.Activity r8 = r1.zzk     // Catch:{ all -> 0x0487 }
            r6.<init>(r8)     // Catch:{ all -> 0x0487 }
            r1.zzn = r6     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0487 }
            android.app.Activity r8 = r1.zzk     // Catch:{ all -> 0x0487 }
            int r8 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r8, r13)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0487 }
            android.app.Activity r15 = r1.zzk     // Catch:{ all -> 0x0487 }
            int r13 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r15, r13)     // Catch:{ all -> 0x0487 }
            r6.<init>(r8, r13)     // Catch:{ all -> 0x0487 }
            java.lang.String r8 = r1.zza     // Catch:{ all -> 0x0487 }
            int r13 = r8.hashCode()     // Catch:{ all -> 0x0487 }
            switch(r13) {
                case -1364013995: goto L_0x037a;
                case -1012429441: goto L_0x0370;
                case -655373719: goto L_0x0366;
                case 1163912186: goto L_0x035c;
                case 1288627767: goto L_0x0352;
                case 1755462605: goto L_0x0348;
                default: goto L_0x0347;
            }
        L_0x0347:
            goto L_0x0383
        L_0x0348:
            java.lang.String r13 = "top-center"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = r7
            goto L_0x0383
        L_0x0352:
            java.lang.String r13 = "bottom-center"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = r10
            goto L_0x0383
        L_0x035c:
            java.lang.String r13 = "bottom-right"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = 5
            goto L_0x0383
        L_0x0366:
            java.lang.String r13 = "bottom-left"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = r11
            goto L_0x0383
        L_0x0370:
            java.lang.String r13 = "top-left"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = 0
            goto L_0x0383
        L_0x037a:
            java.lang.String r13 = "center"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x0383
            r9 = r12
        L_0x0383:
            r8 = 9
            r13 = 10
            if (r9 == 0) goto L_0x03c3
            r15 = 14
            if (r9 == r7) goto L_0x03bc
            if (r9 == r12) goto L_0x03b6
            r12 = 12
            if (r9 == r11) goto L_0x03af
            if (r9 == r10) goto L_0x03a8
            r8 = 11
            r10 = 5
            if (r9 == r10) goto L_0x03a1
            r6.addRule(r13)     // Catch:{ all -> 0x0487 }
            r6.addRule(r8)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03a1:
            r6.addRule(r12)     // Catch:{ all -> 0x0487 }
            r6.addRule(r8)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03a8:
            r6.addRule(r12)     // Catch:{ all -> 0x0487 }
            r6.addRule(r15)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03af:
            r6.addRule(r12)     // Catch:{ all -> 0x0487 }
            r6.addRule(r8)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03b6:
            r8 = 13
            r6.addRule(r8)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03bc:
            r6.addRule(r13)     // Catch:{ all -> 0x0487 }
            r6.addRule(r15)     // Catch:{ all -> 0x0487 }
            goto L_0x03c9
        L_0x03c3:
            r6.addRule(r13)     // Catch:{ all -> 0x0487 }
            r6.addRule(r8)     // Catch:{ all -> 0x0487 }
        L_0x03c9:
            android.widget.LinearLayout r8 = r1.zzn     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzbrj r9 = new com.google.android.gms.internal.ads.zzbrj     // Catch:{ all -> 0x0487 }
            r9.<init>(r1)     // Catch:{ all -> 0x0487 }
            r8.setOnClickListener(r9)     // Catch:{ all -> 0x0487 }
            android.widget.LinearLayout r8 = r1.zzn     // Catch:{ all -> 0x0487 }
            java.lang.String r9 = "Close button"
            r8.setContentDescription(r9)     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout r8 = r1.zzq     // Catch:{ all -> 0x0487 }
            android.widget.LinearLayout r9 = r1.zzn     // Catch:{ all -> 0x0487 }
            r8.addView(r9, r6)     // Catch:{ all -> 0x0487 }
            android.widget.PopupWindow r6 = r1.zzp     // Catch:{ RuntimeException -> 0x043a }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x043a }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x043a }
            android.app.Activity r8 = r1.zzk     // Catch:{ RuntimeException -> 0x043a }
            r9 = 0
            r9 = r14[r9]     // Catch:{ RuntimeException -> 0x043a }
            int r8 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r8, r9)     // Catch:{ RuntimeException -> 0x043a }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x043a }
            android.app.Activity r9 = r1.zzk     // Catch:{ RuntimeException -> 0x043a }
            r10 = r14[r7]     // Catch:{ RuntimeException -> 0x043a }
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r10)     // Catch:{ RuntimeException -> 0x043a }
            r10 = 0
            r6.showAtLocation(r0, r10, r8, r9)     // Catch:{ RuntimeException -> 0x043a }
            r0 = r14[r10]     // Catch:{ all -> 0x0487 }
            r2 = r14[r7]     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzbrr r6 = r1.zzo     // Catch:{ all -> 0x0487 }
            if (r6 == 0) goto L_0x0411
            int r8 = r1.zzh     // Catch:{ all -> 0x0487 }
            int r9 = r1.zze     // Catch:{ all -> 0x0487 }
            r6.zza(r0, r2, r8, r9)     // Catch:{ all -> 0x0487 }
        L_0x0411:
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzj     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcgd r2 = com.google.android.gms.internal.ads.zzcgd.zzb(r4, r5)     // Catch:{ all -> 0x0487 }
            r0.zzaj(r2)     // Catch:{ all -> 0x0487 }
            r0 = 0
            r0 = r14[r0]     // Catch:{ all -> 0x0487 }
            r2 = r14[r7]     // Catch:{ all -> 0x0487 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0487 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0487 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzR(r4)     // Catch:{ all -> 0x0487 }
            r5 = 0
            r4 = r4[r5]     // Catch:{ all -> 0x0487 }
            int r2 = r2 - r4
            int r4 = r1.zzh     // Catch:{ all -> 0x0487 }
            int r5 = r1.zze     // Catch:{ all -> 0x0487 }
            r1.zzk(r0, r2, r4, r5)     // Catch:{ all -> 0x0487 }
            java.lang.String r0 = "resized"
            r1.zzl(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x043a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0487 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0487 }
            r4.<init>(r2)     // Catch:{ all -> 0x0487 }
            r4.append(r0)     // Catch:{ all -> 0x0487 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0487 }
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            android.widget.RelativeLayout r0 = r1.zzq     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r2 = r1.zzj     // Catch:{ all -> 0x0487 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0487 }
            r0.removeView(r2)     // Catch:{ all -> 0x0487 }
            android.view.ViewGroup r0 = r1.zzr     // Catch:{ all -> 0x0487 }
            if (r0 == 0) goto L_0x0470
            android.widget.ImageView r2 = r1.zzm     // Catch:{ all -> 0x0487 }
            r0.removeView(r2)     // Catch:{ all -> 0x0487 }
            android.view.ViewGroup r0 = r1.zzr     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r2 = r1.zzj     // Catch:{ all -> 0x0487 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0487 }
            r0.addView(r2)     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzj     // Catch:{ all -> 0x0487 }
            com.google.android.gms.internal.ads.zzcgd r2 = r1.zzl     // Catch:{ all -> 0x0487 }
            r0.zzaj(r2)     // Catch:{ all -> 0x0487 }
        L_0x0470:
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0472:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0479:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0480:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0487 }
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            return
        L_0x0487:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0487 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrk.zzb(java.util.Map):void");
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzi) {
            if (this.zzp != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
