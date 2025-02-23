package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public enum zzhbf {
    DOUBLE(zzhbg.DOUBLE, 1),
    FLOAT(zzhbg.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzhbg.BOOLEAN, 0),
    STRING(zzhbg.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzhbg.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzhbg.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzhbg zzt;

    private zzhbf(zzhbg zzhbg, int i) {
        this.zzt = zzhbg;
    }

    public final zzhbg zza() {
        return this.zzt;
    }
}
