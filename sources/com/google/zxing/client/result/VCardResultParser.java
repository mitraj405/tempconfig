package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern COMMA = Pattern.compile(",");
    private static final Pattern CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    private static final Pattern EQUALS = Pattern.compile("=");
    private static final Pattern NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final Pattern SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    private static final Pattern UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
    private static final Pattern VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    private static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (!(i >= length - 2 || (charAt = charSequence.charAt(i + 1)) == 13 || charAt == 10)) {
                    i += 2;
                    char charAt3 = charSequence.charAt(i);
                    int parseHexDigit = ResultParser.parseHexDigit(charAt);
                    int parseHexDigit2 = ResultParser.parseHexDigit(charAt3);
                    if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                        byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                    }
                }
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void formatNames(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List next : iterable) {
                String str = (String) next.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (i < 4 && (indexOf = str.indexOf(59, i2)) >= 0) {
                    strArr[i] = str.substring(i2, indexOf);
                    i++;
                    i2 = indexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder sb = new StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb);
                maybeAppendComponent(strArr, 1, sb);
                maybeAppendComponent(strArr, 2, sb);
                maybeAppendComponent(strArr, 0, sb);
                maybeAppendComponent(strArr, 4, sb);
                next.set(0, sb.toString().trim());
            }
        }
    }

    private static boolean isLikeVCardDate(CharSequence charSequence) {
        if (charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches()) {
            return true;
        }
        return false;
    }

    public static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z, z2);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchVCardPrefixedField.get(0);
    }

    public static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        String str2;
        String str3;
        int i;
        ArrayList arrayList;
        int indexOf;
        int i2;
        String str4;
        String str5 = str;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        ArrayList arrayList2 = null;
        while (i4 < length) {
            int i5 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str5);
            if (i4 > 0) {
                i4--;
            }
            if (!matcher.find(i4)) {
                break;
            }
            int end = matcher.end(i3);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = SEMICOLON.split(group);
                int length2 = split.length;
                int i6 = i3;
                i = i6;
                arrayList = null;
                str3 = null;
                str2 = null;
                while (i6 < length2) {
                    String str6 = split[i6];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str6);
                    String[] split2 = EQUALS.split(str6, i5);
                    if (split2.length > 1) {
                        String str7 = split2[0];
                        String str8 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str7) && "QUOTED-PRINTABLE".equalsIgnoreCase(str8)) {
                            i = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str7)) {
                            str3 = str8;
                        } else if ("VALUE".equalsIgnoreCase(str7)) {
                            str2 = str8;
                        }
                    }
                    i6++;
                    i5 = 2;
                }
            } else {
                arrayList = null;
                i = 0;
                str3 = null;
                str2 = null;
            }
            int i7 = end;
            while (true) {
                indexOf = str5.indexOf(10, i7);
                if (indexOf < 0) {
                    break;
                }
                if (indexOf < str.length() - 1) {
                    int i8 = indexOf + 1;
                    if (str5.charAt(i8) == ' ' || str5.charAt(i8) == 9) {
                        i7 = indexOf + 2;
                    }
                }
                if (i == 0) {
                    break;
                }
                if (indexOf <= 0 || str5.charAt(indexOf - 1) != '=') {
                    if (indexOf >= 2) {
                        if (str5.charAt(indexOf - 2) != '=') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i7 = indexOf + 1;
            }
            if (indexOf < 0) {
                i4 = length;
                i3 = 0;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str5.charAt(indexOf - 1) == 13) {
                        indexOf--;
                    }
                    String substring = str5.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (i != 0) {
                        str4 = decodeQuotedPrintable(substring, str3);
                        if (z2) {
                            str4 = UNESCAPED_SEMICOLONS.matcher(str4).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            substring = UNESCAPED_SEMICOLONS.matcher(substring).replaceAll("\n").trim();
                        }
                        str4 = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if ("uri".equals(str2)) {
                        try {
                            str4 = URI.create(str4).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(str4);
                        arrayList2.add(arrayList3);
                    } else {
                        i2 = 0;
                        arrayList.add(0, str4);
                        arrayList2.add(arrayList);
                        i3 = i2;
                        i4 = indexOf + 1;
                    }
                }
                i2 = 0;
                i3 = i2;
                i4 = indexOf + 1;
            }
        }
        return arrayList2;
    }

    private static void maybeAppendComponent(String[] strArr, int i, StringBuilder sb) {
        String str = strArr[i];
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(strArr[i]);
        }
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String toPrimaryValue(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = (String) list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(ResultParser.EMPTY_STR_ARRAY);
    }

    private static String[] toTypes(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            String str2 = (String) next.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i = 1;
                while (true) {
                    if (i >= next.size()) {
                        str = null;
                        break;
                    }
                    str = (String) next.get(i);
                    int indexOf = str.indexOf(61);
                    if (indexOf < 0) {
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    } else {
                        i++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(ResultParser.EMPTY_STR_ARRAY);
    }

    public AddressBookParsedResult parse(Result result) {
        String[] strArr;
        String[] strArr2;
        String massagedText = ResultParser.getMassagedText(result);
        Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (matchVCardPrefixedField == null) {
            matchVCardPrefixedField = matchVCardPrefixedField("N", massagedText, true, false);
            formatNames(matchVCardPrefixedField);
        }
        List<String> matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        if (matchSingleVCardPrefixedField == null) {
            strArr = null;
        } else {
            strArr = COMMA.split(matchSingleVCardPrefixedField.get(0));
        }
        List<List<String>> matchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
        List<List<String>> matchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        List<List<String>> matchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
        List<String> matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        List<String> matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        List<String> list = (matchSingleVCardPrefixedField4 == null || isLikeVCardDate(matchSingleVCardPrefixedField4.get(0))) ? matchSingleVCardPrefixedField4 : null;
        List<String> matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
        List<List<String>> matchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        List<String> matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        if (matchSingleVCardPrefixedField7 == null) {
            strArr2 = null;
        } else {
            strArr2 = SEMICOLON_OR_COMMA.split(matchSingleVCardPrefixedField7.get(0));
        }
        return new AddressBookParsedResult(toPrimaryValues(matchVCardPrefixedField), strArr, (String) null, toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField6), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField4), toTypes(matchVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField3), toPrimaryValue(list), toPrimaryValue(matchSingleVCardPrefixedField5), toPrimaryValues(matchVCardPrefixedField5), (strArr2 == null || strArr2.length == 2) ? strArr2 : null);
    }
}
