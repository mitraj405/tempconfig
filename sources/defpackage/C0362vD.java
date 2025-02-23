package defpackage;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;

/* renamed from: vD  reason: default package and case insensitive filesystem */
/* compiled from: WebViewCompat */
public final class C0362vD {
    public static final /* synthetic */ int a = 0;

    /* renamed from: vD$a */
    /* compiled from: WebViewCompat */
    public interface a {
        void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    static {
        Uri.parse("*");
        Uri.parse("");
    }
}
