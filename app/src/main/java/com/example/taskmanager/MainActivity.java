package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import Interface.StudentAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String BASE_URL = "http://192.168.232.2:38749";
    private EditText etfname, etlname, etusername, etpassword, etconpassword;
    private Button btnSignin;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfname = findViewById(R.id.etFName);
        etlname = findViewById(R.id.etLName);
        etusername = findViewById(R.id.etUname);
        etpassword = findViewById(R.id.etPass);
        imgProfile = findViewById(R.id.imgProfile);
        etconpassword = findViewById(R.id.etConPass);
        btnSignin = findViewById(R.id.btnSign);

        btnSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Register();
    }

    private void Register(){
        String fname = etfname.getText().toString();
        String lname = etlname.getText().toString();
        String uname = etusername.getText().toString();
        String password = etpassword.getText().toString();
        String conPassword = etconpassword.getText().toString();

        StudentCUD student = new StudentCUD(fname,lname,uname,password,conPassword);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        StudentAPI studentAPI = retrofit.create(StudentAPI.class);
        Call<Void> voidCall = studentAPI.registerStudent(student);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MainActivity.this, "You have been successfully register", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
