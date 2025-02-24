package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    @GwtIncompatible
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    @GwtIncompatible
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    @GwtIncompatible
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    @GwtIncompatible
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Charsets() {
    }
}
