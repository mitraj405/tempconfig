package defpackage;

import cris.org.in.ima.IrctcImaApplication;

/* renamed from: kf  reason: default package and case insensitive filesystem */
/* compiled from: IRCTCConstants */
public enum C1218kf {
    HOME_PAGE("IRCTC Rail Connect", "आई.आर.सी.टी.सी. रेल कनेक्ट"),
    TicketDetails("TICKET DETAILS", "टिकट विवरण"),
    NEW_BOOKING("Train Search", "ट्रेन खोजे"),
    TRAIN_LIST("Train List", "ट्रेन सूची"),
    ADD_PASSENGER("Passenger Details", "यात्री विवरण"),
    MP_PASSENGERS_LIST("MP PASSENGERS LIST", "एमपी यात्री सूची"),
    REVIEW_JOURNEY("Review Journey", "यात्रा की समीक्षा"),
    MAKE_PAYMENT("Make Payment", "भुगतान करें"),
    MY_BOOKING("My Bookings", "मेरी बुकिंग"),
    EWALLET_TXNS("eWallet Transactions", "ई-वॉलेट लेनदेन"),
    EWALLET_STMT("Account Statement", "खाता विवरण"),
    EWALLET_DEPOSIT_HISTORY("Deposit History", "जमा विवरण"),
    EWALLET_REFUND_STATUS("Refund Status", "वापसी की स्थिति"),
    TDR_DETAILS("TDR Details", "टीडीआर विवरण"),
    TKT_CANCELLATION_HISTORY("Cancelled Tickets", "रद्द टिकट"),
    FAILED_TXN_HISTORY("Failed Transactions", "विफल लेनदेन"),
    SPL_TRN_BKG("Vikalp Booking", "विकल्प बुकिंग"),
    OPT_VIKALP("Opt Vikalp", "विकल्प का चयन करें"),
    TDR_HISTORY("TDR History", "टीडीआर इतिहास"),
    LAST_TXN("Last Transaction", "अंतिम लेनदेन"),
    TICKET_REFUND_HISTORY("Refund History", "धनवापसी इतिहास"),
    CANCEL_TICKET("Cancel Ticket", "टिकट रद्द करें"),
    TDR_TICKET("TDR Ticket", "टीडीआर टिकट"),
    MY_PROFILE("My Profile", "मेरी प्रोफाइल"),
    UPDATE_PROFILE("Update User Profile", "यूजर प्रोफ़ाइल अपडेट करें"),
    CHANGE_PASSWORD("Change Password", "पासवर्ड बदलें"),
    CHANGE_TXN_PASSWORD("Change Transaction Password", "ट्रांजेक्शन पासवर्ड बदलें"),
    FORGOT_TXN_PASSWORD("Forgot Txn Password", "ट्रांजेक्शन पासवर्ड भूल गए"),
    AUTHENTICATE_USER("Authenticate User", "ऑथेन्टकेट यूजर"),
    AADHAARPANKYC("Verify PANCARD/Aadhaar Card", "पैन कार्ड / आधार कार्ड सत्यापित करें"),
    EWALLET_REGISTER("eWallet Register", "ईवॉलेट पंजीकरण"),
    CONTACT_US("Contact Us", "हमसे संपर्क करें"),
    FILE_TDR("File TDR", "फ़ाइल टीडीआर"),
    PNR_ENQUIRY("PNR Enquiry", "पीएनआर पूछताछ"),
    ABOUT_US("About Us", "हमारे बारे में"),
    TERM_AND_CONDITIONS("Terms & Conditions", "नियमों और शर्तों"),
    MASTER_PSGN_LIST("Master List", "मास्टर लिस्ट"),
    EWALLET_HELP_LINK("About IRCTC eWallet", "आईआरसीटीसी ई-वॉलेट के बारे में"),
    TDR_REFUND_STATUS("Tdr Refund Status", "टीडीआर धनवापसी स्थिति"),
    DIGITAL_MAGZINE("Digital Magazine", "डिजिटल मैगज़ीन"),
    ZEE5(" ZEE5", " ज़ी5"),
    MY_ACCOUNT("MY ACCOUNT", "मेरा अकाउंट"),
    MY_TRANSACTIONS(" MY TRANSACTIONS", " मेरे लेन-देन"),
    MORE_DRAWER(" MORE", " अन्य"),
    LOYALTY_DETAIL("Loyalty Membership Details", "लायल्टी सदस्यता विवरण"),
    LOYALITY_TRANSACTION("LOYALTY TRANSACTION", "लायल्टी लेन-देन"),
    ADD_LOYALITY("add Loyalty", "लायल्टी जोड़ें"),
    PURCHASE_LOYALTY_POINTS("Purchase Loyalty Points", "लॉयल्टी पॉइंट खरीदें"),
    PURCHASE_POINTS_LOYALTY_CONFIRMATION("Purchase points confirmation", "पॉइंट खरीदें पुष्टि"),
    upcomingjourney("Upcoming Journey", "आगामी यात्रा"),
    FAV_JOURNEY("Favourite Journey", "पसंदीदा यात्रा"),
    Integrity_Pledge("Integrity Pledge", "सत्यनिष्ठा प्रतिज्ञा"),
    Connecting_journey("Connecting Journey", "कनेक्टिंग जर्नी"),
    TRAIN("TRAIN", "ट्रेन"),
    SEARCH_METRO("SEARCH METRO", "मेट्रो खोजें"),
    Review_Metro_Journey("Review Metro Journey", "मेट्रो यात्रा की समीक्षा करें"),
    Metro_booking_Details("Metro Booking Details", "मेट्रो बुकिंग विवरण");
    

    /* renamed from: c  reason: collision with other field name */
    public final String f5547c;

    /* renamed from: d  reason: collision with other field name */
    public final String f5548d;

    /* access modifiers changed from: public */
    C1218kf(String str, String str2) {
        this.f5547c = str;
        this.f5548d = str2;
    }

    public final String a() {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            return this.f5548d;
        }
        return this.f5547c;
    }
}
