package in.juspay.hypersdk.core;

import in.juspay.hyper.core.JsCallback;

public interface DuiCallback extends JsCallback {
    InflateView getInflateView();

    DuiLogger getLogger();
}
