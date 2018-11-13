package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class doacoesActivity extends menuActivity {

    public String pedido_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacoes);

        String lista = null;

        Context context = this;

        JSONArray jsonArray;

        TextView twNome;
        TextView twSangue;
        TableRow tr;
        Button detalhes;

        TableLayout tl = findViewById(R.id.tableLayout);

        try {
            lista  = pedido.getPedidos(context);

            Log.d("fuck",lista);

            JSONObject object = new JSONObject(lista);
            jsonArray  = object.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject pedido = jsonArray.getJSONObject(i);

                twNome = new TextView(this);
                twNome.setText(pedido.get("paciente").toString());
                twNome.setTextSize(18);
                twNome.setTextColor(0);

                twSangue = new TextView(this);
                twSangue.setText(pedido.get("tipo_sanguineo_id").toString());
                twSangue.setTextSize(18);

                detalhes = new Button(this);
                detalhes.setText("Detalhes");
                detalhes.setTag(pedido.get("id").toString());


                tr = new TableRow(this);

                tr.addView(twNome);
                tr.addView(twSangue);
                tr.addView(detalhes);
                tl.addView(tr);
//                Log.d("Nome:", JSONLivro.get("nome").toString());
//                Log.d("Ano:", JSONLivro.get("ano").toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void detalhar(View V) throws ExecutionException, InterruptedException {
        Context context = this;

        pedido.Show(context, V.getTag().toString());
    }
}
