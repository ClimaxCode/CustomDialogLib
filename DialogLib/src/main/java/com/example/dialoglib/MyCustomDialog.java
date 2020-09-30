package com.example.dialoglib;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomDialog extends Dialog{

    private TextView titleTv, descTv;
    private Context mainContext;
     private DialogClickListener onItemClickListener;
    private ImageView icon;
     private Button ok, cancel;
    private Dialog dialog;
    private RatingBar ratingBar;

    public MyCustomDialog(Context context, DialogClickListener onItemClickListener) {
        super(context);
        mainContext = context;
        this.onItemClickListener = onItemClickListener;
       // initialize(context);
         dialog = new Dialog(context);
        // Include dialog.xml file
        dialog.setContentView(R.layout.layout);
        // Set dialog title
        //dialog.setTitle("Custom Dialog");

        // set values for custom dialog components - text, image and button
      /*  TextView text = (TextView) dialog.findViewById(R.id.textDialog);
        text.setText("Custom dialog Android example.");
        ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
        image.setImageResource(R.drawable.image0);*/


        titleTv = dialog.findViewById(R.id.title_tv);
        descTv = dialog.findViewById(R.id.desc_tv);
        ratingBar = dialog.findViewById(R.id.ratingBar);
        icon = dialog.findViewById(R.id.dialogIcon);

        ok = dialog.findViewById(R.id.okBtn);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                methodOk(view);
                //ok.setTextColor("");
            }
        });

        cancel = dialog.findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                methodCancel(view);
            }
        });

    }

    public void show()
    {
        dialog.show();
    }

    public void cancel()
    {
        dialog.cancel();
    }

    public void setTitle(String s)
    {
        titleTv.setText(s);
    }

    public void setDescription(String s)
    {
        descTv.setText(s);
    }

    public void setIcon(int res)
    {
        icon.setImageResource(res);
    }

    public float getRatings()
    {
        return ratingBar.getRating();
    }



/*
    public CustomDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
      //  initialize(context);
    }
*/


/*    public static void s(Context c, String message){
        Toast.makeText(c,message, Toast.LENGTH_SHORT).show();
    }*/


    public static void dialogMethod(Context c, String msg)
    {
        Toast.makeText(c,msg, Toast.LENGTH_SHORT).show();
    }

  /*  private void initialize(final Context context){
       View root_view =  inflate(context, R.layout.layout, this);
        titleTv = root_view.findViewById(R.id.title_tv);
        descTv = root_view.findViewById(R.id.desc_tv);

        ok = root_view.findViewById(R.id.okBtn);
        ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                methodOk(view);
            }
        });

        cancel = root_view.findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                methodCancel(view);
            }
        });
    }*/

/*    public static void setTitle(String title)
    {
        titleTv.setText(title);
    }

    public static void setDescription(String desc)
    {
        descTv.setText(desc);
    }*/

    public void methodOk(View v)
    {
        onItemClickListener.onClick(v);
    }

    public void methodCancel(View v)
    {
        onItemClickListener.onClick(v);
    }

   /* public void callMethod(View v)
    {
        onItemClickListener.onClick(v);
    }*/


}
