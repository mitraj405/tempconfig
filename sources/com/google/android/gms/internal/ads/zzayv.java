package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzayv extends Thread {
    private boolean zza = false;
    private boolean zzb = false;
    private final Object zzc;
    private final zzaym zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzayv() {
        zzaym zzaym = new zzaym();
        this.zzd = zzaym;
        this.zzc = new Object();
        this.zzf = ((Long) zzbdj.zzd.zze()).intValue();
        this.zzg = ((Long) zzbdj.zza.zze()).intValue();
        this.zzh = ((Long) zzbdj.zze.zze()).intValue();
        this.zzi = ((Long) zzbdj.zzc.zze()).intValue();
        this.zzj = ((Integer) zzba.zzc().zza(zzbbw.zzL)).intValue();
        this.zzk = ((Integer) zzba.zzc().zza(zzbbw.zzM)).intValue();
        this.zzl = ((Integer) zzba.zzc().zza(zzbbw.zzN)).intValue();
        this.zze = ((Long) zzbdj.zzf.zze()).intValue();
        this.zzm = (String) zzba.zzc().zza(zzbbw.zzP);
        this.zzn = ((Boolean) zzba.zzc().zza(zzbbw.zzQ)).booleanValue();
        this.zzo = ((Boolean) zzba.zzc().zza(zzbbw.zzR)).booleanValue();
        this.zzp = ((Boolean) zzba.zzc().zza(zzbbw.zzS)).booleanValue();
        setName("ContentFetchTask");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc A[LOOP:2: B:48:0x00dc->B:62:0x00dc, LOOP_START, SYNTHETIC] */
    public final void run() {
        /*
            r6 = this;
        L_0x0000:
            com.google.android.gms.internal.ads.zzayq r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ all -> 0x00a8 }
            android.content.Context r0 = r0.zzb()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ all -> 0x00a8 }
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00b2
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x002a:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00a8 }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x00a8 }
            int r5 = r3.pid     // Catch:{ all -> 0x00a8 }
            if (r4 != r5) goto L_0x002a
            int r1 = r3.importance     // Catch:{ all -> 0x00a8 }
            r3 = 100
            if (r1 != r3) goto L_0x00b2
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzayq r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            android.app.Activity r0 = r0.zza()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x006d:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x008e }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r2)     // Catch:{ Exception -> 0x008e }
            goto L_0x009d
        L_0x008e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbze r2 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zzw(r0, r3)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x009d:
            if (r1 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzayr r0 = new com.google.android.gms.internal.ads.zzayr     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r0.<init>(r6, r1)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x00a8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbze r1 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r2 = "ContentFetchTask.isInForeground"
            r1.zzw(r0, r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00b2:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00ba:
            int r0 = r6.zze     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
            java.lang.String r1 = "ContentFetchTask.run"
            com.google.android.gms.internal.ads.zzbze r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
            goto L_0x00d9
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
        L_0x00d9:
            java.lang.Object r0 = r6.zzc
            monitor-enter(r0)
        L_0x00dc:
            boolean r1 = r6.zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r1)     // Catch:{ InterruptedException -> 0x00dc }
            java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x00dc }
            r1.wait()     // Catch:{ InterruptedException -> 0x00dc }
            goto L_0x00dc
        L_0x00eb:
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x0000
        L_0x00ee:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayv.run():void");
    }

    public final zzayl zza() {
        return this.zzd.zza(this.zzp);
    }

    public final zzayu zzb(View view, zzayl zzayl) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzayl.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                    return new zzayu(this, 1, 0);
                }
            } else if ((view instanceof WebView) && !(view instanceof zzcej)) {
                WebView webView = (WebView) view;
                if (PlatformVersion.isAtLeastKitKat()) {
                    zzayl.zzh();
                    webView.post(new zzayt(this, zzayl, webView, globalVisibleRect));
                    return new zzayu(this, 0, 1);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    zzayu zzb2 = zzb(viewGroup.getChildAt(i3), zzayl);
                    i += zzb2.zza;
                    i2 += zzb2.zzb;
                }
                return new zzayu(this, i, i2);
            }
        }
        return new zzayu(this, 0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r11 == 0) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(android.view.View r11) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzayl r9 = new com.google.android.gms.internal.ads.zzayl     // Catch:{ Exception -> 0x007e }
            int r1 = r10.zzf     // Catch:{ Exception -> 0x007e }
            int r2 = r10.zzg     // Catch:{ Exception -> 0x007e }
            int r3 = r10.zzh     // Catch:{ Exception -> 0x007e }
            int r4 = r10.zzi     // Catch:{ Exception -> 0x007e }
            int r5 = r10.zzj     // Catch:{ Exception -> 0x007e }
            int r6 = r10.zzk     // Catch:{ Exception -> 0x007e }
            int r7 = r10.zzl     // Catch:{ Exception -> 0x007e }
            boolean r8 = r10.zzo     // Catch:{ Exception -> 0x007e }
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzayq r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ Exception -> 0x007e }
            android.content.Context r0 = r0.zzb()     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0052
            java.lang.String r1 = r10.zzm     // Catch:{ Exception -> 0x007e }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x007e }
            if (r1 != 0) goto L_0x0052
            android.content.res.Resources r1 = r0.getResources()     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzO     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x007e }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ Exception -> 0x007e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "id"
            java.lang.String r0 = r0.getPackageName()     // Catch:{ Exception -> 0x007e }
            int r0 = r1.getIdentifier(r2, r3, r0)     // Catch:{ Exception -> 0x007e }
            java.lang.Object r0 = r11.getTag(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0052
            java.lang.String r1 = r10.zzm     // Catch:{ Exception -> 0x007e }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0077
        L_0x0052:
            com.google.android.gms.internal.ads.zzayu r11 = r10.zzb(r11, r9)     // Catch:{ Exception -> 0x007e }
            r9.zzm()     // Catch:{ Exception -> 0x007e }
            int r0 = r11.zza     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0061
            int r0 = r11.zzb     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0077
        L_0x0061:
            int r11 = r11.zzb     // Catch:{ Exception -> 0x007e }
            if (r11 != 0) goto L_0x006c
            int r11 = r9.zzc()     // Catch:{ Exception -> 0x007e }
            if (r11 == 0) goto L_0x0077
            goto L_0x006e
        L_0x006c:
            if (r11 != 0) goto L_0x0078
        L_0x006e:
            com.google.android.gms.internal.ads.zzaym r11 = r10.zzd     // Catch:{ Exception -> 0x007e }
            boolean r11 = r11.zzd(r9)     // Catch:{ Exception -> 0x007e }
            if (r11 != 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            return
        L_0x0078:
            com.google.android.gms.internal.ads.zzaym r11 = r10.zzd     // Catch:{ Exception -> 0x007e }
            r11.zzb(r9)     // Catch:{ Exception -> 0x007e }
            return
        L_0x007e:
            r11 = move-exception
            java.lang.String r0 = "Exception in fetchContentOnUIThread"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r11)
            java.lang.String r0 = "ContentFetchTask.fetchContent"
            com.google.android.gms.internal.ads.zzbze r1 = com.google.android.gms.ads.internal.zzu.zzo()
            r1.zzw(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayv.zzc(android.view.View):void");
    }

    public final void zzd(zzayl zzayl, WebView webView, String str, boolean z) {
        zzayl.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzayl.zzl(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    zzayl.zzl(title + "\n" + optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzayl.zzo()) {
                this.zzd.zzc(zzayl);
            }
        } catch (JSONException unused) {
            zzm.zze("Json string may be malformed.");
        } catch (Throwable th) {
            zzm.zzf("Failed to get webview content.", th);
            zzu.zzo().zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzm.zze("Content hash thread already started, quitting...");
                return;
            }
            this.zza = true;
            start();
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzm.zze("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzm.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
