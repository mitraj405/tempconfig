package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzfk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = true;
        /* access modifiers changed from: private */
        public boolean zzb = false;
        /* access modifiers changed from: private */
        public boolean zzc = false;

        public VideoOptions build() {
            return new VideoOptions(this, (zzi) null);
        }

        public Builder setClickToExpandRequested(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setCustomControlsRequested(boolean z) {
            this.zzb = z;
            return this;
        }

        public Builder setStartMuted(boolean z) {
            this.zza = z;
            return this;
        }
    }

    public /* synthetic */ VideoOptions(Builder builder, zzi zzi) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }

    public VideoOptions(zzfk zzfk) {
        this.zza = zzfk.zza;
        this.zzb = zzfk.zzb;
        this.zzc = zzfk.zzc;
    }
}
