package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    private static final long serialVersionUID = 1;
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected final Set<String> _includedEntries;
    protected final IgnorePropertiesUtil.Checker _inclusionChecker;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    /* renamed from: com.fasterxml.jackson.databind.ser.std.MapSerializer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.JsonInclude$Include[] r0 = com.fasterxml.jackson.annotation.JsonInclude.Include.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include = r0
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.AnonymousClass1.<clinit>():void");
        }
    }

    public MapSerializer(Set<String> set, Set<String> set2, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, set2);
    }

    private final JsonSerializer<Object> _findSerializer(SerializerProvider serializerProvider, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        JsonSerializer<Object> serializerFor = this._dynamicValueSerializers.serializerFor(cls);
        if (serializerFor != null) {
            return serializerFor;
        }
        if (this._valueType.hasGenericTypes()) {
            return _findAndAddDynamic(this._dynamicValueSerializers, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
        }
        return _findAndAddDynamic(this._dynamicValueSerializers, cls, serializerProvider);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.ser.std.MapSerializer construct(java.util.Set<java.lang.String> r12, java.util.Set<java.lang.String> r13, com.fasterxml.jackson.databind.JavaType r14, boolean r15, com.fasterxml.jackson.databind.jsontype.TypeSerializer r16, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r17, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r18, java.lang.Object r19) {
        /*
            r0 = r14
            r1 = r19
            if (r0 != 0) goto L_0x000a
            com.fasterxml.jackson.databind.JavaType r0 = UNSPECIFIED_TYPE
            r6 = r0
            r7 = r6
            goto L_0x0021
        L_0x000a:
            com.fasterxml.jackson.databind.JavaType r2 = r14.getKeyType()
            java.lang.Class<java.util.Properties> r3 = java.util.Properties.class
            boolean r3 = r14.hasRawClass(r3)
            if (r3 == 0) goto L_0x001b
            com.fasterxml.jackson.databind.JavaType r0 = com.fasterxml.jackson.databind.type.TypeFactory.unknownType()
            goto L_0x001f
        L_0x001b:
            com.fasterxml.jackson.databind.JavaType r0 = r14.getContentType()
        L_0x001f:
            r7 = r0
            r6 = r2
        L_0x0021:
            r0 = 0
            if (r15 != 0) goto L_0x002e
            if (r7 == 0) goto L_0x0036
            boolean r2 = r7.isFinal()
            if (r2 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0036
        L_0x002e:
            java.lang.Class r2 = r7.getRawClass()
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r2 != r3) goto L_0x0038
        L_0x0036:
            r8 = r0
            goto L_0x0039
        L_0x0038:
            r8 = r15
        L_0x0039:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r3 = r0
            r4 = r12
            r5 = r13
            r9 = r16
            r10 = r17
            r11 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r1 == 0) goto L_0x004d
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = r0.withFilterId(r1)
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.construct(java.util.Set, java.util.Set, com.fasterxml.jackson.databind.JavaType, boolean, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.JsonSerializer, java.lang.Object):com.fasterxml.jackson.databind.ser.std.MapSerializer");
    }

    public void _ensureOverride(String str) {
        ClassUtil.verifyMustOverride(MapSerializer.class, this, str);
    }

    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        PropertySerializerMap propertySerializerMap2 = findAndAddSecondarySerializer.map;
        if (propertySerializerMap != propertySerializerMap2) {
            this._dynamicValueSerializers = propertySerializerMap2;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    public boolean _hasNullKey(Map<?, ?> map) {
        if (!(map instanceof HashMap) || !map.containsKey((Object) null)) {
            return false;
        }
        return true;
    }

    public Map<?, ?> _orderEntries(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!_hasNullKey(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                _writeNullKeyedEntry(jsonGenerator, serializerProvider, next.getValue());
            } else {
                treeMap.put(key, next.getValue());
            }
        }
        return treeMap;
    }

    public void _writeNullKeyedEntry(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> findNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
        if (obj != null) {
            jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                jsonSerializer = _findSerializer(serializerProvider, obj);
            }
            Object obj2 = this._suppressableValue;
            if (obj2 == MARKER_FOR_EMPTY) {
                if (jsonSerializer.isEmpty(serializerProvider, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (!this._suppressNulls) {
            jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
        } else {
            return;
        }
        try {
            findNullKeySerializer.serialize(null, jsonGenerator, serializerProvider);
            jsonSerializer.serialize(obj, jsonGenerator, serializerProvider);
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, obj, "");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0124, code lost:
        if (r0 != 5) goto L_0x015d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r14, com.fasterxml.jackson.databind.BeanProperty r15) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r13 = this;
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r14.getAnnotationIntrospector()
            r1 = 0
            if (r15 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000d
        L_0x0009:
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r15.getMember()
        L_0x000d:
            boolean r3 = com.fasterxml.jackson.databind.ser.std.StdSerializer._neitherNull(r2, r0)
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r0.findKeySerializer(r2)
            if (r3 == 0) goto L_0x001e
            com.fasterxml.jackson.databind.JsonSerializer r3 = r14.serializerInstance(r2, r3)
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            java.lang.Object r4 = r0.findContentSerializer(r2)
            if (r4 == 0) goto L_0x002a
            com.fasterxml.jackson.databind.JsonSerializer r4 = r14.serializerInstance(r2, r4)
            goto L_0x002e
        L_0x002a:
            r4 = r1
            goto L_0x002e
        L_0x002c:
            r3 = r1
            r4 = r3
        L_0x002e:
            if (r4 != 0) goto L_0x0032
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r4 = r13._valueSerializer
        L_0x0032:
            com.fasterxml.jackson.databind.JsonSerializer r4 = r13.findContextualConvertingSerializer(r14, r15, r4)
            if (r4 != 0) goto L_0x004a
            boolean r5 = r13._valueTypeIsStatic
            if (r5 == 0) goto L_0x004a
            com.fasterxml.jackson.databind.JavaType r5 = r13._valueType
            boolean r5 = r5.isJavaLangObject()
            if (r5 != 0) goto L_0x004a
            com.fasterxml.jackson.databind.JavaType r4 = r13._valueType
            com.fasterxml.jackson.databind.JsonSerializer r4 = r14.findContentValueSerializer((com.fasterxml.jackson.databind.JavaType) r4, (com.fasterxml.jackson.databind.BeanProperty) r15)
        L_0x004a:
            r8 = r4
            if (r3 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r3 = r13._keySerializer
        L_0x004f:
            if (r3 != 0) goto L_0x0058
            com.fasterxml.jackson.databind.JavaType r3 = r13._keyType
            com.fasterxml.jackson.databind.JsonSerializer r3 = r14.findKeySerializer((com.fasterxml.jackson.databind.JavaType) r3, (com.fasterxml.jackson.databind.BeanProperty) r15)
            goto L_0x005c
        L_0x0058:
            com.fasterxml.jackson.databind.JsonSerializer r3 = r14.handleSecondaryContextualization(r3, r15)
        L_0x005c:
            r7 = r3
            java.util.Set<java.lang.String> r3 = r13._ignoredEntries
            java.util.Set<java.lang.String> r4 = r13._includedEntries
            boolean r5 = com.fasterxml.jackson.databind.ser.std.StdSerializer._neitherNull(r2, r0)
            r12 = 0
            if (r5 == 0) goto L_0x00d5
            com.fasterxml.jackson.databind.SerializationConfig r5 = r14.getConfig()
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r6 = r0.findPropertyIgnoralByName(r5, r2)
            java.util.Set r6 = r6.findIgnoredForSerialization()
            boolean r9 = com.fasterxml.jackson.databind.ser.std.StdSerializer._nonEmpty(r6)
            if (r9 == 0) goto L_0x009c
            if (r3 != 0) goto L_0x0082
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            goto L_0x0088
        L_0x0082:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>(r3)
            r3 = r9
        L_0x0088:
            java.util.Iterator r6 = r6.iterator()
        L_0x008c:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = (java.lang.String) r9
            r3.add(r9)
            goto L_0x008c
        L_0x009c:
            com.fasterxml.jackson.annotation.JsonIncludeProperties$Value r5 = r0.findPropertyInclusionByName(r5, r2)
            java.util.Set r5 = r5.getIncluded()
            if (r5 == 0) goto L_0x00c8
            if (r4 != 0) goto L_0x00ae
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            goto L_0x00b4
        L_0x00ae:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r4)
            r4 = r6
        L_0x00b4:
            java.util.Iterator r5 = r5.iterator()
        L_0x00b8:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r4.add(r6)
            goto L_0x00b8
        L_0x00c8:
            java.lang.Boolean r5 = r0.findSerializationSortAlphabetically(r2)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = r6.equals(r5)
            r9 = r3
            r10 = r4
            goto L_0x00d8
        L_0x00d5:
            r9 = r3
            r10 = r4
            r5 = r12
        L_0x00d8:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            com.fasterxml.jackson.annotation.JsonFormat$Value r4 = r13.findFormatOverrides(r14, r15, r3)
            if (r4 == 0) goto L_0x00ee
            com.fasterxml.jackson.annotation.JsonFormat$Feature r6 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES
            java.lang.Boolean r4 = r4.getFeature(r6)
            if (r4 == 0) goto L_0x00ee
            boolean r4 = r4.booleanValue()
            r11 = r4
            goto L_0x00ef
        L_0x00ee:
            r11 = r5
        L_0x00ef:
            r5 = r13
            r6 = r15
            com.fasterxml.jackson.databind.ser.std.MapSerializer r4 = r5.withResolved(r6, r7, r8, r9, r10, r11)
            if (r2 == 0) goto L_0x0101
            java.lang.Object r0 = r0.findFilterId(r2)
            if (r0 == 0) goto L_0x0101
            com.fasterxml.jackson.databind.ser.std.MapSerializer r4 = r4.withFilterId(r0)
        L_0x0101:
            com.fasterxml.jackson.annotation.JsonInclude$Value r15 = r13.findIncludeOverrides(r14, r15, r3)
            if (r15 == 0) goto L_0x0161
            com.fasterxml.jackson.annotation.JsonInclude$Include r0 = r15.getContentInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Include r2 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r0 == r2) goto L_0x0161
            int[] r2 = com.fasterxml.jackson.databind.ser.std.MapSerializer.AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 1
            if (r0 == r2) goto L_0x0146
            r3 = 2
            if (r0 == r3) goto L_0x013a
            r3 = 3
            if (r0 == r3) goto L_0x0137
            r3 = 4
            if (r0 == r3) goto L_0x0127
            r14 = 5
            if (r0 == r14) goto L_0x015c
            goto L_0x015d
        L_0x0127:
            java.lang.Class r15 = r15.getContentFilter()
            java.lang.Object r1 = r14.includeFilterInstance(r1, r15)
            if (r1 != 0) goto L_0x0132
            goto L_0x015c
        L_0x0132:
            boolean r12 = r14.includeFilterSuppressNulls(r1)
            goto L_0x015d
        L_0x0137:
            java.lang.Object r1 = MARKER_FOR_EMPTY
            goto L_0x015c
        L_0x013a:
            com.fasterxml.jackson.databind.JavaType r14 = r13._valueType
            boolean r14 = r14.isReferenceType()
            if (r14 == 0) goto L_0x015c
            java.lang.Object r14 = MARKER_FOR_EMPTY
            r1 = r14
            goto L_0x015c
        L_0x0146:
            com.fasterxml.jackson.databind.JavaType r14 = r13._valueType
            java.lang.Object r1 = com.fasterxml.jackson.databind.util.BeanUtil.getDefaultValue(r14)
            if (r1 == 0) goto L_0x015c
            java.lang.Class r14 = r1.getClass()
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x015c
            java.lang.Object r1 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator(r1)
        L_0x015c:
            r12 = r2
        L_0x015d:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r4 = r4.withContentInclusion(r1, r12)
        L_0x0161:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object obj = null;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, (Object) null);
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._keySerializer;
        try {
            Object obj2 = null;
            for (Map.Entry next : map.entrySet()) {
                try {
                    Object value = next.getValue();
                    obj2 = next.getKey();
                    if (obj2 == null) {
                        serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
                    } else {
                        IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                        if (checker == null || !checker.shouldIgnore(obj2)) {
                            jsonSerializer.serialize(obj2, jsonGenerator, serializerProvider);
                        }
                    }
                    if (value == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        JsonSerializer<Object> jsonSerializer2 = this._valueSerializer;
                        if (jsonSerializer2 == null) {
                            jsonSerializer2 = _findSerializer(serializerProvider, value);
                        }
                        jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
                    }
                } catch (Exception e) {
                    e = e;
                    obj = obj2;
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(obj));
                }
            }
        } catch (Exception e2) {
            e = e2;
            wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(obj));
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException {
        JsonSerializer<Object> jsonSerializer2 = this._keySerializer;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                if (key == null) {
                    serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
                }
                Object value = next.getValue();
                if (value == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else if (typeSerializer == null) {
                    try {
                        jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(key));
                    }
                } else {
                    jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }

    public void serializeFilteredAnyProperties(SerializerProvider serializerProvider, JsonGenerator jsonGenerator, Object obj, Map<?, ?> map, PropertyFilter propertyFilter, Object obj2) throws IOException {
        boolean z;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        if (MARKER_FOR_EMPTY == obj2) {
            z = true;
        } else {
            z = false;
        }
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                if (key == null) {
                    jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
                } else {
                    jsonSerializer = this._keySerializer;
                }
                Object value = next.getValue();
                if (value != null) {
                    jsonSerializer2 = this._valueSerializer;
                    if (jsonSerializer2 == null) {
                        jsonSerializer2 = _findSerializer(serializerProvider, value);
                    }
                    if (z) {
                        if (jsonSerializer2.isEmpty(serializerProvider, value)) {
                        }
                    } else if (obj2 != null && obj2.equals(value)) {
                    }
                } else if (!this._suppressNulls) {
                    jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
                }
                mapProperty.reset(key, value, jsonSerializer, jsonSerializer2);
                try {
                    propertyFilter.serializeAsField(obj, jsonGenerator, serializerProvider, mapProperty);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(key));
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter, Object obj) throws IOException {
        boolean z;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        if (MARKER_FOR_EMPTY == obj) {
            z = true;
        } else {
            z = false;
        }
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                if (key == null) {
                    jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
                } else {
                    jsonSerializer = this._keySerializer;
                }
                Object value = next.getValue();
                if (value != null) {
                    jsonSerializer2 = this._valueSerializer;
                    if (jsonSerializer2 == null) {
                        jsonSerializer2 = _findSerializer(serializerProvider, value);
                    }
                    if (z) {
                        if (jsonSerializer2.isEmpty(serializerProvider, value)) {
                        }
                    } else if (obj != null && obj.equals(value)) {
                    }
                } else if (!this._suppressNulls) {
                    jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
                }
                mapProperty.reset(key, value, jsonSerializer, jsonSerializer2);
                try {
                    propertyFilter.serializeAsField(map, jsonGenerator, serializerProvider, mapProperty);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(key));
                }
            }
        }
    }

    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        boolean z;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, obj);
            return;
        }
        if (MARKER_FOR_EMPTY == obj) {
            z = true;
        } else {
            z = false;
        }
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else {
                IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                if (checker == null || !checker.shouldIgnore(key)) {
                    jsonSerializer = this._keySerializer;
                }
            }
            Object value = next.getValue();
            if (value != null) {
                jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    jsonSerializer2 = _findSerializer(serializerProvider, value);
                }
                if (z) {
                    if (jsonSerializer2.isEmpty(serializerProvider, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this._suppressNulls) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            try {
                jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
                jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
            } catch (Exception e) {
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(key));
            }
        }
    }

    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        boolean z;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        if (MARKER_FOR_EMPTY == obj) {
            z = true;
        } else {
            z = false;
        }
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else {
                IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                if (checker == null || !checker.shouldIgnore(key)) {
                    jsonSerializer = this._keySerializer;
                }
            }
            Object value = next.getValue();
            if (value != null) {
                jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    jsonSerializer2 = _findSerializer(serializerProvider, value);
                }
                if (z) {
                    if (jsonSerializer2.isEmpty(serializerProvider, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this._suppressNulls) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
            try {
                jsonSerializer2.serializeWithType(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
            } catch (Exception e) {
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, String.valueOf(key));
            }
        }
    }

    public void serializeWithoutTypeInfo(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        PropertyFilter findPropertyFilter;
        if (!map.isEmpty()) {
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map, jsonGenerator, serializerProvider);
            }
            Map<?, ?> map2 = map;
            Object obj = this._filterId;
            if (obj == null || (findPropertyFilter = findPropertyFilter(serializerProvider, obj, map2)) == null) {
                Object obj2 = this._suppressableValue;
                if (obj2 != null || this._suppressNulls) {
                    serializeOptionalFields(map2, jsonGenerator, serializerProvider, obj2);
                    return;
                }
                JsonSerializer<Object> jsonSerializer = this._valueSerializer;
                if (jsonSerializer != null) {
                    serializeFieldsUsing(map2, jsonGenerator, serializerProvider, jsonSerializer);
                } else {
                    serializeFields(map2, jsonGenerator, serializerProvider);
                }
            } else {
                serializeFilteredFields(map2, jsonGenerator, serializerProvider, findPropertyFilter, this._suppressableValue);
            }
        }
    }

    public MapSerializer withContentInclusion(Object obj, boolean z) {
        if (obj == this._suppressableValue && z == this._suppressNulls) {
            return this;
        }
        _ensureOverride("withContentInclusion");
        return new MapSerializer(this, this._valueTypeSerializer, obj, z);
    }

    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride("withFilterId");
        return new MapSerializer(this, obj, this._sortKeys);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, Set<String> set2, boolean z) {
        _ensureOverride("withResolved");
        MapSerializer mapSerializer = new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, set, set2);
        if (z != mapSerializer._sortKeys) {
            return new MapSerializer(mapSerializer, this._filterId, z);
        }
        return mapSerializer;
    }

    public MapSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        _ensureOverride("_withValueTypeSerializer");
        return new MapSerializer(this, typeSerializer, this._suppressableValue, this._suppressNulls);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Map<?, ?> map) {
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this._suppressableValue;
        if (obj == null && !this._suppressNulls) {
            return false;
        }
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        boolean z = MARKER_FOR_EMPTY == obj;
        if (jsonSerializer != null) {
            for (Object next : map.values()) {
                if (next == null) {
                    if (!this._suppressNulls) {
                        return false;
                    }
                } else if (z) {
                    if (!jsonSerializer.isEmpty(serializerProvider, next)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object next2 : map.values()) {
            if (next2 != null) {
                try {
                    JsonSerializer<Object> _findSerializer = _findSerializer(serializerProvider, next2);
                    if (!z) {
                        if (obj != null && obj.equals(map)) {
                        }
                        return false;
                    } else if (!_findSerializer.isEmpty(serializerProvider, next2)) {
                        return false;
                    }
                } catch (DatabindException unused) {
                }
            } else if (!this._suppressNulls) {
                return false;
            }
        }
        return true;
    }

    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject(map);
        serializeWithoutTypeInfo(map, jsonGenerator, serializerProvider);
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.setCurrentValue(map);
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(map, JsonToken.START_OBJECT));
        serializeWithoutTypeInfo(map, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        PropertySerializerMap propertySerializerMap2 = findAndAddSecondarySerializer.map;
        if (propertySerializerMap != propertySerializerMap2) {
            this._dynamicValueSerializers = propertySerializerMap2;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    public static MapSerializer construct(Set<String> set, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        return construct(set, (Set<String>) null, javaType, z, typeSerializer, jsonSerializer, jsonSerializer2, obj);
    }

    public MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, set2);
    }

    public MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }

    public MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }
}
