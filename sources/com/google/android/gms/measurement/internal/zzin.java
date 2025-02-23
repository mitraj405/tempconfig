package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzin {
    public static final zzin zza = new zzin((Boolean) null, (Boolean) null, 100);
    private final EnumMap<zza, zzim> zzb;
    private final int zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");
        
        public final String zze;

        private zza(String str) {
            this.zze = str;
        }
    }

    private zzin(EnumMap<zza, zzim> enumMap, int i) {
        EnumMap<zza, zzim> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public static String zza(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i != 90) {
            return i != 100 ? "OTHER" : "UNKNOWN";
        }
        return "REMOTE_CONFIG";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzin)) {
            return false;
        }
        zzin zzin = (zzin) obj;
        for (zza zza2 : zzio.STORAGE.zzd) {
            if (this.zzb.get(zza2) != zzin.zzb.get(zza2)) {
                return false;
            }
        }
        if (this.zzc == zzin.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzc * 17;
        for (zzim hashCode : this.zzb.values()) {
            i = (i * 31) + hashCode.hashCode();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zza(this.zzc));
        for (zza zza2 : zzio.STORAGE.zzd) {
            sb.append(",");
            sb.append(zza2.zze);
            sb.append("=");
            zzim zzim = this.zzb.get(zza2);
            if (zzim == null) {
                zzim = zzim.UNINITIALIZED;
            }
            sb.append(zzim);
        }
        return sb.toString();
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry next : this.zzb.entrySet()) {
            String zzb2 = zzb((zzim) next.getValue());
            if (zzb2 != null) {
                bundle.putString(((zza) next.getKey()).zze, zzb2);
            }
        }
        return bundle;
    }

    public final zzim zzc() {
        zzim zzim = this.zzb.get(zza.AD_STORAGE);
        return zzim == null ? zzim.UNINITIALIZED : zzim;
    }

    public final zzim zzd() {
        zzim zzim = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zzim == null) {
            return zzim.UNINITIALIZED;
        }
        return zzim;
    }

    public final Boolean zze() {
        zzim zzim = this.zzb.get(zza.AD_STORAGE);
        if (zzim == null) {
            return null;
        }
        int ordinal = zzim.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                return Boolean.FALSE;
            }
            if (ordinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final Boolean zzf() {
        zzim zzim = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zzim == null) {
            return null;
        }
        int ordinal = zzim.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                return Boolean.FALSE;
            }
            if (ordinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final String zzg() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zza zza2 : zzio.STORAGE.zza()) {
            zzim zzim = this.zzb.get(zza2);
            char c = '-';
            if (!(zzim == null || (ordinal = zzim.ordinal()) == 0)) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zza2 : zzio.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zza2)));
        }
        return sb.toString();
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        for (zzim zzim : this.zzb.values()) {
            if (zzim != zzim.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public static boolean zza(int i, int i2) {
        return ((i == -20 && i2 == -30) || ((i == -30 && i2 == -20) || i == i2)) || i < i2;
    }

    public static char zza(zzim zzim) {
        if (zzim == null) {
            return '-';
        }
        int ordinal = zzim.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public final boolean zzc(zzin zzin) {
        return zzb(zzin, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final int zza() {
        return this.zzc;
    }

    public zzin(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zzim> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put(zza.AD_STORAGE, zza(bool));
        enumMap.put(zza.ANALYTICS_STORAGE, zza(bool2));
        this.zzc = i;
    }

    public static zzim zza(String str) {
        if (str == null) {
            return zzim.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzim.GRANTED;
        }
        if (str.equals("denied")) {
            return zzim.DENIED;
        }
        return zzim.UNINITIALIZED;
    }

    public static zzin zzb(String str) {
        return zza(str, 100);
    }

    public final zzin zzb(zzin zzin) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zza2 : zzio.STORAGE.zzd) {
            zzim zzim = this.zzb.get(zza2);
            if (zzim == zzim.UNINITIALIZED) {
                zzim = zzin.zzb.get(zza2);
            }
            if (zzim != null) {
                enumMap.put(zza2, zzim);
            }
        }
        return new zzin(enumMap, this.zzc);
    }

    public static zzim zza(char c) {
        if (c == '+') {
            return zzim.POLICY;
        }
        if (c == '0') {
            return zzim.DENIED;
        }
        if (c != '1') {
            return zzim.UNINITIALIZED;
        }
        return zzim.GRANTED;
    }

    public static String zzb(zzim zzim) {
        int ordinal = zzim.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    public final boolean zzb(zzin zzin, zza... zzaArr) {
        for (zza zza2 : zzaArr) {
            zzim zzim = this.zzb.get(zza2);
            zzim zzim2 = zzin.zzb.get(zza2);
            zzim zzim3 = zzim.DENIED;
            if (zzim == zzim3 && zzim2 != zzim3) {
                return true;
            }
        }
        return false;
    }

    public static zzim zza(Boolean bool) {
        if (bool == null) {
            return zzim.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzim.GRANTED;
        }
        return zzim.DENIED;
    }

    public static zzin zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzin((Boolean) null, (Boolean) null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zza2 : zzio.STORAGE.zzd) {
            enumMap.put(zza2, zza(bundle.getString(zza2.zze)));
        }
        return new zzin(enumMap, i);
    }

    public static zzin zza(zzim zzim, zzim zzim2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put(zza.AD_STORAGE, zzim);
        enumMap.put(zza.ANALYTICS_STORAGE, zzim2);
        return new zzin(enumMap, -10);
    }

    public static zzin zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zza2 = zzio.STORAGE.zza();
        for (int i2 = 0; i2 < zza2.length; i2++) {
            zza zza3 = zza2[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put(zza3, zza(str.charAt(i3)));
            } else {
                enumMap.put(zza3, zzim.UNINITIALIZED);
            }
        }
        return new zzin(enumMap, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzin zza(com.google.android.gms.measurement.internal.zzin r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzin$zza> r1 = com.google.android.gms.measurement.internal.zzin.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzio r1 = com.google.android.gms.measurement.internal.zzio.STORAGE
            com.google.android.gms.measurement.internal.zzin$zza[] r1 = r1.zzd
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x004d
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zzim> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzim r5 = (com.google.android.gms.measurement.internal.zzim) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zzim> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzim r6 = (com.google.android.gms.measurement.internal.zzim) r6
            if (r5 != 0) goto L_0x0026
            goto L_0x0035
        L_0x0026:
            if (r6 != 0) goto L_0x0029
            goto L_0x0045
        L_0x0029:
            com.google.android.gms.measurement.internal.zzim r7 = com.google.android.gms.measurement.internal.zzim.UNINITIALIZED
            if (r5 != r7) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            if (r6 != r7) goto L_0x0031
            goto L_0x0045
        L_0x0031:
            com.google.android.gms.measurement.internal.zzim r7 = com.google.android.gms.measurement.internal.zzim.POLICY
            if (r5 != r7) goto L_0x0037
        L_0x0035:
            r5 = r6
            goto L_0x0045
        L_0x0037:
            if (r6 != r7) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            com.google.android.gms.measurement.internal.zzim r7 = com.google.android.gms.measurement.internal.zzim.DENIED
            if (r5 == r7) goto L_0x0044
            if (r6 != r7) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            com.google.android.gms.measurement.internal.zzim r5 = com.google.android.gms.measurement.internal.zzim.GRANTED
            goto L_0x0045
        L_0x0044:
            r5 = r7
        L_0x0045:
            if (r5 == 0) goto L_0x004a
            r0.put(r4, r5)
        L_0x004a:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004d:
            com.google.android.gms.measurement.internal.zzin r9 = new com.google.android.gms.measurement.internal.zzin
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zza(com.google.android.gms.measurement.internal.zzin):com.google.android.gms.measurement.internal.zzin");
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zza2 = zzio.STORAGE.zzd;
        int length = zza2.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zza3 = zza2[i];
            if (bundle.containsKey(zza3.zze) && (string = bundle.getString(zza3.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    public final boolean zza(zzin zzin, zza... zzaArr) {
        for (zza zza2 : zzaArr) {
            if (!zzin.zza(zza2) && zza(zza2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(zza zza2) {
        return this.zzb.get(zza2) != zzim.DENIED;
    }
}
