package defpackage;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;
import in.juspay.hyper.constants.LogCategory;

/* renamed from: S  reason: default package */
/* compiled from: ActivityResultContracts.kt */
public final class S extends ActivityResultContract<Intent, ActivityResult> {
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        Intent intent = (Intent) obj;
        C1177ig.f(componentActivity, LogCategory.CONTEXT);
        C1177ig.f(intent, "input");
        return intent;
    }

    public final Object c(int i, Intent intent) {
        return new ActivityResult(i, intent);
    }
}
