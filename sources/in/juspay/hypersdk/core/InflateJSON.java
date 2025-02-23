package in.juspay.hypersdk.core;

import in.juspay.hypersdk.core.InflateView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class InflateJSON extends InflateView {
    private final String ARGS = "a";
    private final String BODY = "bd";
    private final String CATCH = "ct";
    private final String COMMAND = "c";
    private final String CONDITION = "cnd";
    private final String CONDITIONS = "cnds";
    private final String EXPLICIT_TYPE = "et";
    private final String FUNCTION_STACK_NAME = "fnstk";
    private final String GLOBAL = "g";
    private final String IF = "if";
    private final String INVOKE_ON = "io";
    private final String JSON_ARRAY = "jsa";
    private final String JSON_OBJECT = "jso";
    private final String LOCAL = "lcl";
    private final String METHOD_NAME = "mn";
    private final String NEW = "n";
    private final String RETURN_TO = "rt";
    private final String RETURN_TYPE = "rty";
    private final String RUNIN_UI_JSON = "rj";
    private final String STATE = "st";
    private final String STATIC = "stc";
    private final String TO = "to";
    private final String TYPE = "t";
    private final String VALUE = "v";
    private final String VALUE_GET = "vg";
    private final String VALUE_SET = "vs";
    private final String VOID = "vo";
    private final String WHILE = "w";
    private final HashMap<InflateView.Cmd, Constructor<?>> constructorCache = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);
    private final HashMap<String, HashMap<String, Object>> localState = new HashMap<>();

    public class Arguments {
        /* access modifiers changed from: private */
        public final Object[] args;
        /* access modifiers changed from: private */
        public Class<?>[] classTypes;

        public Arguments(JSONArray jSONArray, Object obj, LinkedList<String> linkedList) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.classTypes = new Class[0];
            }
            this.args = new Object[jSONArray.length()];
            this.classTypes = new Class[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                this.args[i] = InflateJSON.this.getValue(jSONObject, obj, linkedList);
                this.classTypes[i] = (Class) InflateJSON.this.getClassTypeFromObject(this.args[i], jSONObject.optString("et"));
            }
        }
    }

    public InflateJSON(DynamicUI dynamicUI) {
        super(dynamicUI);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006c A[EDGE_INSN: B:40:0x006c->B:32:0x006c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object createNewInstance(java.lang.Class<?> r9, java.lang.Object[] r10, java.lang.Class<?>[] r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L_0x0072
            int r0 = r10.length
            if (r0 != 0) goto L_0x0007
            goto L_0x0072
        L_0x0007:
            in.juspay.hypersdk.core.InflateView$Cmd r0 = new in.juspay.hypersdk.core.InflateView$Cmd
            java.lang.String r1 = "new"
            r0.<init>(r9, r1, r11)
            java.util.HashMap<in.juspay.hypersdk.core.InflateView$Cmd, java.lang.reflect.Constructor<?>> r1 = r8.constructorCache
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L_0x0026
            java.util.HashMap<in.juspay.hypersdk.core.InflateView$Cmd, java.lang.reflect.Constructor<?>> r9 = r8.constructorCache
            java.lang.Object r9 = r9.get(r0)
            java.lang.reflect.Constructor r9 = (java.lang.reflect.Constructor) r9
            java.util.Objects.requireNonNull(r9)
            java.lang.Object r9 = r9.newInstance(r10)
            return r9
        L_0x0026:
            r1 = 0
            java.lang.reflect.Constructor r2 = r9.getConstructor(r11)     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.Object r1 = r2.newInstance(r10)     // Catch:{ NoSuchMethodException -> 0x0031 }
            goto L_0x006c
        L_0x0030:
            r2 = r1
        L_0x0031:
            java.lang.reflect.Constructor[] r9 = r9.getConstructors()
            r3 = 0
            if (r11 != 0) goto L_0x004c
            int r11 = r10.length
            java.lang.Class[] r11 = new java.lang.Class[r11]
            r4 = r3
        L_0x003c:
            int r5 = r10.length
            if (r4 >= r5) goto L_0x004c
            r5 = r10[r4]
            if (r5 == 0) goto L_0x0049
            java.lang.Class r5 = r5.getClass()
            r11[r4] = r5
        L_0x0049:
            int r4 = r4 + 1
            goto L_0x003c
        L_0x004c:
            int r4 = r9.length
        L_0x004d:
            if (r3 >= r4) goto L_0x006c
            r5 = r9[r3]
            java.lang.Class[] r6 = r5.getParameterTypes()
            int r6 = r6.length
            int r7 = r10.length
            if (r6 != r7) goto L_0x0069
            java.lang.Class[] r6 = r5.getParameterTypes()
            boolean r6 = r8.matchTypes(r6, r11)
            if (r6 == 0) goto L_0x0069
            java.lang.Object r1 = r5.newInstance(r10)
            r2 = r5
            goto L_0x006c
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x004d
        L_0x006c:
            java.util.HashMap<in.juspay.hypersdk.core.InflateView$Cmd, java.lang.reflect.Constructor<?>> r9 = r8.constructorCache
            r9.put(r0, r2)
            return r1
        L_0x0072:
            java.lang.Object r9 = r9.newInstance()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateJSON.createNewInstance(java.lang.Class, java.lang.Object[], java.lang.Class[]):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public <Any> Any getClassTypeFromObject(Object obj, String str) {
        if (str.equals("")) {
            return obj.getClass();
        }
        Any createPrimitiveClass = createPrimitiveClass(str);
        if (createPrimitiveClass == null) {
            return Class.forName(str);
        }
        return createPrimitiveClass;
    }

    private Field getField(Class<?> cls, String str) {
        return cls.getDeclaredField(str);
    }

    private Object getLocalStateValue(String str, LinkedList<String> linkedList) {
        Iterator<String> descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            String next = descendingIterator.next();
            if (this.localState.containsKey(next)) {
                HashMap hashMap = this.localState.get(next);
                Objects.requireNonNull(hashMap);
                if (hashMap.containsKey(str)) {
                    HashMap hashMap2 = this.localState.get(next);
                    Objects.requireNonNull(hashMap2);
                    return hashMap2.get(str);
                }
            } else {
                throw new Exception(C0709Uj.i("local state not found for function ", next));
            }
        }
        return null;
    }

    private Object getStateValue(String str) {
        return this.state.get(str);
    }

    private Object invokeFunction(Method method, Object obj, Object[] objArr) {
        if (objArr == null) {
            return method.invoke(obj, new Object[0]);
        }
        return method.invoke(obj, objArr);
    }

    private void saveOutput(Object obj, JSONObject jSONObject, LinkedList<String> linkedList) {
        if (jSONObject != null) {
            String string = jSONObject.getString("to");
            String string2 = jSONObject.getString("v");
            if (string.equals("g")) {
                getDUI().setGlobalState(string2, obj);
            } else if (string.equals("lcl")) {
                setLocalStateValue(string2, obj, linkedList);
            } else {
                this.state.put(string2, obj);
            }
        }
    }

    private void setLocalStateValue(String str, Object obj, LinkedList<String> linkedList) {
        HashMap hashMap = this.localState.get(linkedList.getLast());
        Objects.requireNonNull(hashMap);
        hashMap.put(str, obj);
    }

    public Object callFunction(String str, Object obj, Object[] objArr) {
        return callFunction(str, obj, objArr, (LinkedList<String>) null);
    }

    public Method findMethodInClassWithArgs(Class<?> cls, String str, Class<?>[] clsArr) {
        return findMethodWithCmd(new InflateView.Cmd(cls, str, clsArr));
    }

    public Class<?> getClassNameJSON(JSONObject jSONObject, Object obj) {
        String string = jSONObject.getString("t");
        String optString = jSONObject.optString("et");
        if (string.equals("stc")) {
            optString = jSONObject.getString("v");
        }
        if (!optString.equals("")) {
            return getClassName(optString);
        }
        if (obj != null) {
            return obj.getClass();
        }
        throw new Exception("toRunOn is null");
    }

    public Object getValue(JSONObject jSONObject, Object obj, LinkedList<String> linkedList) {
        String string = jSONObject.getString("t");
        if (string.equals("jsa")) {
            return jSONObject.getJSONArray("v");
        }
        if (string.equals("jso")) {
            return jSONObject.getJSONObject("v");
        }
        return getValueNew(string, jSONObject.getString("v"), obj, linkedList);
    }

    public <Any> Any getValueNew(String str, String str2, Object obj, LinkedList<String> linkedList) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case 103:
                if (str.equals("g")) {
                    c = 0;
                    break;
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    c = 1;
                    break;
                }
                break;
            case 98855:
                if (str.equals("ctx")) {
                    c = 2;
                    break;
                }
                break;
            case 106965:
                if (str.equals("lcl")) {
                    c = 3;
                    break;
                }
                break;
            case 114210:
                if (str.equals("stc")) {
                    c = 4;
                    break;
                }
                break;
            case 3237035:
                if (str.equals("infl")) {
                    c = 5;
                    break;
                }
                break;
            case 3559070:
                if (str.equals("this")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return getDUI().getGlobalState(str2);
            case 1:
                return getStateValue(str2);
            case 2:
                Any activity = this.dynamicUI.getActivity();
                if (activity == null) {
                    return this.dynamicUI.getAppContext();
                }
                return activity;
            case 3:
                return getLocalStateValue(str2, linkedList);
            case 4:
                return null;
            case 5:
                return this;
            case 6:
                return obj;
            default:
                return getValueNew(str, str2);
        }
    }

    public Object parseAndRunPipeJSON(Object obj, JSONArray jSONArray, boolean z, LinkedList<String> linkedList) {
        Object obj2 = null;
        int i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Object runCommandJSON = runCommandJSON(jSONObject, obj, z, linkedList);
            if (jSONObject.has("rt")) {
                saveOutput(runCommandJSON, jSONObject.getJSONObject("rt"), linkedList);
            }
            i++;
            obj2 = runCommandJSON;
        }
        return obj2;
    }

    public void parseKeys(String str, JSONObject jSONObject, Object obj, boolean z) {
        try {
            if (str.equals("rj")) {
                runJSON(obj, jSONObject.getJSONArray("rj"), z, (LinkedList<String>) null);
                return;
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("WARNING", "Error in parsing new infl " + e.getMessage());
        }
        super.parseKeys(str, jSONObject, obj, z);
    }

    public Object runCommandJSON(JSONObject jSONObject, Object obj, boolean z, LinkedList<String> linkedList) {
        Arguments arguments;
        Object obj2;
        Class<?> cls;
        String optString = jSONObject.optString("t", "c");
        JSONObject optJSONObject = jSONObject.optJSONObject("io");
        String optString2 = jSONObject.optString("mn", "");
        if (optJSONObject != null) {
            obj2 = getValue(optJSONObject, obj, linkedList);
            cls = getClassNameJSON(optJSONObject, obj2);
            arguments = new Arguments(jSONObject.optJSONArray("a"), obj, linkedList);
        } else {
            cls = null;
            obj2 = null;
            arguments = null;
        }
        optString.getClass();
        char c = 65535;
        switch (optString.hashCode()) {
            case 119:
                if (optString.equals("w")) {
                    c = 0;
                    break;
                }
                break;
            case 3357:
                if (optString.equals("if")) {
                    c = 1;
                    break;
                }
                break;
            case 3761:
                if (optString.equals("vg")) {
                    c = 2;
                    break;
                }
                break;
            case 3773:
                if (optString.equals("vs")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                JSONArray jSONArray = jSONObject.getJSONArray("cnd");
                JSONArray jSONArray2 = jSONObject.getJSONArray("bd");
                while (true) {
                    Object runJSON = runJSON(obj, jSONArray, z, linkedList);
                    if ((runJSON instanceof Boolean) && ((Boolean) runJSON).equals(Boolean.TRUE)) {
                        runJSON(obj, jSONArray2, z, linkedList);
                    }
                }
            case 1:
                JSONArray jSONArray3 = jSONObject.getJSONArray("cnds");
                for (int i = 0; i < jSONArray3.length(); i++) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                    Object runJSON2 = runJSON(obj, jSONObject2.getJSONArray("cnd"), z, linkedList);
                    if ((runJSON2 instanceof Boolean) && ((Boolean) runJSON2).equals(Boolean.TRUE)) {
                        return runJSON(obj, jSONObject2.getJSONArray("bd"), z, linkedList);
                    }
                }
                break;
            case 2:
                Objects.requireNonNull(cls);
                return getField(cls, optString2).get(obj2);
            case 3:
                Objects.requireNonNull(cls);
                Field field = getField(cls, optString2);
                Objects.requireNonNull(arguments);
                field.set(obj2, arguments.args[0]);
                return null;
            default:
                if (optString2.equals("n")) {
                    Objects.requireNonNull(cls);
                    Objects.requireNonNull(arguments);
                    return createNewInstance(cls, arguments.args, arguments.classTypes);
                }
                Objects.requireNonNull(arguments);
                Method findMethodInClassWithArgs = findMethodInClassWithArgs(cls, optString2, arguments.classTypes);
                if (findMethodInClassWithArgs != null) {
                    return invokeFunction(findMethodInClassWithArgs, obj2, arguments.args);
                }
                throw new Exception("Method not found");
        }
        return null;
    }

    public Object runJSON(Object obj, JSONArray jSONArray, boolean z, LinkedList<String> linkedList) {
        Object obj2 = null;
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                obj2 = parseAndRunPipeJSON(obj, jSONArray.getJSONArray(i), z, linkedList);
                i++;
            } catch (Exception e) {
                DuiLogger logger = this.dynamicUI.getLogger();
                logger.e("WARNING", "Error in parsing new infl " + e.getMessage());
            }
        }
        return obj2;
    }

    public Object runProps(JSONObject jSONObject, String str, Object obj) {
        String str2;
        String str3;
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("props");
        Iterator<String> keys = jSONObject3.keys();
        while (keys.hasNext()) {
            parseKeys(keys.next(), jSONObject3, obj, false);
        }
        Object obj2 = getState().get("rt");
        String string = jSONObject2.getString("rty");
        if (string.equals("vo")) {
            return null;
        }
        Class<?> cls = Class.forName(string);
        if (cls.isInstance(obj2)) {
            return obj2;
        }
        DuiLogger logger = getDUI().getLogger();
        StringBuilder b = C0437ME.b("return type mismatch for method ", str, " expected ", string, " got ");
        if (obj2 != null) {
            str2 = obj2.getClass().getName();
        } else {
            str2 = "result isnull";
        }
        b.append(str2);
        logger.e("WARNING", b.toString());
        Object runJSON = runJSON(obj, jSONObject2.getJSONArray("ct"), false, (LinkedList<String>) null);
        if (cls.isInstance(runJSON)) {
            return runJSON;
        }
        DuiLogger logger2 = getDUI().getLogger();
        StringBuilder b2 = C0437ME.b("return type mismatch for method on default", str, " expected ", string, " got ");
        if (runJSON == null) {
            str3 = "null";
        } else {
            str3 = runJSON.getClass().getName();
        }
        b2.append(str3);
        logger2.e("WARNING", b2.toString());
        return null;
    }

    public Object callFunction(String str, Object obj, Object[] objArr, LinkedList<String> linkedList) {
        HashMap hashMap = new HashMap();
        StringBuilder J = xx.J(str);
        J.append(this.idCounter.getAndIncrement());
        String sb = J.toString();
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        hashMap.put("fnstk", linkedList);
        this.localState.put(sb, hashMap);
        linkedList.add(sb);
        hashMap.put("a", objArr);
        Object runJSON = runJSON(obj, getDUI().getFunction(str), false, linkedList);
        linkedList.removeLast();
        this.localState.remove(sb);
        return runJSON;
    }
}
