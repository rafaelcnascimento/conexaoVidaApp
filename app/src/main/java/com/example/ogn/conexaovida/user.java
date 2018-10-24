package com.example.ogn.conexaovida;

import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class user {

    public static SharedPreferences user;

    public static void cadastar(JSONObject jason){

        conexao c = new conexao("registrar",jason, true,null);
        c.execute();
    }

    public static void login(String email,String password) throws JSONException, ExecutionException, InterruptedException {

        JSONObject jason = new JSONObject();

        jason.put("email",email);
        jason.put("password",password);

        conexao c = new conexao("login",jason, true,null);
        String dados = c.execute().get().toString();

        JSONObject jason_dados = new JSONObject(dados);

        SharedPreferences.Editor editor = user.edit();
        editor.putString("id",jason_dados.getString("id"));
        editor.putString("nome",jason_dados.getString("nome"));
        editor.putString("email",jason_dados.getString("email"));
        editor.putString("telefone",jason_dados.getString("telefone"));
        editor.putString("genero",jason_dados.getString("genero"));
        editor.putString("cidade",jason_dados.getString("cidade"));
        editor.putString("tipo_sanguineo_id",jason_dados.getString("tipo_sanguineo_id"));
        editor.putString("ultima_doacao",jason_dados.getString("ultima_doacao"));
        editor.putString("estado_id",jason_dados.getString("estado_id"));
        editor.putString("api_token",jason_dados.getString("api_token"));

        editor.commit();

        //Log.d("Dados", dados);
    }

}
