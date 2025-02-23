package com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.journeyapps.barcodescanner.camera.CameraManager;
import com.journeyapps.barcodescanner.camera.CameraSettings;

public final class AmbientLightManager implements SensorEventListener {
    private static final float BRIGHT_ENOUGH_LUX = 450.0f;
    private static final float TOO_DARK_LUX = 45.0f;
    private CameraManager cameraManager;
    private CameraSettings cameraSettings;
    private Context context;
    private Handler handler = new Handler();
    private Sensor lightSensor;

    public AmbientLightManager(Context context2, CameraManager cameraManager2, CameraSettings cameraSettings2) {
        this.context = context2;
        this.cameraManager = cameraManager2;
        this.cameraSettings = cameraSettings2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setTorch$0(boolean z) {
        this.cameraManager.d(z);
    }

    private void setTorch(boolean z) {
        this.handler.post(new C1491y0(this, z));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.cameraManager == null) {
            return;
        }
        if (f <= TOO_DARK_LUX) {
            setTorch(true);
        } else if (f >= BRIGHT_ENOUGH_LUX) {
            setTorch(false);
        }
    }

    public void start() {
        this.cameraSettings.getClass();
    }

    public void stop() {
        if (this.lightSensor != null) {
            ((SensorManager) this.context.getSystemService("sensor")).unregisterListener(this);
            this.lightSensor = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
