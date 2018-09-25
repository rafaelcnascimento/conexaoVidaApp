package com.example.ogn.conexaovida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class doacoesActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacoes);

        tabelaDoacoes t1 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment);
        t1.setDados("Jair Bolsonaro","O+");

        tabelaDoacoes t2 = (tabelaDoacoes) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        t2.setDados("Alexei Nikolaevich","AB-");

    }


    public void detalhes(View V) {

        Intent intent = new Intent(this, detalhesActivity.class);

        startActivity(intent);

    }
}
