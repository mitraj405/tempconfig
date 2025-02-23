package in.juspay.hypersmshandler;

import android.content.Intent;
import androidx.annotation.Keep;

@Keep
public interface OnResultHook {
    boolean onActivityResult(int i, int i2, Intent intent);
}
