package defpackage;

import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.EwalletProfileDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import cris.prs.webservices.dto.PostBookingRequestDTO;
import cris.prs.webservices.dto.StatusDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import cris.prs.webservices.dto.b;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* renamed from: Om  reason: default package */
/* compiled from: NgetServices */
public interface Om {
    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1426uk> A(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1225kp> A0(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @FormUrlEncoded
    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> A1(@Path(encoded = true, value = "fullUrl") String str, @Field("txnId") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Z2> B(@Path(encoded = true, value = "fullUrl") String str, @Query("jrnQuota") String str2, @Query("retJrn") String str3);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> B0(@Path(encoded = true, value = "fullUrl") String str, @Query("newEmail") String str2, @Query("newMobile") String str3, @Query("country") String str4, @Query("isd") String str5);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0781ac> B1(@Path(encoded = true, value = "fullUrl") String str, @Body C0766Zb zb);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<O8> C(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Z2> C0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<E4> D(@Path(encoded = true, value = "fullUrl") String str, @Query("nlpCaptchaException") String str2);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Z2> D0(@Path(encoded = true, value = "fullUrl") String str, @Body C1081e2 e2Var);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Wp> E(@Path(encoded = true, value = "fullUrl") String str, @Body C0766Zb zb);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<BookingResponseDTO> E0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<EwalletProfileDTO> F(@Path(encoded = true, value = "fullUrl") String str, @Body EwalletProfileDTO ewalletProfileDTO);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> F0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Y2> G(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Cf> G0(@Path(encoded = true, value = "fullUrl") String str, @Body C1469x0 x0Var);

    @POST("/eticketing/protected/mapps1/allLapAvlFareEnq/{paymentEnqFlag}")
    @Headers({"Accept: application/json"})
    Observable<C1100f2> H(@Path("paymentEnqFlag") String str, @Body C1081e2 e2Var);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> H0(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Xo> I(@Path(encoded = true, value = "fullUrl") String str, @Body C1216kd kdVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0675S3> I0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1074dm> J(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> J0(@Path(encoded = true, value = "fullUrl") String str, @Query("dmrcToken") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> K(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> K0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Wp> L(@Path(encoded = true, value = "fullUrl") String str, @Body PostBookingRequestDTO postBookingRequestDTO);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<E4> L0(@Path(encoded = true, value = "fullUrl") String str, @Query("nlpCaptchaException") String str2);

    @GET("/eticketing/protected/mapps1/addMealChoiceDetails/{trainNo}/{pnrNo}")
    @Headers({"Accept: application/json"})
    Observable<Object> M(@Path("trainNo") String str, @Path("pnrNo") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> M0(@Path(encoded = true, value = "fullUrl") String str, @Query("currentStatus") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> N(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1358qx> N0(@Path(encoded = true, value = "fullUrl") String str, @Body C1358qx qxVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> O(@Path(encoded = true, value = "fullUrl") String str, @Body Xo xo);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> O0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> P(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> P0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Xo> Q(@Path(encoded = true, value = "fullUrl") String str, @Body Xo xo);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<EwalletProfileDTO> Q0(@Path(encoded = true, value = "fullUrl") String str, @Body EwalletProfileDTO ewalletProfileDTO);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0488Ds> R(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0561KB> R0(@Path(encoded = true, value = "fullUrl") String str, @Body C0574LB lb);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<S9> S(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<E4> S0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<E4> T(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<JB> T0(@Path(encoded = true, value = "fullUrl") String str, @Query("source") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> U(@Path(encoded = true, value = "fullUrl") String str, @Query("softBankNumber") String str2);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> U0(@Path(encoded = true, value = "fullUrl") String str, @Body C1395ss ssVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> V(@Path(encoded = true, value = "fullUrl") String str, @Body JB jb);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0726Vq> V0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<PnrEnquiryResponseDTO> W(@Path(encoded = true, value = "fullUrl") String str, @Query("pnrEnqType") String str2);

    @POST("/eticketing/protected/mapps1/ewallet/ewalletRenewAccountForEmailAndPassword")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> W0(@Body C1196jd jdVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0750Xx> X(@Path(encoded = true, value = "fullUrl") String str, @Body C0674S1 s1, @Query("splBooking") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0750Xx> X0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<b> Y(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Oy> Y0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0549JD> Z(@Path(encoded = true, value = "fullUrl") String str, @Body KD kd);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0701U1> Z0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0561KB> a(@Path(encoded = true, value = "fullUrl") String str, @Body C0574LB lb);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<EwalletProfileDTO> a0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> a1(@Path(encoded = true, value = "fullUrl") String str, @Body C1229kx kxVar);

    @POST("/eticketing/protected/mapps1/altAvlEnq/{type}")
    @Headers({"Accept: application/json"})
    Observable<TrainBtwnStnsRespDto> b(@Body C1469x0 x0Var, @Path("type") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1291nx> b0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> b1(@Path(encoded = true, value = "fullUrl") String str, @Body C1196jd jdVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> c(@Path(encoded = true, value = "fullUrl") String str, @Body C1229kx kxVar);

    @POST("/eticketing/protected/ewallet/initEwalletRegPayment")
    @Headers({"Accept: application/json"})
    Observable<C1215kb> c0(@Body C1215kb kbVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<AvlFareResponseDTO> c1(@Path(encoded = true, value = "fullUrl") String str, @Body C0515Ga ga);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0726Vq> d(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: text/plain"})
    Observable<String> d0(@Path(encoded = true, value = "fullUrl") String str, @Query("hl") String str2);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> d1(@Path(encoded = true, value = "fullUrl") String str, @Body C1426uk ukVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> e(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0687T1> e0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0459BB> e1(@Path(encoded = true, value = "fullUrl") String str, @Query("userid") String str2, @Query("email") String str3, @Query("mobile") String str4);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> f(@Path(encoded = true, value = "fullUrl") String str, @Body DB db);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> f0(@Path(encoded = true, value = "fullUrl") String str, @Query("newEmail") String str2, @Query("newMobile") String str3, @Query("emailCode") String str4, @Query("smsCode") String str5);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<PnrEnquiryResponseDTO> f1(@Path(encoded = true, value = "fullUrl") String str, @Body C0573L6 l6);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> g(@Path(encoded = true, value = "fullUrl") String str, @Body C1229kx kxVar);

    @GET("/eticketing/StationLinguisticNames")
    @Headers({"Accept: text/plain"})
    Observable<String> g0(@Query("hl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<TrainScheduleViewDTO> g1(@Path(encoded = true, value = "fullUrl") String str);

    @GET("/eticketing/protected/mapps1/deleteJourneyDetails/{id}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> h(@Path("id") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<TrainScheduleViewDTO> h0(@Path(encoded = true, value = "fullUrl") String str, @Query("startingStationCode") String str2, @Query("journeyDate") String str3);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1358qx> h1(@Path(encoded = true, value = "fullUrl") String str);

    @POST("/eticketing/protected/mapps1/ewallet/ewalletRegisterData")
    @Headers({"Accept: application/json"})
    Observable<C1215kb> i(@Path("txnId") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0613Ns> i0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0812c0> i1(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0812c0> j(@Path(encoded = true, value = "fullUrl") String str, @Query("city") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> j0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("/eticketing/protected/mapps1/verifyPaymentNonBkg/{txnId}/{entityCodeId}")
    @Headers({"Accept: application/json"})
    Observable<C1263mp> j1(@Path("txnId") String str, @Path("entityCodeId") int i, @Body C1225kp kpVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0716V1> k(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> k0(@Path(encoded = true, value = "fullUrl") String str, @Body Xo xo);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> k1(@Path(encoded = true, value = "fullUrl") String str, @Body Xo xo);

    @GET("{fullUrl}")
    @Headers({"Content-Type: application/pdf"})
    Observable<ResponseBody> l(@Path(encoded = true, value = "fullUrl") String str, @Query("appType") Integer num, @Query("language") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<U7> l0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1215kb> l1(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<JB> m(@Path(encoded = true, value = "fullUrl") String str, @Query("source") String str2, @Query("otp") String str3);

    @POST("{fullUrl}")
    @Headers({"Accept: text/plain", "Content-Type: text/plain"})
    Observable<String> m0(@Path(encoded = true, value = "fullUrl") String str, @Body String str2, @Query("reqSource") String str3, @Query("loginType") String str4);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<TrainBtwnStnsRespDto> m1(@Path(encoded = true, value = "fullUrl") String str, @Query("dateSpecific") String str2, @Query("journeyType") String str3);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> n(@Path(encoded = true, value = "fullUrl") String str);

    @POST("eticketing/protected/soft/initLoyaltyPurchasePayment")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> n0(C1432ux uxVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1225kp> n1(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> o(@Path(encoded = true, value = "fullUrl") String str, @Query("softBankNumber") String str2);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> o0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("eticketing/protected/soft/initLoyaltyPurchase")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> o1();

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0742Wx[]> p(@Path(encoded = true, value = "fullUrl") String str);

    @GET("/eticketing/webservices/taenqservices/specialTrainDetails")
    @Headers({"Accept: application/json"})
    Observable<TrainBtwnStnsRespDto> p0();

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> p1(@Path(encoded = true, value = "fullUrl") String str, @Query("lastTxnDtls") String str2);

    @POST("/eticketing/protected/ewallet/depositBankList")
    @Headers({"Accept: application/json"})
    Observable<Object> q();

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<Object> q0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("/eticketing/protected/mapps1/saveJourneyDetails/{from}/{to}/{trainNo}/{quota}/{cls}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> q1(@Path("from") String str, @Path("to") String str2, @Path("trainNo") String str3, @Path("quota") String str4, @Path("cls") String str5);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1215kb> r(@Path(encoded = true, value = "fullUrl") String str, @Body C1215kb kbVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<BookingResponseDTO> r0(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<F4> r1(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1225kp> s(@Path(encoded = true, value = "fullUrl") String str, @Query("insurenceApplicable") String str2, @Body C1225kp kpVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<BookingResponseDTO> s0(@Path(encoded = true, value = "fullUrl") String str, @Body C1225kp kpVar);

    @POST("eticketing/protected/soft/loyaltyPurchaseData")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> s1(@Path("txnId") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<E4> t(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: text/plain", "Content-Type: text/plain"})
    Observable<Boolean> t0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0750Xx> t1(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> u(@Path(encoded = true, value = "fullUrl") String str, @Body C0486Dp dp);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> u0(@Path(encoded = true, value = "fullUrl") String str, @Body C1432ux uxVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1432ux> u1(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> v(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> v0(@Path(encoded = true, value = "fullUrl") String str);

    @POST("/eticketing/protected/mapps1/ewallet/ewalletRenewal")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> v1(@Body Xo xo);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1215kb> w(@Path(encoded = true, value = "fullUrl") String str, @Body C1215kb kbVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> w0(@Path(encoded = true, value = "fullUrl") String str, @Body C1426uk ukVar);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> w1(@Path(encoded = true, value = "fullUrl") String str, @Body Jh jh);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1122g> x(@Path(encoded = true, value = "fullUrl") String str, @Body C1122g gVar);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> x0(@Path(encoded = true, value = "fullUrl") String str, @Query("eftFlag") Integer num, @Query("eftAmount") Integer num2, @Query("eftNumber") String str2, @Query("eftDate") String str3, @Query("remarks") String str4);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<TrainBtwnStnsRespDto> x1(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<StatusDTO> y(@Path(encoded = true, value = "fullUrl") String str, @Body JB jb);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1279nb> y0(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C0707Ue> y1(@Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<JB> z(@Path(encoded = true, value = "fullUrl") String str);

    @FormUrlEncoded
    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<C1109fb> z0(@Path(encoded = true, value = "fullUrl") String str, @Field("recharge") int i);

    @POST("{fullUrl}")
    @Headers({"Accept: application/json"})
    Observable<TrainBtwnStnsRespDto> z1(@Path(encoded = true, value = "fullUrl") String str, @Body C1081e2 e2Var);
}
