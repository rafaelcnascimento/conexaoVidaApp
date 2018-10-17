package com.example.ogn.conexaovida;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class user {

    public static void cadastar(JSONObject jason){

        conexao c = new conexao("registrar",jason, true);
        c.execute();
    }

    public static String getDoacoes() throws ExecutionException, InterruptedException {
        conexao c = new conexao("doacoes",null, false);

        String lista = c.execute().get().toString();

        return lista;
    }
}
