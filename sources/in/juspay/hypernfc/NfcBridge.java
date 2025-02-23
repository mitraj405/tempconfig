package in.juspay.hypernfc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.cardreader.card_reader_lib.CardTask;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.core.BridgeComponents;
import org.json.JSONObject;

public class NfcBridge extends HyperBridge {
    private final int NFC_CARD_REQUEST = 121;
    private final int SETTINGS_REQUEST = 144;
    private String callback;
    private final CardTask cardTask = new CardTask();
    private int waitingTime;

    public NfcBridge(BridgeComponents bridgeComponents) {
        super(bridgeComponents);
    }

    private void showLoadingScreen(String str, int i) {
        this.callback = str;
        this.waitingTime = i;
        Intent intent = new Intent(this.bridgeComponents.getContext(), NfcActivity.class);
        intent.putExtra("waitingTime", i);
        this.bridgeComponents.getFragmentHooks().startActivityForResult(intent, 121, (Bundle) null);
    }

    @JavascriptInterface
    public boolean isNFCEnabled() {
        return this.cardTask.isNFCEnabled(this.bridgeComponents.getContext());
    }

    @JavascriptInterface
    public boolean isNFCSupportPresent() {
        return this.cardTask.isNFCSupported(this.bridgeComponents.getContext());
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle;
        if (i != 144 && i != 121) {
            return false;
        }
        String str = null;
        if (intent != null) {
            try {
                bundle = intent.getExtras();
            } catch (Exception unused) {
                this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
            }
        } else {
            bundle = null;
        }
        if (i == 121 && (i2 == -1 || i2 == 0)) {
            if (intent == null || !intent.hasExtra("result_data")) {
                this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
                return false;
            }
            if (bundle != null) {
                str = bundle.getString("result_data");
            }
            this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, str);
            return true;
        } else if (i != 144 || !isNFCEnabled()) {
            if (i == 144 && !isNFCEnabled()) {
                this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Permission denied !!\"}");
                return true;
            }
            return false;
        } else {
            openNFCReader(this.callback, this.waitingTime);
            return true;
        }
    }

    @JavascriptInterface
    public void openNFCReader(String str, int i) {
        this.callback = str;
        this.waitingTime = i;
        try {
            if (isNFCSupportPresent() && isNFCEnabled()) {
                showLoadingScreen(str, i);
            } else if (isNFCSupportPresent()) {
                this.bridgeComponents.getFragmentHooks().startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 144, (Bundle) null);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", "Does not support");
                jSONObject.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, (Object) null);
                this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, jSONObject.toString());
            }
        } catch (Exception e) {
            this.bridgeComponents.getCallbackInvoker().invokeCallbackInDUIWebview(str, String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{Base64.encodeToString(e.toString().getBytes(), 2)}));
        }
    }
}
