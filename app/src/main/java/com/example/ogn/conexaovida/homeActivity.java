package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void sobre(View v) {
        Intent intent = new Intent(this, sobreActivity.class);

        intent.putExtra("com.example.ogn.conexaovida.MAE","home");

        startActivity(intent);
    }

    public void login(View v) {
        Intent intent = new Intent(this, loginActivity.class);

        startActivity(intent);
    }

    public void cadastro(View v) {
        Intent intent = new Intent(this, cadastroActivity.class);

        startActivity(intent);
    }

    public void pedidos(View V){
        Intent intent = new Intent(this, doacoesActivity.class);

        intent.putExtra("com.example.ogn.conexaovida.ORIGEM","home");

        startActivity(intent);
    }

}
