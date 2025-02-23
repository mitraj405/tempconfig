package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzagm extends zzagd {
    public static final Parcelable.Creator<zzagm> CREATOR = new zzagl();
    public final String zza;
    public final zzfxr zzb;

    public zzagm(String str, String str2, List list) {
        super(str);
        zzdi.zzd(!list.isEmpty());
        this.zza = str2;
        zzfxr zzk = zzfxr.zzk(list);
        this.zzb = zzk;
        String str3 = (String) zzk.get(0);
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagm.class == obj.getClass()) {
            zzagm zzagm = (zzagm) obj;
            if (!zzet.zzG(this.zzf, zzagm.zzf) || !zzet.zzG(this.zza, zzagm.zza) || !this.zzb.equals(zzagm.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return this.zzb.hashCode() + (((hashCode * 31) + i) * 31);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzf);
        sb.append(": description=");
        return C1058d.B(sb, this.zza, ": values=", valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeStringArray((String[]) this.zzb.toArray(new String[0]));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzbf r10) {
        /*
            r9 = this;
            java.lang.String r0 = r9.zzf
            int r1 = r0.hashCode()
            r2 = 10
            r3 = 4
            r4 = -1
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            switch(r1) {
                case 82815: goto L_0x010b;
                case 82878: goto L_0x0100;
                case 82897: goto L_0x00f5;
                case 83253: goto L_0x00eb;
                case 83254: goto L_0x00e1;
                case 83255: goto L_0x00d6;
                case 83341: goto L_0x00cb;
                case 83378: goto L_0x00c1;
                case 83536: goto L_0x00b6;
                case 83552: goto L_0x00ab;
                case 2567331: goto L_0x00a0;
                case 2569357: goto L_0x0094;
                case 2569358: goto L_0x0088;
                case 2569891: goto L_0x007c;
                case 2570401: goto L_0x0070;
                case 2570410: goto L_0x0064;
                case 2571565: goto L_0x0058;
                case 2575251: goto L_0x004d;
                case 2581512: goto L_0x0042;
                case 2581513: goto L_0x0037;
                case 2581514: goto L_0x002b;
                case 2583398: goto L_0x001f;
                case 2590194: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0115
        L_0x0013:
            java.lang.String r1 = "TYER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 11
            goto L_0x0116
        L_0x001f:
            java.lang.String r1 = "TRCK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 9
            goto L_0x0116
        L_0x002b:
            java.lang.String r1 = "TPE3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 19
            goto L_0x0116
        L_0x0037:
            java.lang.String r1 = "TPE2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 5
            goto L_0x0116
        L_0x0042:
            java.lang.String r1 = "TPE1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r5
            goto L_0x0116
        L_0x004d:
            java.lang.String r1 = "TIT2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r6
            goto L_0x0116
        L_0x0058:
            java.lang.String r1 = "TEXT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 21
            goto L_0x0116
        L_0x0064:
            java.lang.String r1 = "TDRL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 15
            goto L_0x0116
        L_0x0070:
            java.lang.String r1 = "TDRC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 14
            goto L_0x0116
        L_0x007c:
            java.lang.String r1 = "TDAT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 13
            goto L_0x0116
        L_0x0088:
            java.lang.String r1 = "TCON"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 22
            goto L_0x0116
        L_0x0094:
            java.lang.String r1 = "TCOM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 17
            goto L_0x0116
        L_0x00a0:
            java.lang.String r1 = "TALB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 7
            goto L_0x0116
        L_0x00ab:
            java.lang.String r1 = "TYE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r2
            goto L_0x0116
        L_0x00b6:
            java.lang.String r1 = "TXT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 20
            goto L_0x0116
        L_0x00c1:
            java.lang.String r1 = "TT2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r8
            goto L_0x0116
        L_0x00cb:
            java.lang.String r1 = "TRK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 8
            goto L_0x0116
        L_0x00d6:
            java.lang.String r1 = "TP3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 18
            goto L_0x0116
        L_0x00e1:
            java.lang.String r1 = "TP2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r3
            goto L_0x0116
        L_0x00eb:
            java.lang.String r1 = "TP1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = r7
            goto L_0x0116
        L_0x00f5:
            java.lang.String r1 = "TDA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 12
            goto L_0x0116
        L_0x0100:
            java.lang.String r1 = "TCM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 16
            goto L_0x0116
        L_0x010b:
            java.lang.String r1 = "TAL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0115
            r0 = 6
            goto L_0x0116
        L_0x0115:
            r0 = r4
        L_0x0116:
            switch(r0) {
                case 0: goto L_0x025e;
                case 1: goto L_0x025e;
                case 2: goto L_0x0252;
                case 3: goto L_0x0252;
                case 4: goto L_0x0246;
                case 5: goto L_0x0246;
                case 6: goto L_0x023a;
                case 7: goto L_0x023a;
                case 8: goto L_0x020a;
                case 9: goto L_0x020a;
                case 10: goto L_0x01f6;
                case 11: goto L_0x01f6;
                case 12: goto L_0x01cf;
                case 13: goto L_0x01cf;
                case 14: goto L_0x019b;
                case 15: goto L_0x0167;
                case 16: goto L_0x015b;
                case 17: goto L_0x015b;
                case 18: goto L_0x014f;
                case 19: goto L_0x014f;
                case 20: goto L_0x0143;
                case 21: goto L_0x0143;
                case 22: goto L_0x011b;
                default: goto L_0x0119;
            }
        L_0x0119:
            goto L_0x0269
        L_0x011b:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Integer r0 = com.google.android.gms.internal.ads.zzgap.zzf(r0, r2)
            if (r0 != 0) goto L_0x0135
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzi(r0)
            return
        L_0x0135:
            int r0 = r0.intValue()
            java.lang.String r0 = com.google.android.gms.internal.ads.zzage.zza(r0)
            if (r0 == 0) goto L_0x0269
            r10.zzi(r0)
            return
        L_0x0143:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzt(r0)
            return
        L_0x014f:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzg(r0)
            return
        L_0x015b:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzf(r0)
            return
        L_0x0167:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = zzb(r0)
            int r1 = r0.size()
            if (r1 == r6) goto L_0x0191
            if (r1 == r7) goto L_0x0188
            if (r1 == r5) goto L_0x017f
            goto L_0x0269
        L_0x017f:
            java.lang.Object r1 = r0.get(r7)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10.zzm(r1)
        L_0x0188:
            java.lang.Object r1 = r0.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10.zzn(r1)
        L_0x0191:
            java.lang.Object r0 = r0.get(r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r10.zzo(r0)
            return
        L_0x019b:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = zzb(r0)
            int r1 = r0.size()
            if (r1 == r6) goto L_0x01c5
            if (r1 == r7) goto L_0x01bc
            if (r1 == r5) goto L_0x01b3
            goto L_0x0269
        L_0x01b3:
            java.lang.Object r1 = r0.get(r7)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10.zzj(r1)
        L_0x01bc:
            java.lang.Object r1 = r0.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10.zzk(r1)
        L_0x01c5:
            java.lang.Object r0 = r0.get(r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r10.zzl(r0)
            return
        L_0x01cf:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.String r1 = r0.substring(r7, r3)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.String r0 = r0.substring(r8, r7)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            r10.zzk(r1)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
            r10.zzj(r0)     // Catch:{ NumberFormatException | StringIndexOutOfBoundsException -> 0x01f5 }
        L_0x01f5:
            return
        L_0x01f6:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb     // Catch:{ NumberFormatException -> 0x0209 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ NumberFormatException -> 0x0209 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0209 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0209 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0209 }
            r10.zzl(r0)     // Catch:{ NumberFormatException -> 0x0209 }
        L_0x0209:
            return
        L_0x020a:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            int r1 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1, r4)
            r1 = r0[r8]     // Catch:{ NumberFormatException -> 0x0239 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0239 }
            int r2 = r0.length     // Catch:{ NumberFormatException -> 0x0239 }
            if (r2 <= r6) goto L_0x022e
            r0 = r0[r6]     // Catch:{ NumberFormatException -> 0x0239 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0239 }
            goto L_0x022f
        L_0x022e:
            r0 = 0
        L_0x022f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0239 }
            r10.zzs(r1)     // Catch:{ NumberFormatException -> 0x0239 }
            r10.zzr(r0)     // Catch:{ NumberFormatException -> 0x0239 }
        L_0x0239:
            return
        L_0x023a:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzd(r0)
            return
        L_0x0246:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzc(r0)
            return
        L_0x0252:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zze(r0)
            return
        L_0x025e:
            com.google.android.gms.internal.ads.zzfxr r0 = r9.zzb
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.zzq(r0)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagm.zza(com.google.android.gms.internal.ads.zzbf):void");
    }
}
