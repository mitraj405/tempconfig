package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: l8  reason: default package and case insensitive filesystem */
/* compiled from: DecoderThread */
public final class C1236l8 {
    public final O3 a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f5575a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f5576a;

    /* renamed from: a  reason: collision with other field name */
    public HandlerThread f5577a;

    /* renamed from: a  reason: collision with other field name */
    public C1172i8 f5578a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f5579a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final a f5580a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f5581a = new b();

    /* renamed from: a  reason: collision with other field name */
    public boolean f5582a = false;
    public final Handler b;

    /* renamed from: l8$a */
    /* compiled from: DecoderThread */
    public class a implements Handler.Callback {
        public a() {
        }

        public final boolean handleMessage(Message message) {
            PlanarYUVLuminanceSource planarYUVLuminanceSource;
            Result result;
            C1429us usVar;
            Message message2 = message;
            int i = message2.what;
            int i2 = R.id.zxing_decode;
            C1236l8 l8Var = C1236l8.this;
            if (i == i2) {
                C0466Bx bx = (C0466Bx) message2.obj;
                l8Var.getClass();
                System.currentTimeMillis();
                Rect rect = l8Var.f5575a;
                bx.f3536a = rect;
                Result result2 = null;
                C1429us usVar2 = bx.f3537a;
                if (rect == null) {
                    planarYUVLuminanceSource = null;
                } else {
                    byte[] bArr = usVar2.f6986a;
                    int i3 = bx.b;
                    int i4 = usVar2.b;
                    int i5 = usVar2.a;
                    if (i3 == 90) {
                        byte[] bArr2 = new byte[(i5 * i4)];
                        int i6 = 0;
                        for (int i7 = 0; i7 < i5; i7++) {
                            for (int i8 = i4 - 1; i8 >= 0; i8--) {
                                bArr2[i6] = bArr[(i8 * i5) + i7];
                                i6++;
                            }
                        }
                        usVar = new C1429us(bArr2, i4, i5);
                    } else if (i3 == 180) {
                        int i9 = i5 * i4;
                        byte[] bArr3 = new byte[i9];
                        int i10 = i9 - 1;
                        for (int i11 = 0; i11 < i9; i11++) {
                            bArr3[i10] = bArr[i11];
                            i10--;
                        }
                        usVar = new C1429us(bArr3, i5, i4);
                    } else if (i3 != 270) {
                        usVar = usVar2;
                    } else {
                        int i12 = i5 * i4;
                        byte[] bArr4 = new byte[i12];
                        int i13 = i12 - 1;
                        for (int i14 = 0; i14 < i5; i14++) {
                            for (int i15 = i4 - 1; i15 >= 0; i15--) {
                                bArr4[i13] = bArr[(i15 * i5) + i14];
                                i13--;
                            }
                        }
                        usVar = new C1429us(bArr4, i4, i5);
                    }
                    Rect rect2 = bx.f3536a;
                    int width = rect2.width() / 1;
                    int height = rect2.height() / 1;
                    int i16 = rect2.top;
                    byte[] bArr5 = new byte[(width * height)];
                    int i17 = usVar.a;
                    int i18 = (i16 * i17) + rect2.left;
                    for (int i19 = 0; i19 < height; i19++) {
                        System.arraycopy(usVar.f6986a, i18, bArr5, i19 * width, width);
                        i18 += i17;
                    }
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr5, width, height, 0, 0, width, height, false);
                }
                if (planarYUVLuminanceSource != null) {
                    C1172i8 i8Var = l8Var.f5578a;
                    BinaryBitmap a2 = i8Var.a(planarYUVLuminanceSource);
                    Reader reader = i8Var.a;
                    i8Var.f5484a.clear();
                    try {
                        if (reader instanceof MultiFormatReader) {
                            result = ((MultiFormatReader) reader).decodeWithState(a2);
                        } else {
                            result = reader.decode(a2);
                        }
                        result2 = result;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        reader.reset();
                        throw th;
                    }
                    reader.reset();
                }
                Handler handler = l8Var.b;
                if (result2 != null) {
                    System.currentTimeMillis();
                    if (handler != null) {
                        Message obtain = Message.obtain(handler, R.id.zxing_decode_succeeded, new C1272n2(result2, bx));
                        obtain.setData(new Bundle());
                        obtain.sendToTarget();
                    }
                } else if (handler != null) {
                    Message.obtain(handler, R.id.zxing_decode_failed).sendToTarget();
                }
                if (handler != null) {
                    C1172i8 i8Var2 = l8Var.f5578a;
                    i8Var2.getClass();
                    ArrayList arrayList = new ArrayList(i8Var2.f5484a);
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultPoint resultPoint = (ResultPoint) it.next();
                        float f = (float) 1;
                        float x = (resultPoint.getX() * f) + ((float) bx.f3536a.left);
                        float y = (resultPoint.getY() * f) + ((float) bx.f3536a.top);
                        if (bx.f3538a) {
                            x = ((float) usVar2.a) - x;
                        }
                        arrayList2.add(new ResultPoint(x, y));
                    }
                    Message.obtain(handler, R.id.zxing_possible_result_points, arrayList2).sendToTarget();
                }
                O3 o3 = l8Var.a;
                o3.b.post(new Ft(3, o3, l8Var.f5581a));
            } else if (i == R.id.zxing_preview_failed) {
                O3 o32 = l8Var.a;
                o32.b.post(new Ft(3, o32, l8Var.f5581a));
            }
            return true;
        }
    }

    /* renamed from: l8$b */
    /* compiled from: DecoderThread */
    public class b implements C1287nq {
        public b() {
        }
    }

    public C1236l8(O3 o3, C1172i8 i8Var, Handler handler) {
        r1.U();
        this.a = o3;
        this.f5578a = i8Var;
        this.b = handler;
    }
}
