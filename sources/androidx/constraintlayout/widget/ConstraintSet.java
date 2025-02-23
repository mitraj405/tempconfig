package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class ConstraintSet {
    public static final SparseIntArray a;

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f1657a = {0, 4, 8};
    public static final SparseIntArray b;

    /* renamed from: a  reason: collision with other field name */
    public int f1658a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f1659a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, O6> f1660a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1661a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f1662b = "";

    /* renamed from: b  reason: collision with other field name */
    public final HashMap<Integer, a> f1663b = new HashMap<>();

    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public C0007a f1664a;

        /* renamed from: a  reason: collision with other field name */
        public final b f1665a = new b();

        /* renamed from: a  reason: collision with other field name */
        public final c f1666a = new c();

        /* renamed from: a  reason: collision with other field name */
        public final d f1667a = new d();

        /* renamed from: a  reason: collision with other field name */
        public final e f1668a = new e();

        /* renamed from: a  reason: collision with other field name */
        public String f1669a;

        /* renamed from: a  reason: collision with other field name */
        public HashMap<String, O6> f1670a = new HashMap<>();

        /* renamed from: androidx.constraintlayout.widget.ConstraintSet$a$a  reason: collision with other inner class name */
        public static class C0007a {
            public int a = 0;

            /* renamed from: a  reason: collision with other field name */
            public float[] f1671a = new float[10];

            /* renamed from: a  reason: collision with other field name */
            public int[] f1672a = new int[10];

            /* renamed from: a  reason: collision with other field name */
            public String[] f1673a = new String[5];

            /* renamed from: a  reason: collision with other field name */
            public boolean[] f1674a = new boolean[4];
            public int b = 0;

            /* renamed from: b  reason: collision with other field name */
            public int[] f1675b = new int[10];
            public int c = 0;

            /* renamed from: c  reason: collision with other field name */
            public int[] f1676c = new int[10];
            public int d = 0;

            /* renamed from: d  reason: collision with other field name */
            public int[] f1677d = new int[5];
            public int[] e = new int[4];

            public final void a(float f, int i) {
                int i2 = this.b;
                int[] iArr = this.f1676c;
                if (i2 >= iArr.length) {
                    this.f1676c = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1671a;
                    this.f1671a = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1676c;
                int i3 = this.b;
                iArr2[i3] = i;
                float[] fArr2 = this.f1671a;
                this.b = i3 + 1;
                fArr2[i3] = f;
            }

            public final void b(int i, int i2) {
                int i3 = this.a;
                int[] iArr = this.f1672a;
                if (i3 >= iArr.length) {
                    this.f1672a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1675b;
                    this.f1675b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1672a;
                int i4 = this.a;
                iArr3[i4] = i;
                int[] iArr4 = this.f1675b;
                this.a = i4 + 1;
                iArr4[i4] = i2;
            }

            public final void c(int i, String str) {
                int i2 = this.c;
                int[] iArr = this.f1677d;
                if (i2 >= iArr.length) {
                    this.f1677d = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1673a;
                    this.f1673a = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1677d;
                int i3 = this.c;
                iArr2[i3] = i;
                String[] strArr2 = this.f1673a;
                this.c = i3 + 1;
                strArr2[i3] = str;
            }

            public final void d(int i, boolean z) {
                int i2 = this.d;
                int[] iArr = this.e;
                if (i2 >= iArr.length) {
                    this.e = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1674a;
                    this.f1674a = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.e;
                int i3 = this.d;
                iArr2[i3] = i;
                boolean[] zArr2 = this.f1674a;
                this.d = i3 + 1;
                zArr2[i3] = z;
            }

            public final void e(a aVar) {
                for (int i = 0; i < this.a; i++) {
                    int i2 = this.f1672a[i];
                    int i3 = this.f1675b[i];
                    int[] iArr = ConstraintSet.f1657a;
                    if (i2 == 6) {
                        aVar.f1665a.v = i3;
                    } else if (i2 == 7) {
                        aVar.f1665a.w = i3;
                    } else if (i2 == 8) {
                        aVar.f1665a.C = i3;
                    } else if (i2 == 27) {
                        aVar.f1665a.x = i3;
                    } else if (i2 == 28) {
                        aVar.f1665a.z = i3;
                    } else if (i2 == 41) {
                        aVar.f1665a.M = i3;
                    } else if (i2 == 42) {
                        aVar.f1665a.N = i3;
                    } else if (i2 == 61) {
                        aVar.f1665a.t = i3;
                    } else if (i2 == 62) {
                        aVar.f1665a.u = i3;
                    } else if (i2 == 72) {
                        aVar.f1665a.U = i3;
                    } else if (i2 == 73) {
                        aVar.f1665a.V = i3;
                    } else if (i2 == 88) {
                        aVar.f1666a.f = i3;
                    } else if (i2 == 89) {
                        aVar.f1666a.g = i3;
                    } else if (i2 == 2) {
                        aVar.f1665a.B = i3;
                    } else if (i2 == 31) {
                        aVar.f1665a.D = i3;
                    } else if (i2 == 34) {
                        aVar.f1665a.A = i3;
                    } else if (i2 == 38) {
                        aVar.a = i3;
                    } else if (i2 == 64) {
                        aVar.f1666a.f1698a = i3;
                    } else if (i2 == 66) {
                        aVar.f1666a.d = i3;
                    } else if (i2 == 76) {
                        aVar.f1666a.f1703c = i3;
                    } else if (i2 == 78) {
                        aVar.f1667a.f1706b = i3;
                    } else if (i2 == 97) {
                        aVar.f1665a.X = i3;
                    } else if (i2 == 93) {
                        aVar.f1665a.E = i3;
                    } else if (i2 != 94) {
                        switch (i2) {
                            case 11:
                                aVar.f1665a.I = i3;
                                break;
                            case 12:
                                aVar.f1665a.J = i3;
                                break;
                            case 13:
                                aVar.f1665a.F = i3;
                                break;
                            case 14:
                                aVar.f1665a.H = i3;
                                break;
                            case 15:
                                aVar.f1665a.K = i3;
                                break;
                            case 16:
                                aVar.f1665a.G = i3;
                                break;
                            case 17:
                                aVar.f1665a.f1686c = i3;
                                break;
                            case 18:
                                aVar.f1665a.f1689d = i3;
                                break;
                            default:
                                switch (i2) {
                                    case 21:
                                        aVar.f1665a.f1683b = i3;
                                        break;
                                    case 22:
                                        aVar.f1667a.f1704a = i3;
                                        break;
                                    case 23:
                                        aVar.f1665a.f1679a = i3;
                                        break;
                                    case 24:
                                        aVar.f1665a.y = i3;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 54:
                                                aVar.f1665a.O = i3;
                                                break;
                                            case 55:
                                                aVar.f1665a.P = i3;
                                                break;
                                            case 56:
                                                aVar.f1665a.Q = i3;
                                                break;
                                            case 57:
                                                aVar.f1665a.R = i3;
                                                break;
                                            case 58:
                                                aVar.f1665a.S = i3;
                                                break;
                                            case 59:
                                                aVar.f1665a.T = i3;
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 82:
                                                        aVar.f1666a.f1701b = i3;
                                                        break;
                                                    case 83:
                                                        aVar.f1668a.f1708a = i3;
                                                        break;
                                                    case 84:
                                                        aVar.f1666a.e = i3;
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        aVar.f1665a.L = i3;
                    }
                }
                for (int i4 = 0; i4 < this.b; i4++) {
                    int i5 = this.f1676c[i4];
                    float f = this.f1671a[i4];
                    int[] iArr2 = ConstraintSet.f1657a;
                    if (i5 == 19) {
                        aVar.f1665a.f1678a = f;
                    } else if (i5 == 20) {
                        aVar.f1665a.b = f;
                    } else if (i5 == 37) {
                        aVar.f1665a.c = f;
                    } else if (i5 == 60) {
                        aVar.f1668a.f1707a = f;
                    } else if (i5 == 63) {
                        aVar.f1665a.d = f;
                    } else if (i5 == 79) {
                        aVar.f1666a.f1697a = f;
                    } else if (i5 == 85) {
                        aVar.f1666a.c = f;
                    } else if (i5 == 39) {
                        aVar.f1665a.f = f;
                    } else if (i5 != 40) {
                        switch (i5) {
                            case 43:
                                aVar.f1667a.a = f;
                                break;
                            case 44:
                                e eVar = aVar.f1668a;
                                eVar.k = f;
                                eVar.f1710b = true;
                                break;
                            case 45:
                                aVar.f1668a.b = f;
                                break;
                            case 46:
                                aVar.f1668a.c = f;
                                break;
                            case 47:
                                aVar.f1668a.d = f;
                                break;
                            case 48:
                                aVar.f1668a.e = f;
                                break;
                            case 49:
                                aVar.f1668a.f = f;
                                break;
                            case 50:
                                aVar.f1668a.g = f;
                                break;
                            case 51:
                                aVar.f1668a.h = f;
                                break;
                            case 52:
                                aVar.f1668a.i = f;
                                break;
                            case 53:
                                aVar.f1668a.j = f;
                                break;
                            default:
                                switch (i5) {
                                    case 67:
                                        aVar.f1666a.b = f;
                                        break;
                                    case 68:
                                        aVar.f1667a.b = f;
                                        break;
                                    case 69:
                                        aVar.f1665a.g = f;
                                        break;
                                    case 70:
                                        aVar.f1665a.h = f;
                                        break;
                                }
                        }
                    } else {
                        aVar.f1665a.e = f;
                    }
                }
                for (int i6 = 0; i6 < this.c; i6++) {
                    int i7 = this.f1677d[i6];
                    String str = this.f1673a[i6];
                    int[] iArr3 = ConstraintSet.f1657a;
                    if (i7 == 5) {
                        aVar.f1665a.f1680a = str;
                    } else if (i7 == 65) {
                        aVar.f1666a.f1699a = str;
                    } else if (i7 == 74) {
                        b bVar = aVar.f1665a;
                        bVar.f1684b = str;
                        bVar.f1682a = null;
                    } else if (i7 == 77) {
                        aVar.f1665a.f1687c = str;
                    } else if (i7 == 90) {
                        aVar.f1666a.f1702b = str;
                    }
                }
                for (int i8 = 0; i8 < this.d; i8++) {
                    int i9 = this.e[i8];
                    boolean z = this.f1674a[i8];
                    int[] iArr4 = ConstraintSet.f1657a;
                    if (i9 == 44) {
                        aVar.f1668a.f1710b = z;
                    } else if (i9 == 75) {
                        aVar.f1665a.f1694f = z;
                    } else if (i9 == 80) {
                        aVar.f1665a.f1690d = z;
                    } else if (i9 == 81) {
                        aVar.f1665a.f1692e = z;
                    }
                }
            }
        }

        public final void a(ConstraintLayout.LayoutParams layoutParams) {
            b bVar = this.f1665a;
            layoutParams.f1633c = bVar.f1691e;
            layoutParams.f1635d = bVar.f1693f;
            layoutParams.f1637e = bVar.f1695g;
            layoutParams.f1639f = bVar.f1696h;
            layoutParams.f1641g = bVar.i;
            layoutParams.f1643h = bVar.j;
            layoutParams.f1645i = bVar.k;
            layoutParams.f1647j = bVar.l;
            layoutParams.k = bVar.m;
            layoutParams.l = bVar.n;
            layoutParams.m = bVar.o;
            layoutParams.p = bVar.p;
            layoutParams.q = bVar.q;
            layoutParams.r = bVar.r;
            layoutParams.s = bVar.s;
            layoutParams.leftMargin = bVar.y;
            layoutParams.rightMargin = bVar.z;
            layoutParams.topMargin = bVar.A;
            layoutParams.bottomMargin = bVar.B;
            layoutParams.x = bVar.K;
            layoutParams.y = bVar.J;
            layoutParams.u = bVar.G;
            layoutParams.w = bVar.I;
            layoutParams.c = bVar.b;
            layoutParams.d = bVar.c;
            layoutParams.n = bVar.t;
            layoutParams.o = bVar.u;
            layoutParams.b = bVar.d;
            layoutParams.f1628a = bVar.f1680a;
            layoutParams.J = bVar.v;
            layoutParams.K = bVar.w;
            layoutParams.f = bVar.e;
            layoutParams.e = bVar.f;
            layoutParams.C = bVar.N;
            layoutParams.B = bVar.M;
            layoutParams.f1632b = bVar.f1690d;
            layoutParams.f1634c = bVar.f1692e;
            layoutParams.D = bVar.O;
            layoutParams.E = bVar.P;
            layoutParams.H = bVar.Q;
            layoutParams.I = bVar.R;
            layoutParams.F = bVar.S;
            layoutParams.G = bVar.T;
            layoutParams.g = bVar.g;
            layoutParams.h = bVar.h;
            layoutParams.L = bVar.x;
            layoutParams.a = bVar.f1678a;
            layoutParams.f1626a = bVar.f1686c;
            layoutParams.f1630b = bVar.f1689d;
            layoutParams.width = bVar.f1679a;
            layoutParams.height = bVar.f1683b;
            String str = bVar.f1687c;
            if (str != null) {
                layoutParams.f1631b = str;
            }
            layoutParams.M = bVar.X;
            layoutParams.setMarginStart(bVar.D);
            layoutParams.setMarginEnd(bVar.C);
            layoutParams.a();
        }

        /* renamed from: b */
        public final a clone() {
            a aVar = new a();
            aVar.f1665a.a(this.f1665a);
            aVar.f1666a.a(this.f1666a);
            d dVar = aVar.f1667a;
            dVar.getClass();
            d dVar2 = this.f1667a;
            dVar.f1705a = dVar2.f1705a;
            dVar.f1704a = dVar2.f1704a;
            dVar.a = dVar2.a;
            dVar.b = dVar2.b;
            dVar.f1706b = dVar2.f1706b;
            aVar.f1668a.a(this.f1668a);
            aVar.a = this.a;
            aVar.f1664a = this.f1664a;
            return aVar;
        }

        public final void c(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.a = i;
            int i2 = layoutParams.f1633c;
            b bVar = this.f1665a;
            bVar.f1691e = i2;
            bVar.f1693f = layoutParams.f1635d;
            bVar.f1695g = layoutParams.f1637e;
            bVar.f1696h = layoutParams.f1639f;
            bVar.i = layoutParams.f1641g;
            bVar.j = layoutParams.f1643h;
            bVar.k = layoutParams.f1645i;
            bVar.l = layoutParams.f1647j;
            bVar.m = layoutParams.k;
            bVar.n = layoutParams.l;
            bVar.o = layoutParams.m;
            bVar.p = layoutParams.p;
            bVar.q = layoutParams.q;
            bVar.r = layoutParams.r;
            bVar.s = layoutParams.s;
            bVar.b = layoutParams.c;
            bVar.c = layoutParams.d;
            bVar.f1680a = layoutParams.f1628a;
            bVar.t = layoutParams.n;
            bVar.u = layoutParams.o;
            bVar.d = layoutParams.b;
            bVar.v = layoutParams.J;
            bVar.w = layoutParams.K;
            bVar.x = layoutParams.L;
            bVar.f1678a = layoutParams.a;
            bVar.f1686c = layoutParams.f1626a;
            bVar.f1689d = layoutParams.f1630b;
            bVar.f1679a = layoutParams.width;
            bVar.f1683b = layoutParams.height;
            bVar.y = layoutParams.leftMargin;
            bVar.z = layoutParams.rightMargin;
            bVar.A = layoutParams.topMargin;
            bVar.B = layoutParams.bottomMargin;
            bVar.E = layoutParams.A;
            bVar.e = layoutParams.f;
            bVar.f = layoutParams.e;
            bVar.N = layoutParams.C;
            bVar.M = layoutParams.B;
            bVar.f1690d = layoutParams.f1632b;
            bVar.f1692e = layoutParams.f1634c;
            bVar.O = layoutParams.D;
            bVar.P = layoutParams.E;
            bVar.Q = layoutParams.H;
            bVar.R = layoutParams.I;
            bVar.S = layoutParams.F;
            bVar.T = layoutParams.G;
            bVar.g = layoutParams.g;
            bVar.h = layoutParams.h;
            bVar.f1687c = layoutParams.f1631b;
            bVar.G = layoutParams.u;
            bVar.I = layoutParams.w;
            bVar.F = layoutParams.t;
            bVar.H = layoutParams.v;
            bVar.K = layoutParams.x;
            bVar.J = layoutParams.y;
            bVar.L = layoutParams.z;
            bVar.X = layoutParams.M;
            bVar.C = layoutParams.getMarginEnd();
            bVar.D = layoutParams.getMarginStart();
        }

        public final void d(int i, Constraints.LayoutParams layoutParams) {
            c(i, layoutParams);
            this.f1667a.a = layoutParams.k;
            float f = layoutParams.m;
            e eVar = this.f1668a;
            eVar.f1707a = f;
            eVar.b = layoutParams.n;
            eVar.c = layoutParams.o;
            eVar.d = layoutParams.p;
            eVar.e = layoutParams.q;
            eVar.f = layoutParams.r;
            eVar.g = layoutParams.s;
            eVar.h = layoutParams.t;
            eVar.i = layoutParams.u;
            eVar.j = layoutParams.v;
            eVar.k = layoutParams.l;
            eVar.f1710b = layoutParams.j;
        }
    }

    public static class b {
        public static final SparseIntArray a;
        public int A = 0;
        public int B = 0;
        public int C = 0;
        public int D = 0;
        public int E = 0;
        public int F = Integer.MIN_VALUE;
        public int G = Integer.MIN_VALUE;
        public int H = Integer.MIN_VALUE;
        public int I = Integer.MIN_VALUE;
        public int J = Integer.MIN_VALUE;
        public int K = Integer.MIN_VALUE;
        public int L = Integer.MIN_VALUE;
        public int M = 0;
        public int N = 0;
        public int O = 0;
        public int P = 0;
        public int Q = 0;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = -1;
        public int V = 0;
        public int W = -1;
        public int X = 0;

        /* renamed from: a  reason: collision with other field name */
        public float f1678a = -1.0f;

        /* renamed from: a  reason: collision with other field name */
        public int f1679a;

        /* renamed from: a  reason: collision with other field name */
        public String f1680a = null;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1681a = false;

        /* renamed from: a  reason: collision with other field name */
        public int[] f1682a;
        public float b = 0.5f;

        /* renamed from: b  reason: collision with other field name */
        public int f1683b;

        /* renamed from: b  reason: collision with other field name */
        public String f1684b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1685b = false;
        public float c = 0.5f;

        /* renamed from: c  reason: collision with other field name */
        public int f1686c = -1;

        /* renamed from: c  reason: collision with other field name */
        public String f1687c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f1688c = true;
        public float d = 0.0f;

        /* renamed from: d  reason: collision with other field name */
        public int f1689d = -1;

        /* renamed from: d  reason: collision with other field name */
        public boolean f1690d = false;
        public float e = -1.0f;

        /* renamed from: e  reason: collision with other field name */
        public int f1691e = -1;

        /* renamed from: e  reason: collision with other field name */
        public boolean f1692e = false;
        public float f = -1.0f;

        /* renamed from: f  reason: collision with other field name */
        public int f1693f = -1;

        /* renamed from: f  reason: collision with other field name */
        public boolean f1694f = true;
        public float g = 1.0f;

        /* renamed from: g  reason: collision with other field name */
        public int f1695g = -1;
        public float h = 1.0f;

        /* renamed from: h  reason: collision with other field name */
        public int f1696h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = 0;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = 0;
        public int z = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.Layout_layout_constraintLeft_toLeftOf, 24);
            sparseIntArray.append(C0221hs.Layout_layout_constraintLeft_toRightOf, 25);
            sparseIntArray.append(C0221hs.Layout_layout_constraintRight_toLeftOf, 28);
            sparseIntArray.append(C0221hs.Layout_layout_constraintRight_toRightOf, 29);
            sparseIntArray.append(C0221hs.Layout_layout_constraintTop_toTopOf, 35);
            sparseIntArray.append(C0221hs.Layout_layout_constraintTop_toBottomOf, 34);
            sparseIntArray.append(C0221hs.Layout_layout_constraintBottom_toTopOf, 4);
            sparseIntArray.append(C0221hs.Layout_layout_constraintBottom_toBottomOf, 3);
            sparseIntArray.append(C0221hs.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sparseIntArray.append(C0221hs.Layout_layout_editor_absoluteX, 6);
            sparseIntArray.append(C0221hs.Layout_layout_editor_absoluteY, 7);
            sparseIntArray.append(C0221hs.Layout_layout_constraintGuide_begin, 17);
            sparseIntArray.append(C0221hs.Layout_layout_constraintGuide_end, 18);
            sparseIntArray.append(C0221hs.Layout_layout_constraintGuide_percent, 19);
            sparseIntArray.append(C0221hs.Layout_guidelineUseRtl, 90);
            sparseIntArray.append(C0221hs.Layout_android_orientation, 26);
            sparseIntArray.append(C0221hs.Layout_layout_constraintStart_toEndOf, 31);
            sparseIntArray.append(C0221hs.Layout_layout_constraintStart_toStartOf, 32);
            sparseIntArray.append(C0221hs.Layout_layout_constraintEnd_toStartOf, 10);
            sparseIntArray.append(C0221hs.Layout_layout_constraintEnd_toEndOf, 9);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginLeft, 13);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginTop, 16);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginRight, 14);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginBottom, 11);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginStart, 15);
            sparseIntArray.append(C0221hs.Layout_layout_goneMarginEnd, 12);
            sparseIntArray.append(C0221hs.Layout_layout_constraintVertical_weight, 38);
            sparseIntArray.append(C0221hs.Layout_layout_constraintHorizontal_weight, 37);
            sparseIntArray.append(C0221hs.Layout_layout_constraintHorizontal_chainStyle, 39);
            sparseIntArray.append(C0221hs.Layout_layout_constraintVertical_chainStyle, 40);
            sparseIntArray.append(C0221hs.Layout_layout_constraintHorizontal_bias, 20);
            sparseIntArray.append(C0221hs.Layout_layout_constraintVertical_bias, 36);
            sparseIntArray.append(C0221hs.Layout_layout_constraintDimensionRatio, 5);
            sparseIntArray.append(C0221hs.Layout_layout_constraintLeft_creator, 91);
            sparseIntArray.append(C0221hs.Layout_layout_constraintTop_creator, 91);
            sparseIntArray.append(C0221hs.Layout_layout_constraintRight_creator, 91);
            sparseIntArray.append(C0221hs.Layout_layout_constraintBottom_creator, 91);
            sparseIntArray.append(C0221hs.Layout_layout_constraintBaseline_creator, 91);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginLeft, 23);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginRight, 27);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginStart, 30);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginEnd, 8);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginTop, 33);
            sparseIntArray.append(C0221hs.Layout_android_layout_marginBottom, 2);
            sparseIntArray.append(C0221hs.Layout_android_layout_width, 22);
            sparseIntArray.append(C0221hs.Layout_android_layout_height, 21);
            sparseIntArray.append(C0221hs.Layout_layout_constraintWidth, 41);
            sparseIntArray.append(C0221hs.Layout_layout_constraintHeight, 42);
            sparseIntArray.append(C0221hs.Layout_layout_constrainedWidth, 41);
            sparseIntArray.append(C0221hs.Layout_layout_constrainedHeight, 42);
            sparseIntArray.append(C0221hs.Layout_layout_wrapBehaviorInParent, 76);
            sparseIntArray.append(C0221hs.Layout_layout_constraintCircle, 61);
            sparseIntArray.append(C0221hs.Layout_layout_constraintCircleRadius, 62);
            sparseIntArray.append(C0221hs.Layout_layout_constraintCircleAngle, 63);
            sparseIntArray.append(C0221hs.Layout_layout_constraintWidth_percent, 69);
            sparseIntArray.append(C0221hs.Layout_layout_constraintHeight_percent, 70);
            sparseIntArray.append(C0221hs.Layout_chainUseRtl, 71);
            sparseIntArray.append(C0221hs.Layout_barrierDirection, 72);
            sparseIntArray.append(C0221hs.Layout_barrierMargin, 73);
            sparseIntArray.append(C0221hs.Layout_constraint_referenced_ids, 74);
            sparseIntArray.append(C0221hs.Layout_barrierAllowsGoneWidgets, 75);
        }

        public final void a(b bVar) {
            this.f1681a = bVar.f1681a;
            this.f1679a = bVar.f1679a;
            this.f1685b = bVar.f1685b;
            this.f1683b = bVar.f1683b;
            this.f1686c = bVar.f1686c;
            this.f1689d = bVar.f1689d;
            this.f1678a = bVar.f1678a;
            this.f1688c = bVar.f1688c;
            this.f1691e = bVar.f1691e;
            this.f1693f = bVar.f1693f;
            this.f1695g = bVar.f1695g;
            this.f1696h = bVar.f1696h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.b = bVar.b;
            this.c = bVar.c;
            this.f1680a = bVar.f1680a;
            this.t = bVar.t;
            this.u = bVar.u;
            this.d = bVar.d;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.e = bVar.e;
            this.f = bVar.f;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.g = bVar.g;
            this.h = bVar.h;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.f1687c = bVar.f1687c;
            int[] iArr = bVar.f1682a;
            if (iArr == null || bVar.f1684b != null) {
                this.f1682a = null;
            } else {
                this.f1682a = Arrays.copyOf(iArr, iArr.length);
            }
            this.f1684b = bVar.f1684b;
            this.f1690d = bVar.f1690d;
            this.f1692e = bVar.f1692e;
            this.f1694f = bVar.f1694f;
            this.X = bVar.X;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.Layout);
            this.f1685b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                SparseIntArray sparseIntArray = a;
                int i3 = sparseIntArray.get(index);
                switch (i3) {
                    case 1:
                        this.m = ConstraintSet.l(obtainStyledAttributes, index, this.m);
                        break;
                    case 2:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 3:
                        this.l = ConstraintSet.l(obtainStyledAttributes, index, this.l);
                        break;
                    case 4:
                        this.k = ConstraintSet.l(obtainStyledAttributes, index, this.k);
                        break;
                    case 5:
                        this.f1680a = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.v = obtainStyledAttributes.getDimensionPixelOffset(index, this.v);
                        break;
                    case 7:
                        this.w = obtainStyledAttributes.getDimensionPixelOffset(index, this.w);
                        break;
                    case 8:
                        this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                        break;
                    case 9:
                        this.s = ConstraintSet.l(obtainStyledAttributes, index, this.s);
                        break;
                    case 10:
                        this.r = ConstraintSet.l(obtainStyledAttributes, index, this.r);
                        break;
                    case 11:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 12:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 13:
                        this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 14:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 15:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 16:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 17:
                        this.f1686c = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1686c);
                        break;
                    case 18:
                        this.f1689d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1689d);
                        break;
                    case 19:
                        this.f1678a = obtainStyledAttributes.getFloat(index, this.f1678a);
                        break;
                    case 20:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 21:
                        this.f1683b = obtainStyledAttributes.getLayoutDimension(index, this.f1683b);
                        break;
                    case 22:
                        this.f1679a = obtainStyledAttributes.getLayoutDimension(index, this.f1679a);
                        break;
                    case 23:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 24:
                        this.f1691e = ConstraintSet.l(obtainStyledAttributes, index, this.f1691e);
                        break;
                    case 25:
                        this.f1693f = ConstraintSet.l(obtainStyledAttributes, index, this.f1693f);
                        break;
                    case 26:
                        this.x = obtainStyledAttributes.getInt(index, this.x);
                        break;
                    case 27:
                        this.z = obtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 28:
                        this.f1695g = ConstraintSet.l(obtainStyledAttributes, index, this.f1695g);
                        break;
                    case 29:
                        this.f1696h = ConstraintSet.l(obtainStyledAttributes, index, this.f1696h);
                        break;
                    case 30:
                        this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                        break;
                    case 31:
                        this.p = ConstraintSet.l(obtainStyledAttributes, index, this.p);
                        break;
                    case 32:
                        this.q = ConstraintSet.l(obtainStyledAttributes, index, this.q);
                        break;
                    case 33:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 34:
                        this.j = ConstraintSet.l(obtainStyledAttributes, index, this.j);
                        break;
                    case 35:
                        this.i = ConstraintSet.l(obtainStyledAttributes, index, this.i);
                        break;
                    case 36:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 37:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 38:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 39:
                        this.M = obtainStyledAttributes.getInt(index, this.M);
                        break;
                    case 40:
                        this.N = obtainStyledAttributes.getInt(index, this.N);
                        break;
                    case 41:
                        ConstraintSet.m(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.m(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i3) {
                            case 61:
                                this.t = ConstraintSet.l(obtainStyledAttributes, index, this.t);
                                break;
                            case 62:
                                this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                                break;
                            case 63:
                                this.d = obtainStyledAttributes.getFloat(index, this.d);
                                break;
                            default:
                                switch (i3) {
                                    case 69:
                                        this.g = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.h = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        break;
                                    case 72:
                                        this.U = obtainStyledAttributes.getInt(index, this.U);
                                        break;
                                    case 73:
                                        this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                        break;
                                    case 74:
                                        this.f1684b = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f1694f = obtainStyledAttributes.getBoolean(index, this.f1694f);
                                        break;
                                    case 76:
                                        this.X = obtainStyledAttributes.getInt(index, this.X);
                                        break;
                                    case 77:
                                        this.n = ConstraintSet.l(obtainStyledAttributes, index, this.n);
                                        break;
                                    case 78:
                                        this.o = ConstraintSet.l(obtainStyledAttributes, index, this.o);
                                        break;
                                    case 79:
                                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                        break;
                                    case 80:
                                        this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                                        break;
                                    case 81:
                                        this.O = obtainStyledAttributes.getInt(index, this.O);
                                        break;
                                    case 82:
                                        this.P = obtainStyledAttributes.getInt(index, this.P);
                                        break;
                                    case 83:
                                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                                        break;
                                    case 84:
                                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                                        break;
                                    case 85:
                                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                        break;
                                    case 86:
                                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                        break;
                                    case 87:
                                        this.f1690d = obtainStyledAttributes.getBoolean(index, this.f1690d);
                                        break;
                                    case 88:
                                        this.f1692e = obtainStyledAttributes.getBoolean(index, this.f1692e);
                                        break;
                                    case 89:
                                        this.f1687c = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f1688c = obtainStyledAttributes.getBoolean(index, this.f1688c);
                                        break;
                                    case 91:
                                        Integer.toHexString(index);
                                        sparseIntArray.get(index);
                                        break;
                                    default:
                                        Integer.toHexString(index);
                                        sparseIntArray.get(index);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class c {
        public static final SparseIntArray a;

        /* renamed from: a  reason: collision with other field name */
        public float f1697a = Float.NaN;

        /* renamed from: a  reason: collision with other field name */
        public int f1698a = -1;

        /* renamed from: a  reason: collision with other field name */
        public String f1699a = null;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1700a = false;
        public float b = Float.NaN;

        /* renamed from: b  reason: collision with other field name */
        public int f1701b = 0;

        /* renamed from: b  reason: collision with other field name */
        public String f1702b = null;
        public float c = Float.NaN;

        /* renamed from: c  reason: collision with other field name */
        public int f1703c = -1;
        public int d = 0;
        public int e = -1;
        public int f = -3;
        public int g = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.Motion_motionPathRotate, 1);
            sparseIntArray.append(C0221hs.Motion_pathMotionArc, 2);
            sparseIntArray.append(C0221hs.Motion_transitionEasing, 3);
            sparseIntArray.append(C0221hs.Motion_drawPath, 4);
            sparseIntArray.append(C0221hs.Motion_animateRelativeTo, 5);
            sparseIntArray.append(C0221hs.Motion_animateCircleAngleTo, 6);
            sparseIntArray.append(C0221hs.Motion_motionStagger, 7);
            sparseIntArray.append(C0221hs.Motion_quantizeMotionSteps, 8);
            sparseIntArray.append(C0221hs.Motion_quantizeMotionPhase, 9);
            sparseIntArray.append(C0221hs.Motion_quantizeMotionInterpolator, 10);
        }

        public final void a(c cVar) {
            this.f1700a = cVar.f1700a;
            this.f1698a = cVar.f1698a;
            this.f1699a = cVar.f1699a;
            this.f1703c = cVar.f1703c;
            this.d = cVar.d;
            this.b = cVar.b;
            this.f1697a = cVar.f1697a;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.Motion);
            this.f1700a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.f1703c = obtainStyledAttributes.getInt(index, this.f1703c);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.f1699a = T9.f544a[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.f1699a = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.d = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1698a = ConstraintSet.l(obtainStyledAttributes, index, this.f1698a);
                        break;
                    case 6:
                        this.f1701b = obtainStyledAttributes.getInteger(index, this.f1701b);
                        break;
                    case 7:
                        this.f1697a = obtainStyledAttributes.getFloat(index, this.f1697a);
                        break;
                    case 8:
                        this.e = obtainStyledAttributes.getInteger(index, this.e);
                        break;
                    case 9:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 != 1) {
                            if (i2 != 3) {
                                this.f = obtainStyledAttributes.getInteger(index, this.g);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.f1702b = string;
                                if (string.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                    this.f = -1;
                                    break;
                                } else {
                                    this.g = obtainStyledAttributes.getResourceId(index, -1);
                                    this.f = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.g = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.f = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class d {
        public float a = 1.0f;

        /* renamed from: a  reason: collision with other field name */
        public int f1704a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1705a = false;
        public float b = Float.NaN;

        /* renamed from: b  reason: collision with other field name */
        public int f1706b = 0;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.PropertySet);
            this.f1705a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.PropertySet_android_alpha) {
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                } else if (index == C0221hs.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f1704a);
                    this.f1704a = i2;
                    this.f1704a = ConstraintSet.f1657a[i2];
                } else if (index == C0221hs.PropertySet_visibilityMode) {
                    this.f1706b = obtainStyledAttributes.getInt(index, this.f1706b);
                } else if (index == C0221hs.PropertySet_motionProgress) {
                    this.b = obtainStyledAttributes.getFloat(index, this.b);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {
        public static final SparseIntArray a;

        /* renamed from: a  reason: collision with other field name */
        public float f1707a = 0.0f;

        /* renamed from: a  reason: collision with other field name */
        public int f1708a = -1;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1709a = false;
        public float b = 0.0f;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1710b = false;
        public float c = 0.0f;
        public float d = 1.0f;
        public float e = 1.0f;
        public float f = Float.NaN;
        public float g = Float.NaN;
        public float h = 0.0f;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.Transform_android_rotation, 1);
            sparseIntArray.append(C0221hs.Transform_android_rotationX, 2);
            sparseIntArray.append(C0221hs.Transform_android_rotationY, 3);
            sparseIntArray.append(C0221hs.Transform_android_scaleX, 4);
            sparseIntArray.append(C0221hs.Transform_android_scaleY, 5);
            sparseIntArray.append(C0221hs.Transform_android_transformPivotX, 6);
            sparseIntArray.append(C0221hs.Transform_android_transformPivotY, 7);
            sparseIntArray.append(C0221hs.Transform_android_translationX, 8);
            sparseIntArray.append(C0221hs.Transform_android_translationY, 9);
            sparseIntArray.append(C0221hs.Transform_android_translationZ, 10);
            sparseIntArray.append(C0221hs.Transform_android_elevation, 11);
            sparseIntArray.append(C0221hs.Transform_transformPivotTarget, 12);
        }

        public final void a(e eVar) {
            this.f1709a = eVar.f1709a;
            this.f1707a = eVar.f1707a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.f1708a = eVar.f1708a;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.f1710b = eVar.f1710b;
            this.k = eVar.k;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.Transform);
            this.f1709a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        this.f1707a = obtainStyledAttributes.getFloat(index, this.f1707a);
                        break;
                    case 2:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 3:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 4:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 5:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 6:
                        this.f = obtainStyledAttributes.getDimension(index, this.f);
                        break;
                    case 7:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 8:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 9:
                        this.i = obtainStyledAttributes.getDimension(index, this.i);
                        break;
                    case 10:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 11:
                        this.f1710b = true;
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 12:
                        this.f1708a = ConstraintSet.l(obtainStyledAttributes, index, this.f1708a);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        b = sparseIntArray2;
        sparseIntArray.append(C0221hs.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(C0221hs.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(C0221hs.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(C0221hs.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(C0221hs.Constraint_android_orientation, 27);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(C0221hs.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(C0221hs.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(C0221hs.Constraint_android_layout_width, 23);
        sparseIntArray.append(C0221hs.Constraint_android_layout_height, 21);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(C0221hs.Constraint_android_visibility, 22);
        sparseIntArray.append(C0221hs.Constraint_android_alpha, 43);
        sparseIntArray.append(C0221hs.Constraint_android_elevation, 44);
        sparseIntArray.append(C0221hs.Constraint_android_rotationX, 45);
        sparseIntArray.append(C0221hs.Constraint_android_rotationY, 46);
        sparseIntArray.append(C0221hs.Constraint_android_rotation, 60);
        sparseIntArray.append(C0221hs.Constraint_android_scaleX, 47);
        sparseIntArray.append(C0221hs.Constraint_android_scaleY, 48);
        sparseIntArray.append(C0221hs.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(C0221hs.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(C0221hs.Constraint_android_translationX, 51);
        sparseIntArray.append(C0221hs.Constraint_android_translationY, 52);
        sparseIntArray.append(C0221hs.Constraint_android_translationZ, 53);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(C0221hs.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(C0221hs.Constraint_transitionEasing, 65);
        sparseIntArray.append(C0221hs.Constraint_drawPath, 66);
        sparseIntArray.append(C0221hs.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(C0221hs.Constraint_motionStagger, 79);
        sparseIntArray.append(C0221hs.Constraint_android_id, 38);
        sparseIntArray.append(C0221hs.Constraint_motionProgress, 68);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(C0221hs.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(C0221hs.Constraint_chainUseRtl, 71);
        sparseIntArray.append(C0221hs.Constraint_barrierDirection, 72);
        sparseIntArray.append(C0221hs.Constraint_barrierMargin, 73);
        sparseIntArray.append(C0221hs.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(C0221hs.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(C0221hs.Constraint_pathMotionArc, 76);
        sparseIntArray.append(C0221hs.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(C0221hs.Constraint_visibilityMode, 78);
        sparseIntArray.append(C0221hs.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(C0221hs.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(C0221hs.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(C0221hs.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(C0221hs.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(C0221hs.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(C0221hs.Constraint_quantizeMotionInterpolator, 86);
        int i = C0221hs.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray2.append(i, 6);
        sparseIntArray2.append(i, 7);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(C0221hs.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(C0221hs.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(C0221hs.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(C0221hs.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(C0221hs.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(C0221hs.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(C0221hs.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(C0221hs.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(C0221hs.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(C0221hs.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(C0221hs.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(C0221hs.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(C0221hs.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(C0221hs.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(C0221hs.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(C0221hs.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(C0221hs.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(C0221hs.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(C0221hs.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(C0221hs.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(C0221hs.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static a d(Context context, XmlResourceParser xmlResourceParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, C0221hs.ConstraintOverride);
        o(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public static int[] f(Barrier barrier, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = Ir.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, FacebookMediationAdapter.KEY_ID, context.getPackageName());
            }
            if (i == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) barrier.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        if (i3 != split.length) {
            return Arrays.copyOf(iArr, i3);
        }
        return iArr;
    }

    public static a g(Context context, AttributeSet attributeSet, boolean z) {
        int[] iArr;
        a aVar = new a();
        if (z) {
            iArr = C0221hs.ConstraintOverride;
        } else {
            iArr = C0221hs.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (z) {
            o(aVar, obtainStyledAttributes);
        } else {
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                b bVar = aVar.f1665a;
                if (i < indexCount) {
                    int index = obtainStyledAttributes.getIndex(i);
                    int i2 = C0221hs.Constraint_android_id;
                    d dVar = aVar.f1667a;
                    e eVar = aVar.f1668a;
                    c cVar = aVar.f1666a;
                    if (!(index == i2 || C0221hs.Constraint_android_layout_marginStart == index || C0221hs.Constraint_android_layout_marginEnd == index)) {
                        cVar.f1700a = true;
                        bVar.f1685b = true;
                        dVar.f1705a = true;
                        eVar.f1709a = true;
                    }
                    SparseIntArray sparseIntArray = a;
                    switch (sparseIntArray.get(index)) {
                        case 1:
                            bVar.m = l(obtainStyledAttributes, index, bVar.m);
                            break;
                        case 2:
                            bVar.B = obtainStyledAttributes.getDimensionPixelSize(index, bVar.B);
                            break;
                        case 3:
                            bVar.l = l(obtainStyledAttributes, index, bVar.l);
                            break;
                        case 4:
                            bVar.k = l(obtainStyledAttributes, index, bVar.k);
                            break;
                        case 5:
                            bVar.f1680a = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            bVar.v = obtainStyledAttributes.getDimensionPixelOffset(index, bVar.v);
                            break;
                        case 7:
                            bVar.w = obtainStyledAttributes.getDimensionPixelOffset(index, bVar.w);
                            break;
                        case 8:
                            bVar.C = obtainStyledAttributes.getDimensionPixelSize(index, bVar.C);
                            break;
                        case 9:
                            bVar.s = l(obtainStyledAttributes, index, bVar.s);
                            break;
                        case 10:
                            bVar.r = l(obtainStyledAttributes, index, bVar.r);
                            break;
                        case 11:
                            bVar.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar.I);
                            break;
                        case 12:
                            bVar.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar.J);
                            break;
                        case 13:
                            bVar.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar.F);
                            break;
                        case 14:
                            bVar.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar.H);
                            break;
                        case 15:
                            bVar.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar.K);
                            break;
                        case 16:
                            bVar.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar.G);
                            break;
                        case 17:
                            bVar.f1686c = obtainStyledAttributes.getDimensionPixelOffset(index, bVar.f1686c);
                            break;
                        case 18:
                            bVar.f1689d = obtainStyledAttributes.getDimensionPixelOffset(index, bVar.f1689d);
                            break;
                        case 19:
                            bVar.f1678a = obtainStyledAttributes.getFloat(index, bVar.f1678a);
                            break;
                        case 20:
                            bVar.b = obtainStyledAttributes.getFloat(index, bVar.b);
                            break;
                        case 21:
                            bVar.f1683b = obtainStyledAttributes.getLayoutDimension(index, bVar.f1683b);
                            break;
                        case 22:
                            dVar.f1704a = f1657a[obtainStyledAttributes.getInt(index, dVar.f1704a)];
                            break;
                        case 23:
                            bVar.f1679a = obtainStyledAttributes.getLayoutDimension(index, bVar.f1679a);
                            break;
                        case 24:
                            bVar.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar.y);
                            break;
                        case 25:
                            bVar.f1691e = l(obtainStyledAttributes, index, bVar.f1691e);
                            break;
                        case 26:
                            bVar.f1693f = l(obtainStyledAttributes, index, bVar.f1693f);
                            break;
                        case 27:
                            bVar.x = obtainStyledAttributes.getInt(index, bVar.x);
                            break;
                        case 28:
                            bVar.z = obtainStyledAttributes.getDimensionPixelSize(index, bVar.z);
                            break;
                        case 29:
                            bVar.f1695g = l(obtainStyledAttributes, index, bVar.f1695g);
                            break;
                        case 30:
                            bVar.f1696h = l(obtainStyledAttributes, index, bVar.f1696h);
                            break;
                        case 31:
                            bVar.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar.D);
                            break;
                        case 32:
                            bVar.p = l(obtainStyledAttributes, index, bVar.p);
                            break;
                        case 33:
                            bVar.q = l(obtainStyledAttributes, index, bVar.q);
                            break;
                        case 34:
                            bVar.A = obtainStyledAttributes.getDimensionPixelSize(index, bVar.A);
                            break;
                        case 35:
                            bVar.j = l(obtainStyledAttributes, index, bVar.j);
                            break;
                        case 36:
                            bVar.i = l(obtainStyledAttributes, index, bVar.i);
                            break;
                        case 37:
                            bVar.c = obtainStyledAttributes.getFloat(index, bVar.c);
                            break;
                        case 38:
                            aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                            break;
                        case 39:
                            bVar.f = obtainStyledAttributes.getFloat(index, bVar.f);
                            break;
                        case 40:
                            bVar.e = obtainStyledAttributes.getFloat(index, bVar.e);
                            break;
                        case 41:
                            bVar.M = obtainStyledAttributes.getInt(index, bVar.M);
                            break;
                        case 42:
                            bVar.N = obtainStyledAttributes.getInt(index, bVar.N);
                            break;
                        case 43:
                            dVar.a = obtainStyledAttributes.getFloat(index, dVar.a);
                            break;
                        case 44:
                            eVar.f1710b = true;
                            eVar.k = obtainStyledAttributes.getDimension(index, eVar.k);
                            break;
                        case 45:
                            eVar.b = obtainStyledAttributes.getFloat(index, eVar.b);
                            break;
                        case 46:
                            eVar.c = obtainStyledAttributes.getFloat(index, eVar.c);
                            break;
                        case 47:
                            eVar.d = obtainStyledAttributes.getFloat(index, eVar.d);
                            break;
                        case 48:
                            eVar.e = obtainStyledAttributes.getFloat(index, eVar.e);
                            break;
                        case 49:
                            eVar.f = obtainStyledAttributes.getDimension(index, eVar.f);
                            break;
                        case 50:
                            eVar.g = obtainStyledAttributes.getDimension(index, eVar.g);
                            break;
                        case 51:
                            eVar.h = obtainStyledAttributes.getDimension(index, eVar.h);
                            break;
                        case 52:
                            eVar.i = obtainStyledAttributes.getDimension(index, eVar.i);
                            break;
                        case 53:
                            eVar.j = obtainStyledAttributes.getDimension(index, eVar.j);
                            break;
                        case 54:
                            bVar.O = obtainStyledAttributes.getInt(index, bVar.O);
                            break;
                        case 55:
                            bVar.P = obtainStyledAttributes.getInt(index, bVar.P);
                            break;
                        case 56:
                            bVar.Q = obtainStyledAttributes.getDimensionPixelSize(index, bVar.Q);
                            break;
                        case 57:
                            bVar.R = obtainStyledAttributes.getDimensionPixelSize(index, bVar.R);
                            break;
                        case 58:
                            bVar.S = obtainStyledAttributes.getDimensionPixelSize(index, bVar.S);
                            break;
                        case 59:
                            bVar.T = obtainStyledAttributes.getDimensionPixelSize(index, bVar.T);
                            break;
                        case 60:
                            eVar.f1707a = obtainStyledAttributes.getFloat(index, eVar.f1707a);
                            break;
                        case 61:
                            bVar.t = l(obtainStyledAttributes, index, bVar.t);
                            break;
                        case 62:
                            bVar.u = obtainStyledAttributes.getDimensionPixelSize(index, bVar.u);
                            break;
                        case 63:
                            bVar.d = obtainStyledAttributes.getFloat(index, bVar.d);
                            break;
                        case 64:
                            cVar.f1698a = l(obtainStyledAttributes, index, cVar.f1698a);
                            break;
                        case 65:
                            if (obtainStyledAttributes.peekValue(index).type != 3) {
                                cVar.f1699a = T9.f544a[obtainStyledAttributes.getInteger(index, 0)];
                                break;
                            } else {
                                cVar.f1699a = obtainStyledAttributes.getString(index);
                                break;
                            }
                        case 66:
                            cVar.d = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 67:
                            cVar.b = obtainStyledAttributes.getFloat(index, cVar.b);
                            break;
                        case 68:
                            dVar.b = obtainStyledAttributes.getFloat(index, dVar.b);
                            break;
                        case 69:
                            bVar.g = obtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 70:
                            bVar.h = obtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 71:
                            break;
                        case 72:
                            bVar.U = obtainStyledAttributes.getInt(index, bVar.U);
                            break;
                        case 73:
                            bVar.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar.V);
                            break;
                        case 74:
                            bVar.f1684b = obtainStyledAttributes.getString(index);
                            break;
                        case 75:
                            bVar.f1694f = obtainStyledAttributes.getBoolean(index, bVar.f1694f);
                            break;
                        case 76:
                            cVar.f1703c = obtainStyledAttributes.getInt(index, cVar.f1703c);
                            break;
                        case 77:
                            bVar.f1687c = obtainStyledAttributes.getString(index);
                            break;
                        case 78:
                            dVar.f1706b = obtainStyledAttributes.getInt(index, dVar.f1706b);
                            break;
                        case 79:
                            cVar.f1697a = obtainStyledAttributes.getFloat(index, cVar.f1697a);
                            break;
                        case 80:
                            bVar.f1690d = obtainStyledAttributes.getBoolean(index, bVar.f1690d);
                            break;
                        case 81:
                            bVar.f1692e = obtainStyledAttributes.getBoolean(index, bVar.f1692e);
                            break;
                        case 82:
                            cVar.f1701b = obtainStyledAttributes.getInteger(index, cVar.f1701b);
                            break;
                        case 83:
                            eVar.f1708a = l(obtainStyledAttributes, index, eVar.f1708a);
                            break;
                        case 84:
                            cVar.e = obtainStyledAttributes.getInteger(index, cVar.e);
                            break;
                        case 85:
                            cVar.c = obtainStyledAttributes.getFloat(index, cVar.c);
                            break;
                        case 86:
                            int i3 = obtainStyledAttributes.peekValue(index).type;
                            if (i3 != 1) {
                                if (i3 != 3) {
                                    cVar.f = obtainStyledAttributes.getInteger(index, cVar.g);
                                    break;
                                } else {
                                    String string = obtainStyledAttributes.getString(index);
                                    cVar.f1702b = string;
                                    if (string.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                        cVar.f = -1;
                                        break;
                                    } else {
                                        cVar.g = obtainStyledAttributes.getResourceId(index, -1);
                                        cVar.f = -2;
                                        break;
                                    }
                                }
                            } else {
                                int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                                cVar.g = resourceId;
                                if (resourceId == -1) {
                                    break;
                                } else {
                                    cVar.f = -2;
                                    break;
                                }
                            }
                        case 87:
                            Integer.toHexString(index);
                            sparseIntArray.get(index);
                            break;
                        case 91:
                            bVar.n = l(obtainStyledAttributes, index, bVar.n);
                            break;
                        case 92:
                            bVar.o = l(obtainStyledAttributes, index, bVar.o);
                            break;
                        case 93:
                            bVar.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar.E);
                            break;
                        case 94:
                            bVar.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar.L);
                            break;
                        case 95:
                            m(bVar, obtainStyledAttributes, index, 0);
                            break;
                        case 96:
                            m(bVar, obtainStyledAttributes, index, 1);
                            break;
                        case 97:
                            bVar.X = obtainStyledAttributes.getInt(index, bVar.X);
                            break;
                        default:
                            Integer.toHexString(index);
                            sparseIntArray.get(index);
                            break;
                    }
                    i++;
                } else if (bVar.f1684b != null) {
                    bVar.f1682a = null;
                }
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public static int l(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r9.peekValue(r10)
            int r0 = r0.type
            r1 = 3
            r2 = 21
            r3 = 23
            r4 = 1
            r5 = -1
            r6 = 5
            r7 = 0
            if (r0 == r1) goto L_0x006d
            if (r0 == r6) goto L_0x0029
            int r9 = r9.getInt(r10, r7)
            r10 = -4
            r0 = -2
            if (r9 == r10) goto L_0x0027
            r10 = -3
            if (r9 == r10) goto L_0x0025
            if (r9 == r0) goto L_0x002d
            if (r9 == r5) goto L_0x002d
        L_0x0025:
            r4 = r7
            goto L_0x002f
        L_0x0027:
            r7 = r0
            goto L_0x002f
        L_0x0029:
            int r9 = r9.getDimensionPixelSize(r10, r7)
        L_0x002d:
            r4 = r7
            r7 = r9
        L_0x002f:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r9 == 0) goto L_0x0041
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            if (r11 != 0) goto L_0x003c
            r8.width = r7
            r8.f1632b = r4
            goto L_0x006c
        L_0x003c:
            r8.height = r7
            r8.f1634c = r4
            goto L_0x006c
        L_0x0041:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.b
            if (r9 == 0) goto L_0x0053
            androidx.constraintlayout.widget.ConstraintSet$b r8 = (androidx.constraintlayout.widget.ConstraintSet.b) r8
            if (r11 != 0) goto L_0x004e
            r8.f1679a = r7
            r8.f1690d = r4
            goto L_0x006c
        L_0x004e:
            r8.f1683b = r7
            r8.f1692e = r4
            goto L_0x006c
        L_0x0053:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.a.C0007a
            if (r9 == 0) goto L_0x006c
            androidx.constraintlayout.widget.ConstraintSet$a$a r8 = (androidx.constraintlayout.widget.ConstraintSet.a.C0007a) r8
            if (r11 != 0) goto L_0x0064
            r8.b(r3, r7)
            r9 = 80
            r8.d(r9, r4)
            goto L_0x006c
        L_0x0064:
            r8.b(r2, r7)
            r9 = 81
            r8.d(r9, r4)
        L_0x006c:
            return
        L_0x006d:
            java.lang.String r9 = r9.getString(r10)
            if (r9 != 0) goto L_0x0075
            goto L_0x0175
        L_0x0075:
            r10 = 61
            int r10 = r9.indexOf(r10)
            int r0 = r9.length()
            if (r10 <= 0) goto L_0x0175
            int r0 = r0 + r5
            if (r10 >= r0) goto L_0x0175
            java.lang.String r0 = r9.substring(r7, r10)
            int r10 = r10 + r4
            java.lang.String r9 = r9.substring(r10)
            int r10 = r9.length()
            if (r10 <= 0) goto L_0x0175
            java.lang.String r10 = r0.trim()
            java.lang.String r9 = r9.trim()
            java.lang.String r0 = "ratio"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x00ca
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r10 == 0) goto L_0x00b5
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            if (r11 != 0) goto L_0x00ae
            r8.width = r7
            goto L_0x00b0
        L_0x00ae:
            r8.height = r7
        L_0x00b0:
            n(r8, r9)
            goto L_0x0175
        L_0x00b5:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.b
            if (r10 == 0) goto L_0x00bf
            androidx.constraintlayout.widget.ConstraintSet$b r8 = (androidx.constraintlayout.widget.ConstraintSet.b) r8
            r8.f1680a = r9
            goto L_0x0175
        L_0x00bf:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.a.C0007a
            if (r10 == 0) goto L_0x0175
            androidx.constraintlayout.widget.ConstraintSet$a$a r8 = (androidx.constraintlayout.widget.ConstraintSet.a.C0007a) r8
            r8.c(r6, r9)
            goto L_0x0175
        L_0x00ca:
            java.lang.String r0 = "weight"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x0118
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0175 }
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams     // Catch:{ NumberFormatException -> 0x0175 }
            if (r10 == 0) goto L_0x00ea
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x00e4
            r8.width = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.e = r9     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x00e4:
            r8.height = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.f = r9     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x00ea:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.b     // Catch:{ NumberFormatException -> 0x0175 }
            if (r10 == 0) goto L_0x00fe
            androidx.constraintlayout.widget.ConstraintSet$b r8 = (androidx.constraintlayout.widget.ConstraintSet.b) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x00f8
            r8.f1679a = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.f = r9     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x00f8:
            r8.f1683b = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.e = r9     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x00fe:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.a.C0007a     // Catch:{ NumberFormatException -> 0x0175 }
            if (r10 == 0) goto L_0x0175
            androidx.constraintlayout.widget.ConstraintSet$a$a r8 = (androidx.constraintlayout.widget.ConstraintSet.a.C0007a) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x010f
            r8.b(r3, r7)     // Catch:{ NumberFormatException -> 0x0175 }
            r10 = 39
            r8.a(r9, r10)     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x010f:
            r8.b(r2, r7)     // Catch:{ NumberFormatException -> 0x0175 }
            r10 = 40
            r8.a(r9, r10)     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x0118:
            java.lang.String r0 = "parent"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0175
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0175 }
            r10 = 1065353216(0x3f800000, float:1.0)
            float r9 = java.lang.Math.min(r10, r9)     // Catch:{ NumberFormatException -> 0x0175 }
            r10 = 0
            float r9 = java.lang.Math.max(r10, r9)     // Catch:{ NumberFormatException -> 0x0175 }
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams     // Catch:{ NumberFormatException -> 0x0175 }
            r0 = 2
            if (r10 == 0) goto L_0x0146
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x013f
            r8.width = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.g = r9     // Catch:{ NumberFormatException -> 0x0175 }
            r8.D = r0     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x013f:
            r8.height = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.h = r9     // Catch:{ NumberFormatException -> 0x0175 }
            r8.E = r0     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x0146:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.b     // Catch:{ NumberFormatException -> 0x0175 }
            if (r10 == 0) goto L_0x015c
            androidx.constraintlayout.widget.ConstraintSet$b r8 = (androidx.constraintlayout.widget.ConstraintSet.b) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x0155
            r8.f1679a = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.g = r9     // Catch:{ NumberFormatException -> 0x0175 }
            r8.O = r0     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x0155:
            r8.f1683b = r7     // Catch:{ NumberFormatException -> 0x0175 }
            r8.h = r9     // Catch:{ NumberFormatException -> 0x0175 }
            r8.P = r0     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x015c:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.a.C0007a     // Catch:{ NumberFormatException -> 0x0175 }
            if (r9 == 0) goto L_0x0175
            androidx.constraintlayout.widget.ConstraintSet$a$a r8 = (androidx.constraintlayout.widget.ConstraintSet.a.C0007a) r8     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 != 0) goto L_0x016d
            r8.b(r3, r7)     // Catch:{ NumberFormatException -> 0x0175 }
            r9 = 54
            r8.b(r9, r0)     // Catch:{ NumberFormatException -> 0x0175 }
            goto L_0x0175
        L_0x016d:
            r8.b(r2, r7)     // Catch:{ NumberFormatException -> 0x0175 }
            r9 = 55
            r8.b(r9, r0)     // Catch:{ NumberFormatException -> 0x0175 }
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.m(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void n(ConstraintLayout.LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i = 0;
            int i2 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    if (substring.equalsIgnoreCase("H")) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                }
                i2 = i;
                i = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i);
                if (substring2.length() > 0) {
                    Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i2 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.f1628a = str;
    }

    public static void o(a aVar, TypedArray typedArray) {
        int i;
        a aVar2 = aVar;
        TypedArray typedArray2 = typedArray;
        int indexCount = typedArray.getIndexCount();
        a.C0007a aVar3 = new a.C0007a();
        aVar2.f1664a = aVar3;
        c cVar = aVar2.f1666a;
        int i2 = 0;
        cVar.f1700a = false;
        b bVar = aVar2.f1665a;
        bVar.f1685b = false;
        d dVar = aVar2.f1667a;
        dVar.f1705a = false;
        e eVar = aVar2.f1668a;
        eVar.f1709a = false;
        int i3 = 0;
        while (i3 < indexCount) {
            int index = typedArray2.getIndex(i3);
            int i4 = b.get(index);
            SparseIntArray sparseIntArray = a;
            switch (i4) {
                case 2:
                    i = i2;
                    aVar3.b(2, typedArray2.getDimensionPixelSize(index, bVar.B));
                    continue;
                case 5:
                    i = i2;
                    aVar3.c(5, typedArray2.getString(index));
                    continue;
                case 6:
                    i = i2;
                    aVar3.b(6, typedArray2.getDimensionPixelOffset(index, bVar.v));
                    continue;
                case 7:
                    i = i2;
                    aVar3.b(7, typedArray2.getDimensionPixelOffset(index, bVar.w));
                    continue;
                case 8:
                    i = i2;
                    aVar3.b(8, typedArray2.getDimensionPixelSize(index, bVar.C));
                    continue;
                case 11:
                    i = i2;
                    aVar3.b(11, typedArray2.getDimensionPixelSize(index, bVar.I));
                    continue;
                case 12:
                    i = i2;
                    aVar3.b(12, typedArray2.getDimensionPixelSize(index, bVar.J));
                    continue;
                case 13:
                    i = i2;
                    aVar3.b(13, typedArray2.getDimensionPixelSize(index, bVar.F));
                    continue;
                case 14:
                    i = i2;
                    aVar3.b(14, typedArray2.getDimensionPixelSize(index, bVar.H));
                    continue;
                case 15:
                    i = i2;
                    aVar3.b(15, typedArray2.getDimensionPixelSize(index, bVar.K));
                    continue;
                case 16:
                    i = i2;
                    aVar3.b(16, typedArray2.getDimensionPixelSize(index, bVar.G));
                    continue;
                case 17:
                    i = i2;
                    aVar3.b(17, typedArray2.getDimensionPixelOffset(index, bVar.f1686c));
                    continue;
                case 18:
                    i = i2;
                    aVar3.b(18, typedArray2.getDimensionPixelOffset(index, bVar.f1689d));
                    continue;
                case 19:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.f1678a), 19);
                    continue;
                case 20:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.b), 20);
                    continue;
                case 21:
                    i = i2;
                    aVar3.b(21, typedArray2.getLayoutDimension(index, bVar.f1683b));
                    continue;
                case 22:
                    i = i2;
                    aVar3.b(22, f1657a[typedArray2.getInt(index, dVar.f1704a)]);
                    continue;
                case 23:
                    i = i2;
                    aVar3.b(23, typedArray2.getLayoutDimension(index, bVar.f1679a));
                    continue;
                case 24:
                    i = i2;
                    aVar3.b(24, typedArray2.getDimensionPixelSize(index, bVar.y));
                    continue;
                case 27:
                    i = i2;
                    aVar3.b(27, typedArray2.getInt(index, bVar.x));
                    continue;
                case 28:
                    i = i2;
                    aVar3.b(28, typedArray2.getDimensionPixelSize(index, bVar.z));
                    continue;
                case 31:
                    i = i2;
                    aVar3.b(31, typedArray2.getDimensionPixelSize(index, bVar.D));
                    continue;
                case 34:
                    i = i2;
                    aVar3.b(34, typedArray2.getDimensionPixelSize(index, bVar.A));
                    continue;
                case 37:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.c), 37);
                    continue;
                case 38:
                    i = i2;
                    int resourceId = typedArray2.getResourceId(index, aVar2.a);
                    aVar2.a = resourceId;
                    aVar3.b(38, resourceId);
                    continue;
                case 39:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.f), 39);
                    continue;
                case 40:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.e), 40);
                    continue;
                case 41:
                    i = i2;
                    aVar3.b(41, typedArray2.getInt(index, bVar.M));
                    continue;
                case 42:
                    i = i2;
                    aVar3.b(42, typedArray2.getInt(index, bVar.N));
                    continue;
                case 43:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, dVar.a), 43);
                    continue;
                case 44:
                    i = i2;
                    aVar3.d(44, true);
                    aVar3.a(typedArray2.getDimension(index, eVar.k), 44);
                    continue;
                case 45:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, eVar.b), 45);
                    continue;
                case 46:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, eVar.c), 46);
                    continue;
                case 47:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, eVar.d), 47);
                    continue;
                case 48:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, eVar.e), 48);
                    continue;
                case 49:
                    i = i2;
                    aVar3.a(typedArray2.getDimension(index, eVar.f), 49);
                    continue;
                case 50:
                    i = i2;
                    aVar3.a(typedArray2.getDimension(index, eVar.g), 50);
                    continue;
                case 51:
                    i = i2;
                    aVar3.a(typedArray2.getDimension(index, eVar.h), 51);
                    continue;
                case 52:
                    i = i2;
                    aVar3.a(typedArray2.getDimension(index, eVar.i), 52);
                    continue;
                case 53:
                    i = i2;
                    aVar3.a(typedArray2.getDimension(index, eVar.j), 53);
                    continue;
                case 54:
                    i = i2;
                    aVar3.b(54, typedArray2.getInt(index, bVar.O));
                    continue;
                case 55:
                    i = i2;
                    aVar3.b(55, typedArray2.getInt(index, bVar.P));
                    continue;
                case 56:
                    i = i2;
                    aVar3.b(56, typedArray2.getDimensionPixelSize(index, bVar.Q));
                    continue;
                case 57:
                    i = i2;
                    aVar3.b(57, typedArray2.getDimensionPixelSize(index, bVar.R));
                    continue;
                case 58:
                    i = i2;
                    aVar3.b(58, typedArray2.getDimensionPixelSize(index, bVar.S));
                    continue;
                case 59:
                    i = i2;
                    aVar3.b(59, typedArray2.getDimensionPixelSize(index, bVar.T));
                    continue;
                case 60:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, eVar.f1707a), 60);
                    continue;
                case 62:
                    i = i2;
                    aVar3.b(62, typedArray2.getDimensionPixelSize(index, bVar.u));
                    continue;
                case 63:
                    i = i2;
                    aVar3.a(typedArray2.getFloat(index, bVar.d), 63);
                    continue;
                case 64:
                    i = i2;
                    aVar3.b(64, l(typedArray2, index, cVar.f1698a));
                    continue;
                case 65:
                    i = i2;
                    if (typedArray2.peekValue(index).type != 3) {
                        aVar3.c(65, T9.f544a[typedArray2.getInteger(index, i)]);
                        break;
                    } else {
                        aVar3.c(65, typedArray2.getString(index));
                        continue;
                    }
                case 66:
                    i = 0;
                    aVar3.b(66, typedArray2.getInt(index, 0));
                    continue;
                case 67:
                    aVar3.a(typedArray2.getFloat(index, cVar.b), 67);
                    break;
                case 68:
                    aVar3.a(typedArray2.getFloat(index, dVar.b), 68);
                    break;
                case 69:
                    aVar3.a(typedArray2.getFloat(index, 1.0f), 69);
                    break;
                case 70:
                    aVar3.a(typedArray2.getFloat(index, 1.0f), 70);
                    break;
                case 71:
                    break;
                case 72:
                    aVar3.b(72, typedArray2.getInt(index, bVar.U));
                    break;
                case 73:
                    aVar3.b(73, typedArray2.getDimensionPixelSize(index, bVar.V));
                    break;
                case 74:
                    aVar3.c(74, typedArray2.getString(index));
                    break;
                case 75:
                    aVar3.d(75, typedArray2.getBoolean(index, bVar.f1694f));
                    break;
                case 76:
                    aVar3.b(76, typedArray2.getInt(index, cVar.f1703c));
                    break;
                case 77:
                    aVar3.c(77, typedArray2.getString(index));
                    break;
                case 78:
                    aVar3.b(78, typedArray2.getInt(index, dVar.f1706b));
                    break;
                case 79:
                    aVar3.a(typedArray2.getFloat(index, cVar.f1697a), 79);
                    break;
                case 80:
                    aVar3.d(80, typedArray2.getBoolean(index, bVar.f1690d));
                    break;
                case 81:
                    aVar3.d(81, typedArray2.getBoolean(index, bVar.f1692e));
                    break;
                case 82:
                    aVar3.b(82, typedArray2.getInteger(index, cVar.f1701b));
                    break;
                case 83:
                    aVar3.b(83, l(typedArray2, index, eVar.f1708a));
                    break;
                case 84:
                    aVar3.b(84, typedArray2.getInteger(index, cVar.e));
                    break;
                case 85:
                    aVar3.a(typedArray2.getFloat(index, cVar.c), 85);
                    break;
                case 86:
                    int i5 = typedArray2.peekValue(index).type;
                    if (i5 != 1) {
                        if (i5 != 3) {
                            int integer = typedArray2.getInteger(index, cVar.g);
                            cVar.f = integer;
                            aVar3.b(88, integer);
                            break;
                        } else {
                            String string = typedArray2.getString(index);
                            cVar.f1702b = string;
                            aVar3.c(90, string);
                            if (cVar.f1702b.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                cVar.f = -1;
                                aVar3.b(88, -1);
                                break;
                            } else {
                                int resourceId2 = typedArray2.getResourceId(index, -1);
                                cVar.g = resourceId2;
                                aVar3.b(89, resourceId2);
                                cVar.f = -2;
                                aVar3.b(88, -2);
                                break;
                            }
                        }
                    } else {
                        int resourceId3 = typedArray2.getResourceId(index, -1);
                        cVar.g = resourceId3;
                        aVar3.b(89, resourceId3);
                        if (cVar.g != -1) {
                            cVar.f = -2;
                            aVar3.b(88, -2);
                            break;
                        }
                    }
                    break;
                case 87:
                    Integer.toHexString(index);
                    sparseIntArray.get(index);
                    break;
                case 93:
                    aVar3.b(93, typedArray2.getDimensionPixelSize(index, bVar.E));
                    break;
                case 94:
                    aVar3.b(94, typedArray2.getDimensionPixelSize(index, bVar.L));
                    break;
                case 95:
                    m(aVar3, typedArray2, index, i2);
                    break;
                case 96:
                    m(aVar3, typedArray2, index, 1);
                    break;
                case 97:
                    aVar3.b(97, typedArray2.getInt(index, bVar.X));
                    break;
                case 98:
                    if (!MotionLayout.k) {
                        if (typedArray2.peekValue(index).type != 3) {
                            aVar2.a = typedArray2.getResourceId(index, aVar2.a);
                            break;
                        } else {
                            aVar2.f1669a = typedArray2.getString(index);
                            break;
                        }
                    } else {
                        int resourceId4 = typedArray2.getResourceId(index, aVar2.a);
                        aVar2.a = resourceId4;
                        if (resourceId4 == -1) {
                            aVar2.f1669a = typedArray2.getString(index);
                            break;
                        }
                    }
                    break;
                case 99:
                    aVar3.d(99, typedArray2.getBoolean(index, bVar.f1688c));
                    break;
                default:
                    i = i2;
                    Integer.toHexString(index);
                    sparseIntArray.get(index);
                    continue;
            }
            i = 0;
            i3++;
            i2 = i;
        }
    }

    public final void a(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            HashMap<Integer, a> hashMap = this.f1663b;
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                C0175e8.d(childAt);
            } else if (this.f1661a && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (hashMap.containsKey(Integer.valueOf(id)) && (aVar = hashMap.get(Integer.valueOf(id))) != null) {
                O6.e(childAt, aVar.f1670a);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        c(constraintLayout);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public final void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> hashMap = this.f1663b;
        HashSet hashSet = new HashSet(hashMap.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                C0175e8.d(childAt);
            } else if (this.f1661a && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && hashMap.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = hashMap.get(Integer.valueOf(id));
                if (aVar != null) {
                    if (childAt instanceof Barrier) {
                        b bVar = aVar.f1665a;
                        bVar.W = 1;
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(bVar.U);
                        barrier.setMargin(bVar.V);
                        barrier.setAllowsGoneWidget(bVar.f1694f);
                        int[] iArr = bVar.f1682a;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = bVar.f1684b;
                            if (str != null) {
                                int[] f = f(barrier, str);
                                bVar.f1682a = f;
                                barrier.setReferencedIds(f);
                            }
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.a();
                    aVar.a(layoutParams);
                    O6.e(childAt, aVar.f1670a);
                    childAt.setLayoutParams(layoutParams);
                    d dVar = aVar.f1667a;
                    if (dVar.f1706b == 0) {
                        childAt.setVisibility(dVar.f1704a);
                    }
                    childAt.setAlpha(dVar.a);
                    e eVar = aVar.f1668a;
                    childAt.setRotation(eVar.f1707a);
                    childAt.setRotationX(eVar.b);
                    childAt.setRotationY(eVar.c);
                    childAt.setScaleX(eVar.d);
                    childAt.setScaleY(eVar.e);
                    if (eVar.f1708a != -1) {
                        View findViewById = ((View) childAt.getParent()).findViewById(eVar.f1708a);
                        if (findViewById != null) {
                            float bottom = ((float) (findViewById.getBottom() + findViewById.getTop())) / 2.0f;
                            float right = ((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f;
                            if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                childAt.setPivotX(right - ((float) childAt.getLeft()));
                                childAt.setPivotY(bottom - ((float) childAt.getTop()));
                            }
                        }
                    } else {
                        if (!Float.isNaN(eVar.f)) {
                            childAt.setPivotX(eVar.f);
                        }
                        if (!Float.isNaN(eVar.g)) {
                            childAt.setPivotY(eVar.g);
                        }
                    }
                    childAt.setTranslationX(eVar.h);
                    childAt.setTranslationY(eVar.i);
                    childAt.setTranslationZ(eVar.j);
                    if (eVar.f1710b) {
                        childAt.setElevation(eVar.k);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = hashMap.get(num);
            if (aVar2 != null) {
                b bVar2 = aVar2.f1665a;
                if (bVar2.W == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = bVar2.f1682a;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f1684b;
                        if (str2 != null) {
                            int[] f2 = f(barrier2, str2);
                            bVar2.f1682a = f2;
                            barrier2.setReferencedIds(f2);
                        }
                    }
                    barrier2.setType(bVar2.U);
                    barrier2.setMargin(bVar2.V);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.t();
                    aVar2.a(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (bVar2.f1681a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.a(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).j(constraintLayout);
            }
        }
    }

    public final void e(ConstraintLayout constraintLayout) {
        int i;
        int i2;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> hashMap = constraintSet.f1663b;
        hashMap.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!constraintSet.f1661a || id != -1) {
                if (!hashMap.containsKey(Integer.valueOf(id))) {
                    hashMap.put(Integer.valueOf(id), new a());
                }
                a aVar = hashMap.get(Integer.valueOf(id));
                if (aVar == null) {
                    i = childCount;
                } else {
                    HashMap<String, O6> hashMap2 = constraintSet.f1660a;
                    HashMap<String, O6> hashMap3 = new HashMap<>();
                    Class<?> cls = childAt.getClass();
                    for (String next : hashMap2.keySet()) {
                        O6 o6 = hashMap2.get(next);
                        try {
                            if (next.equals("BackgroundColor")) {
                                hashMap3.put(next, new O6(o6, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } else {
                                i2 = childCount;
                                try {
                                    hashMap3.put(next, new O6(o6, cls.getMethod("getMap" + next, new Class[0]).invoke(childAt, new Object[0])));
                                } catch (NoSuchMethodException e2) {
                                    e = e2;
                                } catch (IllegalAccessException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    childCount = i2;
                                } catch (InvocationTargetException e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    childCount = i2;
                                }
                                childCount = i2;
                            }
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            i2 = childCount;
                            e.printStackTrace();
                            childCount = i2;
                        } catch (IllegalAccessException e6) {
                            e = e6;
                            i2 = childCount;
                            e.printStackTrace();
                            childCount = i2;
                        } catch (InvocationTargetException e7) {
                            e = e7;
                            i2 = childCount;
                            e.printStackTrace();
                            childCount = i2;
                        }
                    }
                    i = childCount;
                    aVar.f1670a = hashMap3;
                    aVar.c(id, layoutParams);
                    int visibility = childAt.getVisibility();
                    d dVar = aVar.f1667a;
                    dVar.f1704a = visibility;
                    dVar.a = childAt.getAlpha();
                    float rotation = childAt.getRotation();
                    e eVar = aVar.f1668a;
                    eVar.f1707a = rotation;
                    eVar.b = childAt.getRotationX();
                    eVar.c = childAt.getRotationY();
                    eVar.d = childAt.getScaleX();
                    eVar.e = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        eVar.f = pivotX;
                        eVar.g = pivotY;
                    }
                    eVar.h = childAt.getTranslationX();
                    eVar.i = childAt.getTranslationY();
                    eVar.j = childAt.getTranslationZ();
                    if (eVar.f1710b) {
                        eVar.k = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
                        b bVar = aVar.f1665a;
                        bVar.f1694f = allowsGoneWidget;
                        bVar.f1682a = barrier.getReferencedIds();
                        bVar.U = barrier.getType();
                        bVar.V = barrier.getMargin();
                    }
                }
                i3++;
                constraintSet = this;
                childCount = i;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final a h(int i) {
        HashMap<Integer, a> hashMap = this.f1663b;
        if (!hashMap.containsKey(Integer.valueOf(i))) {
            hashMap.put(Integer.valueOf(i), new a());
        }
        return hashMap.get(Integer.valueOf(i));
    }

    public final a i(int i) {
        HashMap<Integer, a> hashMap = this.f1663b;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public final void j(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a g = g(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        g.f1665a.f1681a = true;
                    }
                    this.f1663b.put(Integer.valueOf(g.a), g);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01da
            if (r0 == 0) goto L_0x01c8
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0015
            goto L_0x01cb
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r7
            goto L_0x004e
        L_0x0031:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r6
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r3
            goto L_0x004e
        L_0x0045:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r5) goto L_0x0058
            goto L_0x01cb
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$a> r0 = r9.f1663b     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r3 = r2.a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2 = r1
            goto L_0x01cb
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r7
            goto L_0x00d9
        L_0x007e:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r5
            goto L_0x00d9
        L_0x0093:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r6
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r3
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cb
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, O6> r0 = r2.f1670a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            defpackage.O6.d(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.ConstraintSet$c r0 = r2.f1666a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.ConstraintSet$b r0 = r2.f1665a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.ConstraintSet$e r0 = r2.f1668a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.ConstraintSet$d r0 = r2.f1667a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$a r0 = g(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$b r2 = r0.f1665a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.W = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$a r0 = g(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$b r2 = r0.f1665a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f1681a = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f1685b = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01b5:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$a r0 = g(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01be:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$a r0 = g(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01c6:
            r2 = r0
            goto L_0x01cb
        L_0x01c8:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01cb:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x0006
        L_0x01d1:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01da
        L_0x01d6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.k(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
