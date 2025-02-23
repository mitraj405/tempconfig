package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new C0406yb(0));
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new C0080Ab(0));
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new C0423zb(0));
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new Bb(0));

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        detectNetwork.detectResourceMismatches();
        detectNetwork.detectUnbufferedIo();
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory factory(String str, int i) {
        return new CustomThreadFactory(str, i, (StrictMode.ThreadPolicy) null);
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<ScheduledExecutorService> cls2 = ScheduledExecutorService.class;
        Qualified<ScheduledExecutorService> qualified = Qualified.qualified(cls, cls2);
        Class<ExecutorService> cls3 = ExecutorService.class;
        Class<Executor> cls4 = Executor.class;
        Qualified[] qualifiedArr = {Qualified.qualified(cls, cls3), Qualified.qualified(cls, cls4)};
        Class<Blocking> cls5 = Blocking.class;
        Qualified<Blocking> qualified2 = Qualified.qualified(cls5, cls2);
        Qualified[] qualifiedArr2 = {Qualified.qualified(cls5, cls3), Qualified.qualified(cls5, cls4)};
        Class<Lightweight> cls6 = Lightweight.class;
        return Arrays.asList(new Component[]{Component.builder(qualified, (Qualified<? super T>[]) qualifiedArr).factory(new C0333t(1)).build(), Component.builder(qualified2, (Qualified<? super T>[]) qualifiedArr2).factory(new C0363vb(0)).build(), Component.builder(Qualified.qualified(cls6, cls2), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(cls6, cls3), Qualified.qualified(cls6, cls4)}).factory(new C0377wb(0)).build(), Component.builder(Qualified.qualified(UiThread.class, cls4)).factory(new C0391xb(0)).build()});
    }

    private static ThreadFactory factory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i, threadPolicy);
    }
}
