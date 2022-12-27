//山﨑里沙,2022/12/27
//家族のユーザ検索の結果を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilySearch2 extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_mail;
    Button user_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family2);

        //メールアドレス
        family_mail = (EditText) findViewById(R.id.editTextTextPersonName4);

        //user_button = (Button)findViewById(R.id.button23);
        findViewById(R.id.button21).setOnClickListener(this);//検索ボタン
        findViewById(R.id.button23).setOnClickListener(this);//ユーザボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        int user_id;
        //画面遷移用
        Intent register_family = new Intent(this, RegisterFamilyName.class);
        Intent error = new Intent(this, SignUp.class);//後で変更
        Intent check = new Intent(this, RegisterFamilyCheck.class);

        if (v.getId() == R.id.button21) {
            //入力されたメールアドレスを取得する
            String get_family_mail = family_mail.getText().toString();
            //一致するデータがDBにあるか検索(ユーザIDとユーザ名が返ってくる)
            user_id = 111;
            if (user_id == 0){
                startActivity(error);
            } else {
                user_button =new Button(this);
                user_button.setText(user_id);
            }
            //家族登録画面へ遷移
            //startActivity(register_family);
        } else if (v.getId() == R.id.button23) {
            startActivity(check);
        }
    }
}
