package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logar(View v) throws JSONException {

        EditText emailEt = this.findViewById(R.id.emailText);
        EditText senhaEt = this.findViewById(R.id.senhaText);

        String email = emailEt.getText().toString();
        String senha = senhaEt.getText().toString();

        user.login(email,senha);

        Intent intent = new Intent(this, mainActivity.class);

        startActivity(intent);
    }
}
