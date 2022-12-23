//山﨑里沙,2022/12/23
//ユーザの初期画面のプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account);

        findViewById(R.id.button10).setOnClickListener(this);//アカウント更新ボタン
        findViewById(R.id.button9).setOnClickListener(this);//家族ボタン
        findViewById(R.id.button8).setOnClickListener(this);//フレンドボタン
        findViewById(R.id.button7).setOnClickListener(this);//アカウント削除ボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent update_user = new Intent(this, UpdateUser.class);
        Intent family = new Intent(this, SignUp.class);//後から変更
        Intent friend = new Intent(this, LoginAccount.class);//後から変更
        Intent delete_user = new Intent(this, DeleteAccount.class);

        if (v.getId() == R.id.button10) {
            //アカウント更新画面へ遷移
            startActivity(update_user);
        } else if (v.getId() == R.id.button9) {
            //家族メニュー画面へ遷移
            //今は新規登録画面
            startActivity(family);
        } else if (v.getId() == R.id.button8) {
            //フレンドメニュー画面へ遷移
            //今はログイン画面
            startActivity(friend);
        } else if (v.getId() == R.id.button7) {
            //アカウント削除画面へ遷移
            startActivity(delete_user);
        }
    }
}
