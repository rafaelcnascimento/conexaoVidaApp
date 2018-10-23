package com.example.ogn.conexaovida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class doacoesActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacoes);

        String lista = null;

//        tabelaDoacoes t1 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment);
//        t1.setDados("Jair Bolsonaro","O+");
//
//        tabelaDoacoes t2 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment2);
//        t2.setDados("Alexei Nikolaevich","AB-");


        try {
             lista  = pedido.getPedidos();
        } catch (ExecutionException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("lmaoo",lista);

    }


    public void detalhes(View V) {

        Intent intent = new Intent(this, detalhesActivity.class);

        startActivity(intent);

    }
}
