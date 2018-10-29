package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class user {

    public static void cadastar(JSONObject jason){

        conexao c = new conexao("registrar",jason, true,null);
        c.execute();
    }

    public static void login(String email,String password, Context context) throws JSONException, ExecutionException, InterruptedException {

        JSONObject jason = new JSONObject();

        jason.put("email",email);
        jason.put("password",password);

        conexao c = new conexao("login",jason, true,null);

        user.setDados(c.execute().get().toString(),context);
    }

    public static void setDados(String dados, Context context) throws JSONException {

        JSONObject jason_dados = new JSONObject(dados);

        //Log.d("Dados: ", jason_dados.toString());

        SharedPreferences prefs = context.getSharedPreferences("dadoUsers", MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("id",jason_dados.getString("id"));
        editor.putString("nome",jason_dados.getString("nome"));
        editor.putString("email",jason_dados.getString("email"));
        editor.putString("telefone",jason_dados.getString("telefone"));
        editor.putString("cidade",jason_dados.getString("cidade"));
        editor.putString("tipo_sanguineo_id",jason_dados.getString("tipo_sanguineo_id"));
        editor.putString("estado_id",jason_dados.getString("estado_id"));
        editor.putString("api_token",jason_dados.getString("api_token"));

        editor.apply();
    }

    public static String getDado(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences("dadoUsers", MODE_PRIVATE);

        String dado = prefs.getString(key, "");

        return dado;
    }
}
