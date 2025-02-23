package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.google.android.material.color.utilities.TemperatureCache;
import java.util.function.Function;

/* renamed from: Fk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Fk implements Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3498a;

    public /* synthetic */ Fk(Object obj, int i) {
        this.a = i;
        this.f3498a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.f3498a;
        switch (i) {
            case 0:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 1:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 2:
                return ((MaterialDynamicColors) obj2).lambda$onSecondaryFixed$125((DynamicScheme) obj);
            case 3:
                return ((MaterialDynamicColors) obj2).lambda$onErrorContainer$102((DynamicScheme) obj);
            case 4:
                return ((MaterialDynamicColors) obj2).lambda$primaryFixed$105((DynamicScheme) obj);
            case 5:
                return ((MaterialDynamicColors) obj2).lambda$secondaryFixedDim$122((DynamicScheme) obj);
            case 6:
                return ((MaterialDynamicColors) obj2).lambda$primaryFixedDim$108((DynamicScheme) obj);
            case 7:
                return ((MaterialDynamicColors) obj2).lambda$primary$54((DynamicScheme) obj);
            case 8:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 9:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 10:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 11:
                return ((MaterialDynamicColors) obj2).lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
            case 12:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 13:
                return ((MaterialDynamicColors) obj2).lambda$onTertiaryContainer$90((DynamicScheme) obj);
            case 14:
                return ((MaterialDynamicColors) obj2).lambda$tertiary$81((DynamicScheme) obj);
            case 15:
                return ((MaterialDynamicColors) obj2).lambda$secondaryContainer$75((DynamicScheme) obj);
            case 16:
                return ((MaterialDynamicColors) obj2).lambda$inverseOnSurface$41((DynamicScheme) obj);
            case 17:
                return ((MaterialDynamicColors) obj2).lambda$onPrimaryContainer$62((DynamicScheme) obj);
            case 18:
                return ((MaterialDynamicColors) obj2).lambda$onBackground$14((DynamicScheme) obj);
            default:
                return ((TemperatureCache) obj2).lambda$getHctsByTemp$0((Hct) obj);
        }
    }
}
