package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersmshandler.JuspayDuiHook;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectivityReceiver extends BroadcastReceiver implements JuspayDuiHook {
    private static final String LOG_TAG = "ConnectivityReceiver";
    private final Map<Activity, Boolean> attachedMap = new WeakHashMap();
    private final JuspayServices juspayServices;

    public ConnectivityReceiver(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    private String getNetworkType() {
        if (this.juspayServices.getSessionInfo().getNetworkInfo() != null) {
            return this.juspayServices.getSessionInfo().getNetworkInfo();
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isMobileDataOn() {
        /*
            r7 = this;
            r0 = 0
            in.juspay.hypersdk.core.JuspayServices r1 = r7.juspayServices     // Catch:{ Exception -> 0x004d }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x004d }
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x004d }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x004d }
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "airplane_mode_on"
            int r3 = android.provider.Settings.Global.getInt(r3, r4, r0)     // Catch:{ Exception -> 0x004d }
            r4 = 1
            if (r3 != 0) goto L_0x001e
            r3 = r4
            goto L_0x001f
        L_0x001e:
            r3 = r0
        L_0x001f:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004d }
            r6 = 29
            if (r5 < r6) goto L_0x0032
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r1 = defpackage.d7.a(r1, r5)     // Catch:{ Exception -> 0x004d }
            if (r1 != 0) goto L_0x0047
            boolean r1 = r2.isDataEnabled()     // Catch:{ Exception -> 0x004d }
            goto L_0x0048
        L_0x0032:
            int r2 = r2.getSimState()     // Catch:{ Exception -> 0x004d }
            r5 = 5
            if (r2 != r5) goto L_0x0047
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x004d }
            java.lang.String r2 = "mobile_data"
            int r1 = android.provider.Settings.Global.getInt(r1, r2, r4)     // Catch:{ Exception -> 0x004d }
            if (r1 != r4) goto L_0x0047
            r1 = r4
            goto L_0x0048
        L_0x0047:
            r1 = r0
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            if (r3 == 0) goto L_0x004d
            r0 = r4
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.ConnectivityReceiver.isMobileDataOn():boolean");
    }

    private boolean isNetworkAvailable() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.juspayServices.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.IS_NETWORK_AVAILABLE, "network failure", e);
            return false;
        }
    }

    public void attach(Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool == null || !bool.booleanValue()) {
            activity.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            juspayServices2.sdkDebug(str, "Attaching the " + str);
            this.attachedMap.put(activity, Boolean.TRUE);
        }
    }

    public void detach(Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool != null && bool.booleanValue()) {
            activity.unregisterReceiver(this);
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            juspayServices2.sdkDebug(str, "Detaching the " + str);
            this.attachedMap.put(activity, Boolean.FALSE);
        }
    }

    public String execute(Activity activity, String str, JSONObject jSONObject) {
        return String.valueOf(isNetworkAvailable());
    }

    public void onReceive(Context context, Intent intent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("connected", String.valueOf(isNetworkAvailable()));
            jSONObject.put("networkType", getNetworkType());
            jSONObject.put("isMobileDataOn", String.valueOf(isMobileDataOn()));
        } catch (JSONException unused) {
        }
        this.juspayServices.getJBridge().invokeFnInDUIWebview("onNetworkChange", jSONObject.toString());
    }
}
