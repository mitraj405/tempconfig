package in.juspay.hypersdk.utils;

import android.content.Context;
import com.google.android.gms.ads.AdError;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.SdkInfo;

public class IntegrationUtils {
    public static String getAppName(Context context) {
        return context.getString(R.string.godel_app_name);
    }

    public static String getAssetAarVersion(Context context) {
        return getVersion(context, PaymentConstants.ASSET_AAR_VERSION);
    }

    public static String getGodelBuildVersion(Context context) {
        return getVersion(context, PaymentConstants.GODEL_BUILD_VERSION);
    }

    public static String getGodelVersion(Context context) {
        return getVersion(context, PaymentConstants.GODEL_VERSION);
    }

    public static SdkInfo getSdkInfo(Context context) {
        return new SdkInfo(getAppName(context), getGodelVersion(context), isSdkDebuggable(context), usesLocalAssets(context));
    }

    public static String getSdkVersion(Context context) {
        return getSdkVersion(context, "-");
    }

    private static String getVersion(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return AdError.UNDEFINED_DOMAIN;
        }
        return context.getString(identifier);
    }

    private static boolean isSdkDebuggable(Context context) {
        return context.getResources().getBoolean(R.bool.godel_debuggable);
    }

    private static boolean usesLocalAssets(Context context) {
        return context.getResources().getBoolean(R.bool.use_local_assets);
    }

    public static String getSdkVersion(Context context, String str) {
        StringBuilder sb = new StringBuilder(getGodelVersion(context));
        if (context.getResources().getBoolean(context.getResources().getIdentifier("use_rc", "bool", context.getPackageName()))) {
            sb.append(str);
            sb.append(getGodelBuildVersion(context));
        }
        return sb.toString();
    }
}
