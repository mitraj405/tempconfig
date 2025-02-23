package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Gk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Gk implements Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MaterialDynamicColors f3499a;

    public /* synthetic */ Gk(MaterialDynamicColors materialDynamicColors, int i) {
        this.a = i;
        this.f3499a = materialDynamicColors;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        MaterialDynamicColors materialDynamicColors = this.f3499a;
        switch (i) {
            case 0:
                return materialDynamicColors.lambda$secondary$69((DynamicScheme) obj);
            case 1:
                return materialDynamicColors.lambda$secondaryFixed$119((DynamicScheme) obj);
            case 2:
                return materialDynamicColors.lambda$onSecondaryFixed$126((DynamicScheme) obj);
            case 3:
                return materialDynamicColors.highestSurface((DynamicScheme) obj);
            case 4:
                return materialDynamicColors.lambda$inversePrimary$66((DynamicScheme) obj);
            case 5:
                return materialDynamicColors.lambda$onError$96((DynamicScheme) obj);
            case 6:
                return materialDynamicColors.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            case 7:
                return materialDynamicColors.lambda$tertiaryContainer$87((DynamicScheme) obj);
            case 8:
                return materialDynamicColors.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            case 9:
                return materialDynamicColors.lambda$tertiaryFixed$133((DynamicScheme) obj);
            case 10:
                return materialDynamicColors.highestSurface((DynamicScheme) obj);
            case 11:
                return materialDynamicColors.lambda$onSecondaryFixedVariant$129((DynamicScheme) obj);
            case 12:
                return materialDynamicColors.highestSurface((DynamicScheme) obj);
            case 13:
                return materialDynamicColors.lambda$onTertiaryFixedVariant$143((DynamicScheme) obj);
            default:
                return materialDynamicColors.lambda$onPrimaryContainer$63((DynamicScheme) obj);
        }
    }
}
