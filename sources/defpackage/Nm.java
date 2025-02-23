package defpackage;

import defpackage.C1096ev;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;

/* renamed from: Nm  reason: default package */
/* compiled from: NewThreadWorker */
public class Nm extends Scheduler.a {
    public static volatile Object a;

    /* renamed from: a  reason: collision with other field name */
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f3715a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReference<ScheduledExecutorService> f3716a = new AtomicReference<>();
    public static final Object b = new Object();

    /* renamed from: b  reason: collision with other field name */
    public static final boolean f3717b;
    public static final int c = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3718a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f3719a;

    static {
        boolean z;
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i = C1518zp.a;
        if (z2 || (i != 0 && i < 21)) {
            z = false;
        } else {
            z = true;
        }
        f3717b = z;
    }

    public Nm(ThreadFactory threadFactory) {
        boolean z;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!e(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) newScheduledThreadPool;
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f3716a;
                if (atomicReference.get() != null) {
                    break;
                }
                ScheduledExecutorService newScheduledThreadPool2 = Executors.newScheduledThreadPool(1, new C0533Hu("RxSchedulerPurge-"));
                while (true) {
                    if (!atomicReference.compareAndSet((Object) null, newScheduledThreadPool2)) {
                        if (atomicReference.get() != null) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Mm mm = new Mm();
                    long j = (long) c;
                    newScheduledThreadPool2.scheduleAtFixedRate(mm, j, j, TimeUnit.MILLISECONDS);
                    break;
                }
                newScheduledThreadPool2.shutdownNow();
            }
            f3715a.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        }
        this.f3718a = newScheduledThreadPool;
    }

    public static Method c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static boolean e(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        if (f3717b) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = a;
                Object obj2 = b;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    method = c(scheduledExecutorService);
                    if (method != null) {
                        obj2 = method;
                    }
                    a = obj2;
                } else {
                    method = (Method) obj;
                }
            } else {
                method = c(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, new Object[]{Boolean.TRUE});
                    return true;
                } catch (InvocationTargetException e) {
                    C1520zu.a(e);
                } catch (IllegalAccessException e2) {
                    C1520zu.a(e2);
                } catch (IllegalArgumentException e3) {
                    C1520zu.a(e3);
                }
            }
        }
        return false;
    }

    public final Subscription b(C c2) {
        if (this.f3719a) {
            return C0455Ay.a;
        }
        return d(c2, 0, (TimeUnit) null);
    }

    public final C1096ev d(C c2, long j, TimeUnit timeUnit) {
        Future future;
        C1096ev evVar = new C1096ev(C1520zu.c(c2));
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        ScheduledExecutorService scheduledExecutorService = this.f3718a;
        if (i <= 0) {
            future = scheduledExecutorService.submit(evVar);
        } else {
            future = scheduledExecutorService.schedule(evVar, j, timeUnit);
        }
        evVar.f5457a.a(new C1096ev.a(future));
        return evVar;
    }

    public final boolean isUnsubscribed() {
        return this.f3719a;
    }

    public final void unsubscribe() {
        this.f3719a = true;
        this.f3718a.shutdownNow();
        f3715a.remove(this.f3718a);
    }
}
