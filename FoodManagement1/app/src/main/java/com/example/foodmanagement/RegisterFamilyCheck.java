//山﨑里沙,2022/12/29
//追加する家族ユーザの確認プログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilyCheck extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    TextView view_user_mail;
    TextView view_user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familycheck);

        findViewById(R.id.button24).setOnClickListener(this);//キャンセルボタン
        findViewById(R.id.button25).setOnClickListener(this);//申請ボタン

        //ユーザ名とユーザIDを表示するテキストのIDを取得する
        view_user_mail = findViewById(R.id.textView10);
        view_user_name = findViewById(R.id.textView5);
        //RegisterFamilySearch2からユーザIDとユーザ名を受け取る
        Intent user_mail = getIntent();
        Intent user_name = getIntent();
        String get_user_mail = user_mail.getStringExtra("user_mail");
        String get_user_name = user_name.getStringExtra("user_name");
        //受け取ったユーザIDとユーザ名を挿入する
        view_user_mail.setText(get_user_mail);
        view_user_name.setText(get_user_name);
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent next = new Intent(this, RegisterFamilyFin.class);
        Intent cancel = new Intent(this, RegisterFamilySearch.class);

        if (v.getId() == R.id.button24) {
            //ユーザ検索画面へ遷移
            startActivity(cancel);
        } else if (v.getId() == R.id.button25) {
            //登録完了画面へ遷移
            startActivity(next);
        }
    }
}
