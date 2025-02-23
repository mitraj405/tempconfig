package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/* renamed from: pg  reason: default package and case insensitive filesystem */
/* compiled from: InvertedDecoder */
public final class C1326pg extends C1172i8 {
    public C1326pg(MultiFormatReader multiFormatReader) {
        super(multiFormatReader);
    }

    public final BinaryBitmap a(PlanarYUVLuminanceSource planarYUVLuminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource.invert()));
    }
}
