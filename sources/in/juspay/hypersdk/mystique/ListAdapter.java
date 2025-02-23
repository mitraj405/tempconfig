package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import in.juspay.hypersdk.core.DuiCallback;
import in.juspay.hypersdk.core.Renderer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListAdapter extends BaseAdapter {
    private BitmapCache bitmapCache = BitmapCache.getInstance();
    private LruCache<String, Integer> colorCache = new LruCache<>(20);
    private Context context;
    private float density;
    private LruCache<String, Drawable> drawableCache = new LruCache<>(50);
    /* access modifiers changed from: private */
    public final DuiCallback duiCallback;
    /* access modifiers changed from: private */
    public JSONArray holderData;
    private JSONObject itemView;
    private Renderer renderer;
    private JSONArray rowData;
    private LruCache<String, Typeface> typefaceCache = new LruCache<>(20);
    private LruCache<String, Integer> typefaceWeightCache = new LruCache<>(20);

    public class Holder {
        View[] views;

        public Holder(View view) {
            this.views = new View[ListAdapter.this.holderData.length()];
            for (int i = 0; i < ListAdapter.this.holderData.length(); i++) {
                try {
                    this.views[i] = view.findViewById(ListAdapter.this.holderData.getJSONObject(i).getInt(FacebookMediationAdapter.KEY_ID));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public ListAdapter(Context context2, Renderer renderer2, JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, DuiCallback duiCallback2) {
        this.renderer = renderer2;
        this.rowData = jSONArray2;
        this.itemView = jSONObject;
        this.holderData = jSONArray;
        this.duiCallback = duiCallback2;
        this.context = context2;
        this.density = context2.getResources().getDisplayMetrics().density;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyUpdate(android.view.View r7, org.json.JSONObject r8, org.json.JSONObject r9, int r10) {
        /*
            r6 = this;
            java.util.Iterator r0 = r8.keys()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0103
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = ""
            java.lang.String r3 = r6.getString(r8, r1, r2)
            java.lang.String r2 = r6.getString(r8, r1, r2)
            java.lang.String r2 = r6.getDefault(r1, r2)
            java.lang.String r2 = r6.getString(r9, r3, r2)
            int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0004 }
            r4 = 0
            switch(r3) {
                case -1550943582: goto L_0x0088;
                case -1351902487: goto L_0x007d;
                case -1332194002: goto L_0x0073;
                case -1003668786: goto L_0x0069;
                case -859610604: goto L_0x005f;
                case 3556653: goto L_0x0055;
                case 92909918: goto L_0x004a;
                case 94842723: goto L_0x0040;
                case 908612063: goto L_0x0036;
                case 1941332754: goto L_0x002c;
                default: goto L_0x002a;
            }     // Catch:{ Exception -> 0x0004 }
        L_0x002a:
            goto L_0x0092
        L_0x002c:
            java.lang.String r3 = "visibility"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 4
            goto L_0x0093
        L_0x0036:
            java.lang.String r3 = "packageIcon"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 7
            goto L_0x0093
        L_0x0040:
            java.lang.String r3 = "color"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 2
            goto L_0x0093
        L_0x004a:
            java.lang.String r3 = "alpha"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 8
            goto L_0x0093
        L_0x0055:
            java.lang.String r3 = "text"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 1
            goto L_0x0093
        L_0x005f:
            java.lang.String r3 = "imageUrl"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 3
            goto L_0x0093
        L_0x0069:
            java.lang.String r3 = "textSize"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 6
            goto L_0x0093
        L_0x0073:
            java.lang.String r3 = "background"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = r4
            goto L_0x0093
        L_0x007d:
            java.lang.String r3 = "onClick"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 9
            goto L_0x0093
        L_0x0088:
            java.lang.String r3 = "fontStyle"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0004 }
            if (r3 == 0) goto L_0x0092
            r3 = 5
            goto L_0x0093
        L_0x0092:
            r3 = -1
        L_0x0093:
            switch(r3) {
                case 0: goto L_0x00c6;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00b2;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00a8;
                case 7: goto L_0x00a3;
                case 8: goto L_0x009e;
                case 9: goto L_0x0099;
                default: goto L_0x0096;
            }
        L_0x0096:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00cb
        L_0x0099:
            r6.setClickListener(r7, r2, r10)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x009e:
            r6.setAlpha(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00a3:
            r6.setPackageIcon(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00a8:
            r6.setTextSize(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00ad:
            r6.setFontStyle(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00b2:
            r6.setVisibility(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00b7:
            r6.setImage(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00bc:
            r6.setTextColor(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00c1:
            r6.setText(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00c6:
            r6.setBackground(r7, r2)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x00cb:
            r3.<init>()     // Catch:{ Exception -> 0x00f1 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x00f1 }
            in.juspay.hypersdk.core.DuiCallback r5 = r6.duiCallback     // Catch:{ Exception -> 0x00f1 }
            in.juspay.hypersdk.core.InflateView r5 = r5.getInflateView()     // Catch:{ Exception -> 0x00f1 }
            if (r5 == 0) goto L_0x0004
            if (r2 == 0) goto L_0x0004
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x00f1 }
            in.juspay.hypersdk.core.InflateView r2 = r2.getInflateView()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r5 = "view"
            r2.putInState(r5, r7)     // Catch:{ Exception -> 0x00f1 }
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x00f1 }
            in.juspay.hypersdk.core.InflateView r2 = r2.getInflateView()     // Catch:{ Exception -> 0x00f1 }
            r2.parseKeys(r1, r3, r7, r4)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x0004
        L_0x00f1:
            r1 = move-exception
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x0004 }
            in.juspay.hypersdk.core.DuiLogger r2 = r2.getLogger()     // Catch:{ Exception -> 0x0004 }
            java.lang.String r3 = "Error while adding properties to list item"
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0004 }
            r2.e(r3, r1)     // Catch:{ Exception -> 0x0004 }
            goto L_0x0004
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.applyUpdate(android.view.View, org.json.JSONObject, org.json.JSONObject, int):void");
    }

    private View createView() {
        try {
            return this.renderer.createView(this.itemView);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getDefault(String str, String str2) {
        if (str.equals("onClick")) {
            return str2;
        }
        return null;
    }

    private String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    private void setAlpha(View view, String str) {
        view.setAlpha(Float.parseFloat(str));
    }

    private void setBackground(View view, String str) {
        if (str == null) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(0);
            } else {
                view.setBackgroundDrawable((Drawable) null);
            }
            view.setBackgroundDrawable((Drawable) null);
            return;
        }
        Integer num = this.colorCache.get(str);
        if (num == null) {
            num = Integer.valueOf(Color.parseColor(str));
            this.colorCache.put(str, num);
        }
        Drawable background = view.getBackground();
        if (background == null || ((background instanceof ColorDrawable) && ((ColorDrawable) background).getColor() != num.intValue())) {
            view.setBackgroundColor(num.intValue());
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(num.intValue());
        }
    }

    private void setClickListener(View view, final String str, final int i) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DuiCallback access$000 = ListAdapter.this.duiCallback;
                access$000.addJsToWebView("window.callUICallback('" + str + "'," + i + ");");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b A[Catch:{ Exception -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010e A[Catch:{ Exception -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0187 A[Catch:{ Exception -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0194 A[Catch:{ Exception -> 0x0198 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setFontStyle(android.view.View r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "assets/"
            java.lang.String r1 = ","
            java.lang.String r2 = "FONT_ERROR"
            java.lang.String r3 = "fonts/"
            boolean r4 = r13 instanceof android.widget.TextView
            if (r4 != 0) goto L_0x000d
            return
        L_0x000d:
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0198 }
            boolean r4 = r14.contains(r1)     // Catch:{ Exception -> 0x0198 }
            android.util.LruCache<java.lang.String, java.lang.Integer> r5 = r12.typefaceWeightCache     // Catch:{ Exception -> 0x0198 }
            java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0198 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0198 }
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r6 = r12.typefaceCache     // Catch:{ Exception -> 0x0198 }
            java.lang.Object r6 = r6.get(r14)     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6     // Catch:{ Exception -> 0x0198 }
            if (r6 == 0) goto L_0x0039
            android.graphics.Typeface r14 = r13.getTypeface()     // Catch:{ Exception -> 0x0198 }
            if (r14 == r6) goto L_0x0038
            if (r5 == 0) goto L_0x0035
            int r14 = r5.intValue()     // Catch:{ Exception -> 0x0198 }
            r13.setTypeface(r6, r14)     // Catch:{ Exception -> 0x0198 }
            goto L_0x0038
        L_0x0035:
            r13.setTypeface(r6)     // Catch:{ Exception -> 0x0198 }
        L_0x0038:
            return
        L_0x0039:
            if (r4 == 0) goto L_0x0164
            java.lang.String[] r1 = r14.split(r1)     // Catch:{ Exception -> 0x0198 }
            int r3 = r1.length     // Catch:{ Exception -> 0x0198 }
            r4 = 2
            if (r3 == r4) goto L_0x004f
            in.juspay.hypersdk.core.DuiCallback r13 = r12.duiCallback     // Catch:{ Exception -> 0x0198 }
            in.juspay.hypersdk.core.DuiLogger r13 = r13.getLogger()     // Catch:{ Exception -> 0x0198 }
            java.lang.String r14 = "incorrect font format recieved"
            r13.e(r2, r14)     // Catch:{ Exception -> 0x0198 }
            return
        L_0x004f:
            r3 = 0
            r7 = r1[r3]     // Catch:{ Exception -> 0x0198 }
            r8 = 1
            r1 = r1[r8]     // Catch:{ Exception -> 0x0198 }
            int r9 = r7.hashCode()     // Catch:{ Exception -> 0x0198 }
            r10 = 3433509(0x346425, float:4.811371E-39)
            r11 = -1
            if (r9 == r10) goto L_0x007e
            r10 = 108403163(0x67619db, float:4.6286453E-35)
            if (r9 == r10) goto L_0x0074
            r10 = 1544803905(0x5c13d641, float:1.66449585E17)
            if (r9 == r10) goto L_0x006a
            goto L_0x0088
        L_0x006a:
            java.lang.String r9 = "default"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x0198 }
            if (r7 == 0) goto L_0x0088
            r7 = r4
            goto L_0x0089
        L_0x0074:
            java.lang.String r9 = "resId"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x0198 }
            if (r7 == 0) goto L_0x0088
            r7 = r8
            goto L_0x0089
        L_0x007e:
            java.lang.String r9 = "path"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x0198 }
            if (r7 == 0) goto L_0x0088
            r7 = r3
            goto L_0x0089
        L_0x0088:
            r7 = r11
        L_0x0089:
            if (r7 == 0) goto L_0x010e
            if (r7 == r8) goto L_0x00f7
            if (r7 == r4) goto L_0x0091
            goto L_0x0180
        L_0x0091:
            int r0 = r1.hashCode()     // Catch:{ Exception -> 0x0198 }
            r7 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r7) goto L_0x00b9
            r7 = 1086463900(0x40c21f9c, float:6.0663586)
            if (r0 == r7) goto L_0x00af
            r7 = 1222907667(0x48e41713, float:467128.6)
            if (r0 == r7) goto L_0x00a5
            goto L_0x00c2
        L_0x00a5:
            java.lang.String r0 = "semiBold"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0198 }
            if (r0 == 0) goto L_0x00c2
            r11 = r4
            goto L_0x00c2
        L_0x00af:
            java.lang.String r0 = "regular"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0198 }
            if (r0 == 0) goto L_0x00c2
            r11 = r3
            goto L_0x00c2
        L_0x00b9:
            java.lang.String r0 = "bold"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0198 }
            if (r0 == 0) goto L_0x00c2
            r11 = r8
        L_0x00c2:
            java.lang.String r0 = "sans-serif"
            if (r11 == 0) goto L_0x00e7
            if (r11 == r8) goto L_0x00de
            if (r11 == r4) goto L_0x00cc
            goto L_0x0180
        L_0x00cc:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0198 }
            java.lang.String r1 = "sans-serif-medium"
            int r3 = r0.intValue()     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x0198 }
            r5 = r0
            r6 = r1
            goto L_0x0180
        L_0x00de:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0198 }
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x0198 }
            goto L_0x00ef
        L_0x00e7:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0198 }
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x0198 }
        L_0x00ef:
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r3)     // Catch:{ Exception -> 0x0198 }
            r6 = r0
            r5 = r1
            goto L_0x0180
        L_0x00f7:
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0198 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0198 }
            android.content.Context r1 = r12.context     // Catch:{ Exception -> 0x0198 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0198 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r0 = r1.getFont(r0)     // Catch:{ Exception -> 0x0198 }
            goto L_0x017f
        L_0x010e:
            boolean r4 = r1.contains(r0)     // Catch:{ Exception -> 0x0198 }
            if (r4 == 0) goto L_0x0125
            java.lang.String r3 = ""
            java.lang.String r0 = r1.replace(r0, r3)     // Catch:{ Exception -> 0x0198 }
            android.content.Context r1 = r12.context     // Catch:{ Exception -> 0x0198 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r1, r0)     // Catch:{ Exception -> 0x0198 }
            goto L_0x017f
        L_0x0125:
            java.lang.String r0 = "res/"
            boolean r0 = r1.contains(r0)     // Catch:{ Exception -> 0x0198 }
            if (r0 == 0) goto L_0x0180
            java.lang.String r0 = "/"
            java.lang.String[] r0 = r1.split(r0)     // Catch:{ Exception -> 0x0198 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0198 }
            int r1 = r1 - r8
            r0 = r0[r1]     // Catch:{ Exception -> 0x0198 }
            java.lang.String r1 = "\\."
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x0198 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0198 }
            android.content.Context r1 = r12.context     // Catch:{ Exception -> 0x0198 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0198 }
            java.lang.String r3 = "font"
            android.content.Context r4 = r12.context     // Catch:{ Exception -> 0x0198 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0198 }
            int r0 = r1.getIdentifier(r0, r3, r4)     // Catch:{ Exception -> 0x0198 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0198 }
            android.content.Context r1 = r12.context     // Catch:{ Exception -> 0x0198 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0198 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r6 = r1.getFont(r0)     // Catch:{ Exception -> 0x0198 }
            goto L_0x0180
        L_0x0164:
            android.content.Context r0 = r12.context     // Catch:{ Exception -> 0x0198 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x0198 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0198 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0198 }
            r1.append(r14)     // Catch:{ Exception -> 0x0198 }
            java.lang.String r3 = ".ttf"
            r1.append(r3)     // Catch:{ Exception -> 0x0198 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0198 }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r0, r1)     // Catch:{ Exception -> 0x0198 }
        L_0x017f:
            r6 = r0
        L_0x0180:
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r0 = r12.typefaceCache     // Catch:{ Exception -> 0x0198 }
            r0.put(r14, r6)     // Catch:{ Exception -> 0x0198 }
            if (r5 == 0) goto L_0x0194
            android.util.LruCache<java.lang.String, java.lang.Integer> r0 = r12.typefaceWeightCache     // Catch:{ Exception -> 0x0198 }
            r0.put(r14, r5)     // Catch:{ Exception -> 0x0198 }
            int r14 = r5.intValue()     // Catch:{ Exception -> 0x0198 }
            r13.setTypeface(r6, r14)     // Catch:{ Exception -> 0x0198 }
            goto L_0x01a6
        L_0x0194:
            r13.setTypeface(r6)     // Catch:{ Exception -> 0x0198 }
            goto L_0x01a6
        L_0x0198:
            r13 = move-exception
            in.juspay.hypersdk.core.DuiCallback r14 = r12.duiCallback
            in.juspay.hypersdk.core.DuiLogger r14 = r14.getLogger()
            java.lang.String r13 = r13.toString()
            r14.e(r2, r13)
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setFontStyle(android.view.View, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:62|63) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r7.duiCallback.getLogger().e("IMG_ERR", "Couldn't read from assets");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x015b */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f A[SYNTHETIC, Splitter:B:16:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[Catch:{ Exception -> 0x01cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[Catch:{ Exception -> 0x01cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012b A[Catch:{ Exception -> 0x01cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01be A[Catch:{ Exception -> 0x01cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setImage(android.view.View r17, java.lang.String r18) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = "/"
            java.lang.String r2 = "assets/"
            java.lang.String r8 = "IMG_ERR"
            boolean r3 = r0 instanceof android.widget.ImageView
            if (r3 != 0) goto L_0x000f
            return
        L_0x000f:
            r9 = r0
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            java.lang.String r0 = ","
            r3 = r18
            java.lang.String[] r0 = r3.split(r0)     // Catch:{ Exception -> 0x01cd }
            int r3 = r0.length     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = "drawable"
            r10 = 0
            r11 = 1
            if (r3 <= r11) goto L_0x0040
            r3 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x01cd }
            if (r3 != 0) goto L_0x0040
            android.content.Context r3 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x01cd }
            r5 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            android.content.Context r6 = r7.context     // Catch:{ Exception -> 0x01cd }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x01cd }
            int r3 = r3.getIdentifier(r5, r4, r6)     // Catch:{ Exception -> 0x01cd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01cd }
            goto L_0x0041
        L_0x0040:
            r3 = r10
        L_0x0041:
            r12 = 0
            r0 = r0[r12]     // Catch:{ Exception -> 0x01cd }
            java.lang.String r5 = "->"
            java.lang.String[] r0 = r0.split(r5)     // Catch:{ Exception -> 0x01cd }
            int r5 = r0.length     // Catch:{ Exception -> 0x01cd }
            java.lang.String r13 = ""
            if (r5 != r11) goto L_0x0082
            r0 = r0[r12]     // Catch:{ Exception -> 0x01cd }
            android.content.Context r1 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01cd }
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01cd }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x01cd }
            int r1 = r1.getIdentifier(r0, r4, r2)     // Catch:{ Exception -> 0x01cd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01cd }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r2 = r7.drawableCache     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x01cd }
            r10 = r2
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Exception -> 0x01cd }
            if (r10 != 0) goto L_0x01bc
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01cd }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01cd }
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r1)     // Catch:{ Exception -> 0x01cd }
        L_0x007e:
            r13 = r0
        L_0x007f:
            r10 = r1
            goto L_0x01bc
        L_0x0082:
            r4 = r0[r12]     // Catch:{ Exception -> 0x01cd }
            int r5 = r4.hashCode()     // Catch:{ Exception -> 0x01cd }
            r6 = 116079(0x1c56f, float:1.62661E-40)
            r14 = 2
            if (r5 == r6) goto L_0x00ad
            r6 = 3433509(0x346425, float:4.811371E-39)
            if (r5 == r6) goto L_0x00a3
            r6 = 108403163(0x67619db, float:4.6286453E-35)
            if (r5 == r6) goto L_0x0099
            goto L_0x00b7
        L_0x0099:
            java.lang.String r5 = "resId"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x01cd }
            if (r4 == 0) goto L_0x00b7
            r4 = r11
            goto L_0x00b8
        L_0x00a3:
            java.lang.String r5 = "path"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x01cd }
            if (r4 == 0) goto L_0x00b7
            r4 = r12
            goto L_0x00b8
        L_0x00ad:
            java.lang.String r5 = "url"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x01cd }
            if (r4 == 0) goto L_0x00b7
            r4 = r14
            goto L_0x00b8
        L_0x00b7:
            r4 = -1
        L_0x00b8:
            if (r4 == 0) goto L_0x012b
            if (r4 == r11) goto L_0x0102
            if (r4 == r14) goto L_0x00c0
            goto L_0x01bc
        L_0x00c0:
            r14 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            in.juspay.hypersdk.mystique.BitmapCache r0 = r7.bitmapCache     // Catch:{ Exception -> 0x01cd }
            android.graphics.Bitmap r0 = r0.get(r14)     // Catch:{ Exception -> 0x01cd }
            if (r0 == 0) goto L_0x00cf
            r9.setImageBitmap(r0)     // Catch:{ Exception -> 0x01cd }
            goto L_0x01bc
        L_0x00cf:
            if (r3 == 0) goto L_0x00e2
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01cd }
            int r1 = r3.intValue()     // Catch:{ Exception -> 0x01cd }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ Exception -> 0x01cd }
            r9.setImageDrawable(r0)     // Catch:{ Exception -> 0x01cd }
        L_0x00e2:
            in.juspay.hypersdk.mystique.DownloadImageTask r15 = new in.juspay.hypersdk.mystique.DownloadImageTask     // Catch:{ Exception -> 0x01cd }
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.Context r4 = r0.getApplicationContext()     // Catch:{ Exception -> 0x01cd }
            in.juspay.hypersdk.mystique.BitmapCache r5 = r7.bitmapCache     // Catch:{ Exception -> 0x01cd }
            in.juspay.hypersdk.core.DuiCallback r6 = r7.duiCallback     // Catch:{ Exception -> 0x01cd }
            r0 = r15
            r1 = r16
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x01cd }
            java.lang.String[] r0 = new java.lang.String[r11]     // Catch:{ Exception -> 0x01cd }
            r0[r12] = r14     // Catch:{ Exception -> 0x01cd }
            r15.execute(r0)     // Catch:{ Exception -> 0x01cd }
            goto L_0x01bc
        L_0x0102:
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r1 = r7.drawableCache     // Catch:{ Exception -> 0x01cd }
            r2 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x01cd }
            r10 = r1
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Exception -> 0x01cd }
            if (r10 != 0) goto L_0x01bc
            r1 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x01cd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01cd }
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01cd }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01cd }
            android.graphics.drawable.Drawable r10 = r2.getDrawable(r1)     // Catch:{ Exception -> 0x01cd }
            r13 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            goto L_0x01bc
        L_0x012b:
            r3 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            boolean r3 = r3.contains(r2)     // Catch:{ Exception -> 0x01cd }
            if (r3 == 0) goto L_0x0168
            r0 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r0.replace(r2, r13)     // Catch:{ Exception -> 0x01cd }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r1 = r7.drawableCache     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x01cd }
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1     // Catch:{ Exception -> 0x01cd }
            if (r1 != 0) goto L_0x007f
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x015b }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x015b }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x015b }
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ Exception -> 0x015b }
            android.graphics.drawable.Drawable r1 = android.graphics.drawable.Drawable.createFromStream(r2, r10)     // Catch:{ Exception -> 0x015b }
            r2.close()     // Catch:{ Exception -> 0x015a }
            goto L_0x007e
        L_0x015a:
            r13 = r0
        L_0x015b:
            in.juspay.hypersdk.core.DuiCallback r0 = r7.duiCallback     // Catch:{ Exception -> 0x01cd }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r2 = "Couldn't read from assets"
            r0.e(r8, r2)     // Catch:{ Exception -> 0x01cd }
            goto L_0x007f
        L_0x0168:
            r2 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            java.lang.String r3 = "res/"
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x01cd }
            if (r2 == 0) goto L_0x01bc
            r0 = r0[r11]     // Catch:{ Exception -> 0x01cd }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x01cd }
            int r2 = r0.length     // Catch:{ Exception -> 0x01cd }
            int r2 = r2 - r11
            r2 = r0[r2]     // Catch:{ Exception -> 0x01cd }
            java.lang.String r3 = "\\."
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ Exception -> 0x01cd }
            r2 = r2[r12]     // Catch:{ Exception -> 0x01cd }
            int r3 = r0.length     // Catch:{ Exception -> 0x01cd }
            int r3 = r3 - r11
            java.lang.Object[] r0 = java.util.Arrays.copyOfRange(r0, r11, r3)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = android.text.TextUtils.join(r1, r0)     // Catch:{ Exception -> 0x01cd }
            android.content.Context r1 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01cd }
            android.content.Context r3 = r7.context     // Catch:{ Exception -> 0x01cd }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x01cd }
            int r0 = r1.getIdentifier(r2, r0, r3)     // Catch:{ Exception -> 0x01cd }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01cd }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r1 = r7.drawableCache     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x01cd }
            r10 = r1
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Exception -> 0x01cd }
            if (r10 != 0) goto L_0x01bc
            android.content.Context r1 = r7.context     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01cd }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01cd }
            android.graphics.drawable.Drawable r10 = r1.getDrawable(r0)     // Catch:{ Exception -> 0x01cd }
            r13 = r2
        L_0x01bc:
            if (r10 == 0) goto L_0x01d8
            r9.setImageDrawable(r10)     // Catch:{ Exception -> 0x01cd }
            boolean r0 = r13.isEmpty()     // Catch:{ Exception -> 0x01cd }
            if (r0 != 0) goto L_0x01d8
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r0 = r7.drawableCache     // Catch:{ Exception -> 0x01cd }
            r0.put(r13, r10)     // Catch:{ Exception -> 0x01cd }
            goto L_0x01d8
        L_0x01cd:
            in.juspay.hypersdk.core.DuiCallback r0 = r7.duiCallback
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()
            java.lang.String r1 = "Unable to set drawable, input error"
            r0.e(r8, r1)
        L_0x01d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setImage(android.view.View, java.lang.String):void");
    }

    private void setPackageIcon(View view, String str) {
        PackageManager packageManager = this.context.getPackageManager();
        ((ImageView) view).setImageDrawable(packageManager.getApplicationInfo(str, 0).loadIcon(packageManager));
    }

    private void setText(View view, String str) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!textView.getText().equals(str)) {
                textView.setText(str);
            }
        }
    }

    private void setTextColor(View view, String str) {
        TextView textView;
        int intValue;
        if (view instanceof TextView) {
            if (str == null) {
                textView = (TextView) view;
                intValue = -16777216;
            } else {
                Integer num = this.colorCache.get(str);
                if (num == null) {
                    num = Integer.valueOf(Color.parseColor(str));
                    this.colorCache.put(str, num);
                }
                textView = (TextView) view;
                intValue = num.intValue();
            }
            textView.setTextColor(intValue);
        }
    }

    private void setTextSize(View view, String str) {
        if (view instanceof TextView) {
            float parseInt = ((float) Integer.parseInt(str)) * this.density;
            TextView textView = (TextView) view;
            if (textView.getTextSize() != parseInt) {
                textView.setTextSize(0, parseInt);
            }
        }
    }

    private void setVisibility(View view, String str) {
        int i;
        if (str.equalsIgnoreCase("gone")) {
            i = 8;
        } else if (str.equalsIgnoreCase("invisible")) {
            i = 4;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    private void updateView(View view, int i) {
        if (view.getTag() != null) {
            Holder holder = (Holder) view.getTag();
            int i2 = 0;
            while (true) {
                View[] viewArr = holder.views;
                if (i2 < viewArr.length) {
                    View view2 = viewArr[i2];
                    if (view2 != null) {
                        applyUpdate(view2, this.holderData.getJSONObject(i2), this.rowData.getJSONObject(i), i);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public int getCount() {
        return this.rowData.length();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createView();
            if (view == null) {
                return new View(this.context);
            }
            view.setTag(new Holder(view));
        }
        try {
            updateView(view, i);
        } catch (Exception unused) {
        }
        return view;
    }

    public void updateRowData(JSONArray jSONArray) {
        this.rowData = jSONArray;
    }
}
