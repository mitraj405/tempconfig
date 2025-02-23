package defpackage;

/* renamed from: Iz  reason: default package */
/* compiled from: TextDirectionHeuristicsCompat */
public final class Iz {
    public static final d a = new d((a) null, false);
    public static final d b = new d((a) null, true);
    public static final d c;
    public static final d d;

    /* renamed from: Iz$a */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static class a implements b {
        public static final a a = new a();

        public final int a(CharSequence charSequence, int i) {
            int i2 = i + 0;
            int i3 = 2;
            for (int i4 = 0; i4 < i2 && i3 == 2; i4++) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i4));
                d dVar = Iz.a;
                if (directionality != 0) {
                    if (!(directionality == 1 || directionality == 2)) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i3 = 2;
                                break;
                        }
                    }
                    i3 = 0;
                }
                i3 = 1;
            }
            return i3;
        }
    }

    /* renamed from: Iz$b */
    /* compiled from: TextDirectionHeuristicsCompat */
    public interface b {
        int a(CharSequence charSequence, int i);
    }

    /* renamed from: Iz$c */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static abstract class c implements Hz {
        public final b a;

        public c(a aVar) {
            this.a = aVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            }
            b bVar = this.a;
            if (bVar == null) {
                return a();
            }
            int a2 = bVar.a(charSequence, i);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: Iz$d */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static class d extends c {
        public final boolean a;

        public d(a aVar, boolean z) {
            super(aVar);
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    static {
        a aVar = a.a;
        c = new d(aVar, false);
        d = new d(aVar, true);
    }
}
