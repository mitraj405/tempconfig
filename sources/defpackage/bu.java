package defpackage;

import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: bu  reason: default package */
/* compiled from: RoomSQLiteQuery */
public final class bu implements My, Closeable {
    public static final TreeMap<Integer, bu> a = new TreeMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final double[] f2743a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f2744a;

    /* renamed from: a  reason: collision with other field name */
    public final long[] f2745a;

    /* renamed from: a  reason: collision with other field name */
    public final String[] f2746a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f2747a;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public volatile String f2748c;
    public int d;

    public bu(int i) {
        this.c = i;
        int i2 = i + 1;
        this.f2744a = new int[i2];
        this.f2745a = new long[i2];
        this.f2743a = new double[i2];
        this.f2746a = new String[i2];
        this.f2747a = new byte[i2][];
    }

    public static bu c(int i, String str) {
        TreeMap<Integer, bu> treeMap = a;
        synchronized (treeMap) {
            Map.Entry<Integer, bu> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                bu value = ceilingEntry.getValue();
                value.f2748c = str;
                value.d = i;
                return value;
            }
            bu buVar = new bu(i);
            buVar.f2748c = str;
            buVar.d = i;
            return buVar;
        }
    }

    public final void a(C0084Bd bd) {
        for (int i = 1; i <= this.d; i++) {
            int i2 = this.f2744a[i];
            if (i2 == 1) {
                bd.e(i);
            } else if (i2 == 2) {
                bd.c(i, this.f2745a[i]);
            } else if (i2 == 3) {
                bd.b(this.f2743a[i], i);
            } else if (i2 == 4) {
                bd.h(i, this.f2746a[i]);
            } else if (i2 == 5) {
                bd.a(i, this.f2747a[i]);
            }
        }
    }

    public final String b() {
        return this.f2748c;
    }

    public final void e(int i, long j) {
        this.f2744a[i] = 2;
        this.f2745a[i] = j;
    }

    public final void h(int i) {
        this.f2744a[i] = 1;
    }

    public final void j(int i, String str) {
        this.f2744a[i] = 4;
        this.f2746a[i] = str;
    }

    public final void release() {
        TreeMap<Integer, bu> treeMap = a;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.c), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }

    public final void close() {
    }
}
