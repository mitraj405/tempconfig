package defpackage;

/* renamed from: K9  reason: default package */
/* compiled from: EAppConstant */
public enum K9 {
    NULL_IDCARD("Select ID Card Type", 99),
    UNIQUE_ICARD("Aadhaar ID/Virtual ID", 9);
    
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public String f3678c;

    /* access modifiers changed from: public */
    K9(String str, int i) {
        this.f3678c = str;
        this.c = i;
    }

    public static K9 a(String str) {
        for (K9 k9 : values()) {
            if (k9.name().equalsIgnoreCase(str)) {
                return k9;
            }
        }
        return null;
    }

    public static K9 i(String str) {
        for (K9 k9 : values()) {
            if (k9.f3678c == str) {
                return k9;
            }
        }
        return null;
    }

    public final String f() {
        return this.f3678c;
    }
}
