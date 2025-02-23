package com.fasterxml.jackson.core.io;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class UTF32Reader extends Reader {
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i2;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null ? true : z2;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            IOContext iOContext = this._context;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    private boolean loadMore(int i) throws IOException {
        byte[] bArr;
        InputStream inputStream = this._in;
        if (inputStream == null || (bArr = this._buffer) == null) {
            return false;
        }
        this._byteCount = (this._length - i) + this._byteCount;
        if (i > 0) {
            int i2 = this._ptr;
            if (i2 > 0) {
                System.arraycopy(bArr, i2, bArr, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            int read = inputStream.read(bArr);
            if (read < 1) {
                this._length = 0;
                if (read < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = read;
        }
        while (true) {
            int i3 = this._length;
            if (i3 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            byte[] bArr2 = this._buffer;
            int read2 = inputStream2.read(bArr2, i3, bArr2.length - i3);
            if (read2 < 1) {
                if (read2 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += read2;
        }
    }

    private void reportBounds(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length)}));
    }

    private void reportInvalid(int i, int i2, String str) throws IOException {
        StringBuilder sb = new StringBuilder("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(this._charCount + i2);
        sb.append(", byte #");
        throw new CharConversionException(lf.k(sb, (this._byteCount + this._ptr) - 1, ")"));
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i, int i2) throws IOException {
        int i3 = this._byteCount + i;
        int i4 = this._charCount;
        StringBuilder C = C1058d.C("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ", i, ", needed ", i2, ", at char #");
        C.append(i4);
        C.append(", byte #");
        C.append(i3);
        C.append(")");
        throw new CharConversionException(C.toString());
    }

    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        byte b;
        byte b2;
        if (this._buffer == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            reportBounds(cArr, i, i2);
        }
        int i4 = i2 + i;
        char c = this._surrogate;
        if (c != 0) {
            i3 = i + 1;
            cArr[i] = c;
            this._surrogate = 0;
        } else {
            int i5 = this._length - this._ptr;
            if (i5 < 4 && !loadMore(i5)) {
                if (i5 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i3 = i;
        }
        int i6 = this._length - 4;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int i7 = this._ptr;
            if (i7 > i6) {
                break;
            }
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                b = (bArr[i7] << 8) | (bArr[i7 + 1] & UnsignedBytes.MAX_VALUE);
                b2 = (bArr[i7 + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i7 + 2] & UnsignedBytes.MAX_VALUE) << 8);
            } else {
                byte[] bArr2 = this._buffer;
                byte b3 = (bArr2[i7] & UnsignedBytes.MAX_VALUE) | ((bArr2[i7 + 1] & UnsignedBytes.MAX_VALUE) << 8);
                b = (bArr2[i7 + 3] << 8) | (bArr2[i7 + 2] & UnsignedBytes.MAX_VALUE);
                b2 = b3;
            }
            this._ptr = i7 + 4;
            if (b != 0) {
                byte b4 = 65535 & b;
                byte b5 = b2 | ((b4 - 1) << 16);
                if (b4 > 16) {
                    reportInvalid(b5, i3 - i, String.format(" (above 0x%08x)", new Object[]{1114111}));
                }
                int i8 = i3 + 1;
                cArr[i3] = (char) ((b5 >> 10) + 55296);
                byte b6 = (b5 & UnsignedBytes.MAX_VALUE) | Ascii.NUL;
                if (i8 >= i4) {
                    this._surrogate = (char) b5;
                    i3 = i8;
                    break;
                }
                b2 = b6;
                i3 = i8;
            }
            cArr[i3] = (char) b2;
            i3++;
        }
        int i9 = i3 - i;
        this._charCount += i9;
        return i9;
    }
}
