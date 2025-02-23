package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.perf.util.Constants;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.CameraPreview;
import java.util.ArrayList;
import java.util.List;

public class ViewfinderView extends View {
    public static final int[] a = {0, 64, 128, 192, Constants.MAX_HOST_LENGTH, 192, 128, 64};

    /* renamed from: a  reason: collision with other field name */
    public final Paint f3969a = new Paint(1);

    /* renamed from: a  reason: collision with other field name */
    public Rect f3970a;

    /* renamed from: a  reason: collision with other field name */
    public CameraPreview f3971a;

    /* renamed from: a  reason: collision with other field name */
    public List<ResultPoint> f3972a;

    /* renamed from: a  reason: collision with other field name */
    public C1205jx f3973a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3974a;
    public List<ResultPoint> b;
    public int c;
    public final int d;
    public final int e;
    public int f;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.c = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.d = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.e = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        this.f3974a = obtainStyledAttributes.getBoolean(R.styleable.zxing_finder_zxing_viewfinder_laser_visibility, true);
        obtainStyledAttributes.recycle();
        this.f = 0;
        this.f3972a = new ArrayList(20);
        this.b = new ArrayList(20);
    }

    public final void onDraw(Canvas canvas) {
        C1205jx jxVar;
        CameraPreview cameraPreview = this.f3971a;
        if (cameraPreview != null) {
            Rect framingRect = cameraPreview.getFramingRect();
            C1205jx previewSize = this.f3971a.getPreviewSize();
            if (!(framingRect == null || previewSize == null)) {
                this.f3970a = framingRect;
                this.f3973a = previewSize;
            }
        }
        Rect rect = this.f3970a;
        if (rect != null && (jxVar = this.f3973a) != null) {
            int width = getWidth();
            int height = getHeight();
            Paint paint = this.f3969a;
            paint.setColor(this.c);
            float f2 = (float) width;
            Paint paint2 = paint;
            canvas.drawRect(0.0f, 0.0f, f2, (float) rect.top, paint2);
            canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), paint2);
            float f3 = f2;
            canvas.drawRect((float) (rect.right + 1), (float) rect.top, f3, (float) (rect.bottom + 1), paint2);
            canvas.drawRect(0.0f, (float) (rect.bottom + 1), f3, (float) height, paint2);
            if (this.f3974a) {
                paint.setColor(this.d);
                paint.setAlpha(a[this.f]);
                this.f = (this.f + 1) % 8;
                int height2 = (rect.height() / 2) + rect.top;
                canvas.drawRect((float) (rect.left + 2), (float) (height2 - 1), (float) (rect.right - 1), (float) (height2 + 2), paint);
            }
            float width2 = ((float) getWidth()) / ((float) jxVar.c);
            float height3 = ((float) getHeight()) / ((float) jxVar.d);
            boolean isEmpty = this.b.isEmpty();
            int i = this.e;
            if (!isEmpty) {
                paint.setAlpha(80);
                paint.setColor(i);
                for (ResultPoint next : this.b) {
                    canvas.drawCircle((float) ((int) (next.getX() * width2)), (float) ((int) (next.getY() * height3)), 3.0f, paint);
                }
                this.b.clear();
            }
            if (!this.f3972a.isEmpty()) {
                paint.setAlpha(160);
                paint.setColor(i);
                for (ResultPoint next2 : this.f3972a) {
                    canvas.drawCircle((float) ((int) (next2.getX() * width2)), (float) ((int) (next2.getY() * height3)), 6.0f, paint);
                }
                List<ResultPoint> list = this.f3972a;
                List<ResultPoint> list2 = this.b;
                this.f3972a = list2;
                this.b = list;
                list2.clear();
            }
            postInvalidateDelayed(80, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
        }
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.f3971a = cameraPreview;
        cameraPreview.f3954a.add(new a());
    }

    public void setLaserVisibility(boolean z) {
        this.f3974a = z;
    }

    public void setMaskColor(int i) {
        this.c = i;
    }

    public class a implements CameraPreview.e {
        public a() {
        }

        public final void b() {
            ViewfinderView viewfinderView = ViewfinderView.this;
            CameraPreview cameraPreview = viewfinderView.f3971a;
            if (cameraPreview != null) {
                Rect framingRect = cameraPreview.getFramingRect();
                C1205jx previewSize = viewfinderView.f3971a.getPreviewSize();
                if (!(framingRect == null || previewSize == null)) {
                    viewfinderView.f3970a = framingRect;
                    viewfinderView.f3973a = previewSize;
                }
            }
            viewfinderView.invalidate();
        }

        public final void a() {
        }

        public final void c() {
        }

        public final void d() {
        }

        public final void e(Exception exc) {
        }
    }
}
