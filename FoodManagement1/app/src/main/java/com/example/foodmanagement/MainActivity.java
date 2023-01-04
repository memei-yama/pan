//山﨑里沙,2022/12/14
//初期画面からログイン画面と新規登録画面に遷移することができるプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttonはログイン,button2は新規登録
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }

    //ボタンを押下したら新規登録かログイン画面に遷移する
    @Override
    public void onClick(View v) {
        Intent login = new Intent(this, Account.class);
        Intent register = new Intent(this, SignUp.class);

        if (v.getId() == R.id.button) {
            startActivity(login);
        } else if (v.getId() == R.id.button2) {
            startActivity(register);
        }
    }
}