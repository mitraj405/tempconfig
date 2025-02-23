package in.juspay.hyper.core;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class JuspayCoreLib {
    private static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static boolean isAppDebuggable() {
        Context applicationContext2 = getApplicationContext();
        if (applicationContext2 == null || (applicationContext2.getApplicationInfo().flags & 2) == 0) {
            return false;
        }
        return true;
    }

    public static void setApplicationContext(Context context) {
        applicationContext = context;
    }
}
