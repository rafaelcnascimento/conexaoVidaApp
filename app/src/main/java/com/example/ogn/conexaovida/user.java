package com.example.ogn.conexaovida;

import android.util.Log;

import org.json.JSONObject;

public class user {

    public static void cadastar(JSONObject jason){

        conexao c = new conexao("registrar",jason, true);
        c.execute();
    }
}
