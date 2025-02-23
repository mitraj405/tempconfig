package defpackage;

import android.view.View;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* renamed from: cw  reason: default package and case insensitive filesystem */
/* compiled from: SequenceBuilder.kt */
public final class C1057cw<T> extends C1078dw<T> implements Iterator<T>, Continuation<Unit> {
    public T a;

    /* renamed from: a  reason: collision with other field name */
    public Iterator<? extends T> f5430a;

    /* renamed from: a  reason: collision with other field name */
    public Continuation<? super Unit> f5431a;
    public int c;

    public final void a(View view, Continuation continuation) {
        this.a = view;
        this.c = 3;
        this.f5431a = continuation;
        C1177ig.f(continuation, "frame");
    }

    public final Object b(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.a;
        }
        this.f5430a = it;
        this.c = 2;
        this.f5431a = continuation;
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        C1177ig.f(continuation, "frame");
        return v7Var;
    }

    public final RuntimeException c() {
        int i = this.c;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.c);
    }

    public final CoroutineContext getContext() {
        return C1440va.a;
    }

    public final boolean hasNext() {
        while (true) {
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.f5430a;
                    C1177ig.c(it);
                    if (it.hasNext()) {
                        this.c = 2;
                        return true;
                    }
                    this.f5430a = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw c();
                }
            }
            this.c = 5;
            Continuation<? super Unit> continuation = this.f5431a;
            C1177ig.c(continuation);
            this.f5431a = null;
            continuation.resumeWith(Unit.a);
        }
    }

    public final T next() {
        int i = this.c;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i == 2) {
            this.c = 1;
            Iterator<? extends T> it = this.f5430a;
            C1177ig.c(it);
            return it.next();
        } else if (i == 3) {
            this.c = 0;
            T t = this.a;
            this.a = null;
            return t;
        } else {
            throw c();
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void resumeWith(Object obj) {
        r1.R(obj);
        this.c = 4;
    }
}
