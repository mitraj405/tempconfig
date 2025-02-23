package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: l7  reason: default package and case insensitive filesystem */
/* compiled from: CopyLock */
public final class C0253l7 {
    public static final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final File f3075a;

    /* renamed from: a  reason: collision with other field name */
    public FileChannel f3076a;

    /* renamed from: a  reason: collision with other field name */
    public final Lock f3077a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3078a;

    public C0253l7(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, C1058d.z(str, ".lck"));
        this.f3075a = file2;
        String absolutePath = file2.getAbsolutePath();
        HashMap hashMap = a;
        synchronized (hashMap) {
            lock = (Lock) hashMap.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                hashMap.put(absolutePath, lock);
            }
        }
        this.f3077a = lock;
        this.f3078a = z;
    }

    public final void a() {
        FileChannel fileChannel = this.f3076a;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f3077a.unlock();
    }
}
