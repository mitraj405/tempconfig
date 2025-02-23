package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JacksonStdImpl
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ContextualDeserializer, ResolvableDeserializer {
    private static final long serialVersionUID = 1;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected Set<String> _includableProperties;
    protected IgnorePropertiesUtil.Checker _inclusionChecker;
    protected final KeyDeserializer _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public static class MapReferring extends ReadableObjectId.Referring {
        private final MapReferringAccumulator _parent;
        public final Object key;
        public final Map<Object, Object> next = new LinkedHashMap();

        public MapReferring(MapReferringAccumulator mapReferringAccumulator, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this._parent = mapReferringAccumulator;
            this.key = obj;
        }

        public void handleResolvedForwardReference(Object obj, Object obj2) throws IOException {
            this._parent.resolveForwardReference(obj, obj2);
        }
    }

    public static final class MapReferringAccumulator {
        private List<MapReferring> _accumulator = new ArrayList();
        private Map<Object, Object> _result;
        private final Class<?> _valueType;

        public MapReferringAccumulator(Class<?> cls, Map<Object, Object> map) {
            this._valueType = cls;
            this._result = map;
        }

        public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference unresolvedForwardReference, Object obj) {
            MapReferring mapReferring = new MapReferring(this, unresolvedForwardReference, this._valueType, obj);
            this._accumulator.add(mapReferring);
            return mapReferring;
        }

        public void put(Object obj, Object obj2) {
            if (this._accumulator.isEmpty()) {
                this._result.put(obj, obj2);
                return;
            }
            List<MapReferring> list = this._accumulator;
            list.get(list.size() - 1).next.put(obj, obj2);
        }

        public void resolveForwardReference(Object obj, Object obj2) throws IOException {
            Iterator<MapReferring> it = this._accumulator.iterator();
            Map<Object, Object> map = this._result;
            while (it.hasNext()) {
                MapReferring next = it.next();
                if (next.hasId(obj)) {
                    it.remove();
                    map.put(next.key, obj2);
                    map.putAll(next.next);
                    return;
                }
                map = next.next;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    public MapDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(javaType, (NullValueProvider) null, (Boolean) null);
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(javaType, keyDeserializer);
        this._inclusionChecker = null;
    }

    private void handleUnresolvedReference(DeserializationContext deserializationContext, MapReferringAccumulator mapReferringAccumulator, Object obj, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        if (mapReferringAccumulator == null) {
            deserializationContext.reportInputMismatch((JsonDeserializer<?>) this, "Unresolved forward reference but no identity info: " + unresolvedForwardReference, new Object[0]);
        }
        unresolvedForwardReference.getRoid().appendReferring(mapReferringAccumulator.handleUnresolvedReference(unresolvedForwardReference, obj));
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String str;
        Object obj;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, (ObjectIdReader) null);
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else if (jsonParser.hasToken(JsonToken.FIELD_NAME)) {
            str = jsonParser.currentName();
        } else {
            str = null;
        }
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(str)) {
                SettableBeanProperty findCreatorProperty = propertyBasedCreator.findCreatorProperty(str);
                if (findCreatorProperty == null) {
                    Object deserializeKey = this._keyDeserializer.deserializeKey(str, deserializationContext);
                    try {
                        if (nextToken == JsonToken.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                obj = this._nullProvider.getNullValue(deserializationContext);
                            }
                        } else if (typeDeserializer == null) {
                            obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                        } else {
                            obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        }
                        startBuilding.bufferMapProperty(deserializeKey, obj);
                    } catch (Exception e) {
                        wrapAndThrow(deserializationContext, e, this._containerType.getRawClass(), str);
                        return null;
                    }
                } else if (startBuilding.assignParameter(findCreatorProperty, findCreatorProperty.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.nextToken();
                    try {
                        Map<Object, Object> map = (Map) propertyBasedCreator.build(deserializationContext, startBuilding);
                        _readAndBind(jsonParser, deserializationContext, map);
                        return map;
                    } catch (Exception e2) {
                        return (Map) wrapAndThrow(deserializationContext, e2, this._containerType.getRawClass(), str);
                    }
                }
            } else {
                jsonParser.skipChildren();
            }
            str = jsonParser.nextFieldName();
        }
        try {
            return (Map) propertyBasedCreator.build(deserializationContext, startBuilding);
        } catch (Exception e3) {
            wrapAndThrow(deserializationContext, e3, this._containerType.getRawClass(), str);
            return null;
        }
    }

    public final boolean _isStdKeyDeser(JavaType javaType, KeyDeserializer keyDeserializer) {
        JavaType keyType;
        if (keyDeserializer == null || (keyType = javaType.getKeyType()) == null) {
            return true;
        }
        Class<?> rawClass = keyType.getRawClass();
        if ((rawClass == String.class || rawClass == Object.class) && isDefaultKeyDeserializer(keyDeserializer)) {
            return true;
        }
        return false;
    }

    public final void _readAndBind(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        boolean z;
        MapReferringAccumulator mapReferringAccumulator;
        String str;
        Object obj;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonDeserializer.getObjectIdReader() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            mapReferringAccumulator = new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), map);
        } else {
            mapReferringAccumulator = null;
        }
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.currentToken();
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (currentToken != jsonToken) {
                if (currentToken != JsonToken.END_OBJECT) {
                    deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                } else {
                    return;
                }
            }
            str = jsonParser.currentName();
        }
        while (str != null) {
            Object deserializeKey = keyDeserializer.deserializeKey(str, deserializationContext);
            JsonToken nextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(str)) {
                try {
                    if (nextToken == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            obj = this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else if (typeDeserializer == null) {
                        obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                    } else {
                        obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                    }
                    if (z) {
                        mapReferringAccumulator.put(deserializeKey, obj);
                    } else {
                        map.put(deserializeKey, obj);
                    }
                } catch (UnresolvedForwardReference e) {
                    handleUnresolvedReference(deserializationContext, mapReferringAccumulator, deserializeKey, e);
                } catch (Exception e2) {
                    wrapAndThrow(deserializationContext, e2, map, str);
                }
            } else {
                jsonParser.skipChildren();
            }
            str = jsonParser.nextFieldName();
        }
    }

    public final void _readAndBindStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        boolean z;
        MapReferringAccumulator mapReferringAccumulator;
        String str;
        Object obj;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonDeserializer.getObjectIdReader() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            mapReferringAccumulator = new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), map);
        } else {
            mapReferringAccumulator = null;
        }
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.currentToken();
            if (currentToken != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (currentToken != jsonToken) {
                    deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                }
                str = jsonParser.currentName();
            } else {
                return;
            }
        }
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(str)) {
                try {
                    if (nextToken == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            obj = this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else if (typeDeserializer == null) {
                        obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                    } else {
                        obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                    }
                    if (z) {
                        mapReferringAccumulator.put(str, obj);
                    } else {
                        map.put(str, obj);
                    }
                } catch (UnresolvedForwardReference e) {
                    handleUnresolvedReference(deserializationContext, mapReferringAccumulator, str, e);
                } catch (Exception e2) {
                    wrapAndThrow(deserializationContext, e2, map, str);
                }
            } else {
                jsonParser.skipChildren();
            }
            str = jsonParser.nextFieldName();
        }
    }

    public final void _readAndUpdate(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String str;
        Object obj;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.currentToken();
            if (currentToken != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (currentToken != jsonToken) {
                    deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                }
                str = jsonParser.currentName();
            } else {
                return;
            }
        }
        while (str != null) {
            Object deserializeKey = keyDeserializer.deserializeKey(str, deserializationContext);
            JsonToken nextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(str)) {
                try {
                    if (nextToken != JsonToken.VALUE_NULL) {
                        Object obj2 = map.get(deserializeKey);
                        if (obj2 != null) {
                            if (typeDeserializer == null) {
                                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext, obj2);
                            } else {
                                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer, obj2);
                            }
                        } else if (typeDeserializer == null) {
                            obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                        } else {
                            obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        }
                        if (obj != obj2) {
                            map.put(deserializeKey, obj);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(deserializeKey, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, str);
                }
            } else {
                jsonParser.skipChildren();
            }
            str = jsonParser.nextFieldName();
        }
    }

    public final void _readAndUpdateStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String str;
        Object obj;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.currentToken();
            if (currentToken != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (currentToken != jsonToken) {
                    deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                }
                str = jsonParser.currentName();
            } else {
                return;
            }
        }
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(str)) {
                try {
                    if (nextToken != JsonToken.VALUE_NULL) {
                        Object obj2 = map.get(str);
                        if (obj2 != null) {
                            if (typeDeserializer == null) {
                                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext, obj2);
                            } else {
                                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer, obj2);
                            }
                        } else if (typeDeserializer == null) {
                            obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                        } else {
                            obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        }
                        if (obj != obj2) {
                            map.put(str, obj);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(str, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, str);
                }
            } else {
                jsonParser.skipChildren();
            }
            str = jsonParser.nextFieldName();
        }
    }

    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        JsonDeserializer jsonDeserializer;
        HashSet hashSet;
        Set<String> set;
        AnnotatedMember member;
        Set<String> included;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        if (keyDeserializer == null) {
            keyDeserializer = deserializationContext.findKeyDeserializer(this._containerType.getKeyType(), beanProperty);
        } else if (keyDeserializer instanceof ContextualKeyDeserializer) {
            keyDeserializer = ((ContextualKeyDeserializer) keyDeserializer).createContextual(deserializationContext, beanProperty);
        }
        KeyDeserializer keyDeserializer2 = keyDeserializer;
        JsonDeserializer jsonDeserializer2 = this._valueDeserializer;
        if (beanProperty != null) {
            jsonDeserializer2 = findConvertingContentDeserializer(deserializationContext, beanProperty, jsonDeserializer2);
        }
        JavaType contentType = this._containerType.getContentType();
        if (jsonDeserializer2 == null) {
            jsonDeserializer = deserializationContext.findContextualValueDeserializer(contentType, beanProperty);
        } else {
            jsonDeserializer = deserializationContext.handleSecondaryContextualization(jsonDeserializer2, beanProperty, contentType);
        }
        JsonDeserializer jsonDeserializer3 = jsonDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.forProperty(beanProperty);
        }
        TypeDeserializer typeDeserializer2 = typeDeserializer;
        Set<String> set2 = this._ignorableProperties;
        Set<String> set3 = this._includableProperties;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (StdDeserializer._neitherNull(annotationIntrospector, beanProperty) && (member = beanProperty.getMember()) != null) {
            DeserializationConfig config = deserializationContext.getConfig();
            JsonIgnoreProperties.Value findPropertyIgnoralByName = annotationIntrospector.findPropertyIgnoralByName(config, member);
            if (findPropertyIgnoralByName != null) {
                Set<String> findIgnoredForDeserialization = findPropertyIgnoralByName.findIgnoredForDeserialization();
                if (!findIgnoredForDeserialization.isEmpty()) {
                    if (set2 == null) {
                        set2 = new HashSet<>();
                    } else {
                        set2 = new HashSet<>(set2);
                    }
                    for (String add : findIgnoredForDeserialization) {
                        set2.add(add);
                    }
                }
            }
            JsonIncludeProperties.Value findPropertyInclusionByName = annotationIntrospector.findPropertyInclusionByName(config, member);
            if (!(findPropertyInclusionByName == null || (included = findPropertyInclusionByName.getIncluded()) == null)) {
                HashSet hashSet2 = new HashSet();
                if (set3 == null) {
                    hashSet2 = new HashSet(included);
                } else {
                    for (String next : included) {
                        if (set3.contains(next)) {
                            hashSet2.add(next);
                        }
                    }
                }
                hashSet = hashSet2;
                set = set2;
                return withResolved(keyDeserializer2, typeDeserializer2, jsonDeserializer3, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializer3), set, hashSet);
            }
        }
        set = set2;
        hashSet = set3;
        return withResolved(keyDeserializer2, typeDeserializer2, jsonDeserializer3, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializer3), set, hashSet);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public final Class<?> getMapClass() {
        return this._containerType.getRawClass();
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public JavaType getValueType() {
        return this._containerType;
    }

    public boolean isCachable() {
        if (this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null && this._includableProperties == null) {
            return true;
        }
        return false;
    }

    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                JavaType javaType = this._containerType;
                deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{javaType, this._valueInstantiator.getClass().getName()}));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, delegateType, (BeanProperty) null);
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._containerType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{javaType2, this._valueInstantiator.getClass().getName()}));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, arrayDelegateType, (BeanProperty) null);
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(deserializationContext, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()), deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    public void setIgnorableProperties(Set<String> set) {
        if (set == null || set.size() == 0) {
            set = null;
        }
        this._ignorableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, this._includableProperties);
    }

    public void setIncludableProperties(Set<String> set) {
        this._includableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(this._ignorableProperties, set);
    }

    public MapDeserializer withResolved(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Set<String> set, Set<String> set2) {
        if (this._keyDeserializer == keyDeserializer && this._valueDeserializer == jsonDeserializer && this._valueTypeDeserializer == typeDeserializer && this._nullProvider == nullValueProvider && this._ignorableProperties == set && this._includableProperties == set2) {
            return this;
        }
        return new MapDeserializer(this, keyDeserializer, jsonDeserializer, typeDeserializer, nullValueProvider, set, set2);
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(jsonParser, deserializationContext);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (!this._hasDefaultCreator) {
            return (Map) deserializationContext.handleMissingInstantiator(getMapClass(), getValueInstantiator(), jsonParser, "no default constructor found", new Object[0]);
        }
        int currentTokenId = jsonParser.currentTokenId();
        if (!(currentTokenId == 1 || currentTokenId == 2)) {
            if (currentTokenId == 3) {
                return (Map) _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (currentTokenId != 5) {
                if (currentTokenId != 6) {
                    return (Map) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                return (Map) _deserializeFromString(jsonParser, deserializationContext);
            }
        }
        Map<Object, Object> map = (Map) this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._standardStringKey) {
            _readAndBindStringKeyMap(jsonParser, deserializationContext, map);
            return map;
        }
        _readAndBind(jsonParser, deserializationContext, map);
        return map;
    }

    public MapDeserializer(MapDeserializer mapDeserializer, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Set<String> set, Set<String> set2) {
        super((ContainerDeserializerBase<?>) mapDeserializer, nullValueProvider, mapDeserializer._unwrapSingle);
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = set;
        this._includableProperties = set2;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, set2);
        this._standardStringKey = _isStdKeyDeser(this._containerType, keyDeserializer);
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        jsonParser.setCurrentValue(map);
        JsonToken currentToken = jsonParser.currentToken();
        if (currentToken != JsonToken.START_OBJECT && currentToken != JsonToken.FIELD_NAME) {
            return (Map) deserializationContext.handleUnexpectedToken(getMapClass(), jsonParser);
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(jsonParser, deserializationContext, map);
            return map;
        }
        _readAndUpdate(jsonParser, deserializationContext, map);
        return map;
    }
}
