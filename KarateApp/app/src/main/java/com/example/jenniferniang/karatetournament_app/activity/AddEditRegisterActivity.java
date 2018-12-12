package com.example.jenniferniang.karatetournament_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jenniferniang.karatetournament_app.R;

public class AddEditRegisterActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_ID";
    public static final String EXTRA_USERNAME =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_USERNAME";
    public static final String EXTRA_LASTNAME =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_LASTNAME";
    public static final String EXTRA_FIRSTNAME =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_FIRSTNAME";
    public static final String EXTRA_ROLE =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_ROLE";
    public static final String EXTRA_AGE =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_AGE";
    public static final String EXTRA_GENDER =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_GENDER";
    public static final String EXTRA_CITY =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_CITY";
    public static final String EXTRA_COUNTRY =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_COUNTRY";
    public static final String EXTRA_ZIPCODE =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_ZIPCODE";
    public static final String EXTRA_WEIGHT =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_WEIGHT";
    public static final String EXTRA_EXPERIENCE =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_EXPERIENCE";
    public static final String EXTRA_CLUBID =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_CLUBID";
    public static final String EXTRA_INSTRUCTORLASTNAME =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_INSTRUCOTRLASTNAME";
    public static final String EXTRA_REGISTERPIC =
            "com.example.enniferniang.karatetournament_app.activity.EXTRA_REGISTERPIC";

    private EditText etUserName;
    private EditText etLastName;
    private EditText etFirstName;
    private EditText etDelegRole;
    private EditText etAge;
    private EditText etGender;
    private EditText etCity;
    private EditText etCountry;
    private EditText etZipCode;
    private EditText etWeight;
    private EditText etExperience;
    private EditText etClubID;
    private EditText etInstructorLastName;
    private EditText etRegisterPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_register);

        etUserName = findViewById(R.id.et_userName);
        etLastName = findViewById(R.id.et_lastName);
        etFirstName = findViewById(R.id.et_firstName);
        etDelegRole = findViewById(R.id.et_delegRole);
        etAge = findViewById(R.id.et_age);
        etGender = findViewById(R.id.et_gender);
        etCity = findViewById(R.id.et_city);
        etCountry = findViewById(R.id.et_country);
        etZipCode = findViewById(R.id.et_zipCode);
        etWeight = findViewById(R.id.et_weight);
        etExperience = findViewById(R.id.et_experience);
        etClubID = findViewById(R.id.et_clubID);
        etInstructorLastName = findViewById(R.id.et_instructorName);
        etRegisterPic = findViewById(R.id.et_registerPic);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Register");

            etUserName.setText(intent.getStringExtra(EXTRA_USERNAME));
            etLastName.setText(intent.getStringExtra(EXTRA_LASTNAME));
            etFirstName.setText(intent.getStringExtra(EXTRA_FIRSTNAME));
            etDelegRole.setText(intent.getStringExtra(EXTRA_ROLE));
            etAge.setText(intent.getStringExtra(EXTRA_AGE));
            etGender.setText(intent.getStringExtra(EXTRA_GENDER));
            etCity.setText(intent.getStringExtra(EXTRA_CITY));
            etCountry.setText(intent.getStringExtra(EXTRA_COUNTRY));
            etZipCode.setText(intent.getStringExtra(EXTRA_ZIPCODE));
            etWeight.setText(intent.getStringExtra(EXTRA_WEIGHT));
            etExperience.setText(intent.getStringExtra(EXTRA_EXPERIENCE));
            etClubID.setText(intent.getStringExtra(EXTRA_CLUBID));
            etInstructorLastName.setText(intent.getStringExtra(EXTRA_INSTRUCTORLASTNAME));
            etRegisterPic.setText(intent.getStringExtra(EXTRA_REGISTERPIC));

        } else {
            setTitle("Add Register");
        }
    }

    private void saveRegister() {

        String userName = etUserName.getText().toString();
        String lastName = etLastName.getText().toString();
        String firstName = etFirstName.getText().toString();
        String delegRole = etDelegRole.getText().toString();
        String age = etAge.getText().toString();
        String gender = etGender.getText().toString();
        String city = etCity.getText().toString();
        String country = etCountry.getText().toString();
        String zipCode = etZipCode.getText().toString();
        String weight = etWeight.getText().toString();
        String experience = etExperience.getText().toString();
        String clubID = etClubID.getText().toString();
        String instructorLastName = etInstructorLastName.getText().toString();
        String registerPic = etRegisterPic.getText().toString();


        if (userName.trim().isEmpty() || lastName.trim().isEmpty() || firstName.trim().isEmpty() || delegRole.trim().isEmpty()
                || age.trim().isEmpty() || gender.trim().isEmpty() || city.trim().isEmpty() || country.trim().isEmpty()
                || zipCode.trim().isEmpty() || weight.trim().isEmpty() || experience.trim().isEmpty() || clubID.trim().isEmpty()
                || instructorLastName.trim().isEmpty()|| registerPic.trim().isEmpty()) {
            Toast.makeText(this, "Please insert register information", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_USERNAME, userName);
        data.putExtra(EXTRA_LASTNAME, lastName);
        data.putExtra(EXTRA_FIRSTNAME, firstName);
        data.putExtra(EXTRA_ROLE, delegRole);
        data.putExtra(EXTRA_AGE, age);
        System.out.println("gender: " + gender);
        data.putExtra(EXTRA_GENDER, gender);
        data.putExtra(EXTRA_CITY, city);
        data.putExtra(EXTRA_COUNTRY, country);
        data.putExtra(EXTRA_ZIPCODE, zipCode);
        data.putExtra(EXTRA_WEIGHT, weight);
        data.putExtra(EXTRA_EXPERIENCE, experience);
        data.putExtra(EXTRA_CLUBID, clubID);
        data.putExtra(EXTRA_INSTRUCTORLASTNAME, instructorLastName);
        data.putExtra(EXTRA_REGISTERPIC, registerPic);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_event_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_event:
                saveRegister();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
