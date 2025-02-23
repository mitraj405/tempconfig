package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask {
    DATA_MASK_000 {
        public boolean isMasked(int i, int i2) {
            if (((i + i2) & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_001 {
        public boolean isMasked(int i, int i2) {
            if ((i & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_010 {
        public boolean isMasked(int i, int i2) {
            if (i2 % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_011 {
        public boolean isMasked(int i, int i2) {
            if ((i + i2) % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_100 {
        public boolean isMasked(int i, int i2) {
            if ((((i2 / 3) + (i / 2)) & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_101 {
        public boolean isMasked(int i, int i2) {
            if ((i * i2) % 6 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_110 {
        public boolean isMasked(int i, int i2) {
            if ((i * i2) % 6 < 3) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_111 {
        public boolean isMasked(int i, int i2) {
            if (((((i * i2) % 3) + i + i2) & 1) == 0) {
                return true;
            }
            return false;
        }
    };

    public abstract boolean isMasked(int i, int i2);

    public final void unmaskBitMatrix(BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    bitMatrix.flip(i3, i2);
                }
            }
        }
    }
}
