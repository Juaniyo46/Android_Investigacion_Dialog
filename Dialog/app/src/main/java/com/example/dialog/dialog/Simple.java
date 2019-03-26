package com.example.dialog.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.dialog.MainActivity;

public class Simple extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Dialogo sin Fragment");
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aceptar();
            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelar();
            }
        });
        dialogo.show();
    }

    public void aceptar() {
        Toast.makeText(this, "ACEPTADO", Toast.LENGTH_SHORT).show();
    }

    public void cancelar(){
        Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
    }
}



