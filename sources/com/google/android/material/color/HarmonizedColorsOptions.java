package com.google.android.material.color;

import com.google.android.material.R;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class HarmonizedColorsOptions {
    private final int colorAttributeToHarmonizeWith;
    private final HarmonizedColorAttributes colorAttributes;
    private final int[] colorResourceIds;

    public static class Builder {
        /* access modifiers changed from: private */
        public int colorAttributeToHarmonizeWith = R.attr.colorPrimary;
        /* access modifiers changed from: private */
        public HarmonizedColorAttributes colorAttributes;
        /* access modifiers changed from: private */
        public int[] colorResourceIds = new int[0];

        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this);
        }

        @CanIgnoreReturnValue
        public Builder setColorAttributeToHarmonizeWith(int i) {
            this.colorAttributeToHarmonizeWith = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setColorAttributes(HarmonizedColorAttributes harmonizedColorAttributes) {
            this.colorAttributes = harmonizedColorAttributes;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setColorResourceIds(int[] iArr) {
            this.colorResourceIds = iArr;
            return this;
        }
    }

    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    public int getThemeOverlayResourceId(int i) {
        HarmonizedColorAttributes harmonizedColorAttributes = this.colorAttributes;
        if (harmonizedColorAttributes == null || harmonizedColorAttributes.getThemeOverlay() == 0) {
            return i;
        }
        return this.colorAttributes.getThemeOverlay();
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.colorResourceIds = builder.colorResourceIds;
        this.colorAttributes = builder.colorAttributes;
        this.colorAttributeToHarmonizeWith = builder.colorAttributeToHarmonizeWith;
    }
}
