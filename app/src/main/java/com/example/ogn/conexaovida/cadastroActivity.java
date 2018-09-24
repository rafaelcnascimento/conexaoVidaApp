package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class cadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        tipos.add("A+");
        tipos.add("A-");
        tipos.add("B+");
        tipos.add("B-");
        tipos.add("AB+");
        tipos.add("AB-");
        tipos.add("O+");
        tipos.add("O-");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerSangue.setAdapter(dataAdapter);

        // Spinner element
        Spinner spinnerEstado = (Spinner) findViewById(R.id.spinnerEstado);

        // Spinner click listener
        spinnerEstado.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> estados = new ArrayList<String>();
        estados.add("Rio Grande do Sul - RS");
        estados.add("Santa Catarina - SC");
        estados.add("Paraná - PR");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerEstado.setAdapter(dataAdapter2);
    }


        @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void login(View v) {
        Intent intent = new Intent(this, loginActivity.class);

        startActivity(intent);
    }

    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        RadioButton rMasc = (RadioButton) this.findViewById(R.id.radioMasc);
        RadioButton rFem = (RadioButton) this.findViewById(R.id.radioFem);

        switch(v.getId()) {
            case R.id.radioMasc:
                if (checked)
                    rFem.setChecked(false);
                break;
            case R.id.radioFem:
                if (checked)
                    rMasc.setChecked(false);
                break;
        }
    }

}
