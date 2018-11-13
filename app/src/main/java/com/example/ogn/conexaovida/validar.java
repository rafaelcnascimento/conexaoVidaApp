package com.example.ogn.conexaovida;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class validar {

    public static boolean cadastroUser(Context c, String nome, String email, String telefone,
                                       String cidade, String password, String confirmarPassword) {
        //Checa se é nulo
        if (nome.equals("") || email.equals("") || telefone.equals("") ||
                cidade.equals("") || password.equals("") || confirmarPassword.equals("")) {
            Toast.makeText(c, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

            return false;
            //Checa se as senhas batem
        } else if (!password.equals(confirmarPassword)) {
            Toast.makeText(c, "As senhas informadas não são iguais", Toast.LENGTH_SHORT).show();

            return false;
            //Checa o tamanho dos campos
        } else if (!validar.size(c, "nome", nome, 1, 100) || !validar.size(c, "email", email, 1, 100) ||
                !validar.size(c, "telefone", telefone, 10, 11) || !validar.size(c, "cidade", cidade, 1, 100) ||
                !validar.size(c, "senha", password, 6, 20)
                ) {

            return false;

            //Valida nome
        } else if (!nome.matches("/^[a-zA-Z]+$/")) {
            Toast.makeText(c, "O campo nome possui caractres invalidos", Toast.LENGTH_SHORT).show();

            return false;
        }

        else if (!cidade.matches("/^[a-zA-Z]+$/")) {
            Toast.makeText(c, "O campo cidade possui caractres invalidos", Toast.LENGTH_SHORT).show();

            return false;
        }

        else
            return true;
    }

    public static boolean size(Context c, String nome, String campo, int min, int max) {

        if (campo.length() > max) {
            Toast.makeText(c, "O campo " + nome + " deve conter menos de " + max + " caracteres", Toast.LENGTH_SHORT).show();

            return false;
        } else if (campo.length() < min) {
            Toast.makeText(c, "O campo " + nome + " deve conter mais de " + min + " caracteres", Toast.LENGTH_SHORT).show();

            return false;
        } else {
            return true;
        }

    }


}
