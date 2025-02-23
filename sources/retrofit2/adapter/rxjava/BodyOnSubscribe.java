package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

final class BodyOnSubscribe<T> implements Observable.OnSubscribe<T> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    public static class BodySubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super R> subscriber;
        private boolean subscriberTerminated;

        public BodySubscriber(Subscriber<? super R> subscriber2) {
            super(subscriber2);
            this.subscriber = subscriber2;
        }

        public void onCompleted() {
            if (!this.subscriberTerminated) {
                this.subscriber.onCompleted();
            }
        }

        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.").initCause(th);
            Cu.f3555a.b().getClass();
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
            } catch (Nn | Pn | Qn unused) {
                Cu.f3555a.b().getClass();
            } catch (Throwable th) {
                C1354qp.D0(th);
                new C1190j6(httpException, th);
                Cu.f3555a.b().getClass();
            }
        }
    }

    public BodyOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    public void call(Subscriber<? super T> subscriber) {
        this.upstream.call(new BodySubscriber(subscriber));
    }
}
