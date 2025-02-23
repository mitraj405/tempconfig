package defpackage;

import android.annotation.SuppressLint;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.services.HyperServices;
import java.util.LinkedList;
import org.json.JSONObject;

/* renamed from: cf  reason: default package and case insensitive filesystem */
/* compiled from: HyperServiceHolder */
public final class C0822cf extends HyperPaymentsCallbackAdapter {
    public static HyperPaymentsCallback a;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with other field name */
    public static HyperServices f3934a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList f3935a = new LinkedList();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f3936a;

    /* renamed from: a  reason: collision with other field name */
    public final FragmentActivity f3937a;

    static {
        C1354qp.R(C0822cf.class);
    }

    public C0822cf(FragmentActivity fragmentActivity) {
        this.f3937a = fragmentActivity;
        if (f3934a == null) {
            f3934a = new HyperServices(fragmentActivity);
        }
    }

    public final HyperServices getHyperServices() {
        if (f3934a == null) {
            f3934a = new HyperServices(this.f3937a);
        }
        return f3934a;
    }

    public final void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
        if (jSONObject != null) {
            try {
                jSONObject.getString("event");
            } catch (Exception e) {
                e.getMessage();
            }
            jSONObject.toString();
        }
        HyperPaymentsCallback hyperPaymentsCallback = a;
        if (hyperPaymentsCallback != null) {
            hyperPaymentsCallback.onEvent(jSONObject, juspayResponseHandler);
        } else {
            f3935a.add(new Pair(jSONObject, juspayResponseHandler));
        }
    }

    public final void setCallback(HyperPaymentsCallback hyperPaymentsCallback) {
        a = hyperPaymentsCallback;
        while (true) {
            LinkedList linkedList = f3935a;
            if (linkedList.peek() != null) {
                Pair pair = (Pair) linkedList.poll();
                if (pair != null) {
                    a.onEvent((JSONObject) pair.first, (JuspayResponseHandler) pair.second);
                }
            } else {
                return;
            }
        }
    }
}
