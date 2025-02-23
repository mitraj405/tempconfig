package androidx.appcompat.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.AdRequest;

public final class AppLocalesMetadataHolderService extends Service {
    public static final /* synthetic */ int c = 0;

    public static class a {
        public static int a() {
            return AdRequest.MAX_CONTENT_URL_LENGTH;
        }
    }

    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
