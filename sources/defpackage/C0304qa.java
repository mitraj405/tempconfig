package defpackage;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.emoji2.text.d;

/* renamed from: qa  reason: default package and case insensitive filesystem */
/* compiled from: EmojiTextViewHelper */
public final class C0304qa {
    public final b a;

    /* renamed from: qa$a */
    /* compiled from: EmojiTextViewHelper */
    public static class a extends b {
        public final TextView a;

        /* renamed from: a  reason: collision with other field name */
        public final C0270ma f3187a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3188a = true;

        public a(TextView textView) {
            this.a = textView;
            this.f3187a = new C0270ma(textView);
        }

        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f3188a) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i = 0; i < inputFilterArr.length; i++) {
                    InputFilter inputFilter = inputFilterArr[i];
                    if (inputFilter instanceof C0270ma) {
                        sparseArray.put(i, inputFilter);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - sparseArray.size())];
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (sparseArray.indexOfKey(i3) < 0) {
                        inputFilterArr2[i2] = inputFilterArr[i3];
                        i2++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            int i4 = 0;
            while (true) {
                C0270ma maVar = this.f3187a;
                if (i4 >= length2) {
                    InputFilter[] inputFilterArr3 = new InputFilter[(inputFilterArr.length + 1)];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = maVar;
                    return inputFilterArr3;
                } else if (inputFilterArr[i4] == maVar) {
                    return inputFilterArr;
                } else {
                    i4++;
                }
            }
        }

        public final boolean b() {
            return this.f3188a;
        }

        public final void c(boolean z) {
            if (z) {
                TextView textView = this.a;
                textView.setTransformationMethod(e(textView.getTransformationMethod()));
            }
        }

        public final void d(boolean z) {
            this.f3188a = z;
            TextView textView = this.a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
            textView.setFilters(a(textView.getFilters()));
        }

        public final TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f3188a) {
                if (!(transformationMethod instanceof C0327sa) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                    return new C0327sa(transformationMethod);
                }
                return transformationMethod;
            } else if (transformationMethod instanceof C0327sa) {
                return ((C0327sa) transformationMethod).a;
            } else {
                return transformationMethod;
            }
        }
    }

    /* renamed from: qa$b */
    /* compiled from: EmojiTextViewHelper */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z) {
            throw null;
        }

        public void d(boolean z) {
            throw null;
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* renamed from: qa$c */
    /* compiled from: EmojiTextViewHelper */
    public static class c extends b {
        public final a a;

        public c(TextView textView) {
            this.a = new a(textView);
        }

        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            boolean z;
            if (d.a != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return inputFilterArr;
            }
            return this.a.a(inputFilterArr);
        }

        public final boolean b() {
            return this.a.f3188a;
        }

        public final void c(boolean z) {
            boolean z2;
            if (d.a != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(!z2)) {
                this.a.c(z);
            }
        }

        public final void d(boolean z) {
            boolean z2;
            if (d.a != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = !z2;
            a aVar = this.a;
            if (z3) {
                aVar.f3188a = z;
            } else {
                aVar.d(z);
            }
        }

        public final TransformationMethod e(TransformationMethod transformationMethod) {
            boolean z;
            if (d.a != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return transformationMethod;
            }
            return this.a.e(transformationMethod);
        }
    }

    public C0304qa(TextView textView) {
        if (textView != null) {
            this.a = new c(textView);
            return;
        }
        throw new NullPointerException("textView cannot be null");
    }
}
