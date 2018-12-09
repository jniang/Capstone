package com.example.jenniferniang.karatetournament_app.fragment;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.jenniferniang.karatetournament_app.BuildConfig;
import com.example.jenniferniang.karatetournament_app.R;
import com.example.jenniferniang.karatetournament_app.activity.HomeActivity;
import com.example.jenniferniang.karatetournament_app.general.User;


public class RegisterEnterFrag extends Fragment
            implements View.OnClickListener, AdapterView.OnItemSelectedListener {

        // debug flag
        private boolean debug = false;

        // Define User Register info
        private String mUserName, mLastName, mFirstName, mRole, mAge, mGender, mCity, mCountry, mZipCode, mWeight, mExperience,
                mClubID, mIntructorName, mEvent, mCurrentPhotoPath;


        // Profile JSON data
        private String profileJSon;

        // Define UI view elements
        private EditText etUserName, etLastName, etFirstName, etAge, etCity, etZipCode, etWeight, etExperience;
        private EditText etClubID, etInstructorName, etEvent;
        private RadioGroup rgGender;
        private RadioButton rbGender;
        private Button mButtonCreate, mBtnCountry;
        private ImageButton mButtonPicture;
        private ImageView mProfilePic; // Profile pic collection parameters and resources.
        private ImageView mCoverImg;


        static final int REQUEST_IMAGE_CAPTURE = 1;

        private User mUser = User.getInstance();

        //private DatabaseReference mDatabase;

        public RegisterEnterFrag(){
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            final View view = inflater.inflate(R.layout.fragment_register_enter, container, false);

            // Find view elements from layout

            etUserName = view.findViewById(R.id.et_userName);
            etLastName = view.findViewById(R.id.et_lastName);
            etFirstName = view.findViewById(R.id.et_firstName);
            etAge = view.findViewById(R.id.et_age);
            etUserName = view.findViewById(R.id.et_userName);
            etCity = view.findViewById(R.id.et_city);
            etWeight = view.findViewById(R.id.et_weight);

            // Radio Group Buttons
            rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);
            rbGender = (RadioButton) view.findViewById(rgGender.getCheckedRadioButtonId());
            rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    rbGender = (RadioButton) view.findViewById(checkedId);
                }
            });

            //Drop Down Button from layout
            mBtnCountry = view.findViewById(R.id.btn_country);
            mBtnCountry.setOnClickListener(this);


            mButtonCreate = view.findViewById(R.id.button_get_started);
            mButtonCreate.setOnClickListener(this);

            mButtonPicture = view.findViewById(R.id.button_get_user_picture);
            mButtonPicture.setOnClickListener(this);

            //TODO: change to getActivity () and move back the spinner code


            return view;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


        /** Handles the profile picture getter and user creation buttons.
         *
         * @param view the current view.
         */
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.button_get_user_picture: {
                    dispatchTakePictureIntent();
                    break;
                }

                /*case R.id.btn_country: {
                    selectCountry();
                    break;
                }

                case R.id.next: {
                    // Check valid data entered
                    if (isValidData()) {
                        // Set the user profile
                        setUserProfile();
                        mListener.onFloatingButtonClicked();
                    }
                    break;
                }
                */

                case R.id.button_get_started: {
                    // Check valid data entered
                    System.out.println("clicked");
                    Toast.makeText(getActivity(), "get started button clicked.", Toast.LENGTH_SHORT);
                    startActivity(new Intent(this.getActivity(), HomeActivity.class));
//                    if (isValidData()) {
//                        // Set the user profile
//                        setUserProfile();
////                        mListener.onFloatingButtonClicked();
//                        startActivity(new Intent(getActivity(), HomeActivity.class));
//                    }
                    break;
                }
            }
        }

        private void setUserRegister() {
            mUser.setUserName(mUserName);
            mUser.setFirstName(mFirstName);
            mUser.setLastName(mLastName);
            mUser.setDelegRole(mRole);
            mUser.setAge(mAge);
            mUser.setGender(mGender);
            mUser.setCity(mCity);
            mUser.setCountry(mCountry);
            mUser.setZipCode(mZipCode);
            mUser.setWeight(mWeight);
            mUser.setExperience(mExperience);
            mUser.setClubID(mClubID);
            mUser.setInstructorLastName(mIntructorName);


            mUser.setRegisterPic(mCurrentPhotoPath);




            // Insert profile data into database
            //mDatabase.child("Users").child(User.getUUID()).setValue(mUser);

            // Load user info to Json data
           // profileJSon = JSONProfileUtils.toProfileJSonData(mUser);
        }

        private boolean isValidData() {
            if ((mUserName = etUserName.getText().toString()).matches("")
                    || (mLastName = etLastName.getText().toString()).matches("")
                    || (mFirstName = etFirstName.getText().toString()).matches("")
                    || (mRole == null)
                    || (mRole.matches(""))
                    || (mAge = etAge.getText().toString()).matches("")
                    || (mCity = etCity.getText().toString()).matches("")
                    || (mAge = etAge.getText().toString()).matches("")
                    || (mCountry == null)
                    || (mCountry.matches(""))
                    || (mZipCode = etZipCode.getText().toString()).matches("")
                    || (mWeight = etWeight.getText().toString()).matches("")
                    || (rbGender == null)
                    || (mGender = rbGender.getText().toString()).matches("")
                    || (mExperience == null)
                    || (mExperience.matches(""))
                    || (mClubID == null)
                    || (mClubID.matches(""))
                    || (mEvent == null)
                    || (mEvent.matches(""))
                    || (mIntructorName = etInstructorName.getText().toString()).matches("")) {
                if (BuildConfig.DEBUG) {
                    Log.v("ValidDataCheck", "Detect Invalid Profile Data");
                }
                Toast toast = Toast.makeText(getActivity(),
                        "Invalid data entered", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                return false;
            }

            return true;
        }


        //TODO: Code for Country but need to import library!!!!
       /* private void selectCountry() {
            final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
            picker.show(getActivity().getSupportFragmentManager(), "COUNTRY_PICKER");
            picker.setListener(new CountryPickerListener() {
                @Override
                public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                    mNation = name;
                    mBtnCountry.setBackgroundResource(flagDrawableResID);
                    // Toast.makeText(getActivity(), mCountry, Toast.LENGTH_SHORT).show();
                    picker.dismiss();
                }
            });
        }
        */



        /**
         * Helper function stores the image to a file.
         *
         * @return
         * @throws IOException
         */
        private File createImageFile() throws IOException {
            // Create the profile image file name.
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(imageFileName,".jpg", storageDir);
            mCurrentPhotoPath = image.getAbsolutePath();
            return image;
        }

        /**
         * Captures the image returned from the camera intent, and stores it as the users new profile
         * picture.
         *
         * @param requestCode
         * @param resultCode
         * @param data
         */
        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK){
                mProfilePic = getActivity().findViewById(R.id.iv_profile_pic);
                mProfilePic.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));
            }
        }

        /**
         * Stores the picture taken in the intent to a file for future use.
         */
        private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Ensure that there's a camera activity to handle the intent
            if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {

                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.example.jenniferniang.karatetournament_app", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        }

    public interface OnFloatingButtonClickListener {
        void onFloatingButtonClicked();
    }
}


