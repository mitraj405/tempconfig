package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Bk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Bk implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ Bk(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return MaterialDynamicColors.lambda$primaryContainer$59((DynamicScheme) obj);
            case 1:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155((DynamicScheme) obj);
            case 2:
                return ((DynamicScheme) obj).primaryPalette;
            case 3:
                return ((DynamicScheme) obj).secondaryPalette;
            case 4:
                return ((DynamicScheme) obj).neutralPalette;
            case 5:
                return ((DynamicScheme) obj).primaryPalette;
            case 6:
                return MaterialDynamicColors.lambda$onSurface$32((DynamicScheme) obj);
            case 7:
                return ((DynamicScheme) obj).primaryPalette;
            case 8:
                return ((DynamicScheme) obj).primaryPalette;
            case 9:
                return ((DynamicScheme) obj).primaryPalette;
            case 10:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$22((DynamicScheme) obj);
            case 11:
                return Double.valueOf(((DynamicScheme) obj).neutralVariantPalette.getKeyColor().getTone());
            case 12:
                return MaterialDynamicColors.lambda$onPrimaryFixed$110((DynamicScheme) obj);
            case 13:
                return MaterialDynamicColors.lambda$outlineVariant$45((DynamicScheme) obj);
            case 14:
                return ((DynamicScheme) obj).neutralPalette;
            case 15:
                return ((DynamicScheme) obj).secondaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$onTertiaryFixed$138((DynamicScheme) obj);
            case 17:
                return MaterialDynamicColors.lambda$onTertiary$83((DynamicScheme) obj);
            case 18:
                return ((DynamicScheme) obj).neutralPalette;
            case 19:
                return MaterialDynamicColors.lambda$controlHighlight$151((DynamicScheme) obj);
            case 20:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 21:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 22:
                return ((DynamicScheme) obj).secondaryPalette;
            case 23:
                return ((DynamicScheme) obj).neutralPalette;
            case 24:
                return ((DynamicScheme) obj).neutralPalette;
            case 25:
                return ((DynamicScheme) obj).neutralPalette;
            case 26:
                return ((DynamicScheme) obj).neutralPalette;
            case 27:
                return ((DynamicScheme) obj).neutralPalette;
            case 28:
                return ((DynamicScheme) obj).tertiaryPalette;
            default:
                return ((DynamicScheme) obj).secondaryPalette;
        }
    }
}
