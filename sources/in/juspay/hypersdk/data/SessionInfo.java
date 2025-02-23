package in.juspay.hypersdk.data;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.Constants;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.Utils;
import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionInfo {
    private static final String LOG_TAG = "in.juspay.hypersdk.data.SessionInfo";
    private final String androidId = generateId("juspay_android_id");
    private JSONObject bundleParams = new JSONObject();
    private final Context context;
    private final String deviceId = generateId("juspay_device_id");
    private DisplayMetrics displayMetrics;
    private final JuspayServices juspayServices;
    private String sessionId;
    private JSONObject sessionInfo = new JSONObject();

    public SessionInfo(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        this.context = juspayServices2.getContext().getApplicationContext();
    }

    private void addOrUpdateOrderId(String str) {
        JSONObject sessionData = getSessionData();
        if (!sessionData.optString(PaymentConstants.ORDER_ID).equals(str) && !str.equals("")) {
            try {
                sessionData.put(PaymentConstants.ORDER_ID, str);
            } catch (JSONException unused) {
            }
        }
    }

    private boolean devOptionsEnabled() {
        try {
            if (Settings.Secure.getInt(this.context.getContentResolver(), "development_settings_enabled", 0) == 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private String generateId(String str) {
        Context context2 = this.juspayServices.getContext();
        String sdkName = this.juspayServices.getSdkInfo().getSdkName();
        String read = KeyValueStore.read(context2, sdkName, str, (String) null);
        if (read != null) {
            return read;
        }
        String uuid = UUID.randomUUID().toString();
        KeyValueStore.write(context2, sdkName, str, uuid);
        return uuid;
    }

    private DisplayMetrics getDisplayMetrics() {
        try {
            if (this.displayMetrics == null) {
                this.displayMetrics = this.context.getResources().getDisplayMetrics();
            }
            return this.displayMetrics;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    private String getOrderIdFromPayload(JSONObject jSONObject, String str) {
        if (jSONObject.has(PaymentConstants.ORDER_ID_CAMEL)) {
            return jSONObject.optString(PaymentConstants.ORDER_ID_CAMEL);
        }
        if (jSONObject.has(PaymentConstants.ORDER_ID)) {
            return jSONObject.optString(PaymentConstants.ORDER_ID);
        }
        return str;
    }

    private String getScreenPpi() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.xdpi);
        }
        return null;
    }

    private int getVersionCode() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private String getVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static boolean isRooted() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void addOrderIdInSessionData(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject optJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD);
        if (optJSONObject != null) {
            try {
                if (optJSONObject.has(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL)) {
                    jSONObject2 = new JSONObject(optJSONObject.optString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL, "{}"));
                } else if (optJSONObject.has(PaymentConstants.ORDER_DETAILS_CAMEL)) {
                    jSONObject2 = new JSONObject(optJSONObject.optString(PaymentConstants.ORDER_DETAILS_CAMEL, "{}"));
                } else {
                    str = getOrderIdFromPayload(optJSONObject, "");
                    addOrUpdateOrderId(str);
                }
                str = getOrderIdFromPayload(jSONObject2, optJSONObject.optString(PaymentConstants.ORDER_ID_CAMEL));
                addOrUpdateOrderId(str);
            } catch (JSONException unused) {
            }
        }
    }

    public void createSessionDataMap() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("device_id", getDeviceId());
            jSONObject.put("android_id", EncryptionHelper.getSHA256Hash(getAndroidId()));
            jSONObject.put("os", LogSubCategory.LifeCycle.ANDROID);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("android_api_level", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("locale", Locale.getDefault().getDisplayLanguage());
            jSONObject.put("app_name", this.context.getApplicationInfo().loadLabel(this.context.getPackageManager()));
            jSONObject.put("app_version", getVersionName());
            jSONObject.put("app_version_code", getVersionCode());
            String clientId = getClientId();
            if (!Objects.equals(clientId, "")) {
                jSONObject.put(PaymentConstants.CLIENT_ID, clientId);
            }
            String merchantId = getMerchantId();
            if (!Objects.equals(merchantId, "")) {
                jSONObject.put(PaymentConstants.MERCHANT_ID, merchantId);
            }
            jSONObject.put("dir_name", this.context.getApplicationInfo().sourceDir);
            jSONObject.put("package_name", this.context.getApplicationInfo().packageName);
            jSONObject.put("network_info", getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
            jSONObject.put("is_rooted", String.valueOf(isRooted()));
            jSONObject.put("is_dev_enabled", String.valueOf(devOptionsEnabled()));
            jSONObject.put("app_debuggable", JuspayCoreLib.isAppDebuggable());
            jSONObject.put("sdk_debuggable", this.juspayServices.getSdkInfo().isSdkDebuggable());
            jSONObject.put("screen_width", getScreenWidth());
            jSONObject.put("screen_height", getScreenHeight());
            jSONObject.put("screen_ppi", getScreenPpi());
            jSONObject.put("geocode", "");
            jSONObject.put(FirebaseAnalytics.Param.LOCATION, "");
            jSONObject.put("capability", "");
            updateSessionData(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public String get(String str, String str2) {
        return this.sessionInfo.optString(str, str2);
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppName() {
        String optString = this.sessionInfo.optString("app_name");
        if (!optString.equals("")) {
            return optString;
        }
        return getClientId();
    }

    public JSONObject getBundleParams() {
        return this.bundleParams;
    }

    public String getClientId() {
        JSONObject optJSONObject;
        if (!this.bundleParams.has(PaymentConstants.PAYLOAD) || (optJSONObject = this.bundleParams.optJSONObject(PaymentConstants.PAYLOAD)) == null) {
            return "";
        }
        if (optJSONObject.has(PaymentConstants.CLIENT_ID_CAMEL)) {
            return optJSONObject.optString(PaymentConstants.CLIENT_ID_CAMEL);
        }
        if (optJSONObject.has(PaymentConstants.CLIENT_ID)) {
            return optJSONObject.optString(PaymentConstants.CLIENT_ID);
        }
        return "";
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getMerchantId() {
        JSONObject optJSONObject;
        if (!this.bundleParams.has(PaymentConstants.PAYLOAD) || (optJSONObject = this.bundleParams.optJSONObject(PaymentConstants.PAYLOAD)) == null) {
            return "";
        }
        try {
            if (optJSONObject.has(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL)) {
                JSONObject jSONObject = new JSONObject(optJSONObject.optString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL, "{}"));
                if (jSONObject.has(PaymentConstants.MERCHANT_ID_CAMEL)) {
                    return jSONObject.optString(PaymentConstants.MERCHANT_ID_CAMEL);
                }
                if (jSONObject.has(PaymentConstants.MERCHANT_ID)) {
                    return jSONObject.optString(PaymentConstants.MERCHANT_ID);
                }
            }
        } catch (Exception unused) {
        }
        if (optJSONObject.has(PaymentConstants.MERCHANT_ID_CAMEL)) {
            return optJSONObject.optString(PaymentConstants.MERCHANT_ID_CAMEL);
        }
        if (optJSONObject.has(PaymentConstants.MERCHANT_ID)) {
            return optJSONObject.optString(PaymentConstants.MERCHANT_ID);
        }
        return "";
    }

    public String getNetworkInfo() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "cellular";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return "cellular";
            }
            return "wifi";
        } catch (Exception unused) {
            return null;
        }
    }

    public String getNetworkName() {
        int networkType = getNetworkType();
        if ("wifi".equals(getNetworkInfo())) {
            return "WIFI";
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            default:
                return "OTHER";
        }
    }

    public int getNetworkType() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
            if (d7.a(this.context, "android.permission.READ_PHONE_STATE") == 0 && telephonyManager != null) {
                return telephonyManager.getNetworkType();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getOrderId() {
        JSONObject sessionData = getSessionData();
        if (sessionData.has(PaymentConstants.ORDER_ID)) {
            return sessionData.optString(PaymentConstants.ORDER_ID);
        }
        return "";
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getScreenHeight() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.heightPixels);
        }
        return null;
    }

    public String getScreenSizeDensity() {
        try {
            DisplayMetrics displayMetrics2 = getDisplayMetrics();
            if (displayMetrics2 != null) {
                float f = displayMetrics2.density;
                return (this.context.getResources().getConfiguration().screenLayout & 15) + "-" + f;
            }
            throw new Exception("display metrics null");
        } catch (Exception unused) {
            return null;
        }
    }

    public String getScreenWidth() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.widthPixels);
        }
        return null;
    }

    public JSONObject getSessionData() {
        JSONObject optJSONObject = this.sessionInfo.optJSONObject("sessionData");
        if (optJSONObject != null) {
            return optJSONObject;
        }
        return new JSONObject();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public boolean isVerifyAssetsEnabled() {
        return this.sessionInfo.optBoolean(Constants.VERIFY_ASSETS, true);
    }

    public void logDeviceIdentifiers() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", getDeviceId());
            jSONObject.put("android_id", getAndroidId());
            this.juspayServices.getSdkTracker().trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.IDENTIFIERS, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void logSessionInfo() {
        try {
            this.juspayServices.getSdkTracker().trackContext(LogSubCategory.Context.DEVICE, "info", "session_info", this.sessionInfo);
        } catch (Exception e) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, "session_info", "Exception while logging ", e);
        }
    }

    public void removeAttribute(String str) {
        this.sessionInfo.remove(str);
    }

    public void resetSession() {
        this.sessionId = null;
        this.sessionInfo = new JSONObject();
        this.bundleParams = new JSONObject();
    }

    public void set(String str, String str2) {
        try {
            this.sessionInfo.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void setBundleParams(JSONObject jSONObject) {
        try {
            JSONArray names = this.bundleParams.names();
            if (names != null) {
                for (int i = 0; i < names.length(); i++) {
                    this.bundleParams.remove(names.getString(i));
                }
            }
            JSONArray names2 = jSONObject.names();
            if (names2 != null) {
                for (int i2 = 0; i2 < names2.length(); i2++) {
                    String string = names2.getString(i2);
                    this.bundleParams.put(string, jSONObject.get(string));
                }
            }
            set("bundleParams", this.bundleParams.toString());
        } catch (JSONException unused) {
        }
    }

    public void setSessionId() {
        this.sessionId = UUID.randomUUID().toString();
        String str = LOG_TAG;
        JuspayLogger.d(str, "Session ID: " + this.sessionId);
    }

    public String tryGetClientId() {
        String clientId = getClientId();
        if (clientId.equals("")) {
            return null;
        }
        return clientId;
    }

    public String tryGetMerchantId() {
        String merchantId = getMerchantId();
        if (merchantId.equals("")) {
            return null;
        }
        return merchantId;
    }

    public void updateSessionData(JSONObject jSONObject) {
        this.sessionInfo.remove("sessionData");
        try {
            this.sessionInfo.put("sessionData", jSONObject);
        } catch (JSONException e) {
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            juspayServices2.sdkDebug(str, "Unable to update sessionInfo: " + e);
        }
    }
}
