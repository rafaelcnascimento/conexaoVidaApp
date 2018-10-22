package com.example.ogn.conexaovida;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class user {

    public static void cadastar(JSONObject jason){

        conexao c = new conexao("registrar",jason, true,null);
        c.execute();
    }

    public static String getDoacoes() throws ExecutionException, InterruptedException, JSONException {
        String token = "U3y4o7TFBgnjYflevisR5xdHKvWEsoVCZ2Jmy5hg5mJDm8rJHwSmLczHl6ji";

        JSONObject jason = new JSONObject();

        jason.put("email","r_catelan@hotmail.com");
        jason.put("password","110ftw");

        conexao c = new conexao("doacoes",jason, true,token);

        String lista = c.execute().get().toString();

        return lista;
    }
}
