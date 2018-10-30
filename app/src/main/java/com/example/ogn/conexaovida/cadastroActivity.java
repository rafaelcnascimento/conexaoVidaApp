package com.example.ogn.conexaovida;

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

//        // Spinner element
//        Spinner spinnerEstado = (Spinner) findViewById(R.id.spinnerEstado);
//
//        // Spinner click listener
//        spinnerEstado.setOnItemSelectedListener(this);
//
//        // Spinner Drop down elements
//        List<String> estados = new ArrayList<String>();
//        estados.add("Rio Grande do Sul - RS");
//        estados.add("Santa Catarina - SC");
//        estados.add("Paraná - PR");
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinnerEstado.setAdapter(dataAdapter2);


    }


        @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

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
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void cadastrar (View v) throws JSONException {
        EditText nomeEt = this.findViewById(R.id.nomeText);
        EditText emailEt = this.findViewById(R.id.emailText);
        EditText telefoneEt = this.findViewById(R.id.telefoneText);
        EditText cidadeEt = this.findViewById(R.id.cidadeText);
        EditText senhaEt = this.findViewById(R.id.senhaText);
        //String confirmarSenhaEt = this.findViewById(R.id.confirmarSenhaText);

        String nome = nomeEt.getText().toString();
        String email = emailEt.getText().toString();
        String telefone = telefoneEt.getText().toString();
        String cidade = cidadeEt.getText().toString();
        String password = senhaEt.getText().toString();
//
//        //Validar(....)

        JSONObject jason = new JSONObject();

        jason.put("nome",nome);
        jason.put("email",email);
        jason.put("telefone",telefone);
        jason.put("password",password);
        jason.put("cidade",cidade);
        jason.put("tipo_sanguineo_id",tipo_sanguineo_id);

        user.cadastar(jason);

        Intent intent = new Intent(this, loginActivity.class);

        startActivity(intent);

        Toast.makeText(cadastroActivity.this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();

    }
}
