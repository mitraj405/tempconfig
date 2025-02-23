package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: am  reason: default package and case insensitive filesystem */
/* compiled from: MultiDex */
public final class C0123am {
    public static final HashSet a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f804a;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1 < 1) goto L_0x0042;
     */
    static {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            a = r0
            java.lang.String r0 = "java.vm.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x0042
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = "."
            r1.<init>(r0, r2)
            boolean r0 = r1.hasMoreTokens()
            r2 = 0
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r1.nextToken()
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            boolean r3 = r1.hasMoreTokens()
            if (r3 == 0) goto L_0x002d
            java.lang.String r2 = r1.nextToken()
        L_0x002d:
            if (r0 == 0) goto L_0x0042
            if (r2 == 0) goto L_0x0042
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0042 }
            int r1 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0042 }
            r2 = 1
            r3 = 2
            if (r0 > r3) goto L_0x0043
            if (r0 != r3) goto L_0x0042
            if (r1 < r2) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            f804a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0123am.<clinit>():void");
    }

    public static void a(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            file.getPath();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.getPath();
                return;
            }
            for (File file2 : listFiles) {
                file2.getPath();
                file2.length();
                if (!file2.delete()) {
                    file2.getPath();
                } else {
                    file2.getPath();
                }
            }
            if (!file.delete()) {
                file.getPath();
            } else {
                file.getPath();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0022 A[Catch:{ all -> 0x0054 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0024 A[SYNTHETIC, Splitter:B:20:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0065 A[SYNTHETIC, Splitter:B:43:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0067 A[Catch:{ all -> 0x0054 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r6, java.io.File r7, java.io.File r8) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.lang.String r0 = "secondary-dexes"
            java.util.HashSet r1 = a
            monitor-enter(r1)
            boolean r2 = r1.contains(r7)     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            return
        L_0x000d:
            r1.add(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "java.vm.version"
            java.lang.System.getProperty(r2)     // Catch:{ all -> 0x006c }
            r2 = 0
            java.lang.ClassLoader r3 = r6.getClassLoader()     // Catch:{ RuntimeException -> 0x001f }
            boolean r4 = r3 instanceof dalvik.system.BaseDexClassLoader     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r3 = r2
        L_0x0020:
            if (r3 != 0) goto L_0x0024
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            return
        L_0x0024:
            a(r6)     // Catch:{ all -> 0x0027 }
        L_0x0027:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "code_cache"
            r4.<init>(r8, r5)     // Catch:{ all -> 0x006c }
            f(r4)     // Catch:{ IOException -> 0x0032 }
            goto L_0x003e
        L_0x0032:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x006c }
            java.io.File r8 = r6.getFilesDir()     // Catch:{ all -> 0x006c }
            r4.<init>(r8, r5)     // Catch:{ all -> 0x006c }
            f(r4)     // Catch:{ all -> 0x006c }
        L_0x003e:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x006c }
            r8.<init>(r4, r0)     // Catch:{ all -> 0x006c }
            f(r8)     // Catch:{ all -> 0x006c }
            cm r0 = new cm     // Catch:{ all -> 0x006c }
            r0.<init>(r7, r8)     // Catch:{ all -> 0x006c }
            r7 = 0
            java.util.ArrayList r7 = r0.c(r6, r7)     // Catch:{ all -> 0x0054 }
            e(r8, r3, r7)     // Catch:{ IOException -> 0x0056 }
            goto L_0x005e
        L_0x0054:
            r6 = move-exception
            goto L_0x0068
        L_0x0056:
            r7 = 1
            java.util.ArrayList r6 = r0.c(r6, r7)     // Catch:{ all -> 0x0054 }
            e(r8, r3, r6)     // Catch:{ all -> 0x0054 }
        L_0x005e:
            r0.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0063
        L_0x0062:
            r2 = move-exception
        L_0x0063:
            if (r2 != 0) goto L_0x0067
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            return
        L_0x0067:
            throw r2     // Catch:{ all -> 0x006c }
        L_0x0068:
            r0.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            throw r6     // Catch:{ all -> 0x006c }
        L_0x006c:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0123am.b(android.content.Context, java.io.File, java.io.File):void");
    }

    public static Field c(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder K = xx.K("Field ", str, " not found in ");
        K.append(obj.getClass());
        throw new NoSuchFieldException(K.toString());
    }

    public static void d(Context context) {
        ApplicationInfo applicationInfo;
        if (!f804a) {
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    b(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir));
                } catch (Exception e) {
                    throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
                }
            }
        }
    }

    public static void e(File file, ClassLoader classLoader, ArrayList arrayList) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        IOException[] iOExceptionArr;
        if (!arrayList.isEmpty()) {
            Object obj = c(classLoader, "pathList").get(classLoader);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList(arrayList);
            Class<ArrayList> cls = ArrayList.class;
            Class[] clsArr = {cls, File.class, cls};
            Class cls2 = obj.getClass();
            while (cls2 != null) {
                try {
                    Method declaredMethod = cls2.getDeclaredMethod("makeDexElements", clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    Object[] objArr = (Object[]) declaredMethod.invoke(obj, new Object[]{arrayList3, file, arrayList2});
                    Field c = c(obj, "dexElements");
                    Object[] objArr2 = (Object[]) c.get(obj);
                    Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
                    System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                    System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
                    c.set(obj, objArr3);
                    if (arrayList2.size() > 0) {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            IOException iOException = (IOException) it.next();
                        }
                        Field c2 = c(obj, "dexElementsSuppressedExceptions");
                        IOException[] iOExceptionArr2 = (IOException[]) c2.get(obj);
                        if (iOExceptionArr2 == null) {
                            iOExceptionArr = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
                        } else {
                            IOException[] iOExceptionArr3 = new IOException[(arrayList2.size() + iOExceptionArr2.length)];
                            arrayList2.toArray(iOExceptionArr3);
                            System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList2.size(), iOExceptionArr2.length);
                            iOExceptionArr = iOExceptionArr3;
                        }
                        c2.set(obj, iOExceptionArr);
                        IOException iOException2 = new IOException("I/O exception during makeDexElement");
                        iOException2.initCause((Throwable) arrayList2.get(0));
                        throw iOException2;
                    }
                    return;
                } catch (NoSuchMethodException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            throw new NoSuchMethodException("Method makeDexElements with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        }
    }

    public static void f(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                file.getPath();
            } else {
                file.getPath();
                parentFile.isDirectory();
                parentFile.isFile();
                parentFile.exists();
                parentFile.canRead();
                parentFile.canWrite();
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
