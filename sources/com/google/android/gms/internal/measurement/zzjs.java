package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public class zzjs extends IOException {
    public zzjs(String str) {
        super(str);
    }

    public static zzjv zza() {
        return new zzjv("Protocol message tag had invalid wire type.");
    }

    public static zzjs zzb() {
        return new zzjs("Protocol message end-group tag did not match expected tag.");
    }

    public static zzjs zzc() {
        return new zzjs("Protocol message contained an invalid tag (zero).");
    }

    public static zzjs zzd() {
        return new zzjs("Protocol message had invalid UTF-8.");
    }

    public static zzjs zze() {
        return new zzjs("CodedInputStream encountered a malformed varint.");
    }

    public static zzjs zzf() {
        return new zzjs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzjs zzg() {
        return new zzjs("Failed to parse the message.");
    }

    public static zzjs zzh() {
        return new zzjs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
