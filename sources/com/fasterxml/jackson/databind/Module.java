package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import java.util.Collections;

public abstract class Module {

    public interface SetupContext {
        void addBeanDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier);

        void addBeanSerializerModifier(BeanSerializerModifier beanSerializerModifier);

        void addKeySerializers(Serializers serializers);

        void addSerializers(Serializers serializers);

        void registerSubtypes(NamedType... namedTypeArr);

        void setMixInAnnotations(Class<?> cls, Class<?> cls2);

        void setNamingStrategy(PropertyNamingStrategy propertyNamingStrategy);
    }

    public Iterable<? extends Module> getDependencies() {
        return Collections.emptyList();
    }

    public abstract String getModuleName();

    public Object getTypeId() {
        return getClass().getName();
    }

    public abstract void setupModule(SetupContext setupContext);

    public abstract Version version();
}
