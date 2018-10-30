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

        String dados = c.execute().get().toString();

        JSONObject jason_dados = new JSONObject(dados);

        setDado(context,"id",jason_dados.getString("id"));
        setDado(context,"nome",jason_dados.getString("nome"));
        setDado(context,"email",jason_dados.getString("email"));
        setDado(context,"telefone",jason_dados.getString("telefone"));
        setDado(context,"cidade",jason_dados.getString("cidade"));
        setDado(context,"tipo_sanguineo_id",jason_dados.getString("tipo_sanguineo_id"));
        setDado(context,"estado_id",jason_dados.getString("estado_id"));
        setDado(context,"api_token",jason_dados.getString("api_token"));
    }

    public static void atualizar(Context context, JSONObject jason) throws ExecutionException, InterruptedException, JSONException {

        conexao c = new conexao("user/"+getDado(context,"id"),jason, true, getDado(context,"api_token"));

        c.execute();

        setDado(context,"nome",jason.getString("nome"));
        setDado(context,"email",jason.getString("email"));
        setDado(context,"telefone",jason.getString("telefone"));
        setDado(context,"cidade",jason.getString("cidade"));
        setDado(context,"tipo_sanguineo_id",jason.getString("tipo_sanguineo_id"));
    }

    public static void setDado(Context context, String key, String value) {

        SharedPreferences prefs = context.getSharedPreferences("dadoUsers", MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(key,value);

        editor.commit();
    }

    public static String getDado(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences("dadoUsers", MODE_PRIVATE);

        String dado = prefs.getString(key, "");

        return dado;
    }
}
