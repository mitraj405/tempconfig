package com.google.zxing.datamatrix.encoder;

class C40Encoder implements Encoder {
    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    private static String encodeToCodewords(CharSequence charSequence) {
        int charAt = charSequence.charAt(1) * '(';
        int charAt2 = charSequence.charAt(2) + charAt + (charSequence.charAt(0) * 1600) + 1;
        return new String(new char[]{(char) (charAt2 / 256), (char) (charAt2 % 256)});
    }

    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb));
        sb.delete(0, 3);
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (encoderContext.hasMoreCharacters()) {
                if (sb.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && dataCapacity != 2) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
                while (sb.length() % 3 == 1 && (encodeChar > 3 || dataCapacity != 1)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
            }
        }
        handleEOD(encoderContext, sb);
    }

    public int encodeChar(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c <= 127) {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c - 128), sb) + 2;
        }
    }

    public int getEncodingMode() {
        return 1;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }
}
