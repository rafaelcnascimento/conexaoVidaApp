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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public int tipo_sanguineo_id;
    public int regiao_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
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

    }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = null;

            switch (parent.getId())
            {
                case R.id.spinnerSangue:

                    item = parent.getItemAtPosition(position).toString();

                    switch (item) {
                        case "O+":
                            tipo_sanguineo_id = 1;
                            break;
                        case "O-":
                            tipo_sanguineo_id = 2;
                            break;
                        case "A+":
                            tipo_sanguineo_id = 3;
                            break;
                        case "A-":
                            tipo_sanguineo_id = 4;
                            break;
                        case "B+":
                            tipo_sanguineo_id = 5;
                            break;
                        case "B-":
                            tipo_sanguineo_id = 6;
                            break;
                        case "AB+":
                            tipo_sanguineo_id = 7;
                            break;
                        case "AB-":
                            tipo_sanguineo_id = 8;
                            break;
                    }

                    break;

                case R.id.spinnerRegiao:

                    item = parent.getItemAtPosition(position).toString();

                    switch (item) {
                        case "Central":
                            regiao_id = 1;
                            break;
                        case "Metropolitana/Litoral":
                            regiao_id = 2;
                            break;
                        case "Noroeste":
                            regiao_id = 3;
                            break;
                        case "Norte":
                            regiao_id = 4;
                            break;
                        case "Oeste":
                            regiao_id = 5;
                            break;
                        case "Serra":
                            regiao_id = 6;
                            break;
                        case "Sul":
                            regiao_id = 7;
                            break;
                    }

                    break;
            }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void cadastrar (View v) throws JSONException {
        Context context = this;

        EditText nomeEt = this.findViewById(R.id.nomeText);
        EditText emailEt = this.findViewById(R.id.emailText);
        EditText telefoneEt = this.findViewById(R.id.telefoneText);
        EditText cidadeEt = this.findViewById(R.id.cidadeText);
        EditText senhaEt = this.findViewById(R.id.senhaText);
        EditText confirmarSenhaEt = this.findViewById(R.id.confirmarSenhaText);

        String nome = nomeEt.getText().toString();
        String email = emailEt.getText().toString();
        String telefone = telefoneEt.getText().toString();
        String cidade = cidadeEt.getText().toString();
        String password = senhaEt.getText().toString();
        String confirmarSenha = confirmarSenhaEt.getText().toString();

        if (validar.cadastroUser(context,nome,email,telefone,cidade,password,confirmarSenha)){
            JSONObject jason = new JSONObject();

            jason.put("nome",nome);
            jason.put("email",email);
            jason.put("telefone",telefone);
            jason.put("password",password);
            jason.put("regiao_id",regiao_id);
            jason.put("cidade",cidade);
            jason.put("tipo_sanguineo_id",tipo_sanguineo_id);

            user.cadastar(jason);

            Intent intent = new Intent(this, loginActivity.class);

            startActivity(intent);

            Toast.makeText(cadastroActivity.this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}
