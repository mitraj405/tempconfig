package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdiw extends zzcru {
    private final Executor zzc;
    /* access modifiers changed from: private */
    public final zzdjb zzd;
    private final zzdjj zze;
    private final zzdkb zzf;
    private final zzdjg zzg;
    private final zzdjm zzh;
    private final zzhew zzi;
    private final zzhew zzj;
    private final zzhew zzk;
    private final zzhew zzl;
    private final zzhew zzm;
    /* access modifiers changed from: private */
    public zzdkx zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private final zzbxw zzr;
    private final zzauo zzs;
    private final VersionInfoParcel zzt;
    private final Context zzu;
    private final zzdiy zzv;
    private final zzemn zzw;
    /* access modifiers changed from: private */
    public final Map zzx = new HashMap();
    private final List zzy = new ArrayList();

    static {
        zzfxr.zzr("3010", "3008", "1005", "1009", "2011", "2007");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdiw(zzcrt zzcrt, Executor executor, zzdjb zzdjb, zzdjj zzdjj, zzdkb zzdkb, zzdjg zzdjg, zzdjm zzdjm, zzhew zzhew, zzhew zzhew2, zzhew zzhew3, zzhew zzhew4, zzhew zzhew5, zzbxw zzbxw, zzauo zzauo, VersionInfoParcel versionInfoParcel, Context context, zzdiy zzdiy, zzemn zzemn, zzaxy zzaxy) {
        super(zzcrt);
        this.zzc = executor;
        this.zzd = zzdjb;
        this.zze = zzdjj;
        this.zzf = zzdkb;
        this.zzg = zzdjg;
        this.zzh = zzdjm;
        this.zzi = zzhew;
        this.zzj = zzhew2;
        this.zzk = zzhew3;
        this.zzl = zzhew4;
        this.zzm = zzhew5;
        this.zzr = zzbxw;
        this.zzs = zzauo;
        this.zzt = versionInfoParcel;
        this.zzu = context;
        this.zzv = zzdiy;
        this.zzw = zzemn;
    }

    public static boolean zzX(View view) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjJ)).booleanValue()) {
            zzu.zzp();
            long zzw2 = zzt.zzw(view);
            if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                if (zzw2 >= ((long) ((Integer) zzba.zzc().zza(zzbbw.zzjK)).intValue())) {
                    return true;
                }
            }
            return false;
        } else if (!view.isShown() || !view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            return false;
        } else {
            return true;
        }
    }

    private final synchronized ImageView.ScaleType zzZ() {
        zzdkx zzdkx = this.zzn;
        if (zzdkx == null) {
            zzm.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj2 = zzdkx.zzj();
        if (zzj2 != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj2);
        }
        return zzdkb.zza;
    }

    private final void zzaa(String str, boolean z) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
            ListenableFuture zzw2 = this.zzd.zzw();
            if (zzw2 != null) {
                zzgcj.zzr(zzw2, new zzdiu(this, "Google", true), this.zzc);
                return;
            }
            return;
        }
        zzf("Google", true);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzf.zzd(this.zzn);
        this.zze.zzq(view, map, map2, zzZ());
        this.zzp = true;
    }

    /* access modifiers changed from: private */
    public final void zzac(View view, zzeeo zzeeo) {
        zzcej zzr2 = this.zzd.zzr();
        if (this.zzg.zzd() && zzeeo != null && zzr2 != null && view != null) {
            zzu.zzA().zzj(zzeeo.zza(), view);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b3, code lost:
        return;
     */
    /* renamed from: zzad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz(com.google.android.gms.internal.ads.zzdkx r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzo     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x0007
            goto L_0x00b2
        L_0x0007:
            r7.zzn = r8     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzdkb r0 = r7.zzf     // Catch:{ all -> 0x00b4 }
            r0.zze(r8)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzdjj r1 = r7.zze     // Catch:{ all -> 0x00b4 }
            android.view.View r2 = r8.zzf()     // Catch:{ all -> 0x00b4 }
            java.util.Map r3 = r8.zzm()     // Catch:{ all -> 0x00b4 }
            java.util.Map r4 = r8.zzn()     // Catch:{ all -> 0x00b4 }
            r5 = r8
            r6 = r8
            r1.zzy(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzcq     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b4 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b4 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzauo r0 = r7.zzs     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzauk r0 = r0.zzc()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x0042
            android.view.View r1 = r8.zzf()     // Catch:{ all -> 0x00b4 }
            r0.zzo(r1)     // Catch:{ all -> 0x00b4 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbA     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b4 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b4 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzfel r0 = r7.zzb     // Catch:{ all -> 0x00b4 }
            boolean r1 = r0.zzak     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x005b
            goto L_0x00a1
        L_0x005b:
            org.json.JSONObject r0 = r0.zzaj     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r0 = r0.keys()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x00a1
        L_0x0063:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00a1
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzdkx r2 = r7.zzn     // Catch:{ all -> 0x00b4 }
            java.util.Map r2 = r2.zzl()     // Catch:{ all -> 0x00b4 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x00b4 }
            java.util.Map r3 = r7.zzx     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            r3.put(r1, r4)     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x0063
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00b4 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x0063
            android.content.Context r3 = r7.zzu     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzaxx r4 = new com.google.android.gms.internal.ads.zzaxx     // Catch:{ all -> 0x00b4 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x00b4 }
            java.util.List r2 = r7.zzy     // Catch:{ all -> 0x00b4 }
            r2.add(r4)     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzdit r2 = new com.google.android.gms.internal.ads.zzdit     // Catch:{ all -> 0x00b4 }
            r2.<init>(r7, r1)     // Catch:{ all -> 0x00b4 }
            r4.zzc(r2)     // Catch:{ all -> 0x00b4 }
            goto L_0x0063
        L_0x00a1:
            com.google.android.gms.internal.ads.zzaxx r0 = r8.zzi()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzaxx r8 = r8.zzi()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.internal.ads.zzbxw r0 = r7.zzr     // Catch:{ all -> 0x00b4 }
            r8.zzc(r0)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r7)
            return
        L_0x00b2:
            monitor-exit(r7)
            return
        L_0x00b4:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdiw.zzz(com.google.android.gms.internal.ads.zzdkx):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzA(zzdkx zzdkx) {
        this.zze.zzz(zzdkx.zzf(), zzdkx.zzl());
        if (zzdkx.zzh() != null) {
            zzdkx.zzh().setClickable(false);
            zzdkx.zzh().removeAllViews();
        }
        if (zzdkx.zzi() != null) {
            zzdkx.zzi().zze(this.zzr);
        }
        this.zzn = null;
    }

    public static /* synthetic */ void zzl(zzdiw zzdiw) {
        try {
            zzdjb zzdjb = zzdiw.zzd;
            int zzc2 = zzdjb.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzm.zzg("Wrong native template id!");
                                return;
                            }
                            zzdjm zzdjm = zzdiw.zzh;
                            if (zzdjm.zzg() != null) {
                                zzdjm.zzg().zzg((zzblk) zzdiw.zzl.zzb());
                            }
                        } else if (zzdiw.zzh.zzf() != null) {
                            zzdiw.zzaa("Google", true);
                            zzdiw.zzh.zzf().zze((zzbha) zzdiw.zzk.zzb());
                        }
                    } else if (zzdiw.zzh.zzd(zzdjb.zzA()) != null) {
                        if (zzdiw.zzd.zzs() != null) {
                            zzdiw.zzf("Google", true);
                        }
                        zzdiw.zzh.zzd(zzdiw.zzd.zzA()).zze((zzbfx) zzdiw.zzm.zzb());
                    }
                } else if (zzdiw.zzh.zza() != null) {
                    zzdiw.zzaa("Google", true);
                    zzdiw.zzh.zza().zze((zzbfs) zzdiw.zzj.zzb());
                }
            } else if (zzdiw.zzh.zzb() != null) {
                zzdiw.zzaa("Google", true);
                zzdiw.zzh.zzb().zze((zzbfu) zzdiw.zzi.zzb());
            }
        } catch (RemoteException e) {
            zzm.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzp     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0007
            goto L_0x0087
        L_0x0007:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbA     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzfel r0 = r3.zzb     // Catch:{ all -> 0x008e }
            boolean r0 = r0.zzak     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            java.util.Map r0 = r3.zzx     // Catch:{ all -> 0x008e }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x008e }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x008e }
            java.util.Map r2 = r3.zzx     // Catch:{ all -> 0x008e }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x008e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0029
            goto L_0x0087
        L_0x0044:
            if (r7 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzbbn r7 = com.google.android.gms.internal.ads.zzbbw.zzdy     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r7 = r0.zza(r7)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x008e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x0087
            if (r5 == 0) goto L_0x0087
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x008e }
        L_0x0062:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x008e }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x008e }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x008e }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            boolean r0 = zzX(r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x0087:
            monitor-exit(r3)
            return
        L_0x0089:
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x008e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdiw.zzB(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzC(zzcw zzcw) {
        this.zze.zzj(zzcw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzD(android.view.View r10, android.view.View r11, java.util.Map r12, java.util.Map r13, boolean r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzdkb r0 = r9.zzf     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdkx r1 = r9.zzn     // Catch:{ all -> 0x0035 }
            r0.zzc(r1)     // Catch:{ all -> 0x0035 }
            android.widget.ImageView$ScaleType r8 = r9.zzZ()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdjj r2 = r9.zze     // Catch:{ all -> 0x0035 }
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.zzk(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0035 }
            boolean r10 = r9.zzq     // Catch:{ all -> 0x0035 }
            if (r10 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzdjb r10 = r9.zzd     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcej r11 = r10.zzs()     // Catch:{ all -> 0x0035 }
            if (r11 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            com.google.android.gms.internal.ads.zzcej r10 = r10.zzs()     // Catch:{ all -> 0x0035 }
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0035 }
            r11.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r12 = "onSdkAdUserInteractionClick"
            r10.zzd(r12, r11)     // Catch:{ all -> 0x0035 }
            monitor-exit(r9)
            return
        L_0x0033:
            monitor-exit(r9)
            return
        L_0x0035:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdiw.zzD(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzE(View view, int i) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkE)).booleanValue()) {
            zzdkx zzdkx = this.zzn;
            if (zzdkx == null) {
                zzm.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                this.zzc.execute(new zzdiq(this, view, zzdkx instanceof zzdjv, i));
            }
        }
    }

    public final synchronized void zzF(String str) {
        this.zze.zzl(str);
    }

    public final synchronized void zzG(Bundle bundle) {
        this.zze.zzm(bundle);
    }

    public final synchronized void zzH() {
        zzdkx zzdkx = this.zzn;
        if (zzdkx == null) {
            zzm.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzc.execute(new zzdis(this, zzdkx instanceof zzdjv));
        }
    }

    public final synchronized void zzI() {
        if (!this.zzp) {
            this.zze.zzr();
        }
    }

    public final void zzJ(View view) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
            zzbzt zzp2 = this.zzd.zzp();
            if (zzp2 != null) {
                zzgcj.zzr(zzp2, new zzdiv(this, view), this.zzc);
                return;
            }
            return;
        }
        zzac(view, this.zzd.zzu());
    }

    public final synchronized void zzK(View view, MotionEvent motionEvent, View view2) {
        this.zze.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzL(Bundle bundle) {
        this.zze.zzt(bundle);
    }

    public final synchronized void zzM(View view) {
        this.zze.zzu(view);
    }

    public final synchronized void zzN() {
        this.zze.zzv();
    }

    public final synchronized void zzO(zzcs zzcs) {
        this.zze.zzw(zzcs);
    }

    public final synchronized void zzP(zzdg zzdg) {
        this.zzw.zza(zzdg);
    }

    public final synchronized void zzQ(zzbgx zzbgx) {
        this.zze.zzx(zzbgx);
    }

    public final synchronized void zzR(zzdkx zzdkx) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzby)).booleanValue()) {
            zzt.zza.post(new zzdim(this, zzdkx));
        } else {
            zzz(zzdkx);
        }
    }

    public final synchronized void zzS(zzdkx zzdkx) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzby)).booleanValue()) {
            zzt.zza.post(new zzdin(this, zzdkx));
        } else {
            zzA(zzdkx);
        }
    }

    public final boolean zzT() {
        return this.zzg.zze();
    }

    public final synchronized boolean zzU() {
        return this.zze.zzA();
    }

    public final synchronized boolean zzV() {
        return this.zze.zzB();
    }

    public final boolean zzW() {
        return this.zzg.zzd();
    }

    public final synchronized boolean zzY(Bundle bundle) {
        if (this.zzp) {
            return true;
        }
        boolean zzC = this.zze.zzC(bundle);
        this.zzp = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zze.zza();
    }

    public final synchronized void zzb() {
        this.zzo = true;
        this.zzc.execute(new zzdir(this));
        super.zzb();
    }

    public final zzdiy zzc() {
        return this.zzv;
    }

    public final zzeeo zzf(String str, boolean z) {
        boolean z2;
        boolean z3;
        String str2;
        zzeek zzeek;
        zzeel zzeel;
        zzeel zzeel2;
        String str3;
        if (!this.zzg.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdjb zzdjb = this.zzd;
        zzcej zzr2 = zzdjb.zzr();
        zzcej zzs2 = zzdjb.zzs();
        if (zzr2 == null && zzs2 == null) {
            zzm.zzj("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z4 = false;
        if (zzr2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (zzs2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeF)).booleanValue()) {
            this.zzg.zza();
            int zzc2 = this.zzg.zza().zzc();
            int i = zzc2 - 1;
            if (i != 0) {
                if (i != 1) {
                    if (zzc2 == 1) {
                        str3 = "VIDEO";
                    } else if (zzc2 != 2) {
                        str3 = "UNKNOWN";
                    } else {
                        str3 = "DISPLAY";
                    }
                    zzm.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                    return null;
                } else if (zzr2 != null) {
                    z3 = false;
                    z4 = true;
                } else {
                    zzm.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
            } else if (zzs2 != null) {
                z3 = true;
            } else {
                zzm.zzj("Omid media type was video but there was no video webview.");
                return null;
            }
        } else {
            z4 = z2;
        }
        if (z4) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzr2 = zzs2;
        }
        zzr2.zzG();
        if (!zzu.zzA().zzl(this.zzu)) {
            zzm.zzj("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        VersionInfoParcel versionInfoParcel = this.zzt;
        String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
        if (z3) {
            zzeek = zzeek.VIDEO;
            zzeel = zzeel.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdjb zzdjb2 = this.zzd;
            zzeek zzeek2 = zzeek.NATIVE_DISPLAY;
            if (zzdjb2.zzc() == 3) {
                zzeel2 = zzeel.UNSPECIFIED;
            } else {
                zzeel2 = zzeel.ONE_PIXEL;
            }
            zzeel = zzeel2;
            zzeek = zzeek2;
        }
        zzeeo zzb = zzu.zzA().zzb(str4, zzr2.zzG(), "", "javascript", str2, str, zzeel, zzeek, this.zzb.zzal);
        if (zzb == null) {
            zzm.zzj("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zzd.zzW(zzb);
        zzr2.zzat(zzb);
        if (z3) {
            zzu.zzA().zzj(zzb.zza(), zzs2.zzF());
            this.zzq = true;
        }
        if (z) {
            zzu.zzA().zzk(zzb.zza());
            zzr2.zzd("onSdkLoaded", new ArrayMap());
        }
        return zzb;
    }

    public final String zzg() {
        return this.zzg.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zze.zze(view, map, map2, zzZ());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zze.zzf(view, map, map2, zzZ());
    }

    public final void zzk() {
        this.zzc.execute(new zzdio(this));
        if (this.zzd.zzc() != 7) {
            Executor executor = this.zzc;
            zzdjj zzdjj = this.zze;
            Objects.requireNonNull(zzdjj);
            executor.execute(new zzdip(zzdjj));
        }
        super.zzk();
    }

    public final void zzu(View view) {
        zzeeo zzu2 = this.zzd.zzu();
        if (this.zzg.zzd() && zzu2 != null && view != null) {
            zzu.zzA().zzg(zzu2.zza(), view);
        }
    }

    public final synchronized void zzv() {
        this.zze.zzh();
    }

    public final /* synthetic */ void zzw() {
        this.zze.zzi();
        this.zzd.zzI();
    }

    public final /* synthetic */ void zzx(View view, boolean z, int i) {
        this.zze.zzo(view, this.zzn.zzf(), this.zzn.zzl(), this.zzn.zzm(), z, zzZ(), i);
    }

    public final /* synthetic */ void zzy(boolean z) {
        this.zze.zzo((View) null, this.zzn.zzf(), this.zzn.zzl(), this.zzn.zzm(), z, zzZ(), 0);
    }
}
