package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class LogChannel {
    final long batchCount;
    final String channelName;
    private int currentBatchRetryAttempts = 0;
    final String encryptionLevel;
    final String endPointProd;
    final String endpointSBX;
    final String environment;
    Map<String, String> headers;
    final JSONObject keyProd;
    final JSONObject keySBX;
    private final ConcurrentLinkedQueue<byte[]> logsQueue = new ConcurrentLinkedQueue<>();
    final int priority;
    final int retryAttempts;

    public LogChannel(int i, long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5) {
        this.channelName = str;
        this.endPointProd = str2;
        this.endpointSBX = str3;
        this.keyProd = jSONObject;
        this.keySBX = jSONObject2;
        this.headers = map;
        this.priority = i2;
        this.environment = str4;
        this.encryptionLevel = str5;
        this.retryAttempts = i;
        this.batchCount = j;
    }

    public void addToLogsQueue(byte[] bArr) {
        this.logsQueue.add(bArr);
    }

    public long getBatchCount() {
        return this.batchCount;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getCurrentBatchRetryAttempts() {
        return this.currentBatchRetryAttempts;
    }

    public String getEncryptionLevel() {
        return this.encryptionLevel;
    }

    public String getEndPointProd() {
        return this.endPointProd;
    }

    public String getEndpointSBX() {
        return this.endpointSBX;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public JSONObject getKeyProd() {
        return this.keyProd;
    }

    public JSONObject getKeySBX() {
        return this.keySBX;
    }

    public ConcurrentLinkedQueue<byte[]> getLogsQueue() {
        return this.logsQueue;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRetryAttempts() {
        return this.retryAttempts;
    }

    public void pollLogsQueue() {
        this.logsQueue.poll();
    }

    public void setCurrentBatchRetryAttempts(int i) {
        this.currentBatchRetryAttempts = i;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelName", this.channelName).put("endPointProd", this.endPointProd).put("headers", this.headers).put("endpointSBX", this.endpointSBX).put("keyProd", this.keyProd).put("keySBX", this.keySBX).put("encryptionLevel", this.encryptionLevel).put("priority", this.priority).put(PaymentConstants.ENV, this.environment).put("retryAttempts", this.retryAttempts).put("batchCount", this.batchCount);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
