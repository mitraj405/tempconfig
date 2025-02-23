package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzeil implements zzgcf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzfel zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzflh zze;
    final /* synthetic */ zzfex zzf;
    final /* synthetic */ zzein zzg;

    public zzeil(zzein zzein, long j, zzfeo zzfeo, zzfel zzfel, String str, zzflh zzflh, zzfex zzfex) {
        this.zza = j;
        this.zzb = zzfeo;
        this.zzc = zzfel;
        this.zzd = str;
        this.zze = zzflh;
        this.zzf = zzfex;
        this.zzg = zzein;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void zza(java.lang.Throwable r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.google.android.gms.internal.ads.zzein r2 = r1.zzg
            com.google.android.gms.common.util.Clock r2 = r2.zza
            long r2 = r2.elapsedRealtime()
            long r4 = r1.zza
            long r2 = r2 - r4
            boolean r4 = r0 instanceof java.util.concurrent.TimeoutException
            r5 = 3
            r6 = 0
            if (r4 == 0) goto L_0x001a
            r4 = 2
        L_0x0018:
            r13 = r6
            goto L_0x0063
        L_0x001a:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzehv
            if (r4 == 0) goto L_0x0020
            r4 = r5
            goto L_0x0018
        L_0x0020:
            boolean r4 = r0 instanceof java.util.concurrent.CancellationException
            if (r4 == 0) goto L_0x0026
            r4 = 4
            goto L_0x0018
        L_0x0026:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzffn
            if (r4 == 0) goto L_0x002c
            r4 = 5
            goto L_0x0018
        L_0x002c:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdwl
            r7 = 6
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.client.zze r4 = com.google.android.gms.internal.ads.zzfgi.zza(r17)
            int r4 = r4.zza
            if (r4 != r5) goto L_0x003a
            r7 = 1
        L_0x003a:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzbs
            com.google.android.gms.internal.ads.zzbbu r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r8.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzeex
            if (r4 == 0) goto L_0x0061
            r4 = r0
            com.google.android.gms.internal.ads.zzeex r4 = (com.google.android.gms.internal.ads.zzeex) r4
            com.google.android.gms.ads.internal.client.zze r4 = r4.zzb()
            if (r4 == 0) goto L_0x0061
            int r4 = r4.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r13 = r4
            goto L_0x0062
        L_0x0061:
            r13 = r6
        L_0x0062:
            r4 = r7
        L_0x0063:
            com.google.android.gms.internal.ads.zzein r14 = r1.zzg
            monitor-enter(r14)
            com.google.android.gms.internal.ads.zzein r7 = r1.zzg     // Catch:{ all -> 0x0102 }
            boolean r8 = r7.zze     // Catch:{ all -> 0x0102 }
            if (r8 == 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzeip r7 = r7.zzb     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfeo r8 = r1.zzb     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfel r9 = r1.zzc     // Catch:{ all -> 0x0102 }
            boolean r10 = r0 instanceof com.google.android.gms.internal.ads.zzeex     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x007d
            r6 = r0
            com.google.android.gms.internal.ads.zzeex r6 = (com.google.android.gms.internal.ads.zzeex) r6     // Catch:{ all -> 0x0102 }
        L_0x007d:
            r10 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r4
            r11 = r2
            r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0102 }
        L_0x0086:
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzhz     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0102 }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ all -> 0x0102 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0102 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0102 }
            if (r6 == 0) goto L_0x00ad
            com.google.android.gms.internal.ads.zzein r6 = r1.zzg     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfll r6 = r6.zzc     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzflh r7 = r1.zze     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfex r8 = r1.zzf     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfel r9 = r1.zzc     // Catch:{ all -> 0x0102 }
            java.util.List r10 = r9.zzn     // Catch:{ all -> 0x0102 }
            java.util.List r7 = r7.zzc(r8, r9, r10)     // Catch:{ all -> 0x0102 }
            r6.zzd(r7)     // Catch:{ all -> 0x0102 }
        L_0x00ad:
            com.google.android.gms.internal.ads.zzein r6 = r1.zzg     // Catch:{ all -> 0x0102 }
            boolean r7 = r6.zzg     // Catch:{ all -> 0x0102 }
            if (r7 == 0) goto L_0x00b7
            monitor-exit(r14)     // Catch:{ all -> 0x0102 }
            return
        L_0x00b7:
            java.util.LinkedHashMap r15 = r6.zzd     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfel r12 = r1.zzc     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzeim r10 = new com.google.android.gms.internal.ads.zzeim     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = r1.zzd     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = r12.zzaf     // Catch:{ all -> 0x0102 }
            r6 = r10
            r9 = r4
            r4 = r10
            r10 = r2
            r5 = r12
            r12 = r13
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x0102 }
            r15.put(r5, r4)     // Catch:{ all -> 0x0102 }
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zza(r17)     // Catch:{ all -> 0x0102 }
            int r4 = r0.zza     // Catch:{ all -> 0x0102 }
            r5 = 3
            if (r4 == r5) goto L_0x00da
            if (r4 != 0) goto L_0x00f5
        L_0x00da:
            com.google.android.gms.ads.internal.client.zze r4 = r0.zzd     // Catch:{ all -> 0x0102 }
            if (r4 == 0) goto L_0x00f5
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = "com.google.android.gms.ads"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0102 }
            if (r4 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzeex r4 = new com.google.android.gms.internal.ads.zzeex     // Catch:{ all -> 0x0102 }
            com.google.android.gms.ads.internal.client.zze r0 = r0.zzd     // Catch:{ all -> 0x0102 }
            r5 = 13
            r4.<init>(r5, r0)     // Catch:{ all -> 0x0102 }
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zza(r4)     // Catch:{ all -> 0x0102 }
        L_0x00f5:
            com.google.android.gms.internal.ads.zzein r4 = r1.zzg     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzeey r4 = r4.zzf     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.ads.zzfel r5 = r1.zzc     // Catch:{ all -> 0x0102 }
            r4.zzf(r5, r2, r0)     // Catch:{ all -> 0x0102 }
            monitor-exit(r14)     // Catch:{ all -> 0x0102 }
            return
        L_0x0102:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0102 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeil.zza(java.lang.Throwable):void");
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzein zzein = this.zzg;
            if (zzein.zze) {
                zzein.zzb.zza(this.zzb, this.zzc, 0, (zzeex) null, elapsedRealtime);
            }
            zzein zzein2 = this.zzg;
            if (!zzein2.zzg) {
                if (zzein2.zzq(this.zzc)) {
                    ((zzeim) this.zzg.zzd.get(this.zzc)).zzd = elapsedRealtime;
                } else {
                    LinkedHashMap zzh = this.zzg.zzd;
                    zzfel zzfel = this.zzc;
                    zzh.put(zzfel, new zzeim(this.zzd, zzfel.zzaf, 0, elapsedRealtime, (Integer) null));
                }
                this.zzg.zzf.zzg(this.zzc, elapsedRealtime, (zze) null);
            }
        }
    }
}
