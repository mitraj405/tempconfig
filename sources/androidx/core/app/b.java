package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

/* compiled from: NotificationCompat */
public final class b extends Ym {

    /* compiled from: NotificationCompat */
    public static class a {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putInt("android.callType", 0);
        bundle.putBoolean("android.callIsVideo", false);
        bundle.putCharSequence("android.verificationText", (CharSequence) null);
        bundle.putParcelable("android.answerIntent", (Parcelable) null);
        bundle.putParcelable("android.declineIntent", (Parcelable) null);
        bundle.putParcelable("android.hangUpIntent", (Parcelable) null);
    }

    public final void b(Zm zm) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 31) {
            Notification.Builder builder = zm.a;
            CharSequence charSequence2 = null;
            builder.setContentTitle((CharSequence) null);
            Bundle bundle = this.a.f1738a;
            if (bundle == null || !bundle.containsKey("android.text")) {
                charSequence = null;
            } else {
                charSequence = this.a.f1738a.getCharSequence("android.text");
            }
            if (charSequence != null) {
                charSequence2 = charSequence;
            }
            builder.setContentText(charSequence2);
            a.b(builder, "call");
        } else if (Log.isLoggable("NotifCompat", 3)) {
            String.valueOf(0);
        }
    }

    public final String c() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }
}
