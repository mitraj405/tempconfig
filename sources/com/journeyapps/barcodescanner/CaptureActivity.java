package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.android.DecodeFormatManager;
import com.google.zxing.client.android.DecodeHintManager;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.Map;
import java.util.Set;

public class CaptureActivity extends Activity {
    public DecoratedBarcodeView a;

    /* renamed from: a  reason: collision with other field name */
    public a f3965a;

    public final void onCreate(Bundle bundle) {
        int intExtra;
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.zxing_capture);
        this.a = (DecoratedBarcodeView) findViewById(R.id.zxing_barcode_scanner);
        DecoratedBarcodeView decoratedBarcodeView = this.a;
        a aVar = new a(this, decoratedBarcodeView);
        this.f3965a = aVar;
        Intent intent = getIntent();
        getWindow().addFlags(128);
        if (bundle != null) {
            aVar.a = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                if (aVar.a == -1) {
                    int rotation = getWindowManager().getDefaultDisplay().getRotation();
                    int i2 = getResources().getConfiguration().orientation;
                    if (i2 == 2) {
                        if (!(rotation == 0 || rotation == 1)) {
                            i = 8;
                            aVar.a = i;
                        }
                    } else if (i2 == 1) {
                        if (rotation == 0 || rotation == 3) {
                            i = 1;
                        } else {
                            i = 9;
                        }
                        aVar.a = i;
                    }
                    i = 0;
                    aVar.a = i;
                }
                setRequestedOrientation(aVar.a);
            }
            if (Intents.Scan.ACTION.equals(intent.getAction())) {
                Set<BarcodeFormat> parseDecodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
                Map<DecodeHintType, Object> parseDecodeHints = DecodeHintManager.parseDecodeHints(intent);
                CameraSettings cameraSettings = new CameraSettings();
                if (intent.hasExtra(Intents.Scan.CAMERA_ID) && (intExtra = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1)) >= 0) {
                    cameraSettings.a = intExtra;
                }
                if (intent.hasExtra(Intents.Scan.TORCH_ENABLED) && intent.getBooleanExtra(Intents.Scan.TORCH_ENABLED, false)) {
                    decoratedBarcodeView.setTorchOn();
                }
                String stringExtra = intent.getStringExtra(Intents.Scan.PROMPT_MESSAGE);
                if (stringExtra != null) {
                    decoratedBarcodeView.setStatusText(stringExtra);
                }
                int intExtra2 = intent.getIntExtra(Intents.Scan.SCAN_TYPE, 0);
                String stringExtra2 = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
                new MultiFormatReader().setHints(parseDecodeHints);
                decoratedBarcodeView.f3966a.setCameraSettings(cameraSettings);
                decoratedBarcodeView.f3966a.setDecoderFactory(new C1299o8(parseDecodeFormats, parseDecodeHints, stringExtra2, intExtra2));
            }
            if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                aVar.f3977a.setBeepEnabled(false);
            }
            if (intent.hasExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG)) {
                boolean booleanExtra = intent.getBooleanExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG, true);
                String stringExtra3 = intent.getStringExtra(Intents.Scan.MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE);
                aVar.f3983b = booleanExtra;
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                aVar.f3981a = stringExtra3;
            }
            if (intent.hasExtra(Intents.Scan.TIMEOUT)) {
                aVar.f3976a.postDelayed(new C0189f6(aVar, 7), intent.getLongExtra(Intents.Scan.TIMEOUT, 0));
            }
            if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                aVar.f3982a = true;
            }
        }
        a aVar2 = this.f3965a;
        a.C0051a aVar3 = aVar2.f3980a;
        DecoratedBarcodeView decoratedBarcodeView2 = aVar2.f3979a;
        BarcodeView barcodeView = decoratedBarcodeView2.f3966a;
        DecoratedBarcodeView.b bVar = new DecoratedBarcodeView.b(aVar3);
        barcodeView.e = 2;
        barcodeView.f3941a = bVar;
        barcodeView.k();
    }

    public final void onDestroy() {
        super.onDestroy();
        a aVar = this.f3965a;
        aVar.c = true;
        aVar.f3978a.cancel();
        aVar.f3976a.removeCallbacksAndMessages((Object) null);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent)) {
            return true;
        }
        return false;
    }

    public final void onPause() {
        super.onPause();
        a aVar = this.f3965a;
        aVar.f3978a.cancel();
        BarcodeView barcodeView = aVar.f3979a.f3966a;
        O3 cameraInstance = barcodeView.getCameraInstance();
        barcodeView.d();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.f3735b && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a aVar = this.f3965a;
        aVar.getClass();
        if (i != 250) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            Intent intent = new Intent(Intents.Scan.ACTION);
            intent.putExtra(Intents.Scan.MISSING_CAMERA_PERMISSION, true);
            aVar.f3975a.setResult(0, intent);
            if (aVar.f3983b) {
                aVar.b(aVar.f3981a);
            } else {
                aVar.a();
            }
        } else {
            aVar.f3979a.f3966a.f();
        }
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.f3965a;
        Activity activity = aVar.f3975a;
        if (d7.a(activity, "android.permission.CAMERA") == 0) {
            aVar.f3979a.f3966a.f();
        } else if (!aVar.e) {
            J.e(activity, new String[]{"android.permission.CAMERA"}, 250);
            aVar.e = true;
        }
        aVar.f3978a.start();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f3965a.a);
    }
}
