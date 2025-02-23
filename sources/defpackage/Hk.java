package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Hk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Hk implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ Hk(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return Double.valueOf(((DynamicScheme) obj).neutralPalette.getKeyColor().getTone());
            case 1:
                return ((DynamicScheme) obj).neutralPalette;
            case 2:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157((DynamicScheme) obj);
            case 3:
                return ((DynamicScheme) obj).neutralPalette;
            default:
                return Double.valueOf(((DynamicScheme) obj).tertiaryPalette.getKeyColor().getTone());
        }
    }
}
