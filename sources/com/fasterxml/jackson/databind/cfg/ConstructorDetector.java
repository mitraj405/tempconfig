package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

public final class ConstructorDetector implements Serializable {
    public static final ConstructorDetector DEFAULT = new ConstructorDetector(SingleArgConstructor.HEURISTIC);
    public static final ConstructorDetector EXPLICIT_ONLY = new ConstructorDetector(SingleArgConstructor.REQUIRE_MODE);
    public static final ConstructorDetector USE_DELEGATING = new ConstructorDetector(SingleArgConstructor.DELEGATING);
    public static final ConstructorDetector USE_PROPERTIES_BASED = new ConstructorDetector(SingleArgConstructor.PROPERTIES);
    private static final long serialVersionUID = 1;
    protected final boolean _allowJDKTypeCtors;
    protected final boolean _requireCtorAnnotation;
    protected final SingleArgConstructor _singleArgMode;

    public enum SingleArgConstructor {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    public ConstructorDetector(SingleArgConstructor singleArgConstructor, boolean z, boolean z2) {
        this._singleArgMode = singleArgConstructor;
        this._requireCtorAnnotation = z;
        this._allowJDKTypeCtors = z2;
    }

    public boolean requireCtorAnnotation() {
        return this._requireCtorAnnotation;
    }

    public boolean shouldIntrospectorImplicitConstructors(Class<?> cls) {
        if (this._requireCtorAnnotation) {
            return false;
        }
        if (this._allowJDKTypeCtors || !ClassUtil.isJDKClass(cls) || Throwable.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public boolean singleArgCreatorDefaultsToDelegating() {
        if (this._singleArgMode == SingleArgConstructor.DELEGATING) {
            return true;
        }
        return false;
    }

    public boolean singleArgCreatorDefaultsToProperties() {
        if (this._singleArgMode == SingleArgConstructor.PROPERTIES) {
            return true;
        }
        return false;
    }

    public SingleArgConstructor singleArgMode() {
        return this._singleArgMode;
    }

    public ConstructorDetector(SingleArgConstructor singleArgConstructor) {
        this(singleArgConstructor, false, false);
    }
}
