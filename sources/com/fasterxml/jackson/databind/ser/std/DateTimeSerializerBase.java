package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    protected final DateFormat _customFormat;
    protected final AtomicReference<DateFormat> _reusedCustomFormat;
    protected final Boolean _useTimestamp;

    public DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        AtomicReference<DateFormat> atomicReference;
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        if (dateFormat == null) {
            atomicReference = null;
        } else {
            atomicReference = new AtomicReference<>();
        }
        this._reusedCustomFormat = atomicReference;
    }

    public boolean _asTimestamp(SerializerProvider serializerProvider) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (serializerProvider != null) {
            return serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for ".concat(handledType().getName()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024 A[LOOP:0: B:8:0x0024->B:11:0x002f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _serializeAsString(java.util.Date r2, com.fasterxml.jackson.core.JsonGenerator r3, com.fasterxml.jackson.databind.SerializerProvider r4) throws java.io.IOException {
        /*
            r1 = this;
            java.text.DateFormat r0 = r1._customFormat
            if (r0 != 0) goto L_0x0008
            r4.defaultSerializeDateValue(r2, r3)
            return
        L_0x0008:
            java.util.concurrent.atomic.AtomicReference<java.text.DateFormat> r4 = r1._reusedCustomFormat
            r0 = 0
            java.lang.Object r4 = r4.getAndSet(r0)
            java.text.DateFormat r4 = (java.text.DateFormat) r4
            if (r4 != 0) goto L_0x001b
            java.text.DateFormat r4 = r1._customFormat
            java.lang.Object r4 = r4.clone()
            java.text.DateFormat r4 = (java.text.DateFormat) r4
        L_0x001b:
            java.lang.String r2 = r4.format(r2)
            r3.writeString((java.lang.String) r2)
            java.util.concurrent.atomic.AtomicReference<java.text.DateFormat> r2 = r1._reusedCustomFormat
        L_0x0024:
            boolean r3 = r2.compareAndSet(r0, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0031
        L_0x002b:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x0024
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase._serializeAsString(java.util.Date, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        boolean z;
        SimpleDateFormat simpleDateFormat;
        Locale locale;
        TimeZone timeZone;
        JsonFormat.Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
        if (findFormatOverrides == null) {
            return this;
        }
        JsonFormat.Shape shape = findFormatOverrides.getShape();
        if (shape.isNumeric()) {
            return withFormat(Boolean.TRUE, (DateFormat) null);
        }
        if (findFormatOverrides.hasPattern()) {
            if (findFormatOverrides.hasLocale()) {
                locale = findFormatOverrides.getLocale();
            } else {
                locale = serializerProvider.getLocale();
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(findFormatOverrides.getPattern(), locale);
            if (findFormatOverrides.hasTimeZone()) {
                timeZone = findFormatOverrides.getTimeZone();
            } else {
                timeZone = serializerProvider.getTimeZone();
            }
            simpleDateFormat2.setTimeZone(timeZone);
            return withFormat(Boolean.FALSE, simpleDateFormat2);
        }
        boolean hasLocale = findFormatOverrides.hasLocale();
        boolean hasTimeZone = findFormatOverrides.hasTimeZone();
        boolean z2 = true;
        if (shape == JsonFormat.Shape.STRING) {
            z = true;
        } else {
            z = false;
        }
        if (!hasLocale && !hasTimeZone && !z) {
            return this;
        }
        DateFormat dateFormat = serializerProvider.getConfig().getDateFormat();
        if (dateFormat instanceof StdDateFormat) {
            StdDateFormat stdDateFormat = (StdDateFormat) dateFormat;
            if (findFormatOverrides.hasLocale()) {
                stdDateFormat = stdDateFormat.withLocale(findFormatOverrides.getLocale());
            }
            if (findFormatOverrides.hasTimeZone()) {
                stdDateFormat = stdDateFormat.withTimeZone(findFormatOverrides.getTimeZone());
            }
            return withFormat(Boolean.FALSE, stdDateFormat);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            serializerProvider.reportBadDefinition((Class<?>) handledType(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[]{dateFormat.getClass().getName()}));
        }
        SimpleDateFormat simpleDateFormat3 = (SimpleDateFormat) dateFormat;
        if (hasLocale) {
            simpleDateFormat = new SimpleDateFormat(simpleDateFormat3.toPattern(), findFormatOverrides.getLocale());
        } else {
            simpleDateFormat = (SimpleDateFormat) simpleDateFormat3.clone();
        }
        TimeZone timeZone2 = findFormatOverrides.getTimeZone();
        if (timeZone2 == null || timeZone2.equals(simpleDateFormat.getTimeZone())) {
            z2 = false;
        }
        if (z2) {
            simpleDateFormat.setTimeZone(timeZone2);
        }
        return withFormat(Boolean.FALSE, simpleDateFormat);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        return false;
    }

    public abstract DateTimeSerializerBase<T> withFormat(Boolean bool, DateFormat dateFormat);
}
