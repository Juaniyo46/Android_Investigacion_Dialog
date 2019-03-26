package com.example.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialog.dialog.Dialogo;
import com.example.dialog.dialog.MultiplechoiseDialog;
import com.example.dialog.dialog.Personalizado;
import com.example.dialog.dialog.SelecttableDialog;
import com.example.dialog.dialog.SinglechoiceDialog;

public class MainActivity extends AppCompatActivity implements Dialogo.OnDialogListener  {

    Button mostrar;
    Button lista1;
    Button lista2;
    Button lista3;
    Button dialogPers;
    Button dialogoSimple;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;


        mostrar = findViewById(R.id.mostrar);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(v);
            }
        });

        lista1 = findViewById(R.id.lista1);

        lista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListDialog(v);
            }
        });

        lista2 = findViewById(R.id.lista2);

        lista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListSelectDialog(v);
            }
        });

        lista3 = findViewById(R.id.lista3);

        lista3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListUniqueSelectDialog(v);
            }
        });

        dialogPers = findViewById(R.id.DialogoPers);
        dialogPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPersonalDialog(v);
            }
        });

        dialogoSimple = findViewById(R.id.DialogoSimple);
        dialogoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogoSimple(v);
            }
        });

    }

    public void showDialogoSimple(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("Título del Dialog");

        builder.setMessage("¿Quieres cerrar la aplicación?");

        builder.setCancelable(false);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, "ACEPTADO", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(context, "NEGACIÓN", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        //Creacion del dialogo
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void ShowPersonalDialog(View view) {
        DialogFragment dialogFragment = new Personalizado();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }



    public void ShowDialog(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(Dialogo.TAG);

        if (fragment == null) {
            fragment = new Dialogo();

            //Con esto se le envia el texto al fragmento.
            Bundle bundle = new Bundle();
            bundle.putString(Dialogo.MESSAGE,"Esto es un mensaje");

            fragment.setArguments(bundle);
        }


        fragment.show(getSupportFragmentManager(), Dialogo.TAG); //Con el tag evitamos que cuando haya cambios por ejemplo en la orientación esta se vuelva a crear.
    }

    public void ShowListDialog(View view) {
        DialogFragment dialogFragment = new SelecttableDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void ShowListSelectDialog(View view) {
        DialogFragment dialogFragment = new MultiplechoiseDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void ShowListUniqueSelectDialog(View view) {
        DialogFragment dialogFragment = new SinglechoiceDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }


    //Esto es la implementación de la interfaz creada en Dialogo. Es otra forma de darle funcionalidad a los botones.

    @Override
    public void OnPositiveButtonClicked() {
        Toast.makeText(this, "Botón positivo pulsado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNegativeButtonClicked() {
        Toast.makeText(this, "Botón negativo pulsado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNeutralButtonClicked() {
        Toast.makeText(this, "Botón neutral pulsado", Toast.LENGTH_SHORT).show();
    }
}
