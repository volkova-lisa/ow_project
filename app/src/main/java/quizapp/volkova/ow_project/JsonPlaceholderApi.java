package quizapp.volkova.ow_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    @GET("/api/v1/entities/getAllIds")
    Call<String> getData();



}
