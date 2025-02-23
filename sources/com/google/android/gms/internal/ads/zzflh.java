package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzflh {
    private final zzein zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfey zzf;
    private final zzfez zzg;
    private final Clock zzh;
    private final zzauo zzi;

    public zzflh(zzein zzein, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfey zzfey, zzfez zzfez, Clock clock, zzauo zzauo) {
        this.zza = zzein;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfey;
        this.zzg = zzfez;
        this.zzh = clock;
        this.zzi = zzauo;
    }

    public static final List zzf(int i, int i2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", lf.h("2.", i2)));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j, 10)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (zzl.zzk()) {
            return "fakeForAdDebugLog";
        }
        return str;
    }

    private static String zzj(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzfex zzfex, zzfel zzfel, List list) {
        return zzd(zzfex, zzfel, false, "", "", list);
    }

    public final List zzd(zzfex zzfex, zzfel zzfel, boolean z, String str, String str2, List list) {
        String str3;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            if (true != z) {
                str3 = "0";
            } else {
                str3 = C0515Ga.AVLBLTY_ONLY;
            }
            String zzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzfex.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzfel != null) {
                zzj = zzbyc.zzc(zzj(zzj(zzj(zzj, "@gw_qdata@", zzfel.zzy), "@gw_adnetid@", zzfel.zzx), "@gw_allocid@", zzfel.zzw), this.zze, zzfel.zzW, zzfel.zzaw);
            }
            String zzj2 = zzj(zzj(zzj(zzj(zzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdf)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean z4 = !TextUtils.isEmpty(str2);
            if (z3) {
                z2 = z4;
            } else if (!z4) {
                arrayList.add(zzj2);
            }
            if (this.zzi.zzf(Uri.parse(zzj2))) {
                Uri.Builder buildUpon = Uri.parse(zzj2).buildUpon();
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzj2 = buildUpon.build().toString();
            }
            arrayList.add(zzj2);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A[LOOP:0: B:12:0x005f->B:14:0x0065, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzfel r11, java.util.List r12, com.google.android.gms.internal.ads.zzbvn r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.common.util.Clock r1 = r10.zzh
            long r1 = r1.currentTimeMillis()
            java.lang.String r3 = r13.zzc()     // Catch:{ RemoteException -> 0x00b0 }
            int r13 = r13.zzb()     // Catch:{ RemoteException -> 0x00b0 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ RemoteException -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzdg
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzfez r4 = r10.zzg
            if (r4 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzfus r4 = com.google.android.gms.internal.ads.zzfus.zzc()
            goto L_0x003b
        L_0x0032:
            com.google.android.gms.internal.ads.zzfey r4 = r4.zza
            goto L_0x0037
        L_0x0035:
            com.google.android.gms.internal.ads.zzfey r4 = r10.zzf
        L_0x0037:
            com.google.android.gms.internal.ads.zzfus r4 = com.google.android.gms.internal.ads.zzfus.zzd(r4)
        L_0x003b:
            com.google.android.gms.internal.ads.zzflf r5 = new com.google.android.gms.internal.ads.zzflf
            r5.<init>()
            com.google.android.gms.internal.ads.zzfus r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzflg r7 = new com.google.android.gms.internal.ads.zzflg
            r7.<init>()
            com.google.android.gms.internal.ads.zzfus r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r12 = r12.iterator()
        L_0x005f:
            boolean r6 = r12.hasNext()
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r12.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzj(r6, r7, r13)
            java.lang.String r7 = r10.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzj(r6, r8, r7)
            android.content.Context r7 = r10.zze
            boolean r8 = r11.zzW
            java.util.Map r9 = r11.zzaw
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyc.zzc(r6, r7, r8, r9)
            r0.add(r6)
            goto L_0x005f
        L_0x00af:
            return r0
        L_0x00b0:
            r11 = move-exception
            java.lang.String r12 = "Unable to determine award type and amount."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r12, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzflh.zze(com.google.android.gms.internal.ads.zzfel, java.util.List, com.google.android.gms.internal.ads.zzbvn):java.util.List");
    }
}
