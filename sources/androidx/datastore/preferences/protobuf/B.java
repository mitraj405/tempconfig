package androidx.datastore.preferences.protobuf;

import defpackage.x3;
import java.util.List;
import java.util.Map;

/* compiled from: MessageLiteToString */
public final class B {
    public static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static final void b(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object b : (List) obj) {
                b(sb, i, str, b);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry b2 : ((Map) obj).entrySet()) {
                b(sb, i, str, b2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                x3.e eVar = x3.f3407a;
                sb.append(C1488xu.h(new x3.e(((String) obj).getBytes(p.a))));
                sb.append('\"');
            } else if (obj instanceof x3) {
                sb.append(": \"");
                sb.append(C1488xu.h((x3) obj));
                sb.append('\"');
            } else if (obj instanceof n) {
                sb.append(" {");
                c((n) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                b(sb, i4, "key", entry.getKey());
                b(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ad, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01be, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d0, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L_0x0202;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(androidx.datastore.preferences.protobuf.A r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeSet r5 = new java.util.TreeSet
            r5.<init>()
            java.lang.Class r6 = r18.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            if (r9 >= r7) goto L_0x004f
            r11 = r6[r9]
            java.lang.String r12 = r11.getName()
            r4.put(r12, r11)
            java.lang.Class[] r12 = r11.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = r11.getName()
            r3.put(r12, r11)
            java.lang.String r12 = r11.getName()
            boolean r10 = r12.startsWith(r10)
            if (r10 == 0) goto L_0x004c
            java.lang.String r10 = r11.getName()
            r5.add(r10)
        L_0x004c:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x004f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0053:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0221
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = ""
            java.lang.String r9 = r6.replaceFirst(r10, r7)
            java.lang.String r11 = "List"
            boolean r12 = r9.endsWith(r11)
            r13 = 1
            if (r12 == 0) goto L_0x00bf
            java.lang.String r12 = "OrBuilderList"
            boolean r12 = r9.endsWith(r12)
            if (r12 != 0) goto L_0x00bf
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x00bf
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r9.substring(r8, r13)
            java.lang.String r12 = r12.toLowerCase()
            r11.append(r12)
            int r12 = r9.length()
            int r12 = r12 + -4
            java.lang.String r12 = r9.substring(r13, r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Object r12 = r3.get(r6)
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            if (r12 == 0) goto L_0x00bf
            java.lang.Class r14 = r12.getReturnType()
            java.lang.Class<java.util.List> r15 = java.util.List.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00bf
            java.lang.String r6 = a(r11)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.n.k(r12, r0, r7)
            b(r1, r2, r6, r7)
            goto L_0x0053
        L_0x00bf:
            java.lang.String r11 = "Map"
            boolean r12 = r9.endsWith(r11)
            if (r12 == 0) goto L_0x0123
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x0123
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r9.substring(r8, r13)
            java.lang.String r12 = r12.toLowerCase()
            r11.append(r12)
            int r12 = r9.length()
            int r12 = r12 + -3
            java.lang.String r12 = r9.substring(r13, r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Object r6 = r3.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 == 0) goto L_0x0123
            java.lang.Class r12 = r6.getReturnType()
            java.lang.Class<java.util.Map> r14 = java.util.Map.class
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0123
            java.lang.Class<java.lang.Deprecated> r12 = java.lang.Deprecated.class
            boolean r12 = r6.isAnnotationPresent(r12)
            if (r12 != 0) goto L_0x0123
            int r12 = r6.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0123
            java.lang.String r7 = a(r11)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.n.k(r6, r0, r9)
            b(r1, r2, r7, r6)
            goto L_0x0053
        L_0x0123:
            java.lang.String r6 = "set"
            java.lang.String r6 = r6.concat(r9)
            java.lang.Object r6 = r4.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x0133
            goto L_0x0053
        L_0x0133:
            java.lang.String r6 = "Bytes"
            boolean r6 = r9.endsWith(r6)
            if (r6 == 0) goto L_0x0159
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r10)
            int r11 = r9.length()
            int r11 = r11 + -5
            java.lang.String r11 = r9.substring(r8, r11)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            boolean r6 = r3.containsKey(r6)
            if (r6 == 0) goto L_0x0159
            goto L_0x0053
        L_0x0159:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = r9.substring(r8, r13)
            java.lang.String r11 = r11.toLowerCase()
            r6.append(r11)
            java.lang.String r11 = r9.substring(r13)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r11 = r10.concat(r9)
            java.lang.Object r11 = r3.get(r11)
            java.lang.reflect.Method r11 = (java.lang.reflect.Method) r11
            java.lang.String r12 = "has"
            java.lang.String r9 = r12.concat(r9)
            java.lang.Object r9 = r3.get(r9)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r11 == 0) goto L_0x0053
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Object r11 = androidx.datastore.preferences.protobuf.n.k(r11, r0, r12)
            if (r9 != 0) goto L_0x020a
            boolean r9 = r11 instanceof java.lang.Boolean
            if (r9 == 0) goto L_0x01a2
            r7 = r11
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r7 = r7 ^ r13
            goto L_0x0205
        L_0x01a2:
            boolean r9 = r11 instanceof java.lang.Integer
            if (r9 == 0) goto L_0x01b0
            r7 = r11
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x0204
            goto L_0x0202
        L_0x01b0:
            boolean r9 = r11 instanceof java.lang.Float
            if (r9 == 0) goto L_0x01c1
            r7 = r11
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0204
            goto L_0x0202
        L_0x01c1:
            boolean r9 = r11 instanceof java.lang.Double
            if (r9 == 0) goto L_0x01d3
            r7 = r11
            java.lang.Double r7 = (java.lang.Double) r7
            double r14 = r7.doubleValue()
            r16 = 0
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x0204
            goto L_0x0202
        L_0x01d3:
            boolean r9 = r11 instanceof java.lang.String
            if (r9 == 0) goto L_0x01dc
            boolean r7 = r11.equals(r7)
            goto L_0x0205
        L_0x01dc:
            boolean r7 = r11 instanceof defpackage.x3
            if (r7 == 0) goto L_0x01e7
            x3$e r7 = defpackage.x3.f3407a
            boolean r7 = r11.equals(r7)
            goto L_0x0205
        L_0x01e7:
            boolean r7 = r11 instanceof androidx.datastore.preferences.protobuf.A
            if (r7 == 0) goto L_0x01f5
            r7 = r11
            androidx.datastore.preferences.protobuf.A r7 = (androidx.datastore.preferences.protobuf.A) r7
            androidx.datastore.preferences.protobuf.n r7 = r7.d()
            if (r11 != r7) goto L_0x0204
            goto L_0x0202
        L_0x01f5:
            boolean r7 = r11 instanceof java.lang.Enum
            if (r7 == 0) goto L_0x0204
            r7 = r11
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
            if (r7 != 0) goto L_0x0204
        L_0x0202:
            r7 = r13
            goto L_0x0205
        L_0x0204:
            r7 = r8
        L_0x0205:
            if (r7 != 0) goto L_0x0208
            goto L_0x0216
        L_0x0208:
            r13 = r8
            goto L_0x0216
        L_0x020a:
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.n.k(r9, r0, r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r13 = r7.booleanValue()
        L_0x0216:
            if (r13 == 0) goto L_0x0053
            java.lang.String r6 = a(r6)
            b(r1, r2, r6, r11)
            goto L_0x0053
        L_0x0221:
            boolean r3 = r0 instanceof androidx.datastore.preferences.protobuf.n.c
            if (r3 == 0) goto L_0x024d
            r3 = r0
            androidx.datastore.preferences.protobuf.n$c r3 = (androidx.datastore.preferences.protobuf.n.c) r3
            androidx.datastore.preferences.protobuf.l<androidx.datastore.preferences.protobuf.n$d> r3 = r3.extensions
            java.util.Iterator r3 = r3.k()
        L_0x022e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x024d
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            androidx.datastore.preferences.protobuf.n$d r5 = (androidx.datastore.preferences.protobuf.n.d) r5
            r5.getClass()
            java.lang.String r5 = "[0]"
            java.lang.Object r4 = r4.getValue()
            b(r1, r2, r5, r4)
            goto L_0x022e
        L_0x024d:
            androidx.datastore.preferences.protobuf.n r0 = (androidx.datastore.preferences.protobuf.n) r0
            androidx.datastore.preferences.protobuf.L r0 = r0.unknownFields
            if (r0 == 0) goto L_0x026b
        L_0x0253:
            int r3 = r0.f1922a
            if (r8 >= r3) goto L_0x026b
            int[] r3 = r0.f1924a
            r3 = r3[r8]
            int r3 = r3 >>> 3
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object[] r4 = r0.f1925a
            r4 = r4[r8]
            b(r1, r2, r3, r4)
            int r8 = r8 + 1
            goto L_0x0253
        L_0x026b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.B.c(androidx.datastore.preferences.protobuf.A, java.lang.StringBuilder, int):void");
    }
}
