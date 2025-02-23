package com.momagic;

import android.app.Activity;
import android.os.Bundle;

public class NotificationPermission extends Activity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d7.a(this, "android.permission.POST_NOTIFICATIONS") == -1) {
            J.e(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 123456);
        } else {
            finish();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 123456) {
            if (iArr.length > 0) {
                if (iArr[0] == 0) {
                    String str = C0835h.f4048a;
                    if (str == null || str.isEmpty()) {
                        C0835h.f4046a.getString(C0772Zr.something_wrong_fcm_sender_id);
                    } else {
                        C0835h.f(C0835h.f4046a, C0835h.f4048a);
                    }
                    finish();
                } else if (J.f(this, "android.permission.POST_NOTIFICATIONS")) {
                    finish();
                } else {
                    finish();
                }
            }
            overridePendingTransition(C0740Wq.datb_notification_permission_fade_in, C0740Wq.datb_notification_permission_fade_out);
        }
    }
}
