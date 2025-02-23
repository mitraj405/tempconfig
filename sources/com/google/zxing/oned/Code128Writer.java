package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i);
        CType cType = CType.ONE_DIGIT;
        if (findCType3 != cType) {
            CType cType2 = CType.UNCODABLE;
            if (findCType3 == cType2) {
                if (i >= charSequence.length() || ((charAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || (charAt >= '`' && (charAt < 241 || charAt > 244))))) {
                    return 100;
                }
                return 101;
            } else if (i2 == 101 && findCType3 == CType.FNC_1) {
                return 101;
            } else {
                if (i2 == 99) {
                    return 99;
                }
                if (i2 == 100) {
                    CType cType3 = CType.FNC_1;
                    if (findCType3 == cType3 || (findCType = findCType(charSequence, i + 2)) == cType2 || findCType == cType) {
                        return 100;
                    }
                    if (findCType != cType3) {
                        int i3 = i + 4;
                        while (true) {
                            findCType2 = findCType(charSequence, i3);
                            if (findCType2 != CType.TWO_DIGITS) {
                                break;
                            }
                            i3 += 2;
                        }
                        if (findCType2 == CType.ONE_DIGIT) {
                            return 100;
                        }
                        return 99;
                    } else if (findCType(charSequence, i + 3) == CType.TWO_DIGITS) {
                        return 99;
                    } else {
                        return 100;
                    }
                } else {
                    if (findCType3 == CType.FNC_1) {
                        findCType3 = findCType(charSequence, i + 1);
                    }
                    if (findCType3 == CType.TWO_DIGITS) {
                        return 99;
                    }
                    return 100;
                }
            }
        } else if (i2 == 101) {
            return 101;
        } else {
            return 100;
        }
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int chooseCode = chooseCode(str, i3, i5);
                int i8 = 100;
                if (chooseCode == i5) {
                    switch (str.charAt(i3)) {
                        case 241:
                            i8 = 102;
                            break;
                        case 242:
                            i8 = 97;
                            break;
                        case 243:
                            i8 = 96;
                            break;
                        case 244:
                            if (i5 == 101) {
                                i8 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i5 != 100) {
                                if (i5 == 101) {
                                    i8 = str.charAt(i3) - ' ';
                                    if (i8 < 0) {
                                        i8 += 96;
                                        break;
                                    }
                                } else {
                                    i8 = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                                }
                            } else {
                                i8 = str.charAt(i3) - ' ';
                                break;
                            }
                            break;
                    }
                    i3++;
                } else {
                    if (i5 != 0) {
                        i7 = chooseCode;
                    } else if (chooseCode == 100) {
                        i7 = 104;
                    } else if (chooseCode != 101) {
                        i7 = 105;
                    }
                    i8 = i7;
                    i5 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i8]);
                i4 += i8 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                int[][] iArr = Code128Reader.CODE_PATTERNS;
                arrayList.add(iArr[i4 % 103]);
                arrayList.add(iArr[106]);
                Iterator it = arrayList.iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    for (int i10 : (int[]) it.next()) {
                        i9 += i10;
                    }
                }
                boolean[] zArr = new boolean[i9];
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i += OneDimensionalCodeWriter.appendPattern(zArr, i, (int[]) it2.next(), true);
                }
                return zArr;
            }
        }
    }

    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
