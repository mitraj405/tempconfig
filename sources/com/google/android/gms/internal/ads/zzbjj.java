package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogCategory;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbjj implements zzbix {
    private final zzb zza;
    private final zzdsk zzb;
    private final zzr zzc;
    private final zzbrk zzd;
    private final zzedh zze;
    private final zzcni zzf;
    private zzy zzg = null;
    private final zzgcu zzh = zzbzo.zzf;

    public zzbjj(zzb zzb2, zzbrk zzbrk, zzedh zzedh, zzdsk zzdsk, zzcni zzcni) {
        this.zza = zzb2;
        this.zzd = zzbrk;
        this.zze = zzedh;
        this.zzb = zzdsk;
        this.zzc = new zzr((String) null);
        this.zzf = zzcni;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return 14;
        }
        return -1;
    }

    public static Uri zzc(Context context, zzauo zzauo, Uri uri, View view, Activity activity, zzffk zzffk) {
        if (zzauo == null) {
            return uri;
        }
        try {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzla)).booleanValue() || zzffk == null) {
                if (zzauo.zze(uri)) {
                    return zzauo.zza(uri, context, view, activity);
                }
                return uri;
            } else if (zzauo.zze(uri)) {
                return zzffk.zza(uri, context, view, activity);
            } else {
                return uri;
            }
        } catch (zzaup unused) {
            return uri;
        } catch (Exception e) {
            zzu.zzo().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    public static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzm.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return C0515Ga.AVLBLTY_ONLY.equals(map.get("custom_close"));
    }

    /* access modifiers changed from: private */
    public final void zzh(String str, zza zza2, Map map, String str2) {
        String str3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj;
        Object obj2;
        HashMap hashMap;
        boolean z6;
        String str4;
        boolean z7;
        zza zza3 = zza2;
        Map map2 = map;
        String str5 = str2;
        zzcej zzcej = (zzcej) zza3;
        zzfel zzD = zzcej.zzD();
        zzfeo zzR = zzcej.zzR();
        boolean z8 = false;
        if (zzD == null || zzR == null) {
            str3 = "";
            z = false;
        } else {
            String str6 = zzR.zzb;
            z = zzD.zzai;
            str3 = str6;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjP)).booleanValue() || !map2.containsKey("sc") || !((String) map2.get("sc")).equals("0")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzlM)).booleanValue() || !map2.containsKey("ig_cl") || !((String) map2.get("ig_cl")).equals("true")) {
            z3 = false;
        } else {
            z3 = true;
        }
        if ("expand".equalsIgnoreCase(str5)) {
            if (zzcej.zzaF()) {
                zzm.zzj("Cannot expand WebView that is already expanded.");
                return;
            }
            zzk(false);
            ((zzcft) zza3).zzaL(zzf(map), zzb(map), z2);
        } else if ("webapp".equalsIgnoreCase(str5)) {
            zzk(false);
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzkV)).booleanValue() || !Objects.equals(map2.get("is_allowed_for_lock_screen"), C0515Ga.AVLBLTY_ONLY)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (str != null) {
                ((zzcft) zza3).zzaN(zzf(map), zzb(map), str, z2, z7);
            } else {
                ((zzcft) zza3).zzaM(zzf(map), zzb(map), (String) map2.get("html"), (String) map2.get("baseurl"), z2);
            }
        } else if ("chrome_custom_tab".equalsIgnoreCase(str5)) {
            zzcej.getContext();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzeb)).booleanValue()) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzef)).booleanValue()) {
                    zze.zza("User opt out chrome custom tab.");
                } else {
                    z8 = true;
                }
            }
            boolean zzg2 = zzbct.zzg(zzcej.getContext());
            if (z8) {
                if (!zzg2) {
                    zzm(4);
                } else {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzm.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri zzd2 = zzd(zzc(zzcej.getContext(), zzcej.zzI(), Uri.parse(str), zzcej.zzF(), zzcej.zzi(), zzcej.zzS()));
                    if (!z || this.zze == null || !zzl(zza3, zzcej.getContext(), zzd2.toString(), str3)) {
                        this.zzg = new zzbjg(this);
                        ((zzcft) zza3).zzaJ(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z2, z3);
                        return;
                    }
                    return;
                }
            }
            map2.put("use_first_package", "true");
            map2.put("use_running_process", "true");
            zzj(zza2, map, z, str3, z2, z3);
        } else if ("app".equalsIgnoreCase(str5) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
            zzj(zza2, map, z, str3, z2, z3);
        } else if ("open_app".equalsIgnoreCase(str5)) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzht)).booleanValue()) {
                zzk(true);
                String str7 = (String) map2.get("p");
                if (str7 == null) {
                    zzm.zzj("Package name missing from open app action.");
                } else if (!z || this.zze == null || !zzl(zza3, zzcej.getContext(), str7, str3)) {
                    PackageManager packageManager = zzcej.getContext().getPackageManager();
                    if (packageManager == null) {
                        zzm.zzj("Cannot get package manager from open app action.");
                        return;
                    }
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str7);
                    if (launchIntentForPackage != null) {
                        ((zzcft) zza3).zzaJ(new zzc(launchIntentForPackage, this.zzg), z2, z3);
                    }
                }
            }
        } else {
            zzk(true);
            String str8 = (String) map2.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str8)) {
                try {
                    intent = Intent.parseUri(str8, 0);
                } catch (URISyntaxException e) {
                    zzm.zzh("Error parsing the url: ".concat(String.valueOf(str8)), e);
                }
            }
            Intent intent2 = intent;
            if (!(intent2 == null || intent2.getData() == null)) {
                Uri data = intent2.getData();
                if (!Uri.EMPTY.equals(data)) {
                    Uri zzd3 = zzd(zzc(zzcej.getContext(), zzcej.zzI(), data, zzcej.zzF(), zzcej.zzi(), zzcej.zzS()));
                    if (!TextUtils.isEmpty(intent2.getType())) {
                        if (((Boolean) zzba.zzc().zza(zzbbw.zzhu)).booleanValue()) {
                            intent2.setDataAndType(zzd3, intent2.getType());
                        }
                    }
                    intent2.setData(zzd3);
                }
            }
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzhM)).booleanValue() || !"intent_async".equalsIgnoreCase(str5) || !map2.containsKey("event_id")) {
                z4 = false;
            } else {
                z4 = true;
            }
            HashMap hashMap2 = new HashMap();
            if (z4) {
                zzbjh zzbjh = r1;
                boolean z9 = z2;
                HashMap hashMap3 = hashMap2;
                obj = "p";
                obj2 = "event_id";
                z5 = z3;
                hashMap = hashMap3;
                zzbjh zzbjh2 = new zzbjh(this, z9, zza2, hashMap3, map);
                this.zzg = zzbjh;
                z6 = false;
            } else {
                z5 = z3;
                obj = "p";
                hashMap = hashMap2;
                obj2 = "event_id";
                z6 = z2;
            }
            if (intent2 == null) {
                boolean z10 = z5;
                if (!TextUtils.isEmpty(str)) {
                    str4 = zzd(zzc(zzcej.getContext(), zzcej.zzI(), Uri.parse(str), zzcej.zzF(), zzcej.zzi(), zzcej.zzS())).toString();
                } else {
                    str4 = str;
                }
                if (!z || this.zze == null || !zzl(zza3, zzcej.getContext(), str4, str3)) {
                    ((zzcft) zza3).zzaJ(new zzc((String) map2.get("i"), str4, (String) map2.get("m"), (String) map2.get(obj), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzg), z6, z10);
                } else if (z4) {
                    hashMap.put((String) map2.get(obj2), Boolean.TRUE);
                    ((zzbls) zza3).zzd("openIntentAsync", hashMap);
                }
            } else if (!z || this.zze == null || !zzl(zza3, zzcej.getContext(), intent2.getData().toString(), str3)) {
                ((zzcft) zza3).zzaJ(new zzc(intent2, this.zzg), z6, z5);
            } else if (z4) {
                hashMap.put((String) map2.get(obj2), Boolean.TRUE);
                ((zzbls) zza3).zzd("openIntentAsync", hashMap);
            }
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzdsk zzdsk = this.zzb;
        if (zzdsk != null) {
            zzeds.zzd(context, zzdsk, this.zze, str, "dialog_not_shown", zzfxu.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: android.content.Intent} */
    /* JADX WARNING: type inference failed for: r16v1, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r16v6, types: [android.net.Uri] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0105, code lost:
        if (com.google.android.gms.internal.ads.zzbji.zzc(r2, r11, r12, r13, r14) == null) goto L_0x0107;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = 1
            r1.zzk(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcej r4 = (com.google.android.gms.internal.ads.zzcej) r4
            android.content.Context r11 = r4.getContext()
            com.google.android.gms.internal.ads.zzauo r12 = r4.zzI()
            android.view.View r13 = r4.zzF()
            com.google.android.gms.internal.ads.zzffk r14 = r4.zzS()
            java.lang.String r5 = "activity"
            java.lang.Object r5 = r11.getSystemService(r5)
            r15 = r5
            android.app.ActivityManager r15 = (android.app.ActivityManager) r15
            java.lang.String r5 = "u"
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r16 = 0
            if (r6 == 0) goto L_0x003a
        L_0x0036:
            r2 = r16
            goto L_0x016d
        L_0x003a:
            android.net.Uri r7 = android.net.Uri.parse(r5)
            r9 = 0
            r5 = r11
            r6 = r12
            r8 = r13
            r10 = r14
            android.net.Uri r5 = zzc(r5, r6, r7, r8, r9, r10)
            android.net.Uri r5 = zzd(r5)
            java.lang.String r6 = "use_first_package"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r17 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_running_process"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r18 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r10 = 0
            if (r2 != 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzdZ
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r6.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r3 = r10
        L_0x0086:
            java.lang.String r2 = r5.getScheme()
            java.lang.String r6 = "http"
            boolean r2 = r6.equalsIgnoreCase(r2)
            java.lang.String r7 = "https"
            if (r2 == 0) goto L_0x00a3
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r7)
            android.net.Uri r16 = r2.build()
        L_0x00a0:
            r2 = r16
            goto L_0x00ba
        L_0x00a3:
            java.lang.String r2 = r5.getScheme()
            boolean r2 = r7.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a0
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r6)
            android.net.Uri r16 = r2.build()
            goto L_0x00a0
        L_0x00ba:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.content.Intent r8 = com.google.android.gms.internal.ads.zzbji.zza(r5, r11, r12, r13, r14)
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzbji.zza(r2, r11, r12, r13, r14)
            if (r3 == 0) goto L_0x00d5
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r8)
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r2)
        L_0x00d5:
            r5 = r8
            r6 = r9
            r7 = r11
            r3 = r8
            r8 = r12
            r21 = r9
            r9 = r13
            r0 = r10
            r10 = r14
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzbji.zzd(r5, r6, r7, r8, r9, r10)
            if (r6 == 0) goto L_0x00f0
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbji.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x00f0:
            if (r2 == 0) goto L_0x0107
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzbji.zzc(r2, r11, r12, r13, r14)
            if (r6 == 0) goto L_0x0107
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzbji.zzb(r5, r6, r7, r8, r9, r10)
            android.content.pm.ResolveInfo r5 = com.google.android.gms.internal.ads.zzbji.zzc(r2, r11, r12, r13, r14)
            if (r5 != 0) goto L_0x016d
        L_0x0107:
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L_0x010f
            goto L_0x016c
        L_0x010f:
            if (r18 == 0) goto L_0x0156
            if (r15 == 0) goto L_0x0156
            java.util.List r2 = r15.getRunningAppProcesses()
            if (r2 == 0) goto L_0x0156
            int r5 = r21.size()
            r10 = r0
        L_0x011e:
            if (r10 >= r5) goto L_0x0156
            r6 = r21
            java.lang.Object r7 = r6.get(r10)
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            java.util.Iterator r8 = r2.iterator()
        L_0x012c:
            boolean r9 = r8.hasNext()
            int r15 = r10 + 1
            if (r9 == 0) goto L_0x0152
            java.lang.Object r9 = r8.next()
            android.app.ActivityManager$RunningAppProcessInfo r9 = (android.app.ActivityManager.RunningAppProcessInfo) r9
            java.lang.String r9 = r9.processName
            android.content.pm.ActivityInfo r15 = r7.activityInfo
            java.lang.String r15 = r15.packageName
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x012c
            r5 = r3
            r6 = r7
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbji.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x0152:
            r21 = r6
            r10 = r15
            goto L_0x011e
        L_0x0156:
            r6 = r21
            if (r17 == 0) goto L_0x016c
            java.lang.Object r0 = r6.get(r0)
            r6 = r0
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbji.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x016c:
            r2 = r3
        L_0x016d:
            if (r22 == 0) goto L_0x018d
            com.google.android.gms.internal.ads.zzedh r0 = r1.zze
            if (r0 == 0) goto L_0x018d
            if (r2 == 0) goto L_0x018d
            android.content.Context r0 = r4.getContext()
            android.net.Uri r3 = r2.getData()
            java.lang.String r3 = r3.toString()
            r4 = r20
            r5 = r23
            boolean r0 = r1.zzl(r4, r0, r3, r5)
            if (r0 != 0) goto L_0x018c
            goto L_0x018f
        L_0x018c:
            return
        L_0x018d:
            r4 = r20
        L_0x018f:
            r0 = r4
            com.google.android.gms.internal.ads.zzcft r0 = (com.google.android.gms.internal.ads.zzcft) r0     // Catch:{ ActivityNotFoundException -> 0x01a1 }
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x01a1 }
            com.google.android.gms.ads.internal.overlay.zzy r4 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x01a1 }
            r3.<init>(r2, r4)     // Catch:{ ActivityNotFoundException -> 0x01a1 }
            r2 = r24
            r4 = r25
            r0.zzaJ(r3, r2, r4)     // Catch:{ ActivityNotFoundException -> 0x01a1 }
            return
        L_0x01a1:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbrk zzbrk = this.zzd;
        if (zzbrk != null) {
            zzbrk.zza(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c3, code lost:
        if (r4 != false) goto L_0x00cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdsk r0 = r8.zzb
            if (r0 == 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzedh r1 = r8.zze
            java.lang.String r2 = "offline_open"
            com.google.android.gms.internal.ads.zzeds.zzc(r10, r0, r1, r12, r2)
        L_0x000b:
            com.google.android.gms.internal.ads.zzbze r0 = com.google.android.gms.ads.internal.zzu.zzo()
            boolean r0 = r0.zzA(r10)
            r1 = 0
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzedh r9 = r8.zze
            com.google.android.gms.ads.internal.util.client.zzr r10 = r8.zzc
            r9.zzh(r10, r12)
            return r1
        L_0x001e:
            r0 = r9
            com.google.android.gms.internal.ads.zzcej r0 = (com.google.android.gms.internal.ads.zzcej) r0
            com.google.android.gms.internal.ads.zzfel r2 = r0.zzD()
            r3 = 1
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzbst r2 = r2.zzad
            if (r2 == 0) goto L_0x003a
            boolean r4 = r2.zza
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = r2.zzb
            if (r4 == 0) goto L_0x003a
            boolean r2 = r2.zzc
            if (r2 == 0) goto L_0x003a
            r2 = r3
            goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzhJ
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005b
            if (r2 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzdsk r9 = r8.zzb
            if (r9 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzedh r11 = r8.zze
            java.lang.String r0 = "onfs"
            com.google.android.gms.internal.ads.zzeds.zzc(r10, r9, r11, r12, r0)
        L_0x005a:
            return r1
        L_0x005b:
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzbr r2 = com.google.android.gms.ads.internal.util.zzt.zzz(r10)
            com.google.android.gms.ads.internal.zzu.zzp()
            en r4 = new en
            r4.<init>(r10)
            boolean r4 = r4.a()
            java.lang.String r5 = "offline_notification_channel"
            com.google.android.gms.ads.internal.util.zzab r6 = com.google.android.gms.ads.internal.zzu.zzq()
            boolean r5 = r6.zzi(r10, r5)
            com.google.android.gms.internal.ads.zzcgd r6 = r0.zzO()
            boolean r6 = r6.zzi()
            if (r6 == 0) goto L_0x008a
            android.app.Activity r6 = r0.zzi()
            if (r6 != 0) goto L_0x008a
            r6 = r3
            goto L_0x008b
        L_0x008a:
            r6 = r1
        L_0x008b:
            if (r4 != 0) goto L_0x00cc
            com.google.android.gms.ads.internal.zzu.zzp()
            en r4 = new en
            r4.<init>(r10)
            boolean r4 = r4.a()
            if (r4 == 0) goto L_0x009c
            goto L_0x00c6
        L_0x009c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r7 = 33
            if (r4 >= r7) goto L_0x00b3
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzhE
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r7.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L_0x00c3
        L_0x00b3:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzhD
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r7.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
        L_0x00c3:
            if (r4 == 0) goto L_0x00c6
            goto L_0x00cc
        L_0x00c6:
            java.lang.String r9 = "notifications_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00cc:
            if (r5 == 0) goto L_0x00d4
            java.lang.String r9 = "notification_channel_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00d4:
            if (r2 != 0) goto L_0x00dc
            java.lang.String r9 = "work_manager_unavailable"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00dc:
            if (r6 == 0) goto L_0x00e4
            java.lang.String r9 = "ad_no_activity"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00e4:
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzhB
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00fc
            java.lang.String r9 = "notification_flow_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00fc:
            com.google.android.gms.ads.internal.overlay.zzm r2 = r0.zzL()
            if (r2 == 0) goto L_0x0132
            android.app.Activity r2 = r0.zzi()
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzedt r2 = com.google.android.gms.internal.ads.zzedu.zze()
            android.app.Activity r4 = r0.zzi()
            r2.zza(r4)
            r4 = 0
            r2.zzb(r4)
            r2.zzc(r12)
            r2.zzd(r11)
            com.google.android.gms.internal.ads.zzedu r11 = r2.zze()
            com.google.android.gms.ads.internal.overlay.zzm r0 = r0.zzL()     // Catch:{ Exception -> 0x0129 }
            r0.zzf(r11)     // Catch:{ Exception -> 0x0129 }
            goto L_0x013a
        L_0x0129:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            r8.zzi(r10, r12, r9)
            return r1
        L_0x0132:
            r10 = r9
            com.google.android.gms.internal.ads.zzcft r10 = (com.google.android.gms.internal.ads.zzcft) r10
            r0 = 14
            r10.zzaK(r12, r11, r0)
        L_0x013a:
            r9.onAdClicked()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzm(int i) {
        String str;
        zzdsk zzdsk = this.zzb;
        if (zzdsk != null) {
            zzdsj zza2 = zzdsk.zza();
            zza2.zzb(LogCategory.ACTION, "cct_action");
            switch (i) {
                case 2:
                    str = "CONTEXT_NOT_AN_ACTIVITY";
                    break;
                case 3:
                    str = "CONTEXT_NULL";
                    break;
                case 4:
                    str = "CCT_NOT_SUPPORTED";
                    break;
                case 5:
                    str = "CCT_READY_TO_OPEN";
                    break;
                case 6:
                    str = "ACTIVITY_NOT_FOUND";
                    break;
                case 7:
                    str = "EMPTY_URL";
                    break;
                case 8:
                    str = "UNKNOWN";
                    break;
                default:
                    str = "WRONG_EXP_SETUP";
                    break;
            }
            zza2.zzb("cct_open_status", str);
            zza2.zzf();
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ListenableFuture listenableFuture;
        zza zza2 = (zza) obj;
        String str = (String) map.get("u");
        Map hashMap = new HashMap();
        zzcej zzcej = (zzcej) zza2;
        if (zzcej.zzD() != null) {
            hashMap = zzcej.zzD().zzaw;
        }
        String zzc2 = zzbyc.zzc(str, zzcej.getContext(), true, hashMap);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzm.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue() || this.zzf == null || !zzcni.zzj(zzc2)) {
                listenableFuture = zzgcj.zzh(zzc2);
            } else {
                listenableFuture = this.zzf.zzb(zzc2, zzay.zze());
            }
            zzgcj.zzr(listenableFuture, new zzbjf(this, map, zza2, str2), this.zzh);
            return;
        }
        this.zza.zzb(zzc2);
    }
}
