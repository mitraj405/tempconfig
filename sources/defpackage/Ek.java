package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Ek  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ek implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ Ek(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return MaterialDynamicColors.lambda$secondary$68((DynamicScheme) obj);
            case 1:
                return MaterialDynamicColors.lambda$secondaryFixed$118((DynamicScheme) obj);
            case 2:
                return Double.valueOf(10.0d);
            case 3:
                return MaterialDynamicColors.lambda$onErrorContainer$101((DynamicScheme) obj);
            case 4:
                return ((DynamicScheme) obj).errorPalette;
            case 5:
                return ((DynamicScheme) obj).secondaryPalette;
            case 6:
                return ((DynamicScheme) obj).primaryPalette;
            case 7:
                return Double.valueOf(((DynamicScheme) obj).primaryPalette.getKeyColor().getTone());
            case 8:
                return ((DynamicScheme) obj).primaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$textPrimaryInverse$153((DynamicScheme) obj);
            case 10:
                return Double.valueOf(0.0d);
            case 11:
                return ((DynamicScheme) obj).neutralPalette;
            case 12:
                return ((DynamicScheme) obj).errorPalette;
            case 13:
                return MaterialDynamicColors.lambda$onSurfaceVariant$36((DynamicScheme) obj);
            case 14:
                return ((DynamicScheme) obj).neutralPalette;
            case 15:
                return ((DynamicScheme) obj).neutralPalette;
            case 16:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$135((DynamicScheme) obj);
            case 17:
                return MaterialDynamicColors.lambda$tertiaryContainer$86((DynamicScheme) obj);
            case 18:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$114((DynamicScheme) obj);
            case 19:
                return MaterialDynamicColors.lambda$tertiaryFixed$132((DynamicScheme) obj);
            case 20:
                return ((DynamicScheme) obj).neutralPalette;
            case 21:
                return ((DynamicScheme) obj).neutralPalette;
            case 22:
                return ((DynamicScheme) obj).neutralPalette;
            case 23:
                return ((DynamicScheme) obj).neutralPalette;
            case 24:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 25:
                return MaterialDynamicColors.lambda$inverseOnSurface$40((DynamicScheme) obj);
            case 26:
                return ((DynamicScheme) obj).secondaryPalette;
            case 27:
                return ((DynamicScheme) obj).errorPalette;
            case 28:
                return ((DynamicScheme) obj).tertiaryPalette;
            default:
                return ((DynamicScheme) obj).primaryPalette;
        }
    }
}
