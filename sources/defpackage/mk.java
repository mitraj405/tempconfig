package defpackage;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;

/* renamed from: mk  reason: default package */
/* compiled from: ManifestSchemaFactory */
public final class mk {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final il f3106a;

    /* renamed from: mk$a */
    /* compiled from: ManifestSchemaFactory */
    public static class a implements il {
        public final hl a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        public final boolean isSupported(Class<?> cls) {
            return false;
        }
    }

    /* renamed from: mk$b */
    /* compiled from: ManifestSchemaFactory */
    public static class b implements il {
        public final il[] a;

        public b(il... ilVarArr) {
            this.a = ilVarArr;
        }

        public final hl a(Class<?> cls) {
            for (il ilVar : this.a) {
                if (ilVar.isSupported(cls)) {
                    return ilVar.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }

        public final boolean isSupported(Class<?> cls) {
            for (il isSupported : this.a) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public mk() {
        il ilVar;
        il[] ilVarArr = new il[2];
        ilVarArr[0] = C0238je.a;
        try {
            ilVar = (il) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            ilVar = a;
        }
        ilVarArr[1] = ilVar;
        b bVar = new b(ilVarArr);
        Charset charset = p.a;
        this.f3106a = bVar;
    }
}
