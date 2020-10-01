CustomDialogLib for Rating:

Supported features:
defining custom dialog's title, description and icon
custom rating scope (number of stars)
provide overrided method for cancel and submit button

Screen Shots:

Getting started:

Integration:

Step 1:
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2: 
  Add the dependency
  implementation 'com.github.ClimaxCode:CustomDialogLib:0.1.0'


Setup and create dialog:

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

        //customization methods
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
