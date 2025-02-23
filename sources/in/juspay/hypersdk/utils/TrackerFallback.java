package in.juspay.hypersdk.utils;

import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class TrackerFallback {
    private int count = 3;
    private boolean enableTrackerFallback;
    private NetUtils netUtils;
    private List<String> requiredKeysList;

    public TrackerFallback(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("enableTrackerFallback")) {
            try {
                this.netUtils = new NetUtils(0, 0);
                this.enableTrackerFallback = jSONObject.optBoolean("enableTrackerFallback", true);
                this.count = jSONObject.optInt("trackerFallbackAttempts", 3);
                this.requiredKeysList = Arrays.asList(new String[]{LogCategory.ACTION, PaymentConstants.ORDER_ID_CAMEL, PaymentConstants.CLIENT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, "customerId", "os", "os_version", "app_version", "requestId"});
            } catch (Exception unused) {
            }
        }
    }

    private HashMap<String, String> getQueryParams(JuspayServices juspayServices, JSONObject jSONObject, LogType logType) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        LogType logType2 = LogType.PROCESS_END;
        if (logType == logType2) {
            arrayList.add("errorMessage");
            arrayList.add("errorCode");
        }
        if (logType == LogType.INITIATE_RESULT || logType == logType2) {
            arrayList.add(PaymentConstants.CLIENT_ID);
            arrayList.add(PaymentConstants.MERCHANT_ID);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD);
        JSONObject sessionData = juspayServices.getSessionInfo().getSessionData();
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> list = this.requiredKeysList;
        if (list != null) {
            for (String next : list) {
                if (optJSONObject != null && optJSONObject.has(next)) {
                    str2 = optJSONObject.optString(next, "");
                } else if (sessionData.has(next)) {
                    str2 = sessionData.optString(next, "");
                } else if (jSONObject.has(next)) {
                    str2 = jSONObject.optString(next, "");
                }
                hashMap.put(next, str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (optJSONObject != null && optJSONObject.has(str3)) {
                str = optJSONObject.optString(str3, "");
            } else if (jSONObject.has(str3)) {
                str = jSONObject.optString(str3, "");
            }
            hashMap.put(str3, str);
        }
        hashMap.put("sessionId", juspayServices.getSessionInfo().getSessionId());
        hashMap.put("logtype", logType.name());
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$log$0(JuspayServices juspayServices, JSONObject jSONObject, LogType logType) {
        try {
            if (this.enableTrackerFallback && this.netUtils != null) {
                int i = 0;
                while (i < this.count) {
                    if (this.netUtils.doGet("https://assets.juspay.in/a.html", new HashMap(), getQueryParams(juspayServices, jSONObject, logType), new JSONObject()).getResponseCode() != 200) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void log(JSONObject jSONObject, JuspayServices juspayServices, LogType logType) {
        ExecutorManager.runOnBackgroundThread(new w8(this, juspayServices, jSONObject, logType, 1));
    }
}
