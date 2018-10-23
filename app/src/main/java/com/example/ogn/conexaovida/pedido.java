package com.example.ogn.conexaovida;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class pedido {

    public static String getPedidos() throws ExecutionException, InterruptedException, JSONException {
        String token = "ogqIDoLI6vxgNLewcffLgahxbefSzcvyqmCcUWpft31DVkO9NuKEcjuzsOby";

        JSONObject jason = new JSONObject();

        jason.put("email","r_catelan@hotmail.com");
        jason.put("password","110ftw");

        conexao c = new conexao("doacoes",jason, false, token);

        String lista = c.execute().get().toString();

        return lista;
    }
}
