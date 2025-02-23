package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/* renamed from: sl  reason: default package and case insensitive filesystem */
/* compiled from: MixedDecoder */
public final class C1389sl extends C1172i8 {
    public boolean a = true;

    public C1389sl(MultiFormatReader multiFormatReader) {
        super(multiFormatReader);
    }

    public final BinaryBitmap a(PlanarYUVLuminanceSource planarYUVLuminanceSource) {
        if (this.a) {
            this.a = false;
            return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource.invert()));
        }
        this.a = true;
        return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource));
    }
}
