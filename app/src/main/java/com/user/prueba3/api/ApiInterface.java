package com.user.prueba3.api;

import android.graphics.DashPathEffect;

import com.user.prueba3.models.DepartmentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by USER on 2/4/2018.
 */

public interface ApiInterface {

    @GET("foods")
    Call<List<DepartmentModel>> getDepartment();

    @POST("foods")
    Call<DepartmentModel> createDepartment(@Body DepartmentModel departmentModel);

    @PUT("foods/{id}")
    Call<DepartmentModel> updateDepartment(@Path("id")int id,@Body DepartmentModel departmentModel);

    @DELETE("foods/{id}")
    Call<DepartmentModel> deleteDepartment (@Path("id")int id);

}
