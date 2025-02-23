package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzbe {
    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal, Boolean bool, Boolean bool2) {
        zzaf zzaf2 = new zzaf();
        Iterator<Integer> zzg = zzaf.zzg();
        while (zzg.hasNext()) {
            int intValue = zzg.next().intValue();
            if (zzaf.zzc(intValue)) {
                zzaq zza = zzal.zza(zzh, (List<zzaq>) Arrays.asList(new zzaq[]{zzaf.zza(intValue), new zzai(Double.valueOf((double) intValue)), zzaf}));
                if (zza.zzd().equals(bool)) {
                    return zzaf2;
                }
                if (bool2 == null || zza.zzd().equals(bool2)) {
                    zzaf2.zzb(intValue, zza);
                }
            }
        }
        return zzaf2;
    }

    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal) {
        return zza(zzaf, zzh, zzal, (Boolean) null, (Boolean) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        r16 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r20, com.google.android.gms.internal.measurement.zzaf r21, com.google.android.gms.internal.measurement.zzh r22, java.util.List<com.google.android.gms.internal.measurement.zzaq> r23) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r20.getClass()
            int r4 = r20.hashCode()
            java.lang.String r5 = "reverse"
            java.lang.String r6 = "slice"
            java.lang.String r7 = "shift"
            java.lang.String r8 = "every"
            java.lang.String r9 = "sort"
            java.lang.String r10 = "some"
            java.lang.String r11 = "join"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "map"
            java.lang.String r14 = "lastIndexOf"
            java.lang.String r15 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r3 = 1
            r16 = -1
            switch(r4) {
                case -1776922004: goto L_0x010e;
                case -1354795244: goto L_0x0102;
                case -1274492040: goto L_0x00f8;
                case -934873754: goto L_0x00ec;
                case -895859076: goto L_0x00df;
                case -678635926: goto L_0x00d6;
                case -467511597: goto L_0x00cd;
                case -277637751: goto L_0x00c2;
                case 107868: goto L_0x00b7;
                case 111185: goto L_0x00ac;
                case 3267882: goto L_0x00a1;
                case 3452698: goto L_0x0094;
                case 3536116: goto L_0x0089;
                case 3536286: goto L_0x007d;
                case 96891675: goto L_0x0071;
                case 109407362: goto L_0x0065;
                case 109526418: goto L_0x0059;
                case 965561430: goto L_0x004b;
                case 1099846370: goto L_0x003f;
                case 1943291465: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0117
        L_0x0031:
            java.lang.String r4 = "indexOf"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x003b
            goto L_0x0117
        L_0x003b:
            r0 = 19
            goto L_0x00e9
        L_0x003f:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0047
            goto L_0x0117
        L_0x0047:
            r0 = 18
            goto L_0x00e9
        L_0x004b:
            java.lang.String r4 = "reduceRight"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0055
            goto L_0x0117
        L_0x0055:
            r0 = 17
            goto L_0x00e9
        L_0x0059:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0061
            goto L_0x0117
        L_0x0061:
            r0 = 16
            goto L_0x00e9
        L_0x0065:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x006d
            goto L_0x0117
        L_0x006d:
            r0 = 15
            goto L_0x00e9
        L_0x0071:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0079
            goto L_0x0117
        L_0x0079:
            r0 = 14
            goto L_0x00e9
        L_0x007d:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0085
            goto L_0x0117
        L_0x0085:
            r0 = 13
            goto L_0x00e9
        L_0x0089:
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0091
            goto L_0x0117
        L_0x0091:
            r0 = 12
            goto L_0x00e9
        L_0x0094:
            java.lang.String r4 = "push"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x009e
            goto L_0x0117
        L_0x009e:
            r0 = 11
            goto L_0x00e9
        L_0x00a1:
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00a9
            goto L_0x0117
        L_0x00a9:
            r0 = 10
            goto L_0x00e9
        L_0x00ac:
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00b4
            goto L_0x0117
        L_0x00b4:
            r0 = 9
            goto L_0x00e9
        L_0x00b7:
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x00bf
            goto L_0x0117
        L_0x00bf:
            r0 = 8
            goto L_0x00e9
        L_0x00c2:
            java.lang.String r4 = "unshift"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00cb
            goto L_0x0117
        L_0x00cb:
            r0 = 7
            goto L_0x00e9
        L_0x00cd:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x00d4
            goto L_0x0117
        L_0x00d4:
            r0 = 6
            goto L_0x00e9
        L_0x00d6:
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0117
        L_0x00dd:
            r0 = 5
            goto L_0x00e9
        L_0x00df:
            java.lang.String r4 = "splice"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00e8
            goto L_0x0117
        L_0x00e8:
            r0 = 4
        L_0x00e9:
            r16 = r0
            goto L_0x0117
        L_0x00ec:
            java.lang.String r4 = "reduce"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00f5
            goto L_0x0117
        L_0x00f5:
            r16 = 3
            goto L_0x0117
        L_0x00f8:
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ff
            goto L_0x0117
        L_0x00ff:
            r16 = 2
            goto L_0x0117
        L_0x0102:
            java.lang.String r4 = "concat"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x010b
            goto L_0x0117
        L_0x010b:
            r16 = r3
            goto L_0x0117
        L_0x010e:
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0115
            goto L_0x0117
        L_0x0115:
            r16 = 0
        L_0x0117:
            r17 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r4 = "Callback should be a method"
            r19 = r1
            r0 = 0
            switch(r16) {
                case 0: goto L_0x0747;
                case 1: goto L_0x06e5;
                case 2: goto L_0x0688;
                case 3: goto L_0x067d;
                case 4: goto L_0x05bb;
                case 5: goto L_0x058c;
                case 6: goto L_0x04ec;
                case 7: goto L_0x0460;
                case 8: goto L_0x042f;
                case 9: goto L_0x0415;
                case 10: goto L_0x03d5;
                case 11: goto L_0x03a2;
                case 12: goto L_0x0331;
                case 13: goto L_0x02d8;
                case 14: goto L_0x029a;
                case 15: goto L_0x0281;
                case 16: goto L_0x0202;
                case 17: goto L_0x01f6;
                case 18: goto L_0x01be;
                case 19: goto L_0x012a;
                default: goto L_0x0122;
            }
        L_0x0122:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x012a:
            java.lang.String r2 = "indexOf"
            r15 = r23
            r5 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r2, r5, r15)
            com.google.android.gms.internal.measurement.zzaq r2 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r4 = r23.isEmpty()
            if (r4 != 0) goto L_0x0148
            r4 = 0
            java.lang.Object r2 = r15.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            r7 = r22
            com.google.android.gms.internal.measurement.zzaq r2 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            goto L_0x014a
        L_0x0148:
            r7 = r22
        L_0x014a:
            int r4 = r23.size()
            if (r4 <= r3) goto L_0x0185
            java.lang.Object r3 = r15.get(r3)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzg.zza((double) r3)
            int r5 = r21.zzb()
            double r5 = (double) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0179
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x0179:
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0184
            int r0 = r21.zzb()
            double r0 = (double) r0
            double r0 = r0 + r3
            goto L_0x0185
        L_0x0184:
            r0 = r3
        L_0x0185:
            java.util.Iterator r3 = r21.zzg()
        L_0x0189:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01b4
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            double r5 = (double) r4
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r14 = r21
            if (r7 < 0) goto L_0x0189
            com.google.android.gms.internal.measurement.zzaq r4 = r14.zza((int) r4)
            boolean r4 = com.google.android.gms.internal.measurement.zzg.zza(r4, r2)
            if (r4 == 0) goto L_0x0189
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            return r0
        L_0x01b4:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x01be:
            r14 = r21
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r5, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r0 = r21.zzb()
            if (r0 == 0) goto L_0x01f5
            r3 = 0
        L_0x01cd:
            int r1 = r0 / 2
            if (r3 >= r1) goto L_0x01f5
            boolean r1 = r14.zzc((int) r3)
            if (r1 == 0) goto L_0x01f2
            com.google.android.gms.internal.measurement.zzaq r1 = r14.zza((int) r3)
            r2 = 0
            r14.zzb(r3, r2)
            int r2 = r0 + -1
            int r2 = r2 - r3
            boolean r4 = r14.zzc((int) r2)
            if (r4 == 0) goto L_0x01ef
            com.google.android.gms.internal.measurement.zzaq r4 = r14.zza((int) r2)
            r14.zzb(r3, r4)
        L_0x01ef:
            r14.zzb(r2, r1)
        L_0x01f2:
            int r3 = r3 + 1
            goto L_0x01cd
        L_0x01f5:
            return r14
        L_0x01f6:
            r14 = r21
            r7 = r22
            r15 = r23
            r2 = 0
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r14, (com.google.android.gms.internal.measurement.zzh) r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15, (boolean) r2)
            return r0
        L_0x0202:
            r14 = r21
            r7 = r22
            r15 = r23
            r2 = 0
            r5 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r6, r5, r15)
            boolean r4 = r23.isEmpty()
            if (r4 == 0) goto L_0x0218
            com.google.android.gms.internal.measurement.zzaq r0 = r21.zzc()
            return r0
        L_0x0218:
            int r4 = r21.zzb()
            double r8 = (double) r4
            java.lang.Object r2 = r15.get(r2)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r10 = r2.doubleValue()
            double r10 = com.google.android.gms.internal.measurement.zzg.zza((double) r10)
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x023d
            double r10 = r10 + r8
            double r10 = java.lang.Math.max(r10, r0)
            goto L_0x0241
        L_0x023d:
            double r10 = java.lang.Math.min(r10, r8)
        L_0x0241:
            int r2 = r23.size()
            if (r2 != r5) goto L_0x026b
            java.lang.Object r2 = r15.get(r3)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r2 = r2.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzg.zza((double) r2)
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0267
            double r8 = r8 + r2
            double r8 = java.lang.Math.max(r8, r0)
            goto L_0x026b
        L_0x0267:
            double r8 = java.lang.Math.min(r8, r2)
        L_0x026b:
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            int r1 = (int) r10
        L_0x0271:
            double r2 = (double) r1
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0280
            com.google.android.gms.internal.measurement.zzaq r2 = r14.zza((int) r1)
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            int r1 = r1 + 1
            goto L_0x0271
        L_0x0280:
            return r0
        L_0x0281:
            r14 = r21
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r7, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r1 = r21.zzb()
            if (r1 != 0) goto L_0x0292
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x0292:
            com.google.android.gms.internal.measurement.zzaq r1 = r14.zza((int) r0)
            r14.zzb((int) r0)
            return r1
        L_0x029a:
            r14 = r21
            r7 = r22
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r8, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x02d2
            int r1 = r21.zzb()
            if (r1 == 0) goto L_0x02cf
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r14, r7, r0, r1, r2)
            int r0 = r0.zzb()
            int r1 = r21.zzb()
            if (r0 == r1) goto L_0x02cf
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x02d2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x02d8:
            r14 = r21
            r7 = r22
            r15 = r23
            r5 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r9, r3, r15)
            int r0 = r21.zzb()
            if (r0 < r5) goto L_0x0330
            java.util.List r0 = r21.zzi()
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x030c
            r1 = 0
            java.lang.Object r2 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzal
            if (r2 == 0) goto L_0x0304
            com.google.android.gms.internal.measurement.zzal r1 = (com.google.android.gms.internal.measurement.zzal) r1
            goto L_0x030d
        L_0x0304:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x030c:
            r1 = 0
        L_0x030d:
            com.google.android.gms.internal.measurement.zzbh r2 = new com.google.android.gms.internal.measurement.zzbh
            r2.<init>(r1, r7)
            java.util.Collections.sort(r0, r2)
            r21.zzj()
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
        L_0x031d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0330
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            int r2 = r3 + 1
            r14.zzb(r3, r1)
            r3 = r2
            goto L_0x031d
        L_0x0330:
            return r14
        L_0x0331:
            r14 = r21
            r7 = r22
            r15 = r23
            r0 = 3
            r5 = 2
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r10, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            r1 = 0
            java.lang.Object r2 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzal
            if (r2 == 0) goto L_0x039c
            int r2 = r21.zzb()
            if (r2 == 0) goto L_0x0399
            com.google.android.gms.internal.measurement.zzal r1 = (com.google.android.gms.internal.measurement.zzal) r1
            java.util.Iterator r2 = r21.zzg()
        L_0x0357:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0399
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r6 = r14.zzc((int) r4)
            if (r6 == 0) goto L_0x0357
            com.google.android.gms.internal.measurement.zzaq[] r6 = new com.google.android.gms.internal.measurement.zzaq[r0]
            com.google.android.gms.internal.measurement.zzaq r8 = r14.zza((int) r4)
            r9 = 0
            r6[r9] = r8
            com.google.android.gms.internal.measurement.zzai r8 = new com.google.android.gms.internal.measurement.zzai
            double r9 = (double) r4
            java.lang.Double r4 = java.lang.Double.valueOf(r9)
            r8.<init>(r4)
            r6[r3] = r8
            r6[r5] = r14
            java.util.List r4 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzaq r4 = r1.zza((com.google.android.gms.internal.measurement.zzh) r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r4)
            java.lang.Boolean r4 = r4.zzd()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0357
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x0399:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x039c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x03a2:
            r14 = r21
            r7 = r22
            r15 = r23
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x03c6
            java.util.Iterator r0 = r23.iterator()
        L_0x03b2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03c6
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            r14.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            goto L_0x03b2
        L_0x03c6:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r21.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x03d5:
            r14 = r21
            r7 = r22
            r15 = r23
            com.google.android.gms.internal.measurement.zzg.zzc(r11, r3, r15)
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x03e7
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzj
            return r0
        L_0x03e7:
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x0409
            r0 = 0
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r1 != 0) goto L_0x0406
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzax
            if (r1 == 0) goto L_0x0401
            goto L_0x0406
        L_0x0401:
            java.lang.String r0 = r0.zzf()
            goto L_0x040b
        L_0x0406:
            java.lang.String r0 = ""
            goto L_0x040b
        L_0x0409:
            java.lang.String r0 = ","
        L_0x040b:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r14.zzb((java.lang.String) r0)
            r1.<init>(r0)
            return r1
        L_0x0415:
            r14 = r21
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r12, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x0426
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x0426:
            int r0 = r0 - r3
            com.google.android.gms.internal.measurement.zzaq r1 = r14.zza((int) r0)
            r14.zzb((int) r0)
            return r1
        L_0x042f:
            r14 = r21
            r7 = r22
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r13, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x045a
            int r1 = r21.zzb()
            if (r1 != 0) goto L_0x0453
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x0453:
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r14, r7, r0)
            return r0
        L_0x045a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x0460:
            r14 = r21
            r7 = r22
            r15 = r23
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x04dd
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            java.util.Iterator r1 = r23.iterator()
        L_0x0475:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0495
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x048d
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            goto L_0x0475
        L_0x048d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x0495:
            int r1 = r0.zzb()
            java.util.Iterator r2 = r21.zzg()
        L_0x049d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04ba
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r14.zza((int) r3)
            r0.zzb(r4, r3)
            goto L_0x049d
        L_0x04ba:
            r21.zzj()
            java.util.Iterator r1 = r0.zzg()
        L_0x04c1:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04dd
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzaq r2 = r0.zza((int) r2)
            r14.zzb(r3, r2)
            goto L_0x04c1
        L_0x04dd:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r21.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x04ec:
            r2 = r21
            r7 = r22
            r15 = r23
            r5 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r14, r5, r15)
            com.google.android.gms.internal.measurement.zzaq r4 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r5 = r23.isEmpty()
            if (r5 != 0) goto L_0x0509
            r5 = 0
            java.lang.Object r4 = r15.get(r5)
            com.google.android.gms.internal.measurement.zzaq r4 = (com.google.android.gms.internal.measurement.zzaq) r4
            com.google.android.gms.internal.measurement.zzaq r4 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r4)
        L_0x0509:
            int r5 = r21.zzb()
            int r5 = r5 - r3
            double r5 = (double) r5
            int r8 = r23.size()
            if (r8 <= r3) goto L_0x054a
            java.lang.Object r5 = r15.get(r3)
            com.google.android.gms.internal.measurement.zzaq r5 = (com.google.android.gms.internal.measurement.zzaq) r5
            com.google.android.gms.internal.measurement.zzaq r5 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r5)
            java.lang.Double r6 = r5.zze()
            double r6 = r6.doubleValue()
            boolean r6 = java.lang.Double.isNaN(r6)
            if (r6 == 0) goto L_0x0534
            int r5 = r21.zzb()
            int r5 = r5 - r3
            double r5 = (double) r5
            goto L_0x0540
        L_0x0534:
            java.lang.Double r3 = r5.zze()
            double r5 = r3.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzg.zza((double) r5)
        L_0x0540:
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x054a
            int r3 = r21.zzb()
            double r7 = (double) r3
            double r5 = r5 + r7
        L_0x054a:
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0558
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x0558:
            int r0 = r21.zzb()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r0, r5)
            int r0 = (int) r0
        L_0x0562:
            if (r0 < 0) goto L_0x0582
            boolean r1 = r2.zzc((int) r0)
            if (r1 == 0) goto L_0x057f
            com.google.android.gms.internal.measurement.zzaq r1 = r2.zza((int) r0)
            boolean r1 = com.google.android.gms.internal.measurement.zzg.zza(r1, r4)
            if (r1 == 0) goto L_0x057f
            com.google.android.gms.internal.measurement.zzai r1 = new com.google.android.gms.internal.measurement.zzai
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            return r1
        L_0x057f:
            int r0 = r0 + -1
            goto L_0x0562
        L_0x0582:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x058c:
            r2 = r21
            r7 = r22
            r0 = r23
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r15, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x05b5
            int r1 = r21.zza()
            if (r1 != 0) goto L_0x05ad
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05ad:
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            zza(r2, r7, r0)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05b5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x05bb:
            r2 = r21
            r7 = r22
            r0 = r23
            r5 = 2
            boolean r1 = r23.isEmpty()
            if (r1 == 0) goto L_0x05ce
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x05ce:
            r1 = 0
            java.lang.Object r4 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzaq r4 = (com.google.android.gms.internal.measurement.zzaq) r4
            com.google.android.gms.internal.measurement.zzaq r4 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r4)
            java.lang.Double r4 = r4.zze()
            double r8 = r4.doubleValue()
            double r8 = com.google.android.gms.internal.measurement.zzg.zza((double) r8)
            int r4 = (int) r8
            if (r4 >= 0) goto L_0x05f2
            int r6 = r21.zzb()
            int r6 = r6 + r4
            int r4 = java.lang.Math.max(r1, r6)
            goto L_0x05fc
        L_0x05f2:
            int r1 = r21.zzb()
            if (r4 <= r1) goto L_0x05fc
            int r4 = r21.zzb()
        L_0x05fc:
            int r1 = r21.zzb()
            com.google.android.gms.internal.measurement.zzaf r6 = new com.google.android.gms.internal.measurement.zzaf
            r6.<init>()
            int r8 = r23.size()
            if (r8 <= r3) goto L_0x066c
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r8 = r3.doubleValue()
            double r8 = com.google.android.gms.internal.measurement.zzg.zza((double) r8)
            int r3 = (int) r8
            r8 = 0
            int r3 = java.lang.Math.max(r8, r3)
            if (r3 <= 0) goto L_0x063f
            r8 = r4
        L_0x062a:
            int r9 = r4 + r3
            int r9 = java.lang.Math.min(r1, r9)
            if (r8 >= r9) goto L_0x063f
            com.google.android.gms.internal.measurement.zzaq r9 = r2.zza((int) r4)
            r6.zza((com.google.android.gms.internal.measurement.zzaq) r9)
            r2.zzb((int) r4)
            int r8 = r8 + 1
            goto L_0x062a
        L_0x063f:
            int r1 = r23.size()
            if (r1 <= r5) goto L_0x066b
            r3 = r5
        L_0x0646:
            int r1 = r23.size()
            if (r3 >= r1) goto L_0x066b
            java.lang.Object r1 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            boolean r8 = r1 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r8 != 0) goto L_0x0663
            int r8 = r4 + r3
            int r8 = r8 - r5
            r2.zza((int) r8, (com.google.android.gms.internal.measurement.zzaq) r1)
            int r3 = r3 + 1
            goto L_0x0646
        L_0x0663:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x066b:
            return r6
        L_0x066c:
            if (r4 >= r1) goto L_0x067c
            com.google.android.gms.internal.measurement.zzaq r0 = r2.zza((int) r4)
            r6.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            r0 = 0
            r2.zzb(r4, r0)
            int r4 = r4 + 1
            goto L_0x066c
        L_0x067c:
            return r6
        L_0x067d:
            r2 = r21
            r7 = r22
            r0 = r23
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r2, (com.google.android.gms.internal.measurement.zzh) r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r0, (boolean) r3)
            return r0
        L_0x0688:
            r2 = r21
            r7 = r22
            r0 = r23
            r1 = r19
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r1, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x06df
            int r1 = r21.zza()
            if (r1 != 0) goto L_0x06ae
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x06ae:
            com.google.android.gms.internal.measurement.zzaq r1 = r21.zzc()
            com.google.android.gms.internal.measurement.zzaf r1 = (com.google.android.gms.internal.measurement.zzaf) r1
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = 0
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r2, r7, r0, r4, r3)
            com.google.android.gms.internal.measurement.zzaf r2 = new com.google.android.gms.internal.measurement.zzaf
            r2.<init>()
            java.util.Iterator r0 = r0.zzg()
        L_0x06c6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x06de
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r1.zza((int) r3)
            r2.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            goto L_0x06c6
        L_0x06de:
            return r2
        L_0x06df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x06e5:
            r2 = r21
            r7 = r22
            r0 = r23
            com.google.android.gms.internal.measurement.zzaq r1 = r21.zzc()
            com.google.android.gms.internal.measurement.zzaf r1 = (com.google.android.gms.internal.measurement.zzaf) r1
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x0746
            java.util.Iterator r0 = r23.iterator()
        L_0x06fb:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0746
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x073e
            int r3 = r1.zzb()
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzaf
            if (r4 == 0) goto L_0x073a
            com.google.android.gms.internal.measurement.zzaf r2 = (com.google.android.gms.internal.measurement.zzaf) r2
            java.util.Iterator r4 = r2.zzg()
        L_0x071d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x06fb
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r6 = r5.intValue()
            int r6 = r6 + r3
            int r5 = r5.intValue()
            com.google.android.gms.internal.measurement.zzaq r5 = r2.zza((int) r5)
            r1.zzb(r6, r5)
            goto L_0x071d
        L_0x073a:
            r1.zzb(r3, r2)
            goto L_0x06fb
        L_0x073e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x0746:
            return r1
        L_0x0747:
            r0 = r23
            r1 = r2
            r3 = 0
            r2 = r21
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r1, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r0)
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r1 = r21.toString()
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(java.lang.String, com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzaq zza(com.google.android.gms.internal.measurement.zzaf r9, com.google.android.gms.internal.measurement.zzh r10, java.util.List<com.google.android.gms.internal.measurement.zzaq> r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzg.zzb((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzal
            if (r4 == 0) goto L_0x009f
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzaq r11 = (com.google.android.gms.internal.measurement.zzaq) r11
            com.google.android.gms.internal.measurement.zzaq r11 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            int r11 = r9.zzb()
            if (r11 == 0) goto L_0x0097
            r11 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzal r3 = (com.google.android.gms.internal.measurement.zzal) r3
            int r4 = r9.zzb()
            if (r12 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            if (r12 == 0) goto L_0x004d
            int r4 = r4 - r1
            goto L_0x004e
        L_0x004d:
            r4 = r0
        L_0x004e:
            if (r12 == 0) goto L_0x0052
            r12 = r1
            goto L_0x0053
        L_0x0052:
            r12 = -1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            goto L_0x0094
        L_0x005a:
            int r6 = r4 - r5
            int r6 = r6 * r12
            if (r6 < 0) goto L_0x0096
            boolean r6 = r9.zzc((int) r5)
            if (r6 == 0) goto L_0x0094
            r6 = 4
            com.google.android.gms.internal.measurement.zzaq[] r6 = new com.google.android.gms.internal.measurement.zzaq[r6]
            r6[r0] = r11
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            r6[r1] = r11
            com.google.android.gms.internal.measurement.zzai r11 = new com.google.android.gms.internal.measurement.zzai
            double r7 = (double) r5
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r6[r2] = r11
            r11 = 3
            r6[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzaq r11 = r3.zza((com.google.android.gms.internal.measurement.zzh) r10, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            boolean r6 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r6 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            int r5 = r5 + r12
            goto L_0x005a
        L_0x0096:
            return r11
        L_0x0097:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x009f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List, boolean):com.google.android.gms.internal.measurement.zzaq");
    }
}
