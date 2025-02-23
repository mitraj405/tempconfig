package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: ProfileVerifier */
public final class d {
    public static final Bt<c> a = new Bt<>();

    /* renamed from: a  reason: collision with other field name */
    public static c f2266a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f2267a = new Object();

    /* compiled from: ProfileVerifier */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    /* compiled from: ProfileVerifier */
    public static class b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final long f2268a;
        public final int b;

        /* renamed from: b  reason: collision with other field name */
        public final long f2269b;

        public b(int i, int i2, long j, long j2) {
            this.a = i;
            this.b = i2;
            this.f2268a = j;
            this.f2269b = j2;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.a);
                dataOutputStream.writeInt(this.b);
                dataOutputStream.writeLong(this.f2268a);
                dataOutputStream.writeLong(this.f2269b);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b == bVar.b && this.f2268a == bVar.f2268a && this.a == bVar.a && this.f2269b == bVar.f2269b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.b), Long.valueOf(this.f2268a), Integer.valueOf(this.a), Long.valueOf(this.f2269b)});
        }
    }

    /* compiled from: ProfileVerifier */
    public static class c {
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return a.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i, boolean z, boolean z2) {
        c cVar = new c();
        f2266a = cVar;
        a.set(cVar);
        return f2266a;
    }

    public static void c(Context context, boolean z) {
        boolean z2;
        boolean z3;
        b bVar;
        b bVar2;
        if (z || f2266a == null) {
            synchronized (f2267a) {
                if (!z) {
                    if (f2266a != null) {
                        return;
                    }
                }
                int i = Build.VERSION.SDK_INT;
                int i2 = 0;
                if (i >= 28) {
                    if (i != 30) {
                        File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                        long length = file.length();
                        if (!file.exists() || length <= 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                        long length2 = file2.length();
                        if (!file2.exists() || length2 <= 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        try {
                            long a2 = a(context);
                            File file3 = new File(context.getFilesDir(), "profileInstalled");
                            if (file3.exists()) {
                                try {
                                    bVar = b.a(file3);
                                } catch (IOException unused) {
                                    b(131072, z2, z3);
                                    return;
                                }
                            } else {
                                bVar = null;
                            }
                            if (bVar != null && bVar.f2268a == a2) {
                                int i3 = bVar.b;
                                if (i3 != 2) {
                                    i2 = i3;
                                    if (z && z3 && i2 != 1) {
                                        i2 = 2;
                                    }
                                    if (bVar != null && bVar.b == 2 && i2 == 1 && length < bVar.f2269b) {
                                        i2 = 3;
                                    }
                                    bVar2 = new b(1, i2, a2, length2);
                                    if (bVar == null || !bVar.equals(bVar2)) {
                                        bVar2.b(file3);
                                    }
                                    b(i2, z2, z3);
                                    return;
                                }
                            }
                            if (z2) {
                                i2 = 1;
                            } else if (z3) {
                                i2 = 2;
                            }
                            i2 = 2;
                            i2 = 3;
                            bVar2 = new b(1, i2, a2, length2);
                            try {
                                bVar2.b(file3);
                            } catch (IOException unused2) {
                                i2 = 196608;
                            }
                            b(i2, z2, z3);
                            return;
                        } catch (PackageManager.NameNotFoundException unused3) {
                            b(65536, z2, z3);
                            return;
                        }
                    }
                }
                b(262144, false, false);
            }
        }
    }
}
