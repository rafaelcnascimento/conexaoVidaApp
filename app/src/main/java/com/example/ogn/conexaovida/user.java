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

    public static void login(String email,String password) throws JSONException {

        JSONObject jason = new JSONObject();

        jason.put("email",email);
        jason.put("password",password);

        conexao c = new conexao("login",jason, true,null);
        String dados = c.execute().toString();

        Log.d("etc", "blarbblarb");

        Log.d("Dados", dados);
    }

}
