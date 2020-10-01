package com.example.customdialoglib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialoglib.MyCustomDialog;
import com.example.dialoglib.DialogClickListener;

public class MainActivity extends AppCompatActivity implements DialogClickListener {

    private MyCustomDialog dialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new MyCustomDialog(this,this);

        showDialog = findViewById(R.id.dialogBtn);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        //CustomDialog.s(getApplicationContext(),"welcome to library project");
       // dialog.setTitle("ClimaxCode");
       // dialog.setDescription("Please give us ratings");
       // dialog.setIcon(R.drawable.ic_launcher_background);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okBtn:
                Toast.makeText(getApplicationContext(), "submit rating "+dialog.getRatings(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                //Toast.makeText(getApplicationContext(), "dismiss dialog ", Toast.LENGTH_SHORT).show();
               dialog.cancel();
                break;
        }
    }
}