package defpackage;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: uo  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class uo implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ uo(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ((AnnotatedMethod) obj).getFullName();
            case 1:
                return ((DynamicScheme) obj).secondaryPalette;
            case 2:
                return ((DynamicScheme) obj).secondaryPalette;
            case 3:
                return ((DynamicScheme) obj).secondaryPalette;
            case 4:
                return ((DynamicScheme) obj).errorPalette;
            case 5:
                return MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
            case 6:
                return MaterialDynamicColors.lambda$secondaryFixedDim$121((DynamicScheme) obj);
            case 7:
                return MaterialDynamicColors.lambda$inverseSurface$38((DynamicScheme) obj);
            case 8:
                return MaterialDynamicColors.lambda$surfaceTint$51((DynamicScheme) obj);
            case 9:
                return ((DynamicScheme) obj).primaryPalette;
            case 10:
                return MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
            case 11:
                return MaterialDynamicColors.lambda$primary$53((DynamicScheme) obj);
            case 12:
                return MaterialDynamicColors.lambda$onPrimary$56((DynamicScheme) obj);
            case 13:
                return ((DynamicScheme) obj).neutralPalette;
            case 14:
                return ((DynamicScheme) obj).neutralPalette;
            case 15:
                return MaterialDynamicColors.lambda$surfaceContainer$26((DynamicScheme) obj);
            case 16:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 17:
                return MaterialDynamicColors.lambda$onSecondary$71((DynamicScheme) obj);
            case 18:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159((DynamicScheme) obj);
            case 19:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 20:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 21:
                return ((DynamicScheme) obj).primaryPalette;
            case 22:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 23:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 24:
                return MaterialDynamicColors.lambda$tertiary$80((DynamicScheme) obj);
            case 25:
                return MaterialDynamicColors.lambda$controlNormal$148((DynamicScheme) obj);
            case 26:
                return MaterialDynamicColors.lambda$secondaryContainer$74((DynamicScheme) obj);
            case 27:
                return MaterialDynamicColors.lambda$surfaceBright$20((DynamicScheme) obj);
            case 28:
                return MaterialDynamicColors.lambda$background$11((DynamicScheme) obj);
            default:
                return MaterialDynamicColors.lambda$surface$16((DynamicScheme) obj);
        }
    }
}
