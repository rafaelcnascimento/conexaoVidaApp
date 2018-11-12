package com.example.ogn.conexaovida;

import android.content.Context;
import android.widget.Toast;

public class validar {

    public static boolean cadastroUser(Context context, String nome, String email, String telefone,
                                       String cidade, String password, String confirmarPassword)
    {
       if (nome.equals("") || email.equals("") || telefone.equals("") ||
                cidade.equals("") || password.equals("") || confirmarPassword.equals("")){
           Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

           return false;
       } else
           return  true;
    }
}
