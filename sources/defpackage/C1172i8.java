package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;

/* renamed from: i8  reason: default package and case insensitive filesystem */
/* compiled from: Decoder */
public class C1172i8 implements ResultPointCallback {
    public final Reader a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f5484a = new ArrayList();

    public C1172i8(MultiFormatReader multiFormatReader) {
        this.a = multiFormatReader;
    }

    public BinaryBitmap a(PlanarYUVLuminanceSource planarYUVLuminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource));
    }

    public final void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f5484a.add(resultPoint);
    }
}
