package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class senhaActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);
    }

    public void salvar(View v) {
        Intent intent = new Intent(this, dadosActivity.class);

        startActivity(intent);

        Toast.makeText(senhaActivity.this, "Senha modificada com sucesso", Toast.LENGTH_SHORT).show();

    }
}
