package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedString implements SerializableString, Serializable {
    private static final JsonStringEncoder JSON_ENCODER = JsonStringEncoder.getInstance();
    private static final long serialVersionUID = 1;
    protected transient String _jdkSerializeValue;
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;

    public SerializedString(String str) {
        if (str != null) {
            this._value = str;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this._jdkSerializeValue = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    public int appendQuoted(char[] cArr, int i) {
        char[] cArr2 = this._quotedChars;
        if (cArr2 == null) {
            cArr2 = JSON_ENCODER.quoteAsString(this._value);
            this._quotedChars = cArr2;
        }
        int length = cArr2.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArr2, 0, cArr, i, length);
        return length;
    }

    public int appendQuotedUTF8(byte[] bArr, int i) {
        byte[] bArr2 = this._quotedUTF8Ref;
        if (bArr2 == null) {
            bArr2 = JSON_ENCODER.quoteAsUTF8(this._value);
            this._quotedUTF8Ref = bArr2;
        }
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    public int appendUnquoted(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    public int appendUnquotedUTF8(byte[] bArr, int i) {
        byte[] bArr2 = this._unquotedUTF8Ref;
        if (bArr2 == null) {
            bArr2 = JSON_ENCODER.encodeAsUTF8(this._value);
            this._unquotedUTF8Ref = bArr2;
        }
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    public final char[] asQuotedChars() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        char[] quoteAsString = JSON_ENCODER.quoteAsString(this._value);
        this._quotedChars = quoteAsString;
        return quoteAsString;
    }

    public final byte[] asQuotedUTF8() {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        byte[] quoteAsUTF8 = JSON_ENCODER.quoteAsUTF8(this._value);
        this._quotedUTF8Ref = quoteAsUTF8;
        return quoteAsUTF8;
    }

    public final byte[] asUnquotedUTF8() {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        byte[] encodeAsUTF8 = JSON_ENCODER.encodeAsUTF8(this._value);
        this._unquotedUTF8Ref = encodeAsUTF8;
        return encodeAsUTF8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this._value.equals(((SerializedString) obj)._value);
    }

    public final String getValue() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public Object readResolve() {
        return new SerializedString(this._jdkSerializeValue);
    }

    public final String toString() {
        return this._value;
    }
}
