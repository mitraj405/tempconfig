package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.Ints;
import in.juspay.hyper.constants.LogCategory;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeds extends zzbsf {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsk zzc;
    private final zzr zzd;
    private final zzedh zze;
    private String zzf;
    private String zzg;

    public zzeds(Context context, zzedh zzedh, zzr zzr, zzdsk zzdsk) {
        this.zzb = context;
        this.zzc = zzdsk;
        this.zzd = zzr;
        this.zze = zzedh;
    }

    public static void zzc(Context context, zzdsk zzdsk, zzedh zzedh, String str, String str2) {
        zzd(context, zzdsk, zzedh, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdsk zzdsk, zzedh zzedh, String str, String str2, Map map) {
        String str3;
        String str4;
        if (true != zzu.zzo().zzA(context)) {
            str3 = "offline";
        } else {
            str3 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
        }
        if (zzdsk != null) {
            zzdsj zza2 = zzdsk.zza();
            zza2.zzb("gqi", str);
            zza2.zzb(LogCategory.ACTION, str2);
            zza2.zzb("device_connectivity", str3);
            zza2.zzb("event_timestamp", String.valueOf(zzu.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zza2.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            str4 = zza2.zze();
        } else {
            str4 = "";
        }
        zzedh.zzd(new zzedj(zzu.zzB().currentTimeMillis(), str, str4, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, AdService.CLASS_NAME);
            return zzfsg.zzb(context, 0, intent, zzfsg.zza | Ints.MAX_POWER_OF_TWO, 0);
        }
        intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
        return zzfsg.zza(context, 0, intent, 201326592);
    }

    private final String zzs() {
        zzecz zzecz = (zzecz) this.zza.get(this.zzf);
        if (zzecz == null) {
            return "";
        }
        return zzecz.zzb();
    }

    private static String zzt(int i, String str) {
        Resources zze2 = zzu.zzo().zze();
        if (zze2 == null) {
            return str;
        }
        return zze2.getString(i);
    }

    private final void zzu(String str, String str2, Map map) {
        zzd(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzv() {
        /*
            r6 = this;
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r0 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.util.zzbr r0 = com.google.android.gms.ads.internal.util.zzt.zzz(r0)     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r1 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.offline.buffering.zza r2 = new com.google.android.gms.ads.internal.offline.buffering.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x0040 }
            java.util.Map r5 = r6.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.internal.ads.zzecz r5 = (com.google.android.gms.internal.ads.zzecz) r5     // Catch:{ RemoteException -> 0x0040 }
            if (r5 != 0) goto L_0x0022
            java.lang.String r5 = ""
            goto L_0x0026
        L_0x0022:
            java.lang.String r5 = r5.zzc()     // Catch:{ RemoteException -> 0x0040 }
        L_0x0026:
            r2.<init>(r3, r4, r5)     // Catch:{ RemoteException -> 0x0040 }
            boolean r1 = r0.zzg(r1, r2)     // Catch:{ RemoteException -> 0x0040 }
            if (r1 != 0) goto L_0x0047
            android.content.Context r2 = r6.zzb     // Catch:{ RemoteException -> 0x003e }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x003e }
            boolean r1 = r0.zzf(r2, r3, r4)     // Catch:{ RemoteException -> 0x003e }
            goto L_0x0047
        L_0x003e:
            r0 = move-exception
            goto L_0x0042
        L_0x0040:
            r0 = move-exception
            r1 = 0
        L_0x0042:
            java.lang.String r2 = "Failed to schedule offline notification poster."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
        L_0x0047:
            if (r1 != 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzedh r0 = r6.zze
            java.lang.String r1 = r6.zzf
            r0.zzc(r1)
            java.lang.String r0 = r6.zzf
            java.lang.String r1 = "offline_notification_worker_not_scheduled"
            com.google.android.gms.internal.ads.zzfxu r2 = com.google.android.gms.internal.ads.zzfxu.zzd()
            r6.zzu(r0, r1, r2)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzv():void");
    }

    private final void zzw(Activity activity, zzm zzm) {
        zzu.zzp();
        if (new C0183en(activity).a()) {
            zzv();
            zzx(activity, zzm);
        } else if (Build.VERSION.SDK_INT < 33) {
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(activity);
            zzK.setTitle(zzt(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzt(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new zzedl(this, activity, zzm)).setNegativeButton(zzt(R.string.notifications_permission_decline, "Don't allow"), new zzedm(this, zzm)).setOnCancelListener(new zzedn(this, zzm));
            zzK.create().show();
            zzu(this.zzf, "rtsdi", zzfxu.zzd());
        } else {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            zzu(this.zzf, "asnpdi", zzfxu.zzd());
        }
    }

    private final void zzx(Activity activity, zzm zzm) {
        XmlResourceParser xmlResourceParser;
        AlertDialog alertDialog;
        zzu.zzp();
        AlertDialog.Builder onCancelListener = zzt.zzK(activity).setOnCancelListener(new zzedk(zzm));
        int i = R.layout.offline_ads_dialog;
        Resources zze2 = zzu.zzo().zze();
        Drawable drawable = null;
        if (zze2 == null) {
            xmlResourceParser = null;
        } else {
            xmlResourceParser = zze2.getLayout(i);
        }
        if (xmlResourceParser == null) {
            onCancelListener.setMessage(zzt(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialog = onCancelListener.create();
        } else {
            View inflate = activity.getLayoutInflater().inflate(xmlResourceParser, (ViewGroup) null);
            onCancelListener.setView(inflate);
            String zzs = zzs();
            if (!zzs.isEmpty()) {
                TextView textView = (TextView) inflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(zzs);
            }
            zzecz zzecz = (zzecz) this.zza.get(this.zzf);
            if (zzecz != null) {
                drawable = zzecz.zza();
            }
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawable);
            }
            alertDialog = onCancelListener.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
        Timer timer = new Timer();
        timer.schedule(new zzedr(this, alertDialog, timer, zzm), 3000);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zzA = zzu.zzo().zzA(this.zzb);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzA) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzu(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzedh.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        int i = 0;
        while (i < strArr.length) {
            if (!strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                i++;
            } else {
                zzedu zzedu = (zzedu) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza2 = zzedu.zza();
                zzm zzb2 = zzedu.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    zzv();
                    zzx(zza2, zzb2);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb2 != null) {
                        zzb2.zzb();
                    }
                }
                zzu(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzedu zzedu = (zzedu) ObjectWrapper.unwrap(iObjectWrapper);
        Activity zza2 = zzedu.zza();
        zzm zzb2 = zzedu.zzb();
        this.zzf = zzedu.zzc();
        this.zzg = zzedu.zzd();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzhF)).booleanValue()) {
            zzu(this.zzf, "dialog_impression", zzfxu.zzd());
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(zza2);
            zzK.setTitle(zzt(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzt(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzt(R.string.offline_opt_in_confirm, "OK"), new zzedo(this, zza2, zzb2)).setNegativeButton(zzt(R.string.offline_opt_in_decline, "No thanks"), new zzedp(this, zzb2)).setOnCancelListener(new zzedq(this, zzb2));
            zzK.create().show();
            return;
        }
        zzw(zza2, zzb2);
    }

    public final void zzh() {
        this.zze.zze(new zzeda(this.zzd));
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new zza(str, str2, ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a6 A[SYNTHETIC, Splitter:B:13:0x00a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(com.google.android.gms.dynamic.IObjectWrapper r10, com.google.android.gms.ads.internal.offline.buffering.zza r11) {
        /*
            r9 = this;
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)
            android.content.Context r10 = (android.content.Context) r10
            java.lang.String r0 = r11.zza
            java.lang.String r1 = r11.zzb
            java.lang.String r11 = r11.zzc
            java.lang.String r2 = r9.zzs()
            com.google.android.gms.ads.internal.util.zzab r3 = com.google.android.gms.ads.internal.zzu.zzq()
            java.lang.String r4 = "AdMob Offline Notifications"
            java.lang.String r5 = "offline_notification_channel"
            r3.zzh(r10, r5, r4)
            java.lang.String r3 = "offline_notification_clicked"
            android.app.PendingIntent r3 = zzr(r10, r3, r1, r0)
            java.lang.String r4 = "offline_notification_dismissed"
            android.app.PendingIntent r0 = zzr(r10, r4, r1, r0)
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            r4.<init>(r10, r5)
            boolean r5 = r2.isEmpty()
            r6 = 1
            if (r5 != 0) goto L_0x0048
            int r5 = com.google.android.gms.ads.impl.R.string.offline_notification_title_with_advertiser
            java.lang.String r7 = "You are back online! Continue learning about %s"
            java.lang.String r5 = zzt(r5, r7)
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r8 = 0
            r7[r8] = r2
            java.lang.String r2 = java.lang.String.format(r5, r7)
            r4.g(r2)
            goto L_0x0053
        L_0x0048:
            int r2 = com.google.android.gms.ads.impl.R.string.offline_notification_title
            java.lang.String r5 = "You are back online! Let's pick up where we left off"
            java.lang.String r2 = zzt(r2, r5)
            r4.g(r2)
        L_0x0053:
            r2 = 16
            r4.j(r2, r6)
            android.app.Notification r2 = r4.f1735a
            r2.deleteIntent = r0
            r4.f1736a = r3
            android.content.pm.ApplicationInfo r0 = r10.getApplicationInfo()
            int r0 = r0.icon
            r2.icon = r0
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzhG
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r4.b = r0
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzhI
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L_0x00a3
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00a3
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x00a3 }
            r0.<init>(r11)     // Catch:{ IOException -> 0x00a3 }
            java.net.URLConnection r11 = r0.openConnection()     // Catch:{ IOException -> 0x00a3 }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ IOException -> 0x00a3 }
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeStream(r11)     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a4
        L_0x00a3:
            r11 = r2
        L_0x00a4:
            if (r11 == 0) goto L_0x00bd
            androidx.core.graphics.drawable.IconCompat r0 = new androidx.core.graphics.drawable.IconCompat     // Catch:{ NotFoundException -> 0x00bd }
            r0.<init>(r6)     // Catch:{ NotFoundException -> 0x00bd }
            r0.f1781a = r11     // Catch:{ NotFoundException -> 0x00bd }
            r4.f1740a = r0     // Catch:{ NotFoundException -> 0x00bd }
            Um r0 = new Um     // Catch:{ NotFoundException -> 0x00bd }
            r0.<init>()     // Catch:{ NotFoundException -> 0x00bd }
            r0.i(r11)     // Catch:{ NotFoundException -> 0x00bd }
            r0.h(r2)     // Catch:{ NotFoundException -> 0x00bd }
            r4.m(r0)     // Catch:{ NotFoundException -> 0x00bd }
        L_0x00bd:
            java.lang.String r11 = "notification"
            java.lang.Object r10 = r10.getSystemService(r11)
            android.app.NotificationManager r10 = (android.app.NotificationManager) r10
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            android.app.Notification r0 = r4.b()     // Catch:{ IllegalArgumentException -> 0x00d7 }
            r2 = 54321(0xd431, float:7.612E-41)
            r10.notify(r1, r2, r0)     // Catch:{ IllegalArgumentException -> 0x00d7 }
            java.lang.String r10 = "offline_notification_impression"
            goto L_0x00e3
        L_0x00d7:
            r10 = move-exception
            java.lang.String r0 = "notification_not_shown_reason"
            java.lang.String r10 = r10.getMessage()
            r11.put(r0, r10)
            java.lang.String r10 = "offline_notification_failed"
        L_0x00e3:
            r9.zzu(r1, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzj(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza):void");
    }

    public final /* synthetic */ void zzk(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzu(this.zzf, "rtsdc", hashMap);
        activity.startActivity(zzu.zzq().zzf(activity));
        zzv();
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final /* synthetic */ void zzl(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final /* synthetic */ void zzm(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final /* synthetic */ void zzn(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzu(this.zzf, "dialog_click", hashMap);
        zzw(activity, zzm);
    }

    public final /* synthetic */ void zzo(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final /* synthetic */ void zzp(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final void zzq(String str, zzdjb zzdjb) {
        String str2;
        String str3 = "";
        if (!TextUtils.isEmpty(zzdjb.zzx())) {
            str2 = zzdjb.zzx();
        } else if (zzdjb.zzB() != null) {
            str2 = zzdjb.zzB();
        } else {
            str2 = str3;
        }
        zzbfd zzm = zzdjb.zzm();
        if (zzm != null) {
            try {
                str3 = zzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbfd zzn = zzdjb.zzn();
        Drawable drawable = null;
        if (zzn != null) {
            try {
                IObjectWrapper zzf2 = zzn.zzf();
                if (zzf2 != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(zzf2);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzecv(str2, str3, drawable));
    }
}
