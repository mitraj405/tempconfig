package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class JavaUtilCollectionsDeserializers {

    public static class JavaUtilCollectionsConverter implements Converter<Object, Object> {
        private final JavaType _inputType;
        private final int _kind;

        public JavaUtilCollectionsConverter(int i, JavaType javaType) {
            this._inputType = javaType;
            this._kind = i;
        }

        private void _checkSingleton(int i) {
            if (i != 1) {
                throw new IllegalArgumentException(C1058d.y("Can not deserialize Singleton container from ", i, " entries"));
            }
        }

        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this._kind) {
                case 1:
                    Set set = (Set) obj;
                    _checkSingleton(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    _checkSingleton(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    _checkSingleton(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }

        public JavaType getInputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        public JavaType getOutputType(TypeFactory typeFactory) {
            return this._inputType;
        }
    }

    private static String _findSingletonTypeName(String str) {
        if (str.startsWith("Singleton")) {
            return str.substring(9);
        }
        return null;
    }

    private static String _findSyncTypeName(String str) {
        if (str.startsWith("Synchronized")) {
            return str.substring(12);
        }
        return null;
    }

    private static String _findUnmodifiableTypeName(String str) {
        if (str.startsWith("Unmodifiable")) {
            return str.substring(12);
        }
        return null;
    }

    private static String _findUtilArrayTypeName(String str) {
        if (str.startsWith("java.util.Arrays$")) {
            return str.substring(17);
        }
        return null;
    }

    private static String _findUtilCollectionsImmutableTypeName(String str) {
        if (str.startsWith("java.util.ImmutableCollections$")) {
            return str.substring(31);
        }
        return null;
    }

    private static String _findUtilCollectionsTypeName(String str) {
        if (str.startsWith("java.util.Collections$")) {
            return str.substring(22);
        }
        return null;
    }

    public static JavaUtilCollectionsConverter converter(int i, JavaType javaType, Class<?> cls) {
        return new JavaUtilCollectionsConverter(i, javaType.findSuperType(cls));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.JsonDeserializer<?> findForCollection(com.fasterxml.jackson.databind.DeserializationContext r8, com.fasterxml.jackson.databind.JavaType r9) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            java.lang.Class r8 = r9.getRawClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r0 = "java.util."
            boolean r0 = r8.startsWith(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.String r0 = _findUtilCollectionsTypeName(r8)
            r2 = 4
            r3 = 5
            java.lang.Class<java.util.Set> r4 = java.util.Set.class
            java.lang.String r5 = "Set"
            java.lang.Class<java.util.List> r6 = java.util.List.class
            java.lang.String r7 = "List"
            if (r0 == 0) goto L_0x0096
            java.lang.String r8 = _findUnmodifiableTypeName(r0)
            if (r8 == 0) goto L_0x003e
            boolean r0 = r8.endsWith(r5)
            if (r0 == 0) goto L_0x0033
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r2, r9, r4)
            goto L_0x008d
        L_0x0033:
            boolean r8 = r8.endsWith(r7)
            if (r8 == 0) goto L_0x008c
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r3, r9, r6)
            goto L_0x008d
        L_0x003e:
            java.lang.String r8 = _findSingletonTypeName(r0)
            if (r8 == 0) goto L_0x005c
            boolean r0 = r8.endsWith(r5)
            if (r0 == 0) goto L_0x0050
            r8 = 1
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r8, r9, r4)
            goto L_0x008d
        L_0x0050:
            boolean r8 = r8.endsWith(r7)
            if (r8 == 0) goto L_0x008c
            r8 = 2
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r8, r9, r6)
            goto L_0x008d
        L_0x005c:
            java.lang.String r8 = _findSyncTypeName(r0)
            if (r8 == 0) goto L_0x008c
            boolean r0 = r8.endsWith(r5)
            if (r0 == 0) goto L_0x006e
            r8 = 7
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r8, r9, r4)
            goto L_0x008d
        L_0x006e:
            boolean r0 = r8.endsWith(r7)
            if (r0 == 0) goto L_0x007b
            r8 = 9
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r8, r9, r6)
            goto L_0x008d
        L_0x007b:
            java.lang.String r0 = "Collection"
            boolean r8 = r8.endsWith(r0)
            if (r8 == 0) goto L_0x008c
            r8 = 8
            java.lang.Class<java.util.Collection> r0 = java.util.Collection.class
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r8 = converter(r8, r9, r0)
            goto L_0x008d
        L_0x008c:
            r8 = r1
        L_0x008d:
            if (r8 != 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer r1 = new com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
            r1.<init>(r8)
        L_0x0095:
            return r1
        L_0x0096:
            java.lang.String r0 = _findUtilArrayTypeName(r8)
            if (r0 == 0) goto L_0x00ad
            boolean r8 = r0.contains(r7)
            if (r8 == 0) goto L_0x00ac
            com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer r8 = new com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r9 = converter(r3, r9, r6)
            r8.<init>(r9)
            return r8
        L_0x00ac:
            return r1
        L_0x00ad:
            java.lang.String r8 = _findUtilCollectionsImmutableTypeName(r8)
            if (r8 == 0) goto L_0x00d5
            boolean r0 = r8.contains(r7)
            if (r0 == 0) goto L_0x00c5
            com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer r8 = new com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
            r0 = 11
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r9 = converter(r0, r9, r6)
            r8.<init>(r9)
            return r8
        L_0x00c5:
            boolean r8 = r8.contains(r5)
            if (r8 == 0) goto L_0x00d5
            com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer r8 = new com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r9 = converter(r2, r9, r4)
            r8.<init>(r9)
            return r8
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers.findForCollection(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.JsonDeserializer<?> findForMap(com.fasterxml.jackson.databind.DeserializationContext r5, com.fasterxml.jackson.databind.JavaType r6) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            java.lang.Class r5 = r6.getRawClass()
            java.lang.String r5 = r5.getName()
            java.lang.String r0 = _findUtilCollectionsTypeName(r5)
            r1 = 6
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            java.lang.String r3 = "Map"
            r4 = 0
            if (r0 == 0) goto L_0x004a
            java.lang.String r5 = _findUnmodifiableTypeName(r0)
            if (r5 == 0) goto L_0x0025
            boolean r5 = r5.contains(r3)
            if (r5 == 0) goto L_0x005b
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r5 = converter(r1, r6, r2)
            goto L_0x005c
        L_0x0025:
            java.lang.String r5 = _findSingletonTypeName(r0)
            if (r5 == 0) goto L_0x0037
            boolean r5 = r5.contains(r3)
            if (r5 == 0) goto L_0x005b
            r5 = 3
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r5 = converter(r5, r6, r2)
            goto L_0x005c
        L_0x0037:
            java.lang.String r5 = _findSyncTypeName(r0)
            if (r5 == 0) goto L_0x005b
            boolean r5 = r5.contains(r3)
            if (r5 == 0) goto L_0x005b
            r5 = 10
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r5 = converter(r5, r6, r2)
            goto L_0x005c
        L_0x004a:
            java.lang.String r5 = _findUtilCollectionsImmutableTypeName(r5)
            if (r5 == 0) goto L_0x005b
            boolean r5 = r5.contains(r3)
            if (r5 == 0) goto L_0x005b
            com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers$JavaUtilCollectionsConverter r5 = converter(r1, r6, r2)
            goto L_0x005c
        L_0x005b:
            r5 = r4
        L_0x005c:
            if (r5 != 0) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer r4 = new com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer
            r4.<init>(r5)
        L_0x0064:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers.findForMap(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.JsonDeserializer");
    }
}
