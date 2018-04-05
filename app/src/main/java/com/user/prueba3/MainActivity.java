package com.user.prueba3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.user.prueba3.adapter.DepartmentAdapter;
import com.user.prueba3.api.Api;
import com.user.prueba3.models.DepartmentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG= "MainActivity";


    private Button buttonSelectAll;
    private Button buttonCreate;
    private Button buttonDelete;
    private Button buttonUpdate;
    private EditText txtName;
    private EditText txtDescription;
    private EditText txtPrice;
    private EditText txtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        buttonSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllData.class);
                startActivity(intent);
                finish();
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendHttpRequest();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }

    private void initViews() {

        buttonSelectAll = findViewById(R.id.buttonSelect);
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate= findViewById(R.id.buttonUpdate);
        txtName = findViewById(R.id.nameFood);
        txtDescription = findViewById(R.id.descriptionFood);
        txtPrice= findViewById(R.id.priceFood);
        txtId = findViewById(R.id.idFood);

    }





    private void sendHttpRequest() {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setName(txtName.getText().toString());
        departmentModel.setDescription(txtDescription.getText().toString());
        departmentModel.setPrice(Integer.valueOf(txtPrice.getText().toString()));
        departmentModel.setId(Integer.valueOf(txtId.getText().toString()));



        Call<DepartmentModel> call = Api.instance().createDepartment(departmentModel);
        call.enqueue(new Callback<DepartmentModel>() {
            @Override
            public void onResponse(Call<DepartmentModel> call, Response<DepartmentModel> response) {
                assert response.body() != null;
                Log.i(TAG, response.body().getName());

            }

            @Override
            public void onFailure(Call<DepartmentModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());



            }
        });
    }


    private void updateData(){
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setName(txtName.getText().toString());
        departmentModel.setDescription(txtDescription.getText().toString());
        departmentModel.setPrice(Integer.valueOf(txtPrice.getText().toString()));
        departmentModel.setId(Integer.valueOf(txtId.getText().toString()));

        Call<DepartmentModel> call = Api.instance().updateDepartment(departmentModel.getId(),departmentModel);
        call.enqueue(new Callback<DepartmentModel>() {
            @Override
            public void onResponse(Call<DepartmentModel> call, Response<DepartmentModel> response) {
                if(response != null){ Log.i(TAG, response.body().getName());}

            }

            @Override
            public void onFailure(Call<DepartmentModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });
    }

    private void deleteData(){
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setName(txtName.getText().toString());
        departmentModel.setDescription(txtDescription.getText().toString());
        departmentModel.setPrice(Integer.valueOf(txtPrice.getText().toString()));
        departmentModel.setId(Integer.valueOf(txtId.getText().toString()));

        Call<DepartmentModel> call = Api.instance().deleteDepartment(departmentModel.getId());
        call.enqueue(new Callback<DepartmentModel>() {
            @Override
            public void onResponse(Call<DepartmentModel> call, Response<DepartmentModel> response) {
                if(response != null){ Log.i(TAG, response.body().getName());}

            }

            @Override
            public void onFailure(Call<DepartmentModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });

    }
}
