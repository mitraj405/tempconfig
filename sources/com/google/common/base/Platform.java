package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler patternCompiler = loadPatternCompiler();

    public static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        public CommonPattern compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        public boolean isPcreLike() {
            return true;
        }
    }

    private Platform() {
    }

    public static CommonPattern compilePattern(String str) {
        Preconditions.checkNotNull(str);
        return patternCompiler.compile(str);
    }

    public static String emptyToNull(String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String formatCompact4Digits(double d) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(d)});
    }

    public static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> cls, String str) {
        WeakReference weakReference = Enums.getEnumConstants(cls).get(str);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.of((Enum) cls.cast(weakReference.get()));
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    private static void logPatternCompilerError(ServiceConfigurationError serviceConfigurationError) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", serviceConfigurationError);
    }

    public static String nullToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    public static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    public static boolean stringIsNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static long systemNanoTime() {
        return System.nanoTime();
    }

    public static void checkGwtRpcEnabled() {
    }
}
