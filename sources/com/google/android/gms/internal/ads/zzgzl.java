package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzl {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzgzj zzgzj, String str) {
        StringBuilder n = lf.n("# ", str);
        zzd(zzgzj, n, 0);
        return n.toString();
    }

    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzc(i, sb);
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
                sb.append(zzhaq.zza(zzgwm.zzw((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzgwm) {
                sb.append(": \"");
                sb.append(zzhaq.zza((zzgwm) obj));
                sb.append('\"');
            } else if (obj instanceof zzgxy) {
                sb.append(" {");
                zzd((zzgxy) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb, i3, "key", entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzgzj zzgzj, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzgzj zzgzj2 = zzgzj;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzgzj.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzgxy.zzbR(method2, zzgzj2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzgxy.zzbR(method, zzgzj2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzbR = zzgxy.zzbR(method4, zzgzj2, new Object[0]);
                    if (method5 == null) {
                        if (zzbR instanceof Boolean) {
                            if (!((Boolean) zzbR).booleanValue()) {
                            }
                        } else if (zzbR instanceof Integer) {
                            if (((Integer) zzbR).intValue() == 0) {
                            }
                        } else if (zzbR instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbR).floatValue()) == 0) {
                            }
                        } else if (!(zzbR instanceof Double)) {
                            if (zzbR instanceof String) {
                                z = zzbR.equals("");
                            } else if (zzbR instanceof zzgwm) {
                                z = zzbR.equals(zzgwm.zzb);
                            } else if (zzbR instanceof zzgzj) {
                                if (zzbR == ((zzgzj) zzbR).zzbt()) {
                                }
                            } else if ((zzbR instanceof Enum) && ((Enum) zzbR).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbR).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzgxy.zzbR(method5, zzgzj2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzbR);
                }
            }
            i2 = 3;
        }
        if (zzgzj2 instanceof zzgxu) {
            Iterator zzf = ((zzgxu) zzgzj2).zza.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb2, i3, C1058d.y("[", ((zzgxv) entry2.getKey()).zza, "]"), entry2.getValue());
            }
        }
        zzhat zzhat = ((zzgxy) zzgzj2).zzt;
        if (zzhat != null) {
            zzhat.zzi(sb2, i3);
        }
    }
}
