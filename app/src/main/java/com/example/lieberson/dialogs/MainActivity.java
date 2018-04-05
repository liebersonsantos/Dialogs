package com.example.lieberson.dialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnALert;
    private AppCompatButton btnDialogItem;
    private AlertDialog alertDialog;
    private AlertDialog alertDialogItems;

    private String[] items = {"item 1", "item 2", "item 3", "item 4"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnALert = findViewById(R.id.btnAlertId);
        btnDialogItem = findViewById(R.id.btnDialogItemId);


        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog);
        builder.setMessage("Deseja excluir?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Sim", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();

            }
        });

        AlertDialog.Builder builderDialogItems = new AlertDialog.Builder(this);
        builderDialogItems.setTitle("Selecione a opção desejada: ");
//        builderDialogItems.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//
//                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
//
//            }
//        });
        builderDialogItems.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                Toast.makeText(MainActivity.this, items[which] + " : " + isChecked, Toast.LENGTH_SHORT).show();

            }
        });

        builderDialogItems.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
        builderDialogItems.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogItems = builderDialogItems.create();
        alertDialog = builder.create();

        btnALert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.show();

            }
        });

        btnDialogItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialogItems.show();

            }
        });

    }
}
