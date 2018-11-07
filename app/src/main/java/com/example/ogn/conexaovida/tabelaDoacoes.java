package com.example.ogn.conexaovida;

import com.example.ogn.conexaovida.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class tabelaDoacoes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tabelad, container, false);

    }

    public void setDados(String nome, String sangue, String id) {
        TextView tv1 = (TextView)  getView().findViewById(R.id.textView1);
        tv1.setText(nome);

        TextView tv2 = (TextView)  getView().findViewById(R.id.textView2);
        tv2.setText(sangue);

        Button botao = (Button) getView().findViewById(R.id.button1);
        botao.setTag("1");
    }

    public String getPedidoId(){
        Button botao = (Button) getView().findViewById(R.id.button1);

        return botao.getTag().toString();
    }
}
