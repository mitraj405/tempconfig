package com.google.android.material.color.utilities;

import java.util.function.Function;

public final class MaterialDynamicColors {
    public static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        double d4;
        Hct from = Hct.from(d, d2, d3);
        if (from.getChroma() >= d2) {
            return d3;
        }
        Hct hct = from;
        double chroma = from.getChroma();
        double d5 = d3;
        while (hct.getChroma() < d2) {
            if (z) {
                d4 = -1.0d;
            } else {
                d4 = 1.0d;
            }
            double d6 = d5 + d4;
            Hct from2 = Hct.from(d, d2, d6);
            if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d2) < 0.4d) {
                return d6;
            }
            if (Math.abs(from2.getChroma() - d2) < Math.abs(hct.getChroma() - d2)) {
                hct = from2;
            }
            chroma = Math.max(chroma, from2.getChroma());
            d5 = d6;
        }
        return d5;
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        if (variant == Variant.FIDELITY || variant == Variant.CONTENT) {
            return true;
        }
        return false;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        if (dynamicScheme.variant == Variant.MONOCHROME) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$background$11(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlActivated$146(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$150(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$151(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 0.2d;
        } else {
            d = 0.12d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlNormal$148(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$error$92(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$error$93(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$errorContainer$98(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$errorContainer$99(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseOnSurface$40(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 95.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inverseOnSurface$41(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inversePrimary$65(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 40.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inversePrimary$66(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseSurface$38(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onBackground$13(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onBackground$14(DynamicScheme dynamicScheme) {
        return background();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onError$95(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onError$96(DynamicScheme dynamicScheme) {
        return error();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onErrorContainer$101(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onErrorContainer$102(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimary$56(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimary$57(DynamicScheme dynamicScheme) {
        return primary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onPrimaryContainer$62(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 0.0d;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryContainer$63(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixed$110(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 100.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$111(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$112(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixedVariant$114(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 90.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$115(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$116(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondary$71(DynamicScheme dynamicScheme) {
        double d = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 10.0d;
            }
            return Double.valueOf(d);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondary$72(DynamicScheme dynamicScheme) {
        return secondary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onSecondaryContainer$77(DynamicScheme dynamicScheme) {
        double d;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryContainer$78(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$125(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$126(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixedVariant$128(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 25.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$129(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$130(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurface$32(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurfaceVariant$36(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiary$83(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiary$84(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onTertiaryContainer$89(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 0.0d;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        } else if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        } else {
            if (dynamicScheme.isDark) {
                d = 90.0d;
            } else {
                d = 10.0d;
            }
            return Double.valueOf(d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryContainer$90(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixed$138(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 100.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$139(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$140(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixedVariant$142(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 90.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$143(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$144(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outline$43(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 60.0d;
        } else {
            d = 50.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outlineVariant$45(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primary$53(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 100.0d;
            } else {
                d2 = 0.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primary$54(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryContainer$59(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 85.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryContainer$60(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixed$104(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 40.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixed$105(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixedDim$107(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixedDim$108(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondary$68(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondary$69(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryContainer$74(DynamicScheme dynamicScheme) {
        double d;
        double d2 = 30.0d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d2 = 85.0d;
            }
            return Double.valueOf(d2);
        } else if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d);
        } else {
            return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d, !dynamicScheme.isDark)), dynamicScheme));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryContainer$75(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixed$118(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 80.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixed$119(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixedDim$121(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 70.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixedDim$122(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surface$16(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceBright$20(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 24.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainer$26(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 12.0d;
        } else {
            d = 94.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHigh$28(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 17.0d;
        } else {
            d = 92.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHighest$30(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 22.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLow$24(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 96.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLowest$22(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 4.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceDim$18(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 87.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceTint$51(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceVariant$34(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiary$80(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 90.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiary$81(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryContainer$86(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 60.0d;
            } else {
                d2 = 49.0d;
            }
            return Double.valueOf(d2);
        } else if (!isFidelity(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 30.0d;
            } else {
                d = 90.0d;
            }
            return Double.valueOf(d);
        } else {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryContainer$87(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixed$132(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 40.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixed$133(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixedDim$135(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixedDim$136(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textHintInverse$161(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverse$153(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverseDisableOnly$157(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverse$155(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverseDisabled$159(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    public static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct inViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (!DynamicColor.tonePrefersLightForeground(hct.getTone()) || DynamicColor.toneAllowsLightForeground(inViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(inViewingConditions.getTone());
        }
        return DynamicColor.enableLightForeground(hct.getTone());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return ViewingConditions.defaultWithBackgroundLstar(d);
    }

    public DynamicColor background() {
        return new DynamicColor("background", new Bk(24), new uo(28), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new Ek(8), new Ak(6));
    }

    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new Ek(15), new Ak(16), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null, new Bk(19));
    }

    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new Bk(21), new uo(25));
    }

    public DynamicColor error() {
        return new DynamicColor("error", new Ek(4), new Ak(2), true, new Gk(this, 3), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Ck(this, 1));
    }

    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new Ek(27), new Ak(23), true, new Gk(this, 12), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Ck(this, 8));
    }

    public DynamicColor highestSurface(DynamicScheme dynamicScheme) {
        if (dynamicScheme.isDark) {
            return surfaceBright();
        }
        return surfaceDim();
    }

    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new Hk(1), new Ek(25), false, new Fk(this, 16), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new Ek(6), new Ak(4), false, new Gk(this, 4), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new Bk(4), new uo(7), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new Bk(26), new Hk(0));
    }

    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new Ak(8), new Bk(11));
    }

    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new Hk(3), new Ik(0), false, new Fk(this, 18), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onError() {
        return new DynamicColor("on_error", new Ek(12), new Ak(12), false, new Gk(this, 5), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new uo(4), new Ek(3), false, new Fk(this, 3), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new Bk(9), new uo(12), false, new Dk(this, 5), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new Ek(29), new Fk(this, 17), false, new Gk(this, 14), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new Ak(9), new Bk(12), false, new Ck(this, 3), new Dk(this, 6), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new uo(21), new Ek(18), false, new Fk(this, 11), new Gk(this, 8), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new Bk(15), new uo(17), false, new Dk(this, 7), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new Bk(29), new Ck(this, 10), false, new Dk(this, 12), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new uo(3), new Ek(2), false, new Fk(this, 2), new Gk(this, 2), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new Ek(26), new Ak(22), false, new Gk(this, 11), new Ck(this, 7), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new Ak(5), new Bk(6), false, new Ck(this, 2), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new uo(16), new Ek(13), false, new Fk(this, 8), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new Ak(14), new Bk(17), false, new Ck(this, 6), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new uo(23), new Dk(this, 9), false, new Fk(this, 13), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new Ak(13), new Bk(16), false, new Ck(this, 5), new Dk(this, 8), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new Ek(28), new Ak(24), false, new Gk(this, 13), new Ck(this, 9), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor outline() {
        return new DynamicColor("outline", new Ek(24), new Ak(21), false, new Gk(this, 10), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new Ak(10), new Bk(13), false, new Ck(this, 4), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor primary() {
        return new DynamicColor("primary", new Bk(8), new uo(11), true, new Dk(this, 4), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Fk(this, 7));
    }

    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new Ak(0), new Bk(0), true, new Ck(this, 0), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Dk(this, 0));
    }

    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new Bk(2), new uo(5), true, new Dk(this, 1), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Fk(this, 4));
    }

    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new Bk(7), new uo(10), true, new Dk(this, 3), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Fk(this, 6));
    }

    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new uo(9), new Ek(7));
    }

    public DynamicColor scrim() {
        return new DynamicColor("scrim", new uo(14), new Ek(10), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor secondary() {
        return new DynamicColor("secondary", new uo(1), new Ek(0), true, new Fk(this, 0), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Gk(this, 0));
    }

    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new Bk(22), new uo(26), true, new Dk(this, 11), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Fk(this, 15));
    }

    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new uo(2), new Ek(1), true, new Fk(this, 1), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Gk(this, 1));
    }

    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new Bk(3), new uo(6), true, new Dk(this, 2), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Fk(this, 5));
    }

    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new Ek(5), new Ak(3));
    }

    public DynamicColor shadow() {
        return new DynamicColor("shadow", new Ek(14), new Ak(15), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surface() {
        return new DynamicColor("surface", new Bk(25), new uo(29), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new Bk(23), new uo(27), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new Bk(14), new uo(15), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new Ek(21), new Ak(18), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new Ek(22), new Ak(19), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new Ek(11), new Ak(11), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new Ak(7), new Bk(10), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new Ek(23), new Ak(20), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new Bk(5), new uo(8), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new Ik(1), new Ak(25), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new Bk(20), new uo(24), true, new Dk(this, 10), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Fk(this, 14));
    }

    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new uo(20), new Ek(17), true, new Fk(this, 10), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Gk(this, 7));
    }

    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new uo(22), new Ek(19), true, new Fk(this, 12), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Gk(this, 9));
    }

    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new uo(19), new Ek(16), true, new Fk(this, 9), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Gk(this, 6));
    }

    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new Bk(28), new Hk(4));
    }

    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new Ek(20), new Ak(17));
    }

    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new uo(13), new Ek(9));
    }

    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new Bk(27), new Hk(2));
    }

    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new Ak(1), new Bk(1));
    }

    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new Bk(18), new uo(18));
    }
}
