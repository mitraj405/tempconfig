package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.emoji2.text.d;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: FontRequestEmojiCompatConfig */
public final class g extends d.c {
    public static final a a = new a();

    /* compiled from: FontRequestEmojiCompatConfig */
    public static class a {
    }

    /* compiled from: FontRequestEmojiCompatConfig */
    public static class b implements d.g {
        public final C0109Yc a;

        /* renamed from: a  reason: collision with other field name */
        public final Context f2021a;

        /* renamed from: a  reason: collision with other field name */
        public Handler f2022a;

        /* renamed from: a  reason: collision with other field name */
        public d.h f2023a;

        /* renamed from: a  reason: collision with other field name */
        public final a f2024a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f2025a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public Executor f2026a;

        /* renamed from: a  reason: collision with other field name */
        public ThreadPoolExecutor f2027a;

        public b(Context context, C0109Yc yc) {
            a aVar = g.a;
            if (context != null) {
                this.f2021a = context.getApplicationContext();
                this.a = yc;
                this.f2024a = aVar;
                return;
            }
            throw new NullPointerException("Context cannot be null");
        }

        public final void a(d.h hVar) {
            synchronized (this.f2025a) {
                this.f2023a = hVar;
            }
            c();
        }

        public final void b() {
            synchronized (this.f2025a) {
                this.f2023a = null;
                Handler handler = this.f2022a;
                if (handler != null) {
                    handler.removeCallbacks((Runnable) null);
                }
                this.f2022a = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2027a;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2026a = null;
                this.f2027a = null;
            }
        }

        public final void c() {
            synchronized (this.f2025a) {
                if (this.f2023a != null) {
                    if (this.f2026a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new C0322s6("emojiCompat"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        this.f2027a = threadPoolExecutor;
                        this.f2026a = threadPoolExecutor;
                    }
                    this.f2026a.execute(new C0189f6(this, 2));
                }
            }
        }

        public final C0204gd d() {
            try {
                a aVar = this.f2024a;
                Context context = this.f2021a;
                C0109Yc yc = this.a;
                aVar.getClass();
                C0195fd a2 = C0107Xc.a(context, yc);
                int i = a2.a;
                if (i == 0) {
                    C0204gd[] gdVarArr = a2.f2939a;
                    if (gdVarArr != null && gdVarArr.length != 0) {
                        return gdVarArr[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException(C1058d.y("fetchFonts failed (", i, ")"));
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }
    }

    public g(Context context, C0109Yc yc) {
        super(new b(context, yc));
    }
}
