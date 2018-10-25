package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logar(View v) throws JSONException, ExecutionException, InterruptedException {

        EditText emailEt = this.findViewById(R.id.emailText);
        EditText passwordEt = this.findViewById(R.id.senhaText);

        String email = emailEt.getText().toString();
        String senha = passwordEt.getText().toString();

        Context context = this;

        user.login(email,senha,context);

        Intent intent = new Intent(this, mainActivity.class);

        startActivity(intent);
    }

}
