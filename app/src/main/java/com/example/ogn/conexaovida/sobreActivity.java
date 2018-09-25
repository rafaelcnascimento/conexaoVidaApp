package com.example.ogn.conexaovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class sobreActivity extends menuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Intent intent = getIntent();
        String activityMae = intent.getStringExtra("com.example.ogn.conexaovida.MAE");

        if (activityMae.equals("menu")) {
            getMenuInflater().inflate(R.menu.menulogando, menu);
            return true;
        } else {
            return false;
        }
        
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.dados:
//                Intent intent1 = new Intent(this, dadosActivity.class);
//
//                startActivity(intent1);
//                break;
//            case R.id.sobre:
//                Intent intent2 = new Intent(this, sobreActivity.class);
//
//                intent2.putExtra("com.example.ogn.conexaovida.MAE","menu");
//
//                startActivity(intent2);
//                break;
//            case R.id.doacoes:
//                Intent intent3 = new Intent(this, doacoesActivity.class);
//
//                startActivity(intent3);
//                break;
//            case R.id.pedido:
//                Intent intent4 = new Intent(this, pedidoActivity.class);
//
//                startActivity(intent4);
//                break;
//            case R.id.logout:
//                Intent intent5 = new Intent(this, homeActivity.class);
//
//                startActivity(intent5);
//                break;
//        }
//        return true;
//    }
}
