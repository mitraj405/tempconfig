package in.juspay.hyperinteg;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.services.HyperServices;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;

@Keep
public class HyperServiceHolder extends HyperPaymentsCallbackAdapter {
    private static HyperPaymentsCallback callback;
    private static final Queue<Pair<JSONObject, JuspayResponseHandler>> events = new LinkedList();
    @SuppressLint({"StaticFieldLeak"})
    private static HyperServices hyperServices;
    private final FragmentActivity fragmentActivity;

    @Keep
    public HyperServiceHolder(FragmentActivity fragmentActivity2) {
        this.fragmentActivity = fragmentActivity2;
        if (hyperServices == null) {
            hyperServices = new HyperServices(fragmentActivity2);
        }
    }

    private void runQueuedEvents() {
        while (true) {
            Queue<Pair<JSONObject, JuspayResponseHandler>> queue = events;
            if (queue.peek() != null) {
                Pair poll = queue.poll();
                if (poll != null) {
                    callback.onEvent((JSONObject) poll.first, (JuspayResponseHandler) poll.second);
                }
            } else {
                return;
            }
        }
    }

    @Keep
    public HyperServices getHyperServices() {
        if (hyperServices == null) {
            hyperServices = new HyperServices(this.fragmentActivity);
        }
        return hyperServices;
    }

    public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
        return callback.getMerchantView(viewGroup, merchantViewType);
    }

    @Keep
    public void initiate(JSONObject jSONObject) {
        getHyperServices().initiate(this.fragmentActivity, jSONObject, this);
    }

    @Keep
    public boolean isInitialised() {
        return getHyperServices().isInitialised();
    }

    @Keep
    public boolean onBackPressed() {
        return getHyperServices().onBackPressed();
    }

    public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
        HyperPaymentsCallback hyperPaymentsCallback = callback;
        if (hyperPaymentsCallback != null) {
            hyperPaymentsCallback.onEvent(jSONObject, juspayResponseHandler);
        } else {
            events.add(new Pair(jSONObject, juspayResponseHandler));
        }
    }

    @Keep
    public void process(ViewGroup viewGroup, JSONObject jSONObject) {
        getHyperServices().lambda$process$5(this.fragmentActivity, viewGroup, jSONObject);
    }

    @Keep
    public void resetActivity() {
        HyperServices hyperServices2 = hyperServices;
        if (hyperServices2 != null) {
            hyperServices2.resetActivity(this.fragmentActivity);
        }
    }

    @Keep
    public void setCallback(HyperPaymentsCallback hyperPaymentsCallback) {
        callback = hyperPaymentsCallback;
        runQueuedEvents();
    }

    @Keep
    public void terminate() {
        getHyperServices().terminate();
    }

    @Keep
    public void process(JSONObject jSONObject) {
        getHyperServices().process(this.fragmentActivity, jSONObject);
    }

    @Keep
    public HyperServiceHolder(FragmentActivity fragmentActivity2, HyperPaymentsCallback hyperPaymentsCallback) {
        this(fragmentActivity2);
        callback = hyperPaymentsCallback;
        runQueuedEvents();
    }
}
