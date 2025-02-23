package in.juspay.hypersdk.services;

import android.content.Context;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.utils.IntegrationUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkConfigService {
    private static final String sdkConfigLocation = "sdk_config.json";
    private final JuspayServices juspayServices;
    private JSONObject sdkConfig;

    public SdkConfigService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        try {
            this.sdkConfig = new JSONObject(KeyValueStore.read(juspayServices2, sdkConfigLocation, "{}"));
        } catch (JSONException e) {
            this.sdkConfig = new JSONObject();
            juspayServices2.getSdkTracker().trackException(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, PaymentConstants.SDK_CONFIG, "Exception while parsing sdk config", e);
        }
    }

    public static JSONObject getCachedSdkConfig() {
        try {
            if (JuspayCoreLib.getApplicationContext() != null) {
                return new JSONObject(KeyValueStore.read(JuspayCoreLib.getApplicationContext(), IntegrationUtils.getSdkInfo(JuspayCoreLib.getApplicationContext()).getSdkName(), sdkConfigLocation, "{}"));
            }
            return null;
        } catch (JSONException e) {
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, PaymentConstants.SDK_CONFIG, "Exception while parsing cached sdk config", e);
            return null;
        }
    }

    public JSONObject getSdkConfig() {
        return this.sdkConfig;
    }

    public void renewConfig(Context context) {
        try {
            String readFromFile = this.juspayServices.getFileProviderService().readFromFile(context, sdkConfigLocation);
            this.sdkConfig = new JSONObject(readFromFile);
            KeyValueStore.write(this.juspayServices, sdkConfigLocation, readFromFile);
        } catch (JSONException e) {
            this.juspayServices.getSdkTracker().trackException(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, PaymentConstants.SDK_CONFIG, "Exception while parsing renewed sdk config", e);
        }
    }
}
