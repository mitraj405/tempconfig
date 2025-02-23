package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import defpackage.K7;
import in.juspay.hyper.core.JuspayLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomtabActivity extends Activity {
    public static final String CUSTOMTAB_RESULT = "customtab-result";
    private static final String LOG_TAG = "CustomtabActivity";
    private Boolean isFirstResume = Boolean.TRUE;

    public static ArrayList<ResolveInfo> getCustomTabsPackages(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 131072);
        ArrayList<ResolveInfo> arrayList = new ArrayList<>();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent = new Intent();
            intent.setAction("android.support.customtabs.action.CustomTabsService");
            intent.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent, 0) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean isChromeInstalled(ArrayList<ResolveInfo> arrayList) {
        Iterator<ResolveInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.packageName.equals("com.android.chrome")) {
                return true;
            }
        }
        return false;
    }

    private void launchInBrowser(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void launchIntentChooser(ArrayList<ResolveInfo> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResolveInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage(it.next().activityInfo.packageName);
            arrayList2.add(intent);
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList2.remove(0), "Select app");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
        startActivity(createChooser);
    }

    public void loadUrl(String str) {
        K7 a = new K7.d().a();
        Uri parse = Uri.parse(str);
        Intent intent = a.a;
        intent.setData(parse);
        try {
            ArrayList<ResolveInfo> customTabsPackages = getCustomTabsPackages(getBaseContext(), str);
            if (customTabsPackages.size() <= 0) {
                launchInBrowser(str);
            } else if (isChromeInstalled(customTabsPackages)) {
                intent.setPackage("com.android.chrome");
                intent.setData(Uri.parse(str));
                Object obj = d7.a;
                startActivity(intent, a.f333a);
            } else {
                launchIntentChooser(customTabsPackages, str);
            }
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "Exception in customtab activity", e);
        }
    }

    public void onCreate(Bundle bundle) {
        Uri data;
        String str;
        super.onCreate(bundle);
        if (getIntent() != null && ((data = getIntent().getData()) == null || data.getHost() == null)) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                str = null;
            } else {
                str = extras.getString("url");
            }
            if (str != null) {
                loadUrl(str);
                return;
            }
        }
        finish();
    }

    public void onResume() {
        super.onResume();
        if (!this.isFirstResume.booleanValue()) {
            Intent intent = new Intent("customtab-result");
            intent.putExtra("status", "CANCELLED");
            ji.a(this).b(intent);
            finish();
            return;
        }
        this.isFirstResume = Boolean.FALSE;
    }
}
