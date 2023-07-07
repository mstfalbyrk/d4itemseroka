package com.D4ItemSeroka.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView giris;
    EditText usernametext;
    EditText passwordtext;
    EditText pincodetext;
    EditText phonetext;
    ImageView imageEx;
    Button login;
    CheckBox checkBox;
    Spinner spinner;
    ArrayAdapter adapter;
    TextClock textClock;
    EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giris = (TextView) findViewById(R.id.girisAlani);
        usernametext = (EditText) findViewById(R.id.usernametext);
        usernametext.addTextChangedListener(textWatcher);
        passwordtext = (EditText) findViewById(R.id.passwordtext);
        passwordtext.addTextChangedListener(textWatcher);
        pincodetext = (EditText) findViewById(R.id.pincodetext);
        pincodetext.addTextChangedListener(textWatcher);
        phonetext = (EditText) findViewById(R.id.phonetext);
        imageEx = (ImageView) findViewById(R.id.imageEx);
        login = (Button) findViewById(R.id.loginbutton);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        spinner = (Spinner) findViewById(R.id.spinnerbox);
        textClock = (TextClock) findViewById(R.id.teClock);
        date = (EditText) findViewById(R.id.editTextDate);

        adapter = ArrayAdapter.createFromResource(this, R.array.languages,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String language = adapterView.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), language, Toast.LENGTH_SHORT);

                if (i == 1) {
                    giris.setText("D4 Eşya İşaretleyici");
                    giris.setTextColor(Color.parseColor("#930101"));
                    usernametext.setHint("Kullanıcı Adı*");
                    usernametext.setTextColor(Color.parseColor("#FFFFFF"));
                    passwordtext.setHint("Şifre*");
                    passwordtext.setTextColor(Color.parseColor("#FFFFFF"));
                    pincodetext.setHint("Pin kodu*");
                    pincodetext.setTextColor(Color.parseColor("#FFFFFF"));
                    phonetext.setHint("Telefon numarası");
                    phonetext.setTextColor(Color.parseColor("#FFFFFF"));
                    checkBox.setText("Şartları okudum. Kabul ediyorum.");
                    checkBox.setTextColor(Color.parseColor("#FFFFFF"));
                    login.setText("Giriş");
                }else if(i==0){
                    giris.setText("D4 Item Checker");
                    giris.setTextColor(Color.parseColor("#930101"));
                    usernametext.setHint("Username*");
                    usernametext.setTextColor(Color.parseColor("#FFFFFF"));
                    passwordtext.setHint("Password*");
                    passwordtext.setTextColor(Color.parseColor("#FFFFFF"));
                    pincodetext.setHint("Pin code*");
                    pincodetext.setTextColor(Color.parseColor("#FFFFFF"));
                    phonetext.setHint("Phone number");
                    phonetext.setTextColor(Color.parseColor("#FFFFFF"));
                    checkBox.setText("Read and accept the terms.");
                    checkBox.setTextColor(Color.parseColor("#FFFFFF"));
                    login.setText("Login");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    login.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String text1 = usernametext.getText().toString().trim();
            String text2 = passwordtext.getText().toString().trim();
            String text3 = pincodetext.getText().toString().trim();
            checkBox.setEnabled(!text1.isEmpty() && !text2.isEmpty() && !text3.isEmpty());
            checkBox.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}