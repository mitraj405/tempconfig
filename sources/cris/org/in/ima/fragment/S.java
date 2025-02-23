package cris.org.in.ima.fragment;

import android.view.ViewTreeObserver;
import android.webkit.WebView;

/* compiled from: HomeFragment */
public final class S implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ HomeFragment a;

    public S(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void onGlobalLayout() {
        HomeFragment homeFragment = this.a;
        WebView webView = homeFragment.content_Cube_WebView;
        String str = C0535I5.j;
        String str2 = C1450w1.f7009a;
        webView.loadDataWithBaseURL("https://cdn.nlpcaptcha.in", C0709Uj.j(C0437ME.b("<html><head><style>body { margin:0; padding:0; top:0; bottom:0; }</style></head><body><div id='nlpCubeBox200X200' ></div><script type=\"text/javascript\">\nvar NLPCubeOptions = { key: 'a8f0962af41dc8e3e477778ec9b18c3c',cubeBoxId: 'nlpCubeBox200X200', isMobileApp: 1, cubeWidth: \"150\", cubeHeight: \"150\", google_advertising_id: '", str, "', age: '", str2, "', gender: '"), C1450w1.f7021c, "'};\n</script>\n\t<script type=\"text/javascript\" src=\"https://cdn.nlpcaptcha.in/js/nlpCubeBox.js\"></script></body></html>"), "text/html", (String) null, (String) null);
        homeFragment.content_Cube_Ad.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
