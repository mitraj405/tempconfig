package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: o8  reason: default package and case insensitive filesystem */
/* compiled from: DefaultDecoderFactory */
public final class C1299o8 implements C1191j8 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5618a;

    /* renamed from: a  reason: collision with other field name */
    public final Collection<BarcodeFormat> f5619a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<DecodeHintType, ?> f5620a;

    public C1299o8() {
    }

    public C1299o8(Set set, Map map, String str, int i) {
        this.f5619a = set;
        this.f5620a = map;
        this.f5618a = str;
        this.a = i;
    }
}
