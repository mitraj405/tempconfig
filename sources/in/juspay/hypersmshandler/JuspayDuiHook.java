package in.juspay.hypersmshandler;

import android.app.Activity;
import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
public interface JuspayDuiHook {
    void attach(Activity activity);

    void detach(Activity activity);

    String execute(Activity activity, String str, JSONObject jSONObject);
}
