package defpackage;

import android.text.TextUtils;
import java.util.Objects;

/* renamed from: Tk  reason: default package */
/* compiled from: MediaSessionManagerImplBase */
public class Tk {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f557a;
    public final int b;

    public Tk(String str, int i, int i2) {
        this.f557a = str;
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tk)) {
            return false;
        }
        Tk tk = (Tk) obj;
        int i = this.b;
        String str = this.f557a;
        int i2 = this.a;
        if (i2 < 0 || tk.a < 0) {
            if (!TextUtils.equals(str, tk.f557a) || i != tk.b) {
                return false;
            }
            return true;
        } else if (TextUtils.equals(str, tk.f557a) && i2 == tk.a && i == tk.b) {
            return true;
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f557a, Integer.valueOf(this.b)});
    }
}
