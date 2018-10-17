package com.example.ogn.conexaovida;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class conexao extends AsyncTask<Object, Void, Object> {

    private JSONObject jason;
    private String endpoint;
    private boolean enviar;

    conexao(String endpoint, JSONObject jason, boolean enviar){
        this.jason = jason;
        this.endpoint = endpoint;
        this.enviar = enviar;
    }

    @Override
    protected Object doInBackground(Object... objects) {

        URL url;
        HttpURLConnection urlConnection = null;

        String r = new String();
        try {
            url = new URL("http://10.0.2.2:80//api/" + endpoint);

            urlConnection = (HttpURLConnection) url.openConnection();

            if (enviar){
                urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                urlConnection.setRequestProperty("Accept","application/json");
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);

                DataOutputStream os = new DataOutputStream(urlConnection.getOutputStream());
                //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
                os.writeBytes(jason.toString());

                os.flush();
                os.close();
            }

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();

                r += current;

            }
        } catch (Exception e) {
            Log.d("Erro: ", e.toString());

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return r;

    }
}
