package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;

public final class EnumValues implements Serializable {
    private static final long serialVersionUID = 1;
    private final Class<Enum<?>> _enumClass;
    private final SerializableString[] _textual;
    private final Enum<?>[] _values;

    private EnumValues(Class<Enum<?>> cls, SerializableString[] serializableStringArr) {
        this._enumClass = cls;
        this._values = (Enum[]) cls.getEnumConstants();
        this._textual = serializableStringArr;
    }

    public static EnumValues construct(Class<Enum<?>> cls, SerializableString[] serializableStringArr) {
        return new EnumValues(cls, serializableStringArr);
    }

    public static EnumValues constructFromName(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Class<? extends Enum<?>> findEnumType = ClassUtil.findEnumType((Class<?>) cls);
        Enum[] enumArr = (Enum[]) findEnumType.getEnumConstants();
        if (enumArr != null) {
            String[] findEnumValues = mapperConfig.getAnnotationIntrospector().findEnumValues(findEnumType, enumArr, new String[enumArr.length]);
            SerializableString[] serializableStringArr = new SerializableString[enumArr.length];
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                Enum enumR = enumArr[i];
                String str = findEnumValues[i];
                if (str == null) {
                    str = enumR.name();
                }
                serializableStringArr[enumR.ordinal()] = mapperConfig.compileString(str);
            }
            return construct(cls, serializableStringArr);
        }
        throw new IllegalArgumentException("Cannot determine enum constants for Class ".concat(cls.getName()));
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public SerializableString serializedValueFor(Enum<?> enumR) {
        return this._textual[enumR.ordinal()];
    }
}
