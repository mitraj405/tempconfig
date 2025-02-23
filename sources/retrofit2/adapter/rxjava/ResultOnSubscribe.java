package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

final class ResultOnSubscribe<T> implements Observable.OnSubscribe<Result<T>> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    public static class ResultSubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super Result<R>> subscriber;

        public ResultSubscriber(Subscriber<? super Result<R>> subscriber2) {
            super(subscriber2);
            this.subscriber = subscriber2;
        }

        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (Nn | Pn | Qn unused) {
                    Cu.f3555a.b().getClass();
                } catch (Throwable th3) {
                    C1354qp.D0(th3);
                    new C1190j6(th2, th3);
                    Cu.f3555a.b().getClass();
                }
            }
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    public ResultOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    public void call(Subscriber<? super Result<T>> subscriber) {
        this.upstream.call(new ResultSubscriber(subscriber));
    }
}
