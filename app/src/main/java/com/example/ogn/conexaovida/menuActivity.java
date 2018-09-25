package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulogando, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.dados:
                //
                break;
            case R.id.sobre:
                Intent intent2 = new Intent(this, sobreActivity.class);

                intent2.putExtra("com.example.ogn.conexaovida.MAE","menu");

                startActivity(intent2);
                break;
            case R.id.doacoes:
                //
                break;
            case R.id.pedido:
                //
                break;
            case R.id.logout:
                Intent intent5 = new Intent(this, homeActivity.class);

                startActivity(intent5);
                break;
        }
        return true;
    }

}