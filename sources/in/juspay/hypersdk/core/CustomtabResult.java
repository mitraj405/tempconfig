package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import in.juspay.hyper.core.JuspayLogger;

public class CustomtabResult extends Activity {
    public static final String CUSTOMTAB_RESULT = "customtab-result";
    private static final String LOG_TAG = "CustomtabResult";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent("customtab-result");
        try {
            intent.putExtra("response", getIntent().getDataString());
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "Couldn't find data from url", e);
        }
        intent.putExtra("status", "SUCCESS");
        ji.a(this).b(intent);
        startActivity(new Intent(this, CustomtabActivity.class));
        finish();
    }
}
