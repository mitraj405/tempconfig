package defpackage;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import kotlin.coroutines.Continuation;

@SuppressLint({"NewApi"})
/* renamed from: pA  reason: default package */
/* compiled from: TopicsManagerImplCommon.kt */
public class pA extends v3 {
    public final TopicsManager a;

    @C1128g8(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {22}, m = "getTopics$suspendImpl")
    /* renamed from: pA$a */
    /* compiled from: TopicsManagerImplCommon.kt */
    public static final class a extends C1148h7 {
        public /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        public pA f3169a;
        public final /* synthetic */ pA b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(pA pAVar, Continuation<? super a> continuation) {
            super(continuation);
            this.b = pAVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return pA.e(this.b, (C0272me) null, this);
        }
    }

    public pA(TopicsManager topicsManager) {
        this.a = topicsManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[LOOP:0: B:18:0x007a->B:20:0x0080, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object e(defpackage.pA r7, defpackage.C0272me r8, kotlin.coroutines.Continuation<? super defpackage.C0280ne> r9) {
        /*
            boolean r0 = r9 instanceof defpackage.pA.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            pA$a r0 = (defpackage.pA.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            pA$a r0 = new pA$a
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            pA r7 = r0.f3169a
            defpackage.r1.R(r9)
            goto L_0x0063
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0031:
            defpackage.r1.R(r9)
            android.adservices.topics.GetTopicsRequest r8 = r7.d(r8)
            r0.f3169a = r7
            r0.c = r3
            kotlinx.coroutines.c r9 = new kotlinx.coroutines.c
            kotlin.coroutines.Continuation r2 = defpackage.r1.B(r0)
            r9.<init>(r3, r2)
            r9.s()
            F1 r2 = new F1
            r3 = 2
            r2.<init>(r3)
            j7 r3 = defpackage.C1354qp.h(r9)
            android.adservices.topics.TopicsManager r4 = r7.a
            r4.getTopics(r8, r2, r3)
            java.lang.Object r9 = r9.r()
            if (r9 != r1) goto L_0x0060
            defpackage.C1354qp.j0(r0)
        L_0x0060:
            if (r9 != r1) goto L_0x0063
            return r1
        L_0x0063:
            android.adservices.topics.GetTopicsResponse r9 = (android.adservices.topics.GetTopicsResponse) r9
            r7.getClass()
            java.lang.String r7 = "response"
            defpackage.C1177ig.f(r9, r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r8 = r9.getTopics()
            java.util.Iterator r8 = r8.iterator()
        L_0x007a:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r8.next()
            android.adservices.topics.Topic r9 = (android.adservices.topics.Topic) r9
            lA r6 = new lA
            long r1 = r9.getTaxonomyVersion()
            long r3 = r9.getModelVersion()
            int r5 = r9.getTopicId()
            r0 = r6
            r0.<init>(r1, r3, r5)
            r7.add(r6)
            goto L_0x007a
        L_0x009c:
            ne r8 = new ne
            r8.<init>(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pA.e(pA, me, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object b(C0272me meVar, Continuation<? super C0280ne> continuation) {
        return e(this, meVar, continuation);
    }

    public GetTopicsRequest d(C0272me meVar) {
        C1177ig.f(meVar, "request");
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(meVar.a()).build();
        C1177ig.e(build, "Builder()\n            .s…ame)\n            .build()");
        return build;
    }
}
