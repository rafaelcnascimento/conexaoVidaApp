package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class senhaActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);
    }

    public void salvar(View v) throws JSONException {
        Context context = this;

        EditText senhaEt = this.findViewById(R.id.senhaText);
        EditText confirmarSenhaEt = this.findViewById(R.id.confirmarSenhaText);

        String password = senhaEt.getText().toString();
        String confirmarSenha = confirmarSenhaEt.getText().toString();

        if (!password.equals(confirmarSenha)){
            Toast.makeText(senhaActivity.this, "As senhas não conferem", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            Toast.makeText(senhaActivity.this, "A senha deve ter mais de 6 caracteres", Toast.LENGTH_SHORT).show();
        } else {

            JSONObject jason = new JSONObject();

            jason.put("password",password);

            user.senha(context,jason);

            Intent intent = new Intent(this, dadosActivity.class);

            startActivity(intent);

            Toast.makeText(senhaActivity.this, "Senha modificada com sucesso", Toast.LENGTH_SHORT).show();
        }

    }
}
