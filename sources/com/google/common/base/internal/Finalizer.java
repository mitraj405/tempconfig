package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    private static final Constructor<Thread> bigThreadConstructor;
    public static final /* synthetic */ int c = 0;
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Field field;
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        if (bigThreadConstructor2 == null) {
            field = getInheritableThreadLocalsField();
        } else {
            field = null;
        }
        inheritableThreadLocals = field;
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = phantomReference;
    }

    private boolean cleanUp(Reference<?> reference) {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.queue.poll();
        } while (reference != null);
        return true;
    }

    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(new Class[]{ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE});
        } catch (Throwable unused) {
            return null;
        }
    }

    private Method getFinalizeReferentMethod() {
        Class cls = this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ all -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startFinalizer(java.lang.Class<?> r5, java.lang.ref.ReferenceQueue<java.lang.Object> r6, java.lang.ref.PhantomReference<java.lang.Object> r7) {
        /*
            java.lang.String r0 = r5.getName()
            java.lang.String r1 = "com.google.common.base.FinalizableReference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            com.google.common.base.internal.Finalizer r0 = new com.google.common.base.internal.Finalizer
            r0.<init>(r5, r6, r7)
            java.lang.Class<com.google.common.base.internal.Finalizer> r5 = com.google.common.base.internal.Finalizer.class
            java.lang.String r5 = r5.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r6 = bigThreadConstructor
            r7 = 1
            r1 = 0
            if (r6 == 0) goto L_0x0047
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x003d }
            r3 = 0
            r2[r3] = r1     // Catch:{ all -> 0x003d }
            r2[r7] = r0     // Catch:{ all -> 0x003d }
            r3 = 2
            r2[r3] = r5     // Catch:{ all -> 0x003d }
            r3 = 0
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x003d }
            r4 = 3
            r2[r4] = r3     // Catch:{ all -> 0x003d }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x003d }
            r4 = 4
            r2[r4] = r3     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r6.newInstance(r2)     // Catch:{ all -> 0x003d }
            java.lang.Thread r6 = (java.lang.Thread) r6     // Catch:{ all -> 0x003d }
            goto L_0x0048
        L_0x003d:
            r6 = move-exception
            java.util.logging.Logger r2 = logger
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r6)
        L_0x0047:
            r6 = r1
        L_0x0048:
            if (r6 != 0) goto L_0x004f
            java.lang.Thread r6 = new java.lang.Thread
            r6.<init>(r1, r0, r5)
        L_0x004f:
            r6.setDaemon(r7)
            java.lang.reflect.Field r5 = inheritableThreadLocals     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x0064
            r5.set(r6, r1)     // Catch:{ all -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r5 = move-exception
            java.util.logging.Logger r7 = logger
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r7.log(r0, r1, r5)
        L_0x0064:
            r6.start()
            return
        L_0x0068:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Expected com.google.common.base.FinalizableReference."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.startFinalizer(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:0|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:2:0x000a, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.ref.ReferenceQueue<java.lang.Object> r0 = r1.queue     // Catch:{ InterruptedException -> 0x0000 }
            java.lang.ref.Reference r0 = r0.remove()     // Catch:{ InterruptedException -> 0x0000 }
            boolean r0 = r1.cleanUp(r0)     // Catch:{ InterruptedException -> 0x0000 }
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.run():void");
    }
}
