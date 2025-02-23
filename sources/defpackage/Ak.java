package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Ak  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ak implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ Ak(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ((DynamicScheme) obj).primaryPalette;
            case 1:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 2:
                return MaterialDynamicColors.lambda$error$92((DynamicScheme) obj);
            case 3:
                return Double.valueOf(((DynamicScheme) obj).secondaryPalette.getKeyColor().getTone());
            case 4:
                return MaterialDynamicColors.lambda$inversePrimary$65((DynamicScheme) obj);
            case 5:
                return ((DynamicScheme) obj).neutralPalette;
            case 6:
                return MaterialDynamicColors.lambda$controlActivated$146((DynamicScheme) obj);
            case 7:
                return ((DynamicScheme) obj).neutralPalette;
            case 8:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 9:
                return ((DynamicScheme) obj).primaryPalette;
            case 10:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 11:
                return MaterialDynamicColors.lambda$surfaceContainerLow$24((DynamicScheme) obj);
            case 12:
                return MaterialDynamicColors.lambda$onError$95((DynamicScheme) obj);
            case 13:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 14:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 15:
                return Double.valueOf(0.0d);
            case 16:
                return MaterialDynamicColors.lambda$controlHighlight$150((DynamicScheme) obj);
            case 17:
                return MaterialDynamicColors.lambda$textHintInverse$161((DynamicScheme) obj);
            case 18:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28((DynamicScheme) obj);
            case 19:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
            case 20:
                return MaterialDynamicColors.lambda$surfaceDim$18((DynamicScheme) obj);
            case 21:
                return MaterialDynamicColors.lambda$outline$43((DynamicScheme) obj);
            case 22:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$128((DynamicScheme) obj);
            case 23:
                return MaterialDynamicColors.lambda$errorContainer$98((DynamicScheme) obj);
            case 24:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$142((DynamicScheme) obj);
            default:
                return MaterialDynamicColors.lambda$surfaceVariant$34((DynamicScheme) obj);
        }
    }
}
