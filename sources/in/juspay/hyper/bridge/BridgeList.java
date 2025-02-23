package in.juspay.hyper.bridge;

import android.webkit.JavascriptInterface;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class BridgeList implements HBridge {
    private final Map<String, HyperBridge> bridgeList = new HashMap();

    public void addHyperBridge(HyperBridge hyperBridge) {
        this.bridgeList.put(hyperBridge.getInterfaceName(), hyperBridge);
    }

    @JavascriptInterface
    public String getBridgeKeys() {
        return new JSONArray(this.bridgeList.keySet()).toString();
    }

    public Map<String, HyperBridge> getBridgeList() {
        return this.bridgeList;
    }

    public String getInterfaceName() {
        return getClass().getSimpleName();
    }
}
