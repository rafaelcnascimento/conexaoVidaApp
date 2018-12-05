package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class detalhesActivity extends menuActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Context context = this;

        JSONObject jason = null;

        Intent intent = getIntent();
        String dados = intent.getStringExtra("PEDIDO");

        EditText nomeEt = this.findViewById(R.id.nomeText);
        EditText hospitalEt = this.findViewById(R.id.hospitalText);
        EditText enderecoEt = this.findViewById(R.id.enderecoText);
        EditText quartoEt = this.findViewById(R.id.quartoText);
        EditText cidadeEt = this.findViewById(R.id.cidadeText);



        try {
            jason = new JSONObject(dados);

            nomeEt.setText(jason.getString("paciente"));
            hospitalEt.setText(jason.getString("hospital"));
            enderecoEt.setText(jason.getString("endereco_hospital"));
            quartoEt.setText(jason.getString("quarto"));
            cidadeEt.setText(jason.getString("cidade"));

            int tipo_sanguineo_id = Integer.parseInt(jason.getString("tipo_sanguineo_id"));
            int regiao_id = Integer.parseInt(jason.getString("regiao_id"));

            gerarSpinner(tipo_sanguineo_id - 1,regiao_id - 1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void gerarSpinner(int sang, int reg){
        // Spinner element
        Spinner spinnerSangue = (Spinner) findViewById(R.id.spinnerSangue);

        // Spinner click listener
        spinnerSangue.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> tipos = new ArrayList<String>();
        tipos.add("O+");
        tipos.add("O-");
        tipos.add("A+");
        tipos.add("A-");
        tipos.add("B+");
        tipos.add("B-");
        tipos.add("AB+");
        tipos.add("AB-");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerSangue.setAdapter(dataAdapter);

        spinnerSangue.setSelection(sang);

        // Spinner element
        Spinner spinnerRegiao = (Spinner) findViewById(R.id.spinnerRegiao);

        // Spinner click listener
        spinnerRegiao.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> regiao = new ArrayList<String>();
        regiao.add("Central");
        regiao.add("Metropolitana/Litoral");
        regiao.add("Noroeste");
        regiao.add("Norte");
        regiao.add("Oeste");
        regiao.add("Serra");
        regiao.add("Sul");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regiao);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerRegiao.setAdapter(dataAdapter2);

        spinnerRegiao.setSelection(reg);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void voltar(View v) {
        Intent intent = getIntent();

        String origem = intent.getStringExtra("com.example.ogn.conexaovida.ORIGEM");

        intent = new Intent(this, doacoesActivity.class);

        intent.putExtra("com.example.ogn.conexaovida.ORIGEM",origem);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Intent intent = getIntent();
        String activityMae = intent.getStringExtra("com.example.ogn.conexaovida.ORIGEM");

        if (activityMae != null) {
            return false;
        } else {
            getMenuInflater().inflate(R.menu.menulogando, menu);
            return true;
        }

    }

}
