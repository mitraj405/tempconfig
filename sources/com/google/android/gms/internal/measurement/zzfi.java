package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzjk;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzfi {

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zza extends zzjk<zza, zzb> implements zzkv {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzlc<zza> zzd;
        private int zze;
        private zzjt<C0041zza> zzf = zzjk.zzcg();
        private zzjt<zzc> zzg = zzjk.zzcg();
        private zzjt<zzf> zzh = zzjk.zzcg();
        private boolean zzi;
        private zzjt<C0041zza> zzj = zzjk.zzcg();

        /* renamed from: com.google.android.gms.internal.measurement.zzfi$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class C0041zza extends zzjk<C0041zza, C0042zza> implements zzkv {
            /* access modifiers changed from: private */
            public static final C0041zza zzc;
            private static volatile zzlc<C0041zza> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* renamed from: com.google.android.gms.internal.measurement.zzfi$zza$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
            public static final class C0042zza extends zzjk.zzb<C0041zza, C0042zza> implements zzkv {
                private C0042zza() {
                    super(C0041zza.zzc);
                }

                public /* synthetic */ C0042zza(zzfk zzfk) {
                    this();
                }
            }

            static {
                C0041zza zza = new C0041zza();
                zzc = zza;
                zzjk.zza(C0041zza.class, zza);
            }

            private C0041zza() {
            }

            public final zzd zzb() {
                zzd zza = zzd.zza(this.zzg);
                if (zza == null) {
                    return zzd.CONSENT_STATUS_UNSPECIFIED;
                }
                return zza;
            }

            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                if (zza == null) {
                    return zze.CONSENT_TYPE_UNSPECIFIED;
                }
                return zza;
            }

            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfk.zza[i - 1]) {
                    case 1:
                        return new C0041zza();
                    case 2:
                        return new C0042zza((zzfk) null);
                    case 3:
                        return zzjk.zza((zzkt) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
                    case 4:
                        return zzc;
                    case 5:
                        zzlc<C0041zza> zzlc = zzd;
                        if (zzlc == null) {
                            synchronized (C0041zza.class) {
                                zzlc = zzd;
                                if (zzlc == null) {
                                    zzlc = new zzjk.zza<>(zzc);
                                    zzd = zzlc;
                                }
                            }
                        }
                        return zzlc;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zzb extends zzjk.zzb<zza, zzb> implements zzkv {
            private zzb() {
                super(zza.zzc);
            }

            public /* synthetic */ zzb(zzfk zzfk) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zzc extends zzjk<zzc, C0043zza> implements zzkv {
            /* access modifiers changed from: private */
            public static final zzc zzc;
            private static volatile zzlc<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* renamed from: com.google.android.gms.internal.measurement.zzfi$zza$zzc$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
            public static final class C0043zza extends zzjk.zzb<zzc, C0043zza> implements zzkv {
                private C0043zza() {
                    super(zzc.zzc);
                }

                public /* synthetic */ C0043zza(zzfk zzfk) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zzc = zzc2;
                zzjk.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            public final zze zzb() {
                zze zza = zze.zza(this.zzg);
                if (zza == null) {
                    return zze.CONSENT_TYPE_UNSPECIFIED;
                }
                return zza;
            }

            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                if (zza == null) {
                    return zze.CONSENT_TYPE_UNSPECIFIED;
                }
                return zza;
            }

            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfk.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C0043zza((zzfk) null);
                    case 3:
                        return zzjk.zza((zzkt) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
                    case 4:
                        return zzc;
                    case 5:
                        zzlc<zzc> zzlc = zzd;
                        if (zzlc == null) {
                            synchronized (zzc.class) {
                                zzlc = zzd;
                                if (zzlc == null) {
                                    zzlc = new zzjk.zza<>(zzc);
                                    zzd = zzlc;
                                }
                            }
                        }
                        return zzlc;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public enum zzd implements zzjp {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);
            
            private final int zze;

            private zzd(int i) {
                this.zze = i;
            }

            public static zzjo zzb() {
                return zzfl.zza;
            }

            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zze;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public enum zze implements zzjp {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);
            
            private final int zzg;

            private zze(int i) {
                this.zzg = i;
            }

            public static zzjo zzb() {
                return zzfm.zza;
            }

            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzg;
            }

            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zzf extends zzjk<zzf, C0044zza> implements zzkv {
            /* access modifiers changed from: private */
            public static final zzf zzc;
            private static volatile zzlc<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* renamed from: com.google.android.gms.internal.measurement.zzfi$zza$zzf$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
            public static final class C0044zza extends zzjk.zzb<zzf, C0044zza> implements zzkv {
                private C0044zza() {
                    super(zzf.zzc);
                }

                public /* synthetic */ C0044zza(zzfk zzfk) {
                    this();
                }
            }

            static {
                zzf zzf2 = new zzf();
                zzc = zzf2;
                zzjk.zza(zzf.class, zzf2);
            }

            private zzf() {
            }

            public final String zzb() {
                return this.zzf;
            }

            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfk.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0044zza((zzfk) null);
                    case 3:
                        return zzjk.zza((zzkt) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                    case 4:
                        return zzc;
                    case 5:
                        zzlc<zzf> zzlc = zzd;
                        if (zzlc == null) {
                            synchronized (zzf.class) {
                                zzlc = zzd;
                                if (zzlc == null) {
                                    zzlc = new zzjk.zza<>(zzc);
                                    zzd = zzlc;
                                }
                            }
                        }
                        return zzlc;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        static {
            zza zza = new zza();
            zzc = zza;
            zzjk.zza(zza.class, zza);
        }

        private zza() {
        }

        public static zza zzb() {
            return zzc;
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<C0041zza> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final List<C0041zza> zzf() {
            return this.zzj;
        }

        public final boolean zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            if ((this.zze & 1) != 0) {
                return true;
            }
            return false;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", C0041zza.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", C0041zza.class});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zza> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zza.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzb extends zzjk<zzb, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzlc<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjt<zzf> zzg = zzjk.zzcg();
        private boolean zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzb, zza> implements zzkv {
            private zza() {
                super(zzb.zzc);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzc = zzb;
            zzjk.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public final String zzb() {
            return this.zzf;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzb> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzb.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzc extends zzjk<zzc, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzc zzc;
        private static volatile zzlc<zzc> zzd;
        private int zze;
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzc, zza> implements zzkv {
            private zza() {
                super(zzc.zzc);
            }

            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }

            public final zza zza(String str) {
                zzak();
                ((zzc) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzc = zzc2;
            zzjk.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        public final int zza() {
            return this.zzi;
        }

        public final String zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            if ((this.zze & 2) != 0) {
                return true;
            }
            return false;
        }

        public final boolean zzg() {
            if ((this.zze & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean zzh() {
            if ((this.zze & 8) != 0) {
                return true;
            }
            return false;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzc> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzc.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzd extends zzjk<zzd, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzd zzc;
        private static volatile zzlc<zzd> zzd;
        private int zze;
        private long zzf;
        private String zzg = "";
        private int zzh;
        private zzjt<zzg> zzi = zzjk.zzcg();
        private zzjt<zzc> zzj = zzjk.zzcg();
        private zzjt<zzff.zza> zzk = zzjk.zzcg();
        private String zzl = "";
        private boolean zzm;
        private zzjt<zzft.zzc> zzn = zzjk.zzcg();
        private zzjt<zzb> zzo = zzjk.zzcg();
        private String zzp = "";
        private String zzq = "";
        private zza zzr;
        private zze zzs;
        private zzh zzt;
        private zzf zzu;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzd, zza> implements zzkv {
            private zza() {
                super(zzd.zzc);
            }

            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zza zzb() {
                zzak();
                ((zzd) this.zza).zzt();
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            public final List<zzff.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }

            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            public final zza zza(int i, zzc.zza zza) {
                zzak();
                ((zzd) this.zza).zza(i, (zzc) ((zzjk) zza.zzai()));
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzc = zzd2;
            zzjk.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        public static zza zze() {
            return (zza) zzc.zzcb();
        }

        public static zzd zzg() {
            return zzc;
        }

        /* access modifiers changed from: private */
        public final void zzt() {
            this.zzk = zzjk.zzcg();
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zza2 = this.zzr;
            if (zza2 == null) {
                return zza.zzb();
            }
            return zza2;
        }

        public final zzh zzh() {
            zzh zzh2 = this.zzt;
            if (zzh2 == null) {
                return zzh.zzc();
            }
            return zzh2;
        }

        public final String zzi() {
            return this.zzg;
        }

        public final String zzj() {
            return this.zzp;
        }

        public final List<zzff.zza> zzk() {
            return this.zzk;
        }

        public final List<zzb> zzl() {
            return this.zzo;
        }

        public final List<zzft.zzc> zzm() {
            return this.zzn;
        }

        public final List<zzg> zzn() {
            return this.zzi;
        }

        public final boolean zzo() {
            return this.zzm;
        }

        public final boolean zzp() {
            if ((this.zze & 128) != 0) {
                return true;
            }
            return false;
        }

        public final boolean zzq() {
            if ((this.zze & 2) != 0) {
                return true;
            }
            return false;
        }

        public final boolean zzr() {
            if ((this.zze & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
                return true;
            }
            return false;
        }

        public final boolean zzs() {
            if ((this.zze & 1) != 0) {
                return true;
            }
            return false;
        }

        public final zzc zza(int i) {
            return this.zzj.get(i);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzff.zza.class, "zzl", "zzm", "zzn", zzft.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzd> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzd.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzjt<zzc> zzjt = this.zzj;
            if (!zzjt.zzc()) {
                this.zzj = zzjk.zza(zzjt);
            }
            this.zzj.set(i, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zze extends zzjk<zze, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zze zzc;
        private static volatile zzlc<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zze, zza> implements zzkv {
            private zza() {
                super(zze.zzc);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zzc = zze2;
            zzjk.zza(zze.class, zze2);
        }

        private zze() {
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zze> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zze.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzf extends zzjk<zzf, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzf zzc;
        private static volatile zzlc<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzf, zza> implements zzkv {
            private zza() {
                super(zzf.zzc);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzc = zzf2;
            zzjk.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzf> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzf.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzg extends zzjk<zzg, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzg zzc;
        private static volatile zzlc<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzg, zza> implements zzkv {
            private zza() {
                super(zzg.zzc);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzc = zzg2;
            zzjk.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzg> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzg.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public static final class zzh extends zzjk<zzh, zza> implements zzkv {
        /* access modifiers changed from: private */
        public static final zzh zzc;
        private static volatile zzlc<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
        public static final class zza extends zzjk.zzb<zzh, zza> implements zzkv {
            private zza() {
                super(zzh.zzc);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzh zzh2 = new zzh();
            zzc = zzh2;
            zzjk.zza(zzh.class, zzh2);
        }

        private zzh() {
        }

        public static zzh zzc() {
            return zzc;
        }

        public final int zza() {
            return this.zzi;
        }

        public final String zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzf;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzfk) null);
                case 3:
                    return zzjk.zza((zzkt) zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlc<zzh> zzlc = zzd;
                    if (zzlc == null) {
                        synchronized (zzh.class) {
                            zzlc = zzd;
                            if (zzlc == null) {
                                zzlc = new zzjk.zza<>(zzc);
                                zzd = zzlc;
                            }
                        }
                    }
                    return zzlc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
