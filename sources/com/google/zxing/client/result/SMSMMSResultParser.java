package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class SMSMMSResultParser extends ResultParser {
    private static void addNumberVia(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        String str2 = null;
        if (indexOf < 0) {
            collection.add(str);
            collection2.add((Object) null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            str2 = substring.substring(4);
        }
        collection2.add(str2);
    }

    public SMSParsedResult parse(Result result) {
        String str;
        boolean z;
        String str2;
        String massagedText = ResultParser.getMassagedText(result);
        String str3 = null;
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
        if (parseNameValuePairs == null || parseNameValuePairs.isEmpty()) {
            z = false;
            str = null;
        } else {
            str3 = parseNameValuePairs.get("subject");
            str = parseNameValuePairs.get("body");
            z = true;
        }
        int indexOf = massagedText.indexOf(63, 4);
        if (indexOf < 0 || !z) {
            str2 = massagedText.substring(4);
        } else {
            str2 = massagedText.substring(4, indexOf);
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        int i = -1;
        while (true) {
            int i2 = i + 1;
            int indexOf2 = str2.indexOf(44, i2);
            if (indexOf2 > i) {
                addNumberVia(arrayList, arrayList2, str2.substring(i2, indexOf2));
                i = indexOf2;
            } else {
                addNumberVia(arrayList, arrayList2, str2.substring(i2));
                String[] strArr = ResultParser.EMPTY_STR_ARRAY;
                return new SMSParsedResult((String[]) arrayList.toArray(strArr), (String[]) arrayList2.toArray(strArr), str3, str);
            }
        }
    }
}
