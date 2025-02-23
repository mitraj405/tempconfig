package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements t5 {
    public static final o a;

    /* renamed from: a  reason: collision with other field name */
    public F7 f1226a;

    /* renamed from: a  reason: collision with other field name */
    public SearchableInfo f1227a;

    /* renamed from: a  reason: collision with other field name */
    public final Intent f1228a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1229a;

    /* renamed from: a  reason: collision with other field name */
    public final Drawable f1230a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f1231a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnClickListener f1232a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnFocusChangeListener f1233a;

    /* renamed from: a  reason: collision with other field name */
    public final View f1234a;

    /* renamed from: a  reason: collision with other field name */
    public final ImageView f1235a;

    /* renamed from: a  reason: collision with other field name */
    public final SearchAutoComplete f1236a;

    /* renamed from: a  reason: collision with other field name */
    public final b f1237a;

    /* renamed from: a  reason: collision with other field name */
    public final c f1238a;

    /* renamed from: a  reason: collision with other field name */
    public p f1239a;

    /* renamed from: a  reason: collision with other field name */
    public final CharSequence f1240a;

    /* renamed from: a  reason: collision with other field name */
    public final WeakHashMap<String, Drawable.ConstantState> f1241a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1242a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f1243a;
    public final Intent b;

    /* renamed from: b  reason: collision with other field name */
    public final Rect f1244b;

    /* renamed from: b  reason: collision with other field name */
    public final View f1245b;

    /* renamed from: b  reason: collision with other field name */
    public final ImageView f1246b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1247b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1248b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f1249b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final View f1250c;

    /* renamed from: c  reason: collision with other field name */
    public final ImageView f1251c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f1252c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1253c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public final View f1254d;

    /* renamed from: d  reason: collision with other field name */
    public final ImageView f1255d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1256d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public final ImageView f1257e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1258e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f1259f;
    public boolean g;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("SearchView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" isIconified=");
            return xx.G(sb, this.a, "}");
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        public final a a;

        /* renamed from: a  reason: collision with other field name */
        public SearchView f1260a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1261a;
        public int c;

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.f1261a) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.f1261a = false;
                }
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i >= 600) {
                return 192;
            }
            if (i < 640 || i2 < 480) {
                return 160;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            o oVar = SearchView.a;
            oVar.getClass();
            o.a();
            Method method = oVar.c;
            if (method != null) {
                try {
                    method.invoke(this, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }

        public final boolean enoughToFilter() {
            if (this.c <= 0 || super.enoughToFilter()) {
                return true;
            }
            return false;
        }

        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1261a) {
                a aVar = this.a;
                removeCallbacks(aVar);
                post(aVar);
            }
            return onCreateInputConnection;
        }

        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public final void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.f1260a;
            searchView.o(searchView.f1248b);
            searchView.post(searchView.f1237a);
            if (searchView.f1236a.hasFocus()) {
                searchView.d();
            }
        }

        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1260a.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1260a.hasFocus() && getVisibility() == 0) {
                boolean z2 = true;
                this.f1261a = true;
                Context context = getContext();
                o oVar = SearchView.a;
                if (context.getResources().getConfiguration().orientation != 2) {
                    z2 = false;
                }
                if (z2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            a aVar = this.a;
            if (!z) {
                this.f1261a = false;
                removeCallbacks(aVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1261a = false;
                removeCallbacks(aVar);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1261a = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1260a = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.c = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0220hr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new a();
            this.c = getThreshold();
        }

        public final void performCompletion() {
        }

        public final void replaceText(CharSequence charSequence) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            SearchView.this.k();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            F7 f7 = SearchView.this.f1226a;
            if (f7 instanceof Ey) {
                f7.c((Cursor) null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public final void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1233a;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            SearchView searchView = SearchView.this;
            View view2 = searchView.f1254d;
            if (view2.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.f1245b.getPaddingLeft();
                Rect rect = new Rect();
                boolean a2 = UC.a(searchView);
                if (searchView.f1242a) {
                    i9 = resources.getDimensionPixelSize(tr.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(tr.abc_dropdownitem_icon_width);
                } else {
                    i9 = 0;
                }
                SearchAutoComplete searchAutoComplete = searchView.f1236a;
                searchAutoComplete.getDropDownBackground().getPadding(rect);
                if (a2) {
                    i10 = -rect.left;
                } else {
                    i10 = paddingLeft - (rect.left + i9);
                }
                searchAutoComplete.setDropDownHorizontalOffset(i10);
                searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i9) - paddingLeft);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public final void onClick(View view) {
            String str;
            SearchView searchView = SearchView.this;
            ImageView imageView = searchView.f1235a;
            SearchAutoComplete searchAutoComplete = searchView.f1236a;
            if (view == imageView) {
                searchView.o(false);
                searchAutoComplete.requestFocus();
                searchAutoComplete.setImeVisibility(true);
                View.OnClickListener onClickListener = searchView.f1232a;
                if (onClickListener != null) {
                    onClickListener.onClick(searchView);
                }
            } else if (view == searchView.f1251c) {
                searchView.e();
            } else if (view == searchView.f1246b) {
                searchView.i();
            } else if (view == searchView.f1255d) {
                SearchableInfo searchableInfo = searchView.f1227a;
                if (searchableInfo != null) {
                    try {
                        if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                            Intent intent = new Intent(searchView.f1228a);
                            ComponentName searchActivity = searchableInfo.getSearchActivity();
                            if (searchActivity == null) {
                                str = null;
                            } else {
                                str = searchActivity.flattenToShortString();
                            }
                            intent.putExtra("calling_package", str);
                            searchView.getContext().startActivity(intent);
                        } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            searchView.getContext().startActivity(searchView.c(searchView.b, searchableInfo));
                        }
                    } catch (ActivityNotFoundException unused) {
                    }
                }
            } else if (view == searchAutoComplete) {
                searchView.d();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            boolean z;
            int i2;
            SearchView searchView = SearchView.this;
            if (searchView.f1227a == null) {
                return false;
            }
            SearchAutoComplete searchAutoComplete = searchView.f1236a;
            if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                searchView.getContext().startActivity(searchView.b("android.intent.action.SEARCH", (Uri) null, (String) null, searchAutoComplete.getText().toString()));
                return true;
            } else if (searchView.f1227a == null || searchView.f1226a == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
                return false;
            } else {
                if (i == 66 || i == 84 || i == 61) {
                    searchView.f(searchAutoComplete.getListSelection());
                } else if (i == 21 || i == 22) {
                    if (i == 21) {
                        i2 = 0;
                    } else {
                        i2 = searchAutoComplete.length();
                    }
                    searchAutoComplete.setSelection(i2);
                    searchAutoComplete.setListSelection(0);
                    searchAutoComplete.clearListSelection();
                    searchAutoComplete.a();
                } else if (i != 19) {
                    return false;
                } else {
                    searchAutoComplete.getListSelection();
                    return false;
                }
                return true;
            }
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.i();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.f(i);
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o {
        public final Method a = null;
        public final Method b = null;
        public final Method c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public o() {
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            a();
            try {
                Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    public static class p extends TouchDelegate {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Rect f1262a;

        /* renamed from: a  reason: collision with other field name */
        public final View f1263a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1264a;
        public final Rect b;
        public final Rect c;

        public p(Rect rect, Rect rect2, SearchAutoComplete searchAutoComplete) {
            super(rect, searchAutoComplete);
            int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
            this.a = scaledTouchSlop;
            Rect rect3 = new Rect();
            this.f1262a = rect3;
            Rect rect4 = new Rect();
            this.c = rect4;
            Rect rect5 = new Rect();
            this.b = rect5;
            rect3.set(rect);
            rect4.set(rect);
            int i = -scaledTouchSlop;
            rect4.inset(i, i);
            rect5.set(rect2);
            this.f1263a = searchAutoComplete;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0033
                if (r2 == r5) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.f1264a
                r8.f1264a = r4
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.f1264a
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.c
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r5 = r2
                r2 = r4
                goto L_0x0041
            L_0x002f:
                r7 = r5
                r5 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.f1262a
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.f1264a = r5
                r2 = r5
                goto L_0x0041
            L_0x003f:
                r2 = r5
                r5 = r4
            L_0x0041:
                if (r5 == 0) goto L_0x006e
                android.graphics.Rect r4 = r8.b
                android.view.View r5 = r8.f1263a
                if (r2 == 0) goto L_0x005f
                boolean r2 = r4.contains(r0, r1)
                if (r2 != 0) goto L_0x005f
                int r0 = r5.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                int r1 = r5.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                goto L_0x006a
            L_0x005f:
                int r2 = r4.left
                int r0 = r0 - r2
                float r0 = (float) r0
                int r2 = r4.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r9.setLocation(r0, r1)
            L_0x006a:
                boolean r4 = r5.dispatchTouchEvent(r9)
            L_0x006e:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.p.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static {
        o oVar;
        if (Build.VERSION.SDK_INT < 29) {
            oVar = new o();
        } else {
            oVar = null;
        }
        a = oVar;
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(tr.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(tr.abc_search_view_preferred_width);
    }

    public final Intent b(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1252c);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1231a;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f1227a.getSearchActivity());
        return intent;
    }

    public final Intent c(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i2;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1231a;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        } else {
            i2 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void clearFocus() {
        this.f1258e = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f1236a;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f1258e = false;
    }

    public final void d() {
        int i2 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f1236a;
        if (i2 >= 29) {
            k.a(searchAutoComplete);
            return;
        }
        o oVar = a;
        oVar.getClass();
        o.a();
        Method method = oVar.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        oVar.getClass();
        o.a();
        Method method2 = oVar.b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public final void e() {
        SearchAutoComplete searchAutoComplete = this.f1236a;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f1242a) {
            clearFocus();
            o(true);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.getPosition();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r6) {
        /*
            r5 = this;
            F7 r0 = r5.f1226a
            android.database.Cursor r0 = r0.f194a
            if (r0 == 0) goto L_0x008f
            boolean r6 = r0.moveToPosition(r6)
            if (r6 == 0) goto L_0x008f
            r6 = 0
            java.lang.String r1 = "suggest_intent_action"
            int r2 = defpackage.Ey.n     // Catch:{ RuntimeException -> 0x007e }
            int r1 = r0.getColumnIndex(r1)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r1 = defpackage.Ey.i(r0, r1)     // Catch:{ RuntimeException -> 0x007e }
            if (r1 != 0) goto L_0x0021
            android.app.SearchableInfo r1 = r5.f1227a     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r1 = r1.getSuggestIntentAction()     // Catch:{ RuntimeException -> 0x007e }
        L_0x0021:
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = "android.intent.action.SEARCH"
        L_0x0025:
            java.lang.String r2 = "suggest_intent_data"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r2 = defpackage.Ey.i(r0, r2)     // Catch:{ RuntimeException -> 0x007e }
            if (r2 != 0) goto L_0x0037
            android.app.SearchableInfo r2 = r5.f1227a     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r2 = r2.getSuggestIntentData()     // Catch:{ RuntimeException -> 0x007e }
        L_0x0037:
            if (r2 == 0) goto L_0x005d
            java.lang.String r3 = "suggest_intent_data_id"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r3 = defpackage.Ey.i(r0, r3)     // Catch:{ RuntimeException -> 0x007e }
            if (r3 == 0) goto L_0x005d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x007e }
            r4.<init>()     // Catch:{ RuntimeException -> 0x007e }
            r4.append(r2)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r2 = android.net.Uri.encode(r3)     // Catch:{ RuntimeException -> 0x007e }
            r4.append(r2)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r2 = r4.toString()     // Catch:{ RuntimeException -> 0x007e }
        L_0x005d:
            if (r2 != 0) goto L_0x0061
            r2 = r6
            goto L_0x0065
        L_0x0061:
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ RuntimeException -> 0x007e }
        L_0x0065:
            java.lang.String r3 = "suggest_intent_query"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r3 = defpackage.Ey.i(r0, r3)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r4 = "suggest_intent_extra_data"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ RuntimeException -> 0x007e }
            java.lang.String r4 = defpackage.Ey.i(r0, r4)     // Catch:{ RuntimeException -> 0x007e }
            android.content.Intent r6 = r5.b(r1, r2, r4, r3)     // Catch:{ RuntimeException -> 0x007e }
            goto L_0x0081
        L_0x007e:
            r0.getPosition()     // Catch:{ RuntimeException -> 0x0081 }
        L_0x0081:
            if (r6 != 0) goto L_0x0084
            goto L_0x008f
        L_0x0084:
            android.content.Context r0 = r5.getContext()     // Catch:{ RuntimeException -> 0x008c }
            r0.startActivity(r6)     // Catch:{ RuntimeException -> 0x008c }
            goto L_0x008f
        L_0x008c:
            r6.toString()
        L_0x008f:
            r6 = 0
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r5.f1236a
            r0.setImeVisibility(r6)
            r0.dismissDropDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.f(int):void");
    }

    public final void g(int i2) {
        Editable text = this.f1236a.getText();
        Cursor cursor = this.f1226a.f194a;
        if (cursor != null) {
            if (cursor.moveToPosition(i2)) {
                String d2 = this.f1226a.d(cursor);
                if (d2 != null) {
                    setQuery(d2);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    public int getImeOptions() {
        return this.f1236a.getImeOptions();
    }

    public int getInputType() {
        return this.f1236a.getInputType();
    }

    public int getMaxWidth() {
        return this.e;
    }

    public CharSequence getQuery() {
        return this.f1236a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1247b;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1227a;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.f1240a;
        }
        return getContext().getText(this.f1227a.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.d;
    }

    public int getSuggestionRowLayout() {
        return this.c;
    }

    public F7 getSuggestionsAdapter() {
        return this.f1226a;
    }

    public final void h(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void i() {
        SearchAutoComplete searchAutoComplete = this.f1236a;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1227a != null) {
                getContext().startActivity(b("android.intent.action.SEARCH", (Uri) null, (String) null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public final void j() {
        int[] iArr;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1236a.getText());
        int i2 = 0;
        if (!z2 && (!this.f1242a || this.g)) {
            z = false;
        }
        if (!z) {
            i2 = 8;
        }
        ImageView imageView = this.f1251c;
        imageView.setVisibility(i2);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (z2) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    public final void k() {
        int[] iArr;
        if (this.f1236a.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1245b.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1250c.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void l() {
        Drawable drawable;
        SpannableStringBuilder queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z = this.f1242a;
        SearchAutoComplete searchAutoComplete = this.f1236a;
        if (z && (drawable = this.f1230a) != null) {
            int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void m() {
        boolean z;
        int i2 = 0;
        if ((this.f1253c || this.f1259f) && !this.f1248b) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !(this.f1246b.getVisibility() == 0 || this.f1255d.getVisibility() == 0)) {
            i2 = 8;
        }
        this.f1250c.setVisibility(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (r2.f1259f == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.f1253c
            if (r0 == 0) goto L_0x0021
            r1 = 0
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.f1259f
            if (r0 == 0) goto L_0x0011
        L_0x000b:
            boolean r0 = r2.f1248b
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            if (r0 == 0) goto L_0x0021
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L_0x0021
            if (r3 != 0) goto L_0x0023
            boolean r3 = r2.f1259f
            if (r3 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r1 = 8
        L_0x0023:
            android.widget.ImageView r3 = r2.f1246b
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.n(boolean):void");
    }

    public final void o(boolean z) {
        int i2;
        int i3;
        int i4;
        this.f1248b = z;
        int i5 = 0;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        boolean z2 = !TextUtils.isEmpty(this.f1236a.getText());
        this.f1235a.setVisibility(i2);
        n(z2);
        if (z) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        this.f1234a.setVisibility(i3);
        ImageView imageView = this.f1257e;
        if (imageView.getDrawable() == null || this.f1242a) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        imageView.setVisibility(i4);
        j();
        boolean z3 = !z2;
        if (!this.f1259f || this.f1248b || !z3) {
            i5 = 8;
        } else {
            this.f1246b.setVisibility(8);
        }
        this.f1255d.setVisibility(i5);
        m();
    }

    public final void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        o(true);
        this.f1236a.setImeOptions(this.f);
        this.g = false;
    }

    public final void onActionViewExpanded() {
        if (!this.g) {
            this.g = true;
            SearchAutoComplete searchAutoComplete = this.f1236a;
            int imeOptions = searchAutoComplete.getImeOptions();
            this.f = imeOptions;
            searchAutoComplete.setImeOptions(imeOptions | 33554432);
            searchAutoComplete.setText("");
            setIconified(false);
        }
    }

    public final void onDetachedFromWindow() {
        removeCallbacks(this.f1237a);
        post(this.f1238a);
        super.onDetachedFromWindow();
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.f1236a;
            int[] iArr = this.f1243a;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f1249b;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            Rect rect = this.f1229a;
            rect.set(i7, i6, searchAutoComplete.getWidth() + i7, searchAutoComplete.getHeight() + i6);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.f1244b;
            rect2.set(i8, 0, i9, i10);
            p pVar = this.f1239a;
            if (pVar == null) {
                p pVar2 = new p(rect2, rect, searchAutoComplete);
                this.f1239a = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.f1262a.set(rect2);
            Rect rect3 = pVar.c;
            rect3.set(rect2);
            int i11 = -pVar.a;
            rect3.inset(i11, i11);
            pVar.b.set(rect);
        }
    }

    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.f1248b) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.e;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.e;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.e) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(size2, Ints.MAX_POWER_OF_TWO));
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        o(savedState.a);
        requestLayout();
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f1248b;
        return savedState;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.f1237a);
    }

    public final boolean requestFocus(int i2, Rect rect) {
        if (this.f1258e || !isFocusable()) {
            return false;
        }
        if (this.f1248b) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.f1236a.requestFocus(i2, rect);
        if (requestFocus) {
            o(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1231a = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            e();
            return;
        }
        o(false);
        SearchAutoComplete searchAutoComplete = this.f1236a;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1232a;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1242a != z) {
            this.f1242a = z;
            o(z);
            l();
        }
    }

    public void setImeOptions(int i2) {
        this.f1236a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1236a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.e = i2;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1233a = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1232a = onClickListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        SearchAutoComplete searchAutoComplete = this.f1236a;
        searchAutoComplete.setText(charSequence);
        if (charSequence != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1252c = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            i();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1247b = charSequence;
        l();
    }

    public void setQueryRefinementEnabled(boolean z) {
        int i2;
        this.f1256d = z;
        F7 f7 = this.f1226a;
        if (f7 instanceof Ey) {
            Ey ey = (Ey) f7;
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            ey.g = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        if (getContext().getPackageManager().resolveActivity(r3, 65536) != null) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(android.app.SearchableInfo r8) {
        /*
            r7 = this;
            r7.f1227a = r8
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r7.f1236a
            r1 = 1
            r2 = 65536(0x10000, float:9.18355E-41)
            r3 = 0
            if (r8 == 0) goto L_0x0068
            int r8 = r8.getSuggestThreshold()
            r0.setThreshold(r8)
            android.app.SearchableInfo r8 = r7.f1227a
            int r8 = r8.getImeOptions()
            r0.setImeOptions(r8)
            android.app.SearchableInfo r8 = r7.f1227a
            int r8 = r8.getInputType()
            r4 = r8 & 15
            if (r4 != r1) goto L_0x0034
            r4 = -65537(0xfffffffffffeffff, float:NaN)
            r8 = r8 & r4
            android.app.SearchableInfo r4 = r7.f1227a
            java.lang.String r4 = r4.getSuggestAuthority()
            if (r4 == 0) goto L_0x0034
            r8 = r8 | r2
            r4 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 | r4
        L_0x0034:
            r0.setInputType(r8)
            F7 r8 = r7.f1226a
            if (r8 == 0) goto L_0x003e
            r8.c(r3)
        L_0x003e:
            android.app.SearchableInfo r8 = r7.f1227a
            java.lang.String r8 = r8.getSuggestAuthority()
            if (r8 == 0) goto L_0x0065
            Ey r8 = new Ey
            android.content.Context r4 = r7.getContext()
            android.app.SearchableInfo r5 = r7.f1227a
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r6 = r7.f1241a
            r8.<init>(r4, r7, r5, r6)
            r7.f1226a = r8
            r0.setAdapter(r8)
            F7 r8 = r7.f1226a
            Ey r8 = (defpackage.Ey) r8
            boolean r4 = r7.f1256d
            if (r4 == 0) goto L_0x0062
            r4 = 2
            goto L_0x0063
        L_0x0062:
            r4 = r1
        L_0x0063:
            r8.g = r4
        L_0x0065:
            r7.l()
        L_0x0068:
            android.app.SearchableInfo r8 = r7.f1227a
            if (r8 == 0) goto L_0x0098
            boolean r8 = r8.getVoiceSearchEnabled()
            if (r8 == 0) goto L_0x0098
            android.app.SearchableInfo r8 = r7.f1227a
            boolean r8 = r8.getVoiceSearchLaunchWebSearch()
            if (r8 == 0) goto L_0x007d
            android.content.Intent r3 = r7.f1228a
            goto L_0x0087
        L_0x007d:
            android.app.SearchableInfo r8 = r7.f1227a
            boolean r8 = r8.getVoiceSearchLaunchRecognizer()
            if (r8 == 0) goto L_0x0087
            android.content.Intent r3 = r7.b
        L_0x0087:
            if (r3 == 0) goto L_0x0098
            android.content.Context r8 = r7.getContext()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            android.content.pm.ResolveInfo r8 = r8.resolveActivity(r3, r2)
            if (r8 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            r7.f1259f = r1
            if (r1 == 0) goto L_0x00a2
            java.lang.String r8 = "nm"
            r0.setPrivateImeOptions(r8)
        L_0x00a2:
            boolean r8 = r7.f1248b
            r7.o(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1253c = z;
        o(this.f1248b);
    }

    public void setSuggestionsAdapter(F7 f7) {
        this.f1226a = f7;
        this.f1236a.setAdapter(f7);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Context context2 = context;
        this.f1229a = new Rect();
        this.f1244b = new Rect();
        this.f1243a = new int[2];
        this.f1249b = new int[2];
        this.f1237a = new b();
        this.f1238a = new c();
        this.f1241a = new WeakHashMap<>();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        i iVar = new i();
        j jVar = new j();
        a aVar = new a();
        int[] iArr = ps.SearchView;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, iArr, i3, 0);
        TintTypedArray tintTypedArray = new TintTypedArray(context2, obtainStyledAttributes);
        androidx.core.view.f.n(this, context, iArr, attributeSet2, obtainStyledAttributes, i3);
        LayoutInflater.from(context).inflate(tintTypedArray.i(ps.SearchView_layout, Vr.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(Gr.search_src_text);
        this.f1236a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1234a = findViewById(Gr.search_edit_frame);
        View findViewById = findViewById(Gr.search_plate);
        this.f1245b = findViewById;
        View findViewById2 = findViewById(Gr.submit_area);
        this.f1250c = findViewById2;
        ImageView imageView = (ImageView) findViewById(Gr.search_button);
        this.f1235a = imageView;
        ImageView imageView2 = (ImageView) findViewById(Gr.search_go_btn);
        this.f1246b = imageView2;
        ImageView imageView3 = (ImageView) findViewById(Gr.search_close_btn);
        this.f1251c = imageView3;
        ImageView imageView4 = (ImageView) findViewById(Gr.search_voice_btn);
        this.f1255d = imageView4;
        ImageView imageView5 = (ImageView) findViewById(Gr.search_mag_icon);
        this.f1257e = imageView5;
        findViewById.setBackground(tintTypedArray.e(ps.SearchView_queryBackground));
        findViewById2.setBackground(tintTypedArray.e(ps.SearchView_submitBackground));
        int i4 = ps.SearchView_searchIcon;
        imageView.setImageDrawable(tintTypedArray.e(i4));
        imageView2.setImageDrawable(tintTypedArray.e(ps.SearchView_goIcon));
        imageView3.setImageDrawable(tintTypedArray.e(ps.SearchView_closeIcon));
        imageView4.setImageDrawable(tintTypedArray.e(ps.SearchView_voiceIcon));
        imageView5.setImageDrawable(tintTypedArray.e(i4));
        this.f1230a = tintTypedArray.e(ps.SearchView_searchHintIcon);
        C0234jA.a(imageView, getResources().getString(bs.abc_searchview_description_search));
        this.c = tintTypedArray.i(ps.SearchView_suggestionRowLayout, Vr.abc_search_dropdown_item_icons_2line);
        this.d = tintTypedArray.i(ps.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(aVar);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(gVar);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(tintTypedArray.a(ps.SearchView_iconifiedByDefault, true));
        int d2 = tintTypedArray.d(ps.SearchView_android_maxWidth, -1);
        if (d2 != -1) {
            setMaxWidth(d2);
        }
        this.f1240a = tintTypedArray.k(ps.SearchView_defaultQueryHint);
        this.f1247b = tintTypedArray.k(ps.SearchView_queryHint);
        int h2 = tintTypedArray.h(ps.SearchView_android_imeOptions, -1);
        if (h2 != -1) {
            setImeOptions(h2);
        }
        int h3 = tintTypedArray.h(ps.SearchView_android_inputType, -1);
        if (h3 != -1) {
            setInputType(h3);
        }
        setFocusable(tintTypedArray.a(ps.SearchView_android_focusable, true));
        tintTypedArray.n();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1228a = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.b = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1254d = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        o(this.f1242a);
        l();
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f1236a;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public class a implements TextWatcher {
        public a() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.f1236a.getText();
            searchView.f1252c = text;
            boolean z = !TextUtils.isEmpty(text);
            searchView.n(z);
            boolean z2 = !z;
            int i4 = 8;
            if (searchView.f1259f && !searchView.f1248b && z2) {
                searchView.f1246b.setVisibility(8);
                i4 = 0;
            }
            searchView.f1255d.setVisibility(i4);
            searchView.j();
            searchView.m();
            charSequence.toString();
            searchView.getClass();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.g(i);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSuggestionListener(n nVar) {
    }
}
