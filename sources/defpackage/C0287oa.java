package defpackage;

import androidx.emoji2.text.h;
import java.nio.ByteBuffer;

/* renamed from: oa  reason: default package and case insensitive filesystem */
/* compiled from: EmojiMetadata */
public final class C0287oa {
    public static final ThreadLocal<kl> a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public final int f3143a;

    /* renamed from: a  reason: collision with other field name */
    public final h f3144a;
    public volatile int b = 0;

    public C0287oa(h hVar, int i) {
        this.f3144a = hVar;
        this.f3143a = i;
    }

    public final int a(int i) {
        kl c = c();
        int a2 = c.a(16);
        if (a2 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = c.f3207a;
        int i2 = a2 + c.a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final int b() {
        kl c = c();
        int a2 = c.a(16);
        if (a2 == 0) {
            return 0;
        }
        int i = a2 + c.a;
        return c.f3207a.getInt(c.f3207a.getInt(i) + i);
    }

    public final kl c() {
        ThreadLocal<kl> threadLocal = a;
        kl klVar = threadLocal.get();
        if (klVar == null) {
            klVar = new kl();
            threadLocal.set(klVar);
        }
        ll llVar = this.f3144a.f2029a;
        int a2 = llVar.a(6);
        if (a2 != 0) {
            int i = a2 + llVar.a;
            int i2 = (this.f3143a * 4) + llVar.f3207a.getInt(i) + i + 4;
            klVar.b(llVar.f3207a.getInt(i2) + i2, llVar.f3207a);
        }
        return klVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        kl c = c();
        int a2 = c.a(4);
        if (a2 != 0) {
            i = c.f3207a.getInt(a2 + c.a);
        } else {
            i = 0;
        }
        sb.append(Integer.toHexString(i));
        sb.append(", codepoints:");
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(Integer.toHexString(a(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
