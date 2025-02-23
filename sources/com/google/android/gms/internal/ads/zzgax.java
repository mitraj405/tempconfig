package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzgax<V> extends zzgdm implements ListenableFuture<V> {
    private static final Object zzbc = new Object();
    /* access modifiers changed from: private */
    public static final zza zzbf;
    static final boolean zzd;
    static final zzgct zze;
    /* access modifiers changed from: private */
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    public volatile Object value;
    /* access modifiers changed from: private */
    public volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    abstract class zza {
        public /* synthetic */ zza(zzgaw zzgaw) {
        }

        public abstract zzd zza(zzgax zzgax, zzd zzd);

        public abstract zzk zzb(zzgax zzgax, zzk zzk);

        public abstract void zzc(zzk zzk, zzk zzk2);

        public abstract void zzd(zzk zzk, Thread thread);

        public abstract boolean zze(zzgax zzgax, zzd zzd, zzd zzd2);

        public abstract boolean zzf(zzgax zzgax, Object obj, Object obj2);

        public abstract boolean zzg(zzgax zzgax, zzk zzk, zzk zzk2);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgax.zzd) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        public zzb(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, zzk> zzc;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, zzd> zzd;
        final AtomicReferenceFieldUpdater<? super zzgax<?>, Object> zze;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super((zzgaw) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        public final zzd zza(zzgax zzgax, zzd zzd2) {
            return this.zzd.getAndSet(zzgax, zzd2);
        }

        public final zzk zzb(zzgax zzgax, zzk zzk) {
            return this.zzc.getAndSet(zzgax, zzk);
        }

        public final void zzc(zzk zzk, zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        public final void zzd(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        public final boolean zze(zzgax zzgax, zzd zzd2, zzd zzd3) {
            return zzgay.zza(this.zzd, zzgax, zzd2, zzd3);
        }

        public final boolean zzf(zzgax zzgax, Object obj, Object obj2) {
            return zzgay.zza(this.zze, zzgax, obj, obj2);
        }

        public final boolean zzg(zzgax zzgax, zzk zzk, zzk zzk2) {
            return zzgay.zza(this.zzc, zzgax, zzk, zzk2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzf<V> implements Runnable {
        final zzgax<V> zza;
        final ListenableFuture<? extends V> zzb;

        public zzf(zzgax zzgax, ListenableFuture listenableFuture) {
            this.zza = zzgax;
            this.zzb = listenableFuture;
        }

        public final void run() {
            if (this.zza.value == this) {
                ListenableFuture<? extends V> listenableFuture = this.zzb;
                if (zzgax.zzbf.zzf(this.zza, this, zzgax.zze(listenableFuture))) {
                    zzgax.zzx(this.zza, false);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzg extends zza {
        private zzg() {
            throw null;
        }

        public final zzd zza(zzgax zzgax, zzd zzd) {
            zzd zzh;
            synchronized (zzgax) {
                zzh = zzgax.listeners;
                if (zzh != zzd) {
                    zzgax.listeners = zzd;
                }
            }
            return zzh;
        }

        public final zzk zzb(zzgax zzgax, zzk zzk) {
            zzk zzi;
            synchronized (zzgax) {
                zzi = zzgax.waiters;
                if (zzi != zzk) {
                    zzgax.waiters = zzk;
                }
            }
            return zzi;
        }

        public final void zzc(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        public final void zzd(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        public final boolean zze(zzgax zzgax, zzd zzd, zzd zzd2) {
            synchronized (zzgax) {
                if (zzgax.listeners != zzd) {
                    return false;
                }
                zzgax.listeners = zzd2;
                return true;
            }
        }

        public final boolean zzf(zzgax zzgax, Object obj, Object obj2) {
            synchronized (zzgax) {
                if (zzgax.value != obj) {
                    return false;
                }
                zzgax.value = obj2;
                return true;
            }
        }

        public final boolean zzg(zzgax zzgax, zzk zzk, zzk zzk2) {
            synchronized (zzgax) {
                if (zzgax.waiters != zzk) {
                    return false;
                }
                zzgax.waiters = zzk2;
                return true;
            }
        }

        public /* synthetic */ zzg(zzgaz zzgaz) {
            super((zzgaw) null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    interface zzh<V> extends ListenableFuture<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    abstract class zzi<V> extends zzgax<V> implements zzh<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzgax.zzj.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzgax$zzk> r0 = com.google.android.gms.internal.ads.zzgax.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzgax$zzj$1 r1 = new com.google.android.gms.internal.ads.zzgax$zzj$1     // Catch:{ PrivilegedActionException -> 0x005a }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005a }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005a }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005a }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzgax> r2 = com.google.android.gms.internal.ads.zzgax.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                zzc = r3     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                zzb = r3     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                zzd = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                zze = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ NoSuchFieldException -> 0x0053 }
                zzf = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                zza = r1     // Catch:{ NoSuchFieldException -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005a:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgax.zzj.<clinit>():void");
        }

        private zzj() {
            throw null;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final com.google.android.gms.internal.ads.zzgax.zzd zza(com.google.android.gms.internal.ads.zzgax r3, com.google.android.gms.internal.ads.zzgax.zzd r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.ads.zzgax$zzd r0 = r3.listeners
                if (r4 != r0) goto L_0x0007
                goto L_0x000d
            L_0x0007:
                boolean r1 = r2.zze(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
            L_0x000d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgax.zzj.zza(com.google.android.gms.internal.ads.zzgax, com.google.android.gms.internal.ads.zzgax$zzd):com.google.android.gms.internal.ads.zzgax$zzd");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final com.google.android.gms.internal.ads.zzgax.zzk zzb(com.google.android.gms.internal.ads.zzgax r3, com.google.android.gms.internal.ads.zzgax.zzk r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.ads.zzgax$zzk r0 = r3.waiters
                if (r4 != r0) goto L_0x0007
                goto L_0x000d
            L_0x0007:
                boolean r1 = r2.zzg(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
            L_0x000d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgax.zzj.zzb(com.google.android.gms.internal.ads.zzgax, com.google.android.gms.internal.ads.zzgax$zzk):com.google.android.gms.internal.ads.zzgax$zzk");
        }

        public final void zzc(zzk zzk, zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        public final void zzd(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        public final boolean zze(zzgax zzgax, zzd zzd2, zzd zzd3) {
            return zzgba.zza(zza, zzgax, zzb, zzd2, zzd3);
        }

        public final boolean zzf(zzgax zzgax, Object obj, Object obj2) {
            return zzgba.zza(zza, zzgax, zzd, obj, obj2);
        }

        public final boolean zzg(zzgax zzgax, zzk zzk, zzk zzk2) {
            return zzgba.zza(zza, zzgax, zzc, zzk, zzk2);
        }

        public /* synthetic */ zzj(zzgbb zzgbb) {
            super((zzgaw) null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        public zzk() {
            zzgax.zzbf.zzd(this, Thread.currentThread());
        }

        public zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzd = z;
        Class<zzgax> cls2 = zzgax.class;
        zze = new zzgct(cls2);
        try {
            zza2 = new zzj((zzgbb) null);
            th2 = null;
            th = null;
        } catch (Error | Exception e) {
            try {
                th = null;
                th2 = e;
                zza2 = new zze(AtomicReferenceFieldUpdater.newUpdater(cls, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(cls, cls, "next"), AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "waiters"), AtomicReferenceFieldUpdater.newUpdater(cls2, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(cls2, Object.class, "value"));
            } catch (Error | Exception e2) {
                th = e2;
                th2 = e;
                zza2 = new zzg((zzgaz) null);
            }
        }
        zzbf = zza2;
        if (th != null) {
            zzgct zzgct = zze;
            Logger zza3 = zzgct.zza();
            Level level = Level.SEVERE;
            zza3.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzgct.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    private static final Object zzA(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzbc) {
            return null;
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object zze(ListenableFuture listenableFuture) {
        Throwable zzl;
        if (listenableFuture instanceof zzh) {
            Object obj = ((zzgax) listenableFuture).value;
            if (obj instanceof zzb) {
                zzb zzb2 = (zzb) obj;
                if (zzb2.zzc) {
                    Throwable th = zzb2.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((listenableFuture instanceof zzgdm) && (zzl = ((zzgdm) listenableFuture).zzl()) != null) {
            return new zzc(zzl);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!zzd) && isCancelled) {
                zzb zzb3 = zzb.zzb;
                Objects.requireNonNull(zzb3);
                return zzb3;
            }
            try {
                Object zzf2 = zzf(listenableFuture);
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture))));
                }
                if (zzf2 == null) {
                    return zzbc;
                }
                return zzf2;
            } catch (ExecutionException e) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e));
                }
                return new zzc(e.getCause());
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e2));
                }
                return new zzb(false, e2);
            } catch (Error | Exception e3) {
                return new zzc(e3);
            }
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzu(StringBuilder sb) {
        try {
            Object zzf2 = zzf(this);
            sb.append("SUCCESS, result=[");
            if (zzf2 == null) {
                sb.append("null");
            } else if (zzf2 == this) {
                sb.append("this future");
            } else {
                sb.append(zzf2.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzf2)));
            }
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzv(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzw(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                str = zzfvj.zza(zza());
            } catch (Exception | StackOverflowError e) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(e.getClass()));
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzu(sb);
        }
    }

    private final void zzw(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (Exception | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    /* access modifiers changed from: private */
    public static void zzx(zzgax<V> zzgax, boolean z) {
        zzd zzd2 = null;
        while (true) {
            for (zzk zzb2 = zzbf.zzb(zzgax, zzk.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                zzgax.zzq();
            }
            zzgax.zzb();
            zzd zzd3 = zzd2;
            zzd zza2 = zzbf.zza(zzgax, zzd.zza);
            zzd zzd4 = zzd3;
            while (zza2 != null) {
                zzd zzd5 = zza2.next;
                zza2.next = zzd4;
                zzd4 = zza2;
                zza2 = zzd5;
            }
            while (zzd4 != null) {
                zzd2 = zzd4.next;
                Runnable runnable = zzd4.zzb;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzf2 = (zzf) runnable2;
                    zzgax = zzf2.zza;
                    if (zzgax.value == zzf2) {
                        if (zzbf.zzf(zzgax, zzf2, zze(zzf2.zzb))) {
                            z = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzd4.zzc;
                    Objects.requireNonNull(executor);
                    zzy(runnable2, executor);
                }
                zzd4 = zzd2;
            }
            return;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Logger zza2 = zze.zza();
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            zza2.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + valueOf + " with executor " + valueOf2, e);
        }
    }

    private final void zzz(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzbf.zzg(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzfuu.zzc(runnable, "Runnable was null.");
        zzfuu.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzy(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzbf.zze(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzy(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x000a
            r4 = r3
            goto L_0x000b
        L_0x000a:
            r4 = r2
        L_0x000b:
            r1 = r1 | r4
            if (r1 == 0) goto L_0x005f
            boolean r1 = zzd
            if (r1 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzgax$zzb r1 = new com.google.android.gms.internal.ads.zzgax$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzgax$zzb r1 = com.google.android.gms.internal.ads.zzgax.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzgax$zzb r1 = com.google.android.gms.internal.ads.zzgax.zzb.zzb
        L_0x0026:
            java.util.Objects.requireNonNull(r1)
        L_0x0029:
            r4 = r7
            r5 = r2
        L_0x002b:
            com.google.android.gms.internal.ads.zzgax$zza r6 = zzbf
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L_0x0058
            zzx(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            if (r4 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzgax$zzf r0 = (com.google.android.gms.internal.ads.zzgax.zzf) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgax.zzh
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.android.gms.internal.ads.zzgax r4 = (com.google.android.gms.internal.ads.zzgax) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004b
            r5 = r3
            goto L_0x004c
        L_0x004b:
            r5 = r2
        L_0x004c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0056
            r5 = r3
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
        L_0x0056:
            r2 = r3
            goto L_0x005f
        L_0x0058:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            if (r6 != 0) goto L_0x002b
            r2 = r5
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgax.cancel(boolean):boolean");
    }

    public Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzA(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzbf;
                    zza2.zzc(zzk3, zzk2);
                    if (zza2.zzg(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zzz(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzA(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return zzA(obj3);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public boolean isDone() {
        boolean z;
        Object obj = this.value;
        boolean z2 = obj instanceof zzf;
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        return z & (!z2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzu(sb);
        } else {
            zzv(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        return "remaining delay=[" + delay + " ms]";
    }

    public boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzbc;
        }
        if (!zzbf.zzf(this, (Object) null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    public boolean zzd(Throwable th) {
        th.getClass();
        if (!zzbf.zzf(this, (Object) null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    public final Throwable zzl() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public final void zzr(Future future) {
        boolean z;
        if (future != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && isCancelled()) {
            future.cancel(zzt());
        }
    }

    public final boolean zzs(ListenableFuture listenableFuture) {
        zzc zzc2;
        listenableFuture.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!zzbf.zzf(this, (Object) null, zze(listenableFuture))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzf zzf2 = new zzf(this, listenableFuture);
            if (zzbf.zzf(this, (Object) null, zzf2)) {
                try {
                    listenableFuture.addListener(zzf2, zzgbx.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzc2 = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzc2 = zzc.zza;
                    }
                    zzbf.zzf(this, zzf2, zzc2);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            listenableFuture.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    public final boolean zzt() {
        Object obj = this.value;
        if (!(obj instanceof zzb) || !((zzb) obj).zzc) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(long r19, java.util.concurrent.TimeUnit r21) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r21
            long r4 = r3.toNanos(r1)
            boolean r6 = java.lang.Thread.interrupted()
            if (r6 != 0) goto L_0x0174
            java.lang.Object r6 = r0.value
            r7 = 1
            if (r6 == 0) goto L_0x0017
            r8 = r7
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            boolean r9 = r6 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            r9 = r9 ^ r7
            r8 = r8 & r9
            if (r8 == 0) goto L_0x0023
            java.lang.Object r1 = zzA(r6)
            return r1
        L_0x0023:
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x002f
            long r10 = java.lang.System.nanoTime()
            long r10 = r10 + r4
            goto L_0x0030
        L_0x002f:
            r10 = r8
        L_0x0030:
            r12 = 1000(0x3e8, double:4.94E-321)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzgax$zzk r6 = r0.waiters
            com.google.android.gms.internal.ads.zzgax$zzk r14 = com.google.android.gms.internal.ads.zzgax.zzk.zza
            if (r6 == r14) goto L_0x0091
            com.google.android.gms.internal.ads.zzgax$zzk r14 = new com.google.android.gms.internal.ads.zzgax$zzk
            r14.<init>()
        L_0x0041:
            com.google.android.gms.internal.ads.zzgax$zza r15 = zzbf
            r15.zzc(r14, r6)
            boolean r6 = r15.zzg(r0, r6, r14)
            if (r6 == 0) goto L_0x0087
        L_0x004c:
            r8 = 2147483647999999999(0x1dcd64ffffffffff, double:3.98785104510193E-165)
            long r4 = java.lang.Math.min(r4, r8)
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x007e
            java.lang.Object r4 = r0.value
            if (r4 == 0) goto L_0x0064
            r5 = r7
            goto L_0x0065
        L_0x0064:
            r5 = 0
        L_0x0065:
            boolean r6 = r4 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0070
            java.lang.Object r1 = zzA(r4)
            return r1
        L_0x0070:
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x004c
            r0.zzz(r14)
            goto L_0x00bd
        L_0x007e:
            r0.zzz(r14)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x0087:
            com.google.android.gms.internal.ads.zzgax$zzk r6 = r0.waiters
            com.google.android.gms.internal.ads.zzgax$zzk r8 = com.google.android.gms.internal.ads.zzgax.zzk.zza
            if (r6 != r8) goto L_0x008e
            goto L_0x0091
        L_0x008e:
            r8 = 0
            goto L_0x0041
        L_0x0091:
            java.lang.Object r1 = r0.value
            java.util.Objects.requireNonNull(r1)
            java.lang.Object r1 = zzA(r1)
            return r1
        L_0x009b:
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c6
            java.lang.Object r4 = r0.value
            if (r4 == 0) goto L_0x00a5
            r5 = r7
            goto L_0x00a6
        L_0x00a5:
            r5 = 0
        L_0x00a6:
            boolean r6 = r4 instanceof com.google.android.gms.internal.ads.zzgax.zzf
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x00b1
            java.lang.Object r1 = zzA(r4)
            return r1
        L_0x00b1:
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x00c0
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
        L_0x00bd:
            r8 = 0
            goto L_0x009b
        L_0x00c0:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x00c6:
            java.lang.String r6 = r18.toString()
            java.lang.String r8 = r21.toString()
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            java.lang.String r10 = r21.toString()
            java.lang.String r9 = r10.toLowerCase(r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Waited "
            r10.<init>(r11)
            r10.append(r1)
            java.lang.String r1 = " "
            r10.append(r1)
            r10.append(r9)
            java.lang.String r2 = r10.toString()
            long r9 = r4 + r12
            r14 = 0
            int r9 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r9 >= 0) goto L_0x0156
            java.lang.String r9 = " (plus "
            java.lang.String r2 = r2.concat(r9)
            long r4 = -r4
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r9 = r3.convert(r4, r9)
            long r16 = r3.toNanos(r9)
            long r4 = r4 - r16
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x0117
            int r11 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x0116
            goto L_0x0117
        L_0x0116:
            r7 = 0
        L_0x0117:
            if (r3 <= 0) goto L_0x013a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r9)
            r3.append(r1)
            r3.append(r8)
            java.lang.String r2 = r3.toString()
            if (r7 == 0) goto L_0x0136
            java.lang.String r3 = ","
            java.lang.String r2 = r2.concat(r3)
        L_0x0136:
            java.lang.String r2 = r2.concat(r1)
        L_0x013a:
            if (r7 == 0) goto L_0x0150
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " nanoseconds "
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x0150:
            java.lang.String r1 = "delay)"
            java.lang.String r2 = r2.concat(r1)
        L_0x0156:
            boolean r1 = r18.isDone()
            if (r1 == 0) goto L_0x0168
            java.lang.String r1 = " but future completed as timeout expired"
            java.lang.String r1 = r2.concat(r1)
            java.util.concurrent.TimeoutException r2 = new java.util.concurrent.TimeoutException
            r2.<init>(r1)
            throw r2
        L_0x0168:
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = " for "
            java.lang.String r2 = defpackage.xx.D(r2, r3, r6)
            r1.<init>(r2)
            throw r1
        L_0x0174:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgax.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public void zzb() {
    }

    public void zzq() {
    }
}
