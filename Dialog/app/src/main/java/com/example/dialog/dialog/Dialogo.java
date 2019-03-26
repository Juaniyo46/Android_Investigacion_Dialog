package com.example.dialog.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class Dialogo extends DialogFragment {

    public static final String TAG = "EjemploDeDialogo";
    public static final String MESSAGE = "MensageDelDialogo";//Constante creada para compartir información.

    public interface OnDialogListener{
        void OnPositiveButtonClicked();
        void OnNegativeButtonClicked();
        void OnNeutralButtonClicked();
    }

    private OnDialogListener onDialogListener;

    private String message;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onDialogListener = (OnDialogListener) getActivity();

        //Esto se mostrara si el texto que recibe del bondle de mainActivity no llega correctamente.
        message = getArguments().getString(MESSAGE,"Algo ocurrió mal");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Título")
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogListener.OnPositiveButtonClicked();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogListener.OnNegativeButtonClicked();
                    }
                })
                .setNeutralButton("Mas tarde", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogListener.OnNeutralButtonClicked();
                    }
                });

        return builder.create();
    }
}
