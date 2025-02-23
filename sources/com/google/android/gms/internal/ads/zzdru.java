package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdru {
    public static final zzfxr zza;
    public static final zzfxr zzb;
    private final String zzc;
    private final zzdrt zzd;
    private final zzdrt zze;

    static {
        zzdrt zzdrt = zzdrt.PUBLIC_API_CALL;
        zzdrt zzdrt2 = zzdrt.PUBLIC_API_CALLBACK;
        zzdru zzdru = new zzdru("tqgt", zzdrt, zzdrt2);
        zzdrt zzdrt3 = zzdrt.DYNAMITE_ENTER;
        zzdru zzdru2 = new zzdru("l.dl", zzdrt, zzdrt3);
        zzdrt zzdrt4 = zzdrt.CLIENT_SIGNALS_START;
        zzdru zzdru3 = new zzdru("l.rcc", zzdrt3, zzdrt4);
        zzdrt zzdrt5 = zzdrt.CLIENT_SIGNALS_END;
        zzdru zzdru4 = new zzdru("l.cs", zzdrt4, zzdrt5);
        zzdrt zzdrt6 = zzdrt.SERVICE_CONNECTED;
        zzdru zzdru5 = new zzdru("l.cts", zzdrt5, zzdrt6);
        zzdrt zzdrt7 = zzdrt5;
        zzdrt zzdrt8 = zzdrt.GMS_SIGNALS_START;
        zzdrt zzdrt9 = zzdrt4;
        zzdrt zzdrt10 = zzdrt.GMS_SIGNALS_END;
        zzdru zzdru6 = new zzdru("l.gs", zzdrt8, zzdrt10);
        zzdrt zzdrt11 = zzdrt6;
        zzdrt zzdrt12 = zzdrt.GET_SIGNALS_SDKCORE_START;
        zzdru zzdru7 = new zzdru("l.jse", zzdrt10, zzdrt12);
        zzdrt zzdrt13 = zzdrt.GET_SIGNALS_SDKCORE_END;
        zzdrt zzdrt14 = zzdrt10;
        zzdru zzdru8 = new zzdru("l.gs-sdkcore", zzdrt12, zzdrt13);
        zzdru zzdru9 = new zzdru("l.gs-pp", zzdrt13, zzdrt2);
        zzdrt zzdrt15 = zzdrt8;
        zzdrt zzdrt16 = zzdrt11;
        zza = zzfxr.zzs(zzdru, zzdru2, zzdru3, zzdru4, zzdru5, zzdru6, zzdru7, zzdru8, zzdru9);
        zzdru zzdru10 = new zzdru("l.al", zzdrt, zzdrt2);
        zzdru zzdru11 = new zzdru("l.dl", zzdrt, zzdrt3);
        zzdrt zzdrt17 = zzdrt9;
        zzdru zzdru12 = new zzdru("l.rcc", zzdrt3, zzdrt17);
        zzdrt zzdrt18 = zzdrt7;
        zzdru zzdru13 = new zzdru("l.cs", zzdrt17, zzdrt18);
        zzdru zzdru14 = new zzdru("l.cts", zzdrt18, zzdrt16);
        zzdrt zzdrt19 = zzdrt14;
        zzdru zzdru15 = new zzdru("l.gs", zzdrt15, zzdrt19);
        zzdrt zzdrt20 = zzdrt.GET_AD_DICTIONARY_SDKCORE_START;
        zzdru zzdru16 = new zzdru("l.jse", zzdrt19, zzdrt20);
        zzdrt zzdrt21 = zzdrt.GET_AD_DICTIONARY_SDKCORE_END;
        zzdru zzdru17 = new zzdru("l.gad-js", zzdrt20, zzdrt21);
        zzdrt zzdrt22 = zzdrt.HTTP_RESPONSE_READY;
        zzb = zzfxr.zzt(zzdru10, zzdru11, zzdru12, zzdru13, zzdru14, zzdru15, zzdru16, zzdru17, new zzdru("l.http", zzdrt21, zzdrt22), new zzdru("l.nml-js", zzdrt22, zzdrt.SERVER_RESPONSE_PARSE_START));
    }

    public zzdru(String str, zzdrt zzdrt, zzdrt zzdrt2) {
        this.zzc = str;
        this.zzd = zzdrt;
        this.zze = zzdrt2;
    }

    public final zzdrt zza() {
        return this.zzd;
    }

    public final zzdrt zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
