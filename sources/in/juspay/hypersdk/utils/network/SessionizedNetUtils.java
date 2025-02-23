package in.juspay.hypersdk.utils.network;

import com.google.common.net.HttpHeaders;
import in.juspay.hypersdk.data.SessionInfo;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionizedNetUtils extends NetUtils {
    private final SessionInfo sessionInfo;

    public SessionizedNetUtils(SessionInfo sessionInfo2, int i, int i2, boolean z) {
        super(i, i2, z);
        this.sessionInfo = sessionInfo2;
    }

    private String trimClientId(String str) {
        Matcher matcher = Pattern.compile("^(.*)_android$", 2).matcher(str);
        if (!matcher.matches() || matcher.groupCount() <= 0) {
            return str;
        }
        return matcher.group(1);
    }

    public Map<String, String> getDefaultSDKHeaders() {
        Map<String, String> defaultSDKHeaders = super.getDefaultSDKHeaders();
        defaultSDKHeaders.put("x-merchant-id", this.sessionInfo.tryGetMerchantId());
        String tryGetClientId = this.sessionInfo.tryGetClientId();
        if (tryGetClientId != null) {
            tryGetClientId = trimClientId(tryGetClientId);
        }
        defaultSDKHeaders.put("x-client-id", tryGetClientId);
        defaultSDKHeaders.put(HttpHeaders.REFERER, this.sessionInfo.getPackageName());
        return defaultSDKHeaders;
    }
}
