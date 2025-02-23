package defpackage;

import cris.org.in.ima.fragment.ReviewAndPayFragment;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import org.json.JSONObject;

/* renamed from: Vt  reason: default package and case insensitive filesystem */
/* compiled from: ReviewAndPayFragment */
public final class C0728Vt extends HyperPaymentsCallbackAdapter {
    public final /* synthetic */ ReviewAndPayFragment a;

    public C0728Vt(ReviewAndPayFragment reviewAndPayFragment) {
        this.a = reviewAndPayFragment;
    }

    public final void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
        try {
            if (jSONObject.getString("event").equalsIgnoreCase("process_result")) {
                JSONObject optJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD);
                if (!optJSONObject.getBoolean("isHealthy") && optJSONObject.getString(LogCategory.ACTION).equalsIgnoreCase("healthCheck")) {
                    this.a.f5100e = false;
                }
            }
        } catch (Exception e) {
            String str = ReviewAndPayFragment.x;
            e.getMessage();
        }
    }
}
