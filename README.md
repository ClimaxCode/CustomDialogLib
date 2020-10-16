**Custom Dialog Library for Rating the App:**

Supported features:
defining custom dialog's title, description and icon
custom rating scope (number of stars)
provide overrided method for cancel and submit button

**Screen Shots:**



**Getting started:**

**Integration:**

**Step 1:**
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 ** Step 2: **
  Add the dependency
  implementation 'com.github.ClimaxCode:CustomDialogLib:0.1.0'


**Setup and create dialog:**

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

LICENSE:

 GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.

                            Preamble

  The GNU General Public License is a free, copyleft license for
software and other kinds of works.

  The licenses for most software and other practical works are designed
to take away your freedom to share and change the works.  By contrast,
the GNU General Public License is intended to guarantee your freedom to
share and change all versions of a program--to make sure it remains free
software for all its users.  We, the Free Software Foundation, use the
GNU General Public License for most of our software; it applies also to
any other work released this way by its authors.  You can apply it to
your programs, too.
