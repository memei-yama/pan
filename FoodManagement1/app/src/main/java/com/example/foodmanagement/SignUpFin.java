//山﨑里沙,2022/12/22
//新規登録完了画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpFin extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_fin);

        findViewById(R.id.button43).setOnClickListener(this);//戻るボタン
    }
    //ボタンを押下したらログイン画面に遷移する
    @Override
    public void onClick(View v) {
        Intent fin = new Intent(this, LoginAccount.class);

        if (v.getId() == R.id.button43) {
            startActivity(fin);
        }
    }
}
