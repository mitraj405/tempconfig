package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c) {
        if (i >= str.length() || str.charAt(i) != c) {
            return false;
        }
        return true;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ac A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            r1 = r19
            r2 = r20
            java.lang.String r0 = "Mismatching time zone indicator: "
            java.lang.String r3 = "GMT"
            java.lang.String r4 = "00"
            java.lang.String r5 = "Invalid time zone indicator '"
            int r6 = r20.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            int r7 = r6 + 4
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r8 = 45
            boolean r9 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r9 == 0) goto L_0x0020
            int r7 = r7 + 1
        L_0x0020:
            int r9 = r7 + 2
            int r7 = parseInt(r1, r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            boolean r10 = checkOffset(r1, r9, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r10 == 0) goto L_0x002e
            int r9 = r9 + 1
        L_0x002e:
            int r10 = r9 + 2
            int r9 = parseInt(r1, r9, r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r11 = 84
            boolean r11 = checkOffset(r1, r10, r11)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r12 = 0
            r13 = 1
            if (r11 != 0) goto L_0x0055
            int r14 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r14 > r10) goto L_0x0055
            java.util.GregorianCalendar r0 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            int r7 = r7 - r13
            r0.<init>(r6, r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r0.setLenient(r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r2.setIndex(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            java.util.Date r0 = r0.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            return r0
        L_0x0055:
            r14 = 43
            r15 = 90
            if (r11 == 0) goto L_0x00d1
            int r10 = r10 + 1
            int r11 = r10 + 2
            int r10 = parseInt(r1, r10, r11)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r12 = 58
            boolean r16 = checkOffset(r1, r11, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r16 == 0) goto L_0x006d
            int r11 = r11 + 1
        L_0x006d:
            int r13 = r11 + 2
            int r11 = parseInt(r1, r11, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            boolean r12 = checkOffset(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r12 == 0) goto L_0x007b
            int r13 = r13 + 1
        L_0x007b:
            int r12 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r12 <= r13) goto L_0x00ce
            char r12 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r12 == r15) goto L_0x00ce
            if (r12 == r14) goto L_0x00ce
            if (r12 == r8) goto L_0x00ce
            int r12 = r13 + 2
            int r13 = parseInt(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r8 = 59
            if (r13 <= r8) goto L_0x009b
            r8 = 63
            if (r13 >= r8) goto L_0x009b
            r13 = 59
        L_0x009b:
            r8 = 46
            boolean r8 = checkOffset(r1, r12, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r8 == 0) goto L_0x00ca
            int r12 = r12 + 1
            int r8 = r12 + 1
            int r8 = indexOfNonDigit(r1, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            int r14 = r12 + 3
            int r14 = java.lang.Math.min(r8, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            int r17 = parseInt(r1, r12, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            int r14 = r14 - r12
            r12 = 1
            if (r14 == r12) goto L_0x00c0
            r12 = 2
            if (r14 == r12) goto L_0x00bd
            goto L_0x00c2
        L_0x00bd:
            int r17 = r17 * 10
            goto L_0x00c2
        L_0x00c0:
            int r17 = r17 * 100
        L_0x00c2:
            r12 = r17
            r18 = r10
            r10 = r8
            r8 = r18
            goto L_0x00d5
        L_0x00ca:
            r8 = r10
            r10 = r12
            r12 = 0
            goto L_0x00d5
        L_0x00ce:
            r8 = r10
            r10 = r13
            goto L_0x00d3
        L_0x00d1:
            r8 = 0
            r11 = 0
        L_0x00d3:
            r12 = 0
            r13 = 0
        L_0x00d5:
            int r14 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            if (r14 <= r10) goto L_0x01ac
            char r14 = r1.charAt(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            r2 = 5
            if (r14 != r15) goto L_0x00f1
            java.util.TimeZone r0 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r3 = 1
            int r10 = r10 + r3
            goto L_0x0179
        L_0x00e8:
            r0 = move-exception
        L_0x00e9:
            r2 = r20
            goto L_0x01b9
        L_0x00ed:
            r0 = move-exception
            goto L_0x00e9
        L_0x00ef:
            r0 = move-exception
            goto L_0x00e9
        L_0x00f1:
            r15 = 43
            if (r14 == r15) goto L_0x0111
            r15 = 45
            if (r14 != r15) goto L_0x00fa
            goto L_0x0111
        L_0x00fa:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r2.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r2.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
        L_0x0111:
            java.lang.String r5 = r1.substring(r10)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            int r14 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            if (r14 < r2) goto L_0x011c
            goto L_0x0120
        L_0x011c:
            java.lang.String r5 = r5.concat(r4)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
        L_0x0120:
            int r4 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            int r10 = r10 + r4
            java.lang.String r4 = "+0000"
            boolean r4 = r4.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            if (r4 != 0) goto L_0x0177
            java.lang.String r4 = "+00:00"
            boolean r4 = r4.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            if (r4 == 0) goto L_0x0136
            goto L_0x0177
        L_0x0136:
            java.lang.String r3 = r3.concat(r5)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r5 = r4.getID()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            boolean r14 = r5.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            if (r14 != 0) goto L_0x0175
            java.lang.String r14 = ":"
            java.lang.String r15 = ""
            java.lang.String r5 = r5.replace(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            boolean r5 = r5.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            if (r5 == 0) goto L_0x0157
            goto L_0x0175
        L_0x0157:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r5.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r5.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r0 = " given, resolves to "
            r5.append(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r0 = r4.getID()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r5.append(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            java.lang.String r0 = r5.toString()     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r2.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            throw r2     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
        L_0x0175:
            r0 = r4
            goto L_0x0179
        L_0x0177:
            java.util.TimeZone r0 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
        L_0x0179:
            java.util.GregorianCalendar r3 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r3.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 0
            r3.setLenient(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 1
            r3.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            int r7 = r7 - r0
            r0 = 2
            r3.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r3.set(r2, r9)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 11
            r3.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 12
            r3.set(r0, r11)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 13
            r3.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r0 = 14
            r3.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x00ef, NumberFormatException -> 0x00ed, IllegalArgumentException -> 0x00e8 }
            r2 = r20
            r2.setIndex(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            java.util.Date r0 = r3.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            return r0
        L_0x01ac:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b8, NumberFormatException -> 0x01b6, IllegalArgumentException -> 0x01b4 }
        L_0x01b4:
            r0 = move-exception
            goto L_0x01b9
        L_0x01b6:
            r0 = move-exception
            goto L_0x01b9
        L_0x01b8:
            r0 = move-exception
        L_0x01b9:
            if (r1 != 0) goto L_0x01bd
            r1 = 0
            goto L_0x01d0
        L_0x01bd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\""
            r3.<init>(r4)
            r3.append(r1)
            r1 = 34
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x01d0:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01dc
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x01f7
        L_0x01dc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x01f7:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to parse date ["
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r20.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
