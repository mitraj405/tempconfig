package defpackage;

/* renamed from: GD  reason: default package */
/* compiled from: WireFormat */
public enum GD {
    ;
    

    /* renamed from: a  reason: collision with other field name */
    public final HD f232a;
    public final int c;

    /* 'enum' modifier removed */
    /* renamed from: GD$a */
    /* compiled from: WireFormat */
    public static class a extends GD {
        public a() {
            super("STRING", 8, HD.STRING, 2);
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: GD$b */
    /* compiled from: WireFormat */
    public static class b extends GD {
        public b(HD hd) {
            super("GROUP", 9, hd, 3);
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: GD$c */
    /* compiled from: WireFormat */
    public static class c extends GD {
        public c(HD hd) {
            super("MESSAGE", 10, hd, 2);
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: GD$d */
    /* compiled from: WireFormat */
    public static class d extends GD {
        public d(HD hd) {
            super("BYTES", 11, hd, 2);
        }
    }

    /* access modifiers changed from: public */
    GD(HD hd, int i) {
        this.f232a = hd;
        this.c = i;
    }
}
