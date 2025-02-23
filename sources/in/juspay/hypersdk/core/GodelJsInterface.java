package in.juspay.hypersdk.core;

import android.webkit.JavascriptInterface;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class GodelJsInterface {
    private static final String LOG_TAG = "GodelJsInterface";
    private final JuspayServices juspayServices;

    public GodelJsInterface(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    @JavascriptInterface
    public void sendMessage(String str) {
        if (this.juspayServices.getHyperCallback() != null) {
            HyperPaymentsCallback hyperCallback = this.juspayServices.getHyperCallback();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "godel_merchant_message");
                jSONObject.put(PaymentConstants.PAYLOAD, str);
            } catch (JSONException e) {
                this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "exception on godelJsInterface", e);
            }
            hyperCallback.onEvent(jSONObject, (JuspayResponseHandler) null);
        }
    }
}
