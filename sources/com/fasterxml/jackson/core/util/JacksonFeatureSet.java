package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JacksonFeature;

public final class JacksonFeatureSet<F extends JacksonFeature> {
    protected int _enabled;

    public JacksonFeatureSet(int i) {
        this._enabled = i;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromDefaults(F[] fArr) {
        if (fArr.length <= 31) {
            int i = 0;
            for (F f : fArr) {
                if (f.enabledByDefault()) {
                    i |= f.getMask();
                }
            }
            return new JacksonFeatureSet<>(i);
        }
        throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{fArr[0].getClass().getName(), Integer.valueOf(fArr.length)}));
    }

    public boolean isEnabled(F f) {
        if ((f.getMask() & this._enabled) != 0) {
            return true;
        }
        return false;
    }

    public JacksonFeatureSet<F> with(F f) {
        int mask = f.getMask() | this._enabled;
        if (mask == this._enabled) {
            return this;
        }
        return new JacksonFeatureSet<>(mask);
    }
}
