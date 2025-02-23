package in.juspay.hypersmshandler;

import androidx.annotation.Keep;

@Keep
public interface Tracker {
    void trackAction(String str, String str2, String str3, String str4, Object obj);

    void trackAndLogException(String str, String str2, String str3, String str4, String str5, Throwable th);
}
