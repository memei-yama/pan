//山﨑里沙,2022/12/14
//新規登録するプログラム
package com.example.foodmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    //変数の定義
    private EditText person_name;
    private EditText mail_address;
    private EditText postal_address;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_account);

        person_name = (EditText) findViewById(R.id.editTextTextPersonName);//ユーザ名
        mail_address = (EditText) findViewById(R.id.editTextTextEmailAddress);//メールアドレス
        postal_address = (EditText) findViewById(R.id.editTextTextPostalAddress);//住所
        password = (EditText) findViewById(R.id.editTextTextPassword);//パスワード

        findViewById(R.id.button3).setOnClickListener(this);//登録ボタン
        findViewById(R.id.button4).setOnClickListener(this);//キャンセルボタン

    }

    @Override
    public void onClick(View v) {
        Intent cancel = new Intent(this, MainActivity.class);
        Intent register = new Intent(this, SignUp.class);

        if (v.getId() == R.id.button) {
            startActivity(login);
        } else if (v.getId() == R.id.button2) {
            startActivity(register);
        }
    }
}
