package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjk.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public abstract class zzjk<MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhq<MessageType, BuilderType> {
    private static Map<Object, zzjk<?, ?>> zzc = new ConcurrentHashMap();
    protected zzme zzb = zzme.zzc();
    private int zzd = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static class zza<T extends zzjk<T, ?>> extends zzhr<T> {
        public zza(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static abstract class zzb<MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhp<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (!messagetype.zzcn()) {
                this.zza = messagetype.zzcd();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzix zzix) throws zzjs {
            if (!this.zza.zzcn()) {
                zzal();
            }
            try {
                zzlh.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzhv(zzix));
                return this;
            } catch (zzjs e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzjs.zzh();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzc */
        public final BuilderType zzb(zzio zzio, zzix zzix) throws IOException {
            if (!this.zza.zzcn()) {
                zzal();
            }
            try {
                zzlh.zza().zza(this.zza).zza(this.zza, zzis.zza(zzio), zzix);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) this.zzb.zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza = (zzjk) zzaj();
            return zzb2;
        }

        public final /* synthetic */ zzhp zza(zzio zzio, zzix zzix) throws IOException {
            return (zzb) zzb(zzio, zzix);
        }

        public final /* synthetic */ zzhp zzaf() {
            return (zzb) clone();
        }

        /* renamed from: zzag */
        public final MessageType zzai() {
            MessageType messagetype = (zzjk) zzaj();
            if (zzjk.zza(messagetype, true)) {
                return messagetype;
            }
            throw new zzmc(messagetype);
        }

        /* renamed from: zzah */
        public MessageType zzaj() {
            if (!this.zza.zzcn()) {
                return this.zza;
            }
            this.zza.zzck();
            return this.zza;
        }

        public final void zzak() {
            if (!this.zza.zzcn()) {
                zzal();
            }
        }

        public void zzal() {
            MessageType zzcd = this.zzb.zzcd();
            zza(zzcd, this.zza);
            this.zza = zzcd;
        }

        public final /* synthetic */ zzkt zzcj() {
            return this.zzb;
        }

        public final boolean zzcm() {
            return zzjk.zza(this.zza, false);
        }

        public final /* synthetic */ zzhp zza(byte[] bArr, int i, int i2) throws zzjs {
            return zzb(bArr, 0, i2, zzix.zza);
        }

        public final /* synthetic */ zzhp zza(byte[] bArr, int i, int i2, zzix zzix) throws zzjs {
            return zzb(bArr, 0, i2, zzix);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzcn()) {
                zzal();
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzlh.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static final class zzc implements zzjf<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzmn zzb() {
            throw new NoSuchMethodError();
        }

        public final zzmx zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzks zza(zzks zzks, zzkt zzkt) {
            throw new NoSuchMethodError();
        }

        public final zzky zza(zzky zzky, zzky zzky2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzjk<MessageType, BuilderType> implements zzkv {
        protected zzjd<zzc> zzc = zzjd.zzb();

        public final zzjd<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzjd) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
    public static class zzf<ContainingType extends zzkt, Type> extends zziy<ContainingType, Type> {
    }

    private final int zza() {
        return zzlh.zza().zza(this).zzb(this);
    }

    private final int zzb(zzll<?> zzll) {
        if (zzll == null) {
            return zzlh.zza().zza(this).zza(this);
        }
        return zzll.zza(this);
    }

    public static zzjr zzce() {
        return zzjn.zzd();
    }

    public static zzjq zzcf() {
        return zzke.zzd();
    }

    public static <E> zzjt<E> zzcg() {
        return zzlg.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlh.zza().zza(this).zzb(this, (zzjk) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzcn()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzku.zza((zzkt) this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    public final int zzbx() {
        return this.zzd & Integer.MAX_VALUE;
    }

    public final void zzc(int i) {
        if (i >= 0) {
            this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException(lf.h("serialized size must be non-negative, was ", i));
    }

    public final int zzca() {
        return zza((zzll) null);
    }

    public final <MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzcb() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzcc() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final MessageType zzcd() {
        return (zzjk) zza(zze.zzd, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzks zzch() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzks zzci() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final /* synthetic */ zzkt zzcj() {
        return (zzjk) zza(zze.zzf, (Object) null, (Object) null);
    }

    public final void zzck() {
        zzlh.zza().zza(this).zzc(this);
        zzcl();
    }

    public final void zzcl() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean zzcm() {
        return zza(this, true);
    }

    public final boolean zzcn() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public final int zza(zzll zzll) {
        if (zzcn()) {
            int zzb2 = zzb(zzll);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException(lf.h("serialized size must be non-negative, was ", zzb2));
        } else if (zzbx() != Integer.MAX_VALUE) {
            return zzbx();
        } else {
            int zzb3 = zzb(zzll);
            zzc(zzb3);
            return zzb3;
        }
    }

    public static <T extends zzjk<?, ?>> T zza(Class<T> cls) {
        T t = (zzjk) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzjk) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzjk) ((zzjk) zzmg.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzc.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static zzjq zza(zzjq zzjq) {
        int size = zzjq.size();
        return zzjq.zzc(size == 0 ? 10 : size << 1);
    }

    public static <E> zzjt<E> zza(zzjt<E> zzjt) {
        int size = zzjt.size();
        return zzjt.zza(size == 0 ? 10 : size << 1);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static Object zza(zzkt zzkt, String str, Object[] objArr) {
        return new zzlj(zzkt, str, objArr);
    }

    public static <T extends zzjk<?, ?>> void zza(Class<T> cls, T t) {
        t.zzcl();
        zzc.put(cls, t);
    }

    public final void zza(zzit zzit) throws IOException {
        zzlh.zza().zza(this).zza(this, (zzna) zziw.zza(zzit));
    }

    public static final <T extends zzjk<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzlh.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }
}
