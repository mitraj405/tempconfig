package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.Serializable;
import java.util.Map;

public class ConfigOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    protected JsonInclude.Value _defaultInclusion;
    protected Boolean _defaultLeniency;
    protected Boolean _defaultMergeable;
    protected JsonSetter.Value _defaultSetterInfo;
    protected Map<Class<?>, Object> _overrides;
    protected VisibilityChecker<?> _visibilityChecker;

    public ConfigOverrides() {
        this((Map<Class<?>, Object>) null, JsonInclude.Value.empty(), JsonSetter.Value.empty(), VisibilityChecker.Std.defaultInstance(), (Boolean) null, (Boolean) null);
    }

    public JsonFormat.Value findFormatDefaults(Class<?> cls) {
        ConfigOverride configOverride;
        JsonFormat.Value format;
        Map<Class<?>, Object> map = this._overrides;
        if (map == null || (configOverride = (ConfigOverride) map.get(cls)) == null || (format = configOverride.getFormat()) == null) {
            Boolean bool = this._defaultLeniency;
            if (bool == null) {
                return JsonFormat.Value.empty();
            }
            return JsonFormat.Value.forLeniency(bool.booleanValue());
        } else if (!format.hasLenient()) {
            return format.withLenient(this._defaultLeniency);
        } else {
            return format;
        }
    }

    public ConfigOverride findOverride(Class<?> cls) {
        Map<Class<?>, Object> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (ConfigOverride) map.get(cls);
    }

    public JsonInclude.Value getDefaultInclusion() {
        return this._defaultInclusion;
    }

    public Boolean getDefaultMergeable() {
        return this._defaultMergeable;
    }

    public JsonSetter.Value getDefaultSetterInfo() {
        return this._defaultSetterInfo;
    }

    public VisibilityChecker<?> getDefaultVisibility() {
        return this._visibilityChecker;
    }

    public ConfigOverrides(Map<Class<?>, Object> map, JsonInclude.Value value, JsonSetter.Value value2, VisibilityChecker<?> visibilityChecker, Boolean bool, Boolean bool2) {
        this._overrides = map;
        this._defaultInclusion = value;
        this._defaultSetterInfo = value2;
        this._visibilityChecker = visibilityChecker;
        this._defaultMergeable = bool;
        this._defaultLeniency = bool2;
    }
}
