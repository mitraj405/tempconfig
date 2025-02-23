package defpackage;

import android.content.pm.PackageInfo;
import android.os.Build;
import defpackage.C0390xD;
import defpackage.Px;
import defpackage.Y0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: wD  reason: default package and case insensitive filesystem */
/* compiled from: WebViewFeatureInternal */
public final class C0376wD {
    public static final Y0.d a = new Y0.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
    public static final Y0.d b = new Y0.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    public static final Y0.d c = new Y0.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    public static final Y0.d d = new Y0.d("MUTE_AUDIO", "MUTE_AUDIO");

    /* renamed from: wD$a */
    /* compiled from: WebViewFeatureInternal */
    public class a extends Y0.i {
        public final Pattern a = Pattern.compile("\\A\\d+");

        public final boolean c() {
            boolean c = super.c();
            if (!c || Build.VERSION.SDK_INT >= 29) {
                return c;
            }
            int i = C0362vD.a;
            PackageInfo a2 = Z0.a();
            if (a2 == null) {
                return false;
            }
            Matcher matcher = this.a.matcher(a2.versionName);
            if (!matcher.find() || Integer.parseInt(a2.versionName.substring(matcher.start(), matcher.end())) < 105) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: wD$b */
    /* compiled from: WebViewFeatureInternal */
    public class b extends Y0.d {
        public b() {
            super("MULTI_PROFILE", "MULTI_PROFILE");
        }

        public final boolean c() {
            if (!super.c() || !r1.C("MULTI_PROCESS")) {
                return false;
            }
            int i = C0362vD.a;
            if (C0376wD.b.c()) {
                return C0390xD.a.a.e().isMultiProcessEnabled();
            }
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
    }

    static {
        new Y0.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        new Y0.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        new Y0.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        new Y0.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        new Y0.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        new Y0.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        new Y0.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        new Y0.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        new Y0.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        new Y0.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        new Y0.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        new Y0.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        new Y0.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        new Y0.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        new Y0.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        new Y0.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        new Y0.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        new Y0.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        new Y0.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        new Y0.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        new Y0.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        new Y0.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        new Y0.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        new Y0.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        new Y0.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        new Y0.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        new Y0.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        new Y0.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        new Y0.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        new Y0.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        new Y0.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        new Y0.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        new Y0.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        new Y0.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        new Y0.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        new Y0.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        new Y0.g();
        new Px.b();
        new Px.a();
        new Y0.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        new a();
        new Y0.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        new Y0.h("FORCE_DARK", "FORCE_DARK");
        new Y0.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        new Y0.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        new Y0.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        new Y0.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        new Y0.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        new Y0.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        new Y0.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
        new Y0.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");
        new b();
        new Y0.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");
        new Y0.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
    }
}
