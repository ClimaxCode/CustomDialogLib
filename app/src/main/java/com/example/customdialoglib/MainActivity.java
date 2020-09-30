package com.example.customdialoglib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialoglib.MyCustomDialog;
import com.example.dialoglib.DialogClickListener;

public class MainActivity extends AppCompatActivity implements DialogClickListener {

    Button ok,cancel;
    MyCustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CustomDialog.s(getApplicationContext(),"welcome to library project");
        dialog = new MyCustomDialog(this,this);
       // dialog.setTitle("ClimaxCode");
       // dialog.setDescription("Please give us ratings");
       // dialog.setIcon(R.drawable.ic_launcher_background);
        dialog.show();
        //setContentView(v);

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