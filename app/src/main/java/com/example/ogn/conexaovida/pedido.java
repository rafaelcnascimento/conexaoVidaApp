package com.example.ogn.conexaovida;

import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class pedido {

    public static SharedPreferences user;


    public static String getPedidos() throws ExecutionException, InterruptedException, JSONException {


        String token = user.getString("api_token",null);

        JSONObject jason = new JSONObject();

        jason.put("email","r_catelan@hotmail.com");
        jason.put("password","110ftw");

        conexao c = new conexao("doacoes",jason, false, token);

        String lista = c.execute().get().toString();

        return lista;
    }
}
