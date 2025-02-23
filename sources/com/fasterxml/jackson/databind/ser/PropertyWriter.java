package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;

public abstract class PropertyWriter extends ConcreteBeanPropertyBase {
    private static final long serialVersionUID = 1;

    public PropertyWriter(PropertyMetadata propertyMetadata) {
        super(propertyMetadata);
    }

    public PropertyWriter(BeanPropertyDefinition beanPropertyDefinition) {
        super(beanPropertyDefinition.getMetadata());
    }

    public PropertyWriter(PropertyWriter propertyWriter) {
        super((ConcreteBeanPropertyBase) propertyWriter);
    }
}
