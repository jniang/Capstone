package com.example.jenniferniang.karatetournament_app.fragment;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.jenniferniang.karatetournament_app.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterEditFrag extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener  {

  private String mUserName, mLastName, mFirstName, mRole, mAge, mGender, mCity, mCountry,
          mZipCode, mWeight, mExperience, mClubID, mInstructorName;

  private EditText mEtUserName, mEtLastName, mEtFirstName, mEtRole, mEtAge, mEtGender, mEtCity, mEtCountry,
          mEtZipCode, mEtWeight, mEtExperience, mEtClubID, mEtInstructorName;

  private Button mBtUpdate, mBtnCountry;
  private ImageButton mBtPicture;
  private RadioGroup rgGender;
  private RadioButton rbGender;
  private Spinner spRole, spClub, spExperience;

  static final int REQUEST_IMAGE_CAPTURE = 1;

    //private DatabaseReference mDbUsers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_register_edit, container, false);


        //mDbUsers = FirebaseDatabase.getInstance().getReference().child("Users").child(User.getUUID());

        // Find view elements from layout
        mEtUserName = (EditText) view.findViewById(R.id.et_userName);
        mEtLastName = (EditText) view.findViewById(R.id.et_lastName);
        mEtFirstName = (EditText) view.findViewById(R.id.et_firstName);
        mEtAge = (EditText) view.findViewById(R.id.et_age);
        mEtCity = (EditText) view.findViewById(R.id.et_city);
        mEtZipCode = (EditText) view.findViewById(R.id.et_zipCode);
        mEtWeight = (EditText) view.findViewById(R.id.et_weight);
        mEtInstructorName = (EditText) view.findViewById(R.id.et_instructorName);

        rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);
        rbGender = (RadioButton) view.findViewById(rgGender.getCheckedRadioButtonId());
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rbGender = (RadioButton) view.findViewById(checkedId);
            }
        });


        mBtUpdate = (Button) view.findViewById(R.id.bt_update_register);
        mBtUpdate.setOnClickListener(this);

        mBtnCountry = (Button) view.findViewById(R.id.btn_country);
        mBtnCountry.setOnClickListener(this);

        mBtPicture = (ImageButton) view.findViewById(R.id.bt_edit_user_picture);
        mBtPicture.setOnClickListener(this);

        spClub = (Spinner) view.findViewById(R.id.spinner_clubID);

        spRole = (Spinner) view.findViewById(R.id.spinner_role);
        ArrayAdapter<CharSequence> roleAdapter = ArrayAdapter.createFromResource(getContext(),R.array.roles
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spRole.setAdapter(roleAdapter);

        spExperience = (Spinner) view.findViewById(R.id.spinner_experience);
        ArrayAdapter<CharSequence> experienceAdapter = ArrayAdapter.createFromResource(getContext(),R.array.experience
                ,android.R.layout.simple_spinner_item);
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExperience.setAdapter(experienceAdapter);

        spClub = (Spinner) view.findViewById(R.id.spinner_clubID);
        ArrayAdapter<CharSequence> clubAdapter = ArrayAdapter.createFromResource(getContext(),R.array.clubID
                ,android.R.layout.simple_spinner_item);
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClub.setAdapter(clubAdapter);


        // Init the profile data received from ProfileFrag
        //InitProfileData();


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

//            case R.id.bt_edit_user_picture: {
//                dispatchTakePictureIntent();
//                break;
//            }

//            case R.id.btn_country: {
//                selectCountry();
//                break;
//            }

            case R.id.bt_update_register: {
                // Check valid data entered
                if (!isValidData()) {
                    break;
                } else {
                    // Show updated success info
                    Toast toast = Toast.makeText(getActivity(),
                            "Updated Register Success!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();

                    // Update User Register
                    //updateRegister();

                    // Route to RegisterFrag
                    getFragmentManager().popBackStackImmediate();
                }
            }
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private boolean isValidData() {
        if (mUserName.matches("") || mLastName.matches("")
                || mFirstName.matches("") || mAge.matches("")
                || mRole.matches("") || mGender.matches("")
                || mCity.matches("") || mCountry.matches("")
                || mZipCode.matches("") || mExperience.matches("")
                || mWeight.matches("") || mClubID.matches("")
                || mInstructorName.matches("")) {
            Toast toast = Toast.makeText(getActivity(),
                    "Invalid Data Entered", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return false;
        }

        return true;
    }

//    private void selectCountry() {
//        final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
//        picker.show(getActivity().getSupportFragmentManager(), "COUNTRY_PICKER");
//        picker.setListener(new CountryPickerListener() {
//            @Override
//            public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
//                mNation = name;
//                mBtnCountry.setBackgroundResource(flagDrawableResID);
//                // Toast.makeText(getActivity(), mNation, Toast.LENGTH_SHORT).show();
//                picker.dismiss();
//            }
//        });
//    }
//
//    private File createImageFile() throws IOException {
//        // Create the profile image file name.
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK){
//            mRegistePic = getView().findViewById(R.id.iv_register_pic);
//            mRegisterPic.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));
//        }
//    }
//
//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.example.jenniferniang.karatetournament_app", photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }
//        }
//    }
}
