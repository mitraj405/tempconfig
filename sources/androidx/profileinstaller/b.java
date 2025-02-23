package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* compiled from: DeviceProfileWriter */
public final class b {
    public final c.C0023c a;

    /* renamed from: a  reason: collision with other field name */
    public final File f2260a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2261a;

    /* renamed from: a  reason: collision with other field name */
    public final Executor f2262a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2263a = false;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f2264a;

    /* renamed from: a  reason: collision with other field name */
    public S8[] f2265a;
    public byte[] b;

    public b(AssetManager assetManager, F1 f1, c.C0023c cVar, String str, File file) {
        byte[] bArr;
        this.f2262a = f1;
        this.a = cVar;
        this.f2261a = str;
        this.f2260a = file;
        int i = Build.VERSION.SDK_INT;
        if (i <= 33) {
            switch (i) {
                case 27:
                    bArr = Cq.c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = Cq.b;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = Cq.a;
                    break;
            }
        }
        bArr = null;
        this.f2264a = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.a.a();
            }
            return null;
        }
    }

    public final void b(int i, Serializable serializable) {
        this.f2262a.execute(new Q8(this, i, 0, serializable));
    }
}
