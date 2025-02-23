package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzku {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzkt zzkt, String str) {
        StringBuilder n = lf.n("# ", str);
        zza(zzkt, n, 0);
        return n.toString();
    }

    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    public static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza2 : (List) obj) {
                zza(sb, i, str, zza2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza3 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza3);
            }
        } else {
            sb.append(10);
            zza(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzmb.zza(zzia.zza((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzia) {
                sb.append(": \"");
                sb.append(zzmb.zza((zzia) obj));
                sb.append('\"');
            } else if (obj instanceof zzjk) {
                sb.append(" {");
                zza((zzjk) obj, sb, i + 2);
                sb.append("\n");
                zza(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i + 2;
                zza(sb, i3, "key", entry.getKey());
                zza(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zza(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0184, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0193, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a5, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01bb, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L_0x01ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzkt r20, java.lang.StringBuilder r21, int r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.lang.Class r6 = r20.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            java.lang.String r11 = "has"
            java.lang.String r12 = "set"
            r13 = 3
            if (r9 >= r7) goto L_0x0088
            r14 = r6[r9]
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 != 0) goto L_0x0085
            java.lang.String r15 = r14.getName()
            int r15 = r15.length()
            if (r15 < r13) goto L_0x0085
            java.lang.String r13 = r14.getName()
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x0051
            java.lang.String r10 = r14.getName()
            r3.add(r10)
            goto L_0x0085
        L_0x0051:
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0085
            java.lang.Class[] r12 = r14.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x0085
            java.lang.String r12 = r14.getName()
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto L_0x0074
            java.lang.String r10 = r14.getName()
            r4.put(r10, r14)
            goto L_0x0085
        L_0x0074:
            java.lang.String r11 = r14.getName()
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x0085
            java.lang.String r10 = r14.getName()
            r5.put(r10, r14)
        L_0x0085:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x0088:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0090:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x020a
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.substring(r13)
            java.lang.String r13 = "List"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x00e5
            java.lang.String r14 = "OrBuilderList"
            boolean r14 = r9.endsWith(r14)
            if (r14 != 0) goto L_0x00e5
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x00e5
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x00e5
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.List> r15 = java.util.List.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00e5
            int r7 = r9.length()
            int r7 = r7 + -4
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzjk.zza((java.lang.reflect.Method) r13, (java.lang.Object) r0, (java.lang.Object[]) r9)
            zza(r1, r2, r7, r9)
            r13 = 3
            goto L_0x0090
        L_0x00e5:
            java.lang.String r13 = "Map"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x012f
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x012f
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x012f
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x012f
            java.lang.Class<java.lang.Deprecated> r14 = java.lang.Deprecated.class
            boolean r14 = r13.isAnnotationPresent(r14)
            if (r14 != 0) goto L_0x012f
            int r14 = r13.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isPublic(r14)
            if (r14 == 0) goto L_0x012f
            int r7 = r9.length()
            r14 = 3
            int r7 = r7 - r14
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzjk.zza((java.lang.reflect.Method) r13, (java.lang.Object) r0, (java.lang.Object[]) r9)
            zza(r1, r2, r7, r9)
            r13 = r14
            goto L_0x0090
        L_0x012f:
            r13 = 3
            java.lang.String r14 = r12.concat(r9)
            boolean r14 = r3.contains(r14)
            if (r14 == 0) goto L_0x0090
            java.lang.String r14 = "Bytes"
            boolean r14 = r9.endsWith(r14)
            if (r14 == 0) goto L_0x015e
            int r14 = r9.length()
            int r14 = r14 + -5
            java.lang.String r14 = r9.substring(r8, r14)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r10)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            boolean r14 = r5.containsKey(r14)
            if (r14 != 0) goto L_0x0090
        L_0x015e:
            java.lang.Object r7 = r7.getValue()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            java.lang.String r14 = r11.concat(r9)
            java.lang.Object r14 = r4.get(r14)
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14
            if (r7 == 0) goto L_0x0090
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzjk.zza((java.lang.reflect.Method) r7, (java.lang.Object) r0, (java.lang.Object[]) r15)
            if (r14 != 0) goto L_0x01f7
            boolean r14 = r7 instanceof java.lang.Boolean
            r15 = 1
            if (r14 == 0) goto L_0x0188
            r14 = r7
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L_0x01f1
            goto L_0x01ef
        L_0x0188:
            boolean r14 = r7 instanceof java.lang.Integer
            if (r14 == 0) goto L_0x0196
            r14 = r7
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r14 != 0) goto L_0x01f1
            goto L_0x01ef
        L_0x0196:
            boolean r14 = r7 instanceof java.lang.Float
            if (r14 == 0) goto L_0x01a8
            r14 = r7
            java.lang.Float r14 = (java.lang.Float) r14
            float r14 = r14.floatValue()
            int r14 = java.lang.Float.floatToRawIntBits(r14)
            if (r14 != 0) goto L_0x01f1
            goto L_0x01ef
        L_0x01a8:
            boolean r14 = r7 instanceof java.lang.Double
            if (r14 == 0) goto L_0x01be
            r14 = r7
            java.lang.Double r14 = (java.lang.Double) r14
            double r16 = r14.doubleValue()
            long r16 = java.lang.Double.doubleToRawLongBits(r16)
            r18 = 0
            int r14 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r14 != 0) goto L_0x01f1
            goto L_0x01ef
        L_0x01be:
            boolean r14 = r7 instanceof java.lang.String
            if (r14 == 0) goto L_0x01c9
            java.lang.String r14 = ""
            boolean r14 = r7.equals(r14)
            goto L_0x01f2
        L_0x01c9:
            boolean r14 = r7 instanceof com.google.android.gms.internal.measurement.zzia
            if (r14 == 0) goto L_0x01d4
            com.google.android.gms.internal.measurement.zzia r14 = com.google.android.gms.internal.measurement.zzia.zza
            boolean r14 = r7.equals(r14)
            goto L_0x01f2
        L_0x01d4:
            boolean r14 = r7 instanceof com.google.android.gms.internal.measurement.zzkt
            if (r14 == 0) goto L_0x01e2
            r14 = r7
            com.google.android.gms.internal.measurement.zzkt r14 = (com.google.android.gms.internal.measurement.zzkt) r14
            com.google.android.gms.internal.measurement.zzkt r14 = r14.zzcj()
            if (r7 != r14) goto L_0x01f1
            goto L_0x01ef
        L_0x01e2:
            boolean r14 = r7 instanceof java.lang.Enum
            if (r14 == 0) goto L_0x01f1
            r14 = r7
            java.lang.Enum r14 = (java.lang.Enum) r14
            int r14 = r14.ordinal()
            if (r14 != 0) goto L_0x01f1
        L_0x01ef:
            r14 = r15
            goto L_0x01f2
        L_0x01f1:
            r14 = r8
        L_0x01f2:
            if (r14 != 0) goto L_0x01f5
            goto L_0x0203
        L_0x01f5:
            r15 = r8
            goto L_0x0203
        L_0x01f7:
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Object r14 = com.google.android.gms.internal.measurement.zzjk.zza((java.lang.reflect.Method) r14, (java.lang.Object) r0, (java.lang.Object[]) r15)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r15 = r14.booleanValue()
        L_0x0203:
            if (r15 == 0) goto L_0x0090
            zza(r1, r2, r9, r7)
            goto L_0x0090
        L_0x020a:
            boolean r3 = r0 instanceof com.google.android.gms.internal.measurement.zzjk.zzd
            if (r3 == 0) goto L_0x0230
            r3 = r0
            com.google.android.gms.internal.measurement.zzjk$zzd r3 = (com.google.android.gms.internal.measurement.zzjk.zzd) r3
            com.google.android.gms.internal.measurement.zzjd<com.google.android.gms.internal.measurement.zzjk$zzc> r3 = r3.zzc
            java.util.Iterator r3 = r3.zzd()
            boolean r4 = r3.hasNext()
            if (r4 != 0) goto L_0x021e
            goto L_0x0230
        L_0x021e:
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getKey()
            com.google.android.gms.internal.measurement.zzjk$zzc r0 = (com.google.android.gms.internal.measurement.zzjk.zzc) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0230:
            com.google.android.gms.internal.measurement.zzjk r0 = (com.google.android.gms.internal.measurement.zzjk) r0
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzb
            if (r0 == 0) goto L_0x0239
            r0.zza((java.lang.StringBuilder) r1, (int) r2)
        L_0x0239:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(com.google.android.gms.internal.measurement.zzkt, java.lang.StringBuilder, int):void");
    }
}
