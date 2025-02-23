package defpackage;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: Um  reason: default package */
/* compiled from: NotificationCompat */
public final class Um extends Ym {
    public IconCompat a;
    public IconCompat b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f576b;

    /* renamed from: Um$a */
    /* compiled from: NotificationCompat */
    public static class a {
        public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigLargeIcon(icon);
        }
    }

    /* renamed from: Um$b */
    /* compiled from: NotificationCompat */
    public static class b {
        public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigPicture(icon);
        }

        public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            bigPictureStyle.setContentDescription(charSequence);
        }

        public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
            bigPictureStyle.showBigPictureWhenCollapsed(z);
        }
    }

    public final void b(Zm zm) {
        Bitmap bitmap;
        Zm zm2 = zm;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(zm2.a).setBigContentTitle(this.f713a);
        IconCompat iconCompat = this.a;
        Context context = zm2.f765a;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                b.a(bigContentTitle, IconCompat.a.f(iconCompat, context));
            } else {
                int i = iconCompat.a;
                if (i == -1) {
                    i = IconCompat.a.c(iconCompat.f1781a);
                }
                if (i == 1) {
                    IconCompat iconCompat2 = this.a;
                    int i2 = iconCompat2.a;
                    if (i2 == -1) {
                        Object obj = iconCompat2.f1781a;
                        if (obj instanceof Bitmap) {
                            bitmap = (Bitmap) obj;
                        } else {
                            bitmap = null;
                        }
                    } else if (i2 == 1) {
                        bitmap = (Bitmap) iconCompat2.f1781a;
                    } else if (i2 == 5) {
                        Bitmap bitmap2 = (Bitmap) iconCompat2.f1781a;
                        int min = (int) (((float) Math.min(bitmap2.getWidth(), bitmap2.getHeight())) * 0.6666667f);
                        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        Paint paint = new Paint(3);
                        float f = (float) min;
                        float f2 = 0.5f * f;
                        float f3 = 0.9166667f * f2;
                        float f4 = 0.010416667f * f;
                        paint.setColor(0);
                        paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
                        canvas.drawCircle(f2, f2, f3, paint);
                        paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
                        canvas.drawCircle(f2, f2, f3, paint);
                        paint.clearShadowLayer();
                        paint.setColor(-16777216);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                        Matrix matrix = new Matrix();
                        matrix.setTranslate(((float) (-(bitmap2.getWidth() - min))) / 2.0f, ((float) (-(bitmap2.getHeight() - min))) / 2.0f);
                        bitmapShader.setLocalMatrix(matrix);
                        paint.setShader(bitmapShader);
                        canvas.drawCircle(f2, f2, f3, paint);
                        canvas.setBitmap((Bitmap) null);
                        bitmap = createBitmap;
                    } else {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bigContentTitle = bigContentTitle.bigPicture(bitmap);
                }
            }
        }
        if (this.f576b) {
            IconCompat iconCompat3 = this.b;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                a.a(bigContentTitle, IconCompat.a.f(iconCompat3, context));
            }
        }
        if (this.f714a) {
            bigContentTitle.setSummaryText(this.b);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            b.c(bigContentTitle, false);
            b.b(bigContentTitle, (CharSequence) null);
        }
    }

    public final String c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    public final void h(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f1781a = bitmap;
            iconCompat = iconCompat2;
        }
        this.b = iconCompat;
        this.f576b = true;
    }

    public final void i(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f1781a = bitmap;
            iconCompat = iconCompat2;
        }
        this.a = iconCompat;
    }
}
