package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;
    private volatile boolean unsubscribed;

    public CallArbiter(Call<T> call2, Subscriber<? super Response<T>> subscriber2) {
        super(0);
        this.call = call2;
        this.subscriber = subscriber2;
    }

    private void deliverResponse(Response<T> response2) {
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response2);
            }
            try {
                if (!isUnsubscribed()) {
                    this.subscriber.onCompleted();
                }
            } catch (Nn | Pn | Qn unused) {
                Cu.f3555a.b().getClass();
            } catch (Throwable th) {
                C1354qp.D0(th);
                Cu.f3555a.b().getClass();
            }
        } catch (Nn | Pn | Qn unused2) {
            Cu.f3555a.b().getClass();
        } catch (Throwable th2) {
            C1354qp.D0(th2);
            try {
                this.subscriber.onError(th2);
            } catch (Nn | Pn | Qn unused3) {
                Cu.f3555a.b().getClass();
            } catch (Throwable th3) {
                C1354qp.D0(th3);
                new C1190j6(th2, th3);
                Cu.f3555a.b().getClass();
            }
        }
    }

    public void emitError(Throwable th) {
        set(3);
        if (!isUnsubscribed()) {
            try {
                this.subscriber.onError(th);
            } catch (Nn | Pn | Qn unused) {
                Cu.f3555a.b().getClass();
            } catch (Throwable th2) {
                C1354qp.D0(th2);
                new C1190j6(th, th2);
                Cu.f3555a.b().getClass();
            }
        }
    }

    public void emitResponse(Response<T> response2) {
        while (true) {
            int i = get();
            if (i == 0) {
                this.response = response2;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i != 1) {
                if (i == 2 || i == 3) {
                    throw new AssertionError();
                }
                throw new IllegalStateException(lf.h("Unknown state: ", i));
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response2);
                return;
            }
        }
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void request(long j) {
        if (j != 0) {
            while (true) {
                int i = get();
                if (i != 0) {
                    if (i == 1) {
                        return;
                    }
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException(lf.h("Unknown state: ", i));
                        }
                        return;
                    } else if (compareAndSet(2, 3)) {
                        deliverResponse(this.response);
                        return;
                    }
                } else if (compareAndSet(0, 1)) {
                    return;
                }
            }
        }
    }

    public void unsubscribe() {
        this.unsubscribed = true;
        this.call.cancel();
    }
}
