package com.example.ogn.conexaovida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONException;

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
                    Intent intent1 = new Intent(this, dadosActivity.class);

                    startActivity(intent1);
                    break;
                case R.id.sobre:
                    Intent intent2 = new Intent(this, sobreActivity.class);

                    intent2.putExtra("com.example.ogn.conexaovida.MAE","menu");

                    startActivity(intent2);
                    break;
                case R.id.doacoes:
                    Intent intent3 = new Intent(this, doacoesActivity.class);

                    startActivity(intent3);
                    break;
                case R.id.pedido:
                    Intent intent4 = new Intent(this, pedidoActivity.class);

                    startActivity(intent4);
                    break;
                case R.id.logout:
                    Intent intent5 = new Intent(this, homeActivity.class);

                    Context context = this;

                    try {
                        user.logout(context);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    startActivity(intent5);
                    break;
            }
            return true;
    }

}
