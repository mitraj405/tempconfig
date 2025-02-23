package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfv {
    private static String zza;

    public static String zza(Context context) {
        String str;
        String str2 = zza;
        if (str2 != null) {
            return str2;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity != null) {
            str = resolveActivity.activityInfo.packageName;
        } else {
            str = null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(next.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            zza = null;
        } else if (arrayList.size() == 1) {
            zza = (String) arrayList.get(0);
        } else {
            if (!TextUtils.isEmpty(str)) {
                try {
                    List<ResolveInfo> queryIntentActivities2 = context.getPackageManager().queryIntentActivities(intent, 64);
                    if (queryIntentActivities2 != null) {
                        if (queryIntentActivities2.size() != 0) {
                            Iterator<ResolveInfo> it = queryIntentActivities2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ResolveInfo next2 = it.next();
                                IntentFilter intentFilter = next2.filter;
                                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && next2.activityInfo != null) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (RuntimeException unused) {
                }
                if (arrayList.contains(str)) {
                    zza = str;
                }
            }
            if (arrayList.contains("com.android.chrome")) {
                zza = "com.android.chrome";
            } else if (arrayList.contains("com.chrome.beta")) {
                zza = "com.chrome.beta";
            } else if (arrayList.contains("com.chrome.dev")) {
                zza = "com.chrome.dev";
            }
        }
        return zza;
    }
}
