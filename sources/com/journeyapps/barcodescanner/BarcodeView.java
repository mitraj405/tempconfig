package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.android.R;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarcodeView extends CameraPreview {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public C1191j8 f3939a;

    /* renamed from: a  reason: collision with other field name */
    public C1236l8 f3940a;

    /* renamed from: a  reason: collision with other field name */
    public C1251m2 f3941a = null;
    public Handler b;
    public int e = 1;

    public class a implements Handler.Callback {
        public a() {
        }

        public final boolean handleMessage(Message message) {
            C1251m2 m2Var;
            int i = message.what;
            int i2 = R.id.zxing_decode_succeeded;
            BarcodeView barcodeView = BarcodeView.this;
            if (i == i2) {
                C1272n2 n2Var = (C1272n2) message.obj;
                if (!(n2Var == null || (m2Var = barcodeView.f3941a) == null || barcodeView.e == 1)) {
                    m2Var.a(n2Var);
                    if (barcodeView.e == 2) {
                        barcodeView.e = 1;
                        barcodeView.f3941a = null;
                        barcodeView.l();
                    }
                }
                return true;
            } else if (i == R.id.zxing_decode_failed) {
                return true;
            } else {
                if (i != R.id.zxing_possible_result_points) {
                    return false;
                }
                List list = (List) message.obj;
                C1251m2 m2Var2 = barcodeView.f3941a;
                if (!(m2Var2 == null || barcodeView.e == 1)) {
                    m2Var2.b(list);
                }
                return true;
            }
        }
    }

    public BarcodeView(Context context) {
        super(context);
        j();
    }

    public final void d() {
        l();
        super.d();
    }

    public final void e() {
        k();
    }

    public C1191j8 getDecoderFactory() {
        return this.f3939a;
    }

    public final C1172i8 i() {
        C1172i8 i8Var;
        if (this.f3939a == null) {
            this.f3939a = new C1299o8();
        }
        C1212k8 k8Var = new C1212k8();
        HashMap hashMap = new HashMap();
        hashMap.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, k8Var);
        C1299o8 o8Var = (C1299o8) this.f3939a;
        o8Var.getClass();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(hashMap);
        Map<DecodeHintType, ?> map = o8Var.f5620a;
        if (map != null) {
            enumMap.putAll(map);
        }
        Collection<BarcodeFormat> collection = o8Var.f5619a;
        if (collection != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = o8Var.f5618a;
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        int i = o8Var.a;
        if (i == 0) {
            i8Var = new C1172i8(multiFormatReader);
        } else if (i == 1) {
            i8Var = new C1326pg(multiFormatReader);
        } else if (i != 2) {
            i8Var = new C1172i8(multiFormatReader);
        } else {
            i8Var = new C1389sl(multiFormatReader);
        }
        k8Var.a = i8Var;
        return i8Var;
    }

    public final void j() {
        this.f3939a = new C1299o8();
        this.b = new Handler(this.a);
    }

    public final void k() {
        l();
        if (this.e != 1 && this.f3960b) {
            C1236l8 l8Var = new C1236l8(getCameraInstance(), i(), this.b);
            this.f3940a = l8Var;
            l8Var.f5575a = getPreviewFramingRect();
            C1236l8 l8Var2 = this.f3940a;
            l8Var2.getClass();
            r1.U();
            HandlerThread handlerThread = new HandlerThread("l8");
            l8Var2.f5577a = handlerThread;
            handlerThread.start();
            l8Var2.f5576a = new Handler(l8Var2.f5577a.getLooper(), l8Var2.f5580a);
            l8Var2.f5582a = true;
            O3 o3 = l8Var2.a;
            o3.b.post(new Ft(3, o3, l8Var2.f5581a));
        }
    }

    public final void l() {
        C1236l8 l8Var = this.f3940a;
        if (l8Var != null) {
            l8Var.getClass();
            r1.U();
            synchronized (l8Var.f5579a) {
                l8Var.f5582a = false;
                l8Var.f5576a.removeCallbacksAndMessages((Object) null);
                l8Var.f5577a.quit();
            }
            this.f3940a = null;
        }
    }

    public void setDecoderFactory(C1191j8 j8Var) {
        r1.U();
        this.f3939a = j8Var;
        C1236l8 l8Var = this.f3940a;
        if (l8Var != null) {
            l8Var.f5578a = i();
        }
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j();
    }
}
