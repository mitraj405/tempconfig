package defpackage;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: Ey  reason: default package */
/* compiled from: SuggestionsAdapter */
public final class Ey extends Ct implements View.OnClickListener {
    public static final /* synthetic */ int n = 0;
    public final SearchableInfo a;

    /* renamed from: a  reason: collision with other field name */
    public ColorStateList f170a;

    /* renamed from: a  reason: collision with other field name */
    public final SearchView f171a;

    /* renamed from: a  reason: collision with other field name */
    public final WeakHashMap<String, Drawable.ConstantState> f172a;
    public final Context b;
    public final int f;
    public int g = 1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;

    /* renamed from: Ey$a */
    /* compiled from: SuggestionsAdapter */
    public static final class a {
        public final ImageView a;

        /* renamed from: a  reason: collision with other field name */
        public final TextView f173a;
        public final ImageView b;

        /* renamed from: b  reason: collision with other field name */
        public final TextView f174b;
        public final ImageView c;

        public a(View view) {
            this.f173a = (TextView) view.findViewById(16908308);
            this.f174b = (TextView) view.findViewById(16908309);
            this.a = (ImageView) view.findViewById(16908295);
            this.b = (ImageView) view.findViewById(16908296);
            this.c = (ImageView) view.findViewById(Gr.edit_query);
        }
    }

    public Ey(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.f171a = searchView;
        this.a = searchableInfo;
        this.f = searchView.getSuggestionCommitIconResId();
        this.b = context;
        this.f172a = weakHashMap;
    }

