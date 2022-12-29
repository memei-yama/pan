//山﨑里沙,2022/12/22
//ログインをするプログラム
package com.example.foodmanagement;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginAccount extends AppCompatActivity implements View.OnClickListener{
    //変数の定義
    private EditText user_mail;
    private EditText user_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginaccount);

        //メールアドレス
        user_mail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        //パスワード
        user_passwd = (EditText) findViewById(R.id.editTextTextPassword2);

        findViewById(R.id.button5).setOnClickListener(this);//戻るボタン
        findViewById(R.id.button6).setOnClickListener(this);//ログインボタン

    }

    //ボタンを押下したら初期画面かホームに遷移する
    @Override
    public void onClick(View v) {
        //変数の定義
        //DBにあるかどうかを判断する
        boolean correct;
        //画面遷移用
        Intent cancel = new Intent(this, MainActivity.class);
        Intent login = new Intent(this, Home.class);
        Intent error_null = new Intent(this, SignUp.class);//後から変更
        Intent error_false = new Intent(this, News.class);//後から変更

        //戻るボタンを押下したら初期画面に遷移
        if (v.getId() == R.id.button5) {
            startActivity(cancel);
        } else if (v.getId() == R.id.button6) {
            //入力されたメールアドレスを取得する
            String get_user_mail = user_mail.getText().toString();
            //入力されたパスワードを取得する
            String get_user_passwd = user_passwd.getText().toString();

            //メールアドレスとパスワードがDBにあるか検索する
            String url = "http://appserver/userLogin?user_id=get_user_mail,user_passwd=get_user_passwd";
            correct = true;//後から変更

            if (get_user_mail.equals("") || get_user_passwd.equals("")){
                //メールアドレスまたはパスワードがnullだったときLoginErrorNull.javaに遷移
                //今は新規登録画面に遷移
                startActivity(error_null);
            } else if (correct == false) {
                //DBに登録されていないときLoginErrorFalse.javaに遷移
                //今はNews.javaにしている
                startActivity(error_false);
            } else {
                //ログイン成功のときホーム画面に遷移
                startActivity(login);
            }
        }
    }
}
