package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzas implements zzaq, Iterable<zzaq> {
    /* access modifiers changed from: private */
    public final String zza;

    public zzas(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        return this.zza.equals(((zzas) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public final String toString() {
        return lf.j("\"", this.zza, "\"");
    }

    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzf() {
        return this.zza;
    }

    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x018c, code lost:
        if (r22.size() > 0) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x018e, code lost:
        r5 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0197, code lost:
        r7 = r21;
        r5 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ad, code lost:
        if (r22.size() >= 2) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01b0, code lost:
        r0 = r7.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01d6, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r4.indexOf(r5, (int) com.google.android.gms.internal.measurement.zzg.zza(r0))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01d7, code lost:
        r2 = r19;
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("replace", 2, r3);
        r0 = com.google.android.gms.internal.measurement.zzaq.zzc;
        r1 = r0.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01eb, code lost:
        if (r22.isEmpty() != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01ed, code lost:
        r1 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0201, code lost:
        if (r22.size() <= 1) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0203, code lost:
        r0 = r7.zza(r3.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x020d, code lost:
        r3 = r2.zza;
        r4 = r3.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0213, code lost:
        if (r4 >= 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0215, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0218, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzal) == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x021a, code lost:
        r0 = ((com.google.android.gms.internal.measurement.zzal) r0).zza(r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzaq[]{new com.google.android.gms.internal.measurement.zzas(r1), new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r4)), r2}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x025a, code lost:
        return new com.google.android.gms.internal.measurement.zzas(defpackage.xx.D(r3.substring(0, r4), r0.zzf(), r3.substring(r1.length() + r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025b, code lost:
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("substring", 2, r3);
        r0 = r19.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x026b, code lost:
        if (r22.isEmpty() != false) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x026d, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzg.zza(r7.zza(r3.get(0)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0286, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x028c, code lost:
        if (r22.size() <= 1) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028e, code lost:
        r3 = (int) com.google.android.gms.internal.measurement.zzg.zza(r7.zza(r3.get(1)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02a6, code lost:
        r3 = r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02aa, code lost:
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r0.length());
        r3 = java.lang.Math.min(java.lang.Math.max(r3, 0), r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02d4, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r0.substring(java.lang.Math.min(r1, r3), java.lang.Math.max(r1, r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02d5, code lost:
        r2 = r19;
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("split", 2, r3);
        r0 = r2.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02e5, code lost:
        if (r0.length() != 0) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f2, code lost:
        return new com.google.android.gms.internal.measurement.zzaf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02f3, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02fd, code lost:
        if (r22.isEmpty() == false) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02ff, code lost:
        r4.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0304, code lost:
        r1 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0317, code lost:
        if (r22.size() <= 1) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0319, code lost:
        r5 = com.google.android.gms.internal.measurement.zzg.zzc(r7.zza(r3.get(1)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0330, code lost:
        r5 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0337, code lost:
        if (r5 != 0) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x033e, code lost:
        return new com.google.android.gms.internal.measurement.zzaf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x033f, code lost:
        r0 = r0.split(java.util.regex.Pattern.quote(r1), ((int) r5) + 1);
        r3 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x034f, code lost:
        if (r1.isEmpty() == false) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0352, code lost:
        if (r0.length <= 0) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0354, code lost:
        r1 = r0[0].isEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0364, code lost:
        if (r0[r0.length - 1].isEmpty() == false) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0366, code lost:
        r3 = r0.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x036a, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x036f, code lost:
        if (((long) r0.length) <= r5) goto L_0x0373;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0371, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0373, code lost:
        if (r1 >= r3) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0375, code lost:
        r4.add(new com.google.android.gms.internal.measurement.zzas(r0[r1]));
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0387, code lost:
        return new com.google.android.gms.internal.measurement.zzaf((java.util.List<com.google.android.gms.internal.measurement.zzaq>) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0388, code lost:
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("slice", 2, r3);
        r4 = r19.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0398, code lost:
        if (r22.isEmpty() != false) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x039a, code lost:
        r5 = r7.zza(r3.get(0)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03ae, code lost:
        r5 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03af, code lost:
        r5 = com.google.android.gms.internal.measurement.zzg.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03b5, code lost:
        if (r5 >= 0.0d) goto L_0x03c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03b7, code lost:
        r5 = java.lang.Math.max(((double) r4.length()) + r5, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03c2, code lost:
        r5 = java.lang.Math.min(r5, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03cb, code lost:
        r5 = (int) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03d1, code lost:
        if (r22.size() <= 1) goto L_0x03e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03d3, code lost:
        r6 = r7.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03e6, code lost:
        r6 = (double) r4.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03eb, code lost:
        r6 = com.google.android.gms.internal.measurement.zzg.zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03f1, code lost:
        if (r6 >= 0.0d) goto L_0x03fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03f3, code lost:
        r0 = java.lang.Math.max(((double) r4.length()) + r6, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03fe, code lost:
        r0 = java.lang.Math.min(r6, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0418, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r4.substring(r5, java.lang.Math.max(0, ((int) r0) - r5) + r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0419, code lost:
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("match", 1, r3);
        r0 = r19.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0429, code lost:
        if (r22.size() > 0) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x042b, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x042e, code lost:
        r1 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x043d, code lost:
        r0 = java.util.regex.Pattern.compile(r1).matcher(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0449, code lost:
        if (r0.find() == false) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x045f, code lost:
        return new com.google.android.gms.internal.measurement.zzaf(new com.google.android.gms.internal.measurement.zzas(r0.group()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0462, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0463, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toUpperCase", 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0476, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r19.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0477, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toUpperCase", 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x048c, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r19.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x048d, code lost:
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("lastIndexOf", 2, r3);
        r0 = r19.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x049d, code lost:
        if (r22.size() > 0) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x049f, code lost:
        r1 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04a6, code lost:
        r1 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04ba, code lost:
        if (r22.size() >= 2) goto L_0x04bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04bc, code lost:
        r3 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04bf, code lost:
        r3 = r7.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04d6, code lost:
        if (java.lang.Double.isNaN(r3) == false) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04d8, code lost:
        r3 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04db, code lost:
        r3 = com.google.android.gms.internal.measurement.zzg.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04ee, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r0.lastIndexOf(r1, (int) r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04ef, code lost:
        com.google.android.gms.internal.measurement.zzg.zza(r5, 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0502, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r19.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0503, code lost:
        r2 = r19;
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0512, code lost:
        if (r22.isEmpty() != false) goto L_0x0523;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0514, code lost:
        r0 = r7.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0523, code lost:
        r0 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0529, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r2.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0537, code lost:
        if (r0.find() == false) goto L_0x0548;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0547, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0553, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0554, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toLowerCase", 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x056a, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r19.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x056b, code lost:
        r2 = r19;
        r7 = r21;
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0575, code lost:
        if (r22.isEmpty() == false) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0577, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0578, code lost:
        r0 = new java.lang.StringBuilder(r2.zza);
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0584, code lost:
        if (r1 >= r22.size()) goto L_0x059a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0586, code lost:
        r0.append(r7.zza(r3.get(r1)).zzf());
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05a3, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05a4, code lost:
        r2 = r19;
        r7 = r21;
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc(r4, 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x05b2, code lost:
        if (r22.isEmpty() != false) goto L_0x05cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x05b4, code lost:
        r0 = (int) com.google.android.gms.internal.measurement.zzg.zza(r7.zza(r3.get(0)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x05cd, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x05ce, code lost:
        r1 = r2.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05d0, code lost:
        if (r0 < 0) goto L_0x05e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x05d6, code lost:
        if (r0 < r1.length()) goto L_0x05d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05e6, code lost:
        return new com.google.android.gms.internal.measurement.zzas(java.lang.String.valueOf(r1.charAt(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05e9, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05ea, code lost:
        com.google.android.gms.internal.measurement.zzg.zza(r16, 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05ff, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r19.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0600, code lost:
        r2 = r19;
        com.google.android.gms.internal.measurement.zzg.zza("toString", 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0609, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x060a, code lost:
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zza(r6, 1, r3);
        r0 = r19.zza;
        r1 = r21.zza(r3.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x062b, code lost:
        if ("length".equals(r1.zzf()) == false) goto L_0x0630;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x062f, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0630, code lost:
        r3 = r1.zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x063e, code lost:
        if (r3 != java.lang.Math.floor(r3)) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0640, code lost:
        r1 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0641, code lost:
        if (r1 < 0) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0647, code lost:
        if (r1 >= r0.length()) goto L_0x064c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x064b, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x064e, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0136, code lost:
        r18 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015d, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016d, code lost:
        r16 = "toLocaleLowerCase";
        r0 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0171, code lost:
        switch(r18) {
            case 0: goto L_0x060a;
            case 1: goto L_0x0600;
            case 2: goto L_0x05ea;
            case 3: goto L_0x05a4;
            case 4: goto L_0x056b;
            case 5: goto L_0x0554;
            case 6: goto L_0x0503;
            case 7: goto L_0x04ef;
            case 8: goto L_0x048d;
            case 9: goto L_0x0477;
            case 10: goto L_0x0463;
            case 11: goto L_0x0419;
            case 12: goto L_0x0388;
            case 13: goto L_0x02d5;
            case 14: goto L_0x025b;
            case 15: goto L_0x01d7;
            case 16: goto L_0x017e;
            default: goto L_0x0174;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0174, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x017d, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x017e, code lost:
        r3 = r22;
        com.google.android.gms.internal.measurement.zzg.zzc("indexOf", 2, r3);
        r4 = r19.zza;
     */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x064f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r20, com.google.android.gms.internal.measurement.zzh r21, java.util.List<com.google.android.gms.internal.measurement.zzaq> r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            java.lang.String r2 = "toLowerCase"
            java.lang.String r0 = "toLocaleLowerCase"
            java.lang.String r3 = "toString"
            r16 = r4
            java.lang.String r4 = "hasOwnProperty"
            r17 = r14
            java.lang.String r14 = "toUpperCase"
            if (r5 != 0) goto L_0x009b
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r13.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x009b
            boolean r5 = r14.equals(r1)
            if (r5 != 0) goto L_0x009b
            r5 = r17
            boolean r17 = r5.equals(r1)
            if (r17 != 0) goto L_0x009d
            r17 = r4
            java.lang.String r4 = "trim"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0099
            goto L_0x009f
        L_0x0099:
            r4 = 0
            goto L_0x00a0
        L_0x009b:
            r5 = r17
        L_0x009d:
            r17 = r4
        L_0x009f:
            r4 = 1
        L_0x00a0:
            if (r4 == 0) goto L_0x064f
            r20.getClass()
            int r4 = r20.hashCode()
            r18 = -1
            switch(r4) {
                case -1789698943: goto L_0x0160;
                case -1776922004: goto L_0x0152;
                case -1464939364: goto L_0x0146;
                case -1361633751: goto L_0x013a;
                case -1354795244: goto L_0x012d;
                case -1137582698: goto L_0x0124;
                case -906336856: goto L_0x011b;
                case -726908483: goto L_0x0112;
                case -467511597: goto L_0x0108;
                case -399551817: goto L_0x00fe;
                case 3568674: goto L_0x00f2;
                case 103668165: goto L_0x00e8;
                case 109526418: goto L_0x00de;
                case 109648666: goto L_0x00d3;
                case 530542161: goto L_0x00c8;
                case 1094496948: goto L_0x00bd;
                case 1943291465: goto L_0x00b2;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            r4 = r16
            goto L_0x015d
        L_0x00b2:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00b9
            goto L_0x00ae
        L_0x00b9:
            r1 = 16
            goto L_0x0136
        L_0x00bd:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00c4
            goto L_0x00ae
        L_0x00c4:
            r1 = 15
            goto L_0x0136
        L_0x00c8:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00cf
            goto L_0x00ae
        L_0x00cf:
            r1 = 14
            goto L_0x0136
        L_0x00d3:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x00da
            goto L_0x00ae
        L_0x00da:
            r1 = 13
            goto L_0x0136
        L_0x00de:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x00e5
            goto L_0x00ae
        L_0x00e5:
            r1 = 12
            goto L_0x0136
        L_0x00e8:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00ef
            goto L_0x00ae
        L_0x00ef:
            r1 = 11
            goto L_0x0136
        L_0x00f2:
            java.lang.String r4 = "trim"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00fb
            goto L_0x00ae
        L_0x00fb:
            r1 = 10
            goto L_0x0136
        L_0x00fe:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x0105
            goto L_0x00ae
        L_0x0105:
            r1 = 9
            goto L_0x0136
        L_0x0108:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x010f
            goto L_0x00ae
        L_0x010f:
            r1 = 8
            goto L_0x0136
        L_0x0112:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0119
            goto L_0x00ae
        L_0x0119:
            r1 = 7
            goto L_0x0136
        L_0x011b:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0122
            goto L_0x00ae
        L_0x0122:
            r1 = 6
            goto L_0x0136
        L_0x0124:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012b
            goto L_0x00ae
        L_0x012b:
            r1 = 5
            goto L_0x0136
        L_0x012d:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0135
            goto L_0x00ae
        L_0x0135:
            r1 = 4
        L_0x0136:
            r18 = r1
            goto L_0x00ae
        L_0x013a:
            r4 = r16
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0143
            goto L_0x014e
        L_0x0143:
            r18 = 3
            goto L_0x015d
        L_0x0146:
            r4 = r16
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x014f
        L_0x014e:
            goto L_0x015a
        L_0x014f:
            r18 = 2
            goto L_0x015d
        L_0x0152:
            r4 = r16
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x015b
        L_0x015a:
            goto L_0x015d
        L_0x015b:
            r18 = 1
        L_0x015d:
            r6 = r17
            goto L_0x016d
        L_0x0160:
            r4 = r16
            r6 = r17
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r18 = 0
        L_0x016d:
            r16 = r0
            r0 = 0
            switch(r18) {
                case 0: goto L_0x060a;
                case 1: goto L_0x0600;
                case 2: goto L_0x05ea;
                case 3: goto L_0x05a4;
                case 4: goto L_0x056b;
                case 5: goto L_0x0554;
                case 6: goto L_0x0503;
                case 7: goto L_0x04ef;
                case 8: goto L_0x048d;
                case 9: goto L_0x0477;
                case 10: goto L_0x0463;
                case 11: goto L_0x0419;
                case 12: goto L_0x0388;
                case 13: goto L_0x02d5;
                case 14: goto L_0x025b;
                case 15: goto L_0x01d7;
                case 16: goto L_0x017e;
                default: goto L_0x0174;
            }
        L_0x0174:
            r2 = r19
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x017e:
            r2 = 2
            r3 = r22
            com.google.android.gms.internal.measurement.zzg.zzc(r7, r2, r3)
            r2 = r19
            java.lang.String r4 = r2.zza
            int r5 = r22.size()
            if (r5 > 0) goto L_0x0197
            com.google.android.gms.internal.measurement.zzaq r5 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r5 = r5.zzf()
            r7 = r21
            goto L_0x01a8
        L_0x0197:
            r5 = 0
            java.lang.Object r5 = r3.get(r5)
            com.google.android.gms.internal.measurement.zzaq r5 = (com.google.android.gms.internal.measurement.zzaq) r5
            r7 = r21
            com.google.android.gms.internal.measurement.zzaq r5 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r5)
            java.lang.String r5 = r5.zzf()
        L_0x01a8:
            int r6 = r22.size()
            r8 = 2
            if (r6 >= r8) goto L_0x01b0
            goto L_0x01c3
        L_0x01b0:
            r0 = 1
            java.lang.Object r0 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r0 = r0.doubleValue()
        L_0x01c3:
            double r0 = com.google.android.gms.internal.measurement.zzg.zza((double) r0)
            com.google.android.gms.internal.measurement.zzai r3 = new com.google.android.gms.internal.measurement.zzai
            int r0 = (int) r0
            int r0 = r4.indexOf(r5, r0)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.<init>(r0)
            return r3
        L_0x01d7:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r8, r0, r3)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r1 = r0.zzf()
            boolean r4 = r22.isEmpty()
            if (r4 != 0) goto L_0x020d
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
            int r4 = r22.size()
            r5 = 1
            if (r4 <= r5) goto L_0x020d
            java.lang.Object r0 = r3.get(r5)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
        L_0x020d:
            java.lang.String r3 = r2.zza
            int r4 = r3.indexOf(r1)
            if (r4 >= 0) goto L_0x0216
            return r2
        L_0x0216:
            boolean r5 = r0 instanceof com.google.android.gms.internal.measurement.zzal
            if (r5 == 0) goto L_0x023f
            com.google.android.gms.internal.measurement.zzal r0 = (com.google.android.gms.internal.measurement.zzal) r0
            r5 = 3
            com.google.android.gms.internal.measurement.zzaq[] r5 = new com.google.android.gms.internal.measurement.zzaq[r5]
            com.google.android.gms.internal.measurement.zzas r6 = new com.google.android.gms.internal.measurement.zzas
            r6.<init>(r1)
            r8 = 0
            r5[r8] = r6
            com.google.android.gms.internal.measurement.zzai r6 = new com.google.android.gms.internal.measurement.zzai
            double r8 = (double) r4
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r6.<init>(r8)
            r8 = 1
            r5[r8] = r6
            r6 = 2
            r5[r6] = r2
            java.util.List r5 = java.util.Arrays.asList(r5)
            com.google.android.gms.internal.measurement.zzaq r0 = r0.zza((com.google.android.gms.internal.measurement.zzh) r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r5)
        L_0x023f:
            com.google.android.gms.internal.measurement.zzas r5 = new com.google.android.gms.internal.measurement.zzas
            r6 = 0
            java.lang.String r6 = r3.substring(r6, r4)
            java.lang.String r0 = r0.zzf()
            int r1 = r1.length()
            int r1 = r1 + r4
            java.lang.String r1 = r3.substring(r1)
            java.lang.String r0 = defpackage.xx.D(r6, r0, r1)
            r5.<init>(r0)
            return r5
        L_0x025b:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r9, r0, r3)
            java.lang.String r0 = r2.zza
            boolean r1 = r22.isEmpty()
            if (r1 != 0) goto L_0x0286
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.Double r1 = r1.zze()
            double r4 = r1.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzg.zza((double) r4)
            int r1 = (int) r4
            goto L_0x0287
        L_0x0286:
            r1 = 0
        L_0x0287:
            int r4 = r22.size()
            r5 = 1
            if (r4 <= r5) goto L_0x02a6
            java.lang.Object r3 = r3.get(r5)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzg.zza((double) r3)
            int r3 = (int) r3
            goto L_0x02aa
        L_0x02a6:
            int r3 = r0.length()
        L_0x02aa:
            r4 = 0
            int r1 = java.lang.Math.max(r1, r4)
            int r5 = r0.length()
            int r1 = java.lang.Math.min(r1, r5)
            int r3 = java.lang.Math.max(r3, r4)
            int r4 = r0.length()
            int r3 = java.lang.Math.min(r3, r4)
            com.google.android.gms.internal.measurement.zzas r4 = new com.google.android.gms.internal.measurement.zzas
            int r5 = java.lang.Math.min(r1, r3)
            int r1 = java.lang.Math.max(r1, r3)
            java.lang.String r0 = r0.substring(r5, r1)
            r4.<init>(r0)
            return r4
        L_0x02d5:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r10, r0, r3)
            java.lang.String r0 = r2.zza
            int r1 = r0.length()
            if (r1 != 0) goto L_0x02f3
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r1 = 1
            com.google.android.gms.internal.measurement.zzaq[] r1 = new com.google.android.gms.internal.measurement.zzaq[r1]
            r3 = 0
            r1[r3] = r2
            r0.<init>((com.google.android.gms.internal.measurement.zzaq[]) r1)
            return r0
        L_0x02f3:
            r1 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r22.isEmpty()
            if (r5 == 0) goto L_0x0304
            r4.add(r2)
            goto L_0x0382
        L_0x0304:
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
            int r5 = r22.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0330
            java.lang.Object r3 = r3.get(r6)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r5 = r3.doubleValue()
            long r5 = com.google.android.gms.internal.measurement.zzg.zzc(r5)
            goto L_0x0333
        L_0x0330:
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x0333:
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x033f
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x033f:
            java.lang.String r3 = java.util.regex.Pattern.quote(r1)
            int r7 = (int) r5
            int r7 = r7 + 1
            java.lang.String[] r0 = r0.split(r3, r7)
            int r3 = r0.length
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x036a
            int r1 = r0.length
            if (r1 <= 0) goto L_0x036a
            r1 = 0
            r1 = r0[r1]
            boolean r1 = r1.isEmpty()
            int r7 = r0.length
            int r7 = r7 + -1
            r7 = r0[r7]
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x036b
            int r3 = r0.length
            int r3 = r3 + -1
            goto L_0x036b
        L_0x036a:
            r1 = 0
        L_0x036b:
            int r7 = r0.length
            long r7 = (long) r7
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0373
            int r3 = r3 + -1
        L_0x0373:
            if (r1 >= r3) goto L_0x0382
            com.google.android.gms.internal.measurement.zzas r5 = new com.google.android.gms.internal.measurement.zzas
            r6 = r0[r1]
            r5.<init>(r6)
            r4.add(r5)
            int r1 = r1 + 1
            goto L_0x0373
        L_0x0382:
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>((java.util.List<com.google.android.gms.internal.measurement.zzaq>) r4)
            return r0
        L_0x0388:
            r2 = r19
            r7 = r21
            r3 = r22
            r4 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r11, r4, r3)
            java.lang.String r4 = r2.zza
            boolean r5 = r22.isEmpty()
            if (r5 != 0) goto L_0x03ae
            r5 = 0
            java.lang.Object r5 = r3.get(r5)
            com.google.android.gms.internal.measurement.zzaq r5 = (com.google.android.gms.internal.measurement.zzaq) r5
            com.google.android.gms.internal.measurement.zzaq r5 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r5)
            java.lang.Double r5 = r5.zze()
            double r5 = r5.doubleValue()
            goto L_0x03af
        L_0x03ae:
            r5 = r0
        L_0x03af:
            double r5 = com.google.android.gms.internal.measurement.zzg.zza((double) r5)
            int r8 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x03c2
            int r8 = r4.length()
            double r8 = (double) r8
            double r8 = r8 + r5
            double r5 = java.lang.Math.max(r8, r0)
            goto L_0x03cb
        L_0x03c2:
            int r8 = r4.length()
            double r8 = (double) r8
            double r5 = java.lang.Math.min(r5, r8)
        L_0x03cb:
            int r5 = (int) r5
            int r6 = r22.size()
            r8 = 1
            if (r6 <= r8) goto L_0x03e6
            java.lang.Object r3 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r6 = r3.doubleValue()
            goto L_0x03eb
        L_0x03e6:
            int r3 = r4.length()
            double r6 = (double) r3
        L_0x03eb:
            double r6 = com.google.android.gms.internal.measurement.zzg.zza((double) r6)
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x03fe
            int r3 = r4.length()
            double r8 = (double) r3
            double r8 = r8 + r6
            double r0 = java.lang.Math.max(r8, r0)
            goto L_0x0407
        L_0x03fe:
            int r0 = r4.length()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r6, r0)
        L_0x0407:
            int r0 = (int) r0
            int r0 = r0 - r5
            r1 = 0
            int r0 = java.lang.Math.max(r1, r0)
            int r0 = r0 + r5
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r4.substring(r5, r0)
            r1.<init>(r0)
            return r1
        L_0x0419:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r12, r0, r3)
            java.lang.String r0 = r2.zza
            int r1 = r22.size()
            if (r1 > 0) goto L_0x042e
            java.lang.String r1 = ""
            goto L_0x043d
        L_0x042e:
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
        L_0x043d:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0460
            com.google.android.gms.internal.measurement.zzaf r1 = new com.google.android.gms.internal.measurement.zzaf
            r3 = 1
            com.google.android.gms.internal.measurement.zzaq[] r3 = new com.google.android.gms.internal.measurement.zzaq[r3]
            com.google.android.gms.internal.measurement.zzas r4 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.group()
            r4.<init>(r0)
            r0 = 0
            r3[r0] = r4
            r1.<init>((com.google.android.gms.internal.measurement.zzaq[]) r3)
            return r1
        L_0x0460:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzd
            return r0
        L_0x0463:
            r2 = r19
            r3 = r22
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r14, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            return r1
        L_0x0477:
            r2 = r19
            r3 = r22
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r14, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r3)
            r1.<init>(r0)
            return r1
        L_0x048d:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r13, r0, r3)
            java.lang.String r0 = r2.zza
            int r1 = r22.size()
            if (r1 > 0) goto L_0x04a6
            com.google.android.gms.internal.measurement.zzaq r1 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r1 = r1.zzf()
            goto L_0x04b5
        L_0x04a6:
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
        L_0x04b5:
            int r4 = r22.size()
            r5 = 2
            if (r4 >= r5) goto L_0x04bf
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x04d2
        L_0x04bf:
            r4 = 1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
        L_0x04d2:
            boolean r5 = java.lang.Double.isNaN(r3)
            if (r5 == 0) goto L_0x04db
            r3 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x04df
        L_0x04db:
            double r3 = com.google.android.gms.internal.measurement.zzg.zza((double) r3)
        L_0x04df:
            com.google.android.gms.internal.measurement.zzai r5 = new com.google.android.gms.internal.measurement.zzai
            int r3 = (int) r3
            int r0 = r0.lastIndexOf(r1, r3)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r5.<init>(r0)
            return r5
        L_0x04ef:
            r2 = r19
            r3 = r22
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r5, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            return r1
        L_0x0503:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r15, r1, r3)
            boolean r1 = r22.isEmpty()
            if (r1 != 0) goto L_0x0523
            java.lang.Object r0 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.String r0 = r0.zzf()
            goto L_0x0529
        L_0x0523:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r0 = r0.zzf()
        L_0x0529:
            java.lang.String r1 = r2.zza
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0548
            com.google.android.gms.internal.measurement.zzai r1 = new com.google.android.gms.internal.measurement.zzai
            int r0 = r0.start()
            double r3 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            r1.<init>(r0)
            return r1
        L_0x0548:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r0.<init>(r1)
            return r0
        L_0x0554:
            r3 = r22
            r0 = r2
            r2 = r19
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r3)
            r1.<init>(r0)
            return r1
        L_0x056b:
            r2 = r19
            r7 = r21
            r3 = r22
            boolean r0 = r22.isEmpty()
            if (r0 == 0) goto L_0x0578
            return r2
        L_0x0578:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = r2.zza
            r0.<init>(r1)
            r1 = 0
        L_0x0580:
            int r4 = r22.size()
            if (r1 >= r4) goto L_0x059a
            java.lang.Object r4 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r4 = (com.google.android.gms.internal.measurement.zzaq) r4
            com.google.android.gms.internal.measurement.zzaq r4 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r4)
            java.lang.String r4 = r4.zzf()
            r0.append(r4)
            int r1 = r1 + 1
            goto L_0x0580
        L_0x059a:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            return r1
        L_0x05a4:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r4, r0, r3)
            boolean r0 = r22.isEmpty()
            if (r0 != 0) goto L_0x05cd
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzg.zza((double) r0)
            int r0 = (int) r0
            goto L_0x05ce
        L_0x05cd:
            r0 = 0
        L_0x05ce:
            java.lang.String r1 = r2.zza
            if (r0 < 0) goto L_0x05e7
            int r3 = r1.length()
            if (r0 < r3) goto L_0x05d9
            goto L_0x05e7
        L_0x05d9:
            com.google.android.gms.internal.measurement.zzas r3 = new com.google.android.gms.internal.measurement.zzas
            char r0 = r1.charAt(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3.<init>(r0)
            return r3
        L_0x05e7:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzj
            return r0
        L_0x05ea:
            r2 = r19
            r3 = r22
            r0 = r16
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            return r1
        L_0x0600:
            r2 = r19
            r0 = r3
            r3 = r22
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            return r2
        L_0x060a:
            r2 = r19
            r7 = r21
            r3 = r22
            r0 = 1
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r6, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r2.zza
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r7.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r3 = r1.zzf()
            java.lang.String r4 = "length"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0630
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x0630:
            java.lang.Double r1 = r1.zze()
            double r3 = r1.doubleValue()
            double r5 = java.lang.Math.floor(r3)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x064c
            int r1 = (int) r3
            if (r1 < 0) goto L_0x064c
            int r0 = r0.length()
            if (r1 >= r0) goto L_0x064c
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x064c:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x064f:
            r2 = r19
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zza(java.lang.String, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }
}
