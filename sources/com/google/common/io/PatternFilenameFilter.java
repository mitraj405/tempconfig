package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@Beta
public final class PatternFilenameFilter implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }

    public PatternFilenameFilter(Pattern pattern2) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern2);
    }
}
