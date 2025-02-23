package in.juspay.hyper.core;

import org.json.JSONObject;

public interface TrackerInterface {
    void addLogToPersistedQueue(JSONObject jSONObject);

    void track(JSONObject jSONObject);

    void trackAction(String str, String str2, String str3, String str4, Object obj);

    void trackAndLogException(String str, String str2, String str3, String str4, String str5, Throwable th);

    void trackApiCalls(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5);

    void trackLifecycle(String str, String str2, String str3, String str4, Object obj);
}
