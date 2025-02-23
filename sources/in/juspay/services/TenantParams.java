package in.juspay.services;

import androidx.annotation.Keep;
import in.juspay.hyper.bridge.HyperBridge;
import java.util.List;

@Keep
public interface TenantParams {
    String getBaseContent();

    String getBootLoaderEndpoint();

    List<Class<? extends HyperBridge>> getBridgeClasses();

    String getNamespace();
}
