package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.emoji2.text.d;
import androidx.emoji2.text.h;
import defpackage.zo;

/* compiled from: EmojiProcessor */
public final class f {
    public final d.C0019d a;

    /* renamed from: a  reason: collision with other field name */
    public final d.i f2016a;

    /* renamed from: a  reason: collision with other field name */
    public final h f2017a;

    /* compiled from: EmojiProcessor */
    public static final class a {
        public int a = 1;

        /* renamed from: a  reason: collision with other field name */
        public final h.a f2018a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public h.a f2019b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public h.a f2020c;

        public a(h.a aVar) {
            this.f2018a = aVar;
            this.f2019b = aVar;
        }

        public final int a(int i) {
            h.a aVar;
            boolean z;
            SparseArray<h.a> sparseArray = this.f2019b.a;
            if (sparseArray == null) {
                aVar = null;
            } else {
                aVar = sparseArray.get(i);
            }
            int i2 = 1;
            if (this.a != 2) {
                if (aVar == null) {
                    b();
                    this.b = i;
                    return i2;
                }
                this.a = 2;
                this.f2019b = aVar;
                this.c = 1;
            } else if (aVar != null) {
                this.f2019b = aVar;
                this.c++;
            } else {
                boolean z2 = false;
                if (i == 65038) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    b();
                } else {
                    if (i == 65039) {
                        z2 = true;
                    }
                    if (!z2) {
                        h.a aVar2 = this.f2019b;
                        if (aVar2.f2031a != null) {
                            if (this.c != 1) {
                                this.f2020c = aVar2;
                                b();
                            } else if (c()) {
                                this.f2020c = this.f2019b;
                                b();
                            } else {
                                b();
                            }
                            i2 = 3;
                        } else {
                            b();
                        }
                    }
                }
                this.b = i;
                return i2;
            }
            i2 = 2;
            this.b = i;
            return i2;
        }

        public final void b() {
            this.a = 1;
            this.f2019b = this.f2018a;
            this.c = 0;
        }

        public final boolean c() {
            boolean z;
            boolean z2;
            kl c2 = this.f2019b.f2031a.c();
            int a2 = c2.a(6);
            if (a2 == 0 || c2.f3207a.get(a2 + c2.a) == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
            if (this.b == 65039) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
            return false;
        }
    }

    public f(h hVar, d.i iVar, b bVar) {
        this.f2016a = iVar;
        this.f2017a = hVar;
        this.a = bVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        boolean z2;
        C0295pa[] paVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && (paVarArr = (C0295pa[]) editable.getSpans(selectionStart, selectionEnd, C0295pa.class)) != null && paVarArr.length > 0) {
            int length = paVarArr.length;
            int i = 0;
            while (i < length) {
                C0295pa paVar = paVarArr[i];
                int spanStart = editable.getSpanStart(paVar);
                int spanEnd = editable.getSpanEnd(paVar);
                if ((!z || spanStart != selectionStart) && ((z || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i, int i2, C0287oa oaVar) {
        int i3;
        if (oaVar.b == 0) {
            d.C0019d dVar = this.a;
            kl c = oaVar.c();
            int a2 = c.a(8);
            if (a2 != 0) {
                c.f3207a.getShort(a2 + c.a);
            }
            b bVar = (b) dVar;
            bVar.getClass();
            ThreadLocal<StringBuilder> threadLocal = b.a;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = bVar.f2003a;
            String sb2 = sb.toString();
            int i4 = zo.a;
            if (zo.a.a(textPaint, sb2)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            oaVar.b = i3;
        }
        if (oaVar.b == 2) {
            return true;
        }
        return false;
    }
}
