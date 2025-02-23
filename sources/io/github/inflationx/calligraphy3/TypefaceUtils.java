package io.github.inflationx.calligraphy3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.Map;

public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    private TypefaceUtils() {
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            if (!map.containsKey(typeface)) {
                CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
                map.put(typeface, calligraphyTypefaceSpan);
                return calligraphyTypefaceSpan;
            }
            CalligraphyTypefaceSpan calligraphyTypefaceSpan2 = map.get(typeface);
            return calligraphyTypefaceSpan2;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        if (typeface == null || !sCachedFonts.containsValue(typeface)) {
            return false;
        }
        return true;
    }

    public static Typeface load(AssetManager assetManager, String str) {
        Typeface typeface;
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                if (!map.containsKey(str)) {
                    if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        typeface = Typeface.createFromFile(str);
                    } else {
                        typeface = Typeface.createFromAsset(assetManager, str);
                    }
                    map.put(str, typeface);
                    return typeface;
                }
                Typeface typeface2 = map.get(str);
                return typeface2;
            } catch (Exception unused) {
                sCachedFonts.put(str, (Object) null);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
