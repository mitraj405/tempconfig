package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.emoji2.text.d;
import defpackage.C0237ja;
import defpackage.C0316ra;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class AppCompatEmojiEditTextHelper {
    public final EditText a;

    /* renamed from: a  reason: collision with other field name */
    public final C0237ja f1163a;

    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.a = editText;
        this.f1163a = new C0237ja(editText);
    }

    public final KeyListener a(KeyListener keyListener) {
        if (!(!(keyListener instanceof NumberKeyListener))) {
            return keyListener;
        }
        this.f1163a.a.getClass();
        if (keyListener instanceof C0278na) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        return new C0278na(keyListener);
    }

    /* JADX INFO: finally extract failed */
    public final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, ps.AppCompatTextView, i, 0);
        try {
            int i2 = ps.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i2)) {
                z = obtainStyledAttributes.getBoolean(i2, true);
            }
            obtainStyledAttributes.recycle();
            d(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        C0237ja jaVar = this.f1163a;
        if (inputConnection == null) {
            jaVar.getClass();
            return null;
        }
        C0237ja.a aVar = jaVar.a;
        aVar.getClass();
        if (inputConnection instanceof C0257la) {
            return inputConnection;
        }
        return new C0257la(aVar.a, inputConnection, editorInfo);
    }

    public final void d(boolean z) {
        C0316ra raVar = this.f1163a.a.f3033a;
        if (raVar.b != z) {
            if (raVar.f3220a != null) {
                d a2 = d.a();
                C0316ra.a aVar = raVar.f3220a;
                a2.getClass();
                C1354qp.t(aVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a2.f2011a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a2.f2007a.remove(aVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            raVar.b = z;
            if (z) {
                C0316ra.a(raVar.a, d.a().b());
            }
        }
    }
}
