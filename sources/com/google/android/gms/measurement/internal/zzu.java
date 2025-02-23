package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zznk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzu extends zzmx {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzw> zzc;
    private Long zzd;
    private Long zze;

    public zzu(zznc zznc) {
        super(zznc);
    }

    private final zzw zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzw zzw = new zzw(this, this.zza);
        this.zzc.put(num, zzw);
        return zzw;
    }

    private final List<zzfn.zzd> zzu() {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = this.zzc.keySet();
        keySet.removeAll(this.zzb);
        for (Integer intValue : keySet) {
            int intValue2 = intValue.intValue();
            zzw zzw = this.zzc.get(Integer.valueOf(intValue2));
            Preconditions.checkNotNull(zzw);
            zzfn.zzd zza2 = zzw.zza(intValue2);
            arrayList.add(zza2);
            zzal zzh = zzh();
            String str = this.zza;
            zzfn.zzm zzd2 = zza2.zzd();
            zzh.zzal();
            zzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzd2);
            byte[] zzbz = zzd2.zzbz();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(intValue2));
            contentValues.put("current_results", zzbz);
            try {
                if (zzh.e_().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    zzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzfw.zza(str));
                }
            } catch (SQLiteException e) {
                zzh.zzj().zzg().zza("Error storing filter results. appId", zzfw.zza(str), e);
            }
        }
        return arrayList;
    }

    public final boolean zzc() {
        return false;
    }

    public final List<zzfn.zzd> zza(String str, List<zzfn.zzf> list, List<zzfn.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0316 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzfn.zzd> zza(java.lang.String r24, java.util.List<com.google.android.gms.internal.measurement.zzfn.zzf> r25, java.util.List<com.google.android.gms.internal.measurement.zzfn.zzo> r26, java.lang.Long r27, java.lang.Long r28, boolean r29) {
        /*
            r23 = this;
            r10 = r23
            r11 = r25
            r12 = r26
            r13 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r0 = r24
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r27
            r10.zzd = r0
            r0 = r28
            r10.zze = r0
            java.util.Iterator r0 = r25.iterator()
        L_0x002f:
            boolean r1 = r0.hasNext()
            r14 = 0
            r15 = 1
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzfn$zzf r1 = (com.google.android.gms.internal.measurement.zzfn.zzf) r1
            java.lang.String r2 = "_s"
            java.lang.String r1 = r1.zzg()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002f
            r1 = r15
            goto L_0x004c
        L_0x004b:
            r1 = r14
        L_0x004c:
            boolean r0 = com.google.android.gms.internal.measurement.zzoc.zza()
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzag r0 = r23.zze()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbk
            boolean r0 = r0.zzf(r2, r3)
            if (r0 == 0) goto L_0x0063
            r16 = r15
            goto L_0x0065
        L_0x0063:
            r16 = r14
        L_0x0065:
            boolean r0 = com.google.android.gms.internal.measurement.zzoc.zza()
            if (r0 == 0) goto L_0x007c
            com.google.android.gms.measurement.internal.zzag r0 = r23.zze()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbj
            boolean r0 = r0.zzf(r2, r3)
            if (r0 == 0) goto L_0x007c
            r17 = r15
            goto L_0x007e
        L_0x007c:
            r17 = r14
        L_0x007e:
            if (r1 == 0) goto L_0x00bf
            com.google.android.gms.measurement.internal.zzal r2 = r23.zzh()
            java.lang.String r3 = r10.zza
            r2.zzal()
            r2.zzt()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.e_()     // Catch:{ SQLiteException -> 0x00ad }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00ad }
            r7[r14] = r3     // Catch:{ SQLiteException -> 0x00ad }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00ad }
            goto L_0x00bf
        L_0x00ad:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r3)
            r2.zza(r4, r3, r0)
        L_0x00bf:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r17 == 0) goto L_0x00d1
            if (r16 == 0) goto L_0x00d1
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzh()
            java.lang.String r2 = r10.zza
            java.util.Map r0 = r0.zzm(r2)
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzal r2 = r23.zzh()
            java.lang.String r3 = r10.zza
            java.util.Map r9 = r2.zzl(r3)
            boolean r2 = r9.isEmpty()
            if (r2 != 0) goto L_0x03c7
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r9.keySet()
            r2.<init>(r3)
            if (r1 == 0) goto L_0x020c
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzal r3 = r23.zzh()
            java.lang.String r4 = r10.zza
            java.util.Map r3 = r3.zzn(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r4 = r9.isEmpty()
            if (r4 != 0) goto L_0x020a
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0111:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x020a
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r9.get(r6)
            com.google.android.gms.internal.measurement.zzfn$zzm r6 = (com.google.android.gms.internal.measurement.zzfn.zzm) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01f7
            boolean r18 = r7.isEmpty()
            if (r18 == 0) goto L_0x013f
            goto L_0x01f7
        L_0x013f:
            com.google.android.gms.measurement.internal.zznl r8 = r23.g_()
            java.util.List r14 = r6.zzi()
            java.util.List r8 = r8.zza((java.util.List<java.lang.Long>) r14, (java.util.List<java.lang.Integer>) r7)
            boolean r14 = r8.isEmpty()
            if (r14 != 0) goto L_0x01f4
            com.google.android.gms.internal.measurement.zzjk$zzb r14 = r6.zzcc()
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r14 = (com.google.android.gms.internal.measurement.zzfn.zzm.zza) r14
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r14 = r14.zzb()
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r8 = r14.zzb(r8)
            com.google.android.gms.measurement.internal.zznl r14 = r23.g_()
            java.util.List r15 = r6.zzk()
            java.util.List r14 = r14.zza((java.util.List<java.lang.Long>) r15, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r15 = r8.zzd()
            r15.zzd(r14)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List r15 = r6.zzh()
            java.util.Iterator r15 = r15.iterator()
        L_0x017f:
            boolean r18 = r15.hasNext()
            if (r18 == 0) goto L_0x01a7
            java.lang.Object r18 = r15.next()
            r19 = r3
            r3 = r18
            com.google.android.gms.internal.measurement.zzfn$zze r3 = (com.google.android.gms.internal.measurement.zzfn.zze) r3
            int r18 = r3.zza()
            r20 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            boolean r4 = r7.contains(r4)
            if (r4 != 0) goto L_0x01a2
            r14.add(r3)
        L_0x01a2:
            r3 = r19
            r4 = r20
            goto L_0x017f
        L_0x01a7:
            r19 = r3
            r20 = r4
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r3 = r8.zza()
            r3.zza(r14)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r6.zzj()
            java.util.Iterator r4 = r4.iterator()
        L_0x01bf:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x01dd
            java.lang.Object r6 = r4.next()
            com.google.android.gms.internal.measurement.zzfn$zzn r6 = (com.google.android.gms.internal.measurement.zzfn.zzn) r6
            int r14 = r6.zzb()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            boolean r14 = r7.contains(r14)
            if (r14 != 0) goto L_0x01bf
            r3.add(r6)
            goto L_0x01bf
        L_0x01dd:
            com.google.android.gms.internal.measurement.zzfn$zzm$zza r4 = r8.zzc()
            r4.zzc(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzkt r4 = r8.zzai()
            com.google.android.gms.internal.measurement.zzjk r4 = (com.google.android.gms.internal.measurement.zzjk) r4
            com.google.android.gms.internal.measurement.zzfn$zzm r4 = (com.google.android.gms.internal.measurement.zzfn.zzm) r4
            r1.put(r3, r4)
            goto L_0x0202
        L_0x01f4:
            r14 = 0
            goto L_0x0111
        L_0x01f7:
            r19 = r3
            r20 = r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r1.put(r3, r6)
        L_0x0202:
            r3 = r19
            r4 = r20
            r14 = 0
            r15 = 1
            goto L_0x0111
        L_0x020a:
            r14 = r1
            goto L_0x020d
        L_0x020c:
            r14 = r9
        L_0x020d:
            java.util.Iterator r15 = r2.iterator()
        L_0x0211:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x03c7
            java.lang.Object r1 = r15.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r18 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r1 = r14.get(r1)
            com.google.android.gms.internal.measurement.zzfn$zzm r1 = (com.google.android.gms.internal.measurement.zzfn.zzm) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0279
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0243
            goto L_0x0279
        L_0x0243:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x024b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0279
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfn$zze r3 = (com.google.android.gms.internal.measurement.zzfn.zze) r3
            boolean r4 = r3.zzf()
            if (r4 == 0) goto L_0x024b
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zze()
            if (r8 == 0) goto L_0x0274
            long r19 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r19)
            goto L_0x0275
        L_0x0274:
            r3 = 0
        L_0x0275:
            r7.put(r4, r3)
            goto L_0x024b
        L_0x0279:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x02c8
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x0287
            goto L_0x02c8
        L_0x0287:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x028f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02c8
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfn$zzn r3 = (com.google.android.gms.internal.measurement.zzfn.zzn) r3
            boolean r4 = r3.zzf()
            if (r4 == 0) goto L_0x02c3
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x02c3
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r19 = r3.zza()
            r20 = r2
            int r2 = r19 + -1
            long r2 = r3.zza((int) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r8.put(r4, r2)
            goto L_0x02c5
        L_0x02c3:
            r20 = r2
        L_0x02c5:
            r2 = r20
            goto L_0x028f
        L_0x02c8:
            if (r1 == 0) goto L_0x031d
            r2 = 0
        L_0x02cb:
            int r3 = r1.zzd()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x031d
            java.util.List r3 = r1.zzk()
            boolean r3 = com.google.android.gms.measurement.internal.zznl.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x0308
            com.google.android.gms.measurement.internal.zzfw r3 = r23.zzj()
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzp()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            r19 = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            r20 = r15
            java.lang.String r15 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r15, r4, r14)
            r6.set(r2)
            java.util.List r3 = r1.zzi()
            boolean r3 = com.google.android.gms.measurement.internal.zznl.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x030c
            r5.set(r2)
            r3 = 1
            goto L_0x030d
        L_0x0308:
            r19 = r14
            r20 = r15
        L_0x030c:
            r3 = 0
        L_0x030d:
            if (r3 != 0) goto L_0x0316
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x0316:
            int r2 = r2 + 1
            r14 = r19
            r15 = r20
            goto L_0x02cb
        L_0x031d:
            r19 = r14
            r20 = r15
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r1 = r9.get(r1)
            r4 = r1
            com.google.android.gms.internal.measurement.zzfn$zzm r4 = (com.google.android.gms.internal.measurement.zzfn.zzm) r4
            if (r17 == 0) goto L_0x03a3
            if (r16 == 0) goto L_0x03a3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x03a3
            java.lang.Long r2 = r10.zze
            if (r2 == 0) goto L_0x03a3
            java.lang.Long r2 = r10.zzd
            if (r2 != 0) goto L_0x0345
            goto L_0x03a3
        L_0x0345:
            java.util.Iterator r1 = r1.iterator()
        L_0x0349:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x03a3
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzff$zzb r2 = (com.google.android.gms.internal.measurement.zzff.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r14 = r10.zze
            long r14 = r14.longValue()
            r21 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r21
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0371
            java.lang.Long r2 = r10.zzd
            long r14 = r2.longValue()
            long r14 = r14 / r21
        L_0x0371:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x0389
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r21 = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            r7.put(r2, r0)
            goto L_0x038b
        L_0x0389:
            r21 = r0
        L_0x038b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x03a0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r14)
            r8.put(r0, r2)
        L_0x03a0:
            r0 = r21
            goto L_0x0349
        L_0x03a3:
            r21 = r0
            com.google.android.gms.measurement.internal.zzw r0 = new com.google.android.gms.measurement.internal.zzw
            java.lang.String r3 = r10.zza
            r14 = 0
            r1 = r0
            r2 = r23
            r15 = 0
            r22 = r9
            r9 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzw> r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            r1.put(r2, r0)
            r14 = r19
            r15 = r20
            r0 = r21
            r9 = r22
            goto L_0x0211
        L_0x03c7:
            r15 = 0
            boolean r0 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r0 == 0) goto L_0x03ed
            com.google.android.gms.measurement.internal.zzag r0 = r23.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r0 = r0.zzf(r15, r1)
            if (r0 == 0) goto L_0x03ed
            r10.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzf>) r11, (boolean) r13)
            if (r13 == 0) goto L_0x03e5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L_0x03e5:
            r10.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzo>) r12)
            java.util.List r0 = r23.zzu()
            return r0
        L_0x03ed:
            r1 = 1
            r10.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzf>) r11, (boolean) r1)
            r10.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzo>) r12)
            java.util.List r0 = r23.zzu()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }

    private final void zza(List<zzfn.zzf> list, boolean z) {
        zzaz zzaz;
        int i;
        Map<Integer, List<zzff.zzb>> map;
        long j;
        if (!list.isEmpty()) {
            String str = null;
            zzy zzy = new zzy(this);
            ArrayMap arrayMap = new ArrayMap();
            for (zzfn.zzf next : list) {
                zzfn.zzf zza2 = zzy.zza(this.zza, next);
                if (zza2 != null) {
                    zzal zzh = zzh();
                    String str2 = this.zza;
                    String zzg = zza2.zzg();
                    zzaz zzd2 = zzh.zzd(str2, next.zzg());
                    if (zzd2 == null) {
                        zzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfw.zza(str2), zzh.zzi().zza(zzg));
                        zzaz = new zzaz(str2, next.zzg(), 1, 1, 1, next.zzd(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                    } else {
                        zzaz = new zzaz(zzd2.zza, zzd2.zzb, zzd2.zzc + 1, zzd2.zzd + 1, zzd2.zze + 1, zzd2.zzf, zzd2.zzg, zzd2.zzh, zzd2.zzi, zzd2.zzj, zzd2.zzk);
                    }
                    zzaz zzaz2 = zzaz;
                    zzh().zza(zzaz2);
                    if (!zznk.zza() || !zze().zzf(str, zzbf.zzcv) || !z) {
                        long j2 = zzaz2.zzc;
                        String zzg2 = zza2.zzg();
                        Map<Integer, List<zzff.zzb>> map2 = (Map) arrayMap.getOrDefault(zzg2, str);
                        if (map2 == null) {
                            map2 = zzh().zzf(this.zza, zzg2);
                            arrayMap.put(zzg2, map2);
                        }
                        Map<Integer, List<zzff.zzb>> map3 = map2;
                        for (Integer intValue : map3.keySet()) {
                            int intValue2 = intValue.intValue();
                            if (this.zzb.contains(Integer.valueOf(intValue2))) {
                                zzj().zzp().zza("Skipping failed audience ID", Integer.valueOf(intValue2));
                            } else {
                                Iterator it = map3.get(Integer.valueOf(intValue2)).iterator();
                                boolean z2 = true;
                                while (true) {
                                    if (!it.hasNext()) {
                                        i = intValue2;
                                        map = map3;
                                        j = j2;
                                        break;
                                    }
                                    zzff.zzb zzb2 = (zzff.zzb) it.next();
                                    zzaa zzaa = new zzaa(this, this.zza, intValue2, zzb2);
                                    i = intValue2;
                                    zzaa zzaa2 = zzaa;
                                    map = map3;
                                    j = j2;
                                    z2 = zzaa.zza(this.zzd, this.zze, zza2, j2, zzaz2, zza(intValue2, zzb2.zzb()));
                                    if (!z2) {
                                        this.zzb.add(Integer.valueOf(i));
                                        break;
                                    }
                                    zza(Integer.valueOf(i)).zza((zzz) zzaa2);
                                    intValue2 = i;
                                    map3 = map;
                                    j2 = j;
                                }
                                if (!z2) {
                                    this.zzb.add(Integer.valueOf(i));
                                }
                                map3 = map;
                                j2 = j;
                                str = null;
                            }
                        }
                    }
                }
                str = null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0125, code lost:
        if (r7.zzi() == false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0127, code lost:
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0130, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0131, code lost:
        r6.zza("Invalid property filter ID. appId, id", r8, java.lang.String.valueOf(r7));
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.List<com.google.android.gms.internal.measurement.zzfn.zzo> r14) {
        /*
            r13 = this;
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x0010:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0148
            java.lang.Object r1 = r14.next()
            com.google.android.gms.internal.measurement.zzfn$zzo r1 = (com.google.android.gms.internal.measurement.zzfn.zzo) r1
            java.lang.String r2 = r1.zzg()
            r3 = 0
            java.lang.Object r4 = r0.getOrDefault(r2, r3)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzal r4 = r13.zzh()
            java.lang.String r5 = r13.zza
            java.util.Map r4 = r4.zzg(r5, r2)
            r0.put(r2, r4)
        L_0x0036:
            java.util.Set r2 = r4.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0010
            java.lang.Object r5 = r2.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set<java.lang.Integer> r6 = r13.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzfw r1 = r13.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "Skipping failed audience ID"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r1.zza(r2, r3)
            goto L_0x0010
        L_0x006c:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r4.get(r6)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x007b:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x013b
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzff$zze r7 = (com.google.android.gms.internal.measurement.zzff.zze) r7
            com.google.android.gms.measurement.internal.zzfw r8 = r13.zzj()
            r9 = 2
            boolean r8 = r8.zza((int) r9)
            if (r8 == 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzfw r8 = r13.zzj()
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            boolean r10 = r7.zzi()
            if (r10 == 0) goto L_0x00ad
            int r10 = r7.zza()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x00ae
        L_0x00ad:
            r10 = r3
        L_0x00ae:
            com.google.android.gms.measurement.internal.zzfr r11 = r13.zzi()
            java.lang.String r12 = r7.zze()
            java.lang.String r11 = r11.zzc(r12)
            java.lang.String r12 = "Evaluating filter. audience, filter, property"
            r8.zza(r12, r9, r10, r11)
            com.google.android.gms.measurement.internal.zzfw r8 = r13.zzj()
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()
            com.google.android.gms.measurement.internal.zznl r9 = r13.g_()
            java.lang.String r9 = r9.zza((com.google.android.gms.internal.measurement.zzff.zze) r7)
            java.lang.String r10 = "Filter definition"
            r8.zza(r10, r9)
        L_0x00d4:
            boolean r8 = r7.zzi()
            if (r8 == 0) goto L_0x0113
            int r8 = r7.zza()
            r9 = 256(0x100, float:3.59E-43)
            if (r8 <= r9) goto L_0x00e3
            goto L_0x0113
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzac r8 = new com.google.android.gms.measurement.internal.zzac
            java.lang.String r9 = r13.zza
            r8.<init>(r13, r9, r5, r7)
            java.lang.Long r9 = r13.zzd
            java.lang.Long r10 = r13.zze
            int r7 = r7.zza()
            boolean r7 = r13.zza((int) r5, (int) r7)
            boolean r7 = r8.zza(r9, r10, r1, r7)
            if (r7 == 0) goto L_0x0109
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzw r9 = r13.zza((java.lang.Integer) r9)
            r9.zza((com.google.android.gms.measurement.internal.zzz) r8)
            goto L_0x007b
        L_0x0109:
            java.util.Set<java.lang.Integer> r6 = r13.zzb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r6.add(r8)
            goto L_0x013b
        L_0x0113:
            com.google.android.gms.measurement.internal.zzfw r6 = r13.zzj()
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzu()
            java.lang.String r8 = r13.zza
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)
            boolean r9 = r7.zzi()
            if (r9 == 0) goto L_0x0130
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0131
        L_0x0130:
            r7 = r3
        L_0x0131:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r9 = "Invalid property filter ID. appId, id"
            r6.zza(r9, r8, r7)
            r7 = 0
        L_0x013b:
            if (r7 != 0) goto L_0x003e
            java.util.Set<java.lang.Integer> r6 = r13.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.add(r5)
            goto L_0x003e
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.util.List):void");
    }

    private final boolean zza(int i, int i2) {
        zzw zzw = this.zzc.get(Integer.valueOf(i));
        if (zzw == null) {
            return false;
        }
        return zzw.zzd.get(i2);
    }
}
