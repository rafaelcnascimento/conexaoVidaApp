package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class dadosActivity extends menuActivity implements AdapterView.OnItemSelectedListener {

    public int novo_ts = 0;
    public int nova_reg = 0;
    public Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        EditText nomeEt = this.findViewById(R.id.nomeText);
        EditText emailEt = this.findViewById(R.id.emailText);
        EditText telefoneEt = this.findViewById(R.id.telefoneText);
        EditText cidadeEt = this.findViewById(R.id.cidadeText);

        nomeEt.setText(user.getDado(context,"nome"));
        emailEt.setText(user.getDado(context,"email"));
        telefoneEt.setText(user.getDado(context,"telefone"));
        cidadeEt.setText(user.getDado(context,"cidade"));

        int tipo_sanguineo_id = Integer.parseInt(user.getDado(context,"tipo_sanguineo_id"));
        int regiao_id = Integer.parseInt(user.getDado(context,"regiao_id"));

        gerarSpinner(tipo_sanguineo_id - 1,regiao_id - 1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        switch (item) {
            case "O+":
                novo_ts = 1;
                break;
            case "O-":
                novo_ts = 2;
                break;
            case "A+":
                novo_ts = 3;
                break;
            case "A-":
                novo_ts = 4;
                break;
            case "B+":
                novo_ts = 5;
                break;
            case "B-":
                novo_ts = 6;
                break;
            case "AB+":
                novo_ts = 7;
                break;
            case "AB-":
                novo_ts = 8;
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void editarDados(View v) throws JSONException, ExecutionException, InterruptedException {
        EditText nomeEt = this.findViewById(R.id.nomeText);
        EditText emailEt = this.findViewById(R.id.emailText);
        EditText telefoneEt = this.findViewById(R.id.telefoneText);
        EditText cidadeEt = this.findViewById(R.id.cidadeText);

        String nome = nomeEt.getText().toString();
        String email = emailEt.getText().toString();
        String telefone = telefoneEt.getText().toString();
        String cidade = cidadeEt.getText().toString();
//
//        //Validar(....)

        JSONObject jason = new JSONObject();

        jason.put("nome",nome);
        jason.put("email",email);
        jason.put("telefone",telefone);
        jason.put("cidade",cidade);

        if (novo_ts == 0) {
            jason.put("tipo_sanguineo_id",user.getDado(context,"tipo_sanguineo_id"));
        } else {
            jason.put("tipo_sanguineo_id",novo_ts);
        }

        user.atualizar(context,jason);

        Intent intent = new Intent(this, dadosActivity.class);

        startActivity(intent);

        Toast.makeText(dadosActivity.this, "Informações modificadas com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void trocarSenha(View v) {
        Intent intent = new Intent(this, senhaActivity.class);

        startActivity(intent);
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

}