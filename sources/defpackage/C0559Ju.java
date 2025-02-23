package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Ju  reason: default package and case insensitive filesystem */
/* compiled from: SafeCollector.kt */
public final class C0559Ju<T> extends C1148h7 implements FlowCollector<T> {
    public Continuation<? super Unit> a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineContext f3670a;

    /* renamed from: a  reason: collision with other field name */
    public final FlowCollector<T> f3671a;
    public CoroutineContext b;
    public final int c;

    /* renamed from: Ju$a */
    /* compiled from: SafeCollector.kt */
    public static final class a extends C0595Mh implements Function2<Integer, CoroutineContext.b, Integer> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            return Integer.valueOf(((Number) obj).intValue() + 1);
        }
    }

    public C0559Ju(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(Qm.a, C1440va.a);
        this.f3671a = flowCollector;
        this.f3670a = coroutineContext;
        this.c = ((Number) coroutineContext.C(0, a.a)).intValue();
    }

    public final Object b(Continuation<? super Unit> continuation, T t) {
        Comparable comparable;
        int i;
        String str;
        boolean z;
        T t2 = t;
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.b(Job.b.a);
        if (job == null || job.isActive()) {
            CoroutineContext coroutineContext = this.b;
            if (coroutineContext != context) {
                if (coroutineContext instanceof C1400t9) {
                    String str2 = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((C1400t9) coroutineContext).a + ", but then emission attempt of value '" + t2 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                    C1177ig.f(str2, "<this>");
                    List asList = Arrays.asList(new String[]{"\r\n", "\n", "\r"});
                    C1177ig.e(asList, "asList(this)");
                    List Y = C1097ew.Y(new C0537IA(new H8(str2, 0, 0, new C1292ny(asList, false)), new C1312oy(str2)));
                    Iterable iterable = Y;
                    ArrayList arrayList = new ArrayList();
                    for (Object next : iterable) {
                        if (true ^ C1268my.R0((String) next)) {
                            arrayList.add(next);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(C1418u5.W(arrayList));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        int length = str3.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                i2 = -1;
                                break;
                            } else if (!C1354qp.b0(str3.charAt(i2))) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 == -1) {
                            i2 = str3.length();
                        }
                        arrayList2.add(Integer.valueOf(i2));
                    }
                    Iterator it2 = arrayList2.iterator();
                    if (!it2.hasNext()) {
                        comparable = null;
                    } else {
                        comparable = (Comparable) it2.next();
                        while (it2.hasNext()) {
                            Comparable comparable2 = (Comparable) it2.next();
                            if (comparable.compareTo(comparable2) > 0) {
                                comparable = comparable2;
                            }
                        }
                    }
                    Integer num = (Integer) comparable;
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 0;
                    }
                    int size = (Y.size() * 0) + str2.length();
                    int y = r1.y(Y);
                    ArrayList arrayList3 = new ArrayList();
                    int i3 = 0;
                    for (Object next2 : iterable) {
                        int i4 = i3 + 1;
                        if (i3 >= 0) {
                            String str4 = (String) next2;
                            if ((i3 == 0 || i3 == y) && C1268my.R0(str4)) {
                                str = null;
                            } else {
                                C1177ig.f(str4, "<this>");
                                if (i >= 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    int length2 = str4.length();
                                    if (i <= length2) {
                                        length2 = i;
                                    }
                                    String substring = str4.substring(length2);
                                    C1177ig.e(substring, "this as java.lang.String).substring(startIndex)");
                                    str = (String) C1164hy.a.invoke(substring);
                                } else {
                                    throw new IllegalArgumentException(C1058d.y("Requested character count ", i, " is less than zero.").toString());
                                }
                            }
                            if (str != null) {
                                arrayList3.add(str);
                            }
                            i3 = i4;
                        } else {
                            throw new ArithmeticException("Index overflow has happened.");
                        }
                    }
                    StringBuilder sb = new StringBuilder(size);
                    C1472x5.Y(arrayList3, sb, "\n", "", "", -1, "...", (Function1) null);
                    String sb2 = sb.toString();
                    C1177ig.e(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
                    throw new IllegalStateException(sb2.toString());
                } else if (((Number) context.C(0, new Lu(this))).intValue() == this.c) {
                    this.b = context;
                } else {
                    throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f3670a + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
                }
            }
            this.a = continuation;
            C0694Td<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> td = Ku.a;
            FlowCollector<T> flowCollector = this.f3671a;
            C1177ig.d(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
            Object invoke = td.invoke(flowCollector, t2, this);
            if (!C1177ig.a(invoke, C1438v7.COROUTINE_SUSPENDED)) {
                this.a = null;
            }
            return invoke;
        }
        throw job.e();
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object b2 = b(continuation, t);
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            if (b2 == v7Var) {
                C1177ig.f(continuation, "frame");
            }
            if (b2 == v7Var) {
                return b2;
            }
            return Unit.a;
        } catch (Throwable th) {
            this.b = new C1400t9(continuation.getContext(), th);
            throw th;
        }
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.b;
        if (coroutineContext == null) {
            return C1440va.a;
        }
        return coroutineContext;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object invokeSuspend(Object obj) {
        Throwable a2 = C0698Tt.a(obj);
        if (a2 != null) {
            this.b = new C1400t9(getContext(), a2);
        }
        Continuation<? super Unit> continuation = this.a;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return C1438v7.COROUTINE_SUSPENDED;
    }

    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
