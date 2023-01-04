//山﨑里沙,2022/12/22
//ユーザ検索でユーザが見つからなかった時のエラー画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilyError extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family_error);

        findViewById(R.id.button42).setOnClickListener(this);//戻るボタン
    }
    //ボタンを押下したらユーザ検索に遷移する
    @Override
    public void onClick(View v) {
        Intent fin = new Intent(this, RegisterFamilySearch.class);

        if (v.getId() == R.id.button42) {
            startActivity(fin);
        }
    }
}
