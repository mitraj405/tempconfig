package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class TextBuffer {
    static final char[] NO_CHARS = new char[0];
    private final BufferRecycler _allocator;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _hasSegments;
    private char[] _inputBuffer;
    private int _inputLen;
    private int _inputStart;
    private char[] _resultArray;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this._allocator = bufferRecycler;
    }

    private char[] buf(int i) {
        BufferRecycler bufferRecycler = this._allocator;
        if (bufferRecycler != null) {
            return bufferRecycler.allocCharBuffer(2, i);
        }
        return new char[Math.max(i, 500)];
    }

    private char[] carr(int i) {
        return new char[i];
    }

    private void clearSegments() {
        this._hasSegments = false;
        this._segments.clear();
        this._segmentSize = 0;
        this._currentSize = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r3 > 65536) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void expand(int r3) {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r3 = r2._segments
            if (r3 != 0) goto L_0x000b
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2._segments = r3
        L_0x000b:
            char[] r3 = r2._currentSegment
            r0 = 1
            r2._hasSegments = r0
            java.util.ArrayList<char[]> r0 = r2._segments
            r0.add(r3)
            int r0 = r2._segmentSize
            int r1 = r3.length
            int r0 = r0 + r1
            r2._segmentSize = r0
            r0 = 0
            r2._currentSize = r0
            int r3 = r3.length
            int r0 = r3 >> 1
            int r3 = r3 + r0
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 >= r0) goto L_0x0028
        L_0x0026:
            r3 = r0
            goto L_0x002d
        L_0x0028:
            r0 = 65536(0x10000, float:9.18355E-41)
            if (r3 <= r0) goto L_0x002d
            goto L_0x0026
        L_0x002d:
            char[] r3 = r2.carr(r3)
            r2._currentSegment = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.expand(int):void");
    }

    public static TextBuffer fromInitial(char[] cArr) {
        return new TextBuffer((BufferRecycler) null, cArr);
    }

    private char[] resultArray() {
        int i;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        int i2 = this._inputStart;
        if (i2 >= 0) {
            int i3 = this._inputLen;
            if (i3 < 1) {
                return NO_CHARS;
            }
            if (i2 == 0) {
                return Arrays.copyOf(this._inputBuffer, i3);
            }
            return Arrays.copyOfRange(this._inputBuffer, i2, i3 + i2);
        }
        int size = size();
        if (size < 1) {
            return NO_CHARS;
        }
        char[] carr = carr(size);
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                char[] cArr = this._segments.get(i4);
                int length = cArr.length;
                System.arraycopy(cArr, 0, carr, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this._currentSegment, 0, carr, i, this._currentSize);
        return carr;
    }

    private void unshare(int i) {
        int i2 = this._inputLen;
        this._inputLen = 0;
        char[] cArr = this._inputBuffer;
        this._inputBuffer = null;
        int i3 = this._inputStart;
        this._inputStart = -1;
        int i4 = i + i2;
        char[] cArr2 = this._currentSegment;
        if (cArr2 == null || i4 > cArr2.length) {
            this._currentSegment = buf(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this._currentSegment, 0, i2);
        }
        this._segmentSize = 0;
        this._currentSize = i2;
    }

    public void append(char c) {
        if (this._inputStart >= 0) {
            unshare(16);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        if (this._currentSize >= cArr.length) {
            expand(1);
            cArr = this._currentSegment;
        }
        int i = this._currentSize;
        this._currentSize = i + 1;
        cArr[i] = c;
    }

    public char[] contentsAsArray() {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] resultArray = resultArray();
        this._resultArray = resultArray;
        return resultArray;
    }

    public BigDecimal contentsAsDecimal() throws NumberFormatException {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this._resultArray;
        if (cArr3 != null) {
            return NumberInput.parseBigDecimal(cArr3);
        }
        int i = this._inputStart;
        if (i >= 0 && (cArr2 = this._inputBuffer) != null) {
            return NumberInput.parseBigDecimal(cArr2, i, this._inputLen);
        }
        if (this._segmentSize != 0 || (cArr = this._currentSegment) == null) {
            return NumberInput.parseBigDecimal(contentsAsArray());
        }
        return NumberInput.parseBigDecimal(cArr, 0, this._currentSize);
    }

    public double contentsAsDouble() throws NumberFormatException {
        return NumberInput.parseDouble(contentsAsString());
    }

    public int contentsAsInt(boolean z) {
        char[] cArr;
        int i = this._inputStart;
        if (i < 0 || (cArr = this._inputBuffer) == null) {
            if (z) {
                return -NumberInput.parseInt(this._currentSegment, 1, this._currentSize - 1);
            }
            return NumberInput.parseInt(this._currentSegment, 0, this._currentSize);
        } else if (z) {
            return -NumberInput.parseInt(cArr, i + 1, this._inputLen - 1);
        } else {
            return NumberInput.parseInt(cArr, i, this._inputLen);
        }
    }

    public long contentsAsLong(boolean z) {
        char[] cArr;
        int i = this._inputStart;
        if (i < 0 || (cArr = this._inputBuffer) == null) {
            if (z) {
                return -NumberInput.parseLong(this._currentSegment, 1, this._currentSize - 1);
            }
            return NumberInput.parseLong(this._currentSegment, 0, this._currentSize);
        } else if (z) {
            return -NumberInput.parseLong(cArr, i + 1, this._inputLen - 1);
        } else {
            return NumberInput.parseLong(cArr, i, this._inputLen);
        }
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            char[] cArr = this._resultArray;
            if (cArr != null) {
                this._resultString = new String(cArr);
            } else {
                int i = this._inputStart;
                String str = "";
                if (i >= 0) {
                    int i2 = this._inputLen;
                    if (i2 < 1) {
                        this._resultString = str;
                        return str;
                    }
                    this._resultString = new String(this._inputBuffer, i, i2);
                } else {
                    int i3 = this._segmentSize;
                    int i4 = this._currentSize;
                    if (i3 == 0) {
                        if (i4 != 0) {
                            str = new String(this._currentSegment, 0, i4);
                        }
                        this._resultString = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList<char[]> arrayList = this._segments;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = this._segments.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this._currentSegment, 0, this._currentSize);
                        this._resultString = sb.toString();
                    }
                }
            }
        }
        return this._resultString;
    }

    public char[] emptyAndGetCurrentSegment() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        char[] cArr = this._currentSegment;
        if (cArr != null) {
            return cArr;
        }
        char[] buf = buf(0);
        this._currentSegment = buf;
        return buf;
    }

    public char[] expandCurrentSegment() {
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 65536) {
            i = (length >> 2) + length;
        }
        char[] copyOf = Arrays.copyOf(cArr, i);
        this._currentSegment = copyOf;
        return copyOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r0 > 65536) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] finishCurrentSegment() {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r0 = r2._segments
            if (r0 != 0) goto L_0x000b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2._segments = r0
        L_0x000b:
            r0 = 1
            r2._hasSegments = r0
            java.util.ArrayList<char[]> r0 = r2._segments
            char[] r1 = r2._currentSegment
            r0.add(r1)
            char[] r0 = r2._currentSegment
            int r0 = r0.length
            int r1 = r2._segmentSize
            int r1 = r1 + r0
            r2._segmentSize = r1
            r1 = 0
            r2._currentSize = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L_0x0029
        L_0x0027:
            r0 = r1
            goto L_0x002e
        L_0x0029:
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r0 <= r1) goto L_0x002e
            goto L_0x0027
        L_0x002e:
            char[] r0 = r2.carr(r0)
            r2._currentSegment = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.finishCurrentSegment():char[]");
    }

    public char[] getCurrentSegment() {
        if (this._inputStart >= 0) {
            unshare(1);
        } else {
            char[] cArr = this._currentSegment;
            if (cArr == null) {
                this._currentSegment = buf(0);
            } else if (this._currentSize >= cArr.length) {
                expand(1);
            }
        }
        return this._currentSegment;
    }

    public int getCurrentSegmentSize() {
        return this._currentSize;
    }

    public char[] getTextBuffer() {
        if (this._inputStart >= 0) {
            return this._inputBuffer;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        String str = this._resultString;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this._resultArray = charArray;
            return charArray;
        } else if (this._hasSegments) {
            return contentsAsArray();
        } else {
            char[] cArr2 = this._currentSegment;
            if (cArr2 == null) {
                return NO_CHARS;
            }
            return cArr2;
        }
    }

    public int getTextOffset() {
        int i = this._inputStart;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public void releaseBuffers() {
        char[] cArr;
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        BufferRecycler bufferRecycler = this._allocator;
        if (bufferRecycler != null && (cArr = this._currentSegment) != null) {
            this._currentSegment = null;
            bufferRecycler.releaseCharBuffer(2, cArr);
        }
    }

    public void resetWithCopy(char[] cArr, int i, int i2) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(i2);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(cArr, i, i2);
    }

    public void resetWithShared(char[] cArr, int i, int i2) {
        this._resultString = null;
        this._resultArray = null;
        this._inputBuffer = cArr;
        this._inputStart = i;
        this._inputLen = i2;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithString(String str) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = str;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        this._currentSize = 0;
    }

    public String setCurrentAndReturn(int i) {
        String str;
        this._currentSize = i;
        if (this._segmentSize > 0) {
            return contentsAsString();
        }
        if (i == 0) {
            str = "";
        } else {
            str = new String(this._currentSegment, 0, i);
        }
        this._resultString = str;
        return str;
    }

    public void setCurrentLength(int i) {
        this._currentSize = i;
    }

    public int size() {
        if (this._inputStart >= 0) {
            return this._inputLen;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this._resultString;
        if (str != null) {
            return str.length();
        }
        return this._segmentSize + this._currentSize;
    }

    public String toString() {
        return contentsAsString();
    }

    public TextBuffer(BufferRecycler bufferRecycler, char[] cArr) {
        this._allocator = bufferRecycler;
        this._currentSegment = cArr;
        this._currentSize = cArr.length;
        this._inputStart = -1;
    }

    public void append(char[] cArr, int i, int i2) {
        if (this._inputStart >= 0) {
            unshare(i2);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr2 = this._currentSegment;
        int length = cArr2.length;
        int i3 = this._currentSize;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this._currentSize += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            expand(i2);
            int min = Math.min(this._currentSegment.length, i2);
            System.arraycopy(cArr, i, this._currentSegment, 0, min);
            this._currentSize += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public void append(String str, int i, int i2) {
        if (this._inputStart >= 0) {
            unshare(i2);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i3 = this._currentSize;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this._currentSize += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            expand(i2);
            int min = Math.min(this._currentSegment.length, i2);
            int i6 = i + min;
            str.getChars(i, i6, this._currentSegment, 0);
            this._currentSize += min;
            i2 -= min;
            if (i2 > 0) {
                i = i6;
            } else {
                return;
            }
        }
    }
}
