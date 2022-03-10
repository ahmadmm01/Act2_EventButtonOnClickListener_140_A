package com.pam.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText et_Email, et_Password;
    String nama, password, emailcheck, passcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignin);
        et_Email = findViewById(R.id.etEmail);
        et_Password = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }
    public void validation(){
        nama = et_Email.getText().toString();
        password = et_Password.getText().toString();
        emailcheck = "ahmadmm@gmail.com";
        passcheck = "maddmm";

        if (nama.isEmpty() && password.isEmpty())
        {
            et_Email.setError("e-mail is required!");
            et_Password.setError("password is required!");
        } else {
            if (nama.equals(emailcheck) && password.equals(passcheck)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Successful Login! Your e-mail : " + nama + "  and Your password : " + password + "", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                b.putString("a", nama.trim());
                b.putString("b", password.trim());

                Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                i.putExtras(b);

                startActivity(i);
            } else if (!nama.equals(emailcheck) && password.equals(passcheck)) {
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct e-mail!", Toast.LENGTH_LONG);
                t.show();
            } else if (nama.equals(emailcheck) && !password.equals(passcheck)) {
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct password!", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct e-mail and password!", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }
}