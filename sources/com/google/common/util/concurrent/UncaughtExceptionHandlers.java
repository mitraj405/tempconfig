package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class UncaughtExceptionHandlers {

    @VisibleForTesting
    public static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = Logger.getLogger(Exiter.class.getName());
        private final Runtime runtime;

        public Exiter(Runtime runtime2) {
            this.runtime = runtime2;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{thread}), th);
            } catch (Throwable th2) {
                this.runtime.exit(1);
                throw th2;
            }
            this.runtime.exit(1);
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }
}
