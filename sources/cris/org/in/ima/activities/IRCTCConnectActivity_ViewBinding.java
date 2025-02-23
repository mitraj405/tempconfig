package cris.org.in.ima.activities;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class IRCTCConnectActivity_ViewBinding implements Unbinder {
    public IRCTCConnectActivity a;

    public IRCTCConnectActivity_ViewBinding(IRCTCConnectActivity iRCTCConnectActivity, View view) {
        this.a = iRCTCConnectActivity;
        iRCTCConnectActivity.main_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.main_heading, "field 'main_heading'", TextView.class);
    }

    public final void unbind() {
        IRCTCConnectActivity iRCTCConnectActivity = this.a;
        if (iRCTCConnectActivity != null) {
            this.a = null;
            iRCTCConnectActivity.main_heading = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
