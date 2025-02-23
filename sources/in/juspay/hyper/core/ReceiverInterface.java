package in.juspay.hyper.core;

public interface ReceiverInterface {
    void addToListenerMap(String str, String str2);

    void registerReceiver(String str);

    void unRegisterReceiver();
}
