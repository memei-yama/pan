//山﨑里沙,2022/12/14
//新規登録するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    //変数の定義
    private EditText user_name;
    private EditText user_mail;
    private EditText user_address;
    private EditText user_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_account);

        //ユーザ名
        user_name = (EditText) findViewById(R.id.editTextTextPersonName);
        //メールアドレス
        user_mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        //住所
        user_address = (EditText) findViewById(R.id.editTextTextPostalAddress);
        //パスワード
        user_passwd = (EditText) findViewById(R.id.editTextTextPassword);

        findViewById(R.id.button3).setOnClickListener(this);//登録ボタン
        findViewById(R.id.button4).setOnClickListener(this);//キャンセルボタン

    }

    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent cancel = new Intent(this, MainActivity.class);
        Intent register_ok = new Intent(this, Home.class);
        Intent error = new Intent(this,SignUp.class);

        //登録かキャンセルのボタンを押したとき
        if (v.getId() == R.id.button4) {
            //キャンセルを押したときMainActivity.javaに遷移
            startActivity(cancel);
        } else if (v.getId() == R.id.button3) {
            //入力されたユーザ名を取得する
            String get_user_name = user_name.getText().toString();
            //入力されたメールアドレスを取得する
            String get_user_mail = user_mail.getText().toString();
            //入力された住所を取得する
            String get_user_address = user_address.getText().toString();
            //入力されたパスワードを取得する
            String get_user_passwd = user_passwd.getText().toString();

            //ユーザ情報が書き込まれているか
            if (!get_user_name.equals("") && !get_user_mail.equals("") && !get_user_passwd.equals("")) {
                //ユーザ名とメールアドレスとパスワードがnullじゃなかった時
                //データベースに登録する処理を書く
                startActivity(register_ok);
            } else {
                //ユーザ名とメールアドレスとパスワードの一つでもnullだったらエラー画面
                //エラー文を表示させる文を書く
                startActivity(error);
            }
        }
    }
}
