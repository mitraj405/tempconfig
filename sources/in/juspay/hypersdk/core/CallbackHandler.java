package in.juspay.hypersdk.core;

import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;

@Keep
public class CallbackHandler implements InvocationHandler {
    private final InflateJSON infl;
    private final JSONObject obj;

    public CallbackHandler(InflateJSON inflateJSON, JSONObject jSONObject) {
        this.obj = jSONObject;
        this.infl = inflateJSON;
    }

    public Object invoke(Object obj2, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            if (!this.obj.has(name)) {
                return method.invoke(this, objArr);
            }
            this.infl.putInState("proxy", obj2);
            this.infl.putInState(FirebaseAnalytics.Param.METHOD, method);
            this.infl.putInState("args", objArr);
            return this.infl.runProps(this.obj, name, obj2);
        } catch (Throwable th) {
            DuiLogger logger = this.infl.getDUI().getLogger();
            logger.e("ERROR", "error in callback handler" + th.getMessage());
            return new Object();
        }
    }
}
