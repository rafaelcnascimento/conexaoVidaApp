package com.example.ogn.conexaovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class mainActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doar(View V) {

        Toast.makeText(mainActivity.this, "Agradeçemos a sua doação", Toast.LENGTH_SHORT).show();
    }

}
