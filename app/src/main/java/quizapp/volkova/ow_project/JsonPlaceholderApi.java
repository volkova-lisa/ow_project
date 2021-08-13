package quizapp.volkova.ow_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("api/v1/object/{id}")
    Call<List<Pages>>

}
