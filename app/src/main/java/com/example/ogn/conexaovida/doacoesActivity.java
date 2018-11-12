package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class doacoesActivity extends menuActivity {

    public String pedido_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacoes);
//
//        tabelaDoacoes t1 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment);
//        t1.setDados("Jair Bolsonaro","O+","1");
////
//        tabelaDoacoes t2 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment2);
//        t2.setDados("Alexei Nikolaevich","AB-","4");


//        try {
//             lista  = pedido.getPedidos(context);
//        } catch (ExecutionException | JSONException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("lmaoo",lista);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

//Replace the contents of the container with the new fragmentTest
        for (int i = 0; i < 2; i++){
            ft.add(R.id.teste, new tabelaDoacoes());
        }

//Complete the changes
        ft.commit();


    }

    public void detalhes(View V) throws ExecutionException, InterruptedException {

        Context context = this;

        pedido.Show(context, V.getTag().toString());

    }
}
