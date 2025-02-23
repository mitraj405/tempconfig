package defpackage;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* renamed from: k7  reason: default package and case insensitive filesystem */
/* compiled from: CookieJarImpl */
public final class C1211k7 implements CookieJar {
    public final CookieHandler a;

    static {
        C1354qp.R(C1211k7.class);
    }

    public C1211k7(CookieManager cookieManager) {
        this.a = cookieManager;
    }

    public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
        String str;
        try {
            ArrayList arrayList = null;
            for (Map.Entry next : this.a.get(httpUrl.uri(), Collections.emptyMap()).entrySet()) {
                String str2 = (String) next.getKey();
                if ((HttpHeaders.COOKIE.equalsIgnoreCase(str2) || "Cookie2".equalsIgnoreCase(str2)) && !((List) next.getValue()).isEmpty()) {
                    for (String str3 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int length = str3.length();
                        int i = 0;
                        while (i < length) {
                            int delimiterOffset = Util.delimiterOffset(str3, i, length, ";,");
                            int delimiterOffset2 = Util.delimiterOffset(str3, i, delimiterOffset, '=');
                            String trimSubstring = Util.trimSubstring(str3, i, delimiterOffset2);
                            if (!trimSubstring.startsWith("$")) {
                                if (delimiterOffset2 < delimiterOffset) {
                                    str = Util.trimSubstring(str3, delimiterOffset2 + 1, delimiterOffset);
                                } else {
                                    str = "";
                                }
                                if (str.startsWith("\"") && str.endsWith("\"")) {
                                    str = str.substring(1, str.length() - 1);
                                }
                                arrayList2.add(new Cookie.Builder().name(trimSubstring).value(str).domain(httpUrl.host()).build());
                            }
                            i = delimiterOffset + 1;
                        }
                        arrayList.addAll(arrayList2);
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException unused) {
            Objects.toString(httpUrl.resolve("/..."));
            return Collections.emptyList();
        }
    }

    public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        CookieHandler cookieHandler = this.a;
        if (cookieHandler != null) {
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie : list) {
                arrayList.add(cookie.toString());
            }
            try {
                cookieHandler.put(httpUrl.uri(), Collections.singletonMap(HttpHeaders.SET_COOKIE, arrayList));
            } catch (IOException unused) {
                Objects.toString(httpUrl.resolve("/..."));
            }
        }
    }
}
