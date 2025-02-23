package in.juspay.hypersdk.core;

import android.content.Context;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.R;
import in.juspay.services.TenantParams;
import org.json.JSONObject;

public class PrefetchServices {
    private static final String LOG_TAG = "PrefetchServices";

    public static void preFetch(Context context, JSONObject jSONObject) {
        JuspayCoreLib.setApplicationContext(context.getApplicationContext());
        try {
            jSONObject.put("pre_fetch", "true");
            jSONObject.put("use_local_assets", context.getResources().getBoolean(R.bool.use_local_assets));
            JuspayServices juspayServices = new JuspayServices(context, (TenantParams) null);
            juspayServices.setPrefetch(true);
            juspayServices.setBundleParameter(jSONObject);
            ExecutorManager.runOnMainThread(new C0492E9(juspayServices, 3));
        } catch (Exception e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.PREFETCH, "Exception happened in PREFETCH", e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$preFetch$0() {
    }
}
