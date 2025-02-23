package defpackage;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/* renamed from: Ba  reason: default package */
/* compiled from: EmvTags */
public final class Ba {
    public static final LinkedHashMap<u3, mf> a = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final tz f48a = new tz("4f", 1, "Application Identifier (AID) - card");
    public static final tz b = new tz("84", 1, "Dedicated File (DF) Name");
    public static final tz c = new tz("57", 1, "Track 2 Equivalent Data");
    public static final tz d = new tz("80", 1, "Response Message Template Format 1");
    public static final tz e = new tz("83", 1, "Command Template");
    public static final tz f = new tz("94", 1, "Application File Locator (AFL)");
    public static final tz g = new tz("9f38", 5, "Processing Options Data Object List (PDOL)");
    public static final tz h = new tz("9f66", 1, "Terminal Transaction Qualifiers");
    public static final tz i = new tz("9f6b", 1, "Track 2 Data");
    public static final tz j = new tz("9f2a", 1, "The value to be appended to the ADF Name in the data field of the SELECT command, if the Extended Selection Support flag is present and set to 1");

    static {
        for (Field field : Ba.class.getFields()) {
            if (field.getType() == mf.class) {
                try {
                    mf mfVar = (mf) field.get((Object) null);
                    byte[] b2 = mfVar.b();
                    b2.getClass();
                    u3 u3Var = new u3(b2);
                    LinkedHashMap<u3, mf> linkedHashMap = a;
                    if (!linkedHashMap.containsKey(u3Var)) {
                        linkedHashMap.put(u3Var, mfVar);
                    } else {
                        throw new IllegalArgumentException("Tag already added " + mfVar);
                    }
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }
}
