package com.google.zxing.datamatrix.encoder;

import com.google.firebase.perf.util.Constants;

final class EdifactEncoder implements Encoder {
    private static void encodeChar(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    private static String encodeToCodewords(CharSequence charSequence) {
        char c;
        char c2;
        int length = charSequence.length();
        if (length != 0) {
            char c3 = 0;
            char charAt = charSequence.charAt(0);
            if (length >= 2) {
                c = charSequence.charAt(1);
            } else {
                c = 0;
            }
            if (length >= 3) {
                c2 = charSequence.charAt(2);
            } else {
                c2 = 0;
            }
            if (length >= 4) {
                c3 = charSequence.charAt(3);
            }
            int i = (charAt << 18) + (c << 12) + (c2 << 6) + c3;
            char c4 = (char) ((i >> 8) & Constants.MAX_HOST_LENGTH);
            char c5 = (char) (i & Constants.MAX_HOST_LENGTH);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i >> 16) & Constants.MAX_HOST_LENGTH));
            if (length >= 2) {
                sb.append(c4);
            }
            if (length >= 3) {
                sb.append(c5);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    encoderContext.updateSymbolInfo();
                    int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    int remainingCharacters = encoderContext.getRemainingCharacters();
                    if (remainingCharacters > dataCapacity) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + 1);
                        dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    }
                    if (remainingCharacters <= dataCapacity && dataCapacity <= 2) {
                        encoderContext.signalEncoderChange(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i = length - 1;
                    String encodeToCodewords = encodeToCodewords(charSequence);
                    if (!(!encoderContext.hasMoreCharacters()) || i > 2) {
                        z = false;
                    }
                    if (i <= 2) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i);
                        if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                            z = false;
                        }
                    }
                    if (z) {
                        encoderContext.resetSymbolInfo();
                        encoderContext.pos -= i;
                    } else {
                        encoderContext.writeCodewords(encodeToCodewords);
                    }
                    encoderContext.signalEncoderChange(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append(31);
        handleEOD(encoderContext, sb);
    }

    public int getEncodingMode() {
        return 4;
    }
}
