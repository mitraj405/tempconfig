package in.juspay.hypernfc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cardreader.card_reader_lib.CardTask;
import com.google.firebase.messaging.Constants;
import defpackage.d7;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class NfcActivity extends FragmentActivity {
    private final CardTask cardTask = new CardTask();
    /* access modifiers changed from: private */
    public final JSONObject data = new JSONObject();
    private TimerTask task;
    private final Timer timerForWaitingInActivity = new Timer();
    private final Timer timerToReadChangedMessage = new Timer();

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(ImageView imageView) {
        ((Wave) findViewById(R.id.rippleView)).startRippleAnimation((imageView.getHeight() / 2) + imageView.getTop());
    }

    /* access modifiers changed from: private */
    public void lambda$onNewIntent$1() {
        View findViewById = findViewById(R.id.backgroundImage);
        Context applicationContext = getApplicationContext();
        int i = R.drawable.image_border;
        Object obj = d7.a;
        findViewById.setBackground(d7.a.b(applicationContext, i));
    }

    /* access modifiers changed from: private */
    public void timedOut(final JSONObject jSONObject) {
        ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.no_card_detected);
        AnonymousClass2 r0 = new TimerTask() {
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("result_data", jSONObject.toString());
                NfcActivity.this.setResult(0, intent);
                NfcActivity.this.finish();
            }
        };
        this.task = r0;
        this.timerToReadChangedMessage.schedule(r0, 1500);
    }

    public void onBackPressed() {
        setResult(0, new Intent());
        finish();
    }

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            i = extras.getInt("waitingTime");
        } else {
            i = 7000;
        }
        setContentView(R.layout.activity_nfc);
        ImageView imageView = (ImageView) findViewById(R.id.backgroundImage);
        imageView.post(new C0428zq(9, this, imageView));
        AnonymousClass1 r0 = new TimerTask() {
            /* access modifiers changed from: private */
            public void lambda$run$0() {
                View findViewById = NfcActivity.this.findViewById(R.id.backgroundImage);
                Context applicationContext = NfcActivity.this.getApplicationContext();
                int i = R.drawable.image_border;
                Object obj = d7.a;
                findViewById.setBackground(d7.a.b(applicationContext, i));
            }

            public void run() {
                try {
                    NfcActivity.this.data.put("error", "Request timed out!");
                    NfcActivity.this.data.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, (Object) null);
                    NfcActivity.this.runOnUiThread(new a(this));
                    NfcActivity nfcActivity = NfcActivity.this;
                    nfcActivity.timedOut(nfcActivity.data);
                } catch (Exception unused) {
                    Intent intent = new Intent();
                    intent.putExtra("result_data", "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
                    NfcActivity.this.setResult(0, intent);
                    NfcActivity.this.finish();
                }
            }
        };
        this.task = r0;
        this.timerForWaitingInActivity.schedule(r0, (long) i);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            TimerTask timerTask = this.task;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.timerForWaitingInActivity.cancel();
            this.timerToReadChangedMessage.cancel();
        } catch (Exception unused) {
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            String cardDetails = this.cardTask.getCardDetails(intent);
            this.data.put("error", (Object) null);
            this.data.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, cardDetails);
            if (cardDetails != null) {
                ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.scan_successful);
                AnonymousClass3 r4 = new TimerTask() {
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra("result_data", NfcActivity.this.data.toString());
                        NfcActivity.this.setResult(-1, intent);
                        NfcActivity.this.finish();
                    }
                };
                this.task = r4;
                this.timerToReadChangedMessage.schedule(r4, 1500);
                return;
            }
            runOnUiThread(new C0140b6(this, 9));
            ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.scan_failed);
            AnonymousClass4 r42 = new TimerTask() {
                public void run() {
                    Intent intent = new Intent();
                    intent.putExtra("result_data", "{\"error\":\"Couldn't read your card ! Try again or type your card number\"}");
                    NfcActivity.this.setResult(0, intent);
                    NfcActivity.this.finish();
                }
            };
            this.task = r42;
            this.timerToReadChangedMessage.schedule(r42, 1500);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.putExtra("result_data", "{\"error\":\"Couldn't recognize card ! Try again or type your card number\"}");
            setResult(0, intent2);
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.cardTask.isNFCEnabled(this)) {
            this.cardTask.onPauseClone(this);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.cardTask.isNFCEnabled(this)) {
            this.cardTask.onResumeClone(this);
        }
    }
}
