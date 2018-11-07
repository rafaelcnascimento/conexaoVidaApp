package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class pedido {

    public static void cadastar(Context context, JSONObject jason){

        conexao c = new conexao("doacao", jason, true,user.getDado(context,"api_token"));
        c.execute();
    }

    public static String getPedidos(Context context) throws ExecutionException, InterruptedException, JSONException {

        conexao c = new conexao("doacoes",null, false, user.getDado(context,"api_token"));

        String lista = c.execute().get().toString();

        return lista;
    }

    public static void Show(Context context, String id) throws ExecutionException, InterruptedException {

        conexao c = new conexao("doacao/" + id,null, false, user.getDado(context,"api_token"));

        String dados = c.execute().get().toString();

        Log.d("let's go", dados);

        Intent intent = new Intent(context, detalhesActivity.class);

        intent.putExtra("PEDIDO", dados);

        context.startActivity(intent);
    }
}
