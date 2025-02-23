package com.google.firebase.logger;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Logger.kt */
public abstract class Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, Logger> loggers = new ConcurrentHashMap<>();
    private boolean enabled;
    private Level minLevel;
    private final String tag;

    /* compiled from: Logger.kt */
    public static final class AndroidLogger extends Logger {

        /* compiled from: Logger.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.google.firebase.logger.Logger$Level[] r0 = com.google.firebase.logger.Logger.Level.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.INFO     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.WARN     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.logger.Logger.AndroidLogger.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AndroidLogger(String str, boolean z, Level level) {
            super(str, z, level, (DefaultConstructorMarker) null);
            C1177ig.f(str, "tag");
            C1177ig.f(level, "minLevel");
        }

        public int log(Level level, String str, Object[] objArr, Throwable th) {
            boolean z;
            C1177ig.f(level, FirebaseAnalytics.Param.LEVEL);
            C1177ig.f(str, "format");
            C1177ig.f(objArr, "args");
            if (objArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                C1177ig.e(str, "format(format, *args)");
            }
            int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i == 1) {
                String tag = getTag();
                if (th != null) {
                    return Log.v(tag, str, th);
                }
                return Log.v(tag, str);
            } else if (i == 2) {
                String tag2 = getTag();
                if (th != null) {
                    return Log.d(tag2, str, th);
                }
                return Log.d(tag2, str);
            } else if (i == 3) {
                String tag3 = getTag();
                if (th != null) {
                    return Log.i(tag3, str, th);
                }
                return Log.i(tag3, str);
            } else if (i == 4) {
                String tag4 = getTag();
                if (th != null) {
                    return Log.w(tag4, str, th);
                }
                return Log.w(tag4, str);
            } else if (i == 5) {
                String tag5 = getTag();
                if (th != null) {
                    return Log.e(tag5, str, th);
                }
                return Log.e(tag5, str);
            } else {
                throw new V5();
            }
        }
    }

    /* compiled from: Logger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Logger getLogger$default(Companion companion, String str, boolean z, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                level = Level.INFO;
            }
            return companion.getLogger(str, z, level);
        }

        public static /* synthetic */ FakeLogger setupFakeLogger$default(Companion companion, String str, boolean z, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                level = Level.DEBUG;
            }
            return companion.setupFakeLogger(str, z, level);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r1 = new com.google.firebase.logger.Logger.AndroidLogger(r3, r4, r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.firebase.logger.Logger getLogger(java.lang.String r3, boolean r4, com.google.firebase.logger.Logger.Level r5) {
            /*
                r2 = this;
                java.lang.String r0 = "tag"
                defpackage.C1177ig.f(r3, r0)
                java.lang.String r0 = "minLevel"
                defpackage.C1177ig.f(r5, r0)
                java.util.concurrent.ConcurrentHashMap r0 = com.google.firebase.logger.Logger.loggers
                java.lang.Object r1 = r0.get(r3)
                if (r1 != 0) goto L_0x0021
                com.google.firebase.logger.Logger$AndroidLogger r1 = new com.google.firebase.logger.Logger$AndroidLogger
                r1.<init>(r3, r4, r5)
                java.lang.Object r3 = r0.putIfAbsent(r3, r1)
                if (r3 != 0) goto L_0x0020
                goto L_0x0021
            L_0x0020:
                r1 = r3
            L_0x0021:
                com.google.firebase.logger.Logger r1 = (com.google.firebase.logger.Logger) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.logger.Logger.Companion.getLogger(java.lang.String, boolean, com.google.firebase.logger.Logger$Level):com.google.firebase.logger.Logger");
        }

        public final FakeLogger setupFakeLogger(String str, boolean z, Level level) {
            C1177ig.f(str, "tag");
            C1177ig.f(level, "minLevel");
            FakeLogger fakeLogger = new FakeLogger(str, z, level);
            Logger.loggers.put(str, fakeLogger);
            return fakeLogger;
        }
    }

    /* compiled from: Logger.kt */
    public static final class FakeLogger extends Logger {
        private final List<String> record = new ArrayList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FakeLogger(String str, boolean z, Level level) {
            super(str, z, level, (DefaultConstructorMarker) null);
            C1177ig.f(str, "tag");
            C1177ig.f(level, "minLevel");
        }

        private final String toLogMessage(Level level, String str, Object[] objArr, Throwable th) {
            boolean z;
            if (objArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                C1177ig.e(str, "format(format, *args)");
            }
            if (th != null) {
                String str2 = level + ' ' + str + ' ' + Log.getStackTraceString(th);
                if (str2 != null) {
                    return str2;
                }
            }
            return level + ' ' + str;
        }

        public final void clearLogMessages() {
            this.record.clear();
        }

        public final boolean hasLogMessage(String str) {
            boolean z;
            C1177ig.f(str, "message");
            Iterable<String> iterable = this.record;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (String str2 : iterable) {
                C1177ig.f(str2, "<this>");
                if (C1337py.Y0(str2, str, 0, false, 2) >= 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public final boolean hasLogMessageThat(Function1<? super String, Boolean> function1) {
            C1177ig.f(function1, "predicate");
            Iterable<Object> iterable = this.record;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (Object invoke : iterable) {
                if (function1.invoke(invoke).booleanValue()) {
                    return true;
                }
            }
            return false;
        }

        public int log(Level level, String str, Object[] objArr, Throwable th) {
            C1177ig.f(level, FirebaseAnalytics.Param.LEVEL);
            C1177ig.f(str, "format");
            C1177ig.f(objArr, "args");
            String logMessage = toLogMessage(level, str, objArr, th);
            System.out.println(C0709Uj.i("Log: ", logMessage));
            this.record.add(logMessage);
            return logMessage.length();
        }
    }

    /* compiled from: Logger.kt */
    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        private final int priority;

        private Level(int i) {
            this.priority = i;
        }

        public final int getPriority$com_google_firebase_firebase_common() {
            return this.priority;
        }
    }

    public /* synthetic */ Logger(String str, boolean z, Level level, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, level);
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            return logger.debug(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            return logger.error(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static final Logger getLogger(String str, boolean z, Level level) {
        return Companion.getLogger(str, z, level);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            return logger.info(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
    }

    private final int logIfAble(Level level, String str, Object[] objArr, Throwable th) {
        if (!this.enabled || (this.minLevel.getPriority$com_google_firebase_firebase_common() > level.getPriority$com_google_firebase_firebase_common() && !Log.isLoggable(this.tag, level.getPriority$com_google_firebase_firebase_common()))) {
            return 0;
        }
        return log(level, str, objArr, th);
    }

    public static /* synthetic */ int logIfAble$default(Logger logger, Level level, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                objArr = new Object[0];
            }
            return logger.logIfAble(level, str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logIfAble");
    }

    public static final FakeLogger setupFakeLogger(String str, boolean z, Level level) {
        return Companion.setupFakeLogger(str, z, level);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            return logger.verbose(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            return logger.warn(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
    }

    public final int debug(String str) {
        C1177ig.f(str, "msg");
        return debug$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public final int error(String str) {
        C1177ig.f(str, "msg");
        return error$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Level getMinLevel() {
        return this.minLevel;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int info(String str) {
        C1177ig.f(str, "msg");
        return info$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public abstract int log(Level level, String str, Object[] objArr, Throwable th);

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setMinLevel(Level level) {
        C1177ig.f(level, "<set-?>");
        this.minLevel = level;
    }

    public final int verbose(String str) {
        C1177ig.f(str, "msg");
        return verbose$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public final int warn(String str) {
        C1177ig.f(str, "msg");
        return warn$default(this, str, (Throwable) null, 2, (Object) null);
    }

    private Logger(String str, boolean z, Level level) {
        this.tag = str;
        this.enabled = z;
        this.minLevel = level;
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            return logger.debug(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            return logger.error(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            return logger.info(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            return logger.verbose(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            return logger.warn(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
    }

    public final int debug(String str, Object... objArr) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return debug$default(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    public final int error(String str, Object... objArr) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return error$default(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    public final int info(String str, Object... objArr) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return info$default(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    public final int verbose(String str, Object... objArr) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return verbose$default(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    public final int warn(String str, Object... objArr) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return warn$default(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    public final int debug(String str, Object[] objArr, Throwable th) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return logIfAble(Level.DEBUG, str, objArr, th);
    }

    public final int error(String str, Object[] objArr, Throwable th) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return logIfAble(Level.ERROR, str, objArr, th);
    }

    public final int info(String str, Object[] objArr, Throwable th) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return logIfAble(Level.INFO, str, objArr, th);
    }

    public final int verbose(String str, Object[] objArr, Throwable th) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return logIfAble(Level.VERBOSE, str, objArr, th);
    }

    public final int warn(String str, Object[] objArr, Throwable th) {
        C1177ig.f(str, "format");
        C1177ig.f(objArr, "args");
        return logIfAble(Level.WARN, str, objArr, th);
    }

    public final int debug(String str, Throwable th) {
        C1177ig.f(str, "msg");
        return logIfAble$default(this, Level.DEBUG, str, (Object[]) null, th, 4, (Object) null);
    }

    public final int error(String str, Throwable th) {
        C1177ig.f(str, "msg");
        return logIfAble$default(this, Level.ERROR, str, (Object[]) null, th, 4, (Object) null);
    }

    public final int info(String str, Throwable th) {
        C1177ig.f(str, "msg");
        return logIfAble$default(this, Level.INFO, str, (Object[]) null, th, 4, (Object) null);
    }

    public final int verbose(String str, Throwable th) {
        C1177ig.f(str, "msg");
        return logIfAble$default(this, Level.VERBOSE, str, (Object[]) null, th, 4, (Object) null);
    }

    public final int warn(String str, Throwable th) {
        C1177ig.f(str, "msg");
        return logIfAble$default(this, Level.WARN, str, (Object[]) null, th, 4, (Object) null);
    }
}
