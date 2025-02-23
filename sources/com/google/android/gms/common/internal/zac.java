package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public final class zac {
    private static final SimpleArrayMap<String, String> zaa = new SimpleArrayMap<>();
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    public static String zad(Context context, int i) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zaa2});
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zaa2});
            } else if (i == 5) {
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                if (i == 7) {
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zaa2});
                } else if (i == 20) {
                    return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                } else {
                    switch (i) {
                        case 16:
                            return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                        case 17:
                            return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zaa2});
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[]{zaa2});
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zaa2});
        }
    }

    public static String zae(Context context, int i) {
        if (i == 6 || i == 19) {
            return zah(context, "common_google_play_services_resolution_required_text", zaa(context));
        }
        return zad(context, i);
    }

    public static String zaf(Context context, int i) {
        String str;
        if (i == 6) {
            str = zai(context, "common_google_play_services_resolution_required_title");
        } else {
            str = zag(context, i);
        }
        if (str == null) {
            return context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        }
        return str;
    }

    public static String zag(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return zai(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return zai(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return zai(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return zai(context, "common_google_play_services_restricted_profile_title");
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, new Object[]{str2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zai(android.content.Context r4, java.lang.String r5) {
        /*
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.String> r0 = zaa
            monitor-enter(r0)
            android.content.res.Resources r1 = r4.getResources()     // Catch:{ all -> 0x0069 }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x0069 }
            android.os.LocaleList r1 = defpackage.H6.a(r1)     // Catch:{ all -> 0x0069 }
            ki r2 = new ki     // Catch:{ all -> 0x0069 }
            r2 = 0
            java.util.Locale r1 = r1.get(r2)     // Catch:{ all -> 0x0069 }
            java.util.Locale r2 = zab     // Catch:{ all -> 0x0069 }
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x0023
            r0.clear()     // Catch:{ all -> 0x0069 }
            zab = r1     // Catch:{ all -> 0x0069 }
        L_0x0023:
            java.lang.Object r1 = r0.get(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x002d
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x002d:
            android.content.res.Resources r4 = com.google.android.gms.common.GooglePlayServicesUtil.getRemoteResource(r4)     // Catch:{ all -> 0x0069 }
            r1 = 0
            if (r4 != 0) goto L_0x0036
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x0036:
            java.lang.String r2 = "string"
            java.lang.String r3 = "com.google.android.gms"
            int r2 = r4.getIdentifier(r5, r2, r3)     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x004d
            java.lang.String r4 = "Missing resource: "
            int r2 = r5.length()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x004b
            r4.concat(r5)     // Catch:{ all -> 0x0069 }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x004d:
            java.lang.String r4 = r4.getString(r2)     // Catch:{ all -> 0x0069 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x0064
            java.lang.String r4 = "Got empty resource: "
            int r2 = r5.length()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x0062
            r4.concat(r5)     // Catch:{ all -> 0x0069 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x0064:
            r0.put(r5, r4)     // Catch:{ all -> 0x0069 }
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r4
        L_0x0069:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zac.zai(android.content.Context, java.lang.String):java.lang.String");
    }
}
