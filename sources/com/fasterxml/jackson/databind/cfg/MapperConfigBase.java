package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.text.DateFormat;

public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> {
    private static final long AUTO_DETECT_MASK = ((((MapperFeature.AUTO_DETECT_FIELDS.getLongMask() | MapperFeature.AUTO_DETECT_GETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_IS_GETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_SETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_CREATORS.getLongMask());
    private static final long DEFAULT_MAPPER_FEATURES = MapperFeature.collectLongDefaults();
    protected static final ConfigOverride EMPTY_OVERRIDE = ConfigOverride.empty();
    protected final ContextAttributes _attributes;
    protected final ConfigOverrides _configOverrides;
    protected final SimpleMixInResolver _mixIns;
    protected final PropertyName _rootName;
    protected final RootNameLookup _rootNames;
    protected final SubtypeResolver _subtypeResolver;
    protected final Class<?> _view;

    public MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, DEFAULT_MAPPER_FEATURES);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = subtypeResolver;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.getEmpty();
        this._configOverrides = configOverrides;
    }

    public abstract T _withBase(BaseSettings baseSettings);

    public abstract T _withMapperFeatures(long j);

    public final Class<?> findMixInClassFor(Class<?> cls) {
        return this._mixIns.findMixInClassFor(cls);
    }

    public PropertyName findRootName(JavaType javaType) {
        PropertyName propertyName = this._rootName;
        if (propertyName != null) {
            return propertyName;
        }
        return this._rootNames.findRootName(javaType, (MapperConfig<?>) this);
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final ContextAttributes getAttributes() {
        return this._attributes;
    }

    public final ConfigOverride getConfigOverride(Class<?> cls) {
        ConfigOverride findOverride = this._configOverrides.findOverride(cls);
        if (findOverride == null) {
            return EMPTY_OVERRIDE;
        }
        return findOverride;
    }

    public final JsonInclude.Value getDefaultInclusion(Class<?> cls, Class<?> cls2) {
        JsonInclude.Value includeAsProperty = getConfigOverride(cls2).getIncludeAsProperty();
        JsonInclude.Value defaultPropertyInclusion = getDefaultPropertyInclusion(cls);
        if (defaultPropertyInclusion == null) {
            return includeAsProperty;
        }
        return defaultPropertyInclusion.withOverrides(includeAsProperty);
    }

    public Boolean getDefaultMergeable() {
        return this._configOverrides.getDefaultMergeable();
    }

    public final JsonFormat.Value getDefaultPropertyFormat(Class<?> cls) {
        return this._configOverrides.findFormatDefaults(cls);
    }

    public final JsonIgnoreProperties.Value getDefaultPropertyIgnorals(Class<?> cls) {
        JsonIgnoreProperties.Value ignorals;
        ConfigOverride findOverride = this._configOverrides.findOverride(cls);
        if (findOverride == null || (ignorals = findOverride.getIgnorals()) == null) {
            return null;
        }
        return ignorals;
    }

    public final JsonInclude.Value getDefaultPropertyInclusion() {
        return this._configOverrides.getDefaultInclusion();
    }

    public final JsonIncludeProperties.Value getDefaultPropertyInclusions(Class<?> cls, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findPropertyInclusionByName(this, annotatedClass);
    }

    public final JsonSetter.Value getDefaultSetterInfo() {
        return this._configOverrides.getDefaultSetterInfo();
    }

    public final VisibilityChecker<?> getDefaultVisibilityChecker() {
        VisibilityChecker defaultVisibility = this._configOverrides.getDefaultVisibility();
        long j = this._mapperFeatures;
        long j2 = AUTO_DETECT_MASK;
        if ((j & j2) == j2) {
            return defaultVisibility;
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
            defaultVisibility = defaultVisibility.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
            defaultVisibility = defaultVisibility.withGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
            defaultVisibility = defaultVisibility.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_SETTERS)) {
            defaultVisibility = defaultVisibility.withSetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        return !isEnabled(MapperFeature.AUTO_DETECT_CREATORS) ? defaultVisibility.withCreatorVisibility(JsonAutoDetect.Visibility.NONE) : defaultVisibility;
    }

    public final PropertyName getFullRootName() {
        return this._rootName;
    }

    public final SubtypeResolver getSubtypeResolver() {
        return this._subtypeResolver;
    }

    public final T with(MapperFeature... mapperFeatureArr) {
        long j = this._mapperFeatures;
        for (MapperFeature longMask : mapperFeatureArr) {
            j |= longMask.getLongMask();
        }
        if (j == this._mapperFeatures) {
            return this;
        }
        return _withMapperFeatures(j);
    }

    public final T without(MapperFeature... mapperFeatureArr) {
        long j = this._mapperFeatures;
        for (MapperFeature longMask : mapperFeatureArr) {
            j &= ~longMask.getLongMask();
        }
        if (j == this._mapperFeatures) {
            return this;
        }
        return _withMapperFeatures(j);
    }

    public Boolean getDefaultMergeable(Class<?> cls) {
        Boolean mergeable;
        ConfigOverride findOverride = this._configOverrides.findOverride(cls);
        if (findOverride == null || (mergeable = findOverride.getMergeable()) == null) {
            return this._configOverrides.getDefaultMergeable();
        }
        return mergeable;
    }

    public final JsonInclude.Value getDefaultPropertyInclusion(Class<?> cls) {
        JsonInclude.Value include = getConfigOverride(cls).getInclude();
        JsonInclude.Value defaultPropertyInclusion = getDefaultPropertyInclusion();
        if (defaultPropertyInclusion == null) {
            return include;
        }
        return defaultPropertyInclusion.withOverrides(include);
    }

    public PropertyName findRootName(Class<?> cls) {
        PropertyName propertyName = this._rootName;
        if (propertyName != null) {
            return propertyName;
        }
        return this._rootNames.findRootName(cls, (MapperConfig<?>) this);
    }

    public final JsonIgnoreProperties.Value getDefaultPropertyIgnorals(Class<?> cls, AnnotatedClass annotatedClass) {
        JsonIgnoreProperties.Value value;
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            value = null;
        } else {
            value = annotationIntrospector.findPropertyIgnoralByName(this, annotatedClass);
        }
        return JsonIgnoreProperties.Value.merge(value, getDefaultPropertyIgnorals(cls));
    }

    public final T with(PropertyNamingStrategy propertyNamingStrategy) {
        return _withBase(this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    public T with(DateFormat dateFormat) {
        return _withBase(this._base.withDateFormat(dateFormat));
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, BaseSettings baseSettings) {
        super(mapperConfigBase, baseSettings);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
    }

    public final VisibilityChecker<?> getDefaultVisibilityChecker(Class<?> cls, AnnotatedClass annotatedClass) {
        VisibilityChecker visibilityChecker;
        if (ClassUtil.isJDKClass(cls)) {
            visibilityChecker = VisibilityChecker.Std.allPublicInstance();
        } else {
            visibilityChecker = getDefaultVisibilityChecker();
        }
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        if (annotationIntrospector != null) {
            visibilityChecker = annotationIntrospector.findAutoDetectVisibility(annotatedClass, visibilityChecker);
        }
        ConfigOverride findOverride = this._configOverrides.findOverride(cls);
        return findOverride != null ? visibilityChecker.withOverrides(findOverride.getVisibility()) : visibilityChecker;
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, long j) {
        super(mapperConfigBase, j);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
    }
}
