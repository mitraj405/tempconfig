package androidx.emoji2.text;

import androidx.emoji2.text.d;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: EmojiCompatInitializer */
public final class e extends d.h {
    public final /* synthetic */ d.h a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ThreadPoolExecutor f2015a;

    public e(d.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = hVar;
        this.f2015a = threadPoolExecutor;
    }

    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f2015a;
        try {
            this.a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    public final void b(h hVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f2015a;
        try {
            this.a.b(hVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
