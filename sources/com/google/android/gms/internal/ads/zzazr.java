package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzazr extends zzaxn implements zzazs {
    public zzazr() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzazs zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        if (queryLocalInterface instanceof zzazs) {
            return (zzazs) queryLocalInterface;
        }
        return new zzazq(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x0021
            r0 = 2
            if (r3 == r0) goto L_0x001a
            r0 = 3
            if (r3 == r0) goto L_0x000b
            r3 = 0
            return r3
        L_0x000b:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zze> r3 = com.google.android.gms.ads.internal.client.zze.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaxo.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zze r3 = (com.google.android.gms.ads.internal.client.zze) r3
            com.google.android.gms.internal.ads.zzaxo.zzc(r4)
            r2.zzc(r3)
            goto L_0x0043
        L_0x001a:
            r4.readInt()
            com.google.android.gms.internal.ads.zzaxo.zzc(r4)
            goto L_0x0043
        L_0x0021:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0029
            r3 = 0
            goto L_0x003d
        L_0x0029:
            java.lang.String r0 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzazp
            if (r1 == 0) goto L_0x0037
            r3 = r0
            com.google.android.gms.internal.ads.zzazp r3 = (com.google.android.gms.internal.ads.zzazp) r3
            goto L_0x003d
        L_0x0037:
            com.google.android.gms.internal.ads.zzazn r0 = new com.google.android.gms.internal.ads.zzazn
            r0.<init>(r3)
            r3 = r0
        L_0x003d:
            com.google.android.gms.internal.ads.zzaxo.zzc(r4)
            r2.zzd(r3)
        L_0x0043:
            r5.writeNoException()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazr.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