    public static String i(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.view.View r22, android.database.Cursor r23) {
        /*
            r21 = this;
            r1 = r21
            r2 = r23
            java.lang.Object r0 = r22.getTag()
            r3 = r0
            Ey$a r3 = (defpackage.Ey.a) r3
            int r0 = r1.m
            r4 = 0
            r5 = -1
            if (r0 == r5) goto L_0x0017
            int r0 = r2.getInt(r0)
            r6 = r0
            goto L_0x0018
        L_0x0017:
            r6 = r4
        L_0x0018:
            android.widget.TextView r7 = r3.f173a
            r8 = 8
            if (r7 == 0) goto L_0x0034
            int r0 = r1.h
            java.lang.String r0 = i(r2, r0)
            r7.setText(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0031
            r7.setVisibility(r8)
            goto L_0x0034
        L_0x0031:
            r7.setVisibility(r4)
        L_0x0034:
            r9 = 1
            r10 = 2
            android.content.Context r11 = r1.b
            android.widget.TextView r0 = r3.f174b
            if (r0 == 0) goto L_0x00b9
            int r12 = r1.j
            java.lang.String r12 = i(r2, r12)
            if (r12 == 0) goto L_0x008c
            android.content.res.ColorStateList r13 = r1.f170a
            if (r13 != 0) goto L_0x0062
            android.util.TypedValue r13 = new android.util.TypedValue
            r13.<init>()
            android.content.res.Resources$Theme r14 = r11.getTheme()
            int r15 = defpackage.C0220hr.textColorSearchUrl
            r14.resolveAttribute(r15, r13, r9)
            android.content.res.Resources r14 = r11.getResources()
            int r13 = r13.resourceId
            android.content.res.ColorStateList r13 = r14.getColorStateList(r13)
            r1.f170a = r13
        L_0x0062:
            android.text.SpannableString r13 = new android.text.SpannableString
            r13.<init>(r12)
            android.text.style.TextAppearanceSpan r15 = new android.text.style.TextAppearanceSpan
            r16 = 0
            r17 = 0
            r18 = 0
            android.content.res.ColorStateList r14 = r1.f170a
            r19 = 0
            r20 = r14
            r14 = r15
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            int r12 = r12.length()
            r14 = 33
            r13.setSpan(r5, r4, r12, r14)
            goto L_0x0092
        L_0x008c:
            int r5 = r1.i
            java.lang.String r13 = i(r2, r5)
        L_0x0092:
            boolean r5 = android.text.TextUtils.isEmpty(r13)
            if (r5 == 0) goto L_0x00a1
            if (r7 == 0) goto L_0x00a9
            r7.setSingleLine(r4)
            r7.setMaxLines(r10)
            goto L_0x00a9
        L_0x00a1:
            if (r7 == 0) goto L_0x00a9
            r7.setSingleLine(r9)
            r7.setMaxLines(r9)
        L_0x00a9:
            r0.setText(r13)
            boolean r5 = android.text.TextUtils.isEmpty(r13)
            if (r5 == 0) goto L_0x00b6
            r0.setVisibility(r8)
            goto L_0x00b9
        L_0x00b6:
            r0.setVisibility(r4)
        L_0x00b9:
            android.widget.ImageView r12 = r3.a
            if (r12 == 0) goto L_0x0146
            int r0 = r1.k
            r13 = -1
            if (r0 != r13) goto L_0x00c5
            r0 = 0
            goto L_0x0133
        L_0x00c5:
            java.lang.String r0 = r2.getString(r0)
            android.graphics.drawable.Drawable r0 = r1.g(r0)
            if (r0 == 0) goto L_0x00d0
            goto L_0x0133
        L_0x00d0:
            android.app.SearchableInfo r0 = r1.a
            android.content.ComponentName r0 = r0.getSearchActivity()
            java.lang.String r13 = r0.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r14 = r1.f172a
            boolean r15 = r14.containsKey(r13)
            if (r15 == 0) goto L_0x00f5
            java.lang.Object r0 = r14.get(r13)
            android.graphics.drawable.Drawable$ConstantState r0 = (android.graphics.drawable.Drawable.ConstantState) r0
            if (r0 != 0) goto L_0x00ec
            r0 = 0
            goto L_0x0128
        L_0x00ec:
            android.content.res.Resources r13 = r11.getResources()
            android.graphics.drawable.Drawable r0 = r0.newDrawable(r13)
            goto L_0x0128
        L_0x00f5:
            android.content.pm.PackageManager r15 = r11.getPackageManager()
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r5 = r15.getActivityInfo(r0, r5)     // Catch:{ NameNotFoundException -> 0x0116 }
            int r10 = r5.getIconResource()
            if (r10 != 0) goto L_0x0106
            goto L_0x011b
        L_0x0106:
            java.lang.String r8 = r0.getPackageName()
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo
            android.graphics.drawable.Drawable r5 = r15.getDrawable(r8, r10, r5)
            if (r5 != 0) goto L_0x011c
            r0.flattenToShortString()
            goto L_0x011b
        L_0x0116:
            r0 = move-exception
            r5 = r0
            r5.toString()
        L_0x011b:
            r5 = 0
        L_0x011c:
            if (r5 != 0) goto L_0x0120
            r0 = 0
            goto L_0x0124
        L_0x0120:
            android.graphics.drawable.Drawable$ConstantState r0 = r5.getConstantState()
        L_0x0124:
            r14.put(r13, r0)
            r0 = r5
        L_0x0128:
            if (r0 == 0) goto L_0x012b
            goto L_0x0133
        L_0x012b:
            android.content.pm.PackageManager r0 = r11.getPackageManager()
            android.graphics.drawable.Drawable r0 = r0.getDefaultActivityIcon()
        L_0x0133:
            r12.setImageDrawable(r0)
            if (r0 != 0) goto L_0x013d
            r0 = 4
            r12.setVisibility(r0)
            goto L_0x0146
        L_0x013d:
            r12.setVisibility(r4)
            r0.setVisible(r4, r4)
            r0.setVisible(r9, r4)
        L_0x0146:
            android.widget.ImageView r0 = r3.b
            if (r0 == 0) goto L_0x016d
            int r5 = r1.l
            r8 = -1
            if (r5 != r8) goto L_0x0151
            r5 = 0
            goto L_0x0159
        L_0x0151:
            java.lang.String r2 = r2.getString(r5)
            android.graphics.drawable.Drawable r5 = r1.g(r2)
        L_0x0159:
            r0.setImageDrawable(r5)
            if (r5 != 0) goto L_0x0164
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x016d
        L_0x0164:
            r0.setVisibility(r4)
            r5.setVisible(r4, r4)
            r5.setVisible(r9, r4)
        L_0x016d:
            int r0 = r1.g
            android.widget.ImageView r2 = r3.c
            r3 = 2
            if (r0 == r3) goto L_0x0181
            if (r0 != r9) goto L_0x017b
            r0 = r6 & 1
            if (r0 == 0) goto L_0x017b
            goto L_0x0181
        L_0x017b:
            r3 = 8
            r2.setVisibility(r3)
            goto L_0x018e
        L_0x0181:
            r2.setVisibility(r4)
            java.lang.CharSequence r0 = r7.getText()
            r2.setTag(r0)
            r2.setOnClickListener(r1)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ey.b(android.view.View, android.database.Cursor):void");
    }

    public final void c(Cursor cursor) {
        try {
            super.c(cursor);
            if (cursor != null) {
                this.h = cursor.getColumnIndex("suggest_text_1");
                this.i = cursor.getColumnIndex("suggest_text_2");
                this.j = cursor.getColumnIndex("suggest_text_2_url");
                this.k = cursor.getColumnIndex("suggest_icon_1");
                this.l = cursor.getColumnIndex("suggest_icon_2");
                this.m = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    public final String d(Cursor cursor) {
        String i2;
        String i3;
        if (cursor == null) {
            return null;
        }
        String i4 = i(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (i4 != null) {
            return i4;
        }
        SearchableInfo searchableInfo = this.a;
        if (searchableInfo.shouldRewriteQueryFromData() && (i3 = i(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return i3;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (i2 = i(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return i2;
    }

    public final View e(ViewGroup viewGroup) {
        View inflate = this.a.inflate(this.d, viewGroup, false);
        inflate.setTag(new a(inflate));
        ((ImageView) inflate.findViewById(Gr.edit_query)).setImageResource(this.f);
        return inflate;
    }

    public final Drawable f(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.b.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:33|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:45|46|47|48|49|50) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|40|41|42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r2);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00b0 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x00b0=Splitter:B:48:0x00b0, B:42:0x00a6=Splitter:B:42:0x00a6, B:30:0x007c=Splitter:B:30:0x007c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable g(java.lang.String r9) {
        /*
            r8 = this;
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r0 = r8.f172a
            android.content.Context r1 = r8.b
            java.lang.String r2 = "android.resource://"
            r3 = 0
            if (r9 == 0) goto L_0x00d6
            boolean r4 = r9.isEmpty()
            if (r4 != 0) goto L_0x00d6
            java.lang.String r4 = "0"
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x0019
            goto L_0x00d6
        L_0x0019:
            int r4 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            r5.<init>(r2)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            r5.append(r2)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            java.lang.String r2 = "/"
            r5.append(r2)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            r5.append(r4)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            java.lang.String r2 = r5.toString()     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            java.lang.Object r5 = r0.get(r2)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            android.graphics.drawable.Drawable$ConstantState r5 = (android.graphics.drawable.Drawable.ConstantState) r5     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            if (r5 != 0) goto L_0x003f
            r5 = r3
            goto L_0x0043
        L_0x003f:
            android.graphics.drawable.Drawable r5 = r5.newDrawable()     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
        L_0x0043:
            if (r5 == 0) goto L_0x0046
            return r5
        L_0x0046:
            java.lang.Object r5 = defpackage.d7.a     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            android.graphics.drawable.Drawable r4 = defpackage.d7.a.b(r1, r4)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            if (r4 == 0) goto L_0x0055
            android.graphics.drawable.Drawable$ConstantState r5 = r4.getConstantState()     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
            r0.put(r2, r5)     // Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0056 }
        L_0x0055:
            return r4
        L_0x0056:
            return r3
        L_0x0057:
            java.lang.Object r2 = r0.get(r9)
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2
            if (r2 != 0) goto L_0x0061
            r2 = r3
            goto L_0x0065
        L_0x0061:
            android.graphics.drawable.Drawable r2 = r2.newDrawable()
        L_0x0065:
            if (r2 == 0) goto L_0x0068
            return r2
        L_0x0068:
            android.net.Uri r2 = android.net.Uri.parse(r9)
            java.lang.String r4 = "Failed to open "
            java.lang.String r5 = "Resource does not exist: "
            java.lang.String r6 = r2.getScheme()     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.String r7 = "android.resource"
            boolean r6 = r7.equals(r6)     // Catch:{ FileNotFoundException -> 0x00c6 }
            if (r6 == 0) goto L_0x0094
            android.graphics.drawable.Drawable r1 = r8.f(r2)     // Catch:{ NotFoundException -> 0x0082 }
            r3 = r1
            goto L_0x00cd
        L_0x0082:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c6 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00c6 }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x00c6 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00c6 }
            throw r1     // Catch:{ FileNotFoundException -> 0x00c6 }
        L_0x0094:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.io.InputStream r1 = r1.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x00c6 }
            if (r1 == 0) goto L_0x00b4
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r1, r3)     // Catch:{ all -> 0x00ab }
            r1.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00a9
        L_0x00a6:
            r2.toString()     // Catch:{ FileNotFoundException -> 0x00c6 }
        L_0x00a9:
            r3 = r4
            goto L_0x00cd
        L_0x00ab:
            r4 = move-exception
            r1.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b3
        L_0x00b0:
            r2.toString()     // Catch:{ FileNotFoundException -> 0x00c6 }
        L_0x00b3:
            throw r4     // Catch:{ FileNotFoundException -> 0x00c6 }
        L_0x00b4:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c6 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00c6 }
            r5.append(r2)     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.String r4 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00c6 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00c6 }
            throw r1     // Catch:{ FileNotFoundException -> 0x00c6 }
        L_0x00c6:
            r1 = move-exception
            java.util.Objects.toString(r2)
            r1.getMessage()
        L_0x00cd:
            if (r3 == 0) goto L_0x00d6
            android.graphics.drawable.Drawable$ConstantState r1 = r3.getConstantState()
            r0.put(r9, r1)
        L_0x00d6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ey.g(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e) {
            View inflate = this.a.inflate(this.e, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).f173a.setText(e.toString());
            }
            return inflate;
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e) {
            View e2 = e(viewGroup);
            ((a) e2.getTag()).f173a.setText(e.toString());
            return e2;
        }
    }

    public final Cursor h(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        fragment.appendQueryParameter("limit", String.valueOf(50));
        Uri build = fragment.build();
        return this.b.getContentResolver().query(build, (String[]) null, suggestSelection, strArr, (String) null);
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.f194a;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f194a;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f171a.h((CharSequence) tag);
        }
    }
}
