package com.facebook.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@SuppressLint({"MissingSuperCall"})
@Keep
public class AudienceNetworkActivity extends Activity {
    private AudienceNetworkActivityApi mAudienceNetworkActivityApi;
    private final AudienceNetworkActivityApi mAudienceNetworkActivityParentApi = new a();

    public class a implements AudienceNetworkActivityApi {
        public a() {
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AudienceNetworkActivity.super.dump(str, fileDescriptor, printWriter, strArr);
        }

        public final void finish(int i) {
            AudienceNetworkActivity.super.finish();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AudienceNetworkActivity.super.onActivityResult(i, i2, intent);
        }

        public final void onBackPressed() {
            AudienceNetworkActivity.super.onBackPressed();
        }

        public final void onConfigurationChanged(Configuration configuration) {
            AudienceNetworkActivity.super.onConfigurationChanged(configuration);
        }

        public final void onCreate(Bundle bundle) {
            AudienceNetworkActivity.super.onCreate(bundle);
        }

        public final void onDestroy() {
            AudienceNetworkActivity.super.onDestroy();
        }

        public final void onPause() {
            AudienceNetworkActivity.super.onPause();
        }

        public final void onResume() {
            AudienceNetworkActivity.super.onResume();
        }

        public final void onSaveInstanceState(Bundle bundle) {
            AudienceNetworkActivity.super.onSaveInstanceState(bundle);
        }

        public final void onStart() {
            AudienceNetworkActivity.super.onStart();
        }

        public final void onStop() {
            AudienceNetworkActivity.super.onStop();
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return AudienceNetworkActivity.super.onTouchEvent(motionEvent);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mAudienceNetworkActivityApi.dump(str, fileDescriptor, printWriter, strArr);
    }

    public void finish() {
        this.mAudienceNetworkActivityApi.finish(0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mAudienceNetworkActivityApi.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.mAudienceNetworkActivityApi.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mAudienceNetworkActivityApi.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AudienceNetworkActivityApi createAudienceNetworkActivity = DynamicLoaderFactory.makeLoader(this).createAudienceNetworkActivity(this, this.mAudienceNetworkActivityParentApi);
        this.mAudienceNetworkActivityApi = createAudienceNetworkActivity;
        createAudienceNetworkActivity.onCreate(bundle);
    }

    public void onDestroy() {
        this.mAudienceNetworkActivityApi.onDestroy();
    }

    public void onPause() {
        this.mAudienceNetworkActivityApi.onPause();
    }

    public void onResume() {
        this.mAudienceNetworkActivityApi.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mAudienceNetworkActivityApi.onSaveInstanceState(bundle);
    }

    public void onStart() {
        this.mAudienceNetworkActivityApi.onStart();
    }

    public void onStop() {
        this.mAudienceNetworkActivityApi.onStop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mAudienceNetworkActivityApi.onTouchEvent(motionEvent);
    }
}
