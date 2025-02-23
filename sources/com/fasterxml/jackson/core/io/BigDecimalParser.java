package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import java.util.Arrays;

public final class BigDecimalParser {
    private final char[] chars;

    public BigDecimalParser(char[] cArr) {
        this.chars = cArr;
    }

    private int adjustScale(int i, long j) {
        long j2 = ((long) i) - j;
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new NumberFormatException("Scale out of range: " + j2 + " while adjusting scale " + i + " to exponent " + j);
    }

    public static BigDecimal parse(String str) {
        return parse(str.toCharArray());
    }

    private BigDecimal parseBigDecimal(int i) {
        int i2;
        int i3;
        BigDecimal bigDecimal;
        int i4 = i;
        int length = this.chars.length;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        boolean z = false;
        boolean z2 = false;
        int i8 = 0;
        boolean z3 = false;
        for (int i9 = 0; i9 < length; i9++) {
            char c = this.chars[i9];
            if (c != '+') {
                if (c != 'E' && c != 'e') {
                    if (c != '-') {
                        if (c != '.') {
                            if (i6 >= 0 && i5 == -1) {
                                i7++;
                            }
                        } else if (i6 < 0) {
                            i6 = i9;
                        } else {
                            throw new NumberFormatException("Multiple decimal points");
                        }
                    } else if (i5 >= 0) {
                        if (z2) {
                            throw new NumberFormatException("Multiple signs in exponent");
                        }
                    } else if (!z) {
                        i8 = i9 + 1;
                        z = true;
                        z3 = true;
                    } else {
                        throw new NumberFormatException("Multiple signs in number");
                    }
                } else if (i5 < 0) {
                    i5 = i9;
                } else {
                    throw new NumberFormatException("Multiple exponent markers");
                }
            } else if (i5 >= 0) {
                if (z2) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
            } else if (!z) {
                i8 = i9 + 1;
                z = true;
            } else {
                throw new NumberFormatException("Multiple signs in number");
            }
            z2 = true;
        }
        if (i5 >= 0) {
            i2 = 1;
            i3 = Integer.parseInt(new String(this.chars, i5 + 1, (length - i5) - 1));
            i7 = adjustScale(i7, (long) i3);
            length = i5;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (i6 >= 0) {
            int i10 = (length - i6) - i2;
            bigDecimal = toBigDecimalRec(i8, i6 - i8, i3, i4).add(toBigDecimalRec(i6 + i2, i10, i3 - i10, i4));
        } else {
            bigDecimal = toBigDecimalRec(i8, length - i8, i3, i4);
        }
        if (i7 != 0) {
            bigDecimal = bigDecimal.setScale(i7);
        }
        if (z3) {
            return bigDecimal.negate();
        }
        return bigDecimal;
    }

    private BigDecimal toBigDecimalRec(int i, int i2, int i3, int i4) {
        if (i2 > i4) {
            int i5 = i2 / 2;
            return toBigDecimalRec(i, i5, (i3 + i2) - i5, i4).add(toBigDecimalRec(i + i5, i2 - i5, i3, i4));
        } else if (i2 == 0) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(this.chars, i, i2).movePointRight(i3);
        }
    }

    public static BigDecimal parse(char[] cArr, int i, int i2) {
        if (i > 0 || i2 != cArr.length) {
            cArr = Arrays.copyOfRange(cArr, i, i2 + i);
        }
        return parse(cArr);
    }

    public static BigDecimal parse(char[] cArr) {
        int length = cArr.length;
        if (length >= 500) {
            return new BigDecimalParser(cArr).parseBigDecimal(length / 10);
        }
        try {
            return new BigDecimal(cArr);
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Not a valid number representation";
            }
            throw new NumberFormatException("Value \"" + new String(cArr) + "\" can not be represented as `java.math.BigDecimal`, reason: " + message);
        }
    }
}
