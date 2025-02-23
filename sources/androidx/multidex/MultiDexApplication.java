package androidx.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication extends Application {
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0123am.d(this);
    }
}
