package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

        final Context context = this;

        JSONArray jsonArray;

        TextView twNome;
        TextView twSangue;
        TableRow tr;
        Button detalhes;

        TableLayout tl = findViewById(R.id.tableLayout);

        TableLayout.LayoutParams lp =
                new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT);

        lp.setMargins(0,10,10,10);

        try {
            lista  = pedido.getPedidos(context);

            Log.d("listtaa",lista);

            JSONObject object = new JSONObject(lista);
            jsonArray  = object.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject JSONpedido = jsonArray.getJSONObject(i);

                twNome = new TextView(this);
                twNome.setText(user.getNome(JSONpedido.get("paciente").toString()));
                twNome.setTextSize(18);
                twNome.setTextColor(Color.BLACK);

                twSangue = new TextView(this);
                twSangue.setText(pedido.getSangue(JSONpedido.get("tipo_sanguineo_id").toString()));
                twSangue.setTextSize(18);
                twSangue.setTextColor(Color.BLACK);

                detalhes = new Button(this);
                detalhes.setText("Detalhes");
                detalhes.setTag(JSONpedido.get("id").toString());
                detalhes.setBackgroundColor(Color.parseColor("#8A0707"));
                detalhes.setTextColor(Color.WHITE);

                detalhes.setOnClickListener(new View.OnClickListener(){
                    @Override
                    //On click function
                    public void onClick(View V) {
                        try {
                            pedido.Show(context,V.getTag().toString());
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                tr = new TableRow(this);

                tr.addView(twNome);
                tr.addView(twSangue);
                tr.addView(detalhes);
                tr.setLayoutParams(lp);
                tl.addView(tr);
            }
        } catch (JSONException | ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
