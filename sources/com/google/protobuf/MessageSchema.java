package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        boolean z3;
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        if (extensionSchema2 == null || !extensionSchema2.hasExtensions(messageLite)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.hasExtensions = z3;
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        if (isFieldPresent(t, i) == isFieldPresent(t2, i)) {
            return true;
        }
        return false;
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean((Object) t, j);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [int, byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r15, int r16, int r17, com.google.protobuf.MapEntryLite.Metadata<K, V> r18, java.util.Map<K, V> r19, com.google.protobuf.ArrayDecoders.Registers r20) throws java.io.IOException {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r15, r0, r10)
            int r1 = r10.int1
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            K r1 = r9.defaultKey
            V r2 = r9.defaultValue
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r0, r15, r1, r10)
            int r1 = r10.int1
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            com.google.protobuf.WireFormat$FieldType r1 = r9.valueType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.valueType
            V r0 = r9.defaultValue
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.object1
            goto L_0x001d
        L_0x0057:
            com.google.protobuf.WireFormat$FieldType r1 = r9.keyType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.keyType
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.object1
            goto L_0x001d
        L_0x006f:
            int r0 = com.google.protobuf.ArrayDecoders.skipField(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x0081:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, com.google.protobuf.MapEntryLite$Metadata, java.util.Map, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int decodeMapEntryValue(byte[] r2, int r3, int r4, com.google.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws java.io.IOException {
        /*
            r1 = this;
            int[] r0 = com.google.protobuf.MessageSchema.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "unsupported field type."
            r2.<init>(r3)
            throw r2
        L_0x0013:
            int r2 = com.google.protobuf.ArrayDecoders.decodeStringRequireUtf8(r2, r3, r7)
            goto L_0x00ae
        L_0x0019:
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            long r3 = com.google.protobuf.CodedInputStream.decodeZigZag64(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x002b:
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint32(r2, r3, r7)
            int r3 = r7.int1
            int r3 = com.google.protobuf.CodedInputStream.decodeZigZag32(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x003d:
            com.google.protobuf.Protobuf r5 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.Schema r5 = r5.schemaFor(r6)
            int r2 = com.google.protobuf.ArrayDecoders.decodeMessageField(r5, r2, r3, r4, r7)
            goto L_0x00ae
        L_0x004a:
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0057:
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint32(r2, r3, r7)
            int r3 = r7.int1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0064:
            float r2 = com.google.protobuf.ArrayDecoders.decodeFloat(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r7.object1 = r2
            goto L_0x0084
        L_0x006f:
            long r4 = com.google.protobuf.ArrayDecoders.decodeFixed64(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r7.object1 = r2
            goto L_0x0091
        L_0x007a:
            int r2 = com.google.protobuf.ArrayDecoders.decodeFixed32(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.object1 = r2
        L_0x0084:
            int r2 = r3 + 4
            goto L_0x00ae
        L_0x0087:
            double r4 = com.google.protobuf.ArrayDecoders.decodeDouble(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r7.object1 = r2
        L_0x0091:
            int r2 = r3 + 8
            goto L_0x00ae
        L_0x0094:
            int r2 = com.google.protobuf.ArrayDecoders.decodeBytes(r2, r3, r7)
            goto L_0x00ae
        L_0x0099:
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00a7
            r3 = 1
            goto L_0x00a8
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r7.object1 = r3
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.decodeMapEntryValue(byte[], int, int, com.google.protobuf.WireFormat$FieldType, java.lang.Class, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble((Object) t, j);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) {
            return ub;
        }
        return filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat((Object) t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0347, code lost:
        r6 = defpackage.C1058d.q(r9, r4, r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04b7, code lost:
        r6 = r6 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto2(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = UNSAFE
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
        L_0x000f:
            int[] r8 = r0.buffer
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0522
            int r8 = r15.typeAndOffsetAt(r5)
            int r9 = r15.numberAt(r5)
            int r10 = type(r8)
            r11 = 17
            r12 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.buffer
            int r13 = r5 + 2
            r11 = r11[r13]
            r3 = r3 & r11
            int r13 = r11 >>> 20
            int r12 = r12 << r13
            if (r3 == r4) goto L_0x0058
            long r13 = (long) r3
            int r4 = r2.getInt(r1, r13)
            r7 = r4
            r4 = r3
            goto L_0x0058
        L_0x0039:
            boolean r11 = r0.useCachedSizeField
            if (r11 == 0) goto L_0x0055
            com.google.protobuf.FieldType r11 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r10 < r11) goto L_0x0055
            com.google.protobuf.FieldType r11 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r10 > r11) goto L_0x0055
            int[] r11 = r0.buffer
            int r12 = r5 + 2
            r11 = r11[r12]
            r3 = r3 & r11
            goto L_0x0056
        L_0x0055:
            r3 = 0
        L_0x0056:
            r11 = r3
            r12 = 0
        L_0x0058:
            long r13 = offset(r8)
            r8 = r4
            r3 = 0
            switch(r10) {
                case 0: goto L_0x050e;
                case 1: goto L_0x0503;
                case 2: goto L_0x04f5;
                case 3: goto L_0x04e7;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04cf;
                case 6: goto L_0x04c4;
                case 7: goto L_0x04b9;
                case 8: goto L_0x049e;
                case 9: goto L_0x048c;
                case 10: goto L_0x047d;
                case 11: goto L_0x0470;
                case 12: goto L_0x0463;
                case 13: goto L_0x0459;
                case 14: goto L_0x0450;
                case 15: goto L_0x0443;
                case 16: goto L_0x0436;
                case 17: goto L_0x0423;
                case 18: goto L_0x0417;
                case 19: goto L_0x0409;
                case 20: goto L_0x03fd;
                case 21: goto L_0x03f1;
                case 22: goto L_0x03e5;
                case 23: goto L_0x03d9;
                case 24: goto L_0x03cd;
                case 25: goto L_0x03c1;
                case 26: goto L_0x03b6;
                case 27: goto L_0x03a7;
                case 28: goto L_0x039b;
                case 29: goto L_0x038e;
                case 30: goto L_0x0381;
                case 31: goto L_0x0374;
                case 32: goto L_0x0367;
                case 33: goto L_0x035a;
                case 34: goto L_0x034d;
                case 35: goto L_0x032b;
                case 36: goto L_0x030e;
                case 37: goto L_0x02f1;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02b6;
                case 40: goto L_0x0298;
                case 41: goto L_0x027a;
                case 42: goto L_0x025c;
                case 43: goto L_0x023e;
                case 44: goto L_0x0220;
                case 45: goto L_0x0202;
                case 46: goto L_0x01e4;
                case 47: goto L_0x01c6;
                case 48: goto L_0x01a8;
                case 49: goto L_0x0198;
                case 50: goto L_0x0188;
                case 51: goto L_0x017a;
                case 52: goto L_0x016d;
                case 53: goto L_0x015d;
                case 54: goto L_0x014d;
                case 55: goto L_0x013d;
                case 56: goto L_0x0131;
                case 57: goto L_0x0124;
                case 58: goto L_0x0117;
                case 59: goto L_0x00f9;
                case 60: goto L_0x00e5;
                case 61: goto L_0x00d3;
                case 62: goto L_0x00c3;
                case 63: goto L_0x00b3;
                case 64: goto L_0x00a6;
                case 65: goto L_0x009a;
                case 66: goto L_0x008a;
                case 67: goto L_0x007a;
                case 68: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x051a
        L_0x0064:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.MessageLite r3 = (com.google.protobuf.MessageLite) r3
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.CodedOutputStream.computeGroupSize(r9, r3, r4)
            goto L_0x0414
        L_0x007a:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x0414
        L_0x008a:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x0414
        L_0x009a:
            boolean r10 = r15.isOneofPresent(r1, r9, r5)
            if (r10 == 0) goto L_0x051a
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x0414
        L_0x00a6:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
            goto L_0x0414
        L_0x00b3:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x0414
        L_0x00c3:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x0414
        L_0x00d3:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0414
        L_0x00e5:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.SchemaUtil.computeSizeMessage(r9, r3, r4)
            goto L_0x0414
        L_0x00f9:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x010f
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x04b7
        L_0x010f:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeStringSize(r9, r3)
            goto L_0x04b7
        L_0x0117:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x0414
        L_0x0124:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r9, r3)
            goto L_0x0414
        L_0x0131:
            boolean r10 = r15.isOneofPresent(r1, r9, r5)
            if (r10 == 0) goto L_0x051a
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x0414
        L_0x013d:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x0414
        L_0x014d:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x0414
        L_0x015d:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x0414
        L_0x016d:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeFloatSize(r9, r3)
            goto L_0x0414
        L_0x017a:
            boolean r3 = r15.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
            goto L_0x0414
        L_0x0188:
            com.google.protobuf.MapFieldSchema r3 = r0.mapFieldSchema
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.lang.Object r10 = r15.getMapFieldDefaultEntry(r5)
            int r3 = r3.getSerializedSize(r9, r4, r10)
            goto L_0x0414
        L_0x0198:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.SchemaUtil.computeSizeGroupList(r9, r3, r4)
            goto L_0x0414
        L_0x01a8:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01bc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01bc:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01da
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01da:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01e4:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01f8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01f8:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0202:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0216
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0216:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeEnumListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0234
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0234:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x023e:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0252
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0252:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x025c:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeBoolListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0270
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0270:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x027a:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x028e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x028e:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0298:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02ac
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ac:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02ca
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ca:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02e8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02e8:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02f1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0305
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0305:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0322
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0322:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x032b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x051a
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x033f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x033f:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r9 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
        L_0x0347:
            int r6 = defpackage.C1058d.q(r9, r4, r3, r6)
            goto L_0x051a
        L_0x034d:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.SchemaUtil.computeSizeSInt64List(r9, r3, r4)
            goto L_0x0414
        L_0x035a:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeSInt32List(r9, r4, r3)
            goto L_0x0414
        L_0x0367:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r9, r4, r3)
            goto L_0x0414
        L_0x0374:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r9, r4, r3)
            goto L_0x0414
        L_0x0381:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeEnumList(r9, r4, r3)
            goto L_0x0414
        L_0x038e:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeUInt32List(r9, r4, r3)
            goto L_0x0414
        L_0x039b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeByteStringList(r9, r3)
            goto L_0x0414
        L_0x03a7:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.SchemaUtil.computeSizeMessageList(r9, r3, r4)
            goto L_0x0414
        L_0x03b6:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.SchemaUtil.computeSizeStringList(r9, r3)
            goto L_0x0414
        L_0x03c1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.SchemaUtil.computeSizeBoolList(r9, r3, r4)
            goto L_0x0414
        L_0x03cd:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r9, r4, r3)
            goto L_0x0414
        L_0x03d9:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r9, r4, r3)
            goto L_0x0414
        L_0x03e5:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeInt32List(r9, r4, r3)
            goto L_0x0414
        L_0x03f1:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeUInt64List(r9, r4, r3)
            goto L_0x0414
        L_0x03fd:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeInt64List(r9, r4, r3)
            goto L_0x0414
        L_0x0409:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r9, r4, r3)
        L_0x0414:
            int r6 = r6 + r3
            goto L_0x051a
        L_0x0417:
            r3 = 0
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.util.List r4 = (java.util.List) r4
            int r3 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r9, r4, r3)
            goto L_0x0414
        L_0x0423:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.MessageLite r3 = (com.google.protobuf.MessageLite) r3
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.CodedOutputStream.computeGroupSize(r9, r3, r4)
            goto L_0x0414
        L_0x0436:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x0414
        L_0x0443:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x0414
        L_0x0450:
            r10 = r7 & r12
            if (r10 == 0) goto L_0x051a
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x0414
        L_0x0459:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
            goto L_0x0414
        L_0x0463:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x0414
        L_0x0470:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x0414
        L_0x047d:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0414
        L_0x048c:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.Schema r4 = r15.getMessageFieldSchema(r5)
            int r3 = com.google.protobuf.SchemaUtil.computeSizeMessage(r9, r3, r4)
            goto L_0x0414
        L_0x049e:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x04b1
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x04b7
        L_0x04b1:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeStringSize(r9, r3)
        L_0x04b7:
            int r6 = r6 + r3
            goto L_0x051a
        L_0x04b9:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x0414
        L_0x04c4:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r9, r3)
            goto L_0x0414
        L_0x04cf:
            r10 = r7 & r12
            if (r10 == 0) goto L_0x051a
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x0414
        L_0x04d9:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x0414
        L_0x04e7:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x0414
        L_0x04f5:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x0414
        L_0x0503:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeFloatSize(r9, r3)
            goto L_0x0414
        L_0x050e:
            r3 = r7 & r12
            if (r3 == 0) goto L_0x051a
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
            goto L_0x0414
        L_0x051a:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8
            goto L_0x000f
        L_0x0522:
            com.google.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r15.getUnknownFieldsSerializedSize(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0538
            com.google.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            com.google.protobuf.FieldSet r1 = r2.getExtensions(r1)
            int r1 = r1.getSerializedSize()
            int r6 = r6 + r1
        L_0x0538:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.getSerializedSizeProto2(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x031c, code lost:
        r3 = defpackage.C1058d.q(r6, r4, r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0479, code lost:
        r3 = r3 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto3(T r14) {
        /*
            r13 = this;
            sun.misc.Unsafe r0 = UNSAFE
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r13.buffer
            int r4 = r4.length
            if (r2 >= r4) goto L_0x04e7
            int r4 = r13.typeAndOffsetAt(r2)
            int r5 = type(r4)
            int r6 = r13.numberAt(r2)
            long r7 = offset(r4)
            com.google.protobuf.FieldType r4 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r4 = r4.id()
            if (r5 < r4) goto L_0x0035
            com.google.protobuf.FieldType r4 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r4 = r4.id()
            if (r5 > r4) goto L_0x0035
            int[] r4 = r13.buffer
            int r9 = r2 + 2
            r4 = r4[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r9
            goto L_0x0036
        L_0x0035:
            r4 = r1
        L_0x0036:
            r9 = 1
            r10 = 0
            r11 = 0
            switch(r5) {
                case 0: goto L_0x04d5;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04bb;
                case 3: goto L_0x04ac;
                case 4: goto L_0x049d;
                case 5: goto L_0x0492;
                case 6: goto L_0x0487;
                case 7: goto L_0x047c;
                case 8: goto L_0x045e;
                case 9: goto L_0x0449;
                case 10: goto L_0x0438;
                case 11: goto L_0x0429;
                case 12: goto L_0x041a;
                case 13: goto L_0x040f;
                case 14: goto L_0x0404;
                case 15: goto L_0x03f5;
                case 16: goto L_0x03e6;
                case 17: goto L_0x03d0;
                case 18: goto L_0x03c6;
                case 19: goto L_0x03bc;
                case 20: goto L_0x03b2;
                case 21: goto L_0x03a8;
                case 22: goto L_0x039e;
                case 23: goto L_0x0394;
                case 24: goto L_0x038a;
                case 25: goto L_0x0380;
                case 26: goto L_0x0376;
                case 27: goto L_0x0368;
                case 28: goto L_0x035e;
                case 29: goto L_0x0354;
                case 30: goto L_0x034a;
                case 31: goto L_0x0340;
                case 32: goto L_0x0336;
                case 33: goto L_0x032c;
                case 34: goto L_0x0322;
                case 35: goto L_0x0300;
                case 36: goto L_0x02e3;
                case 37: goto L_0x02c6;
                case 38: goto L_0x02a9;
                case 39: goto L_0x028b;
                case 40: goto L_0x026d;
                case 41: goto L_0x024f;
                case 42: goto L_0x0231;
                case 43: goto L_0x0213;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01d7;
                case 46: goto L_0x01b9;
                case 47: goto L_0x019b;
                case 48: goto L_0x017d;
                case 49: goto L_0x016f;
                case 50: goto L_0x015f;
                case 51: goto L_0x0151;
                case 52: goto L_0x0145;
                case 53: goto L_0x0135;
                case 54: goto L_0x0125;
                case 55: goto L_0x0115;
                case 56: goto L_0x0109;
                case 57: goto L_0x00fd;
                case 58: goto L_0x00f1;
                case 59: goto L_0x00d3;
                case 60: goto L_0x00bf;
                case 61: goto L_0x00ad;
                case 62: goto L_0x009d;
                case 63: goto L_0x008d;
                case 64: goto L_0x0081;
                case 65: goto L_0x0075;
                case 66: goto L_0x0065;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x04e3
        L_0x003f:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.MessageLite r4 = (com.google.protobuf.MessageLite) r4
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.CodedOutputStream.computeGroupSize(r6, r4, r5)
            goto L_0x045b
        L_0x0055:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = oneofLongAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r6, r4)
            goto L_0x045b
        L_0x0065:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = oneofIntAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r6, r4)
            goto L_0x045b
        L_0x0075:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r6, r11)
            goto L_0x045b
        L_0x0081:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r6, r1)
            goto L_0x045b
        L_0x008d:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = oneofIntAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeEnumSize(r6, r4)
            goto L_0x045b
        L_0x009d:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = oneofIntAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r6, r4)
            goto L_0x045b
        L_0x00ad:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeBytesSize(r6, r4)
            goto L_0x045b
        L_0x00bf:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeMessage(r6, r4, r5)
            goto L_0x045b
        L_0x00d3:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            boolean r5 = r4 instanceof com.google.protobuf.ByteString
            if (r5 == 0) goto L_0x00e9
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeBytesSize(r6, r4)
            goto L_0x0479
        L_0x00e9:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeStringSize(r6, r4)
            goto L_0x0479
        L_0x00f1:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeBoolSize(r6, r9)
            goto L_0x045b
        L_0x00fd:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r6, r1)
            goto L_0x045b
        L_0x0109:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r6, r11)
            goto L_0x045b
        L_0x0115:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = oneofIntAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeInt32Size(r6, r4)
            goto L_0x045b
        L_0x0125:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = oneofLongAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r6, r4)
            goto L_0x045b
        L_0x0135:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = oneofLongAt(r14, r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeInt64Size(r6, r4)
            goto L_0x045b
        L_0x0145:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFloatSize(r6, r10)
            goto L_0x045b
        L_0x0151:
            boolean r4 = r13.isOneofPresent(r14, r6, r2)
            if (r4 == 0) goto L_0x04e3
            r4 = 0
            int r4 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r6, r4)
            goto L_0x045b
        L_0x015f:
            com.google.protobuf.MapFieldSchema r4 = r13.mapFieldSchema
            java.lang.Object r5 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            java.lang.Object r7 = r13.getMapFieldDefaultEntry(r2)
            int r4 = r4.getSerializedSize(r6, r5, r7)
            goto L_0x045b
        L_0x016f:
            java.util.List r4 = listAt(r14, r7)
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeGroupList(r6, r4, r5)
            goto L_0x045b
        L_0x017d:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0191
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0191:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x019b:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x01af
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x01af:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x01b9:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x01cd
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x01cd:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x01d7:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x01eb
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x01eb:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x01f5:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeEnumListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0209
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0209:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x0213:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0227
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0227:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x0231:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeBoolListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0245
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0245:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x024f:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0263
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0263:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x026d:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0281
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0281:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x028b:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x029f
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x029f:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x02a9:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x02bd
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x02bd:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x02c6:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x02da
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x02da:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x02e3:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x02f7
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x02f7:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x031c
        L_0x0300:
            java.lang.Object r5 = r0.getObject(r14, r7)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x04e3
            boolean r7 = r13.useCachedSizeField
            if (r7 == 0) goto L_0x0314
            long r7 = (long) r4
            r0.putInt(r14, r7, r5)
        L_0x0314:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r6)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
        L_0x031c:
            int r3 = defpackage.C1058d.q(r6, r4, r5, r3)
            goto L_0x04e3
        L_0x0322:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeSInt64List(r6, r4, r1)
            goto L_0x045b
        L_0x032c:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeSInt32List(r6, r4, r1)
            goto L_0x045b
        L_0x0336:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r6, r4, r1)
            goto L_0x045b
        L_0x0340:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r6, r4, r1)
            goto L_0x045b
        L_0x034a:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeEnumList(r6, r4, r1)
            goto L_0x045b
        L_0x0354:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeUInt32List(r6, r4, r1)
            goto L_0x045b
        L_0x035e:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeByteStringList(r6, r4)
            goto L_0x045b
        L_0x0368:
            java.util.List r4 = listAt(r14, r7)
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeMessageList(r6, r4, r5)
            goto L_0x045b
        L_0x0376:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeStringList(r6, r4)
            goto L_0x045b
        L_0x0380:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeBoolList(r6, r4, r1)
            goto L_0x045b
        L_0x038a:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r6, r4, r1)
            goto L_0x045b
        L_0x0394:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r6, r4, r1)
            goto L_0x045b
        L_0x039e:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeInt32List(r6, r4, r1)
            goto L_0x045b
        L_0x03a8:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeUInt64List(r6, r4, r1)
            goto L_0x045b
        L_0x03b2:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeInt64List(r6, r4, r1)
            goto L_0x045b
        L_0x03bc:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed32List(r6, r4, r1)
            goto L_0x045b
        L_0x03c6:
            java.util.List r4 = listAt(r14, r7)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeFixed64List(r6, r4, r1)
            goto L_0x045b
        L_0x03d0:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.MessageLite r4 = (com.google.protobuf.MessageLite) r4
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.CodedOutputStream.computeGroupSize(r6, r4, r5)
            goto L_0x045b
        L_0x03e6:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r6, r4)
            goto L_0x045b
        L_0x03f5:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r6, r4)
            goto L_0x045b
        L_0x0404:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r6, r11)
            goto L_0x045b
        L_0x040f:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r6, r1)
            goto L_0x045b
        L_0x041a:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeEnumSize(r6, r4)
            goto L_0x045b
        L_0x0429:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r6, r4)
            goto L_0x045b
        L_0x0438:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeBytesSize(r6, r4)
            goto L_0x045b
        L_0x0449:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            com.google.protobuf.Schema r5 = r13.getMessageFieldSchema(r2)
            int r4 = com.google.protobuf.SchemaUtil.computeSizeMessage(r6, r4, r5)
        L_0x045b:
            int r3 = r3 + r4
            goto L_0x04e3
        L_0x045e:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r14, (long) r7)
            boolean r5 = r4 instanceof com.google.protobuf.ByteString
            if (r5 == 0) goto L_0x0473
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeBytesSize(r6, r4)
            goto L_0x0479
        L_0x0473:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.protobuf.CodedOutputStream.computeStringSize(r6, r4)
        L_0x0479:
            int r3 = r3 + r4
            goto L_0x04e3
        L_0x047c:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeBoolSize(r6, r9)
            goto L_0x045b
        L_0x0487:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r6, r1)
            goto L_0x045b
        L_0x0492:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r6, r11)
            goto L_0x045b
        L_0x049d:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeInt32Size(r6, r4)
            goto L_0x045b
        L_0x04ac:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r6, r4)
            goto L_0x045b
        L_0x04bb:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            long r4 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r14, (long) r7)
            int r4 = com.google.protobuf.CodedOutputStream.computeInt64Size(r6, r4)
            goto L_0x045b
        L_0x04ca:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            int r4 = com.google.protobuf.CodedOutputStream.computeFloatSize(r6, r10)
            goto L_0x045b
        L_0x04d5:
            boolean r4 = r13.isFieldPresent(r14, r2)
            if (r4 == 0) goto L_0x04e3
            r4 = 0
            int r4 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r6, r4)
            goto L_0x045b
        L_0x04e3:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x04e7:
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r13.unknownFieldSchema
            int r14 = r13.getUnknownFieldsSerializedSize(r0, r14)
            int r3 = r3 + r14
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.getSerializedSizeProto3(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t));
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt((Object) t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        if ((i & ENFORCE_UTF8_MASK) != 0) {
            return true;
        }
        return false;
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject((Object) t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i) & 1048575);
        if (UnsafeUtil.getInt((Object) t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt((Object) t2, presenceMaskAndOffsetAt)) {
            return true;
        }
        return false;
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        if (UnsafeUtil.getInt((Object) t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i) {
            return true;
        }
        return false;
    }

    private static boolean isRequired(int i) {
        if ((i & REQUIRED_MASK) != 0) {
            return true;
        }
        return false;
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong((Object) t, j);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:98|97|157|174|175|(0)(0)|196|219|211) */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0649, code lost:
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x064d, code lost:
        if (r22.skipField() == false) goto L_0x064f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x064f, code lost:
        r0 = r8.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0654, code lost:
        if (r0 < r8.repeatedFieldOffsetStart) goto L_0x0656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0656, code lost:
        r4 = filterMapUnknownEnumValues(r21, r8.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0669, code lost:
        if (r4 != null) goto L_0x066b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x066b, code lost:
        r14.setBuilderToMessage(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x066f, code lost:
        if (r5 == null) goto L_0x0671;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        r5 = r14.getBuilderFromMessage(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0676, code lost:
        r1 = r14.mergeOneFieldFrom(r5, r0);
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x067a, code lost:
        if (r1 == false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x067c, code lost:
        r0 = r8.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0681, code lost:
        if (r0 < r8.repeatedFieldOffsetStart) goto L_0x0683;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0683, code lost:
        r4 = filterMapUnknownEnumValues(r21, r8.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0696, code lost:
        if (r4 != null) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0698, code lost:
        r14.setBuilderToMessage(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x06a1, code lost:
        r0 = th;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0194, code lost:
        r12 = r5;
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0247, code lost:
        r14 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:174:0x0643 */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0649 A[Catch:{ all -> 0x06a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06b3 A[LOOP:6: B:205:0x06af->B:207:0x06b3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.protobuf.ExtensionSchema<ET> r20, T r21, com.google.protobuf.Reader r22, com.google.protobuf.ExtensionRegistryLite r23) throws java.io.IOException {
        /*
            r18 = this;
            r8 = r18
            r7 = r19
            r15 = r21
            r0 = r22
            r6 = r23
            r17 = 0
            r5 = r17
            r9 = r5
        L_0x000f:
            int r2 = r22.getFieldNumber()     // Catch:{ all -> 0x06a7 }
            int r3 = r8.positionForFieldNumber(r2)     // Catch:{ all -> 0x06a7 }
            if (r3 >= 0) goto L_0x00b9
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x003e
            int r0 = r8.checkInitializedCount
            r4 = r5
        L_0x0021:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0038
            int[] r1 = r8.intArray
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0021
        L_0x0038:
            if (r4 == 0) goto L_0x003d
            r7.setBuilderToMessage(r15, r4)
        L_0x003d:
            return
        L_0x003e:
            boolean r1 = r8.hasExtensions     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x0047
            r4 = r20
            r12 = r17
            goto L_0x0050
        L_0x0047:
            com.google.protobuf.MessageLite r1 = r8.defaultInstance     // Catch:{ all -> 0x00b5 }
            r4 = r20
            java.lang.Object r1 = r4.findExtensionByNumber(r6, r1, r2)     // Catch:{ all -> 0x00b5 }
            r12 = r1
        L_0x0050:
            if (r12 == 0) goto L_0x0071
            if (r9 != 0) goto L_0x005c
            com.google.protobuf.FieldSet r1 = r20.getMutableExtensions(r21)     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r0 = move-exception
            goto L_0x06a9
        L_0x005c:
            r1 = r9
        L_0x005d:
            r9 = r20
            r10 = r21
            r11 = r22
            r13 = r23
            r14 = r1
            r3 = r15
            r15 = r5
            r16 = r19
            java.lang.Object r5 = r9.parseExtension(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00b1 }
            r9 = r1
        L_0x006f:
            r15 = r3
            goto L_0x000f
        L_0x0071:
            r3 = r15
            boolean r1 = r7.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x007f
            boolean r1 = r22.skipField()     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x008d
        L_0x007e:
            goto L_0x006f
        L_0x007f:
            if (r5 != 0) goto L_0x0086
            java.lang.Object r1 = r7.getBuilderFromMessage(r3)     // Catch:{ all -> 0x00b1 }
            r5 = r1
        L_0x0086:
            boolean r1 = r7.mergeOneFieldFrom(r5, r0)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x008d
            goto L_0x007e
        L_0x008d:
            int r0 = r8.checkInitializedCount
            r4 = r5
        L_0x0090:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x00aa
            int[] r1 = r8.intArray
            r5 = r1[r0]
            r1 = r18
            r2 = r21
            r10 = r3
            r3 = r5
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r3 = r10
            goto L_0x0090
        L_0x00aa:
            r10 = r3
            if (r4 == 0) goto L_0x00b0
            r7.setBuilderToMessage(r10, r4)
        L_0x00b0:
            return
        L_0x00b1:
            r0 = move-exception
            r10 = r3
            goto L_0x06a5
        L_0x00b5:
            r0 = move-exception
            r10 = r15
            goto L_0x06a5
        L_0x00b9:
            r4 = r20
            r10 = r15
            int r11 = r8.typeAndOffsetAt(r3)     // Catch:{ all -> 0x06a3 }
            int r1 = type(r11)     // Catch:{ InvalidWireTypeException -> 0x0640 }
            switch(r1) {
                case 0: goto L_0x05fd;
                case 1: goto L_0x05eb;
                case 2: goto L_0x05d9;
                case 3: goto L_0x05c7;
                case 4: goto L_0x05b5;
                case 5: goto L_0x05a2;
                case 6: goto L_0x058f;
                case 7: goto L_0x057c;
                case 8: goto L_0x0571;
                case 9: goto L_0x055c;
                case 10: goto L_0x0549;
                case 11: goto L_0x0536;
                case 12: goto L_0x0510;
                case 13: goto L_0x04fd;
                case 14: goto L_0x04ea;
                case 15: goto L_0x04d7;
                case 16: goto L_0x04c4;
                case 17: goto L_0x04af;
                case 18: goto L_0x049d;
                case 19: goto L_0x048b;
                case 20: goto L_0x0479;
                case 21: goto L_0x0467;
                case 22: goto L_0x0455;
                case 23: goto L_0x0443;
                case 24: goto L_0x0431;
                case 25: goto L_0x041f;
                case 26: goto L_0x0417;
                case 27: goto L_0x0402;
                case 28: goto L_0x03f0;
                case 29: goto L_0x03de;
                case 30: goto L_0x03bd;
                case 31: goto L_0x03ab;
                case 32: goto L_0x0399;
                case 33: goto L_0x0387;
                case 34: goto L_0x0375;
                case 35: goto L_0x0363;
                case 36: goto L_0x0351;
                case 37: goto L_0x033f;
                case 38: goto L_0x032d;
                case 39: goto L_0x031b;
                case 40: goto L_0x0309;
                case 41: goto L_0x02f7;
                case 42: goto L_0x02e5;
                case 43: goto L_0x02d3;
                case 44: goto L_0x02b2;
                case 45: goto L_0x02a0;
                case 46: goto L_0x028e;
                case 47: goto L_0x027c;
                case 48: goto L_0x026a;
                case 49: goto L_0x024a;
                case 50: goto L_0x0235;
                case 51: goto L_0x021e;
                case 52: goto L_0x020a;
                case 53: goto L_0x01f7;
                case 54: goto L_0x01e4;
                case 55: goto L_0x01d1;
                case 56: goto L_0x01be;
                case 57: goto L_0x01ab;
                case 58: goto L_0x0198;
                case 59: goto L_0x018e;
                case 60: goto L_0x017d;
                case 61: goto L_0x016e;
                case 62: goto L_0x015b;
                case 63: goto L_0x0133;
                case 64: goto L_0x0120;
                case 65: goto L_0x010c;
                case 66: goto L_0x00f8;
                case 67: goto L_0x00e4;
                case 68: goto L_0x00d2;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            r12 = r5
            r13 = r6
            r14 = r7
            if (r12 != 0) goto L_0x0619
            java.lang.Object r1 = r14.getBuilderFromMessage(r10)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x0617
        L_0x00d2:
            java.lang.Object r1 = r8.mutableOneofMessageFieldForMerge(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.MessageLite r1 = (com.google.protobuf.MessageLite) r1     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.Schema r11 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r0.mergeGroupField(r1, r11, r6)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.storeOneofMessageField(r10, r2, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x00e4:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x00f8:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x010c:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0120:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0133:
            int r1 = r22.readEnum()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.Internal$EnumVerifier r12 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            if (r12 == 0) goto L_0x014c
            boolean r12 = r12.isInRange(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            if (r12 == 0) goto L_0x0144
            goto L_0x014c
        L_0x0144:
            java.lang.Object r5 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r10, r2, r1, r5, r7)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r13 = r6
            r14 = r7
            goto L_0x069c
        L_0x014c:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x015b:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x016e:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.ByteString r1 = r22.readBytes()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x017d:
            java.lang.Object r1 = r8.mutableOneofMessageFieldForMerge(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.MessageLite r1 = (com.google.protobuf.MessageLite) r1     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.Schema r11 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r0.mergeMessageField(r1, r11, r6)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.storeOneofMessageField(r10, r2, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x018e:
            r8.readString(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
        L_0x0194:
            r12 = r5
            r13 = r6
            goto L_0x0247
        L_0x0198:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            boolean r1 = r22.readBool()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01ab:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01be:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01d1:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.readInt32()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01e4:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01f7:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.readInt64()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x020a:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            float r1 = r22.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x021e:
            long r11 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            double r13 = r22.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Double r1 = java.lang.Double.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r11, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.setOneofPresent(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0232:
            r0 = move-exception
            goto L_0x06a5
        L_0x0235:
            java.lang.Object r11 = r8.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x0640 }
            r1 = r18
            r2 = r21
            r4 = r11
            r12 = r5
            r5 = r23
            r13 = r6
            r6 = r22
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
        L_0x0247:
            r14 = r7
            goto L_0x060e
        L_0x024a:
            r12 = r5
            r13 = r6
            long r4 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
            com.google.protobuf.Schema r6 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
            r1 = r18
            r2 = r21
            r3 = r4
            r5 = r22
            r14 = r7
            r7 = r23
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0263:
            r0 = move-exception
            r14 = r7
            goto L_0x0612
        L_0x0267:
            r14 = r7
            goto L_0x0615
        L_0x026a:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x027c:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x028e:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02a0:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02b2:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r4 = r1.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r21
            r3 = r4
            r4 = r5
            r5 = r12
            r6 = r19
            java.lang.Object r5 = com.google.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (com.google.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x02d3:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02e5:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02f7:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0309:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x031b:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x032d:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x033f:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0351:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0363:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0375:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0387:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0399:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03ab:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03bd:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r4 = r1.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r21
            r3 = r4
            r4 = r5
            r5 = r12
            r6 = r19
            java.lang.Object r5 = com.google.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (com.google.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x03de:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03f0:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0402:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r18
            r2 = r21
            r3 = r11
            r4 = r22
            r6 = r23
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0417:
            r12 = r5
            r13 = r6
            r14 = r7
            r8.readStringList(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x041f:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0431:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0443:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0455:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0467:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0479:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x048b:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x049d:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04af:
            r12 = r5
            r13 = r6
            r14 = r7
            java.lang.Object r1 = r8.mutableMessageFieldForMerge(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.MessageLite r1 = (com.google.protobuf.MessageLite) r1     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.mergeGroupField(r1, r2, r13)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.storeMessageField(r10, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04c4:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04d7:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04ea:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04fd:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0510:
            r12 = r5
            r13 = r6
            r14 = r7
            int r1 = r22.readEnum()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.Internal$EnumVerifier r4 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            if (r4 == 0) goto L_0x052a
            boolean r4 = r4.isInRange(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            if (r4 == 0) goto L_0x0524
            goto L_0x052a
        L_0x0524:
            java.lang.Object r5 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r10, r2, r1, r12, r14)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x052a:
            long r4 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r4, (int) r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0536:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0549:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.ByteString r4 = r22.readBytes()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x055c:
            r12 = r5
            r13 = r6
            r14 = r7
            java.lang.Object r1 = r8.mutableMessageFieldForMerge(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.MessageLite r1 = (com.google.protobuf.MessageLite) r1     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.mergeMessageField(r1, r2, r13)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.storeMessageField(r10, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0571:
            r12 = r5
            r13 = r6
            r14 = r7
            r8.readString(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x057c:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            boolean r4 = r22.readBool()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r10, (long) r1, (boolean) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x058f:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05a2:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05b5:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.readInt32()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05c7:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05d9:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.readInt64()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05eb:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            float r4 = r22.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putFloat((java.lang.Object) r10, (long) r1, (float) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05fd:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = offset(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            double r4 = r22.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.UnsafeUtil.putDouble((java.lang.Object) r10, (long) r1, (double) r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
        L_0x060e:
            r5 = r12
            goto L_0x069c
        L_0x0611:
            r0 = move-exception
        L_0x0612:
            r5 = r12
            goto L_0x06ab
        L_0x0615:
            r5 = r12
            goto L_0x0643
        L_0x0617:
            r5 = r1
            goto L_0x061a
        L_0x0619:
            r5 = r12
        L_0x061a:
            boolean r1 = r14.mergeOneFieldFrom(r5, r0)     // Catch:{ InvalidWireTypeException -> 0x0643 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.checkInitializedCount
            r4 = r5
        L_0x0623:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x063a
            int[] r1 = r8.intArray
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0623
        L_0x063a:
            if (r4 == 0) goto L_0x063f
            r14.setBuilderToMessage(r10, r4)
        L_0x063f:
            return
        L_0x0640:
            r12 = r5
        L_0x0641:
            r13 = r6
            r14 = r7
        L_0x0643:
            boolean r1 = r14.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x06a1 }
            if (r1 == 0) goto L_0x066f
            boolean r1 = r22.skipField()     // Catch:{ all -> 0x06a1 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.checkInitializedCount
            r4 = r5
        L_0x0652:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0669
            int[] r1 = r8.intArray
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0652
        L_0x0669:
            if (r4 == 0) goto L_0x066e
            r14.setBuilderToMessage(r10, r4)
        L_0x066e:
            return
        L_0x066f:
            if (r5 != 0) goto L_0x0676
            java.lang.Object r1 = r14.getBuilderFromMessage(r10)     // Catch:{ all -> 0x06a1 }
            r5 = r1
        L_0x0676:
            boolean r1 = r14.mergeOneFieldFrom(r5, r0)     // Catch:{ all -> 0x06a1 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.checkInitializedCount
            r4 = r5
        L_0x067f:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0696
            int[] r1 = r8.intArray
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x067f
        L_0x0696:
            if (r4 == 0) goto L_0x069b
            r14.setBuilderToMessage(r10, r4)
        L_0x069b:
            return
        L_0x069c:
            r15 = r10
            r6 = r13
            r7 = r14
            goto L_0x000f
        L_0x06a1:
            r0 = move-exception
            goto L_0x06ab
        L_0x06a3:
            r0 = move-exception
            r12 = r5
        L_0x06a5:
            r14 = r7
            goto L_0x06ab
        L_0x06a7:
            r0 = move-exception
            r12 = r5
        L_0x06a9:
            r14 = r7
            r10 = r15
        L_0x06ab:
            int r1 = r8.checkInitializedCount
            r7 = r1
            r4 = r5
        L_0x06af:
            int r1 = r8.repeatedFieldOffsetStart
            if (r7 >= r1) goto L_0x06c6
            int[] r1 = r8.intArray
            r3 = r1[r7]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r7 = r7 + 1
            goto L_0x06af
        L_0x06c6:
            if (r4 == 0) goto L_0x06cb
            r14.setBuilderToMessage(r10, r4)
        L_0x06cb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i);
                if (!isFieldPresent(t, i)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t, offset, newInstance);
                    }
                    setFieldPresent(t, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int numberAt = numberAt(i);
        if (isOneofPresent(t2, numberAt, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i);
                if (!isOneofPresent(t, numberAt, i)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t, offset, newInstance);
                    }
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble((Object) t, offset, UnsafeUtil.getDouble((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat((Object) t, offset, UnsafeUtil.getFloat((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean((Object) t, offset, UnsafeUtil.getBoolean((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 9:
                mergeMessage(t, t2, i);
                return;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 17:
                mergeMessage(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t, t2, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t, t2, i);
                return;
            default:
                return;
        }
    }

    private Object mutableMessageFieldForMerge(T t, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long offset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        boolean z;
        int i;
        int i2;
        int[] iArr;
        int i3;
        if (structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3) {
            z = true;
        } else {
            z = false;
        }
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = fields[0].getFieldNumber();
            i = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i5++;
            }
        }
        int[] iArr3 = null;
        if (i4 > 0) {
            iArr = new int[i4];
        } else {
            iArr = null;
        }
        if (i5 > 0) {
            iArr3 = new int[i5];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fields.length) {
            FieldInfo fieldInfo2 = fields[i6];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i7, objArr);
            if (i8 < checkInitialized.length && checkInitialized[i8] == fieldNumber) {
                checkInitialized[i8] = i7;
                i8++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i9] = i7;
                i9++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i3 = i7;
                iArr3[i10] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr.length + iArr3.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr, 0, iArr4, checkInitialized.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr.length, iArr3.length);
        return new MessageSchema(iArr2, objArr, i2, i, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0369  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo r34, com.google.protobuf.NewInstanceSchema r35, com.google.protobuf.ListFieldSchema r36, com.google.protobuf.UnknownFieldSchema<?, ?> r37, com.google.protobuf.ExtensionSchema<?> r38, com.google.protobuf.MapFieldSchema r39) {
        /*
            com.google.protobuf.ProtoSyntax r0 = r34.getSyntax()
            com.google.protobuf.ProtoSyntax r1 = com.google.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r34.getStringInfo()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0028
            r4 = 1
        L_0x001e:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0029
            r4 = r6
            goto L_0x001e
        L_0x0028:
            r6 = 1
        L_0x0029:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0035:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0045
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0035
        L_0x0045:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0048:
            if (r6 != 0) goto L_0x0058
            int[] r6 = EMPTY_INT_ARRAY
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0162
        L_0x0058:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0077
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0064:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0074
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0064
        L_0x0074:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0077:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0096
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0083:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0093
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0083
        L_0x0093:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0096:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a2:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a2
        L_0x00b2:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b5:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c1:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c1
        L_0x00d1:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d4:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e0:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00f0
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e0
        L_0x00f0:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f3:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0112
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010f
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ff
        L_0x010f:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0112:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0133
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011e:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011e
        L_0x012f:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0133:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0156
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013f:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0151
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013f
        L_0x0151:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0156:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 * 2
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
        L_0x0162:
            sun.misc.Unsafe r15 = UNSAFE
            java.lang.Object[] r17 = r34.getObjects()
            com.google.protobuf.MessageLite r18 = r34.getDefaultInstance()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 * 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r20 = r14 + r12
            r22 = r14
            r23 = r20
            r12 = 0
            r21 = 0
        L_0x0181:
            if (r4 >= r1) goto L_0x03bd
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01a9
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0191:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a3
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0191
        L_0x01a3:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ab
        L_0x01a9:
            r3 = r24
        L_0x01ab:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01d8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01b9:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d2
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01b9
        L_0x01d2:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01dc
        L_0x01d8:
            r28 = r1
            r1 = r24
        L_0x01dc:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01e9
            int r14 = r12 + 1
            r13[r12] = r21
            r12 = r14
        L_0x01e9:
            r14 = 51
            r30 = r12
            if (r5 < r14) goto L_0x0284
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0218
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x01fe:
            int r32 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r12) goto L_0x0213
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r31
            r1 = r1 | r12
            int r31 = r31 + 13
            r14 = r32
            r12 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fe
        L_0x0213:
            int r12 = r14 << r31
            r1 = r1 | r12
            r14 = r32
        L_0x0218:
            int r12 = r5 + -51
            r31 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0238
            r14 = 17
            if (r12 != r14) goto L_0x0225
            goto L_0x0238
        L_0x0225:
            r14 = 12
            if (r12 != r14) goto L_0x0246
            if (r10 != 0) goto L_0x0246
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0244
        L_0x0238:
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0244:
            r16 = r14
        L_0x0246:
            int r1 = r1 * 2
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0251
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0259
        L_0x0251:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = reflectField(r2, r12)
            r17[r1] = r12
        L_0x0259:
            r14 = r8
            r32 = r9
            long r8 = r15.objectFieldOffset(r12)
            int r8 = (int) r8
            int r1 = r1 + 1
            r9 = r17[r1]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x026c
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0274
        L_0x026c:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r2, r9)
            r17[r1] = r9
        L_0x0274:
            r1 = r8
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r9 = r8
            r12 = r10
            r29 = r31
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0380
        L_0x0284:
            r14 = r8
            r32 = r9
            int r8 = r16 + 1
            r9 = r17[r16]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r2, r9)
            r12 = 9
            if (r5 == r12) goto L_0x02fc
            r12 = 17
            if (r5 != r12) goto L_0x029a
            goto L_0x02fc
        L_0x029a:
            r12 = 27
            if (r5 == r12) goto L_0x02eb
            r12 = 49
            if (r5 != r12) goto L_0x02a3
            goto L_0x02eb
        L_0x02a3:
            r12 = 12
            if (r5 == r12) goto L_0x02da
            r12 = 30
            if (r5 == r12) goto L_0x02da
            r12 = 44
            if (r5 != r12) goto L_0x02b0
            goto L_0x02da
        L_0x02b0:
            r12 = 50
            if (r5 != r12) goto L_0x02d0
            int r12 = r22 + 1
            r13[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r22] = r8
            r8 = r3 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d3
            int r22 = r22 + 1
            int r8 = r27 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02d0:
            r25 = 1
            goto L_0x030a
        L_0x02d3:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x030b
        L_0x02da:
            if (r10 != 0) goto L_0x02d0
            int r12 = r21 / 3
            int r12 = r12 * 2
            r25 = 1
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
            goto L_0x02f9
        L_0x02eb:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
        L_0x02f9:
            r12 = r27
            goto L_0x030b
        L_0x02fc:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            java.lang.Class r27 = r9.getType()
            r11[r12] = r27
        L_0x030a:
            r12 = r8
        L_0x030b:
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = r12
            r12 = 4096(0x1000, float:5.74E-42)
            if (r9 != r12) goto L_0x031b
            r9 = r25
            goto L_0x031c
        L_0x031b:
            r9 = 0
        L_0x031c:
            if (r9 == 0) goto L_0x0369
            r9 = 17
            if (r5 > r9) goto L_0x0369
            int r9 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0347
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x0331:
            int r29 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r12) goto L_0x0343
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r26
            r1 = r1 | r9
            int r26 = r26 + 13
            r9 = r29
            goto L_0x0331
        L_0x0343:
            int r9 = r9 << r26
            r1 = r1 | r9
            goto L_0x0349
        L_0x0347:
            r29 = r9
        L_0x0349:
            int r9 = r6 * 2
            int r26 = r1 / 32
            int r26 = r26 + r9
            r9 = r17[r26]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x0358
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0360
        L_0x0358:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r2, r9)
            r17[r26] = r9
        L_0x0360:
            r12 = r10
            long r9 = r15.objectFieldOffset(r9)
            int r9 = (int) r9
            int r1 = r1 % 32
            goto L_0x0370
        L_0x0369:
            r12 = r10
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r1
            r1 = 0
        L_0x0370:
            r10 = 18
            if (r5 < r10) goto L_0x037e
            r10 = 49
            if (r5 > r10) goto L_0x037e
            int r10 = r23 + 1
            r13[r23] = r8
            r23 = r10
        L_0x037e:
            r16 = r27
        L_0x0380:
            int r10 = r21 + 1
            r7[r21] = r4
            int r4 = r10 + 1
            r21 = r0
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x038f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0390
        L_0x038f:
            r0 = 0
        L_0x0390:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0397
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0398
        L_0x0397:
            r3 = 0
        L_0x0398:
            r0 = r0 | r3
            int r3 = r5 << 20
            r0 = r0 | r3
            r0 = r0 | r8
            r7[r10] = r0
            int r0 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r9
            r7[r4] = r1
            r10 = r12
            r8 = r14
            r14 = r24
            r1 = r28
            r4 = r29
            r12 = r30
            r9 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            r33 = r21
            r21 = r0
            r0 = r33
            goto L_0x0181
        L_0x03bd:
            r32 = r9
            r12 = r10
            r24 = r14
            r14 = r8
            com.google.protobuf.MessageSchema r0 = new com.google.protobuf.MessageSchema
            com.google.protobuf.MessageLite r9 = r34.getDefaultInstance()
            r1 = 0
            r4 = r0
            r5 = r7
            r6 = r11
            r7 = r14
            r8 = r32
            r11 = r1
            r12 = r13
            r13 = r24
            r14 = r20
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return (long) (i & 1048575);
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject((Object) t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject((Object) t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject((Object) t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject((Object) t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject((Object) t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        T t2 = t;
        long j2 = j;
        Unsafe unsafe = UNSAFE;
        int i4 = i3;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j2);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t, j2, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = UNSAFE;
        long j3 = (long) (this.buffer[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                    int i14 = i9 + 8;
                    unsafe.putInt(t2, j3, i11);
                    return i14;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                    int i15 = i9 + 4;
                    unsafe.putInt(t2, j3, i11);
                    return i15;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, Long.valueOf(registers2.long1));
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(registers2.int1));
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                    int i16 = i9 + 8;
                    unsafe.putInt(t2, j3, i11);
                    return i16;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                    int i17 = i9 + 4;
                    unsafe.putInt(t2, j3, i11);
                    return i17;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(registers2.long1 != 0));
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint642;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr2, i9, registers2);
                    int i18 = registers2.int1;
                    if (i18 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & ENFORCE_UTF8_MASK) == 0 || Utf8.isValidUtf8(bArr2, decodeVarint322, decodeVarint322 + i18)) {
                        unsafe.putObject(t2, j2, new String(bArr2, decodeVarint322, i18, Internal.UTF_8));
                        decodeVarint322 += i18;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint322;
                }
                break;
            case 60:
                if (i12 == 2) {
                    Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t2, i11, i13);
                    int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i13), bArr, i, i2, registers);
                    storeOneofMessageField(t2, i11, i13, mutableOneofMessageFieldForMerge);
                    return mergeMessageField;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, registers2.object1);
                    unsafe.putInt(t2, j3, i11);
                    return decodeBytes;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr2, i9, registers2);
                    int i19 = registers2.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i13);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i19)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i19));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        getMutableUnknownFields(t).storeField(i10, Long.valueOf((long) i19));
                    }
                    return decodeVarint323;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(CodedInputStream.decodeZigZag32(registers2.int1)));
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint324;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr2, i9, registers2);
                    unsafe.putObject(t2, j2, Long.valueOf(CodedInputStream.decodeZigZag64(registers2.long1)));
                    unsafe.putInt(t2, j3, i11);
                    return decodeVarint643;
                }
                break;
            case 68:
                if (i12 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t2, i11, i13);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i13), bArr, i, i2, (i10 & -8) | 4, registers);
                    storeOneofMessageField(t2, i11, i13, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02e1, code lost:
        if (r0 != r15) goto L_0x029e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0304, code lost:
        if (r0 != r15) goto L_0x029e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0307, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r18 = r32;
        r11 = r34;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        r10 = r4;
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f6, code lost:
        r6 = r6 | r20;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011b, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0196, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01fe, code lost:
        r0 = r10 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0200, code lost:
        r6 = r32 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0202, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0204, code lost:
        r6 = r32;
        r19 = r8;
        r28 = r9;
        r2 = r10;
        r27 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x029c, code lost:
        if (r0 != r15) goto L_0x029e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.protobuf.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseProto3Message(T r30, byte[] r31, int r32, int r33, com.google.protobuf.ArrayDecoders.Registers r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            checkMutable(r30)
            sun.misc.Unsafe r9 = UNSAFE
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r2 = r16
            r6 = r2
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001b:
            if (r0 >= r13) goto L_0x032d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r0, r12, r3, r11)
            int r3 = r11.int1
            r4 = r0
            r17 = r3
            goto L_0x0030
        L_0x002d:
            r17 = r0
            r4 = r3
        L_0x0030:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003d
            int r2 = r2 / 3
            int r0 = r15.positionForFieldNumber(r5, r2)
            goto L_0x0041
        L_0x003d:
            int r0 = r15.positionForFieldNumber(r5)
        L_0x0041:
            r2 = r0
            if (r2 != r8) goto L_0x004f
            r2 = r4
            r18 = r5
            r27 = r8
            r28 = r9
            r19 = r16
            goto L_0x0309
        L_0x004f:
            int[] r0 = r15.buffer
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = type(r1)
            long r10 = offset(r1)
            r8 = 17
            r32 = r5
            if (r0 > r8) goto L_0x020f
            int[] r8 = r15.buffer
            int r20 = r2 + 2
            r8 = r8[r20]
            int r20 = r8 >>> 20
            r5 = 1
            int r20 = r5 << r20
            r22 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            if (r8 == r7) goto L_0x0087
            if (r7 == r10) goto L_0x007f
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007f:
            if (r8 == r10) goto L_0x0086
            long r6 = (long) r8
            int r6 = r9.getInt(r14, r6)
        L_0x0086:
            r7 = r8
        L_0x0087:
            r8 = 5
            switch(r0) {
                case 0: goto L_0x01ea;
                case 1: goto L_0x01d3;
                case 2: goto L_0x01b0;
                case 3: goto L_0x01b0;
                case 4: goto L_0x0199;
                case 5: goto L_0x017a;
                case 6: goto L_0x0163;
                case 7: goto L_0x0140;
                case 8: goto L_0x011f;
                case 9: goto L_0x00fb;
                case 10: goto L_0x00e3;
                case 11: goto L_0x0199;
                case 12: goto L_0x00d0;
                case 13: goto L_0x0163;
                case 14: goto L_0x017a;
                case 15: goto L_0x00b9;
                case 16: goto L_0x0095;
                default: goto L_0x008b;
            }
        L_0x008b:
            r18 = r32
            r11 = r34
            r8 = r2
        L_0x0090:
            r10 = r4
            r32 = r6
            goto L_0x0204
        L_0x0095:
            if (r3 != 0) goto L_0x008b
            r11 = r34
            r0 = r22
            int r8 = com.google.protobuf.ArrayDecoders.decodeVarint64(r12, r4, r11)
            long r3 = r11.long1
            long r4 = com.google.protobuf.CodedInputStream.decodeZigZag64(r3)
            r0 = r9
            r1 = r30
            r17 = r8
            r8 = r2
            r2 = r22
            r18 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r2 = r8
            r0 = r17
            goto L_0x0253
        L_0x00b9:
            r18 = r32
            r11 = r34
            r8 = r2
            if (r3 != 0) goto L_0x0090
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r11)
            int r1 = r11.int1
            int r1 = com.google.protobuf.CodedInputStream.decodeZigZag32(r1)
            r2 = r22
            r9.putInt(r14, r2, r1)
            goto L_0x011b
        L_0x00d0:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            if (r3 != 0) goto L_0x0090
            int r2 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r11)
            int r3 = r11.int1
            r9.putInt(r14, r0, r3)
            goto L_0x00f6
        L_0x00e3:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x0090
            int r2 = com.google.protobuf.ArrayDecoders.decodeBytes(r12, r4, r11)
            java.lang.Object r3 = r11.object1
            r9.putObject(r14, r0, r3)
        L_0x00f6:
            r6 = r6 | r20
            r0 = r2
            goto L_0x0202
        L_0x00fb:
            r18 = r32
            r11 = r34
            r8 = r2
            r2 = 2
            if (r3 != r2) goto L_0x0090
            java.lang.Object r5 = r15.mutableMessageFieldForMerge(r14, r8)
            com.google.protobuf.Schema r1 = r15.getMessageFieldSchema(r8)
            r0 = r5
            r2 = r31
            r3 = r4
            r4 = r33
            r10 = r5
            r5 = r34
            int r0 = com.google.protobuf.ArrayDecoders.mergeMessageField(r0, r1, r2, r3, r4, r5)
            r15.storeMessageField(r14, r8, r10)
        L_0x011b:
            r6 = r6 | r20
            goto L_0x0202
        L_0x011f:
            r18 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            r0 = 2
            if (r3 != r0) goto L_0x0196
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0135
            int r0 = com.google.protobuf.ArrayDecoders.decodeString(r12, r4, r11)
            goto L_0x0139
        L_0x0135:
            int r0 = com.google.protobuf.ArrayDecoders.decodeStringRequireUtf8(r12, r4, r11)
        L_0x0139:
            java.lang.Object r1 = r11.object1
            r9.putObject(r14, r5, r1)
            goto L_0x0200
        L_0x0140:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0196
            int r1 = com.google.protobuf.ArrayDecoders.decodeVarint64(r12, r4, r11)
            long r2 = r11.long1
            r23 = 0
            int r2 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            r0 = r16
        L_0x015b:
            com.google.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r14, (long) r5, (boolean) r0)
            r6 = r32 | r20
            r0 = r1
            goto L_0x0202
        L_0x0163:
            r18 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0196
            int r0 = com.google.protobuf.ArrayDecoders.decodeFixed32(r12, r4)
            r9.putInt(r14, r5, r0)
            int r0 = r4 + 4
            goto L_0x0200
        L_0x017a:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0196
            long r23 = com.google.protobuf.ArrayDecoders.decodeFixed64(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r10 = r4
            r4 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x01fe
        L_0x0196:
            r10 = r4
            goto L_0x0204
        L_0x0199:
            r18 = r32
            r11 = r34
            r8 = r2
            r10 = r4
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0204
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r10, r11)
            int r1 = r11.int1
            r9.putInt(r14, r5, r1)
            goto L_0x0200
        L_0x01b0:
            r18 = r32
            r11 = r34
            r8 = r2
            r10 = r4
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0204
            int r10 = com.google.protobuf.ArrayDecoders.decodeVarint64(r12, r10, r11)
            long r2 = r11.long1
            r0 = r9
            r1 = r30
            r23 = r2
            r2 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            r6 = r32 | r20
            r2 = r8
            r0 = r10
            goto L_0x0253
        L_0x01d3:
            r18 = r32
            r11 = r34
            r10 = r4
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0204
            float r0 = com.google.protobuf.ArrayDecoders.decodeFloat(r12, r10)
            com.google.protobuf.UnsafeUtil.putFloat((java.lang.Object) r14, (long) r5, (float) r0)
            int r0 = r10 + 4
            goto L_0x0200
        L_0x01ea:
            r18 = r32
            r11 = r34
            r8 = r2
            r10 = r4
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0204
            double r0 = com.google.protobuf.ArrayDecoders.decodeDouble(r12, r10)
            com.google.protobuf.UnsafeUtil.putDouble((java.lang.Object) r14, (long) r5, (double) r0)
        L_0x01fe:
            int r0 = r10 + 8
        L_0x0200:
            r6 = r32 | r20
        L_0x0202:
            r2 = r8
            goto L_0x0253
        L_0x0204:
            r6 = r32
            r19 = r8
            r28 = r9
            r2 = r10
            r27 = -1
            goto L_0x0309
        L_0x020f:
            r18 = r32
            r8 = r2
            r20 = r6
            r5 = r10
            r11 = r34
            r10 = r4
            r2 = 27
            if (r0 != r2) goto L_0x0265
            r2 = 2
            if (r3 != r2) goto L_0x0258
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.protobuf.Internal$ProtobufList r0 = (com.google.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x023d
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0234
            r1 = 10
            goto L_0x0236
        L_0x0234:
            int r1 = r1 * 2
        L_0x0236:
            com.google.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r9.putObject(r14, r5, r0)
        L_0x023d:
            r5 = r0
            com.google.protobuf.Schema r0 = r15.getMessageFieldSchema(r8)
            r1 = r17
            r2 = r31
            r3 = r10
            r4 = r33
            r10 = r20
            r6 = r34
            int r0 = com.google.protobuf.ArrayDecoders.decodeMessageList(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r6 = r10
        L_0x0253:
            r1 = r18
            r8 = -1
            goto L_0x001b
        L_0x0258:
            r22 = r7
            r19 = r8
            r28 = r9
            r15 = r10
            r26 = r20
            r27 = -1
            goto L_0x02e4
        L_0x0265:
            r4 = r20
            r2 = 49
            if (r0 > r2) goto L_0x02b2
            long r1 = (long) r1
            r32 = r0
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r23 = r3
            r3 = r10
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r18
            r26 = r15
            r15 = r7
            r7 = r23
            r19 = r8
            r27 = -1
            r28 = r9
            r22 = r15
            r15 = r10
            r9 = r20
            r11 = r32
            r12 = r24
            r14 = r34
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0307
        L_0x029e:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r18
            r2 = r19
            r7 = r22
            r6 = r26
            goto L_0x0327
        L_0x02b2:
            r32 = r0
            r23 = r3
            r26 = r4
            r24 = r5
            r22 = r7
            r19 = r8
            r28 = r9
            r15 = r10
            r27 = -1
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x02ea
            r7 = r23
            r0 = 2
            if (r7 != r0) goto L_0x02e4
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r24
            r8 = r34
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0307
            goto L_0x029e
        L_0x02e4:
            r2 = r15
        L_0x02e5:
            r7 = r22
            r6 = r26
            goto L_0x0309
        L_0x02ea:
            r7 = r23
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r18
            r10 = r24
            r12 = r19
            r13 = r34
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0307
            goto L_0x029e
        L_0x0307:
            r2 = r0
            goto L_0x02e5
        L_0x0309:
            com.google.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r18
            r2 = r19
        L_0x0327:
            r8 = r27
            r9 = r28
            goto L_0x001b
        L_0x032d:
            r26 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0340
            long r1 = (long) r7
            r3 = r30
            r6 = r26
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0340:
            r1 = r33
            if (r0 != r1) goto L_0x0345
            return r0
        L_0x0345:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int i8;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i5;
        int i11 = i6;
        long j3 = j2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j3);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j3, protobufList);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i9, protobufList, registers2);
                }
                if (i10 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i9, protobufList, registers2);
                }
                if (i10 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i9, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 26:
                if (i10 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 27:
                if (i10 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i11), i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 28:
                if (i10 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i10 == 2) {
                    i8 = ArrayDecoders.decodePackedVarint32List(bArr, i9, protobufList, registers2);
                } else if (i10 == 0) {
                    i8 = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t, i4, (List<Integer>) protobufList, getEnumFieldVerifier(i11), null, this.unknownFieldSchema);
                return i8;
            case 33:
            case 47:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i10 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i9, protobufList, registers2);
                }
                if (i10 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 49:
                if (i10 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i11), i3, bArr, i, i2, protobufList, registers);
                }
                break;
        }
        return i9;
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder K = xx.K("Field ", str, " for ");
            K.append(cls.getName());
            K.append(" not found. Known fields are ");
            K.append(Arrays.toString(declaredFields));
            throw new RuntimeException(K.toString());
        }
    }

    private void setFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j != 1048575) {
            UnsafeUtil.putInt((Object) t, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt((Object) t, j));
        }
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt((Object) t, (long) (presenceMaskAndOffsetAt(i2) & 1048575), i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(com.google.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L_0x0022:
            int r0 = (int) r4
            r4 = r1
            goto L_0x006c
        L_0x0025:
            com.google.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L_0x005a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L_0x005a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L_0x004c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0051
        L_0x004c:
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L_0x0051:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L_0x006c
        L_0x005a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L_0x0063
            r0 = r1
            r4 = r0
            goto L_0x006c
        L_0x0063:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L_0x0022
        L_0x006c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L_0x007d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x007e
        L_0x007d:
            r6 = r1
        L_0x007e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L_0x0086
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0086:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto L_0x00be
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto L_0x00af
            int r10 = r10 + 1
            r11[r10] = r9
            goto L_0x00db
        L_0x00af:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            goto L_0x00db
        L_0x00be:
            if (r9 == 0) goto L_0x00c9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto L_0x00db
        L_0x00c9:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t, int i, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto2(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.hasExtensions
            if (r3 == 0) goto L_0x0021
            com.google.protobuf.ExtensionSchema<?> r3 = r0.extensionSchema
            com.google.protobuf.FieldSet r3 = r3.getExtensions(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.buffer
            int r6 = r6.length
            sun.misc.Unsafe r7 = UNSAFE
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r8
            r10 = 0
            r12 = 0
        L_0x002e:
            if (r10 >= r6) goto L_0x048d
            int r13 = r0.typeAndOffsetAt(r10)
            int r14 = r0.numberAt(r10)
            int r15 = type(r13)
            r4 = 17
            if (r15 > r4) goto L_0x0056
            int[] r4 = r0.buffer
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0050
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0050:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x0075
            com.google.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            int r9 = r9.extensionNumber(r5)
            if (r9 > r14) goto L_0x0075
            com.google.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            r9.serializeExtension(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0057
        L_0x0073:
            r5 = 0
            goto L_0x0057
        L_0x0075:
            long r8 = offset(r13)
            switch(r15) {
                case 0: goto L_0x047b;
                case 1: goto L_0x046f;
                case 2: goto L_0x0463;
                case 3: goto L_0x0457;
                case 4: goto L_0x044b;
                case 5: goto L_0x043f;
                case 6: goto L_0x0433;
                case 7: goto L_0x0427;
                case 8: goto L_0x041b;
                case 9: goto L_0x040a;
                case 10: goto L_0x03fb;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03e1;
                case 13: goto L_0x03d4;
                case 14: goto L_0x03c7;
                case 15: goto L_0x03ba;
                case 16: goto L_0x03ad;
                case 17: goto L_0x039c;
                case 18: goto L_0x038c;
                case 19: goto L_0x037c;
                case 20: goto L_0x036c;
                case 21: goto L_0x035c;
                case 22: goto L_0x034c;
                case 23: goto L_0x033c;
                case 24: goto L_0x032c;
                case 25: goto L_0x031c;
                case 26: goto L_0x030d;
                case 27: goto L_0x02fa;
                case 28: goto L_0x02eb;
                case 29: goto L_0x02db;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bb;
                case 32: goto L_0x02ab;
                case 33: goto L_0x029b;
                case 34: goto L_0x028b;
                case 35: goto L_0x027b;
                case 36: goto L_0x026b;
                case 37: goto L_0x025b;
                case 38: goto L_0x024b;
                case 39: goto L_0x023b;
                case 40: goto L_0x022b;
                case 41: goto L_0x021b;
                case 42: goto L_0x020b;
                case 43: goto L_0x01fb;
                case 44: goto L_0x01eb;
                case 45: goto L_0x01db;
                case 46: goto L_0x01cb;
                case 47: goto L_0x01bb;
                case 48: goto L_0x01ab;
                case 49: goto L_0x0198;
                case 50: goto L_0x018f;
                case 51: goto L_0x0180;
                case 52: goto L_0x0171;
                case 53: goto L_0x0162;
                case 54: goto L_0x0153;
                case 55: goto L_0x0144;
                case 56: goto L_0x0135;
                case 57: goto L_0x0126;
                case 58: goto L_0x0117;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d7;
                case 63: goto L_0x00c9;
                case 64: goto L_0x00bb;
                case 65: goto L_0x00ad;
                case 66: goto L_0x009f;
                case 67: goto L_0x0091;
                case 68: goto L_0x007f;
                default: goto L_0x007c;
            }
        L_0x007c:
            r13 = 0
            goto L_0x0486
        L_0x007f:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x007c
        L_0x0091:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x007c
        L_0x009f:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x007c
        L_0x00ad:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x007c
        L_0x00bb:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x007c
        L_0x00c9:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x007c
        L_0x00d7:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x007c
        L_0x00e5:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x007c
        L_0x00f5:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x007c
        L_0x0108:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x007c
        L_0x0117:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            boolean r4 = oneofBooleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x007c
        L_0x0126:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x007c
        L_0x0135:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x007c
        L_0x0144:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x007c
        L_0x0153:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x007c
        L_0x0162:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x007c
        L_0x0171:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            float r4 = oneofFloatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x007c
        L_0x0180:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            double r8 = oneofDoubleAt(r1, r8)
            r2.writeDouble(r14, r8)
            goto L_0x007c
        L_0x018f:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeMapHelper(r2, r14, r4, r10)
            goto L_0x007c
        L_0x0198:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            com.google.protobuf.SchemaUtil.writeGroupList(r4, r8, r2, r9)
            goto L_0x007c
        L_0x01ab:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 1
            com.google.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01bb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01cb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01db:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01eb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01fb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x020b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x021b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x022b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x023b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x024b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x025b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x026b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x027b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x028b:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x029b:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02ab:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02bb:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02cb:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02db:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02eb:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeBytesList(r4, r8, r2)
            goto L_0x007c
        L_0x02fa:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            com.google.protobuf.SchemaUtil.writeMessageList(r4, r8, r2, r9)
            goto L_0x007c
        L_0x030d:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeStringList(r4, r8, r2)
            goto L_0x007c
        L_0x031c:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x032c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x033c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x034c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x035c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x036c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x037c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x038c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x039c:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x0486
        L_0x03ad:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x0486
        L_0x03ba:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x0486
        L_0x03d4:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x0486
        L_0x040a:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x0486
        L_0x041b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x0486
        L_0x0427:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            boolean r4 = booleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x0486
        L_0x0433:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x0486
        L_0x043f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x0486
        L_0x044b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x0486
        L_0x0457:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x0486
        L_0x0463:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x0486
        L_0x046f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            float r4 = floatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x0486
        L_0x047b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            double r8 = doubleAt(r1, r8)
            r2.writeDouble(r14, r8)
        L_0x0486:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x002e
        L_0x048d:
            if (r5 == 0) goto L_0x04a4
            com.google.protobuf.ExtensionSchema<?> r4 = r0.extensionSchema
            r4.serializeExtension(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a2
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048d
        L_0x04a2:
            r5 = 0
            goto L_0x048d
        L_0x04a4:
            com.google.protobuf.UnknownFieldSchema<?, ?> r3 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.protobuf.ExtensionSchema<?> r0 = r12.extensionSchema
            com.google.protobuf.FieldSet r0 = r0.getExtensions(r13)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.buffer
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.typeAndOffsetAt(r5)
            int r7 = r12.numberAt(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            int r8 = r8.extensionNumber(r2)
            if (r8 > r7) goto L_0x004b
            com.google.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            r8.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = type(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = oneofBooleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = oneofFloatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = oneofDoubleAt(r13, r8)
            r14.writeDouble(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeMapHelper(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            com.google.protobuf.SchemaUtil.writeGroupList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeBytesList(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            com.google.protobuf.SchemaUtil.writeMessageList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeStringList(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = booleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = floatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = doubleAt(r13, r8)
            r14.writeDouble(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            com.google.protobuf.ExtensionSchema<?> r3 = r12.extensionSchema
            r3.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r12.unknownFieldSchema
            r12.writeUnknownInMessageTo(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            com.google.protobuf.FieldSet r0 = r0.getExtensions(r11)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.buffer
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.typeAndOffsetAt(r3)
            int r5 = r10.numberAt(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.extensionNumber(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.serializeExtension(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = type(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = oneofBooleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = oneofFloatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = oneofDoubleAt(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            com.google.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            com.google.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = booleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = floatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = doubleAt(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            com.google.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.serializeExtension(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    public int getSerializedSize(T t) {
        if (this.proto3) {
            return getSerializedSizeProto3(t);
        }
        return getSerializedSizeProto2(t);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01be, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f2, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0223, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0225, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.buffer
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x0229
            int r3 = r8.typeAndOffsetAt(r1)
            int r4 = r8.numberAt(r1)
            long r5 = offset(r3)
            int r3 = type(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0215;
                case 1: goto L_0x020a;
                case 2: goto L_0x01ff;
                case 3: goto L_0x01f4;
                case 4: goto L_0x01ec;
                case 5: goto L_0x01e1;
                case 6: goto L_0x01da;
                case 7: goto L_0x01cf;
                case 8: goto L_0x01c2;
                case 9: goto L_0x01b4;
                case 10: goto L_0x01a8;
                case 11: goto L_0x01a1;
                case 12: goto L_0x019a;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0225
        L_0x001e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x0030:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0042:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x0050:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0062:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x0070:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x007e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x008c:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x009e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x00b0:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x00c4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashBoolean(r3)
            goto L_0x0223
        L_0x00d6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x00e4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x00f6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x01f2
        L_0x0104:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0116:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0128:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            float r3 = oneofFloatAt(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0223
        L_0x013a:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0225
            int r2 = r2 * 53
            double r3 = oneofDoubleAt(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x0168:
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01be
            int r7 = r3.hashCode()
            goto L_0x01be
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x01f2
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x01f2
        L_0x019a:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x01f2
        L_0x01a1:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x01f2
        L_0x01a8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x01b4:
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01be
            int r7 = r3.hashCode()
        L_0x01be:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0225
        L_0x01c2:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0223
        L_0x01cf:
            int r2 = r2 * 53
            boolean r3 = com.google.protobuf.UnsafeUtil.getBoolean((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashBoolean(r3)
            goto L_0x0223
        L_0x01da:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x01f2
        L_0x01e1:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x01ec:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
        L_0x01f2:
            int r2 = r2 + r3
            goto L_0x0225
        L_0x01f4:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x01ff:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0223
        L_0x020a:
            int r2 = r2 * 53
            float r3 = com.google.protobuf.UnsafeUtil.getFloat((java.lang.Object) r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0223
        L_0x0215:
            int r2 = r2 * 53
            double r3 = com.google.protobuf.UnsafeUtil.getDouble((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
        L_0x0223:
            int r3 = r3 + r2
            r2 = r3
        L_0x0225:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0229:
            int r2 = r2 * 53
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.getFromMessage(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.hasExtensions
            if (r1 == 0) goto L_0x0247
            int r0 = r0 * 53
            com.google.protobuf.ExtensionSchema<?> r1 = r8.extensionSchema
            com.google.protobuf.FieldSet r9 = r1.getExtensions(r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x0247:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isInitialized(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int numberAt = numberAt(i6);
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = UNSAFE.getInt(t2, (long) i8);
                }
                i = i4;
                i2 = i8;
            } else {
                i2 = i3;
                i = i4;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t, i6, i2, i, i9)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t2, numberAt, i6) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t2, typeAndOffsetAt, i6)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t2, typeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (isFieldPresent(t, i6, i2, i, i9) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t2).isInitialized();
    }

    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    switch (type) {
                        case 17:
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.listFieldSchema.makeImmutableListAt(t, offset);
                            continue;
                        case 50:
                            Unsafe unsafe = UNSAFE;
                            Object object = unsafe.getObject(t, offset);
                            if (object != null) {
                                unsafe.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                if (isFieldPresent(t, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.protobuf.UnknownFieldSetLite} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0339, code lost:
        if (r0 != r15) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x037c, code lost:
        if (r0 != r15) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x039f, code lost:
        if (r0 != r15) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03a2, code lost:
        r8 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0260, code lost:
        r5 = r11 | r17;
        r11 = r31;
        r2 = r6;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027d, code lost:
        r0 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0299, code lost:
        r5 = r11 | r17;
        r11 = r31;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x029e, code lost:
        r3 = r12;
        r1 = r22;
        r6 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a3, code lost:
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a6, code lost:
        r17 = r29;
        r8 = r31;
        r2 = r3;
        r20 = r6;
        r25 = r10;
        r19 = r11;
        r9 = r12;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.protobuf.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseProto2Message(T r27, byte[] r28, int r29, int r30, int r31, com.google.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r26 = this;
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            checkMutable(r27)
            sun.misc.Unsafe r10 = UNSAFE
            r16 = 0
            r0 = r29
            r2 = r16
            r3 = r2
            r5 = r3
            r1 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r0 >= r13) goto L_0x03fd
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r0, r12, r3, r9)
            int r3 = r9.int1
            r4 = r3
            r3 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r1) goto L_0x003c
            int r2 = r2 / r7
            int r1 = r15.positionForFieldNumber(r0, r2)
            goto L_0x0040
        L_0x003c:
            int r1 = r15.positionForFieldNumber(r0)
        L_0x0040:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0055
            r22 = r0
            r18 = r1
            r2 = r3
            r9 = r4
            r19 = r5
            r17 = r6
            r25 = r10
            r8 = r11
            r20 = r16
            goto L_0x03a6
        L_0x0055:
            int[] r1 = r15.buffer
            int r19 = r2 + 1
            r1 = r1[r19]
            int r7 = type(r1)
            long r11 = offset(r1)
            r19 = r4
            r4 = 17
            r20 = r11
            if (r7 > r4) goto L_0x02b4
            int[] r4 = r15.buffer
            int r12 = r2 + 2
            r4 = r4[r12]
            int r12 = r4 >>> 20
            r11 = 1
            int r12 = r11 << r12
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r11
            r17 = r12
            if (r4 == r6) goto L_0x008c
            if (r6 == r11) goto L_0x0084
            long r11 = (long) r6
            r10.putInt(r14, r11, r5)
        L_0x0084:
            long r5 = (long) r4
            int r5 = r10.getInt(r14, r5)
            r12 = r4
            r11 = r5
            goto L_0x008e
        L_0x008c:
            r11 = r5
            r12 = r6
        L_0x008e:
            r4 = 5
            switch(r7) {
                case 0: goto L_0x0280;
                case 1: goto L_0x0267;
                case 2: goto L_0x0240;
                case 3: goto L_0x0240;
                case 4: goto L_0x0226;
                case 5: goto L_0x0203;
                case 6: goto L_0x01eb;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01a2;
                case 9: goto L_0x017c;
                case 10: goto L_0x0161;
                case 11: goto L_0x0226;
                case 12: goto L_0x0123;
                case 13: goto L_0x01eb;
                case 14: goto L_0x0203;
                case 15: goto L_0x0105;
                case 16: goto L_0x00e1;
                case 17: goto L_0x009f;
                default: goto L_0x0092;
            }
        L_0x0092:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            goto L_0x02a6
        L_0x009f:
            r5 = 3
            if (r8 != r5) goto L_0x00d4
            java.lang.Object r7 = r15.mutableMessageFieldForMerge(r14, r2)
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.protobuf.Schema r1 = r15.getMessageFieldSchema(r2)
            r22 = r0
            r0 = r7
            r18 = -1
            r8 = r2
            r2 = r28
            r6 = r19
            r4 = r30
            r29 = r12
            r12 = r6
            r6 = r32
            int r0 = com.google.protobuf.ArrayDecoders.mergeGroupField(r0, r1, r2, r3, r4, r5, r6)
            r15.storeMessageField(r14, r8, r7)
            r5 = r11 | r17
            r6 = r29
            r11 = r31
            r2 = r8
            r3 = r12
            r1 = r22
            r12 = r28
            goto L_0x001d
        L_0x00d4:
            r22 = r0
            r29 = r12
            r12 = r19
            r18 = -1
            r7 = r28
            r6 = r2
            goto L_0x02a6
        L_0x00e1:
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            r7 = r28
            if (r8 != 0) goto L_0x02a6
            r4 = r20
            int r8 = com.google.protobuf.ArrayDecoders.decodeVarint64(r7, r3, r9)
            long r0 = r9.long1
            long r19 = com.google.protobuf.CodedInputStream.decodeZigZag64(r0)
            r0 = r10
            r1 = r27
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x0260
        L_0x0105:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r8 != 0) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r7, r3, r9)
            int r1 = r9.int1
            int r1 = com.google.protobuf.CodedInputStream.decodeZigZag32(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x0299
        L_0x0123:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r8 != 0) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r7, r3, r9)
            int r1 = r9.int1
            com.google.protobuf.Internal$EnumVerifier r2 = r15.getEnumFieldVerifier(r6)
            if (r2 == 0) goto L_0x015c
            boolean r2 = r2.isInRange(r1)
            if (r2 == 0) goto L_0x0145
            goto L_0x015c
        L_0x0145:
            com.google.protobuf.UnknownFieldSetLite r2 = getMutableUnknownFields(r27)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.storeField(r12, r1)
            r2 = r6
            r5 = r11
            r3 = r12
            r1 = r22
            r6 = r29
            r11 = r31
            goto L_0x02a3
        L_0x015c:
            r10.putInt(r14, r4, r1)
            goto L_0x0299
        L_0x0161:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r0 = 2
            r18 = -1
            if (r8 != r0) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeBytes(r7, r3, r9)
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r4, r1)
            goto L_0x0299
        L_0x017c:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r0 = 2
            r18 = -1
            if (r8 != r0) goto L_0x02a6
            java.lang.Object r8 = r15.mutableMessageFieldForMerge(r14, r6)
            com.google.protobuf.Schema r1 = r15.getMessageFieldSchema(r6)
            r0 = r8
            r2 = r28
            r4 = r30
            r5 = r32
            int r0 = com.google.protobuf.ArrayDecoders.mergeMessageField(r0, r1, r2, r3, r4, r5)
            r15.storeMessageField(r14, r6, r8)
            goto L_0x0299
        L_0x01a2:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r0 = 2
            r18 = -1
            if (r8 != r0) goto L_0x02a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01bc
            int r0 = com.google.protobuf.ArrayDecoders.decodeString(r7, r3, r9)
            goto L_0x01c0
        L_0x01bc:
            int r0 = com.google.protobuf.ArrayDecoders.decodeStringRequireUtf8(r7, r3, r9)
        L_0x01c0:
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r4, r1)
            goto L_0x0299
        L_0x01c7:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r8 != 0) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint64(r7, r3, r9)
            long r1 = r9.long1
            r19 = 0
            int r1 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01e4
            r1 = 1
            goto L_0x01e6
        L_0x01e4:
            r1 = r16
        L_0x01e6:
            com.google.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r14, (long) r4, (boolean) r1)
            goto L_0x0299
        L_0x01eb:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r1 = r20
            r18 = -1
            if (r8 != r4) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeFixed32(r7, r3)
            r10.putInt(r14, r1, r0)
            goto L_0x027d
        L_0x0203:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r1 = r20
            r0 = 1
            r18 = -1
            if (r8 != r0) goto L_0x02a6
            long r4 = com.google.protobuf.ArrayDecoders.decodeFixed64(r7, r3)
            r0 = r10
            r20 = r1
            r1 = r27
            r8 = r3
            r2 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0299
        L_0x0226:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            if (r8 != 0) goto L_0x02a6
            int r0 = com.google.protobuf.ArrayDecoders.decodeVarint32(r7, r3, r9)
            int r1 = r9.int1
            r4 = r20
            r10.putInt(r14, r4, r1)
            goto L_0x0299
        L_0x0240:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r8 != 0) goto L_0x02a6
            int r8 = com.google.protobuf.ArrayDecoders.decodeVarint64(r7, r3, r9)
            long r2 = r9.long1
            r0 = r10
            r1 = r27
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x0260:
            r5 = r11 | r17
            r11 = r31
            r2 = r6
            r0 = r8
            goto L_0x029e
        L_0x0267:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r0 = r20
            r18 = -1
            if (r8 != r4) goto L_0x02a6
            float r2 = com.google.protobuf.ArrayDecoders.decodeFloat(r7, r3)
            com.google.protobuf.UnsafeUtil.putFloat((java.lang.Object) r14, (long) r0, (float) r2)
        L_0x027d:
            int r0 = r3 + 4
            goto L_0x0299
        L_0x0280:
            r7 = r28
            r22 = r0
            r6 = r2
            r29 = r12
            r12 = r19
            r0 = r20
            r2 = 1
            r18 = -1
            if (r8 != r2) goto L_0x02a6
            double r4 = com.google.protobuf.ArrayDecoders.decodeDouble(r7, r3)
            com.google.protobuf.UnsafeUtil.putDouble((java.lang.Object) r14, (long) r0, (double) r4)
            int r0 = r3 + 8
        L_0x0299:
            r5 = r11 | r17
            r11 = r31
            r2 = r6
        L_0x029e:
            r3 = r12
            r1 = r22
            r6 = r29
        L_0x02a3:
            r12 = r7
            goto L_0x001d
        L_0x02a6:
            r17 = r29
            r8 = r31
            r2 = r3
            r20 = r6
            r25 = r10
            r19 = r11
            r9 = r12
            goto L_0x03a6
        L_0x02b4:
            r22 = r0
            r11 = r2
            r17 = r6
            r12 = r19
            r18 = -1
            r19 = r5
            r5 = r20
            r0 = 27
            if (r7 != r0) goto L_0x030d
            r0 = 2
            if (r8 != r0) goto L_0x0304
            java.lang.Object r0 = r10.getObject(r14, r5)
            com.google.protobuf.Internal$ProtobufList r0 = (com.google.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x02e6
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02dd
            r1 = 10
            goto L_0x02df
        L_0x02dd:
            int r1 = r1 * 2
        L_0x02df:
            com.google.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r10.putObject(r14, r5, r0)
        L_0x02e6:
            r5 = r0
            com.google.protobuf.Schema r0 = r15.getMessageFieldSchema(r11)
            r1 = r12
            r2 = r28
            r4 = r30
            r6 = r32
            int r0 = com.google.protobuf.ArrayDecoders.decodeMessageList(r0, r1, r2, r3, r4, r5, r6)
            r2 = r11
            r3 = r12
            r6 = r17
            r5 = r19
            r1 = r22
            r12 = r28
            r11 = r31
            goto L_0x001d
        L_0x0304:
            r15 = r3
            r25 = r10
            r20 = r11
            r21 = r12
            goto L_0x037f
        L_0x030d:
            r0 = 49
            if (r7 > r0) goto L_0x0355
            long r1 = (long) r1
            r0 = r26
            r20 = r1
            r1 = r27
            r2 = r28
            r4 = r3
            r15 = r4
            r4 = r30
            r23 = r5
            r5 = r12
            r6 = r22
            r29 = r7
            r7 = r8
            r8 = r11
            r25 = r10
            r9 = r20
            r20 = r11
            r11 = r29
            r21 = r12
            r12 = r23
            r14 = r32
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x03a2
        L_0x033b:
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            r6 = r17
            r5 = r19
            r2 = r20
            r3 = r21
            r1 = r22
            r10 = r25
            goto L_0x001d
        L_0x0355:
            r15 = r3
            r23 = r5
            r29 = r7
            r25 = r10
            r20 = r11
            r21 = r12
            r0 = 50
            r9 = r29
            if (r9 != r0) goto L_0x0385
            r0 = 2
            if (r8 != r0) goto L_0x037f
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r20
            r6 = r23
            r8 = r32
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03a2
            goto L_0x033b
        L_0x037f:
            r8 = r31
            r2 = r15
        L_0x0382:
            r9 = r21
            goto L_0x03a6
        L_0x0385:
            r0 = r26
            r10 = r1
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r21
            r6 = r22
            r7 = r8
            r8 = r10
            r10 = r23
            r12 = r20
            r13 = r32
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03a2
            goto L_0x033b
        L_0x03a2:
            r8 = r31
            r2 = r0
            goto L_0x0382
        L_0x03a6:
            if (r9 != r8) goto L_0x03b6
            if (r8 == 0) goto L_0x03b6
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r26
            r6 = r2
            r0 = r17
            r5 = r19
            goto L_0x040c
        L_0x03b6:
            r10 = r26
            boolean r0 = r10.hasExtensions
            r11 = r32
            if (r0 == 0) goto L_0x03d8
            com.google.protobuf.ExtensionRegistryLite r0 = r11.extensionRegistry
            com.google.protobuf.ExtensionRegistryLite r1 = com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r0 == r1) goto L_0x03d8
            com.google.protobuf.MessageLite r5 = r10.defaultInstance
            com.google.protobuf.UnknownFieldSchema<?, ?> r6 = r10.unknownFieldSchema
            r0 = r9
            r1 = r28
            r3 = r30
            r4 = r27
            r7 = r32
            int r0 = com.google.protobuf.ArrayDecoders.decodeExtensionOrUnknownField(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x03e7
        L_0x03d8:
            com.google.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r27)
            r0 = r9
            r1 = r28
            r3 = r30
            r5 = r32
            int r0 = com.google.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
        L_0x03e7:
            r14 = r27
            r12 = r28
            r13 = r30
            r3 = r9
            r15 = r10
            r9 = r11
            r6 = r17
            r5 = r19
            r2 = r20
            r1 = r22
            r10 = r25
            r11 = r8
            goto L_0x001d
        L_0x03fd:
            r19 = r5
            r17 = r6
            r25 = r10
            r8 = r11
            r10 = r15
            r6 = r0
            r9 = r3
            r0 = r17
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x040c:
            if (r0 == r1) goto L_0x0417
            long r0 = (long) r0
            r7 = r27
            r2 = r25
            r2.putInt(r7, r0, r5)
            goto L_0x0419
        L_0x0417:
            r7 = r27
        L_0x0419:
            int r0 = r10.checkInitializedCount
            r1 = 0
            r11 = r0
            r3 = r1
        L_0x041e:
            int r0 = r10.repeatedFieldOffsetStart
            if (r11 >= r0) goto L_0x0438
            int[] r0 = r10.intArray
            r2 = r0[r11]
            com.google.protobuf.UnknownFieldSchema<?, ?> r4 = r10.unknownFieldSchema
            r0 = r26
            r1 = r27
            r5 = r27
            java.lang.Object r0 = r0.filterMapUnknownEnumValues(r1, r2, r3, r4, r5)
            r3 = r0
            com.google.protobuf.UnknownFieldSetLite r3 = (com.google.protobuf.UnknownFieldSetLite) r3
            int r11 = r11 + 1
            goto L_0x041e
        L_0x0438:
            if (r3 == 0) goto L_0x043f
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r0.setBuilderToMessage(r7, r3)
        L_0x043f:
            if (r8 != 0) goto L_0x044b
            r0 = r30
            if (r6 != r0) goto L_0x0446
            goto L_0x0451
        L_0x0446:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x044b:
            r0 = r30
            if (r6 > r0) goto L_0x0452
            if (r9 != r8) goto L_0x0452
        L_0x0451:
            return r6
        L_0x0452:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    private boolean isFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j == 1048575) {
            int typeAndOffsetAt = typeAndOffsetAt(i);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.getDouble((Object) t, offset)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.getFloat((Object) t, offset)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (UnsafeUtil.getLong((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (UnsafeUtil.getLong((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (UnsafeUtil.getLong((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return UnsafeUtil.getBoolean((Object) t, offset);
                case 8:
                    Object object = UnsafeUtil.getObject((Object) t, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.getObject((Object) t, offset) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject((Object) t, offset));
                case 11:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (UnsafeUtil.getLong((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (UnsafeUtil.getInt((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (UnsafeUtil.getLong((Object) t, offset) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (UnsafeUtil.getObject((Object) t, offset) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((UnsafeUtil.getInt((Object) t, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t, t2, i) || Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t, offset)) != Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 1:
                if (!arePresentForEquals(t, t2, i) || Float.floatToIntBits(UnsafeUtil.getFloat((Object) t, offset)) != Float.floatToIntBits(UnsafeUtil.getFloat((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 2:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong((Object) t, offset) != UnsafeUtil.getLong((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 3:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong((Object) t, offset) != UnsafeUtil.getLong((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 4:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 5:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong((Object) t, offset) != UnsafeUtil.getLong((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 6:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 7:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getBoolean((Object) t, offset) != UnsafeUtil.getBoolean((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 8:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 9:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 10:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 11:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 12:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 13:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 14:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong((Object) t, offset) != UnsafeUtil.getLong((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 15:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt((Object) t, offset) != UnsafeUtil.getInt((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 16:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong((Object) t, offset) != UnsafeUtil.getLong((Object) t2, offset)) {
                    return false;
                }
                return true;
            case 17:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }
}
