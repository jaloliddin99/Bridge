package com.jaloliddinabdullaevv.bridge.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;


import com.github.willena.phoneinputview.CountryConfigurator;
import com.github.willena.phoneinputview.PhoneInputView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.MainActivity;
import com.jaloliddinabdullaevv.bridge.R;
import com.jaloliddinabdullaevv.bridge.StartActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Fragment3 extends Fragment {


    EditText emailAddress, passwordEmail;
    View view;
    EditText name, age;
    MaterialAutoCompleteTextView materialAutoCompleteTextView;

    PhoneInputView phoneView;
    MaterialButton registerButton, loginButton;
    TextView switcherReg, switcherLog;

    ScrollView loginScrollView, registerScrollView;

    EditText loginEmail, loginPassword;

    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.layout_register, container, false);
        phoneView = (PhoneInputView) view.findViewById(R.id.phoneId);
        emailAddress=(EditText) view.findViewById(R.id.email);
        passwordEmail=(EditText) view.findViewById(R.id.passwordEmail);
        name=(EditText) view.findViewById(R.id.name);
        age=view.findViewById(R.id.numPicker);
        switcherReg=view.findViewById(R.id.login);
        switcherLog=view.findViewById(R.id.loginSwitcher);

        registerButton=(MaterialButton) view.findViewById(R.id.register);
        loginButton=(MaterialButton) view.findViewById(R.id.loginButton);
        loginScrollView=(ScrollView) view.findViewById(R.id.loginScrollView);
        registerScrollView=(ScrollView) view.findViewById(R.id.registerScrollView);

        loginEmail=(EditText) view.findViewById(R.id.loginEmail);
        loginPassword=(EditText) view.findViewById(R.id.loginPassword);

        FirebaseApp.initializeApp(view.getContext());


        materialAutoCompleteTextView=(MaterialAutoCompleteTextView) view.findViewById(R.id.filled_exposed_dropdown);

        switcherReg.setOnClickListener(v -> {
            registerScrollView.setVisibility(View.GONE);
            loginScrollView.setVisibility(View.VISIBLE);
        });
        switcherLog.setOnClickListener(v -> {
            loginScrollView.setVisibility(View.GONE);
            registerScrollView.setVisibility(View.VISIBLE);

        });

        ArrayList<String> regions=new ArrayList<>();
        regions.add("Jizzax");
        regions.add("Samarqand");
        regions.add("Sirdaryo");
        regions.add("Buxoro");
        regions.add("Qashqadaryo");
        regions.add("Surxondaryo");
        regions.add("Navoiy");
        regions.add("Xoraxm");
        regions.add("Qoraqalpog'iston");
        regions.add("Toshkent");
        regions.add("Namangan");
        regions.add("Farg'ona");
        regions.add("Andijon");
        regions.add("Boshqa davlat");
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapter=new ArrayAdapter(view.getContext(), R.layout.dropdown_item ,regions);
        materialAutoCompleteTextView.setAdapter(arrayAdapter);
        materialAutoCompleteTextView.setSelection(0);




        CountryConfigurator config = new CountryConfigurator();
        config.setDisplayFlag(true);
        config.setDisplayCountryCode(true);
        config.setDisplayDialingCode(true);
        config.setPhoneNumberHintType(CountryConfigurator.HintType.NONE);
        config.setDefaultCountry("UZ");


        loginButton.setOnClickListener(v -> {
            loginToMyAccount();
        });

        registerButton.setOnClickListener(v -> {
            checkData();
            hideKeyboard(((Activity)view.getContext()));
        });

        return view;
    }

    private void loginToMyAccount() {
        String email, password;
        if (loginEmail.getText().toString().isEmpty()){
            loginEmail.setError("emailni kiriting!!!");
            return;
        }else {
            email=loginEmail.getText().toString();
        }
        if (loginPassword.getText().toString().isEmpty()){
            loginPassword.setError("parolni kiriting!!!");
            return;
        }else {
            password=loginPassword.getText().toString();
        }




        StartActivity.mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity)view.getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            editor.putBoolean("key_name1", false);
                            editor.apply();
                            Intent intent=new Intent(view.getContext(), MainActivity.class);
                            view.getContext().startActivity(intent);
                            ((Activity)view.getContext()).finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Ogohlantirish")
                                    .setContentText("email, yoki parol xato, iltimos qayta ununing!")
                                    .setConfirmText("hop, bajaraman!")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                        }
                    }
                });
    }

    private void checkData() {
        String firstName, phone, age1, region, email, password;
        firstName=name.getText().toString().trim();
        phone=phoneView.getFormatedNumber();
        age1=String.valueOf(age.getText());

        if (emailAddress.getText().toString().isEmpty()){
            emailAddress.setError("email kiriting!!!");
            return;
        }else {
            email=emailAddress.getText().toString();
        }

        if (passwordEmail.getText().toString().isEmpty()){
            passwordEmail.setError("parol kiriting!!!");
            return;
        }else {
            password=passwordEmail.getText().toString();
        }

        if (materialAutoCompleteTextView.getText().toString().isEmpty()){
            materialAutoCompleteTextView.setError("hududni tanlang!!!");
            return;
        }else {
            region=materialAutoCompleteTextView.getText().toString();
        }



        if (name.getText().toString().trim().isEmpty()){
            name.setError("Ismingizni kiriting!!!");
            return;
        }else if (passwordEmail.getText().length()<6){
            passwordEmail.setError("parol kamida 6 harf bolishi kerak!!!");
            return;
        }else if (!emailAddress.getText().toString().contains("@")||!emailAddress.getText().toString().contains(".")){
            emailAddress.setError("xato email!!!");
            return;
        }


        if (phone==null){
            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Ogohlantirish")
                    .setContentText("Telefon raqam kiritmadingiz, raqamingizsiz dasturga kira olmaysiz!")
                    .setConfirmText("hop, kiritaman!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
            return;
        }
        phone=phone.replace(" ", "");

        createAccount(email, password, firstName, age1, region, phone);

    }

    private void createAccount(String email, String password, String firstName, String age, String region, String phone) {
        StartActivity.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Log.i("first name ", ""+firstName);
                Log.i("first name region", ""+region);
                Log.i("first name phone", ""+phone);
                Log.i("first name age", ""+age);

                saveItFirebase(firstName, region, phone, age);
            }else if (task.isCanceled()){
                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Ogohlantirish")
                        .setContentText("Malumot Saqlanmadi, internetni yoqib qayta uruning!")
                        .setConfirmText("hop, bajaraman!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
    }

    private void saveItFirebase(String name,String region, String phone, String age) {

        SweetAlertDialog pDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        FirebaseUser user = StartActivity.mAuth.getCurrentUser();


        FirebaseDatabase database = FirebaseDatabase.getInstance(Common.DB_LINK);
        DatabaseReference myRef = database.getReference().child("UserInfo").child(user.getUid());

        Map<String, Object> userDetail=new HashMap<String, Object>();
        userDetail.put("phoneNumber", phone);
        userDetail.put("name", name.replace(" ", "_"));
        userDetail.put("birthDay", age);
        userDetail.put("region", region);
        userDetail.put("lastSeenTime", "online");
        userDetail.put("inWhichPart", "hali bowlamadi");


        myRef.updateChildren(userDetail).addOnCompleteListener((OnCompleteListener<Void>) task -> {
            pDialog.dismissWithAnimation();
            editor.putBoolean("key_name1", false);
            editor.apply();
            Intent intent=new Intent(view.getContext(), MainActivity.class);
            view.getContext().startActivity(intent);
            ((Activity)view.getContext()).finish();

        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
