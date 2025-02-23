package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxy;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzgxy<MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> extends zzgvv<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Object, zzgxy<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhat zzt = zzhat.zzc();

    public static zzgya zzbA() {
        return zzgwc.zzd();
    }

    public static zzgya zzbB(zzgya zzgya) {
        int i;
        int size = zzgya.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgya.zze(i);
    }

    public static zzgyb zzbC() {
        return zzgxf.zze();
    }

    public static zzgyb zzbD(zzgyb zzgyb) {
        int i;
        int size = zzgyb.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgyb.zzg(i);
    }

    public static zzgyf zzbE() {
        return zzgxp.zze();
    }

    public static zzgyf zzbF(zzgyf zzgyf) {
        int i;
        int size = zzgyf.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgyf.zzg(i);
    }

    public static zzgyg zzbG() {
        return zzgxz.zzg();
    }

    public static zzgyg zzbH(zzgyg zzgyg) {
        int i;
        int size = zzgyg.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgyg.zzh(i);
    }

    public static zzgyj zzbI() {
        return zzgyy.zzh();
    }

    public static zzgyj zzbJ(zzgyj zzgyj) {
        int i;
        int size = zzgyj.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgyj.zze(i);
    }

    public static <E> zzgyk<E> zzbK() {
        return zzgzu.zzd();
    }

    public static <E> zzgyk<E> zzbL(zzgyk<E> zzgyk) {
        int i;
        int size = zzgyk.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzgyk.zzf(i);
    }

    public static Object zzbR(Method method, Object obj, Object... objArr) {
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

    public static Object zzbS(zzgzj zzgzj, String str, Object[] objArr) {
        return new zzgzv(zzgzj, str, objArr);
    }

    public static Method zzbT(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(C1058d.A("Generated message class \"", cls.getName(), "\" missing method \"", str, "\"."), e);
        }
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbe(ContainingType containingtype, zzgzj zzgzj, zzgyd zzgyd, int i, zzhbf zzhbf, boolean z, Class cls) {
        return new zzgxw(containingtype, Collections.emptyList(), zzgzj, new zzgxv(zzgyd, i, zzhbf, true, z), cls);
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzgzj zzgzj, zzgyd zzgyd, int i, zzhbf zzhbf, Class cls) {
        return new zzgxw(containingtype, type, zzgzj, new zzgxv(zzgyd, i, zzhbf, false, false), cls);
    }

    public static <T extends zzgxy> T zzbh(Class<T> cls) {
        T t = (zzgxy) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgxy) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((zzgxy) zzhaz.zzg(cls)).zzbt();
            if (t != null) {
                zzc.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends zzgxy<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T zzf = zzf(t, inputStream, zzgxi.zza);
        zze(zzf);
        return zzf;
    }

    public static <T extends zzgxy<T, ?>> T zzbl(T t, InputStream inputStream, zzgxi zzgxi) throws zzgyn {
        T zzf = zzf(t, inputStream, zzgxi);
        zze(zzf);
        return zzf;
    }

    public static <T extends zzgxy<T, ?>> T zzbm(T t, zzgwm zzgwm) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T zzbr = zzbr(t, zzgwm, zzgxi.zza);
        zze(zzbr);
        return zzbr;
    }

    public static <T extends zzgxy<T, ?>> T zzbn(T t, zzgww zzgww) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzbs(t, zzgww, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgyn {
        zzgww zzG = zzgww.zzG(inputStream, 4096);
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T zzbz = zzbz(t, zzG, zzgxi.zza);
        zze(zzbz);
        return zzbz;
    }

    public static <T extends zzgxy<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzbv(t, byteBuffer, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbq(T t, byte[] bArr) throws zzgyn {
        int length = bArr.length;
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T zzh = zzh(t, bArr, 0, length, zzgxi.zza);
        zze(zzh);
        return zzh;
    }

    public static <T extends zzgxy<T, ?>> T zzbr(T t, zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        T zzg = zzg(t, zzgwm, zzgxi);
        zze(zzg);
        return zzg;
    }

    public static <T extends zzgxy<T, ?>> T zzbs(T t, zzgww zzgww, zzgxi zzgxi) throws zzgyn {
        T zzbz = zzbz(t, zzgww, zzgxi);
        zze(zzbz);
        return zzbz;
    }

    public static <T extends zzgxy<T, ?>> T zzbu(T t, InputStream inputStream, zzgxi zzgxi) throws zzgyn {
        T zzbz = zzbz(t, zzgww.zzG(inputStream, 4096), zzgxi);
        zze(zzbz);
        return zzbz;
    }

    public static <T extends zzgxy<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgxi zzgxi) throws zzgyn {
        zzgww zzgww;
        if (byteBuffer.hasArray()) {
            zzgww = zzgww.zzH(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else if (!byteBuffer.isDirect() || !zzhaz.zzB()) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            zzgww = zzgww.zzH(bArr, 0, remaining, true);
        } else {
            zzgww = new zzgwu(byteBuffer, false, (zzgwt) null);
        }
        T zzbs = zzbs(t, zzgww, zzgxi);
        zze(zzbs);
        return zzbs;
    }

    public static <T extends zzgxy<T, ?>> T zzbx(T t, byte[] bArr, zzgxi zzgxi) throws zzgyn {
        T zzh = zzh(t, bArr, 0, bArr.length, zzgxi);
        zze(zzh);
        return zzh;
    }

    public static <T extends zzgxy<T, ?>> T zzby(T t, zzgww zzgww) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzbz(t, zzgww, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbz(T t, zzgww zzgww, zzgxi zzgxi) throws zzgyn {
        T zzbj = t.zzbj();
        try {
            zzhae zzb2 = zzgzt.zza().zzb(zzbj.getClass());
            zzb2.zzh(zzbj, zzgwx.zzq(zzgww), zzgxi);
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzgyn e) {
            if (e.zzk()) {
                throw new zzgyn((IOException) e);
            }
            throw e;
        } catch (zzhar e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyn) {
                throw ((zzgyn) e3.getCause());
            }
            throw new zzgyn(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgyn) {
                throw ((zzgyn) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhae<?> zzhae) {
        if (zzhae != null) {
            return zzhae.zza(this);
        }
        return zzgzt.zza().zzb(getClass()).zza(this);
    }

    public static <T extends zzgxy> void zzcb(Class<T> cls, T t) {
        t.zzbX();
        zzc.put(cls, t);
    }

    public static final <T extends zzgxy<T, ?>> boolean zzce(T t, boolean z) {
        T t2;
        byte byteValue = ((Byte) t.zzbP(zzgxx.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzgzt.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            if (true != zzl) {
                t2 = null;
            } else {
                t2 = t;
            }
            t.zzbQ(zzgxx.SET_MEMOIZED_IS_INITIALIZED, t2);
        }
        return zzl;
    }

    /* access modifiers changed from: private */
    public static <MessageType extends zzgxu<MessageType, BuilderType>, BuilderType, T> zzgxw<MessageType, T> zzd(zzgxg<MessageType, T> zzgxg) {
        return (zzgxw) zzgxg;
    }

    private static <T extends zzgxy<T, ?>> T zze(T t) throws zzgyn {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgxy<T, ?>> T zzf(T t, InputStream inputStream, zzgxi zzgxi) throws zzgyn {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            zzgww zzG = zzgww.zzG(new zzgvt(inputStream, zzgww.zzE(read, inputStream)), 4096);
            T zzbz = zzbz(t, zzG, zzgxi);
            try {
                zzG.zzy(0);
                return zzbz;
            } catch (zzgyn e) {
                throw e;
            }
        } catch (zzgyn e2) {
            if (e2.zzk()) {
                throw new zzgyn((IOException) e2);
            }
            throw e2;
        } catch (IOException e3) {
            throw new zzgyn(e3);
        }
    }

    private static <T extends zzgxy<T, ?>> T zzg(T t, zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        zzgww zzl = zzgwm.zzl();
        T zzbz = zzbz(t, zzl, zzgxi);
        try {
            zzl.zzy(0);
            return zzbz;
        } catch (zzgyn e) {
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public static <T extends zzgxy<T, ?>> T zzh(T t, byte[] bArr, int i, int i2, zzgxi zzgxi) throws zzgyn {
        if (i2 == 0) {
            return t;
        }
        T zzbj = t.zzbj();
        try {
            zzhae zzb2 = zzgzt.zza().zzb(zzbj.getClass());
            zzb2.zzi(zzbj, bArr, i, i + i2, new zzgwa(zzgxi));
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzgyn e) {
            if (e.zzk()) {
                throw new zzgyn((IOException) e);
            }
            throw e;
        } catch (zzhar e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyn) {
                throw ((zzgyn) e3.getCause());
            }
            throw new zzgyn(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgyn.zzi();
        }
    }

    private void zzi() {
        if (this.zzt == zzhat.zzc()) {
            this.zzt = zzhat.zzf();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgzt.zza().zzb(getClass()).zzk(this, (zzgxy) obj);
    }

    public int hashCode() {
        if (zzcf()) {
            return zzaW();
        }
        if (zzcd()) {
            zzcc(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzgzl.zza(this, super.toString());
    }

    public int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    public int zzaM(zzhae zzhae) {
        if (zzcf()) {
            int zzc2 = zzc(zzhae);
            if (zzc2 >= 0) {
                return zzc2;
            }
            throw new IllegalStateException(lf.h("serialized size must be non-negative, was ", zzc2));
        } else if (zzaL() != Integer.MAX_VALUE) {
            return zzaL();
        } else {
            int zzc3 = zzc(zzhae);
            zzaS(zzc3);
            return zzc3;
        }
    }

    public zzgzo zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    public void zzaS(int i) {
        if (i >= 0) {
            this.zzd = i | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException(lf.h("serialized size must be non-negative, was ", i));
    }

    public int zzaW() {
        return zzgzt.zza().zzb(getClass()).zzb(this);
    }

    public int zzaX() {
        return this.zzq;
    }

    public int zzaY() {
        return zzaM((zzhae) null);
    }

    public final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzaZ() {
        return (zzgxs) zzbP(zzgxx.NEW_BUILDER);
    }

    public final zzgzr<MessageType> zzbN() {
        return (zzgzr) zzbP(zzgxx.GET_PARSER);
    }

    public Object zzbO() throws Exception {
        return zzbP(zzgxx.BUILD_MESSAGE_INFO);
    }

    public Object zzbP(zzgxx zzgxx) {
        return zzde(zzgxx, (Object) null, (Object) null);
    }

    public Object zzbQ(zzgxx zzgxx, Object obj) {
        return zzde(zzgxx, obj, (Object) null);
    }

    public void zzbU() {
        this.zzq = 0;
    }

    public void zzbV() {
        zzaS(Integer.MAX_VALUE);
    }

    public void zzbW() {
        zzgzt.zza().zzb(getClass()).zzf(this);
        zzbX();
    }

    public void zzbX() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public void zzbY(int i, zzgwm zzgwm) {
        zzi();
        zzhat zzhat = this.zzt;
        zzhat.zzg();
        if (i != 0) {
            zzhat.zzj((i << 3) | 2, zzgwm);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void zzbZ(zzhat zzhat) {
        this.zzt = zzhat.zze(this.zzt, zzhat);
    }

    public final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType zzaZ = zzaZ();
        zzaZ.zzbj(messagetype);
        return zzaZ;
    }

    /* renamed from: zzbb */
    public final BuilderType zzcZ() {
        return (zzgxs) zzbP(zzgxx.NEW_BUILDER);
    }

    /* renamed from: zzbc */
    public final BuilderType zzbM() {
        BuilderType buildertype = (zzgxs) zzbP(zzgxx.NEW_BUILDER);
        buildertype.zzbj(this);
        return buildertype;
    }

    /* renamed from: zzbi */
    public final MessageType zzbt() {
        return (zzgxy) zzbP(zzgxx.GET_DEFAULT_INSTANCE);
    }

    public MessageType zzbj() {
        return (zzgxy) zzbP(zzgxx.NEW_MUTABLE_INSTANCE);
    }

    public final boolean zzbw() {
        return zzce(this, true);
    }

    public void zzca(int i, int i2) {
        zzi();
        zzhat zzhat = this.zzt;
        zzhat.zzg();
        if (i != 0) {
            zzhat.zzj(i << 3, Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public void zzcc(int i) {
        this.zzq = i;
    }

    public boolean zzcd() {
        if (zzaX() == 0) {
            return true;
        }
        return false;
    }

    public boolean zzcf() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public boolean zzcg(int i, zzgww zzgww) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzi();
        return this.zzt.zzm(i, zzgww);
    }

    public void zzda(zzgxd zzgxd) throws IOException {
        zzgzt.zza().zzb(getClass()).zzj(this, zzgxe.zza(zzgxd));
    }

    public abstract Object zzde(zzgxx zzgxx, Object obj, Object obj2);
}
