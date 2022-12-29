//山﨑里沙,2022/12/29
//家族登録の完了画面プログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilyFin extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familyfin);

        findViewById(R.id.button22).setOnClickListener(this);//戻るボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent fin = new Intent(this, Account.class);

        if (v.getId() == R.id.button22) {
            //ユーザ検索画面へ遷移
            startActivity(fin);
        }
    }
}
