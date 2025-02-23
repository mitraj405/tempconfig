package in.juspay.hypersdk.core;

import android.util.Base64;
import android.webkit.JavascriptInterface;

public class AcsInterface {
    private final DynamicUI dui;
    private final DuiInterface duiInterface;

    public AcsInterface(JuspayServices juspayServices) {
        this.dui = juspayServices.getDynamicUI();
        this.duiInterface = juspayServices.getJBridge();
    }

    private boolean isFunctionAllowedToInvoke(String str) {
        return str.matches("^[a-zA-Z0-9]*$");
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            return duiInterface2.getDataFromSharedPrefs(str, "");
        }
        return "__failed";
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            return duiInterface2.getResourceByName(str);
        }
        return "__failed";
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            return duiInterface2.getSessionAttribute(str, "");
        }
        return "__failed";
    }

    @JavascriptInterface
    public String getSessionInfo() {
        String str;
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            str = duiInterface2.getSessionInfo();
        } else {
            str = "";
        }
        if (str.equals("")) {
            return "__failed";
        }
        return str;
    }

    @JavascriptInterface
    public void invoke(String str, String str2) {
        if (isFunctionAllowedToInvoke(str)) {
            this.dui.addJsToWebView(String.format("window[\"onEvent'\"]('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
        }
    }

    @JavascriptInterface
    public boolean isOnline() {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            return duiInterface2.isOnline();
        }
        return true;
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3) {
        if (isFunctionAllowedToInvoke(str)) {
            this.dui.addJsToWebView(String.format("window[\"onEvent'\"]('%s',atob('%s'),'%s')", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2), str3}));
        }
    }
}
