package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class WorkerParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Dq f2637a;

    /* renamed from: a  reason: collision with other field name */
    public final Data f2638a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkerFactory f2639a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2640a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f2641a;

    /* renamed from: a  reason: collision with other field name */
    public final C0227id f2642a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f2643a;

    /* renamed from: a  reason: collision with other field name */
    public final UUID f2644a;

    /* renamed from: a  reason: collision with other field name */
    public final Executor f2645a;

    public static class a {
        public Network a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f2646a = Collections.emptyList();
        public List<Uri> b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, Data data, List list, a aVar, int i, ExecutorService executorService, TaskExecutor taskExecutor, pE pEVar, C0178eE eEVar, TD td) {
        this.f2644a = uuid;
        this.f2638a = data;
        this.f2643a = new HashSet(list);
        this.f2640a = aVar;
        this.a = i;
        this.f2645a = executorService;
        this.f2641a = taskExecutor;
        this.f2639a = pEVar;
        this.f2637a = eEVar;
        this.f2642a = td;
    }
}
