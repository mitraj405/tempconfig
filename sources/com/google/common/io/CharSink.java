package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class CharSink {
    public Writer openBufferedStream() throws IOException {
        Writer openStream = openStream();
        if (openStream instanceof BufferedWriter) {
            return (BufferedWriter) openStream;
        }
        return new BufferedWriter(openStream);
    }

    public abstract Writer openStream() throws IOException;

    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            writer.append(charSequence);
            writer.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            long copy = CharStreams.copy(readable, writer);
            writer.flush();
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) throws IOException {
        writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(str);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openBufferedStream());
            for (CharSequence append : iterable) {
                writer.append(append).append(str);
            }
            writer.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
