package com.google.android.gms.internal.ads;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfrx implements SensorEventListener {
    public zzfrx(String str, String str2) {
        zzfrw.zza();
        zzfrv.zza();
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        zza(sensorEvent);
    }

    public abstract void zza(SensorEvent sensorEvent);

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
