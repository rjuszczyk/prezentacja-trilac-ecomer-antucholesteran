package pl.pharmaway.prezentacjatrilac.network;

import pl.pharmaway.prezentacjatrilac.Constants;
import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface PrezentacjaApi {
//    @GET("getData.php?lekarzType="+ Constants.LEKARZ_TYPE)
    @GET("getData2.php")
    Call<GetDataResponse> getData();

    @GET("version2.php")
    Call<DataVersion> getDataVersion();

    @POST("send2.php")
    @FormUrlEncoded
    Call<SendResponse> send(
            @Field("createDate") String createDate,
            @Field("agent") String agent,
            @Field("spec") String spec,
            @Field("miasto") String miasto,
            @Field("instytucja") String instytucja,
            @Field("timeInApp") String timeInApp,
            @Field("firstChoice") String firstChoice
    );
}
