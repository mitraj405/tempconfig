package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfn;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzy {
    private zzfn.zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzu zzd;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfn.zzf zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzfn.zzf r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            java.lang.String r9 = r19.zzg()
            java.util.List r10 = r19.zzh()
            com.google.android.gms.measurement.internal.zzu r2 = r1.zzd
            r2.g_()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zznl.zzb(r8, r2)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            r3 = 1
            r5 = 0
            if (r4 == 0) goto L_0x0022
            r6 = r3
            goto L_0x0023
        L_0x0022:
            r6 = r5
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            java.lang.String r7 = "_ep"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x002f
            r7 = r3
            goto L_0x0030
        L_0x002f:
            r7 = r5
        L_0x0030:
            r11 = 0
            if (r7 == 0) goto L_0x0147
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.measurement.internal.zzu r6 = r1.zzd
            r6.g_()
            java.lang.String r6 = "_en"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zznl.zzb(r8, r6)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            r7 = 0
            if (r6 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzu r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzm()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zza(r2, r4)
            return r7
        L_0x005c:
            com.google.android.gms.internal.measurement.zzfn$zzf r6 = r1.zza
            if (r6 == 0) goto L_0x0072
            java.lang.Long r6 = r1.zzb
            if (r6 == 0) goto L_0x0072
            long r13 = r4.longValue()
            java.lang.Long r6 = r1.zzb
            long r15 = r6.longValue()
            int r6 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x00a1
        L_0x0072:
            com.google.android.gms.measurement.internal.zzu r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r6 = r6.zzh()
            android.util.Pair r6 = r6.zza((java.lang.String) r0, (java.lang.Long) r4)
            if (r6 == 0) goto L_0x0137
            java.lang.Object r13 = r6.first
            if (r13 != 0) goto L_0x0084
            goto L_0x0137
        L_0x0084:
            com.google.android.gms.internal.measurement.zzfn$zzf r13 = (com.google.android.gms.internal.measurement.zzfn.zzf) r13
            r1.zza = r13
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r1.zzc = r6
            com.google.android.gms.measurement.internal.zzu r6 = r1.zzd
            r6.g_()
            com.google.android.gms.internal.measurement.zzfn$zzf r6 = r1.zza
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zznl.zzb(r6, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r1.zzb = r2
        L_0x00a1:
            long r6 = r1.zzc
            r13 = 1
            long r6 = r6 - r13
            r1.zzc = r6
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzu r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r2.zzh()
            r2.zzt()
            com.google.android.gms.measurement.internal.zzfw r4 = r2.zzj()
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzp()
            java.lang.String r6 = "Clearing complex main event info. appId"
            r4.zza(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r2.e_()     // Catch:{ SQLiteException -> 0x00d0 }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00d0 }
            r3[r5] = r0     // Catch:{ SQLiteException -> 0x00d0 }
            r4.execSQL(r6, r3)     // Catch:{ SQLiteException -> 0x00d0 }
            goto L_0x00ee
        L_0x00d0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x00ee
        L_0x00df:
            com.google.android.gms.measurement.internal.zzu r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r2.zzh()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzfn$zzf r7 = r1.zza
            r3 = r18
            r2.zza(r3, r4, r5, r7)
        L_0x00ee:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = r1.zza
            java.util.List r2 = r2.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x00fd:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x011c
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfn$zzh r3 = (com.google.android.gms.internal.measurement.zzfn.zzh) r3
            com.google.android.gms.measurement.internal.zzu r4 = r1.zzd
            r4.g_()
            java.lang.String r4 = r3.zzg()
            com.google.android.gms.internal.measurement.zzfn$zzh r4 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x00fd
            r0.add(r3)
            goto L_0x00fd
        L_0x011c:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0127
            r0.addAll(r10)
            r10 = r0
            goto L_0x018e
        L_0x0127:
            com.google.android.gms.measurement.internal.zzu r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzm()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zza(r2, r9)
            goto L_0x018e
        L_0x0137:
            com.google.android.gms.measurement.internal.zzu r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzm()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zza(r2, r9, r4)
            return r7
        L_0x0147:
            if (r6 == 0) goto L_0x018e
            r1.zzb = r4
            r1.zza = r8
            com.google.android.gms.measurement.internal.zzu r2 = r1.zzd
            r2.g_()
            java.lang.String r2 = "_epc"
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r8, (java.lang.String) r2, (java.lang.Object) r3)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r1.zzc = r2
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0178
            com.google.android.gms.measurement.internal.zzu r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzm()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r0.zza(r2, r9)
            goto L_0x018e
        L_0x0178:
            com.google.android.gms.measurement.internal.zzu r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r2.zzh()
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r1.zzc
            r3 = r18
            r7 = r19
            r2.zza(r3, r4, r5, r7)
        L_0x018e:
            com.google.android.gms.internal.measurement.zzjk$zzb r0 = r19.zzcc()
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r0 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r0
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r0 = r0.zza((java.lang.String) r9)
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r0 = r0.zzd()
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r0 = r0.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfn.zzh>) r10)
            com.google.android.gms.internal.measurement.zzkt r0 = r0.zzai()
            com.google.android.gms.internal.measurement.zzjk r0 = (com.google.android.gms.internal.measurement.zzjk) r0
            com.google.android.gms.internal.measurement.zzfn$zzf r0 = (com.google.android.gms.internal.measurement.zzfn.zzf) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(java.lang.String, com.google.android.gms.internal.measurement.zzfn$zzf):com.google.android.gms.internal.measurement.zzfn$zzf");
    }

    private zzy(zzu zzu) {
        this.zzd = zzu;
    }
}
