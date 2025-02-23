package in.juspay.hyper.bridge;

import android.content.Intent;
import in.juspay.hyper.core.BridgeComponents;

public abstract class HyperBridge implements HBridge {
    protected BridgeComponents bridgeComponents;

    public HyperBridge(BridgeComponents bridgeComponents2) {
        this.bridgeComponents = bridgeComponents2;
    }

    public String getInterfaceName() {
        return getClass().getSimpleName();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public boolean onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        return false;
    }

    public void reset() {
    }

    public void terminate() {
    }
}
