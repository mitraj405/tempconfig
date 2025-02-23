package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogChannelExp extends LogChannel {
    private final String errorUrl;
    private final JSONArray fallBackPublicKeys;
    private final JSONArray fallBackUrls;
    private final ArrayList<String> logsQueue = new ArrayList<>();

    public LogChannelExp(int i, long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5, JSONArray jSONArray, JSONArray jSONArray2, String str6) {
        super(i, j, str, str2, str3, jSONObject, jSONObject2, map, i2, str4, str5);
        this.fallBackUrls = jSONArray;
        this.fallBackPublicKeys = jSONArray2;
        this.errorUrl = str6;
    }

    public void addToLogsQueue(String str) {
        this.logsQueue.add(str);
    }

    public String getErrorUrl() {
        return this.errorUrl;
    }

    public JSONArray getFallBackPublicKeys() {
        return this.fallBackPublicKeys;
    }

    public JSONArray getFallBackUrls() {
        return this.fallBackUrls;
    }

    public ArrayList<String> getLogsQueueExp() {
        return this.logsQueue;
    }

    public void pollLogsQueue(String str) {
        this.logsQueue.remove(str);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelName", this.channelName).put("endPointProd", this.endPointProd).put("headers", this.headers).put("endpointSBX", this.endpointSBX).put("keyProd", this.keyProd).put("keySBX", this.keySBX).put("encryptionLevel", this.encryptionLevel).put("priority", this.priority).put(PaymentConstants.ENV, this.environment).put("retryAttempts", this.retryAttempts).put("batchCount", this.batchCount).put("fallBackUrls", this.fallBackUrls).put("fallBackPublicKeys", this.fallBackUrls).put("errorUrl", this.errorUrl);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
