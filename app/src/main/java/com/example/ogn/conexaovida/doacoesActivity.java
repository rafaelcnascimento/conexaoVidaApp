package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class doacoesActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacoes);

    }

    public void detalhes(View V) {

        Intent intent = new Intent(this, detalhesActivity.class);

        startActivity(intent);

    }
}
