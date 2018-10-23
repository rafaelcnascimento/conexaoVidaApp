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

}
