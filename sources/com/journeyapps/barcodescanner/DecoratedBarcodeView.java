package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.List;

public class DecoratedBarcodeView extends FrameLayout {
    public TextView a;

    /* renamed from: a  reason: collision with other field name */
    public BarcodeView f3966a;

    /* renamed from: a  reason: collision with other field name */
    public ViewfinderView f3967a;

    public interface a {
    }

    public class b implements C1251m2 {

        /* renamed from: a  reason: collision with other field name */
        public final C1251m2 f3968a;

        public b(a.C0051a aVar) {
            this.f3968a = aVar;
        }

        public final void a(C1272n2 n2Var) {
            this.f3968a.a(n2Var);
        }

        public final void b(List<ResultPoint> list) {
            for (ResultPoint next : list) {
                ViewfinderView viewfinderView = DecoratedBarcodeView.this.f3967a;
                if (viewfinderView.f3972a.size() < 20) {
                    viewfinderView.f3972a.add(next);
                }
            }
            this.f3968a.b(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.f3966a = barcodeView;
        if (barcodeView != null) {
            barcodeView.c(attributeSet);
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
            this.f3967a = viewfinderView;
            if (viewfinderView != null) {
                viewfinderView.setCameraPreview(this.f3966a);
                this.a = (TextView) findViewById(R.id.zxing_status_view);
                return;
            }
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public CameraSettings getCameraSettings() {
        return this.f3966a.getCameraSettings();
    }

    public C1191j8 getDecoderFactory() {
        return this.f3966a.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.a;
    }

    public ViewfinderView getViewFinder() {
        return this.f3967a;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            setTorchOn();
            return true;
        } else if (i == 25) {
            setTorchOff();
            return true;
        } else if (i == 27 || i == 80) {
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f3966a.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(C1191j8 j8Var) {
        this.f3966a.setDecoderFactory(j8Var);
    }

    public void setStatusText(String str) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchOff() {
        this.f3966a.setTorch(false);
    }

    public void setTorchOn() {
        this.f3966a.setTorch(true);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    public void setTorchListener(a aVar) {
    }
}
