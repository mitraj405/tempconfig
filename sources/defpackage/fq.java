package defpackage;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: fq  reason: default package */
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class fq implements ReadOnlyProperty<Context, DataStore<Preferences>> {
    public volatile C0150bq a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2944a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final String f2945a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<Context, List<W7<Preferences>>> f2946a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineScope f2947a;

    /* renamed from: a  reason: collision with other field name */
    public final wt<Preferences> f2948a;

    public fq(String str, wt<Preferences> wtVar, Function1<? super Context, ? extends List<? extends W7<Preferences>>> function1, CoroutineScope coroutineScope) {
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.f2945a = str;
        this.f2948a = wtVar;
        this.f2946a = function1;
        this.f2947a = coroutineScope;
    }

    public final C0150bq a(Object obj, KProperty kProperty) {
        C0150bq bqVar;
        Context context = (Context) obj;
        C1177ig.f(context, "thisRef");
        C1177ig.f(kProperty, "property");
        C0150bq bqVar2 = this.a;
        if (bqVar2 != null) {
            return bqVar2;
        }
        synchronized (this.f2944a) {
            if (this.a == null) {
                Context applicationContext = context.getApplicationContext();
                wt<Preferences> wtVar = this.f2948a;
                Function1<Context, List<W7<Preferences>>> function1 = this.f2946a;
                C1177ig.e(applicationContext, "applicationContext");
                List invoke = function1.invoke(applicationContext);
                CoroutineScope coroutineScope = this.f2947a;
                eq eqVar = new eq(applicationContext, this);
                C1177ig.f(invoke, "migrations");
                C1177ig.f(coroutineScope, "scope");
                C0171dq dqVar = new C0171dq(eqVar);
                if (wtVar == null) {
                    new C1354qp
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: CONSTRUCTOR  (r0v5 ? I:qp) =  call: qp.<init>():void type: CONSTRUCTOR in method: fq.a(java.lang.Object, kotlin.reflect.KProperty):bq, dex: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:260)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v5 ?
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 50 more
                        */
                    /*
                        this = this;
                        android.content.Context r6 = (android.content.Context) r6
                        java.lang.String r0 = "thisRef"
                        defpackage.C1177ig.f(r6, r0)
                        java.lang.String r0 = "property"
                        defpackage.C1177ig.f(r7, r0)
                        bq r7 = r5.a
                        if (r7 != 0) goto L_0x0068
                        java.lang.Object r7 = r5.f2944a
                        monitor-enter(r7)
                        bq r0 = r5.a     // Catch:{ all -> 0x0065 }
                        if (r0 != 0) goto L_0x005d
                        android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x0065 }
                        wt<androidx.datastore.preferences.core.Preferences> r0 = r5.f2948a     // Catch:{ all -> 0x0065 }
                        kotlin.jvm.functions.Function1<android.content.Context, java.util.List<W7<androidx.datastore.preferences.core.Preferences>>> r1 = r5.f2946a     // Catch:{ all -> 0x0065 }
                        java.lang.String r2 = "applicationContext"
                        defpackage.C1177ig.e(r6, r2)     // Catch:{ all -> 0x0065 }
                        java.lang.Object r1 = r1.invoke(r6)     // Catch:{ all -> 0x0065 }
                        java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0065 }
                        kotlinx.coroutines.CoroutineScope r2 = r5.f2947a     // Catch:{ all -> 0x0065 }
                        eq r3 = new eq     // Catch:{ all -> 0x0065 }
                        r3.<init>(r6, r5)     // Catch:{ all -> 0x0065 }
                        java.lang.String r6 = "migrations"
                        defpackage.C1177ig.f(r1, r6)     // Catch:{ all -> 0x0065 }
                        java.lang.String r6 = "scope"
                        defpackage.C1177ig.f(r2, r6)     // Catch:{ all -> 0x0065 }
                        dq r6 = new dq     // Catch:{ all -> 0x0065 }
                        r6.<init>(r3)     // Catch:{ all -> 0x0065 }
                        if (r0 != 0) goto L_0x0047
                        qp r0 = new qp     // Catch:{ all -> 0x0065 }
                        r0.<init>()     // Catch:{ all -> 0x0065 }
                    L_0x0047:
                        X7 r3 = new X7     // Catch:{ all -> 0x0065 }
                        r4 = 0
                        r3.<init>(r1, r4)     // Catch:{ all -> 0x0065 }
                        java.util.List r1 = defpackage.r1.E(r3)     // Catch:{ all -> 0x0065 }
                        Ww r3 = new Ww     // Catch:{ all -> 0x0065 }
                        r3.<init>(r6, r1, r0, r2)     // Catch:{ all -> 0x0065 }
                        bq r6 = new bq     // Catch:{ all -> 0x0065 }
                        r6.<init>(r3)     // Catch:{ all -> 0x0065 }
                        r5.a = r6     // Catch:{ all -> 0x0065 }
                    L_0x005d:
                        bq r6 = r5.a     // Catch:{ all -> 0x0065 }
                        defpackage.C1177ig.c(r6)     // Catch:{ all -> 0x0065 }
                        monitor-exit(r7)
                        r7 = r6
                        goto L_0x0068
                    L_0x0065:
                        r6 = move-exception
                        monitor-exit(r7)
                        throw r6
                    L_0x0068:
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: defpackage.fq.a(java.lang.Object, kotlin.reflect.KProperty):bq");
                }
            }
