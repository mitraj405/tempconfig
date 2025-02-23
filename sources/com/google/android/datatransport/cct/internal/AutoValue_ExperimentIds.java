package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExperimentIds;
import java.util.Arrays;

final class AutoValue_ExperimentIds extends ExperimentIds {
    private final byte[] clearBlob;
    private final byte[] encryptedBlob;

    public static final class Builder extends ExperimentIds.Builder {
        private byte[] clearBlob;
        private byte[] encryptedBlob;

        public ExperimentIds build() {
            return new AutoValue_ExperimentIds(this.clearBlob, this.encryptedBlob);
        }

        public ExperimentIds.Builder setClearBlob(byte[] bArr) {
            this.clearBlob = bArr;
            return this;
        }

        public ExperimentIds.Builder setEncryptedBlob(byte[] bArr) {
            this.encryptedBlob = bArr;
            return this;
        }
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExperimentIds)) {
            return false;
        }
        ExperimentIds experimentIds = (ExperimentIds) obj;
        byte[] bArr3 = this.clearBlob;
        boolean z = experimentIds instanceof AutoValue_ExperimentIds;
        if (z) {
            bArr = ((AutoValue_ExperimentIds) experimentIds).clearBlob;
        } else {
            bArr = experimentIds.getClearBlob();
        }
        if (Arrays.equals(bArr3, bArr)) {
            byte[] bArr4 = this.encryptedBlob;
            if (z) {
                bArr2 = ((AutoValue_ExperimentIds) experimentIds).encryptedBlob;
            } else {
                bArr2 = experimentIds.getEncryptedBlob();
            }
            if (Arrays.equals(bArr4, bArr2)) {
                return true;
            }
        }
        return false;
    }

    public byte[] getClearBlob() {
        return this.clearBlob;
    }

    public byte[] getEncryptedBlob() {
        return this.encryptedBlob;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.clearBlob) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.encryptedBlob);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.clearBlob) + ", encryptedBlob=" + Arrays.toString(this.encryptedBlob) + "}";
    }

    private AutoValue_ExperimentIds(byte[] bArr, byte[] bArr2) {
        this.clearBlob = bArr;
        this.encryptedBlob = bArr2;
    }
}
