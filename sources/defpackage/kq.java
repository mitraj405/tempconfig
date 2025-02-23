package defpackage;

import androidx.datastore.preferences.protobuf.F;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: kq  reason: default package */
/* compiled from: PreferencesProto */
public final class kq extends n<kq, a> implements jl {
    /* access modifiers changed from: private */
    public static final kq DEFAULT_INSTANCE;
    private static volatile Ho<kq> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private p.c<String> strings_ = F.a;

    /* renamed from: kq$a */
    /* compiled from: PreferencesProto */
    public static final class a extends n.a<kq, a> implements jl {
        public a() {
            super(kq.DEFAULT_INSTANCE);
        }
    }

    static {
        kq kqVar = new kq();
        DEFAULT_INSTANCE = kqVar;
        n.m(kq.class, kqVar);
    }

    public static void o(kq kqVar, Iterable iterable) {
        int i;
        if (!kqVar.strings_.isModifiable()) {
            p.c<String> cVar = kqVar.strings_;
            int size = cVar.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size * 2;
            }
            kqVar.strings_ = cVar.l(i);
        }
        p.c<String> cVar2 = kqVar.strings_;
        Charset charset = p.a;
        iterable.getClass();
        if (iterable instanceof Vh) {
            List<?> underlyingElements = ((Vh) iterable).getUnderlyingElements();
            Vh vh = (Vh) cVar2;
            int size2 = cVar2.size();
            for (Object next : underlyingElements) {
                if (next == null) {
                    String str = "Element at index " + (vh.size() - size2) + " is null.";
                    int size3 = vh.size();
                    while (true) {
                        size3--;
                        if (size3 >= size2) {
                            vh.remove(size3);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof x3) {
                    vh.j((x3) next);
                } else {
                    vh.add((String) next);
                }
            }
        } else if (iterable instanceof qq) {
            cVar2.addAll((Collection) iterable);
        } else {
            if ((cVar2 instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) cVar2).ensureCapacity(((Collection) iterable).size() + cVar2.size());
            }
            int size4 = cVar2.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    String str2 = "Element at index " + (cVar2.size() - size4) + " is null.";
                    int size5 = cVar2.size();
                    while (true) {
                        size5--;
                        if (size5 >= size4) {
                            cVar2.remove(size5);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    cVar2.add(next2);
                }
            }
        }
    }

    public static kq p() {
        return DEFAULT_INSTANCE;
    }

    public static a r() {
        return (a) ((n.a) DEFAULT_INSTANCE.i(n.f.NEW_BUILDER));
    }

    public final Object i(n.f fVar) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new vs(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new kq();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Ho<kq> ho = PARSER;
                if (ho == null) {
                    synchronized (kq.class) {
                        try {
                            ho = PARSER;
                            if (ho == null) {
                                ho = new n.b<>(DEFAULT_INSTANCE);
                                PARSER = ho;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return ho;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final p.c q() {
        return this.strings_;
    }
}
